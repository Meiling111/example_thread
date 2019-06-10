package chapter03;

import java.util.concurrent.TimeUnit;

/**
 * 线程正常关闭一：线程结束生命周期正常结束
 * 线程正常关闭二：捕获中断信号关闭线程
 * @author gaomeiling
 */
public class InterruptThreadExit {

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread() {
			public void run() {
				System.out.println("============6:"+Thread.currentThread().getName());
				System.out.println("I will start work.");
				while(!isInterrupted()) {
					// working
				}
				System.out.println("I will be exiting.");
				System.out.println("============7:"+Thread.currentThread().getName());
			}
		};
		
		System.out.println("============1:"+Thread.currentThread().getName());
		thread.start();
		System.out.println("============2:"+Thread.currentThread().getName());
		TimeUnit.MINUTES.sleep(1);
		System.out.println("============3:"+Thread.currentThread().getName());
		System.out.println("System will be shutdown.");
		System.out.println("============4:"+Thread.currentThread().getName());
		thread.interrupt();
		System.out.println("============5:"+Thread.currentThread().getName());
	}
}
