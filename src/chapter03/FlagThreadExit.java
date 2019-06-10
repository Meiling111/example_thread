package chapter03;

import java.util.concurrent.TimeUnit;

/**
 * 线程正常关闭三：使用volatile关键字关闭线程
 * 
 * @author gaomeiling
 */
public class FlagThreadExit {
	static class MyTask extends Thread{ // 使用static后，创建MyTask对象之前，不用先创建FlagThreadExit对象
		private volatile boolean closed = false;
		
		@Override
		public void run() {
			System.out.println("I will start work.");
			while(!closed && !isInterrupted()) {
				// 正在运行
			}
			System.out.println("I will be exiting.");
		}
		
		public void close() {
			this.closed = true;
//			this.interrupt();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		MyTask t = new MyTask();
		t.start();
		TimeUnit.SECONDS.sleep(30);
		System.out.println("System will be shutdown.");
		t.close();
	}
}
