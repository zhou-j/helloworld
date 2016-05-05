package com.blog.util;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * 
 * 类名: TmFunctions
 * 描述: jsp函数自定义的标签类
 * 创建人: zhoujuan
 * 时间: 2016年3月3日 下午9:50:39
 * @version: V1.0
 */
public class TmFunctions {
    /*
     * 为什么学习自定义标签:第一灵活,简单,复用性强。
     */
    
	/**
	 * 
	 * 方法名: toUpper
	 * 描述: 将字符串转换成大写。
	 * 创建人: zhoujuan
	 * 时间: 2016年3月3日 下午9:55:13
	 * @param content
	 * @return
	 * @return: String
	 * @since: V1.0
	 *System.out.println(dateFormat("2014-12-12 13:12:12","yyyy"));//年份
	  System.out.println(dateFormat("2014-12-12 13:12:12","MM"));//年份
	  System.out.println(dateFormat("2014-12-12 13:12:12","dd"));//年份
	  System.out.println(dateFormat("2014-12-12 13:12:12","yyyy-MM"));//年，月份	
	  System.out.println(dateFormat("2014-12-12 13:12:12","yyyy-MM-dd"));//年月日	
	  System.out.println(dateFormat("2014-12-12 13:12:12","yyyy-MM-dd HH"));//24小时	
	  System.out.println(dateFormat("2014-12-12 13:12:12","yyyy-MM-dd hh"));//12小时	
	  System.out.println(dateFormat("2014-12-12 13:12:12","yyyy-MM-dd HH:mm"));//年月日,时分	
	  System.out.println(dateFormat("2014-12-12 13:12:12","yyyy-MM-dd HH:mm:ss"));//年月日，时分秒	
	 */
	public static String toUpper(String content){
		if(StringUtil.isEmpty(content))return null;
		return content.toUpperCase();
	}
	
