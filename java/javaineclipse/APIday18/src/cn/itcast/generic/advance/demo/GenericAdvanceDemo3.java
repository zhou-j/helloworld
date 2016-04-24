package cn.itcast.generic.advance.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

import cn.itcast.bean.Person;
import cn.itcast.bean.Student;
import cn.itcast.bean.Worker;

public class GenericAdvanceDemo3 {

	public static void main(String[] args) {
		TreeSet<Person> a1 = new TreeSet<Person>(new CompByName());
		
		a1.add(new Person ("abcd",32));
		a1.add(new Person ("abc",36));
		a1.add(new Person ("hehe",34));
		
		TreeSet<Student> a12 = new TreeSet<Student>();
	    a12.add(new Student ("abc",11));
		a12.add(new Student ("hehe",22));
		
		TreeSet<Worker> a13 = new TreeSet<Worker>();
	    a13.add(new Worker ("abc",11));
		a13.add(new Worker ("hehe",22));
		
	//	System.out.println(a1.size());
		
		Iterator<Person> it = a1.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	//	printCollection(a1);
	 //   printCollection(a12);

	}
}
/*
 * class TreeSet<E>
 * {
 * 
 *  }
 *  class TreeSet <Worker>
 *  {
 *      Tree(Comparator<? super Worker> comp);
 *  }
 *    
 *  
 *    什么时候用下限呢？通常对集合中的元素进行取出操作时，可以使用下限*/
class CompByName implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		
		int temp = o1.getName().compareTo(o2.getName());
		
		return temp==0?o1.getAge()-o2.getAge():temp;
	}
}
	
