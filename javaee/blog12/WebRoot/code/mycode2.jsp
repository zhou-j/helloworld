<%@page import="java.awt.Font"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.awt.Color"%>
<%@page import="java.awt.Graphics"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>   
    <title>My JSP 'mycode.jsp' starting page</title>    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>  
  <body>
    <%!
	  public static Color getRandColor(int rc,int bc){
		 java.util.Random random = new java.util.Random();
		 if(rc>255)rc=255;
		 if(bc>255)bc = 255;
		 int red = rc + random.nextInt(bc-rc);
		 int green = rc + random.nextInt(bc-rc);
		 int blue = rc + random.nextInt(bc-rc);
		 return new Color(red,green,blue);		
	  };        
    %>
    <%!
        public static HashMap<String,String> getRanDomString(){
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
    	        	result = start * end;
    	            rm = "*";
    	            break;
    	        case 4:
    	        	result = start / end;
    	            rm = "/";
    	            break;
    	        default:
    	        	result = start % end;
    	            rm = "%";
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
    <% 
     //为什么要使用验证码：用户注册，登录，发帖
     //图文并茂的一种形式，利用java技术生成一张图片,网图片中写入文字，数字，字母表达式等。
     //把这些图片和字母数字：表达式等等：最终在Session中当用户在前端进行载入的时候会和服务器的Session存入进行
     //URL-----如果你要确保数据真的安全有效那么必须进行js验证和服务器验证。
     //前期开发不要过多的心思发在验证上。登录，注册，积分，只要是牵扯到钱的时候一定要服务器验证。
    
     response.setContentType("image/jpeg");//设置相应的类型，告诉浏览器输出的内容为图片
     response.setHeader("Pragma","No cache");//设置响应头的信息，告诉浏览器不要缓存的内容。
     response.setHeader("Cache-Control","no-cache");
     response.setDateHeader("Expire",0);
     //验证码图片的高度和宽度。
     int width = 210;
     int height = 50;
     //java io
     //开始画图对象
     BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
     //输出来
     //OutputStream os = new FileOutPutStream();//
     OutputStream os = response.getOutputStream();
     //画布
     Graphics g = image.getGraphics();
     //建立随机数
     Random random = new Random();
     //往画布添加颜色，字体建立颜色。
     g.setColor(getRandColor(200,255));
     //给整个图片渲染     
     g.fillRect(0,0,width,height);
     g.setFont(new Font("宋体",Font.PLAIN,26));
     g.setColor(Color.WHITE);
     //drawLine绘制直线--html5 canvas drawLine(x,y,x1,y1)代表是画线,x y代表起始点的坐标,x1,y1代表的是结束点的坐标。
     //g.drawLine(0,0,20,20);     
     for(int i=0;i<155;i++){
    	 int x = random.nextInt(width);
    	 int y = random.nextInt(height);
    	 int x1 = random.nextInt(120);
    	 int y1 = random.nextInt(120);
    	 g.drawLine(x,y,x1,y1);
     }  
     //String[] s = {"Q","W","E","R","T","Y","U","I","O","P","A","S","D","F","G","H","J","K","L","Z","X","C","V","B","N","M"};
     //绘制文字
     //String rand = "";
     //for(int i=0;i<5;i++){
     //	int index = random.nextInt(25);
     //int start = random.nextInt(100);
     //int end = random.nextInt(100);
     HashMap<String,String> map = new HashMap<String,String>();
     map = getRanDomString();
     String randStr = map.get("randString");
     String result = map.get("result");
     System.out.println(randStr);
     System.out.println(result);
     g.setColor(getRandColor(100,185));
     g.drawString(randStr, 17*random.nextInt(5)+5,30);
     //将随机数放入到session中
     //session.setAttribute("code",rand);
     g.dispose();
     //输出图片
     ImageIO.write(image,"jpeg",os);
     os.flush();
     os.close();
     os = null;
     response.flushBuffer();
     out.clear();
     out = pageContext.pushBody();
    %>
 </body>
</html>
