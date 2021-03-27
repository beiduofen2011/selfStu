package com.fen.dou.aqsStu.hashMapTest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class TestUUid {
    public static void main(String[] args) {
        HashMap<Integer, Set<String>> map = new HashMap<Integer, Set<String>>();
        for(int i=0;i<10000;i++){
            UUID str = UUID.randomUUID();
            int hash = str.toString().hashCode() ^ (str.toString().hashCode() >>> 16);
            int index = hash & 15;
            if(map.get(index) == null){
                Set<String> strings = new HashSet<>();
                strings.add(str.toString());
                map.put(index,strings);
            }else{
                map.get(index).add(str.toString());
            }
        }
        map.forEach((k,v)->{
            if(v.size()>7){
                System.out.println(k+","+v.size()+"|||");
                for(String sr : v){
                    System.out.print(sr+"   ,");
                }
            }
        });


    }
}
