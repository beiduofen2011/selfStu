package com.fen.dou.classLoadStu;

public class CurrentThreadCloaderTest {
    public static void main(String[] args) throws ClassNotFoundException {
 //       Class my =  Thread.currentThread().getClass().getClassLoader().loadClass("com.fen.dou.classLoadStu.User");
          System.out.println( Thread.currentThread().getClass().getClassLoader());
    }
}
