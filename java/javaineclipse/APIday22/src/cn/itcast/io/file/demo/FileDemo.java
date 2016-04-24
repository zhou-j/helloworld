package cn.itcast.io.file.demo;

import java.io.File;

public class FileDemo {

	public static void main(String[] args) {
		
		constructorDemo();

	}

	public static void constructorDemo() {
	
	//可以将一个已存在的文件或者目录封装成file对象。
	File f1 = new File("c:\\a.txt");
	
	File f2 = new File("c:\\","a.txt");
	
	File f = new File("c:\\");
	
	File f3 = new File(f,"a.txt");
	
	File f4 = new File ("c:"+System.getProperty("file.separator")+"abc\\a.txt");
    System.out.println(f4);
    
	}

}
