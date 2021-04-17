package yc.fen.dou.nettyStu.nio.selectorStu;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NettyWorkTask implements Runnable {
    ServerSocketChannel serverSocket = null;
    Selector selector =  Selector.open();
    NettyWorkTask(ServerSocketChannel serverSocket) throws IOException {
        this.serverSocket = serverSocket;
    }
    public Selector getSelector(){
        System.out.println( this.selector+"-----work------");
        return this.selector;
    }
    @Override
    public void run() {
        try {
            System.out.println("---------1---------------work------");
            // 把ServerSocketChannel注册到selector上
        //    serverSocket.register(selector,0);
            System.out.println("服务启动成功----work------");
            while (true) {
                System.out.println("-----------2--------------work-------");
                // 阻塞等待需要处理的事件发生
                selector.select(500);
                // 获取selector中注册的全部事件的 SelectionKey 实例
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                System.out.println("----------select事件数-------------work-------"+ selectionKeys.size());
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                // 遍历SelectionKey对事件进行处理
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    // 如果是OP_ACCEPT事件，则进行连接获取和事件注册
                    if (key.isReadable()) {
                        // 如果是OP_READ事件，则进行读取和打印
                        SocketChannel socketChannel = (SocketChannel) key.channel();
                        System.out.println("----------从客户端读数据------------work--------"+ socketChannel.getRemoteAddress());
                        ByteBuffer byteBuffer = ByteBuffer.allocate(128);
                        int len = socketChannel.read(byteBuffer);
                        // 如果有数据，把数据打印出来
                        if (len > 0) {
                            System.out.println("接收到消息----work------：" + new String(byteBuffer.array()));
                        } else if (len == Integer.parseInt("-1")) {
                            // 如果客户端断开连接，关闭Socket
                            System.out.println("客户端断开连接----work------");
                            socketChannel.close();
                        }
                        //从事件集合里删除本次处理的key，防止下次select重复处理
                        iterator.remove();
//                         socketChannel.register(selector, SelectionKey.OP_WRITE);
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
