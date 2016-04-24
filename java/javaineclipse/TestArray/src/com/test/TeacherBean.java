package com.test;

import java.util.List;

/**
 * ¿œ ¶¿‡
 * @author jack
 *
 */
public class TeacherBean {
public String teano;
public String teaname;
public List<StudentBean> stuList;
public String getTeano() {
	return teano;
}
public void setTeano(String teano) {
	this.teano = teano;
}
public String getTeaname() {
	return teaname;
}
public void setTeaname(String teaname) {
	this.teaname = teaname;
}
public List<StudentBean> getStuList() {
	return stuList;
}
public void setStuList(List<StudentBean> stuList) {
	this.stuList = stuList;
}

}
