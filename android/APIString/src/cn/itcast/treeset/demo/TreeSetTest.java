package cn.itcast.treeset.demo;

import java.util.Iterator;
import java.util.TreeSet;

import cn.itcast.comparator.ComparatorByLength;

public class TreeSetTest {

	public static void main(String[] args) {
      TreeSet ts = new TreeSet(new ComparatorByLength());
      
      ts.add("aaaaa");
      ts.add("zz");
      ts.add("nbaq");
      ts.add("cba");
      ts.add("abc");
      
      Iterator it = ts.iterator();
      
      while(it.hasNext()){
    	  System.out.println(it.next());
      }
	}

}
