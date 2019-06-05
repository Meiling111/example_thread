package chapter01;

import java.util.concurrent.TimeUnit;

public class TryConcurrency {

	public static void main(String[] args){
		// ͨ�������ڲ���ķ�ʽ�����̣߳�������д���е�run����
		new Thread() {
			public void run() {
				enjoyMusic();
			}
		}.start();
		browserNews();
	}
	
	private static void browserNews(){
		for(;;) {
			System.out.println("Uh-huh,the good news.");
			sleep(1);
		}
	}
	
	public static void enjoyMusic(){
		for(;;){
			System.out.println("Uh-huh,the nice music.");
			sleep(1);
		}
	}
	
	private static void sleep(int seconds){
		try{
			TimeUnit.SECONDS.sleep(seconds);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
