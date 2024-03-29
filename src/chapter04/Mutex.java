package chapter04;

import java.util.concurrent.TimeUnit;

/**
 * synchronized关键字理解
 * @author gaomeiling
 *
 */
public class Mutex {
	private final static Object MUTEX = new Object();
	
	public void accessResource() {
		synchronized (MUTEX) {
			try {
				TimeUnit.MINUTES.sleep(1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		final Mutex mutex = new Mutex();
		for(int i=0;i<5;i++) {
			new Thread(mutex :: accessResource).start();
		}
	}
}
