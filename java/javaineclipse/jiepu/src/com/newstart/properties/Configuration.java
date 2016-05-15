package com.newstart.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
	
	private Properties propertie;
	private FileInputStream inputFile;
	private FileOutputStream outputFile;

	/**
	 * 初始化Configuration类
	 */
	public Configuration() {
		propertie= new Properties();
	}

	/**
	 * 初始化Configuration类
	 * @param filePath
	 * 要读取的配置文件的路径+名称
	 */
	public Configuration(String filePath) {
		propertie = new Properties();
		try {
			inputFile = new FileInputStream(filePath);
			propertie.load(inputFile);
			inputFile.close();
		} catch (FileNotFoundException ex) {
			System.out.println("读取属性文件失败！----- 原因：文件路径错误或者文件不存在");
			ex.printStackTrace();
		} catch (IOException ex) {
			System.out.println("装载文件--->失败!");
			ex.printStackTrace();
		}

	}

    /**
     * 
     * 方法名: getValue
     * 描述: 重载函数，得到key的值
     * 创建人: zhoujuan
     * 时间: 2016年5月11日 下午2:29:52
     * @param key 取得其值的键 
     * @return
     * @return: String key的值
     * @since: V1.0
     */
	public String getValue(String key) {
		if (propertie.containsKey(key)) {
			String value = propertie.getProperty(key);// 得到某一属性的值
			return value;
		} else {
			return "";
		}
	}
	
    /**
     * 
     * 方法名: getValue
     * 描述: 重载函数，得到key的值 
     * 创建人: zhoujuan
     * 时间: 2016年5月11日 下午2:28:30
     * @param fileName properties文件的路径+文件名 
     * @param key 取得其值的键
     * @return
     * @return: String key的值 
     * @since: V1.0
     */
	public String getValue(String fileName, String key) {
		try {
			String value = "";
			inputFile = new FileInputStream(fileName);
			propertie.load(inputFile);
			inputFile.close();
			if (propertie.containsKey(key)) {
				value = propertie.getProperty(key);
				return value;
			} else {
				return value;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return "";
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		} catch (Exception ex) {
			ex.printStackTrace();
			return "";
		}
	}

	/**
	 *  
	 * 方法名: clear
	 * 描述: 清除properties文件中所有的key和其值
	 * 创建人: zhoujuan
	 * 时间: 2016年5月11日 下午2:26:12
	 * @return: void
	 * @since: V1.0
	 */
	public void clear() {
		propertie.clear();
	}

    /**
     * 
     * 方法名: setValue
     * 描述: 改变或添加一个key的值，当key存在于properties文件中时该key的值被value所代替， 当key不存在时，该key的值是value
     * 创建人: zhoujuan
     * 时间: 2016年5月11日 下午2:26:43
     * @param key 要存入的键
     * @param value 要存入的值
     * @return: void
     * @since: V1.0
     */
	public void setValue(String key, String value) {
		propertie.setProperty(key, value);
	}

    /**
     * 
     * 方法名: saveFile
     * 描述: 将更改后的文件数据存入指定的文件中，该文件可以事先不存在。
     * 创建人: zhoujuan
     * 时间: 2016年5月11日 下午2:27:39
     * @param fileName 文件路径+文件名称
     * @param description 对该文件的描述
     * @return: void
     * @since: V1.0
     */
	public void saveFile(String fileName, String description) {
		try {
			outputFile = new FileOutputStream(fileName);
			propertie.store(outputFile, description);
			outputFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Configuration rc = new Configuration("D:\\first\\collection.properties");// 相对路径
		String n = rc.getValue("n");
		System.out.println("n = " + n);

		Configuration cf = new Configuration();
		String n2 = cf.getValue("D:\\first\\collection.properties", "n");
		System.out.println("n2 = " + n2);

		cf.setValue("n", "48");
		cf.saveFile("D:\\first\\collection.properties", "test");

		// Configuration saveCf = new Configuration();
		// saveCf.setValue("min", "10");
		// saveCf.setValue("max", "1000");
		// saveCf.saveFile(".\config\save.perperties");
	}
	
}
