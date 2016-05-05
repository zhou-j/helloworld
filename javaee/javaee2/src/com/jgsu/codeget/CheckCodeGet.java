package com.jgsu.codeget;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class CheckCodeGet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int TYPE_NUMBER = 0;
	private final int TYPE_LETTER = 1;
	private final int TYPE_MULTIPLE = 2;
	private int width;
	private int height;
	private int count;
	private int type;
	private String validate_code;
	private Random random;
	private Font font;
	private int line;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");
		String reqCount = request.getParameter("count");
		String reqWidth = request.getParameter("width");
		String reqHeight = request.getParameter("height");
		String reqType = request.getParameter("type");
		if(reqCount!=null && reqCount!="")this.count = Integer.parseInt(reqCount);
		if(reqWidth!=null && reqWidth!="")this.width = Integer.parseInt(reqWidth);
		if(reqHeight!=null && reqHeight!="")this.height = Integer.parseInt(reqHeight);
		if(reqType!=null && reqType!="")this.type = Integer.parseInt(reqType);
		font = new Font("微软雅黑",Font.BOLD,width/count);
		BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		g.setColor(getRandColor(200,250));
		g.fillRect(0,0,width,height);
		g.setColor(getRandColor(160,200));
		for(int i=0;i<line;i++){
			 int x  = random.nextInt(width);
			 int y  = random.nextInt(height);
			 int x1 = random.nextInt(12);
			 int y1 = random.nextInt(12);
			 g.drawLine(x, y, x+x1, y+y1);
		}
		g.setFont(font);
		validate_code = getValidateCode(count,type);
		request.getSession().setAttribute("validate_code",validate_code );
		for(int i=0;i<count;i++){
			g.setColor(new Color(20+random.nextInt(110),20 + random.nextInt(110),20 + random.nextInt(110)));
			int x = (int)(width/count)*i;
			int y = (int)((height+font.getSize())/2)-5;
			g.drawString(String.valueOf(validate_code.charAt(i)), x, y);
		}
		g.dispose();
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(response.getOutputStream());
		encoder.encode(image);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(request, response);
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		width = 150;
		height = 50;
		count = 4;
		type = TYPE_NUMBER;
		random = new Random();
		line = 200;
	}
	
	private Color getRandColor(int from,int to){
		Random random = new Random();
		if(to>255)from = 255;
		if(to>255)to = 255;
		int rang = Math.abs(to-from);
		int r = from + random.nextInt(rang);
		int g = from + random.nextInt(rang);
		int b = from + random.nextInt(rang);
		return new Color(r,g,b);
	}
	
	private String getValidateCode(int size,int type){
		StringBuffer validate_code = new StringBuffer();
		for(int i = 0;i<size;i++){
			validate_code.append(getOneChar(type));
		}
		return validate_code.toString();
	}

	private String getOneChar(int type){
		String result = null;
		switch(type){
		    case TYPE_NUMBER:
		    	result = String.valueOf(random.nextInt(10));
		    	break;
		    case TYPE_LETTER:
		    	result = String.valueOf((char)(random.nextInt(26)+65));
		    	break;
		    case TYPE_MULTIPLE:
		    	if(random.nextBoolean()){
		    		result = String.valueOf(random.nextInt());
		    	}else{
		    		result = String.valueOf((char)(random.nextInt(26)+65));
		    		break;
		    	}
		    default:
		    	result = null;
		    	break;
		}
		if(result==null){
			throw new NullPointerException("获取验证码出错");
		}
		return result;
	}
}
