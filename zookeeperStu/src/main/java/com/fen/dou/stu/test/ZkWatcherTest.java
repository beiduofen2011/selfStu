package com.fen.dou.stu.test;

import com.fen.dou.stu.util.ZKUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

public class ZkWatcherTest {

    public static void main(String[] args) {
        ZKUtils  zkUtils = ZKUtils.getInstance();
        CuratorFramework client = zkUtils.getClient();
        String path = "/p1";
        try {
            byte[] content = client.getData().usingWatcher(new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    System.out.println("监听器watchedEvent：" + watchedEvent);
                }
            }).forPath(path);
            System.out.println("监听节点内容：" + new String(content));
            // 第一次变更节点数据
            client.setData().forPath(path,"new content".getBytes());
            // 第二次变更节点数据
            client.setData().forPath(path,"second content".getBytes());
            Thread.sleep(Integer.MAX_VALUE);
        } catch (Exception e) {
            e.printStackTrace();
            client.close();
        } finally {
            client.close();
        }
    }

}
