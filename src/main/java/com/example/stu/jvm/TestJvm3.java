package com.example.stu.jvm;

import java.util.ArrayList;
import java.util.List;

public class TestJvm3 {
    public static List<User> userList = new ArrayList<>();
    public static String name = "yangcai";
    public static String name1 = "cai"+"yang";
    public static void main(String[] args) {
       String a = "age";
       String b = "name";
       String c = a + b;
       String d = new String("age1");
       String e = new String("name1");
       String f  = d+e;
    }
}
