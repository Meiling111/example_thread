package chapter03;

import java.util.concurrent.TimeUnit;

public class ThreadInterrupt {

	public static void main(String[] args) throws InterruptedException{
		Thread thread = new Thread( ()->{ 
			try {
				TimeUnit.MINUTES.sleep(2);
			} catch (Exception e) {
				System.out.println("Oh, i am be interrupted.");
			}
		});
		thread.start();
		
		TimeUnit.MILLISECONDS.sleep(2); // 短暂地打断以确定线程开始
		thread.interrupt();
	}
}