	public static String dateFormat(String dateString,String format){
		if(StringUtil.isEmpty(dateString))return "";
		Date date;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateString);
			String ds = new SimpleDateFormat(format).format(date);
			return ds;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			return "";
		}
	}
	public static String dateFormat(Date date,String format){
		if(date==null)return null;
		try {
			String ds = new SimpleDateFormat(format).format(date);
			return ds;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}	    
        
	}

	/**
	 * 空判断 方法名：isEmpty<BR>
	 * 创建人：潭州学院-keke <BR>
	 * 时间：2014年11月11日-下午10:19:52 <BR>
	 * 
	 * @param content
	 * @return boolean<BR>
	 * @exception <BR>
	 * @since 1.0.0
	 */
	public static boolean isEmpty(String content) {
		return StringUtil.isEmpty(content);
	}

	/**
	 * 非判断 方法名：isNotEmpty<BR>
	 * 创建人：潭州学院-keke <BR>
	 * 时间：2014年11月11日-下午10:20:07 <BR>
	 * 
	 * @param content
	 * @return boolean<BR>
	 * @exception <BR>
	 * @since 1.0.0
	 */
	public static boolean isNotEmpty(String content) {
		return !isEmpty(content);
	}

	public static String getWeekChinesee(int week) {
		String cweek = "";
		if (week == 1)
			cweek = "一";
		if (week == 2)
			cweek = "二";
		if (week == 3)
			cweek = "三";
		if (week == 4)
			cweek = "四";
		if (week == 5)
			cweek = "五";
		if (week == 6)
			cweek = "六";
		if (week == 7)
			cweek = "日";
		return cweek;
	}

	public static String getCharacter(int num) {
		String cweek = "";
		if (num == 1)
			cweek = "A";
		if (num == 2)
			cweek = "B";
		if (num == 3)
			cweek = "C";
		if (num == 4)
			cweek = "D";
		if (num == 5)
			cweek = "E";
		if (num == 6)
			cweek = "F";
		if (num == 7)
			cweek = "G";
		if (num == 8)
			cweek = "H";
		if (num == 9)
			cweek = "I";
		if (num == 10)
			cweek = "J";
		if (num == 11)
			cweek = "K";
		if (num == 12)
			cweek = "M";
		if (num == 13)
			cweek = "L";
		if (num == 14)
			cweek = "N";
		if (num == 15)
			cweek = "O";
		if (num == 16)
			cweek = "P";
		if (num == 17)
			cweek = "Q";
		if (num == 18)
			cweek = "R";
		if (num == 19)
			cweek = "S";
		if (num == 20)
			cweek = "T";
		if (num == 21)
			cweek = "U";
		if (num == 22)
			cweek = "V";
		if (num == 23)
			cweek = "W";
		if (num == 24)
			cweek = "X";
		if (num == 25)
			cweek = "Y";
		if (num == 26)
			cweek = "Z";
		return cweek;
	}

	/**
	 * 日期具体的几秒钟以前 方法名：dateString<BR>
	 * 创建人：潭州学院-keke <BR>
	 * 时间：2014年11月11日-下午10:34:33 <BR>
	 * 
	 * @param startTime
	 * @return String<BR>
	 * @exception <BR>
	 * @since 1.0.0
	 */
	public static String dateToString(String startTime) {
		return TmDateUtil.getTimeFormat(startTime);
	}

	/**
	 * 日期具体的几秒钟以前 方法名：dateToString2<BR>
	 * 创建人：潭州学院-keke <BR>
	 * 时间：2014年11月11日-下午10:38:06 <BR>
	 * 
	 * @param startTime
	 * @return String<BR>
	 * @exception <BR>
	 * @since 1.0.0
	 */
	public static String dateToString2(Date startTime) {
		return TmDateUtil.getTimeFormat(startTime);
	}

	/**
	 * 将数字转换成对应的中文 方法名：intToChnNumConverter<BR>
	 * 创建人：潭州学院-keke <BR>
	 * 时间：2014年11月11日-下午10:33:30 <BR>
	 * 
	 * @param num
	 * @return String<BR>
	 * @exception <BR>
	 * @since 1.0.0
	 */
	public static String intToChnNumConverter(int num) {
		String resultNumber = null;
		if (num > 10000 || num < 0) {
			return "";
		}
		HashMap chnNumbers = new HashMap();
		chnNumbers.put(0, "零");
		chnNumbers.put(1, "一");
		chnNumbers.put(2, "二");
		chnNumbers.put(3, "三");
		chnNumbers.put(4, "四");
		chnNumbers.put(5, "五");
		chnNumbers.put(6, "六");
		chnNumbers.put(7, "七");
		chnNumbers.put(8, "八");
		chnNumbers.put(9, "九");

		HashMap unitMap = new HashMap();
		unitMap.put(1, "");
		unitMap.put(10, "十");
		unitMap.put(100, "百");
		unitMap.put(1000, "千");
		int[] unitArray = { 1000, 100, 10, 1 };

		StringBuilder result = new StringBuilder();
		int i = 0;
		while (num > 0) {
			int n1 = num / unitArray[i];
			if (n1 > 0) {
				result.append(chnNumbers.get(n1)).append(unitMap.get(unitArray

				[i]));
			}
			if (n1 == 0) {
				if (result.lastIndexOf("零") != result.length() - 1) {
					result.append("零");
				}
			}
			num = num % unitArray[i++];
			if (num == 0) {
				break;
			}
		}
		resultNumber = result.toString();
		if (resultNumber.startsWith("零")) {
			resultNumber = resultNumber.substring(1);
		}
		if (resultNumber.startsWith("一十")) {
			resultNumber = resultNumber.substring(1);
		}
		return resultNumber;
	}

	/**
	 * 
	 * 方法名：cutContent<BR>
	 * 创建人：潭州学院-keke <BR>
	 * 时间：2014年11月14日-上午12:27:16 <BR>
	 * 
	 * @param content
	 * @param begin
	 * @param end
	 * @return String<BR>
	 * @exception <BR>
	 * @since 1.0.0
	 */
	public static String cutContent(String content,int begin,int end){
		if(StringUtil.isEmpty(content))return "";
		String start = "";
		String result = "";
		System.out.println(content.length());
		if(content.length() > end){
			start = content.substring(begin,end);
			result = "<span style='display:none;'>"+content.substring(end,content.length())+"</span>";
			return start+result+"<a onclick='tm_show_expand(this)' href='javascript:void(0)'>展开</a>";
		}else{
			return content;
		}
	}

	public static String countFileSize(long fileSize) {
		String fileSizeString = "";
		try {
			DecimalFormat df = new DecimalFormat("#.00");
			long fileS = fileSize;
			if (fileS == 0) {
				fileSizeString = "0KB";
			} else if (fileS < 1024) {
				fileSizeString = df.format((double) fileS) + "B";
			} else if (fileS < 1048576) {
				fileSizeString = df.format((double) fileS / 1024) +

				"KB";
			} else if (fileS < 1073741824) {
				fileSizeString = df.format(((double) fileS / 1024 /

				1024) - 0.01) + "MB";
			} else {
				fileSizeString = df.format((double) fileS / 1024 /

				1024 / 1024) + "G";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileSizeString;
	}	
	public static void main(String[] args) {
/*	  System.out.println(dateFormat("2014-12-12 13:12:12","yyyy"));//年份
	  System.out.println(dateFormat("2014-12-12 13:12:12","MM"));//年份
	  System.out.println(dateFormat("2014-12-12 13:12:12","dd"));//年份
	  System.out.println(dateFormat("2014-12-12 13:12:12","yyyy-MM"));//年，月份	
	  System.out.println(dateFormat("2014-12-12 13:12:12","yyyy-MM-dd"));//年月日	
	  System.out.println(dateFormat("2014-12-12 13:12:12","yyyy-MM-dd HH"));//24小时	
	  System.out.println(dateFormat("2014-12-12 13:12:12","yyyy-MM-dd hh"));//12小时	
	  System.out.println(dateFormat("2014-12-12 13:12:12","yyyy-MM-dd HH:mm"));//年月日,时分	
	  System.out.println(dateFormat("2014-12-12 13:12:12","yyyy-MM-dd HH:mm:ss"));//年月日，时分秒		  
*/	

    }
}
