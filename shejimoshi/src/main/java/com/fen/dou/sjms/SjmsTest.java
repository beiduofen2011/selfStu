package com.fen.dou.sjms;

import java.io.*;
import java.util.*;
import java.util.function.Function;

public class SjmsTest implements Comparable{
    public static void main(String[] args) throws IOException {
        List list = Arrays.asList(new int[]{1, 2, 3, 4});
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        list.stream().count();
        BufferedReader br = new BufferedReader(new FileReader("b.txt"));

        BufferedWriter fw = new BufferedWriter(new FileWriter("b.txt"));
        Function<String,String> f1 = x-> x+"aaa";
        Comparator cdd = Comparator.comparing(f1);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
