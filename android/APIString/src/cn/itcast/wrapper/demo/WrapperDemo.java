package cn.itcast.wrapper.demo;

public class WrapperDemo {

	public static void main(String[] args) {
		/*
		 * 基本数据类型对象包装类。 为了方便操作基本数据类型值，将其封装成对象
		 */
		// System.out.println(Integer.toBinaryString(8));
		// System.out.println();

		/*
		 * 十进制-->其他进制。
		 */
		// System.out.println(Integer.toBinaryString(60));
		// System.out.println(Integer.toOctalString(60));
		// System.out.println(Integer.toHexString(60));
		Integer a = new Integer("89");
		Integer b = new Integer(89);

		System.out.println(a == b);

		System.out.println(a.equals(b));

		System.out.println(a.compareTo(b));

	}

}
