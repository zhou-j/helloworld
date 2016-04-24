package cn.itcast.string.demo;

public class StringTest_4 {

	public static void main(String[] args) {

		String s = "    ab   c   ";

		s = MyTrim(s);
		System.out.println("-" + s + "-");

	}

	public static String MyTrim(String s) {

		int start = 0, end = s.length() - 1;
		while (start <= end && s.charAt(start) == ' ') {
			start++;
		}
		while (start <= end && s.charAt(end) == ' ') {
			end--;
		}
		return s.substring(start, end + 1);
	}

}
