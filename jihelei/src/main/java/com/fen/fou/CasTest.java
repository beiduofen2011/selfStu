package com.fen.fou;

import org.springframework.objenesis.instantiator.util.UnsafeUtils;
import sun.misc.Unsafe;

public class CasTest {
     static CasTestObjecy t = new CasTestObjecy();
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException, InterruptedException {
        Unsafe u = UnsafeUtils.getUnsafe();

        long b1 = u.objectFieldOffset(CasTestObjecy.class.getDeclaredField("value"));

        for(int i=0 ; i< 5000 ; i++){
            new Thread(()->{
                for(int j=0 ;j<100;j++){
                    int count = 0;
                    while (!u.compareAndSwapInt(t, b1,t.getValue(),t.getValue()+1)){
                        System.out.println(++count);
                    };
                }
            }).start();
        }

        Thread.sleep(10000);
        System.out.println(Thread.currentThread().getName() + t.getValue());
    }
}
