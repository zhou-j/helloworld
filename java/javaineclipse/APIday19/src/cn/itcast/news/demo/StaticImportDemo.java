package cn.itcast.news.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StaticImportDemo {

	public static void main(String[] args) {
		
		List<String>list = new ArrayList<String>();
		
		list.add("abc3");
		list.add("abc7");
		list.add("abc1");
		
		System.out.println(list);
		
		Collections.sort(list);
		
		System.out.println(list);
		
		String max = Collections.max(list);
		System.out.println("max="+max);

	}

}
