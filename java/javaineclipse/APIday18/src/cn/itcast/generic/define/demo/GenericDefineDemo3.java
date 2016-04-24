package cn.itcast.generic.define.demo;

import cn.itcast.bean.Student;

public class GenericDefineDemo3 {

	public static void main(String[] args) {
		
    //  Tool tool = new Tool();
      
     // tool.setObject(new Student());
      
      //Student stu = (Student)tool.getObject();
		Tool<Student>tool = new Tool<Student>();
		
		tool.setObject(new Student());
		Student stu = (Student)tool.getObject();
	}

	
}
