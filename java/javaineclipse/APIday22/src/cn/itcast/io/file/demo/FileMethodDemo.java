package cn.itcast.io.file.demo;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

public class FileMethodDemo {

	public static void main(String[] args) throws IOException {
		
		
		/*
		 * File对象的常见方法。
		 * 
		 * 1.获取。
		 *       1.1获取文件名称。
		 *       1.2获取文件路径。
		 *       1.3获取文件大小。
		 *       1.4获取文件修改时间。
		 *       
		 * 2.创建与删除。
		 * 
		 * 
		 * 3.判断。
		 * 
		 * 4.重命名。
		 */
		//getDemo();
		//createAndDeleteDemo();

	  //	 isDmeo();
		renameToDemo();
	}
	
	public static void renameToDemo() {
		
		File f1 = new File("c:\\0.mp3");
		
		File f2 = new File("c:\\9.mp3");
		
		boolean b = f1.renameTo(f2);
		
		System.out.println("b="+b);
	}

	public static void isDmeo() {
		
		File f = new File("a.txt");
		
		System.out.println(f.isFile());
		System.out.println(f.isDirectory());
	}

	public static void createAndDeleteDemo() throws IOException {
		
		File dir = new File("abc\\q\\e\\c\\z\\r\\w\\y\\f\\e\\g\\s");
		
		boolean b = dir.mkdirs();
		System.out.println("b="+b);
		dir.mkdirs();
		System.out.println(dir.delete());
		
		//文件的创建和删除。
		File file = new File("file.txt");
		
		/*
		 * 和输出流不一样，如果文件不存在，则创建，如果文件存在，则不创建。
		 * 
		 * 
		 * */
		boolean b1 = file.createNewFile();
		
	}

	public static void getDemo(){
		//File file = new File("E:\\java0331\\day22e\\a.txt");
	     File file = new File("a.txt");
	     
	     String name = file.getName();
	     
	     String absPath = file.getAbsolutePath();//绝对路径
	     
	     String path = file.getPath();
	     
	     long len = file.length();
	     
	     long time = file.lastModified();
	     
	     Date date = new Date(time);

	     DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);
	     
	     String str_time = dateFormat.format(date);
	     
	     
	     System.out.println("name:"+name);
	     System.out.println("absPath:"+absPath);
	     System.out.println("path"+path);
	     System.out.println("len:"+len);
	     System.out.println("str_time:"+str_time);
	
	     
	}

}
