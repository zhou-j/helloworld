package cn.itcast.io.filewrite;

import java.io.FileWriter;
import java.io.IOException;

public class IOExceptionDemo {

	private static final String LINE_SPARATOR = System.getProperty("line.separator");

	public static void main(String[] args) {//throws IOException {
        FileWriter fw = null;
        try{
        	fw = new FileWriter("k:\\demo.txt");
        	fw.write("abcde"+LINE_SPARATOR+"hahaha");
        
        }catch(IOException e){
        	System.out.println(e.toString());
        }finally{
        	if(fw!=null)
        		try{
        			fw.close();
        		}catch(IOException e){
        			//code....
        			throw new RuntimeException("πÿ±’ ß∞‹");
        		}
        }
		
		
		 
	}

}
