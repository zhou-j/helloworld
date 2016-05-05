package com.blog.upload;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		//创建一个文件词条的工厂
		FileItemFactory factory = new DiskFileItemFactory();
		//创建一个文件上传的处理的实例
		ServletFileUpload upload = new  ServletFileUpload(factory);
		List<FileItem> items = null;
		try{
			items = upload.parseRequest(request);	
		}catch(Exception ex){
			
		}
		
		System.out.println("=============="+items);
	}
	

}
