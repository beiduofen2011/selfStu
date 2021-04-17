package com.fen.fou;

public class CasTest3 {
    static CasTestObjecy t = new CasTestObjecy();
    static Object obj = new Object();
    public static void main(String[] args) {
        new Thread(()->{
              int a;boolean flag;
              while (flag = (( a =  t.getValue() ) != 5)) {
                  synchronized (obj){

                  }
              };
            System.out.println(Thread.currentThread().getName() + "-----------------------------------"+a);
            System.out.println(Thread.currentThread().getName() + "-----------------------------------"+flag);

        },"A").start();

        new Thread(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t.setValue(5); ;
        },"B").start();

    }
}
