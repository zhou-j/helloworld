import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountString {

	public static int count = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader bufr0 = new BufferedReader(new InputStreamReader(System.in));
                String line0 = null;
		
		while((line0=bufr0.readLine())!=null){
			if(line0.equals(line0))
				break;
		}
		BufferedReader bufr = new BufferedReader(
				new FileReader("D:\\test.java"));
		String line = null;

		while ((line = bufr.readLine()) != null) {

			if ("over".equals(line))
				break;
			String[] s = line.toString().split(" ");
			for (int i = 0; i < s.length; i++) {

				if (s[i].equals(line0))
					count++;
			}

		}
                bufr0.close();
		bufr.close();
		System.out.println(count);
	}

}