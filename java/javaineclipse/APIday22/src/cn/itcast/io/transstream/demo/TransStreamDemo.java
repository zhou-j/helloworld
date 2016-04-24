package cn.itcast.io.transstream.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class TransStreamDemo {

	public static void main(String[] args) throws IOException {
		//字节流。
		InputStream in = System.in;
//		int ch = in.read();
//		System.out.println(ch);
//		int ch1 = in.read();
//		System.out.println(ch1);
		
		
		//将字节转成字符的桥梁。转换流。
		InputStreamReader isr = new InputStreamReader(in);
//       
//		int ch = isr.read();
//		System.out.println((char)ch);
		//字符流。
		BufferedReader bufr = new BufferedReader(isr);
        OutputStream out = System.out;
        
        OutputStreamWriter osw = new OutputStreamWriter(out);
		
		BufferedWriter bufw = new BufferedWriter(osw);
		
		
		
		
		String line = null;
		
		while((line=bufr.readLine())!=null){
			if("over".equals(line))
				break;
	//		System.out.println(line.toUpperCase());
//			osw.write(line.toUpperCase()+"\r\n");
//			osw.flush();
			
			bufw.write(line.toUpperCase());
			bufw.newLine();
			bufw.flush();
			
		}
        
	}
	 

}
