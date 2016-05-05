package com.blog.tag;

import java.util.Collection;
import java.util.Iterator;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 
 * 内容标签
 * ContentTag<BR>
 * 创建人:潭州学院-keke <BR>
 * 时间：2014年11月13日-下午10:20:18 <BR>
 * @version 1.0.0
 *
 */
public class LoopTag extends TagSupport{
	//在标签里面定义的属性一定要生成set方法,为什么?
	private String var;
	//第一个集合的迭代器
	private Iterator iterator;
	private Object items;
	private int index = 0;
	//标签开始时调用的方法
	public int doStartTag() throws JspException {
		//查询内容表中的数据
		if(items==null){
			return SKIP_BODY;//直接忽略标签体的执行
		}
//		if(items instanceof String){
//			
//		}else if(items instanceof Collections){
//		}
		iterator = ((Collection)items).iterator();//初始迭代器
		if(iterator.hasNext()){//如果你的集合中有数据
			this.pageContext.setAttribute(var, iterator.next());
			this.pageContext.setAttribute(var+"_index", index);
			return EVAL_BODY_INCLUDE;//要去容器执行主体标签内容（标签体）
			
		}else{
			return SKIP_BODY;//忽略标签的主题内容（标签体）
		}
		//有两个固定的返回值 SKIP_BODY,EVAL_BODY_INCLUDE
		//SKIP_BODY:忽略标签的主题内容（标签体）
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
			return SKIP_BODY;//忽略标签的主题内容（标签体）
		}
		//有两个固定的返回值 SKIP_BODY,EVAL_BODY_AGAIN
		//SKIP_BODY:忽略标签的主题内容（标签体）
		//EVAL_BODY_AGAIN：重复执行标签体重的内容
	}
	

	public int doEndTag() throws JspException {
		index = 0;
		iterator = null;
		var = null;
		//有两个固定的返回值 SKIP_BODY,EVAL_BODY_AGAIN
		//EVAL_PAGE:继续运行标签后面的内容
		//SKIP_PAGE:忽略标签结束后面的内容
		return EVAL_PAGE;
	}

	//标签结束以后释放资源
	public void release() {
		index = 0;
		iterator = null;
		var = null;
	}

	//setter/getter
	

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public Object getItems() {
		return items;
	}

	public void setItems(Object items) {
		this.items = items;
	}
	
}
