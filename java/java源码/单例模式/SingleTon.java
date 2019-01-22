package com.test.singleton;

/**
 * 测试单例模式
 * @author Administrator
 *
 */
public class SingleTon {
	
	public static void main(String[] args) {
		System.out.println(EagerSingleton.getInstance().toString());
		System.out.println(EagerSingleton.getInstance().toString());
		System.out.println(LazySingleton.getInstance().toString());
		System.out.println(LazySingleton.getInstance().toString());
	}

}

/**
 * 饿汉式单例，不存在多线程同步问题
 * @author Administrator
 *
 */
class EagerSingleton{
	private static EagerSingleton instance = new EagerSingleton();
	
	/**
	 * 私有化构造函数，不让用户通过构造函数实例化该类
	 */
	private EagerSingleton(){}
	
	public static EagerSingleton getInstance(){
		return instance;
	}
}

/**
 * 懒汉式单例，在这里用synchronized解决多线程同步问题
 * @author Administrator
 *
 */
class LazySingleton{
	private static LazySingleton instance = null;
	
	/**
	 * 私有化构造函数，不让用户通过构造函数实例化该类
	 */
	private LazySingleton(){}
	
	/**
	 * synchronized解决线程同步访问问题，比如多线程同步调用该方法的时候，一个线程进来发现instance为null 然后阻塞了，第二个线程进来发现instance也为null
	 * 因此创建了一个instance实例，完了以后第一个线程就绪运行，又会创建一个instance实例。在这里用synchronized就可以解决该问题
	 * @return
	 */
	public static synchronized LazySingleton getInstance(){
		if( instance == null ){
			instance = new LazySingleton();
		}
		return instance;
	}
}