package yc.fen.dou.nettyStu.nio.selectorStu;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class NioSelectorServerNetty {
    public static void main(String[] args) throws IOException, InterruptedException {
        // 创建NIO ServerSocketChannel
         ServerSocketChannel serverSocket = ServerSocketChannel.open();
         serverSocket.socket().bind(new InetSocketAddress(9000));
         // 设置ServerSocketChannel为非阻塞
         serverSocket.configureBlocking(false);
         // 打开Selector处理Channel，即创建epoll
        System.out.println("----------------------");
        NettyBossTask nettyBossTask = new NettyBossTask(serverSocket);
        NettyWorkTask nettyWorkTask = new NettyWorkTask(serverSocket);
//        NettyWorkTask nettyWorkTask1 = new NettyWorkTask(serverSocket);
//        NettyWorkTask nettyWorkTask2 = new NettyWorkTask(serverSocket);

        NettyWorkTaskGroup.workGroup.add(nettyWorkTask);
//        NettyWorkTaskGroup.workGroup.add(nettyWorkTask1);
//        NettyWorkTaskGroup.workGroup.add(nettyWorkTask2);
        Thread workT = new Thread(nettyWorkTask);
        workT.start();

        Thread bossT = new Thread(nettyBossTask);
        bossT.start();


    }
}