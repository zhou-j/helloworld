package com.blog.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.blog.util.StringUtils;

/**
 * 
 * 大写标签转换 ToUpperTag<BR>
 * 创建人:潭州学院-keke <BR>
 * 时间：2014年11月15日-下午9:34:09 <BR>
 * 
 * @version 1.0.0
 * 
 */
public class LoopUpperLowerTag extends BodyTagSupport {

	private static final long serialVersionUID = 1L;
	private Integer count = 1;
	
	//将userDao转变成自定义标签的业务类，参数可以灵活的配置时间的配需和状态的控制.分页.
	//<tz:userDao var="user" sort="0/1默认值是0" status="0/1默认设置是1" begin="1" end="10">
	// <p>${user.name}</p>
	//</tz:userDao>
	
	public void doInitBody(){
		//调用某个页面的处理方法。初始化
		System.out.println("-=-=============");
	}

	// dostartTag===默认返回值:retrun EVAL_SKIP_INCLUDE
	// doendTag===默认返回值: EVAL_PAGE
	public int doAfterBody() throws JspException {
		if (count > 0) {
			// 获取标签体的内容
			String str = getBodyContent().getString();
			try {
				// 输出标签体的内容
				if (StringUtils.isNotEmpty(str)) {
					this.getPreviousOut().println(str);
				}
				this.bodyContent.clearBody();// 清楚标签体的主题内容
			} catch (IOException e) {
			}
			count--;
			return EVAL_BODY_AGAIN;
		} else {
			count = 1;
			return SKIP_BODY;
		}
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}
