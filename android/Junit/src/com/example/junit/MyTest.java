package com.example.junit;


import android.test.AndroidTestCase;

public class MyTest extends AndroidTestCase {

	public void test1() {
		Service service = new Service();
		System.out.println(service.divide(10, 2));
	}
	
	public void test2() {
		Service service = new Service();
		System.out.println(service.divide(10, 0));
	}

}
