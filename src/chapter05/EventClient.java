package chapter05;

import java.util.concurrent.TimeUnit;

/**
 * 测试单线程间的通讯
 * @author gaomeiling
 */
public class EventClient {
	public static void main(String[] args) {
		final EventQueue eventQueue = new EventQueue();
		new Thread( ()-> { 
			for(;;) {
				eventQueue.offer(new EventQueue.Event()); // 创建静态内部类的实例
			}
		}, "Producer").start();
		
		new Thread( ()-> { 
			for(;;) {
				eventQueue.take();
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}, "Consumer").start();
	}
}
