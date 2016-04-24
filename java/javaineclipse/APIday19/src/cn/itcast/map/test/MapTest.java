package cn.itcast.map.test;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/*
 *练习：
 *"fdgavcbsacdfs"获取该字符串中，每一个字母出现的次数。
 *要求打印结果是：a(2)b(1)....;
 *对于结果的分析发现，字母和次数之间存在着映射的关系。而且这种关系很多。
 *很多就需要存储，能存储映射关系的容器有数组和Map集合。
 *关系——方式有序编号吗？没有！
 *那就是Map集合。又发现可以保证唯一性的一方具备着顺序如a b c .....
 *所以可以使用TreeMap集合。
 *
 *这个集合最终应该存储的是字母和次数的对应关系。
 *
 *1.因为操作的是字符串中的字母，所以先将字符串变成字符数组。
 *2.遍历字符数组，用每一个字母作为键去查Map集合这个表。
 *如果该字母不存在作为键1作为值存储到Map集合中。
 *如果该字母键存在，就将该字母键对应值取出并+1，在将该字母和+1后的值存储到Map集合中；
 * 键相同值会覆盖。这样就记录了该字母的次数。
 * 3.遍历结束，map集合就记录了所有字母的出现的次数。
 * 
 * 
 * */
public class MapTest{
	
	public static void  main(String[] args){
		
		String str = "fdg a v3c4b5sacdfs";
		
		String s = getCharCount(str);
		
		System.out.println(s);
		
	}
	public static String  getCharCount(String str){
		//将字符串变成字符数组。
		char[] chs = str.toCharArray();
		
		//定义map集合表。
		Map<Character,Integer>map = new TreeMap<Character,Integer>();
		
		for(int i = 0;i<chs.length;i++){
			
			if(!(chs[i]>='a'&&chs[i]<='z'||chs[i]>='A'&&chs[i]<='Z'))
				continue;
			
			//将数组中的字母作为键去查Map表。
			Integer value = map.get( chs[i]);
			
			//判断是否为null。
			if(value==null){
				map.put(chs[i],1);
			}else{
				map.put(chs[i], value+1);
			}
		}
		return mapToString(map);
	}
	private static String mapToString(Map<Character, Integer> map) {
		
		StringBuilder sb = new StringBuilder();
		
		Iterator<Character>it =map.keySet().iterator();
		while(it.hasNext()){
			Character key = it.next();
			Integer value = map.get(key);
			
			sb.append(key+"("+value+")");
		}
		
		return  sb.toString();
	}
}
 