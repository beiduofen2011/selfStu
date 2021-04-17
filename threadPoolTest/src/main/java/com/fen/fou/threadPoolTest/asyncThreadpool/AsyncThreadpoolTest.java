package com.fen.fou.threadPoolTest.asyncThreadpool;

public class AsyncThreadpoolTest {
    public  synchronized  void print1() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("--------print1--------"+Thread.currentThread().getName());
        print2();
    }
    public  synchronized  void print2(){
        System.out.println("--------print2--------"+Thread.currentThread().getName());
    }
    public  void print3()  {
        System.out.println("--------print3--------"+Thread.currentThread().getName());
    }
    public static void main(String[] args) {
        AsyncThreadpoolTest asyncThreadpoolTest = new AsyncThreadpoolTest();
       new Thread(()->{
           try {
               asyncThreadpoolTest.print1();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       },"A").start();
        new Thread(()->{
            asyncThreadpoolTest.print2();
        },"B").start();
        new Thread(()->{
            asyncThreadpoolTest.print3();
        },"C").start();
    }
}
