package chapter04;

/**
 * 使用synchronized,对叫号程序进行修改
 * @author gaomeiling
 *
 */
public class TicketWindowRunnable implements Runnable{
	
	private int index = 1;
	
	private final static int MAX = 500;
	
	private final static Object MUTEX = new Object();
	
	public void run() {
		synchronized(MUTEX) { //sychronized代码块
			while(index <= MAX) {
				System.out.println(Thread.currentThread()+" 的号码是："+(index++));
			}
		}
	}
	
	public static void main(String[] args) {
		final TicketWindowRunnable task = new TicketWindowRunnable();
		Thread WindowThread1 = new Thread(task,"一号窗口");
		Thread WindowThread2 = new Thread(task,"二号窗口");
		Thread WindowThread3 = new Thread(task,"三号窗口");
		Thread WindowThread4 = new Thread(task,"四号窗口");
		
		WindowThread1.start();
		WindowThread2.start();
		WindowThread3.start();
		WindowThread4.start();
	}

}
