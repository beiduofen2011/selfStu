package com.fen.dou.stu.util;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

/***
 *                    .::::.
 *                  .::::::::.
 *                 :::::::::::
 *             ..:::::::::::'
 *           '::::::::::::'
 *             .::::::::::
 *        '::::::::::::::..
 *             ..::::::::::::.
 *           ``::::::::::::::::
 *            ::::``:::::::::'        .:::.
 *           ::::'   ':::::'       .::::::::.
 *         .::::'      ::::     .:::::::'::::.
 *        .:::'       :::::  .:::::::::' ':::::.
 *       .::'        :::::.:::::::::'      ':::::.
 *      .::'         ::::::::::::::'         ``::::.
 *  ...:::           ::::::::::::'              ``::.
 * ```` ':.          ':::::::::'                  ::::..
 *                    '.:::::'                    ':'````..
 */

public class ChildrenPathListener implements PathChildrenCacheListener {

    private Logger log = LoggerFactory.getLogger(ChildrenPathListener.class);
    private CountDownLatch countDownLatch;
    private ZKUtils zkUtils;

    public ChildrenPathListener(ZKUtils zkUtils,CountDownLatch countDownLatch) {
        this.zkUtils=zkUtils;
        this.countDownLatch=countDownLatch;
    }

    @Override
    public void childEvent(CuratorFramework client, PathChildrenCacheEvent event) throws Exception {
        switch (event.getType()){
            case CHILD_ADDED:
                log.info("添加子节点路径:" + event.getData().getPath());
                ChildData childData = event.getData();
                return;
            default:
                log.info("ChildrenPathListener childEvent other event type: {}", event.getType());
        }
    }

}
