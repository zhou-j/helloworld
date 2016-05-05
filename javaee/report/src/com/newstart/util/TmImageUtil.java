package com.newstart.util;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * 
 * 类名: TmImageUtil
 * 描述: 图片水印文字工具类
 * 创建人: zhoujuan
 * 时间: 2016年3月30日 下午2:27:45
 * @version: V1.0
 */
public class TmImageUtil {
	/**
	 * 
	 * 方法名: pressText
	 * 描述: 图片水印的方法
	 * 创建人: zhoujuan
	 * 时间: 2016年3月30日 下午4:21:24
	 * @param text  水印文字
	 * @param sourceImg  水印原图
	 * @param targetImg  水印以后的图片
	 * @param fontName   图片水印文字的类型
	 * @param fontStyle  图片水印文字的样式如Font.BOLD
	 * @param fontSize   图片水印文字的大小
	 * @param x          图片水印文字的x坐标
	 * @param y          图片水印文字的y坐标
	 * @param flag       图片水印文字的位置
	 * @return: void
	 * @since: V1.0
	 */
	public static void pressText(String text,String sourceImg,String targetImg,String fontName,String color,int fontSize,int x,int y,int flag){
		try {
	    	//图片
	    	File file = new File(sourceImg);
	    	//返回图片对象
	    	Image image;			
			image = ImageIO.read(file);
	    	//获取图片的宽度和高度
	    	int width = image.getHeight(null);
	    	int height = image.getWidth(null);
	    	//利用图片缓冲流
	    	BufferedImage bufferImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);
	    	//System.out.println(+"====="+);
	    	//画布
	    	Graphics g = bufferImage.createGraphics();
	    	g.drawImage(image, 0, 0,width,height, null);
	    	//设置画布的颜色。
	    	Color Ccolor = StringUtil.StringtoColor(color);
	    	g.setColor(Ccolor);
	    	//设置画布的字体样式。
	    	g.setFont(new Font(fontName,Font.BOLD,fontSize));
	    	if(flag==1){
	    		//左上
	    		g.drawString(text,x,fontSize+y);	    		
	    	}else if(flag==2){
	    		//右上
    	    	g.drawString(text,width-text.length()*fontSize-x,fontSize+y);
	    	}else if(flag==3){
	    		//左下
 		    	g.drawString(text,x,height-y);	    		
	    	}else if(flag==4){
	    		//右下
	    		g.drawString(text,width-text.length()*fontSize-x,height-y);
	    	}
	    	g.dispose();
	    	//合成图片
	    	FileOutputStream outputStream = new FileOutputStream(targetImg);
	    	JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(outputStream);
	    	encoder.encode(bufferImage);
	    	outputStream.close();			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	//io
    public static void main(String[] args) throws IOException {
	   	 String text = "我爱你们！";
	   	 String sourceimg  = "D:/img/b.jpg";
	   	 String targetimg = "D:/img/1.jpg";
	   	 String fontname = "微软雅黑";
	   	 int fontsize = 126;
	   	 String color = "#333333";
	   	 int x = 50;
	   	 int y = 50;
	   	 //pressText(text,sourceimg,targetimg,fontname,color,fontsize,x,y,3);
	}
}

