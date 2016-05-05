package com.tz.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

/**
 * 音乐歌词解析工具类 
 * @author arry
 * @version v1.0
 * 
 */
public class MusicUtil {

	/**
	 * 获取音乐歌词 
	 * @param request 服务器请求
	 * @return String 歌词
	 * 
	 */
	public static String getLrc(HttpServletRequest request){
		
		StringBuffer buffer = new StringBuffer();
		
		// 获取音乐名称
		String musicName = request.getParameter("name"); 
		// 获取音乐对应的歌词路径
		String filePath = request.getRealPath("mp3") + "/" + musicName + ".lrc";
		
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		try{
			// 开始读取歌词文件
			fis = new FileInputStream(filePath);
			isr = new InputStreamReader(fis, "utf-8");
			// 获取歌词文件缓冲流，进行读取
			br = new BufferedReader(isr);
			
			// 建立临时文件
			String temp = null;
			while((temp = br.readLine()) != null){
				buffer.append(temp);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		} finally{
			try {
				if(br != null){
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(fis != null){
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return buffer.toString();
		
	}
	
	// java入口
	public static void main(String[] args){
		
		System.out.println("亲爱的同学们，大家晚上好！ 我爱你们 ^_^");
		
	}
	
}
