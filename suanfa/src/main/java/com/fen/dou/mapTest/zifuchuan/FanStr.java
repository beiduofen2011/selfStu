package com.fen.dou.mapTest.zifuchuan;

import java.util.Scanner;

public class FanStr {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String as = in.nextLine();

        for (int i=as.length()-1;i>=0;i--){
            if(i==as.length()-1){
                System.out.print(as.substring(i));
            }else{
                System.out.print(as.substring(i,i+1));
            }
        }
    }
}
