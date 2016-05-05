package com.blog.util;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtil {

	/**
	 * 灏嗕竴涓棩鏈熻浆鎹㈡垚String 
	 * 鏂规硶鍚嶏細getDateString<BR>
	 * 鍒涘缓浜猴細xuchengfei <BR>
	 * 鏃堕棿锛�014骞�鏈�1鏃�涓嬪崍9:59:14 <BR>
	 * 
	 * @param date
	 * @param pattern
	 * @return String<BR>
	 * @exception <BR>
	 * @since 1.0.0
	 */
	public static String formatDateToString(Date date, String pattern) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat.format(date);
	}

	/**
	 * 灏嗘棩鏈熷瓧绗︿覆杞崲鎴怐ate 鏂规硶鍚嶏細getDateString<BR>
	 * 鍒涘缓浜猴細xuchengfei <BR>
	 * 鏃堕棿锛�014骞�鏈�1鏃�涓嬪崍10:04:06 <BR>
	 * 
	 * @param dateString
	 * @param pattern
	 * @return
	 * @throws ParseException
	 *             Date<BR>
	 * @exception <BR>
	 * @since 1.0.0
	 */
	public static Date parseStringToDate(String dateString, String pattern)
			throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat.parse(dateString);
	}

	/**
	 * 
	 * 灏嗗皬鏁版牸寮忓寲鎴愬瓧绗︿覆锛屼細杩涜鍥涜垗浜斿叆 濡傦細3656.4554===缁撴灉:3656.46<BR>
	 * 鏂规硶鍚嶏細formatDoubleToString<BR>
	 * 鍒涘缓浜猴細xuchengfei <BR>
	 * 鏃堕棿锛�014骞�鏈�2鏃�涓嬪崍9:12:01 <BR>
	 * 
	 * @param dou
	 * @return String<BR>
	 * @exception <BR>
	 * @since 1.0.0
	 */
	public static String formatDoubleToString(double dou,String format) {
		if(isEmpty(format))format = "#.##";
		DecimalFormat decimalFormat = new DecimalFormat(format);
		String string = decimalFormat.format(dou);// 鍥涜垗浜斿叆锛岄�浜旇繘涓�
		return string;
	}
	
	
	/**
	 * 鍒ゆ柇瀛楃涓叉槸鍚︿负绌�
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return null == str || str.length() == 0 || "".equals(str)
				|| str.matches("\\s*");
	}
	
	/**
	 * 闈炵┖鍒ゆ柇
	 * (杩欓噷鐢ㄤ竴鍙ヨ瘽鎻忚堪杩欎釜鏂规硶鐨勪綔鐢�<BR>
	 * 鏂规硶鍚嶏細isNotEmpty<BR>
	 * 鍒涘缓浜猴細xuchengfei <BR>
	 * 鏃堕棿锛�014骞�鏈�2鏃�涓嬪崍9:36:18 <BR>
	 * @param str
	 * @return boolean<BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}
	
	
	/**
	 * 鐧惧垎姣旇浆鎹�
	 * 鏂规硶鍚嶏細getPercent<BR>
	 * 鍒涘缓浜猴細xuchengfei <BR>
	 * 鏃堕棿锛�014骞�鏈�2鏃�涓嬪崍9:50:46 <BR>
	 * @param num
	 * @param totalCount
	 * @param format
	 * @return String<BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	public static String getPercent(int num,double totalCount,String...objects){
		String format = "#.##";
		if(objects!=null && objects.length>0){
			format = objects[0];
		}
		return StringUtil.formatDoubleToString((num/totalCount)*100,format)+"%";
	}
	
	/**
	 * 鐧惧垎姣旇浆鎹�
	 * 鏂规硶鍚嶏細getPercent<BR>
	 * 鍒涘缓浜猴細xuchengfei <BR>
	 * 鏃堕棿锛�014骞�鏈�2鏃�涓嬪崍9:50:46 <BR>
	 * @param num 褰撳墠鐨勬暟瀛�
	 * @param totalCount 鎬绘暟
	 * @param format 
	 * @return String<BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	public static String getPercent(int num,float totalCount,String...objects){//鍔ㄦ�鍙傛暟
		String format = "#.##";
		if(objects!=null && objects.length>0){
			format = objects[0];
		}
		return StringUtil.formatDoubleToString((num/totalCount)*100,format)+"%";
	}
	
	
	
	/**
	 *鍐掓场鎺掑簭鏂规硶,濡傛灉涓簍rue閭ｅ氨鏄檷搴忥紝false閭ｄ箞涔呮槸鍗囧簭 
	 * 鏂规硶鍚嶏細sorts<BR>
	 * 鍒涘缓浜猴細xuchengfei <BR>
	 * 鏃堕棿锛�014骞�鏈�2鏃�涓嬪崍11:35:55 <BR>
	 * @param datas
	 * @param flag
	 * @return int[]<BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	public static int[] sorts(int[] datas,boolean flag){
		for (int i = 0; i < datas.length; i++) {//杞娆℃暟
			for(int j=0; j < datas.length-1; j++){//浜ゆ崲娆℃暟
				if(flag){ 
					if(datas[j] < datas[j+1]){
						int temp = datas[j];
						datas[j] = datas[j+1];
						datas[j+1] = temp;
					}
				}else{
					if(datas[j] < datas[j+1]){
						int temp = datas[j];
						datas[j] = datas[j+1];
						datas[j+1] = temp;
					}
				}
			}
		}
		return datas;
	}
	
	/**
	 * 鍑痉鍔犲瘑
	 * 鏂规硶鍚嶏細encryption<BR>
	 * 鍒涘缓浜猴細xiaowei <BR>
	 * 鏃堕棿锛�014骞�0鏈�5鏃�涓嬪崍9:48:19 <BR>
	 * @param str
	 * @param k
	 * @return String<BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	public static String encryption(String str,int k){
		String string = "";
		for (int i = 0; i < str.length(); i++) {
			char c= str.charAt(i);
			if(c>='a' && c<='z'){
				c += k%26;
				if(c<'a'){
					c+=26;
				}
				if(c>'z'){
					c-=26;
				}
			}else if(c>='A' && c<='Z'){
				c+=k%26;
				if(c<'A'){
					c+=26;
				}
				if(c>'Z'){
					c-=26;
				}
			}
			string+=c;
		}
		return string;
	}
	
	/**
	 * 鍑痉瑙ｅ瘑
	 * 鏂规硶鍚嶏細dencryption<BR>
	 * 鍒涘缓浜猴細xiaowei <BR>
	 * 鏃堕棿锛�014骞�0鏈�5鏃�涓嬪崍9:48:35 <BR>
	 * @param str
	 * @param n
	 * @return String<BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	public static String dencryption(String str,int n){
		String string = "";
		int k = Integer.parseInt("-"+n);
		for (int i = 0; i < str.length(); i++) {
			char c= str.charAt(i);
			if(c>='a' && c<='z'){
				c += k%26;
				if(c<'a'){
					c+=26;
				}
				if(c>'z'){
					c-=26;
				}
			}else if(c>='A' && c<='Z'){
				c+=k%26;
				if(c<'A'){
					c+=26;
				}
				if(c>'Z'){
					c-=26;
				}
			}
			string+=c;
		}
		return string;
	}
	
}



