package cn.itcast.arraylist.test;

import java.util.ArrayList;
import java.util.Iterator;

import cn.itcast.bean.Person;

public class ArrayListTest {

	public static void main(String[] args) {
		
		ArrayList a1 = new ArrayList();
		a1.add(new Person("lisi1",21));
		a1.add(new Person("lisi2",22));
		a1.add(new Person("lisi3",23));
		a1.add(new Person("lisi4",24));
        
		Iterator it = a1.iterator();
		while(it.hasNext()){
		//	System.out.println(((Person) it.next()).getName()+((Person) it.next()).getAge());
		Person p =  (Person)it.next();
		System.out.println(p.getName()+"--"+p.getAge());
		}
	}

}
