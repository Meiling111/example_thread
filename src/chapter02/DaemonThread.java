package chapter02;

public class DaemonThread {

	public static void main(String[] args) throws InterruptedException {
		// 1.main �߳̿�ʼ
		Thread thread = new Thread(() -> {
			while(true) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		 thread.setDaemon(true); // 2.��thread����Ϊ�ػ��߳�
		
		thread.start(); // 3.����thread�߳�
		Thread.sleep(2_000L);
		System.out.println("Main thread finished lifecycle.");
		// 4.main�߳̽���
	}
}
