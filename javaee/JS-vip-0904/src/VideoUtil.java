import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.lang.model.element.Element;
import javax.lang.model.util.Elements;


public class VideoUtil {
	
	/**
	 * 通过优酷的视频详情也的URL地址和页面的编码集，获取源代码
	 * @author er
	 * @param url 网络视屏的链接地址
	 * @param encoding 编码集
	 * @return string 网页的源代码
	 * 
	 * */
	public static String getHtmlResourceByURL(String url,String encoding){
		
		String message = null;
		URL urlObj = null;
		URLConnection uc = null;
		
		//存储源代码的 容器
		StringBuffer strs = new  StringBuffer();
		
		try{
		//建立网络连接
		 urlObj = new URL(url);
		//打开网络连接
		 uc = urlObj.openConnection();
		//建立文件的写入流
		InputStreamReader isr = new InputStreamReader(uc.getInputStream(),encoding);
		//文件的缓冲写入流
		BufferedReader buffer = new BufferedReader(isr);
		
		String temp = null;
		while((temp = buffer.readLine())!=null){
			strs.append(temp);
			
		}
	}catch(MalformedURLException e){
	     e.printStackTrace();
	     message = "您的网络连接失败！世界上最遥远的距离就是没有网！设置网络";
	
	}catch(IOException e){
		
		 e.printStackTrace();
		 message = "您的网络出现异常，打开失败！";
	}
		return null;
	}
	
	/**
	 * 解析优酷网页的源代码，获取视频信息
	 * @author jojo
	 * @param html 源代码
	 * @return HashMap<String,String>集合
	 * 
	 * */
	public static HashMap<String,String>getVideo(String html){
		HashMap
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//通过优酷的视频网站的视频详情页的URL地址和页面的编码集，获取源码
		String url = "";
		String encoding = "utf-8";
		String html = getHtmlResourceByURL(url,encoding);
		
		//根据获取到的源代码解析所需要的信息
		Document document = Jsoup.parse(html);
        //解析优酷视频的源代码
		Element element = document.getElementById("panel_share");
		//获取网页源代码中的具体的元素class='item';
		Elements elements = element.getElementsByClass("item");
		
		int i= 1;
		for(Element ele : elements){
			Element e =ele.getElementById("link"+i);
			i++;
			if(e!= null){
				
				System.out.println(e.)
			}
			
		}
	}

}
