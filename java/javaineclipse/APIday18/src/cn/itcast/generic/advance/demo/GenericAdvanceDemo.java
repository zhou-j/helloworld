package cn.itcast.generic.advance.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import cn.itcast.bean.Person;
import cn.itcast.bean.Student;
import cn.itcast.bean.Worker;

public class GenericAdvanceDemo {

	public static void main(String[] args) {
		ArrayList<Worker> a1 = new ArrayList<Worker>();
		
		a1.add(new Worker ("abc",30));
		a1.add(new Worker("hehe",34));
		
		ArrayList<Student> a12 = new ArrayList<Student>();
	    a12.add(new Student ("abc",30));
		a12.add(new Student ("hehe",34));
		
		printCollection(a1);
	    printCollection(a12);

	}

	/**
	 * @param a1
	 */
	/*
	 * 迭代并打印集合中的元素。
	 * 
	 * 可以对类型进行限定：
	 * ？extends E:接收E类型或者E的子类型对象。上限！
	 * 
	 * ？extends E:接收E类型或者E的父类型。下限！*/
	private static void printCollection(Collection<? extends Person> a1) {
		Iterator<?> it = a1.iterator();
		while(it.hasNext()){
			System.out.println(it.next().toString());
		}
	}

}
