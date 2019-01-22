package com.test.singleton;

/**
 * ���Ե���ģʽ
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
 * ����ʽ�����������ڶ��߳�ͬ������
 * @author Administrator
 *
 */
class EagerSingleton{
	private static EagerSingleton instance = new EagerSingleton();
	
	/**
	 * ˽�л����캯���������û�ͨ�����캯��ʵ��������
	 */
	private EagerSingleton(){}
	
	public static EagerSingleton getInstance(){
		return instance;
	}
}

/**
 * ����ʽ��������������synchronized������߳�ͬ������
 * @author Administrator
 *
 */
class LazySingleton{
	private static LazySingleton instance = null;
	
	/**
	 * ˽�л����캯���������û�ͨ�����캯��ʵ��������
	 */
	private LazySingleton(){}
	
	/**
	 * synchronized����߳�ͬ���������⣬������߳�ͬ�����ø÷�����ʱ��һ���߳̽�������instanceΪnull Ȼ�������ˣ��ڶ����߳̽�������instanceҲΪnull
	 * ��˴�����һ��instanceʵ���������Ժ��һ���߳̾������У��ֻᴴ��һ��instanceʵ������������synchronized�Ϳ��Խ��������
	 * @return
	 */
	public static synchronized LazySingleton getInstance(){
		if( instance == null ){
			instance = new LazySingleton();
		}
		return instance;
	}
}