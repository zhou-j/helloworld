package com.blog.tag;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.blog.bean.Content;
import com.blog.dao.ContentDao;

/**
 * 
 * 类名: ContentTag
 * 描述: 内容标签
 * 创建人: zhoujuan
 * 时间: 2016年3月5日 下午5:40:08
 * @version: V1.0
 */
public class ContentTag extends TagSupport{
	private Integer end; 
	private Integer begain;
	private String var;
	private Integer sort;
	//第一个集合的迭代器
	private Iterator<Content> iterator;
	//标签开始时调用的方法
	private int index = 0;
	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		//查询内容表中的数据
		if(begain==null || begain<=1){
			begain=0;
		}else{
			begain--;
		}
		if(end==null)end=10;
		String sortFlag = "desc";
		if(sort!=null && sort==1)sortFlag = "asc";
		List<Content> contents = ContentDao.findContent(begain,end,sortFlag);
		if(contents!=null && contents.size()>0){
			iterator = contents.iterator();//初始化迭代器
			if(iterator.hasNext()){//如果集合中有数据
				this.pageContext.setAttribute(var, iterator.next());
				this.pageContext.setAttribute(var+"_index", index);
				return EVAL_BODY_INCLUDE;//要去容器执行主体标签中的代码。	
			}else{
				return SKIP_BODY;//忽略标签的主题内容(标签体)
			}
		}else{
			return SKIP_BODY;//忽略标签的主题内容(标签体)
		}
		//有两个固定的返回值SKIP_BODY，EVAL_BODY_INCLUDE
		//SKIP_BODY:忽略标签的主体内容(标签体)
		//EVAL_BODY_INCLUDE:要去容器中执行主体标签内容
	}
	
	//标签循环的时候调用的方法(主体)
	@Override
	public int doAfterBody() throws JspException {
		index++;
		// TODO Auto-generated method stub
		if(iterator.hasNext()){//如果集合中有数据
			this.pageContext.setAttribute(var,iterator.next());
			this.pageContext.setAttribute(var+"_index", index);			
			return EVAL_BODY_AGAIN;//要去容器中重复执行主体标签中的代码。	
		}else{
			return SKIP_BODY;//忽略标签的主题内容(标签体)
		}
		//有两个固定的返回值SKIP_BODY，EVAL_BODY_INCLUDE
		//SKIP_BODY:忽略标签的主体内容(标签体)
		//EVAL_BODY_AGAIN:要去容器中重复执行主体标签内容		
	}

//	@Override
//	public int doEndTag() throws JspException {
//		// TODO Auto-generated method stub
//	}
    //标签结束以后释放资源
	@Override
	public void release() {
		// TODO Auto-generated method stub
		iterator = null;
		var = null;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getBegain() {
		return begain;
	}

	public void setBegain(int begain) {
		this.begain = begain;
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

	public static void main(String[] args) {
		List<String> strings = new ArrayList<String>();
	}
	
}
