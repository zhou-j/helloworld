package com.tanzhou.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TmFunctions {
	
	public static boolean isEmpty(String content){
		return StringUtil.isEmpty(content);
	}
	
	/**
	 * 
	 * 方法名: sex
	 * 描述: 处理性别。
	 * 创建人: zhoujuan
	 * 时间: 2016年2月25日 下午9:16:35
	 * @param male
	 * @return
	 * @return: String
	 * @since: V1.0
	 */
	public static String sex(int male){
		String result = null;
		if(male==1){
			result = "男";
		}else if(male==0){
			result = "女";
		}else if(male==2){
			result = "保密";
		}
		return result;
	}
	
	/**
	 * 
	 * 方法名: formatDate
	 * 描述: 格式化日期。
	 * 创建人: zhoujuan
	 * 时间: 2016年2月25日 下午9:16:00
	 * @param date
	 * @param pattern
	 * @return
	 * @return: String
	 * @since: V1.0
	 */
	public static String formatDate(Date date,String pattern){
		if(pattern==null || pattern.equals(""))pattern = "yyyy-MM-dd HH:mm:ss";
		java.text.SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(date);
	}
}