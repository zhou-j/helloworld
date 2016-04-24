package cn.itcast.io.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountString {

	public static int count = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bufr = new BufferedReader(
				new FileReader("D:\\test.java"));
		String line = null;

		while ((line = bufr.readLine()) != null) {

			if ("over".equals(line))
				break;
			String[] s = line.toString().split(" ");
			for (int i = 0; i < s.length; i++) {

				if (s[i].equals("public"))
					count++;
			}

		}
		bufr.close();
		System.out.println(count);
	}

}
