package com.example.stu.jvm;

public class TestJavap {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = a + b;
        String name = "yangcai";
        User user = new User();
        user.setAge(c);
        user.setName(name);

        printJb(c);
        printYy(user);
    }

    public static void printJb(int c) {
        int d = c + 1;
        System.out.println(d);
    }

    public static void printYy(User user) {
        user.setName("yc");
        System.out.println(user.getName());
    }
}

