package chapter14.singleton;

/**
 * 单例模式——饿汉模式
 * 
 * 关键：instance作为类变量并且直接得到初始化（当一个类初始化时，类中的所有基本数据成员都
 * 会被初始化，赋予初始值，非基本数据类型，对象的句柄也会被初始化，默认值为null）
 * 
 * 总结：饿汉单例模式可以保证多个线程下的唯一实例，getInstance方法的性能也比较高，但是无法
 * 进行懒加载。
 * @author Administrator
 *
 */
// final不允许被继承
public final class Hungry {
	// 实例变量
	private byte[] data = new byte[1024];
	
	// 定义实例对象的时候直接初始化
	private static Hungry instance = new Hungry();
	
	// 私有构造函数，不允许外部new
	private Hungry(){
		
	}
	
	public static Hungry getInstance(){
		return instance;
	}
}
