package com.fen.dou.aqsStu.hashMapTest;

import java.util.Stack;

public class ToTwojinzhi {
    public  static Stack<Integer>  stack = new Stack<Integer>();
    public static void main(String[] args) {

        StringBuffer stringBuffer = new StringBuffer();
        String key = "fbf30d3b-88a9-4f5d-b663-f78f28d24dec";
        System.out.println(key.hashCode());
        System.out.println(key.hashCode() >>> 16);
        toTwo(380285627);
        int ca = stack.size();
        if(ca < 32){
            int chayi = 32 - ca;
            for(int j = 0;j<chayi;j++){
                stringBuffer.append("0");
            }
        }
        for(int i=0 ; i<ca ;i++){
            stringBuffer.append(stack.pop());
        }
        System.out.println(stringBuffer.toString());
    }
    public static void toTwo(int a){
        int b = a%2;
        stack.push(b);
        if(a >=2){
            a = a/2;
            toTwo(a);
        }
    }
}
