package cn.itcast.string.demo;

public class StringTest_2 {

	public static void main(String[] args) {
		String str = "nbaernbauinbaopnbanba";
		String key = "nba";
		
		int count = getkeyStringCount2(str,key);
		System.out.println("count="+count);

	}

	public static int getkeyStringCount2(String str, String key) {
		
		int count = 0 ;
		int index = 0 ;
		while((index = str.indexOf(key,index))!=-1){
			index = index +key.length();
			count++;
		}
		return count;
	}

	public static int getkeyStringCount(String str, String key) {
		int count = 0 ;
		int index = 0 ;
		while((index = str.indexOf(key))!=-1)
				{
			      str = str.substring(index+key.length());
			      count++ ;
				}
		return count;
	}

}
