package cn.itcast.net.uploadtext;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class UploadClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		//1
		Socket s = new Socket("127.0.0.1",10005);
		
		//2
		BufferedReader bufr = new BufferedReader(new FileReader("d:\\client.txt"));
		
		//3
		PrintWriter out =new PrintWriter(s.getOutputStream(),true);
		
		String line = null;
		while((line=bufr.readLine())!=null){
			out.println(line);
		}
		
		out.println("over");
		
		//4.
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		String str = bufIn.readLine();
		System.out.println(str);
		
		bufr.close();
		s.close();

	}

}
