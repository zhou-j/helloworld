<%@page import="java.awt.Font"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.awt.Color"%>
<%@page import="java.awt.Graphics"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%!

	public static Color getRandColor(int rc,int bc){
		java.util.Random random = new java.util.Random();
		if(rc>255)rc=255;
		if(bc>255)bc = 255;
		int red = rc + random.nextInt(bc-rc);
		int green = rc + random.nextInt(bc-rc);
		int blue = rc + random.nextInt(bc-rc);
		return new Color(red,green,blue);		
	}
%>
<%
	//为什么要要使用验证码:用户注册，登陆，发帖。
	//图文并茂的一种形式。利用java技术生成一张图片。往图片写入文字，数字，字母表达式等等.
	//把这些图片和字母数字，表达式等等，最终放在session中，当用户在前端进行输入的时候就会和服务端的session存入进行比较
	//URL----如果你要确保数据真的安全有效那么必须进行js验证和服务端验证.
	//前期开发不要过多的心思花在验证上。登陆，注册，积分，只要是牵扯到钱的时候就一定要服务器验证

	 response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
     response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
     response.setHeader("Cache-Control", "no-cache");
     response.setDateHeader("Expire", 0);
	 //建立随机数
	 Random random  = new Random();
     
     //验证码图片的高度和宽度
     int width = 100;
     int height = 30;
	 //java io
	 //开始画图对象
	 BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
	 //利用，输出流
	 //OutputStream os = new FileOutputStream();//往磁盘中输出
	 OutputStream os = response.getOutputStream();//往浏览器输出的功能
	 //画布
	 Graphics g = image.getGraphics();
	 //给画布添加颜色,字体建立颜色
	 g.setColor(Color.WHITE);//绘制干扰线
	 //给整个图片渲染.fillRect(x, y, width, height)
	 //x  y 坐标
	 g.fillRect(0, 0, width, height);
	 
	 //绘制的区域一直构建好了。开始去绘制图片的文字
	 g.setFont(new Font("微软雅黑",Font.PLAIN,18));
	 g.setColor(getRandColor(200, 255));//白色
	 //drawLine 绘制直线--html5 canvas drawLine(x,y,x1,y1)代表是画线，x y代表起始点的坐标，x1,y1代表是结束点的坐标
	 //这是绘制干扰线
	 for(int i=0;i<155;i++){
		 int x = random.nextInt(width);
		 int y = random.nextInt(height);
		 int x1 = random.nextInt(120);
		 int y1 = random.nextInt(120);
	 	 g.drawLine(x, y, x1, y1);
	 }
	 
	 int start = random.nextInt(100);
	 int end = random.nextInt(100);
	 //绘制文字数字
 	 g.setColor(getRandColor(100,150));
	 HashMap<String,String> map = getRandDomString();
 	 g.drawString(map.get("randString"), 17 * random.nextInt(2)+10, 20);
	 
	 //将随机放入session中
	 session.setAttribute("code",map.get("result"));
	 g.dispose();
	 //输出图片
	 ImageIO.write(image, "JPEG", os);
	 os.flush();
	 os.close();
	 os = null;
	 response.flushBuffer();
	 out.clear();
	 out = pageContext.pushBody();
%>
<%!
	public static HashMap<String,String> getRandDomString(){
		Random random = new Random();
		int start = random.nextInt(30);
		int end = random.nextInt(30);
		int mark = random.nextInt(4);
		int result = 0;
		String rm = "";
		StringBuffer buffer = new StringBuffer();
		switch(mark){
			case 1:
				result = start + end;
				rm = "+";
				break;
			case 2:
				result = start - end;
				rm = "-";
				break;
			case 3:
				rm = "*";
				result = start * end;
				break;
			case 4:
				rm = "/";
				result = start / end;
				break;
			default:	
				rm = "%";
				result = start % end;
				break;
		}
		buffer.append(start);
		buffer.append(rm);
		buffer.append(end);
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("randString",buffer.toString());
		map.put("result",String.valueOf(result));
		return map;
	}
%>

