package cn.itcast.string.demo;

public class StringTest_3 {

	public static void main(String[] args) {

		String s1 = "qwerabcdtyuiop";
		String s2 = "xcabcdvbn";

		String s = getMaxSubstring(s1, s2);
		System.out.println("s=" + s);

	}

	public static String getMaxSubstring(String s1, String s2) {

		for (int i = 0; i < s2.length(); i++) {
			for (int a = 0, b = s2.length() - i; b != s2.length() + 1; a++, b++) {
				String sub = s2.substring(a, b);
				if (s1.contains(sub))
				return sub;
			}
		}
		return null;
	}

}
