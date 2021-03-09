package com.fen.dou.stu.test;

import com.fen.dou.stu.util.NetUtils;
import com.fen.dou.stu.util.RocketMQProducer;
import com.fen.dou.stu.util.ZKUtils;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ZkTest {
    public static void main(String[] args) throws Exception {
        RocketMQProducer.INSTANCE.getInstance().init("172.21.1.177",
                "run_logger");
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
        NioEventLoopGroup workerGroup = new NioEventLoopGroup(2);
        ServerBootstrap serverBoot = new ServerBootstrap();
        serverBoot.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                .childHandler(new ExecutorServerInitializer())
                .option(ChannelOption.SO_BACKLOG, 512)
                .option(ChannelOption.TCP_NODELAY, true)
                .childOption(ChannelOption.SO_KEEPALIVE, true);
        serverBoot.bind(NetUtils.getLocalAddressByNetworkInterface().getHostName(), 1021).sync();

        ZKUtils  zkUtils = ZKUtils.getInstance();

        new TaskWatcherListener("/app");

        while (true){
            Thread.sleep(2000);
            System.out.println("----------");
        }
    }
}
