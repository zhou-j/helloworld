package com.newstart.action.core;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;

public class DownLoadAction {
  
	private Long fileLength;
	private String fileName;
	private String path;
	public InputStream getInputStream() throws IOException{
		System.out.println("如果你文件下载进入了这里，就代表文件可以下载了.....");
		System.out.println("文件的大小："+this.fileLength);
		InputStream stream = ServletActionContext.getServletContext().getResourceAsStream(path);
		System.out.println("文件下载还剩余："+stream.available());
		System.out.println("下载的进度是：");
		return stream;
	}
	
	public String execute() throws UnsupportedEncodingException{
		System.out.println("文件下载进入了这里。。。。。");
		//获取服务器的文件的路径，只能用相对路径
		//id---资源表中查找
		String reltiveName = "upload"+File.separator+"20141213/discuss.rar";
		String filePath = ServletActionContext.getServletContext().getRealPath(reltiveName);
		File file = new File(filePath);
		if(file.exists()){
			fileName = new String("keke.zip".getBytes(),"ISO8859-1");
			path = reltiveName;
			fileLength = file.length();
			return "success";
		}else{
			return "error";
		}
	}

	public Long getFileLength() {
		return fileLength;
	}

	public void setFileLength(Long fileLength) {
		this.fileLength = fileLength;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
}
