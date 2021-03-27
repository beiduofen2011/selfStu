package com.fen.dou.mapTest.zifuchuan;

import java.util.Scanner;

public class LatStrLength {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String as = in.nextLine().toLowerCase();
        String sss = in.nextLine().toLowerCase();
        System.out.println(as.length() - as.replaceAll(sss,"").length());

    }
}
