package cn.itcast.string.demo;

public class StringDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * String类的特点：
		 * 字符串对象一旦被初始化 就不会改变
		 * */
        String s = "abc";
        String s1 = new String("abc");//在堆 里创建2个对象，一个new一个字符串对象在堆内存中。
        System.out.println(s==s1);//比较地址。
        System.out.println(s.equals(s1));//string类中的equals复写object类中的equals,建立了string类自己的判断字符串是否相等的依据。比较字符串中德内容
        // System.out.println("s="+s);//"abc"存储在字符串常量池中。
       // System.out.println("s1="+s1);
	}

}
