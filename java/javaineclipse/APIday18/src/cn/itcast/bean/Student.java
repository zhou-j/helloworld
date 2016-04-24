package cn.itcast.bean;

public class Student extends Person {

	public Student() {
		super();
		
	}

	@Override
	public String toString() {
		return "Student:"+this.getName()+":"+this.getAge();
	}

	public Student(String name, int age) {
		super(name, age);
		
	}

	public static void main(String[] args) {

	}

}
