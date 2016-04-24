package cn.itcast.bean;

public class Worker extends Person {

	@Override
	public String toString() {
		return "Worker:"+this.getName()+":"+this.getAge();
	}

	public Worker() {
		super();
		
	}

	public Worker(String name, int age) {
		super(name, age);
		
	}

	public static void main(String[] args) {

	}

}
