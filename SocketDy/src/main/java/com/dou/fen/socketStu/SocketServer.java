package com.dou.fen.socketStu;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) throws IOException, IOException {
        //创建服务接口
        ServerSocket ss = new ServerSocket(8899);
        //接收请求
        Socket s = ss.accept();
        //调用服务端业务逻辑
        String result = new Person().sayHello();
        //获得输出流
        OutputStream out = s.getOutputStream();
        //发送数据
        out.write(result.getBytes());
        //关闭资源
        out.close();
        s.close();
        ss.close();

    }
}
