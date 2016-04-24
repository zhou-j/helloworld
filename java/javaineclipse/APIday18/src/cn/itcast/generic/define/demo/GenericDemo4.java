package cn.itcast.generic.define.demo;

public class GenericDemo4 {

	public static void main(String[] args) {
		
		Tool<String>tool = new Tool<String>();
		
		tool.show(new Integer(4));
		tool.show("haha");
		tool.print("haha");

	}

}
