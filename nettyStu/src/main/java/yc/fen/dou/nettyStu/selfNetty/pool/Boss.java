package yc.fen.dou.nettyStu.selfNetty.pool;

import java.nio.channels.ServerSocketChannel;
/**
 * boss接口
 */
public interface Boss {
	
	/**
	 * 加入一个新的ServerSocket
	 * @param serverChannel
	 */
	public void registerAcceptChannelTask(ServerSocketChannel serverChannel);
}
