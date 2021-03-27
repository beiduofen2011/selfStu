package com.fen.dou.mapTest.zifuchuan;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TreeSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String a = scanner.nextLine();
            Matcher m = Pattern.compile(".{0,8}").matcher(a);
            String s1 = "";
            do {
                s1 = m.find() ? a.substring(m.start(), m.end()) : "";
                if(s1.length() > 0){
                    if (s1.length() < 8) {
                        StringBuilder str = new StringBuilder(s1);
                        while (str.length() < 8) {
                            str.append("0");
                        }
                        System.out.println(str.toString());
                    } else{
                        System.out.println(s1.toString());
                    }
                }
            } while (s1 != "");
        }
    }
}
