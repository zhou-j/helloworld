package cn.itcast.wrapper.demo;

public class WrapperDemo2 {

	public static void main(String[] args) {

		/*
		 * int num = 4; num = num + 5; Integer i = 4; 自动装箱简化书写。 i = i + 6 ; 自动拆箱
		 * System.out.println(i);
		 */
		Integer a = new Integer(128);
		Integer b = new Integer(128);

		System.out.println(a == b);
		System.out.println(a.equals(b));

		Integer x = 129;// jdk1.5以后，自动装箱，如果装箱的是一个字节，那么该数据会被共享不会重新开辟空间。
		Integer y = 129;
		System.out.println(x == y);
		System.out.println(x.equals(y));
	}

}
