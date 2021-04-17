package yc.fen.dou.nettyStu.nio.selectorStu;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class NioSelectorClient {

    public static void main(String[] args) {
        try{
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress("localhost",10010));//服务端就是bind  然后accept  serverSocketChannel

            Selector selector = Selector.open();

            socketChannel.register(selector, SelectionKey.OP_CONNECT);//注册连接事件

            while(true) {
                int number = selector.select();

                if(number > 0) {
                    Set<SelectionKey> selectionKeySet =  selector.selectedKeys();

                    Iterator<SelectionKey> iterable = selectionKeySet.iterator();
                    while(iterable.hasNext()) {//有事件发生
                        SelectionKey selectionKey = iterable.next();

                        SocketChannel client = (SocketChannel) selectionKey.channel();
                        if(selectionKey.isConnectable()) {//判断 selectionkey 状态  可连接的
                            if(client.isConnectionPending()) {//是否在准备连接的进程中
                                client.finishConnect();//这里会阻塞，如果连接未建立，抛异常 ，
                                System.out.println("连接是否成功：" + client.finishConnect());
                                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

                                byteBuffer.put((LocalDateTime.now() + "，连接成功").getBytes());
                                byteBuffer.flip();
                                client.write(byteBuffer);

//                                ExecutorService executorService = Executors.newSingleThreadExecutor(Executors.defaultThreadFactory());
//
//                                executorService.submit(() -> {//起一个新的线程，去接收控制台的输入 ，不影响其他线程
//                                    while(true) {
//                                        try{
//                                            byteBuffer.clear();
//                                            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
//                                            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//
//                                            byteBuffer.put(bufferedReader.readLine().getBytes());
//                                            byteBuffer.flip();
//                                            client.write(byteBuffer);
//
//                                        }catch (Exception e) {
//                                            e.printStackTrace();
//                                        }
//                                    }
//                                });
                            }

                            iterable.remove();//这个事件清楚，很关键
                            client.register(selector, SelectionKey.OP_READ);//注册读事件
                        } else if(selectionKey.isReadable()){//可读取
                            SocketChannel socketChannel1 = (SocketChannel) selectionKey.channel();
                            ByteBuffer readBuffer = ByteBuffer.allocate(1024);

                            int readCount = socketChannel.read(readBuffer);
                            if(readCount > 0) {
                                String receiveMsg = new String(readBuffer.array());
                                System.out.println("receiveMsg : " + receiveMsg);
                            }

                            iterable.remove();
                        }

                    }
                }
            }

        }catch (Exception e ) {
            e.printStackTrace();
        }


    }
}