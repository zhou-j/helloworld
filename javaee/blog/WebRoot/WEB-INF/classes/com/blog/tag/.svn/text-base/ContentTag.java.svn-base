package com.blog.tag;

import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.blog.bean.Content;
import com.blog.dao.content.ContentDao;

/**
 * 
 * 内容标签
 * ContentTag<BR>
 * 创建人:潭州学院-keke <BR>
 * 时间：2014年11月13日-下午10:20:18 <BR>
 * @version 1.0.0
 *
 */
public class ContentTag extends TagSupport{
	//在标签里面定义的属性一定要生成set方法,为什么?
	private Integer end;
	private Integer begin;
	private Integer sort;
	private String var;
	//第一个集合的迭代器
	private Iterator<Content> iterator;
	private int index = 0;
	//标签开始时调用的方法
	public int doStartTag() throws JspException {
		//查询内容表中的数据
		if(begin==null || begin<=1){
			begin=0;
		}else{
			begin--;
		}
		if(end==null)end=10;
		String sortFlag = "desc"; 
		if(sort!=null && sort==1)sortFlag = "asc";
		//业务发生了变化
		List<Content> contents = ContentDao.findContents(begin,end,sortFlag);
		if(contents!=null && contents.size()>0){
			iterator = contents.iterator();//初始迭代器
			if(iterator.hasNext()){//如果你的集合中有数据
				this.pageContext.setAttribute(var, iterator.next());
				this.pageContext.setAttribute(var+"_index", index);
				return EVAL_BODY_INCLUDE;//要去容器执行主体标签内容（标签体）
				
			}else{
				return SKIP_BODY;//忽略标签的主题内容（标签体）
			}
		}else{
			return SKIP_BODY;//忽略标签的主题内容（标签体）
		}
		//有两个固定的返回值 SKIP_BODY,EVAL_BODY_INCLUDE
		//SKIP_BODY:忽略标签的主题内容（标签体）默认值
		//EVAL_BODY_INCLUDE:要去容器执行主体标签内容
	}
	
	//标签循环的时候调用的方法(主题)
	public int doAfterBody() throws JspException {
		if(iterator.hasNext()){//如果你的集合中有数据
			index++;
			this.pageContext.setAttribute(var, iterator.next());
			this.pageContext.setAttribute(var+"_index", index);
			return EVAL_BODY_AGAIN;//要求容器重复执行标签主体内容
		}else{
			index = 0;
			return SKIP_BODY;//忽略标签的主题内容（标签体）,往标签的下面
		}
		
		//有两个固定的返回值 SKIP_BODY,EVAL_BODY_AGAIN
		//SKIP_BODY:忽略标签的主题内容（标签体）
		//EVAL_BODY_AGAIN：重复执行标签体重的内容
	}
	

	public int doEndTag() throws JspException {
		iterator = null;
		var = null;
		index = 0;
		//有两个固定的返回值 SKIP_BODY,EVAL_BODY_AGAIN
		//EVAL_PAGE:继续运行标签后面的内容 =====默认值
		//SKIP_PAGE:忽略标签结束后面的内容
		return EVAL_PAGE;
	}

	//标签结束以后释放资源
	public void release() {
		iterator = null;
		var = null;
		index = 0;
	}

	//setter/getter
	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	public Integer getBegin() {
		return begin;
	}

	public void setBegin(Integer begin) {
		this.begin = begin;
	}

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
}
