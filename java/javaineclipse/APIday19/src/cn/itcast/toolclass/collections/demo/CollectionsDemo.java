package cn.itcast.toolclass.collections.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import cn.itcast.comparator.ComparatorByLength;

public class CollectionsDemo {

	public static void main(String[] args) {
		
		/*
		 * Collections:是集合框架的工具类。
		 * 里面的方法都是静态的。
		 * 
		 * 
		 * 
		 * */
		demo_4();

	}
	
	public static void demo_4() {
		List<String> list = new ArrayList<String>();
		
		list.add("abcde");
		list.add("cba");
		list.add("aa");
		list.add("zhangsan");
		list.add("wangwu");
		list.add("zhaoliu");
		
		System.out.println(list);
	//	Collections.replaceAll(list,"cba","nba");
	//	Collections.fill(list, "cc");
		Collections.shuffle(list);
		System.out.println(list);
		
	}

	public static void demo_3() {
	/*
		TreeSet<String> ts = new TreeSet<String>(new Comparator<String>(){
		
		public int compare(String o1, String o2){
			
			int temp = o2.compareTo(o1);
			return temp;
		}
		});
		*/
	    TreeSet<String> ts = new TreeSet<String>(Collections.reverseOrder( new ComparatorByLength()));
		ts.add("abc");
		ts.add("hahaha");
		ts.add("zzz");
		ts.add("aa");
		ts.add("cba");
		
		System.out.println(ts);
		
	}

	public static void demo_2(){
        
		
		List<String>list  = new ArrayList<String>();
		
		list.add("abcde");
		list.add("cba");
		list.add("aa");
		list.add("zzz");
		list.add("nbaa");
		Collections.sort(list);
	    System.out.println(list);
	    
	   // int index = Collections.binarySearch(list,"cba");
	    //System.out.println("index="+index);
		
	    String max = Collections.max(list,new ComparatorByLength());
	    System.out.println("max="+max);
	}

	public static void demo_1() {
		
		List<String>list  = new ArrayList<String>();
		
		list.add("abcde");
		list.add("cba");
		list.add("aa");
		list.add("zzz");
		list.add("nbaa");
		
		//对list集合进行指定顺序的排序。
		//Collections.sort(list);
		//System.out.println(list);
	//	mySort(list,new ComparatorByLength());
		Collections.sort(list,new ComparatorByLength());
		System.out.println(list);
	}
	
	public static<T> void mySort(List<T>list,Comparator<? super T> comp){
		for(int i = 0;i<list.size()-1;i++){
			for(int j = i+1;j <list.size();j++){
				if(comp.compare(list.get(i),list.get(j))>0){
					T temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j,temp);
				}
			}
		}
	}

}
