package com.newstart.collection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import com.newstart.bean.CountMessageBean;
import com.newstart.bean.MessageBean;
import com.newstart.properties.Configuration;
import com.newstart.util.ObjectToFile;

public class Message {
    /**
     * 
     * 方法名: getMessage
     * 描述: 获取用户信息。
     * 创建人: zhoujuan
     * 时间: 2016年5月15日 上午11:03:25
     * @return
     * @throws IOException
     * @return: List<MessageBean>
     * @since: V1.0
     */
	public static List<MessageBean> getMessage()throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bufr = new BufferedReader(new FileReader("D:\\jiepu\\radwtmp"));
		String line = null;
	    List<MessageBean> beans = null; 
		beans = new ArrayList<MessageBean>();
		Configuration rc = new Configuration("D:\\jiepu\\temp\\collection.properties");
		int n = Integer.valueOf(rc.getValue("n"));
		long temp = Integer.valueOf(n);
		bufr.skip(temp);
		while ((line = bufr.readLine()) != null) {
			//System.out.println(line);
			n = n + line.length()+2;
			String[] s = line.split("\\|");
			MessageBean bean = null;
		    bean = new MessageBean();
            bean.setUsername(s[0].substring(1));
            bean.setUserterminator(s[1]);
            bean.setTag(s[2]);
            bean.setTime(s[3]);
            bean.setIpaddress(s[4]);
            beans.add(bean);
		}
		rc.setValue("n", String.valueOf(n));
		rc.saveFile("D:\\jiepu\\temp\\collection.properties", "test");		
		bufr.close();
		return beans;
	}

    /**
     * 
     * 方法名: collectionMessage
     * 描述: 用户收费数据采集。
     * 创建人: zhoujuan
     * 时间: 2016年5月15日 上午11:04:49
     * @return
     * @throws Exception
     * @return: List<CountMessageBean>
     * @since: V1.0
     */
	public static List<CountMessageBean> collectionMessage() throws Exception {
		List<CountMessageBean> countbeans = new ArrayList<CountMessageBean>();
		List<MessageBean> beans = getMessage();
		List<MessageBean> uplinebeans = new ArrayList<MessageBean>();
		List<MessageBean> readbeans = (List<MessageBean>)ObjectToFile.readObjectFromFile("D:\\jiepu\\upline.dat");
		if (readbeans != null) {
			uplinebeans.addAll(readbeans);
		}
		for (MessageBean bean : beans) {
			if (bean.getTag().equals("7")) {
				uplinebeans.add(bean);
			}
		}
		List<MessageBean> unmatchbeans = new ArrayList<MessageBean>();
		for (Iterator<MessageBean> it = uplinebeans.iterator(); it.hasNext();) {
			MessageBean uplinebean = (MessageBean) it.next();
			for (Iterator<MessageBean> it2 = beans.iterator(); it2.hasNext();) {
				MessageBean bean = (MessageBean) it2.next();
				if (bean.getTag().equals("8") && uplinebean.getIpaddress().equals(bean.getIpaddress())) {
					CountMessageBean messagebean = new CountMessageBean();
					messagebean.setUsername(uplinebean.getUsername());
					messagebean.setDownlinetime(bean.getTime());
					messagebean.setIpaddress(bean.getIpaddress());
					messagebean.setUplinetime(uplinebean.getTime());
					messagebean.setUserterminator(bean.getUserterminator());
					countbeans.add(messagebean);
					it.remove();
					it2.remove();
					break;
				}
			};
		}
		unmatchbeans.addAll(uplinebeans);
		ObjectToFile.writeObjectToFile(unmatchbeans,"D:\\jiepu\\upline.dat");
		return countbeans;
	}

    /**
     * 
     * 方法名: jsonToList
     * 描述: 将json字符串转换成List<CountMessageBean>
     * 创建人: zhoujuan
     * 时间: 2016年5月15日 上午11:05:56
     * @param json
     * @return
     * @return: List<CountMessageBean>
     * @since: V1.0
     */
	public static List<CountMessageBean> jsonToList(String json) {
		String jsonstr = "{" + "data" + ":" + json + "}";
		JSONObject jsonObject = JSONObject.fromObject(jsonstr);
		String jsonArr = jsonObject.get("data").toString();
		JSONArray jsonArray = JSONArray.fromObject(jsonArr);
		List<CountMessageBean> userList = new ArrayList<CountMessageBean>();
		for (int i = 0; i < jsonArray.size(); i++) {
			CountMessageBean messagebean = (CountMessageBean)JSONObject.toBean(JSONObject.fromObject(jsonArray.get(i)),CountMessageBean.class);
			userList.add(messagebean);
		}
		return userList;
	}

}