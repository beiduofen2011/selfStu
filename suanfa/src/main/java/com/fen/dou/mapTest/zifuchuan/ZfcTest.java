package com.fen.dou.mapTest.zifuchuan;

import java.util.Scanner;

public class ZfcTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] stra = str.split(" ");
       // str.split("\\s+")
        System.out.println(stra[stra.length-1].length());
    }
}
