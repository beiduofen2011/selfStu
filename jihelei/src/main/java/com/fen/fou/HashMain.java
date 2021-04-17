package com.fen.fou;

public class HashMain {
    public static void main(String[] args) {
        System.out.println(((180 & (2-1)) + "======"  + (180 & (2))));
        System.out.println((180 & (4-1))  + "======"  + (180 & (4)));
        System.out.println((180 & (8-1))  + "======"  + (180 & (8)));
        System.out.println((180 & (16-1)) + "======"  + (180 & (16)));
        System.out.println((180 & (32-1)) + "======"  + (180 & (32)));
        System.out.println((180 & (64-1)) + "======"  + (180 & (64)));
        System.out.println((180 & (128-1))+ "======"  + (180 & (128)));
        System.out.println((180 & (256-1))+ "======"  + (180 & (256)));

       // key.hash & (newlen - 1) =  key.hash & oldlen + (key.hash & oldlen -1)
        long sss = 1024 * 1024 * 1024 ;
        System.out.println(1L<<10);
        System.out.println(1L<<10);
        System.out.println(1L<<44);
    }
}
