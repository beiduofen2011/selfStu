package com.fen.dou.mapTest.zifuchuan;

import java.util.Scanner;

public class My16To10
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String s = in.nextLine();
            s = s.substring(2);
            long sss = Long.parseLong(s,16);
            System.out.println(sss);
        }
    }
}
