<%@ page language="java" import="java.util.*,com.yunpan.bean.Resource,com.yunpan.dao.ResourceDao,org.apache.struts2.json.JSONUtil,com.yunpan.util.StringUtil" pageEncoding="UTF-8"%>
<%
   /* 
	      业务：添加文件信息，使用ajax
	      时间：2016/3/13
	      作者：newstart
	      描述：通过文件上传实现百度云盘的技术
	      类：ResourceDao,saveResource(Resource resource)
   */
        //调用ResourceDao保存方法
        //获取客户端传来的数据，通过ajax传递过来的值都是字符串。
        String name = request.getParameter("name");
		String size = request.getParameter("size");
		String sizeString = request.getParameter("sizeString");
		String ext = request.getParameter("ext");
		String url = request.getParameter("url");
		String width = request.getParameter("width");
		String height = request.getParameter("height");
		String folderId = request.getParameter("folderId");
		String newname = request.getParameter("newname");
		String userId = request.getParameter("userId");
		String description = request.getParameter("description");
		
		Resource resource = new Resource();
		resource.setDescription(description);
		resource.setExt(ext);
		resource.setUrl(url);
		resource.setFolderId(folderId==null? null:Integer.parseInt(folderId));
		resource.setHegiht(height==null? null:Integer.parseInt(height));
		resource.setIsDelete(0);
		resource.setName(name);
		resource.setNewName(newname);
		resource.setSize(size== null? null:Integer.parseInt(size));
		resource.setSizeString(sizeString);
		resource.setStatus(1);
		resource.setType(getType(ext));
		resource.setUserId(userId==null? null:Integer.parseInt(userId));
		resource.setWidth(width==null? null:Integer.parseInt(width));
		resource = ResourceDao.saveResource(resource);
		if(resource!=null){
			out.print(JSONUtil.serialize(resource));
		}else{
			out.print("fail");			
		}
%>
<%!
   public static int getType(String ext){
	   int type = 4;//其它
	   if(StringUtil.isDoc(ext)){
		   type = 1;
	   }else if(StringUtil.isImage(ext)){
		   type=2;
	   }else if(StringUtil.isVideo(ext)){
		   type = 3;
	   }
	   return type;
   }

%>