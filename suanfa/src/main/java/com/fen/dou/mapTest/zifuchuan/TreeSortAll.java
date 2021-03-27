package com.fen.dou.mapTest.zifuchuan;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class TreeSortAll {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        TreeSet<Integer> set=new TreeSet<Integer>(new Comparator<Integer>(){
            public int compare(Integer o1,Integer o2){
                return o1-o2;
            }
        });

        while(scan.hasNext()) {
            int num=scan.nextInt();

            for(int i=0;i<num;i++){
                set.add(scan.nextInt());
            }
        }
        Iterator<Integer> it=set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
