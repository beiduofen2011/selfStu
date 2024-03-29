package yc.fen.dou.nettyStu.selfNetty;

import yc.fen.dou.nettyStu.selfNetty.pool.NioSelectorRunnablePool;

import java.io.IOException;
import java.nio.channels.Selector;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;


/**
 * 抽象selector线程类
 */
public abstract class AbstractNioSelector implements Runnable {

	/**
	 * 线程池
	 */
	private final Executor executor;

	/**
	 * 选择器
	 */
	protected Selector selector;

	/**
	 * 选择器wakenUp状态标记
	 */
	protected final AtomicBoolean wakenUp = new AtomicBoolean();

	/**
	 * 任务队列
	 */
	private final Queue<Runnable> taskQueue = new ConcurrentLinkedQueue<Runnable>();

	/**
	 * 线程名称
	 */
	private String threadName;
	
	/**
	 * 线程管理对象
	 */
	protected NioSelectorRunnablePool selectorRunnablePool;

	/**
	 *
	 * @param executor   线程池
	 * @param threadName   线程名字
	 * @param selectorRunnablePool  selector线程管理者
	 */
	AbstractNioSelector(Executor executor, String threadName, NioSelectorRunnablePool selectorRunnablePool) {
		this.executor = executor;
		this.threadName = threadName;
		this.selectorRunnablePool = selectorRunnablePool;
		openSelector();
	}

	/**
	 * 获取selector并启动线程
	 */
	private void openSelector() {
		try {
			this.selector = Selector.open();
		} catch (IOException e) {
			throw new RuntimeException("Failed to create a selector.");
		}
		executor.execute(this);
	}

	@Override
	public void run() {
		Thread.currentThread().setName(this.threadName);
		//一直循环
		while (true) {
			try {
			    //还没有链接
				System.out.println("----------processTaskQueue--------"+Thread.currentThread().getName());
				wakenUp.set(false);
				select(selector);
				processTaskQueue();
				System.out.println("----------processTaskQueue--------"+Thread.currentThread().getName());
				process(selector);
			} catch (Exception e) {
				// ignore
			}
		}

	}

	/**
	 * 注册一个任务并激活selector
	 */
	protected final void registerTask(Runnable task) {
		taskQueue.add(task);
		Selector selector = this.selector;
		if (selector != null) {
			if (wakenUp.compareAndSet(false, true)) {
				selector.wakeup();
				System.out.println("----------selector.wakeup--------");
			}
		} else {
			taskQueue.remove(task);
		}
	}

	/**
	 * 执行队列里的任务
	 */
	private void processTaskQueue() {
		System.out.println("----------processTaskQueue--------"+Thread.currentThread().getName());
		for (;;) {
			final Runnable task = taskQueue.poll();
			if (task == null) {
				break;
			}
			task.run();
		}
	}
	
	/**
	 * 获取线程管理对象
	 * @return
	 */
	public NioSelectorRunnablePool getSelectorRunnablePool() {
		return selectorRunnablePool;
	}

	/**
	 * select抽象方法
	 * 
	 */
	protected abstract int select(Selector selector) throws IOException;

	/**
	 * selector的业务处理
	 * 
	 */
	protected abstract void process(Selector selector) throws IOException;

}
