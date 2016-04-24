package com.example.xml;

public class Person {
     private Integer id;
     private String nameString;
     private Integer age;
     
     
	public Person() {
		super();
		
	}
	
	public Person(Integer id, String nameString, Integer age) {
		super();
		this.id = id;
		this.nameString = nameString;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", nameString=" + nameString + ", age="
				+ age + "]";
	}
	
     
     
}
