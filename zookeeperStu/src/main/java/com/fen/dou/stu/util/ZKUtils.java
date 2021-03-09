package com.fen.dou.stu.util;


import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.framework.recipes.cache.TreeCache;
import org.apache.curator.framework.recipes.cache.TreeCacheListener;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

import java.util.List;

/**
 * zk操作类
 * Created by 落叶 on 2018/1/30.
 */
@Slf4j
public class ZKUtils {


    private static String zkConnectStr = "";

    public static String getZkConnectStr() {
        return zkConnectStr;
    }

    private static void setZkConnectStr(String zkConnectStr) {
        ZKUtils.zkConnectStr = zkConnectStr;
    }

    private static boolean isChanged = true;

    private static ZKUtils ourInstance = new ZKUtils();

    private static CuratorFramework client = null;

    public static ZKUtils getInstance() {

        CuratorFrameworkFactory.Builder builder = CuratorFrameworkFactory.builder().connectString("localhost:2181");
        builder.sessionTimeoutMs(5000);
        builder.connectionTimeoutMs(3000);
        builder.retryPolicy(new RetryNTimes(5, 1000));
        client = builder.build();
        client.start();
        // 没有修改
        isChanged = false;

        return ourInstance;
    }

    public static void setIsChanged(boolean isChanged) {
        ZKUtils.isChanged = isChanged;
    }

    private ZKUtils() {
    }

    /**
     * 创建节点
     *
     * @param path
     */
    public void createNode(String path) {
        try {
            if (checkNodesExists(path)) {
                client.create().creatingParentsIfNeeded().forPath(path);
            }
        } catch (Exception e) {
            log.error("create path:{} failed , message : {}", path, e.getMessage());
        }
    }

    /**
     * 创建数据
     *
     * @param path
     * @param data
     */
    public void createNodeData(String path, String data) {
        try {
            if (checkNodesExists(path)) {
                createNode(path);
            }
            client.setData().forPath(path, data.getBytes(Constants.DEFAULT_CHARSET));
        } catch (Exception e) {
            log.error("create data:{}/{} failed , message : {}", path, data, e.getMessage());
        }
    }

    /**
     * 创建node和数据
     *
     * @param path
     * @param data
     */
    public void createNodeAndData(String path, String data) {
        try {
            client.create().creatingParentsIfNeeded().forPath(path, data.getBytes(Constants.DEFAULT_CHARSET));
        } catch (Exception e) {
            log.error("create node and data:{}/{} failed , message : {}", path, data, e.getMessage());
        }
    }

    /**
     * 创建node和数据
     *
     * @param path
     * @param data
     */
    public void createNodeAndByteData(String path, byte[] data) {
        try {
            client.create().creatingParentsIfNeeded().forPath(path, data);
        } catch (Exception e) {
            log.error("create node and data:{}/{} failed , message : {}", path, data, e.getMessage());
        }
    }

    /**
     * 创建临时节点
     *
     * @param path
     * @param data
     */
    public void createTempNode(String path, String data) {
        try {
            if (checkNodesExists(path)) {
                client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL_SEQUENTIAL)
                        .forPath(path, data.getBytes(Constants.DEFAULT_CHARSET));
            }
        } catch (Exception e) {
            log.error("create tmp path:{} failed , message : {}", path, e.getMessage());
        }
    }

    /**
     * 创建临时节点和数据
     *
     * @param path
     * @param data
     */
    public void createTempNodeAndData(String path, byte[] data) {
        try {
            client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL)
                    .forPath(path, data);
        } catch (Exception e) {
            log.error("create tmp path:{} failed , message : {}", path, e.getMessage());
        }
    }

    /**
     * 检查节点是否存在, true 不存在，false 存在
     *
     * @param path
     * @return
     */
    public boolean checkNodesExists(String path) {
        try {
            Stat stat = client.checkExists().forPath(path);
            return stat == null;
        } catch (Exception e) {
            log.error("check path:{} failed , message : {}", path, e.getMessage());
            return false;
        }
    }

    public String getData(String path) {
        try {
            return new String(client.getData().forPath(path), Constants.DEFAULT_CHARSET);
        } catch (Exception e) {
            log.error("get data for path:{} error,message: {}", path, e.getMessage());
        }
        return null;
    }

    public byte[] getDataBytes(String path) {
        try {
            client.sync().forPath(path);
            return client.getData().forPath(path);
        } catch (Exception e) {
            log.error("get data for path:{} error,message: {}", path, e.getMessage());
        }
        return null;
    }

    public List<String> getChildren(String path) {
        try {
            return client.getChildren().forPath(path);
        } catch (Exception e) {
            log.error("get children data for path:{} error,message: {}", path, e.getMessage());
        }
        return null;
    }

    /**
     * 删除节点信息
     *
     * @param path
     */
    public void deleteNode(String path) {
        try {
            client.delete().forPath(path);
        } catch (Exception e) {
            log.error("get children data for path:{} error,message: {}", path, e.getMessage());
        }
    }

    public void deleteNodeAndChildren(String path) {
        try {
            client.delete().deletingChildrenIfNeeded().forPath(path);
        } catch (Exception e) {
            log.error("get children data for path:{} error,message: {}", path, e.getMessage());
        }
    }

    public TreeCache watcherPath(String path, TreeCacheListener treeCacheListener) {
        TreeCache treeCache = null;
        try {
            treeCache = TreeCache.newBuilder(client, path).setCacheData(true).build();
            treeCache.start();
            treeCache.getListenable().addListener(treeCacheListener);
        } catch (Exception e) {
            log.error("watch all children path:{} , error: {}", path, e.getMessage());
        }
        return treeCache;
    }

    /**
     * 子节点监听
     *
     * @param path
     * @param pathChildrenCacheListener
     * @return
     */
    public PathChildrenCache watchChildrenPath(String path, PathChildrenCacheListener pathChildrenCacheListener) {
        PathChildrenCache childrenCache = null;
        try {
            childrenCache = new PathChildrenCache(client, path, true);
            childrenCache.start(PathChildrenCache.StartMode.POST_INITIALIZED_EVENT);
            childrenCache.getListenable().addListener(pathChildrenCacheListener);
        } catch (Exception e) {
            log.error("watch all children path:{} , error: {}", path, e.getMessage());
        }

        return childrenCache;
    }

    public TreeCache watcherPath(String path, int maxPath, TreeCacheListener treeCacheListener) {
        TreeCache treeCache = null;
        try {
            treeCache = TreeCache.newBuilder(client, path).setCacheData(true).setMaxDepth(maxPath).build();
            treeCache.start();
            treeCache.getListenable().addListener(treeCacheListener);
        } catch (Exception e) {
            log.error("watch all children path:{} , error: {}", path, e.getMessage());
        }
        return treeCache;
    }

    public  CuratorFramework getClient() {
        return client;
    }

}
