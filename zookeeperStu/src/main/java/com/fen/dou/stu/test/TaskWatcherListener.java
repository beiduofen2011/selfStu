package com.fen.dou.stu.test;

import com.fen.dou.stu.util.ZKUtils;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;

public class TaskWatcherListener {

    TaskWatcherListener(String path) throws Exception {

        PathChildrenCache taskWatcherCache = new PathChildrenCache(
                ZKUtils.getInstance().getClient()
                , path, false);
        taskWatcherCache.start(PathChildrenCache.StartMode.POST_INITIALIZED_EVENT);
        taskWatcherCache.getListenable().addListener((client, event) -> {
            if (event.getType() == PathChildrenCacheEvent.Type.INITIALIZED) {
                System.out.println("----------------------INITIALIZED---------------------");
            } else if (event.getType() == PathChildrenCacheEvent.Type.CHILD_ADDED) {
                System.out.println("----------------------CHILD_ADDED---------------------");
            } else if (event.getType() == PathChildrenCacheEvent.Type.CHILD_REMOVED) {
                System.out.println("----------------------CHILD_REMOVED---------------------");
            } else if (event.getType() == PathChildrenCacheEvent.Type.CHILD_UPDATED) {
                System.out.println("----------------------CHILD_UPDATED---------------------");
            }
        });
    }
}
