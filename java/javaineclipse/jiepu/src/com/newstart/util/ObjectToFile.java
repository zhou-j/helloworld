package com.newstart.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 
 * 类名: ObjectToFile
 * 描述: 将对象保存到文件和从文件取出对象的类。
 * 创建人: zhoujuan
 * 时间: 2016年5月14日 下午3:33:54
 * @version: V1.0
 */
public class ObjectToFile {
    /**
     * 
     * 方法名: writeObjectToFile
     * 描述: 将对象写入文件中。
     * 
     * 注意：参数obj一定要实现Serializable接口，否则会抛出java.io.NotSerializableException异常。
     * 另外，如果写入的对象是一个容器，例如List、Map,也要保证容器中的每个元素也都实现了 Serializable接口。
     * 
     * 创建人: zhoujuan
     * 时间: 2016年5月14日 下午3:35:26
     * @param obj
     * @return: void
     * @since: V1.0
     */
	public static void writeObjectToFile(Object obj,String url)
    {
        File file =new File(url);
        FileOutputStream out;
        try {
            out = new FileOutputStream(file);
            ObjectOutputStream objOut=new ObjectOutputStream(out);
            objOut.writeObject(obj);
            objOut.flush();
            objOut.close();
            System.out.println("write object success!");
        } catch (IOException e) {
            System.out.println("write object failed");
            e.printStackTrace();
        }
    }
	
    /**
     * 
     * 方法名: readObjectFromFile
     * 描述: 将对象从文件中读取出来。
     * 创建人: zhoujuan
     * 时间: 2016年5月14日 下午3:38:55
     * @return
     * @return: Object
     * @since: V1.0
     */
	public static Object readObjectFromFile(String url)
    {
        Object temp=null;
        File file =new File(url);
        FileInputStream in;
        try {
            in = new FileInputStream(file);
            int size = in.available();
            if(size==0){
            	System.out.println("file is empty！");
            }else{            	
            	ObjectInputStream objIn=new ObjectInputStream(in);            
            	temp=objIn.readObject();
            	objIn.close();
            	System.out.println("read object success!");
            }
        } catch (IOException e) {
            System.out.println("read object failed");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return temp;
    }
	
	public static void main(String[] args) {
		String url = "exception.dat"; 
		File file =new File(url);
		boolean flag = file.canRead();
		System.out.println(flag);
		 
	}
}
