package com.fen.dou.stu.test;

import com.fen.dou.stu.util.ZKUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.api.CuratorListener;

public class CuratorListenerTest {
    public static void main(String[] args) {
        ZKUtils  zkUtils = ZKUtils.getInstance();
        CuratorFramework client = zkUtils.getClient();
        String path = "/app";
        try {
            CuratorListener listener = new CuratorListener() {
                @Override
                public void eventReceived(CuratorFramework client, CuratorEvent event) throws Exception {
                    System.out.println("监听事件触发，event内容为：" + event);
                }
            };
            client.getCuratorListenable().addListener(listener);
//            // 异步获取节点数据
//            client.getData().inBackground().forPath(path);
//            // 变更节点内容
//            client.setData().forPath(path,"123".getBytes());
            Thread.sleep(Integer.MAX_VALUE);
        } catch (Exception e) {
            e.printStackTrace();
            client.close();
        } finally {
            client.close();
        }
    }

}
