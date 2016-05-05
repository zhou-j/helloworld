package com.newstart.action.core;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.struts2.ServletActionContext;

/**
 * 
 * 类名: UploadAction
 * 描述: 文件上传类。swfupload,fileupload,jqueryload
 * 创建人: zhoujuan
 * 时间: 2016年4月11日 上午11:11:04
 * @version: V1.0
 */
public class UploadAction {
	//这里的file必须和<input type="file" name="file">中的name一致。
	private File file;
	private String fileFileName;//固定格式：file+FileName
	private String fileContentType;
    //execute:每一个action进入的默认方法。
	public String execute(){
        //获取服务器的上传路径upload
		String datename = new SimpleDateFormat("yyyyMMdd").format(new Date());
		String path = "upload/"+datename;
		String root = ServletActionContext.getServletContext().getRealPath("/"+path);
		File rootPath = new File(root);
		//如果在服务器上没有找到upload目录的，那么就创建 rootPath.mkdirs()
		if(!rootPath.exists())rootPath.mkdirs();
		//把临时文件的文件流写入到服务器的upload目录下面
		//缓存字节输入流。
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			//获取临时文件然后以字节流的读取。
			FileInputStream inputStream = new FileInputStream(file);
			bis = new BufferedInputStream(inputStream);
			String name = generateFileName(fileFileName);
			File targetFile = new File(rootPath,name);
			FileOutputStream outputStream = new FileOutputStream(targetFile);
			bos = new BufferedOutputStream(outputStream);
			byte[] buf = new byte[4096];
			//bis.available()==已经上传了多少字节
			//文件字节的总的大小是:file.length()
			int len = 1;
			while((len = bis.read(buf)) !=-1){
				bos.write(buf,0,len);
			}
			//删除临时文件
			file.delete();
			ServletActionContext.getRequest().getSession().setAttribute("url", path+"/"+name);
			//加入文字水印
			//TmImageUtil.pressText("我爱你么，潭州学院",targetFile.getAbsolutePath(),"微软雅黑", 1, 28, 0, 0, 2);	
		} catch (Exception e) {
			file.delete();
			e.printStackTrace();
		}finally{
			try {
				  if(bis!=null){
					  bis.close();
				  }
				  if(bos!=null){
					  bos.close();
				  }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return "uploadpressimg";
	}

	private String generateFileName(String fileName){
		//获取要写入的目录下面
		int index = fileName.lastIndexOf(".");
		//获取文件的后缀
		String ext = fileName.substring(index);
		//重名文件
		String name = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		//随机数
		int number = new Random().nextInt(1000);
		return name+number+ext;
	}
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
    
}
