package com.fen.dou.stu.test;

import com.fen.dou.stu.util.ZKUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;

public class NodeCacheTest {
    public static void main(String[] args) throws Exception {
        ZKUtils  zkUtils = ZKUtils.getInstance();
        CuratorFramework client = zkUtils.getClient();
        String path = "/app";
        final NodeCache nodeCache = new NodeCache(client,path);
        nodeCache.start();
        nodeCache.getListenable().addListener(new NodeCacheListener() {
            @Override
            public void nodeChanged() throws Exception {
                System.out.println("监听事件触发");
                System.out.println("重新获得节点内容为：" + new String(nodeCache.getCurrentData().getData()));
            }
        });
//        client.setData().forPath(path,"456".getBytes());
//        client.setData().forPath(path,"789".getBytes());
//        client.setData().forPath(path,"123".getBytes());
//        client.setData().forPath(path,"222".getBytes());
//        client.setData().forPath(path,"333".getBytes());
//        client.setData().forPath(path,"444".getBytes());
        Thread.sleep(Integer.MAX_VALUE);

    }
}
