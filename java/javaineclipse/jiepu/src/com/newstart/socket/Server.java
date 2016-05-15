package com.newstart.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {	
	//用户集合
	private static ArrayList<Socket> list = new ArrayList<Socket>();         
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// 服务端接收客户端发送过来的数据，并打印在控制台上。
        //用户。
		Socket s = null;	         
        //用户ip
        String ip = null;	         
        try {	             
            //构建服务器对象
            ServerSocket ss = new ServerSocket(1234);	             
            //构建用户集合
            list = new ArrayList<Socket>();	             
            System.out.println("服务器准备就绪...");	             
            //循环监听
            while(true){	                 
                //上线用户
                s = ss.accept();	                 
                //上线的人都添加到集合中。
                list.add(s);	                 
                //获取Socket IP
                ip = s.getInetAddress().getHostAddress();
                System.err.println( ip + " 用户上线了，当前采集数据的客户端个数为： " + list.size() + "个 !" );	                 
                //构建发送信息线程
                Receive receive = new Receive(s);
                receive.start();
                if(receive.isClose==false){
                	receive.interrupt();
                }
            }	             
        } catch (IOException e) {
            //用户下线。
            list.remove(s);
            System.err.println(ip + " 已下线，当前采集数据的客户端个数为: " + list.size() + " 个 !");
        }
	}

	public static ArrayList<Socket> getList() {
		return list;
	}

	public static void setList(ArrayList<Socket> list) {
		Server.list = list;
	}   

}
