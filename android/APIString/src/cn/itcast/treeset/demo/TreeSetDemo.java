package cn.itcast.treeset.demo;

import java.util.Iterator;
import java.util.TreeSet;

import cn.itcast.bean.Person;
import cn.itcast.comparator.ComparatorByName;

public class TreeSetDemo {

	public static void main(String[] args) {
		
	   TreeSet ts = new TreeSet(new ComparatorByName());
	   
	   ts.add(new Person("zhangsan",21));
	   ts.add(new Person("wanwu",23));
	   ts.add(new Person("zhouqi",28));
	   ts.add(new Person("lisi",22));
	   Iterator it = ts.iterator();
	   while(it.hasNext()){
		   Person p =(Person)it.next();
		   
		   System.out.println(p.getName()+":"+p.getAge());
	   }
		
		

	}

	/**
	 * 
	 */
	private static void demo1() {
		TreeSet ts = new TreeSet();
		
		ts.add("abc");
		ts.add("aa");
		ts.add("nba");
		ts.add("cba");
		
		Iterator it = ts.iterator();
		
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

}
