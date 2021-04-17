package com.fen.fou;

import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class ConcurrentSkipListMapTest {
    public static void main(String[] args) {
        ConcurrentSkipListMap concurrentSkipListMap = new ConcurrentSkipListMap();

        concurrentSkipListMap.put("a","a");
        concurrentSkipListMap.put("b","b");
        concurrentSkipListMap.put("c","c");
        concurrentSkipListMap.put("d","d");
        concurrentSkipListMap.put("e","e");

     //   concurrentSkipListMap.

        ConcurrentSkipListSet concurrentSkipListSet = new ConcurrentSkipListSet();
        concurrentSkipListSet.add("a");
        concurrentSkipListSet.add("b");
        concurrentSkipListSet.add("c");
        concurrentSkipListSet.add("d");
        concurrentSkipListSet.add("e");
    }
}
