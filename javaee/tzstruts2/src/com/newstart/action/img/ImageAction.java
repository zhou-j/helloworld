package com.newstart.action.img;

import org.apache.struts2.ServletActionContext;

import com.newstart.utilImage.TmImageUtil;

/**
 * 
 * 类名: ImageAction
 * 描述: 处理图片的业务逻辑类
 * 创建人: zhoujuan
 * 时间: 2016年3月30日 下午2:31:00
 * @version: V1.0
 */
public class ImageAction {
   
	public static final String SUCCESS = "success";
	//文字水印的文字
    private String text;
    //水印的原图片
    private String sourceImg;
    //水印的目标图片
    private String targetImg;
    //水印的字体类型：微软雅黑。
    private String fontName;
    //水印的字体样式：Font.BOLD
    private String fontStyle;
    //水印字体的大小。
    private int fontSize;
    //水印文字的x坐标。
    private int x;
    //水印文字的y坐标。
    private int y;
    //水印文字的位置。
    private int flag;
    
	/**
	 * 
	 * 方法名: pressImg
	 * 描述: 图片水印。
	 * 创建人: zhoujuan
	 * 时间: 2016年3月30日 下午4:47:14
	 * @return
	 * @return: String
	 * @since: V1.0
	 */
	public String pressImg(){
		sourceImg = "C:/Program Files/Apache Software Foundation/Tomcat 6.0/webapps/tzstruts2/images/m0.jpg";
		//ServletActionContext.getServletContext().getRealPath获取服务的根目录。
		targetImg = ServletActionContext.getServletContext().getRealPath("images/m0.jpg");
		TmImageUtil.pressText(text, sourceImg, targetImg, fontName,fontSize, x, y,flag);
		return SUCCESS;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getSourceImg() {
		return sourceImg;
	}

	public void setSourceImg(String sourceImg) {
		this.sourceImg = sourceImg;
	}

	public String getTargetImg() {
		return targetImg;
	}

	public void setTargetImg(String targetImg) {
		this.targetImg = targetImg;
	}

	public String getFontName() {
		return fontName;
	}

	public void setFontName(String fontName) {
		this.fontName = fontName;
	}

	public String getFontStyle() {
		return fontStyle;
	}

	public void setFontStyle(String fontStyle) {
		this.fontStyle = fontStyle;
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
