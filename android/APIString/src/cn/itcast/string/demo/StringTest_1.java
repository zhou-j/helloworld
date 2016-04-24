package cn.itcast.string.demo;

public class StringTest_1 {

	public static void main(String[] args) {
		String str[] = { "nba", "abc", "cba", "zz", "qq", "haha" };
		for (int i = 0; i < 5; i++) {
			for (int j = 5; j >= i + 1; j--) {
				if (str[j].compareTo(str[j - 1]) < 0) {
					String temp = str[j - 1];
					str[j - 1] = str[j];
					str[j] = temp;
				}
			}
		}
		for (int n = 0; n < 6; n++) {
			System.out.print(str[n]+" ");
		}
	}

}
