package com.newstart.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.newstart.bean.CountMessageBean;
import com.newstart.collection.Message;
import com.newstart.dao.SaveDao;

/**
 * 
 * 类名: Receive
 * 描述: 接受并且保存用户收费信息。
 * 创建人: zhoujuan
 * 时间: 2016年5月12日 下午7:32:08
 * @version: V1.0
 */
public class Receive extends Thread {
	private Socket s;
	private int savecount;
	volatile boolean isClose = true;

	public Receive(Socket s) {
		this.s = s;
	}

	public void run() {
		try {
			String ip = s.getInetAddress().getHostAddress();
			// 构建输入流
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			// 不断的接收信息
			while (isClose) {
				String info = null;
				// 接收信息
				if ((info = br.readLine()) != null) {
					List<CountMessageBean> listBeans = Message.jsonToList(info);
					savecount = listBeans.size();
					SaveDao.saveMessage(listBeans);
				} else {
					isClose = false;
				}
			}
			// 保存日志。
			PropertyConfigurator.configure("..//jiepu//src//log4j.properties");
			Logger logger = Logger.getLogger(Receive.class);
			logger.info("当前操作的用户ip为:" + ip + "  保存到数据库的信息的条数为:" + savecount+ "条   数据保存成功！");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
