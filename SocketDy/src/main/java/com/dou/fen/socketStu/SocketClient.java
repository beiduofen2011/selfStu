package com.dou.fen.socketStu;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class SocketClient {
    public static void main(String[] args) throws Exception {
        //创建socket 写入服务端IP地址 以及服务对应端口号
        Socket s = new Socket("127.0.0.1", 8899);
        //获得输入流
        InputStream in = s.getInputStream();
        //获得返回值
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line = null;
        //将返回值写入line并打印到控制台
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        //关闭
        in.close();
        s.close();
    }
}
