package com.tz.video;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Java开发网络视频上传组件 
 * @author arry
 * @version v1.0
 * 
 */
public class VideoUtil {

	
	/**
	 * 通过优酷的视频网站的视频详情页的url地址和页面的编码集，获取源代码
	 * @author arry
	 * @param url 网络视频的链接地址
	 * @param encoding 编码集
	 * @return String 网页的源代码
	 * 
	 */
	public static String getHtmlResourceByURL(String url,String encoding){

		String message = null;
		URL urlObj = null;
		URLConnection uc = null;
		InputStreamReader isr = null;
		BufferedReader buffer = null;
		
		// 存储源代码的容器
		StringBuffer strs = new StringBuffer();
		
		try {
			// 建立网络连接
			urlObj = new URL(url);
			// 打开网络连接
			uc = urlObj.openConnection();
			// 建立文件的写入流
			isr = new InputStreamReader(uc.getInputStream(), encoding);
			// 文件的缓冲写入流
			buffer = new BufferedReader(isr);
			
			String temp = null;
			while((temp = buffer.readLine()) != null){
				strs.append(temp+"\n");
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
			message = "您的网络连接失败！世界上最遥远距离就是没有网 ！设置网络";
		} catch (IOException e) {
			e.printStackTrace();
			message = "您的网络出现异常，打开失败 ！";
		} finally{
			if(isr != null){
				try {
					isr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		message = strs.toString();
		
		return message;
	}
	
	/**
	 * 解析优酷网页的源代码，获取视频信息
	 * @author arry
	 * @param html 源代码
	 * @return HashMap<String,String> 集合
	 * 
	 */
	public static HashMap<String,String> getVideo(String html){
		
		HashMap<String,String> map = new HashMap<String,String>();
		
		// 根据获取到的源代码 解析所需要的信息
		Document document = Jsoup.parse(html);
		// 解析优酷视频的源代码
		Element element = document.getElementById("panel_share");
		// 获取网页源代码中 具体的元素 class="item"
		Elements elements = element.getElementsByClass("item");
		
		int i = 1;
		for(Element ele : elements){
			Element e = ele.getElementById("link"+i);
			i++;
			if(e != null){
				System.out.println("id = "+i+" -  "+e.val());
				map.put("link"+i, e.val());
			}
		}		
		return map;
	}
	
	
	// Java入口
	public static void main(String[] args){
		
		System.out.println("我亲爱的同学们 ！ 大家晚上好，我爱你们 ！");
		
		// 通过优酷的视频网站的视频详情页的url地址和页面的编码集，获取源代码
		
		String url = "http://v.youku.com/v_show/id_XOTEzMTk5NDEy.html?f=23458321&ev=3&from=y1.3-idx-grid-1519-9909.86808-86807.3-2";
		String encoding = "utf-8";
		String html = getHtmlResourceByURL(url, encoding);
		
		// 根据获取到的源代码 解析所需要的信息
		Document document = Jsoup.parse(html);
		// 解析优酷视频的源代码
		Element element = document.getElementById("panel_share");
		// 获取网页源代码中 具体的元素 class="item"
		Elements elements = element.getElementsByClass("item");
		
		int i = 1;
		for(Element ele : elements){
			Element e = ele.getElementById("link"+i);
			i++;
			if(e != null){
				System.out.println("id = "+i+" -  "+e.val());
			}
		}
		
	}
	
	
}
