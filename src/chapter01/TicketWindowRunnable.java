package chapter01;

import java.util.stream.IntStream;

public class TicketWindowRunnable implements Runnable {

	private int index = 1;
	
	private static final int MAX = 50;

	@Override
	public void run() {
		while(index <= MAX) {
			System.out.println(Thread.currentThread() + "�ĺ����ǣ�"+ (index++));
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
//	public static void main(String[] args) {
//		final TicketWindowRunnable task = new TicketWindowRunnable();
//		
//		Thread windowThread1 = new Thread(task,"1�Ŵ���");
//		
//		Thread windowThread2 = new Thread(task,"2�Ŵ���");
//		
//		Thread windowThread3 = new Thread(task,"3�Ŵ���");
//		
//		Thread windowThread4 = new Thread(task,"4�Ŵ���");
//		
//		windowThread1.start();
//		windowThread2.start();
//		windowThread3.start();
//		windowThread4.start();   
//	}
	
	public static void main(String[] args) {
		IntStream.range(0, 5).boxed().map(i -> new Thread(
				() -> System.out.println(Thread.currentThread().getName()))
				).forEach(Thread:: start);
	}
	
}
