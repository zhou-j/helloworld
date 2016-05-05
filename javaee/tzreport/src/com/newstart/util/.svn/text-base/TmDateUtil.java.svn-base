package com.newstart.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * 类名: TmDateUtil
 * 描述: 日期的工具类
 * 创建人: zhoujuan
 * 时间: 2016年3月4日 下午8:16:15
 * @version: V1.0
 */
public class TmDateUtil {

/**
 * 
 * 方法名: dateToString
 * 描述: 日期转换
 * 创建人: zhoujuan
 * 时间: 2016年3月4日 下午8:16:38
 * @param time
 * @return
 * @return: Date
 * @since: V1.0
 */
	public static Date dateToString(String time){
		Date startTime = null;
		try {
			 startTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return startTime;
	}
	
	
/**
 * 
 * 方法名: getTimeFormat
 * 描述: TODO
 * 创建人: zhoujuan
 * 时间: 2016年3月4日 下午8:17:55
 * @param startTime
 * @return
 * @return: String
 * @since: V1.0
 */
	public static String getTimeFormat(String startTime){
		return getTimeFormat(dateToString(startTime));
	}
	
/**
 * 
 * 方法名: getTimeFormat
 * 描述: 获取几分钟前，几年前。
 * 创建人: zhoujuan
 * 时间: 2016年3月4日 下午8:18:09
 * @param startTime
 * @return
 * @return: String
 * @since: V1.0
 */
	public static String getTimeFormat(Date startTime){
		try{
			long startTimeMills = startTime.getTime();
			long endTimeMills = System.currentTimeMillis();
			long diff = (endTimeMills - startTimeMills)/1000;//秒
			long day_diff  = (long) Math.floor(diff/86400);//天
			StringBuffer buffer = new StringBuffer();
			if(day_diff<0){
				return "[error],时间越界.....";
			}else{
				if(day_diff==0 && diff<60){
					if(diff==0)diff=1;
					buffer.append(diff+"秒前");
				}else if(day_diff==0 && diff<120){
					buffer.append("1分钟前");
				}else if(day_diff==0 && diff<3600){
					buffer.append(Math.round(Math.floor(diff/60))+"分钟以前");
				}else if(day_diff==0 && diff<7200){
					buffer.append("1小时前");
				}else if(day_diff==0 && diff<86400){
					buffer.append(Math.round(Math.floor(diff/3600))+"小时前");
				}else if(day_diff==1){
					buffer.append("1天前");
				}else if(day_diff<7){
					buffer.append(day_diff+"天前");
				}else if(day_diff <30){
					buffer.append(Math.round(Math.ceil( day_diff / 7 )) + "星期前");
				}else if(day_diff >=30 && day_diff<=179 ){
					buffer.append(Math.round(Math.ceil( day_diff / 30 )) + "月前");
				}else if(day_diff >=180 && day_diff<365){
					buffer.append("半年前");
				}else if(day_diff>=365){
					buffer.append(Math.round(Math.ceil( day_diff /30/12))+"年前");
				}
			}
			return buffer.toString();
		}catch(Exception ex){
			return "";
		}
	}
}
