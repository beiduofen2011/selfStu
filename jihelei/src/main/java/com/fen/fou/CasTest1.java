//package com.fen.fou;
//
//import org.springframework.objenesis.instantiator.util.UnsafeUtils;
//import sun.misc.Unsafe;
//
//public class CasTest1 {
//    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException, InterruptedException {
//        Unsafe u = UnsafeUtils.getUnsafe();
//        CasTestObjecy t = new CasTestObjecy();
//        long b1 = u.objectFieldOffset(CasTestObjecy.class.getDeclaredField("value"));
//        new Thread(()->{
//                    while (!u.compareAndSwapInt(t, b1,4,5)) {
//                        System.out.println(Thread.currentThread().getName() + "-----------------------------------");
//                    }
//        }).start();
//        Thread.sleep(3000);
//        t.value = 4;
//    }
//}
