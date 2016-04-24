package cn.itcast.toolclass.arrays.demo;

import java.util.Arrays;
import java.util.List;

public class ArraysDemo {

	public static void main(String[] args) {
           /*
            * Arrays:集合框架工具类。里面的方法都是静态的。
            * 
            * */
		
	//	int[] arr = { 3,1,5,6,3,6};
		
	//	System.out.println(Arrays.toString(arr));
		
		demo_2();
	}

	public static void demo_2() {
		
		/*
		 * 如果数组中的元素是对象，那么转成集合时，直接将数组中的元素作为集合中的元素进行集合存储。
		 * 
		 * 如果数组中德元素是基本类型数值，那么会将该数组作为集合中的元素进行存储。
		 * 
		 * */
		
		int[] arr = {31,11,51,61};
		
		List list = Arrays.asList(arr);
		
		System.out.println(list);
	}

	/**
	 * 
	 */
	private static void demo_1() {
		/*
		 * 重点：List asList(数组）将数组转成集合。
		 * 
		 * 好处:其实可以用集合的方法操作数组中的元素。
		 * 注意：数组的长度是固定的，所以对于集合的增删方法是不可以使用的。
		 * 否则会发生UnsuportedOperationexction
		 * 
		 * */
		
		String[] arr = {"abc","haha","xixi"};
		
	//	boolean b = myContains(arr,"xixi");
	//	System.out.println(b);
		
		List<String> list = Arrays.asList(arr);
		//boolean b = list.contains("xixi");
		//System.out.println("b="+b);
		//list.add("hiahia");
	}
	
	public static boolean myContains(String[] arr,String key){
		for(int i = 0; i< arr.length;i++){
			if(arr[i].equals(key))
				return true;
		}
		return false;
		}
	}
/*	
	//toString的经典实现。
	public  static String myToString(int[] a){
	 if (a == null)
         return "null";
     int iMax = a.length - 1;
     if (iMax == -1)
         return "[]";

     StringBuilder b = new StringBuilder();
     b.append('[');
     for (int i = 0; ; i++) {
         b.append(a[i]);
         if (i == iMax)
             return b.append(']').toString();
         b.append(", ");
     }
	}
*/

