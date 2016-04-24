package cn.itcast.hashset.demo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkdeHashSetDemo {

	public static void main(String[] args) {

		HashSet hs = new LinkedHashSet();
		
		
		hs.add("hehe");
		hs.add("heihei");
		hs.add("hahah");
		hs.add("xixii");
		
		Iterator it  = hs.iterator();
		
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

}
