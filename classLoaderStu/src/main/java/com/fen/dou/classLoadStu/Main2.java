package com.fen.dou.classLoadStu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    volatile User user = new User();

    public User getUser() {
        return user;
    }
    public void mysql() {
        System.out.println(Math.sqrt(180));

        int i = 3;
        new Thread(()->{
            int s = i;
            getUser();
            user = null;
        }).start();
    }
    public static void main(String[] args) throws IOException {



    }
}