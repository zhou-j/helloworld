package cn.itcast.hashset.test;

import java.util.HashSet;
import java.util.Iterator;

import cn.itcast.bean.Person;

public class HashSetTest {

	public static void main(String[] args) {
         
		HashSet hs = new HashSet();
		/*
		 * HashSet集合数据结构是哈希表，所以存储元素的时候
		 * 使用的元素的hashCode方法来确定位置，如果位置相同，再通过元素的equals来确定是否相同。*/
		hs.add(new Person("list4",24));
		hs.add(new Person("list7",27));
		hs.add(new Person("list1",21));
		hs.add(new Person("list9",29));
		hs.add(new Person("list7",27));
		
		Iterator it = hs.iterator();
		
		while(it.hasNext()){
			Person p = (Person)it.next();
			System.out.println(p.getName()+"......."+p.getAge());
		}
		
		
		
		
	}

}
