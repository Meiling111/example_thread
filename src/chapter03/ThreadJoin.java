package chapter03;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ThreadJoin {
	public static void main(String[] args) throws InterruptedException {
		// 定义两个线程，并保存在threads中
		List<Thread> threads = IntStream.range(1,3).mapToObj(ThreadJoin :: create).collect(Collectors.toList());
		
		// 启动这两个线程
		threads.forEach(Thread :: start);
		
		// 执行这两个线程的join方法
//		for(Thread thread : threads) {
//			System.out.println(Thread.currentThread().getName());
//			thread.join();
//		}
		
		for(int i=0; i<10; i++) {
			System.out.println(Thread.currentThread().getName()+"#"+i);
			shortSleep();
		}
	}
	
	private static Thread create(int seq) {
		return new Thread( ()->{ 
			for(int i=0; i<10; i++) {
//				System.out.println(Thread.currentThread().getName());
				System.out.println(Thread.currentThread().getName()+"#"+i);
				shortSleep();
			}
		});
	}
	
	private static void shortSleep() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
