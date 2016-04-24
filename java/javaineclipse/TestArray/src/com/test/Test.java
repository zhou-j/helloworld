package com.test;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

/*
 * 运行结果：{"stuList":[{"stuname":"stu_jack","stuno":"stu001"},{"stuname":"stu_jack2","stuno":"stu002"}],"teaname":"tea_jack","teano":"tea_001"}
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TeacherBean tbBean = new TeacherBean();
		List<StudentBean> stuList1 = new ArrayList<StudentBean>();
		StudentBean sBean1 = new StudentBean();
		sBean1.setStuno("stu001");
		sBean1.setStuname("stu_jack");
		StudentBean sBean2 = new StudentBean();
		sBean2.setStuno("stu002");
		sBean2.setStuname("stu_jack2");
		stuList1.add(sBean1);
		stuList1.add(sBean2);
		tbBean.setTeano("tea_001");
		tbBean.setTeaname("tea_jack");
		tbBean.setStuList(stuList1);
		String json = writeJson(tbBean);
		System.out.println(json);

	}

	public static String writeJson(Object object) {
		try {
			String json = JSON.toJSONStringWithDateFormat(object,
					"yyyy-MM-dd HH:mm:ss");
			return json;
		} catch (Exception e) {
		}
		return null;
	}

}
