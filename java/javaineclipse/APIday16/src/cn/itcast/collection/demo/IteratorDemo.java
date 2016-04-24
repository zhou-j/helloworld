package cn.itcast.collection.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorDemo {

	public static void main(String[] args) {

		Collection<String> coll = new ArrayList<String>();

		coll.add("abc1");
		coll.add("abc2");
		coll.add("abc3");
		coll.add("abc4");

		// Iterator it = coll.iterator();

		// while(it.hasNext()){
		// System.out.println(it.next());//循环结束迭代器还是存在
		// }
		for (Iterator<String> it = coll.iterator(); it.hasNext();) {
			System.out.println(it.next());// 循环结束迭代器消失了。
		}

		/*
		 * System.out.println(it.next()); System.out.println(it.next());
		 * System.out.println(it.next()); System.out.println(it.next());
		 * System.out.println(it.next());//java.util.NoSuchElementException
		 */
	}

}
