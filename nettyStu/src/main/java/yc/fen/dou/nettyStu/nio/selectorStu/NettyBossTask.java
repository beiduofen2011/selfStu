package yc.fen.dou.nettyStu.nio.selectorStu;

import lombok.SneakyThrows;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executors;

public class NettyBossTask implements Runnable {
    ServerSocketChannel serverSocket = null;
    Selector selector  = Selector.open();;
    NettyBossTask(ServerSocketChannel serverSocket) throws IOException {
        this.serverSocket = serverSocket;
    }
    public Selector getSelector(){
        System.out.println( this.selector+"-----boss------");
        return this.selector;
    }
    @Override
    public void run() {
        try {
            // 把ServerSocketChannel注册到selector上，并且selector对客户端accept连接操作感兴
            serverSocket.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("服务启动成功---boss------");
            while (true) {
                // 阻塞等待需要处理的事件发生
                selector.select();
                // 获取selector中注册的全部事件的 SelectionKey 实例
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                System.out.println("----------select事件数------------boss-------"+ selectionKeys.size());
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                // 遍历SelectionKey对事件进行处理
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    // 如果是OP_ACCEPT事件，则进行连接获取和事件注册
                    if (key.isAcceptable()) {
                        ServerSocketChannel server = (ServerSocketChannel) key.channel();
                        SocketChannel socketChannel = server.accept();
                        Executors.newSingleThreadExecutor().execute(new Runnable() {
                            @SneakyThrows
                            @Override
                            public void run() {
                                socketChannel.configureBlocking(false);
                                // 这里只注册了读事件，如果需要给客户端发送数据可以注册写事件
                                Selector workselector =  NettyWorkTaskGroup.workGroup.get(0).getSelector();
                                System.out.println("获取---workselector------"+workselector);
                                socketChannel.register(workselector, SelectionKey.OP_READ);
                            }
                        });
                        System.out.println("客户端连接成功---boss------");
                        //从事件集合里删除本次处理的key，防止下次select重复处理
                        iterator.remove();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
