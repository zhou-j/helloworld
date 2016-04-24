package cn.itcast.net.ie_server;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyBrowser {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		Socket s = new Socket("127.0.0.1",9090);
		
		//模拟浏览器，给tomcat服务端发送符合HTTP协议的请求消息。
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		out.println("GET / HTTP/1.1/myweb/1.html");
		out.println("Accept: */*");
		out.println("Host:127.0.0.1:9090");
		out.println("Connection: Keep-Alive");
		
		InputStream in = s.getInputStream();
		
		byte[] buf = new byte[1024];
		int len = in.read(buf);
		
		String str = new String(buf,0,len);
		System.out.println(str);
		
		s.close();

	}

}
