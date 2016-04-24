package cn.itcast.generic.demo;

import java.util.ArrayList;
import java.util.Iterator;



public class GenericDemo {

	public static void main(String[] args) {
		
		ArrayList<String> a1 = new ArrayList<String>();
		
		a1.add("abc");
		a1.add("hahah");
		a1.add("4");
		
		Iterator it = a1.iterator();
		while(it.hasNext()){
			String str = (String)it.next();
			System.out.println(str);
		}

	}

}
