package cn.itcast.comparator;

import java.util.Comparator;

public class ComparatorByLength implements Comparator<String> {

	public int compare(String o1,String o2){
		
		int temp = o1.length() - o2.length();
		return temp==0?o1.compareTo(o2):temp;
		
	}

}
