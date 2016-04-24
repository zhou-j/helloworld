package cn.itcast.generic.advance.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import cn.itcast.bean.Person;
import cn.itcast.bean.Student;
import cn.itcast.bean.Worker;

public class GenericAdvanceDemo2 {

	public static void main(String[] args) {
		ArrayList<Person> a1 = new ArrayList<Person>();
		
		a1.add(new Person ("abc",30));
		a1.add(new Person ("hehe",34));
		
		ArrayList<Student> a12 = new ArrayList<Student>();
	    a12.add(new Student ("abc",11));
		a12.add(new Student ("hehe",22));
		
		ArrayList<Worker> a13 = new ArrayList<Worker>();
	    a13.add(new Worker ("abc",11));
		a13.add(new Worker ("hehe",22));
		
	//	printCollection(a1);
	 //   printCollection(a12);

	}
}
/*
 * 一般在存储元素的时候都是用上限，因为这样取出来都是按照上限类型来运算的。不会出现类型安全隐患。*/

class MyCollection<E>{
	public void add(E e){
		
	}
	public  void addAll(MyCollection<? extends E> e){
		
	}
}

	
