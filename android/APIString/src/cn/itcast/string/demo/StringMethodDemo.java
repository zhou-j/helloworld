package cn.itcast.string.demo;

public class StringMethodDemo {
	
	public static void main(String[] args){
		
		stringMethod_4();
	}

	private static void stringMethod_4() {
		System.out.println("abc".compareTo("acb"));
	}

	private static void stringMethod_3() {
		
		String s = "abc";
		System.out.println(s.equals("ABC".toLowerCase()));
		System.out.println(s.equalsIgnoreCase("ABC"));
		System.out.println(s.contains("cc"));
	}

	private static void stringMethod_2() {
		String  s = "张三,李四,王五";
		String[] arr = s.split(",");
		
		for(int i = 0;i < arr.length ;i++){
			System.out.println(arr[i]);
		}
		char[] chs = s.toCharArray();
		for(int i = 0;i < chs.length;i++){
			System.out.println(chs[i]);
		}
	}

	private static void stringMethod_1() {
		String  s = "ancdae";
		
		System.out.println("length:"+s.length());
		System.out.println("char:"+s.charAt(2));
		System.out.println("index:"+s.indexOf('s'));
		System.out.println("lastIndex:"+s.lastIndexOf('a'));
	}
	

	

}
