<%@page import="org.apache.struts2.json.JSONUtil"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.FileItemFactory"%>
<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	//获取文件的上传的具体目录
	String realPath = request.getRealPath("/");
	String username = request.getParameter("username");
	//定义上传的目录
	String dirPath = realPath+"/upload";
	File dirFile = new File(dirPath);
	//自动创建上传的目录
	if(!dirFile.exists())dirFile.mkdirs();
	//上传操作  
 	FileItemFactory factory = new DiskFileItemFactory();  
	//
  	ServletFileUpload upload = new ServletFileUpload(factory);  
	String fileName = null;
	HashMap<String,Object> map = new HashMap<String,Object>();
 	try{  
      List items = upload.parseRequest(request);  //3name=null name=null
	  if(null != items){  
          Iterator itr = items.iterator();  
          while(itr.hasNext()){  
              FileItem item = (FileItem)itr.next();  
              if(item.isFormField()){  
                  continue;  
              }else{  
            	 String ext = getExt(item.getName());
                 fileName = UUID.randomUUID().toString()+ext;
					//上传文件的目录
                 File savedFile = new File(dirPath,fileName);  
                 item.write(savedFile);  
                 map.put("name",item.getName());//文件的原始名称
                 map.put("newName",fileName);//文件的新名称
                 map.put("ext",getExtNoPoint(fileName));//文件的后缀
                 map.put("size",item.getSize());//文件的真实大小
                 map.put("sizeString",countFileSize(item.getSize()));//获取文件转换以后的大写
                 map.put("url","upload/"+fileName);//获取文件的具体服务器的目录
                 //我可以建立一个文件表。把上传的文件存在表中.--文件夹表一个文件表---云盘
              }  
          }  
	  }  
	}catch(Exception e){  
	   
	} 
 	out.print(JSONUtil.serialize(map));
%>

<%!
public static String countFileSize(long fileSize) {
	String fileSizeString = "";
	try {
		DecimalFormat df = new DecimalFormat("#.00");
		long fileS = fileSize;
		if (fileS == 0) {
			fileSizeString = "0KB";
		} else if (fileS < 1024) {
			fileSizeString = df.format((double) fileS) + "B";
		} else if (fileS < 1048576) {
			fileSizeString = df.format((double) fileS / 1024) + "KB";
		} else if (fileS < 1073741824) {
			fileSizeString = df
					.format(((double) fileS / 1024 / 1024) - 0.01)
					+ "MB";
		} else {
			fileSizeString = df.format((double) fileS / 1024 / 1024 / 1024)
					+ "G";
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return fileSizeString;
}

/**
 * 获取一个文件的后缀(带有点)
 * 
 * @param fileName
 *            文件名
 * @return 返回文件的后缀
 */
public static String getExt(String fileName) {
	int pos = fileName.lastIndexOf(".");
	if (pos == -1)
		return "";
	return fileName.substring(pos, fileName.length());
}

/**
 * 获取一个文件的后缀(不带有点)
 * 
 * @param fileName
 *            文件名
 * @return 返回文件的后缀
 */
public static String getExtNoPoint(String fileName) {
	if (fileName.lastIndexOf(".") == -1)
		return "";
	int pos = fileName.lastIndexOf(".") + 1;
	return fileName.substring(pos, fileName.length());
}
%>