package com.newstart.socket;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.List;
import org.apache.struts2.json.JSONUtil;
import com.newstart.bean.CountMessageBean;
import com.newstart.collection.Message;
import com.newstart.properties.Configuration;
import com.newstart.util.ObjectToFile;

public class Client {
	private static List<CountMessageBean> countbeans = null;
	public static void main(String[] args) {
		/*
		 * Tcp传输,客户端建立的过程。 
		 * 1.创建Tcp客户端socket服务。使用的是Socket对象。建议该对象一创建就明确目的地。要连接的主机。
		 * 2.如果连接建立成功，说明数据传输通道已经建立。该同道就是socket流，是底层建立好的。既然是流，说明这里既有输入，又有输出。 想要输入或者输出流对象，可以找Socket来获取。 可以通过getOutputStream（），和getInputStream（）来获取两个字节流。 
		 * 3.使用输出流，将数据写出。
		 * 4.关闭资源。
		 */
		try {
			// 创建客户端socket服务
			Socket socket = new Socket("127.0.0.1", 1234);
			// 获取socket流中的输出流。
			OutputStream out = socket.getOutputStream();
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
			// 使用输出流将指定的数据写出去。
			countbeans = Message.collectionMessage();
			Configuration rc = new Configuration("D:\\jiepu\\temp\\collection.properties");// 相对路径			
			String flag = rc.getValue("flag");
			if(flag.equals("true")){				
				//获取连接出现异常的时候保存的采集信息。
				List<CountMessageBean> exceptionbeans= (List<CountMessageBean>) ObjectToFile.readObjectFromFile("D:\\jiepu\\exception.dat");
				countbeans.addAll(exceptionbeans);
				rc.setValue("flag", "false");
				rc.saveFile("D:\\jiepu\\temp\\collection.properties", "Test");				
			}
			String json = JSONUtil.serialize(countbeans);
			bw.write(json);
			bw.write("\n");
			// 关闭资源。
			bw.close();
			socket.close();
		} catch (Exception e) {
			Configuration rc = new Configuration("D:\\jiepu\\temp\\collection.properties");// 相对路径			
			ObjectToFile.writeObjectToFile(countbeans,"D:\\jiepu\\exception.dat");
			rc.setValue("flag", "true");
			rc.saveFile("D:\\jiepu\\temp\\collection.properties", "Test");			
			System.out.println("main异常：" + e.getMessage()+"数据已备份！");
		}
	}
}
