package com.fen.dou.sjms.sington;


public class LazyshiTest {

    public static void main(String[] args) {
        LazyshiSington lazyshiSington1 = LazyshiSington.getInstance();
        LazyshiSington lazyshiSington2 = LazyshiSington.getInstance();
        System.out.println(lazyshiSington1);
        System.out.println(lazyshiSington2);
        System.out.println(lazyshiSington1 == lazyshiSington2);
    }
}
class LazyshiSington{
    private volatile  static LazyshiSington lazyshiSington = null;
    private LazyshiSington(){
        if(lazyshiSington != null){
            throw new RuntimeException("已经存在对象");
        }
    }
    public static LazyshiSington getInstance(){
        if(lazyshiSington == null){
            synchronized(LazyshiSington.class){
                if(lazyshiSington == null){
                    lazyshiSington  = new  LazyshiSington();
                }
            }
        }
        return lazyshiSington;
    }
}
