package com.fen.dou.mapTest.zifuchuan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class IntStu {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = " ";
        while((str = br.readLine()) != null){
            String[] s = str.split(" ");
            int m = Integer.parseInt(s[0]);
            int n = Integer.parseInt(s[1]);
            System.out.println(count(m,n));
        }
    }
    public static int count(int m,int n){
        System.out.println("----M----"+m+"--------N------"+n);
        if(n == 1 || m == 0)return 1;
        else if(n > m)return count(m,m);
        else return count(m,n - 1) + count(m - n,n);
    }
}
