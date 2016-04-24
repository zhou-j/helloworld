package cn.itcast.io.file.demo;

import java.io.File;

import cn.itcast.io.filter.FilterByHidden;
import cn.itcast.io.filter.FilterByJava;
import cn.itcast.io.filter.SuffixFilter;

public class FileListDemo {

	public static void main(String[] args) {
		
		listDemo_2();

	}

	public static void listDemo_3() {
		

		File dir = new File("c:\\");
		
		File[] files = dir.listFiles(new FilterByHidden());
		System.out.println(files.length);
		
		for(File file : files){
			 
			
			 System.out.println(file);
		}
	}

	public static void listDemo_2() {
		
		File dir = new File("d:\\first");
		
		String[] names = dir.list(new SuffixFilter(".txt"));
		
		for(String name : names){
			 System.out.println(name);
		}
	}

	public static void listDemo() {

	  File file = new File("d:\\first");
	  
	  /*
	   * 获取当前目录下的文件及文件夹的名称，包含隐藏文件。
	   * 调用list方法的File对象中封装的必须是目录。
	   * 否则会发生NullPointerException
	   * 如果访问的系统目录也会发生空指针异常。
	   * 
	   * 如果目录存在但是没有内容，会返回一个数组，但是长度为0.
	   * 
	   * */
	  String[] names = file.list();
	  System.out.println(names.length);
	  
	  for(String name : names){
		  System.out.println(name);
	  }
	}

}
