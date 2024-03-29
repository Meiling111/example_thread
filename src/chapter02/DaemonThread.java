package chapter02;

public class DaemonThread {

	public static void main(String[] args) throws InterruptedException {
		// 1.main 线程开始
		Thread thread = new Thread(() -> {
			while(true) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		 thread.setDaemon(true); // 2.将thread设置为守护线程
		
		thread.start(); // 3.启动thread线程
		Thread.sleep(2_000L);
		System.out.println("Main thread finished lifecycle.");
		// 4.main线程结束
	}
}