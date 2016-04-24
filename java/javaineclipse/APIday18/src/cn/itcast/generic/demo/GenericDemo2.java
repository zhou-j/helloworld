package cn.itcast.generic.demo;

import java.util.Iterator;
import java.util.TreeSet;

import cn.itcast.bean.Person;
import cn.itcast.comparator.ComparatorByName;

public class GenericDemo2 {

	public static void main(String[] args) {
		
		TreeSet<Person> ts = new TreeSet<Person>( new ComparatorByName());
		ts.add(new Person("lisi",22));
		ts.add(new Person("lisi3",23));
		ts.add(new Person("lisi",21));
		ts.add(new Person("lis0",24));
		
		Iterator<Person> it = ts.iterator();
		
		while(it.hasNext()){
			Person p = it.next();
			System.out.println(p.getName()+":"+p.getAge());
		}
		
		

	}


}
