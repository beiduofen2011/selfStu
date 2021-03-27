package com.fen.dou.aqsStu.hashMapTest;

import lombok.SneakyThrows;
import sun.misc.Unsafe;

import java.util.UUID;
import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        int tableLen = 16;
        int sr = Integer.numberOfLeadingZeros(tableLen) | (1 << (16 - 1));
        System.out.println(sr);
        System.out.println(Integer.toBinaryString(sr));


        int sizectrl = (sr << (32-16)) + 2;
        System.out.println(sizectrl);
        System.out.println(Integer.toBinaryString(sizectrl));
        String key = "fbf30d3b-88a9-4f5d-b663-f78f28d24dec";
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("a","a");
        map.put("b","b");
        map.put("c","c");
        map.put("d","d");
        map.put("e","e");
        map.put("f","f");
        map.put("g","g");
        map.put("h","h");
        map.put("i","i");
        map.put("o","o");
        map.put("p","p");
        map.put("q","q");
        map.put("r","r");
        map.put("s","s");
        map.put("q","q");

        Callable callable = new Callable() {
            @Override
            public Object call() throws Exception {

                for (int i = 0; i < 500000; i++) {
                    map.put(jisuankey(), UUID.randomUUID().toString());
                }
                return map;
            }

            public String jisuankey() throws InterruptedException {
                return UUID.randomUUID().toString();
            }
        };
        for (int i = 0; i < 10; i++) {
            Executors.newCachedThreadPool().submit(new FutureTask<ConcurrentHashMap>(callable) {
                @SneakyThrows
                @Override
                protected void done() {
                    ConcurrentHashMap map1 = this.get();
                    System.out.println(map1.size());
                }
            });
        }


//        int index = (111111111 ^ (111111111 >>> 16)) & 0x7fffffff;
//        System.out.println(index);
    }
}
