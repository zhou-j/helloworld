package com.example.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import android.os.Environment;

public class FileService {

	public void saveToSDCard(String name, String content) throws IOException {
		File file = new File(Environment.getExternalStorageDirectory(),name);//获取sd卡所在目录（兼容所有版本）
		FileOutputStream fos = new FileOutputStream(file);  //创建输出流，指向Sd卡所在目录
		fos.write(content.getBytes());   //写出文件内容
		fos.close();
	}

	public void saveToRom(String name, String content) {
	}

	

}
