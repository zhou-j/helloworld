package cn.itcast.io.encode;

import java.io.IOException;

public class LianTong {

	public static void main(String[] args) throws IOException {
		
		String str = "ÁªÍ¨"; //11000001
		                    //10101010
		                    //11001101
		byte[] buf = str.getBytes("gbk");
		
		for(byte b:buf){
			System.out.println(Integer.toBinaryString(b));
		}

	}

}
