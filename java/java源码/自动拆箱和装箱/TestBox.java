package com.gh.box;

public class TestBox {

	public static void main(String[] args) {
		// 5.0
		//װ�䣬������������װ��ɰ�װ��
		Integer i = 10;  
		//���䣬��װ���Զ�����Ϊ������������
		int j = i; 		
		System.out.println(i + " : " + j);

		// 1.4��Ϊ�˼���1.4�����°汾��һ��ѡ����������д��
		Integer ii = new Integer(20);
		int jj = ii.intValue();
		System.out.println(ii + " : "  + jj);
		
		Double d = new Double(2.0);
		double b = d.doubleValue();
		System.out.println("***********");
		print(3.0f);

		/*
		 * 3 int -- 1 int
		 * 3 int -- ע�͵�һ��  print(int i)  --�� short -- int -- long -- float  -- double��  -- 3 double
		 * 3 int -- ע�� 1 �� 3  -- 2 Integer���Զ�װ�䣩
		 * 3 int -- ע�� 1��2��3 --�״�
		 * */
	}
	public static void print(int i){
		System.out.println("1 int");
	}
	public static void print(Integer i){
		System.out.println("2 Integer");
	}
	public static void print(double i){
		System.out.println("3 double");
	}
	public static void print(Double i){
		System.out.println("4 Double");
	}
	public static void print(float i){
		System.out.println("5 float");
	}

}
