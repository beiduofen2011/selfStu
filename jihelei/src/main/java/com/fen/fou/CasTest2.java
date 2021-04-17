package com.fen.fou;

import org.springframework.objenesis.instantiator.util.UnsafeUtils;
import sun.misc.Unsafe;

public class CasTest2 {
    static CasTestObjecy t = new CasTestObjecy();
    static   int i = 0;
    public static void main(String[] args) throws NoSuchFieldException{
        Unsafe u = UnsafeUtils.getUnsafe();

        long b1 = u.objectFieldOffset(CasTestObjecy.class.getDeclaredField("value"));
        new Thread(()->{

            while (true){
                if(i == 1){
                    System.out.println(Thread.currentThread().getName() + "-------------------c----------------");
                    break;
                }

            }
        },"C").start();
        new Thread(()->{
              int a;boolean flag;

              while (true){
                  u.compareAndSwapInt(t, b1,6,1);
                  if(i == 1){
                      System.out.println(Thread.currentThread().getName() + "-------------------a----------------");
                      break;
                  }

              }
        },"A").start();

        new Thread(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i=1;
            u.compareAndSwapInt(t, b1,0,5);
         },"B").start();
    }
}
