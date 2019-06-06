package chapter03;

import java.util.concurrent.TimeUnit;

public class ThreadisInterrupted {

	public static void main(String[] args) throws InterruptedException{
		Thread thread = new Thread() {
			public void run() {
				while(true) {
					// do something,just empty loop.
				}
			}
		};
		
		thread.start();
		TimeUnit.MILLISECONDS.sleep(2);
		System.out.printf("Thread is interrupted ? %s\n", thread.isInterrupted());
		thread.interrupt();
		System.out.printf("Thread is interrupted ? %s\n", thread.isInterrupted());
	}
}
