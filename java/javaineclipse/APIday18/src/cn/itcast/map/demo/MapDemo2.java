package cn.itcast.map.demo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapDemo2 {

	public static void main(String[] args) {
		
		Map<Integer,String>map = new HashMap<Integer,String>();
		method_2(map);

	}
    public static void method_2(Map<Integer, String> map) {
    	map.put(8, "wangwu");
    	map.put(2,"zhaoliu");
    	map.put(7,"xiaoqiang");
    	map.put(6, "wangcai");
    	
    	Collection<String> values = map.values();
    	
    	Iterator<String> it2 = values.iterator();
    	while(it2.hasNext()){
    		System.out.println(it2.next());
    	}
 /*    	
    	/*
    	 * 通过Map转成set就可以迭代。
    	 * 找到另一个方法。entrySet。
    	 * 该方法将键 和值的映射关系作为对象存储到了Set集合中，而这个映射关系的类型就是Map.Entry类型（结婚证）
    	 * 
    	 * 
    	 * 
    	Set<Map.Entry<Integer, String>>entrySet = map.entrySet();
    	
    	Iterator<Map.Entry<Integer, String>>it = entrySet.iterator();
    	
    	while(it.hasNext()){
    		Map.Entry<Integer, String>me = it.next();
    		Integer key = me.getKey();
    		String value = me.getValue();
    		System.out.println(key+":::::"+value);
    	}
    	
    	
*/    	
    	
    	
    	//取出map中的所有元素。
    	//原理，通过KeySet方法获取map中所有的键所在的Set集合，在通过Set的迭代器获取到每一个键。
    	//再对每一个键通过map集合的get方法获取其对应的值即可。
  /*  	
    	Set<Integer>keySet = map.keySet();
    	Iterator<Integer>it = keySet.iterator();
    	
    	while(it.hasNext()){
    		Integer key  = it.next();
    		String value = map.get(key);
    		System.out.println(key+":"+value);
    	}
	}
	public static void method(Map<Integer,String> map){
    	//添加元素。
    	System.out.println(map.put(8,"wangcai"));
    	System.out.println(map.put(8,"xiaoqiang"));
    	map.put(2,"zhangfan");
    	map.put(7,"zhaoliu");
    	
    	
    	System.out.println("get:"+map.get(8));
    	
    	System.out.println(map);
    	*/
    }
}
