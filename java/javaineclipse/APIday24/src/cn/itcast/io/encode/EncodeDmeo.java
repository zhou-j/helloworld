package cn.itcast.io.encode;

import java.io.IOException;

public class EncodeDmeo {

	public static void main(String[] args) throws IOException {
		
		/*
		 * 字符串--->字节数组：编码。
		 * 字符数组---->字符串：解码。
		 * 如果编错了，解不出来。
		 * 如果编对了，解错了，有可能有救。
		 * 
		 * */
		
		String str = "你好";
		
		//编码；
		byte[] buf = str.getBytes("gbk");
		
		printBytes(buf);
		String s1 = new String(buf,"iso8859-1");
		
//		System.out.println("s1="+s1);
         
		byte[] buf2 = s1.getBytes("iso8859-1");//获取源字节。
		String s2 = new String(buf2,"GBK");
		
		System.out.println("s2="+s2);
	}

	private static void printBytes(byte[] buf) {
		for(byte b:buf){
			System.out.print(b+", " );
		}
	}

}
