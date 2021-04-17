package yc.fen.dou.nettyStu.selfNetty;


import yc.fen.dou.nettyStu.selfNetty.pool.NioSelectorRunnablePool;

import java.util.concurrent.Executors;

/**
 * 启动主函数
 */
public class Start {

	public static void main(String[] args) {
		//初始化线程
		NioSelectorRunnablePool nioSelectorRunnablePool = new NioSelectorRunnablePool(Executors.newSingleThreadExecutor(), Executors.newSingleThreadExecutor());
		//获取服务类
		ServerBootstrap bootstrap = new ServerBootstrap(nioSelectorRunnablePool);
		//绑定端口
		bootstrap.bind(10010);
		while (true){
			System.out.println("start");
		}
	}
}
