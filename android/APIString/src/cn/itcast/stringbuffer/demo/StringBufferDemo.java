package cn.itcast.stringbuffer.demo;

public class StringBufferDemo {
	


	public static void main(String[] args) {
		/*既然是一个容器对象。应该具备什么功能？
		1，添加：
		  StringBuffer append(data);
		  StringBuffer insert(index,data);
		 2,删除：
		  StringBuffer delete(start,end):包含头不包含尾。
		  StringBuffer delete(int index):删除指定位置的元素。
		 3,查找：
		  char charAt(index);
		  int indexOf(String);
		  int lastIndexOf(String);
		 4.修改：
		   StringBuffer replace(start,end,string);
		   void setCharAt
		   
		*/
		bufferMethodDemo_1();
	}
	private static void bufferMethodDemo_1() {
		StringBuffer sb = new StringBuffer("abcde");
		sb.delete(1, 3);
		sb.setLength(10);
		System.out.println(sb);
	}
	public static void bufferMethodDemo() {
		
		StringBuffer sb = new StringBuffer();
	    sb.append(4);
 		sb.append(true);
		sb.insert(1,"haha");
		System.out.println(sb);
	}

}
