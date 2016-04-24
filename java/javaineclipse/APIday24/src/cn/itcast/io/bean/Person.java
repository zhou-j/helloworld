package cn.itcast.io.bean;

import java.io.Serializable;
/*
 * Serializable�����ڸ������л��������Id�š�
 * �����ж���Ͷ����Ƿ���ͬһ���汾��
 * 
 * 
 * */
public class Person implements Serializable /*��ǽӿ�*/{
	
	/**
	 * transient:�Ǿ�̬���ݲ��뱻���л�����ʹ������ؼ������Ρ�
	 */
	private static final long serialVersionUID = 1443423344;
	private transient  String name;
	private  int age;
	
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	
}