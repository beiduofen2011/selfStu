package com.fen.dou.stu.util;


import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
//import org.apache.curator.framework.recipes.locks.InterProcessReadWriteLock;
import org.apache.curator.framework.recipes.locks.InterProcessReadWriteLock;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

import java.util.List;

/**
 * Created by 落叶 on 2019/9/23.
 */
public enum ZkCommon {
  INSTANCE;

  private ZKUtils zkUtils;

  ZkCommon(){
    zkUtils = new ZKUtils();
  }

  public ZKUtils getInstance(){
    return zkUtils;
  }


  public class ZKUtils{

    private CuratorFramework client;

    public void setZkConnection(String zkConnection) {
      client= CuratorFrameworkFactory.newClient(zkConnection,5000,3000,
              new RetryNTimes(5, 1000));
      client.start();
    }


    public void createNodeAndData(String path, byte[] data, boolean overwrite) throws Exception {
      Stat stat = client.checkExists().forPath(path);
      if (stat != null) {
        if (overwrite) {
          client.delete().deletingChildrenIfNeeded().forPath(path);
          client.create().creatingParentsIfNeeded().forPath(path, data);
        }
      } else {
        client.create().creatingParentsIfNeeded().forPath(path, data);
      }
    }

    public  byte[] getData(String path) throws Exception {
      return client.getData().forPath(path);
    }

    public void createTempNode(String path,byte[] data) throws Exception {
      client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).forPath(path, data);
    }

    public boolean nodeExist(String path) throws Exception{
      return client.checkExists().forPath(path) == null;
    }

    public void updateData(String path, byte[] data) throws Exception {
      Stat stat = new Stat();
      client.getData().storingStatIn(stat).forPath(path);
      client.setData().withVersion(stat.getVersion()).forPath(path, data);
    }

    /**
     * 查找子节点
     * @param path
     * @return
     * @throws Exception
     */
    public List<String> getChildNodes(String path) throws Exception {
      List<String> paths  = client.getChildren().forPath(path);
      return paths;
    }

    public CuratorFramework getClient(){
      return client;
    }

    public void close(){
      if(client != null){
        client.close();
      }
    }
    public InterProcessReadWriteLock getLock(String  rootPath){
      InterProcessReadWriteLock lock = new InterProcessReadWriteLock(client,rootPath);
      return lock;
    }
  }
}
