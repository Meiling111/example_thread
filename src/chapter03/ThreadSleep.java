package chapter03;

import java.util.concurrent.TimeUnit;

public class ThreadSleep {

	public static void main(String[] args) {
		
		new Thread( ()->{ 
			long startTime = System.currentTimeMillis();
//			sleep(2_000L);
			try { 
				// �߳�����2����
				TimeUnit.MINUTES.sleep(2); // ʹ��TimeUnit���Tread.sleep,���Բ��ý�����ʱ�任��ɺ�����
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			long endTime = System.currentTimeMillis();
			System.out.println(String.format("Total spend %d ms", (endTime-startTime)));
		}).start();
		
		long startTime = System.currentTimeMillis();
		sleep(3_000L);
		long endTime = System.currentTimeMillis();
		System.out.println(String.format("Main thread total spend %d ms", (endTime-startTime)));
	}
	
	private static void sleep(long ms) {
		try {
			Thread.sleep(ms);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
