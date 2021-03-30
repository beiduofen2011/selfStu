package com.fen.dou.aqsStu.volatitleStu;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Test {
  //  static   ConcurrentHashMap map = new ConcurrentHashMap();
    static   HashMap map = new HashMap();
   // static volatile  HashMap map = new HashMap();
    public static void main(String[] args) {

        new Thread(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put("a","a");
        },"A").start();


        new Thread(()->{
            while (true){
                String ssss = (String) map.get("a");
                if(ssss != null){
                    System.out.println("-----------------------"+Thread.currentThread().getName());
                    break;
                }

            }
        },"B").start();


        new Thread(()->{

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (true){
                String ssss = (String) map.get("a");
                if(ssss != null){
                    System.out.println("-----------------------"+Thread.currentThread().getName());
                    break;
                }

            }
        },"C").start();
    }
}
