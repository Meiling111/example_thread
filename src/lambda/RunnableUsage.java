package lambda;

public class RunnableUsage {
	
	public static void main(String[] args) {
		// 1.1使用匿名内部类
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello Word!");
			}
		}).start();
		// 1.2使用Lambda表达式
		new Thread(() -> System.out.println("Hello Word!")).start();
		
		// 2.1使用匿名内部类
		Runnable runnable1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello Word!");
			}
		};
		// 2.2使用Lambda表达式
		Runnable runnable2 = () -> System.out.println("Hello World!");
		
		// 直接调用run方法（没开新线程）
		runnable1.run();
		runnable2.run();
	}

}
