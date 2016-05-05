package com.blog.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.blog.util.StringUtils;

/**
 * 
 * 大写标签转换
 * ToUpperTag<BR>
 * 创建人:潭州学院-keke <BR>
 * 时间：2014年11月15日-下午9:34:09 <BR>
 * @version 1.0.0
 *
 */
public class ToUpperLowerTag extends BodyTagSupport{

	private static final long serialVersionUID = 1L;
	//转换的内容	
	private String content;
	//转换的标识码 1大小转小写 2小写转大写
	private Integer sort;
	//传输对象
	private String var;
	public int doStartTag() throws JspException {
		if(StringUtils.isEmpty(content)){
			return EVAL_PAGE;//直接往下执行JSP内容
		}
		if(sort==null)sort=1;
		try {
			String str = sort > 1 ? content.toUpperCase() : content.toLowerCase();
			pageContext.setAttribute(var, str);
			this.pageContext.getOut().println(str);
		} catch (IOException e) {
			
		}
		return EVAL_PAGE;
	}
	
	
	
//	public void doInitBody() throws JspException {
//		
//	}

//	public int doAfterBody() throws JspException {
//		
//	}
	
//	public int doEndTag() throws JspException {
//		return EVAL_PAGE;//继续执行标签以后的JSP的内容
//	}
	
	public void release() {
	}


	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}
	
}
