package cn.itcast.net.uploadpic;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadPicServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//创建tcp的socket服务端。
		ServerSocket ss = new ServerSocket(10008);
		
		
		while(true){
			
			//获取客户端。
			Socket s = ss.accept();	
			
			new Thread(new UploadTask(s)).start();
			
		}
		
		
		
		
//		ss.close();
	}

}
