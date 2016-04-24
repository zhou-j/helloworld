package cn.itcast.net.ie_server;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyTomcat {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket ss = new ServerSocket(9090);
		
		Socket s = ss.accept();
		
		InputStream in = s.getInputStream();
		
		byte[] buf = new byte[1024];
		
		int len = in.read(buf);
		String text = new String(buf,0,len);
		System.out.println(text);
		
		
		//给客户端一个反馈信息。
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		
		out.println("欢迎光临");
		
		s.close();
		ss.close();

	}

}
