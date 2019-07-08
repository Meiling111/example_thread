package chapter14.singleton;

/**
 * 单例模式——懒汉式
 * 特点： 1）在使用类实例的时候再去创建（用时创建）
 * 	     2）无法保证单例的唯一性
 * @author Administrator
 *
 */
public final class Lazy {

	// 实例变量
	private byte[] data = new byte[1024];
	
	// 定义实例，但不直接初始化
	private static Lazy instance = null;
	
	private Lazy(){
		
	}
	
	public static Lazy getInstance(){
		if( null == instance )
			instance = new Lazy();
		return instance;
	}
}
