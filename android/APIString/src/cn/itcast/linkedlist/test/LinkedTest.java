package cn.itcast.linkedlist.test;

import java.util.LinkedList;

public class LinkedTest {
	/*
	 * 请使用LinkedList来模拟一个堆栈或者队列数据结构。 堆栈：先进先出first In Last Out Filo 队列：先进先出First
	 * In First Out FIFO
	 * 
	 * 我们应该描述这样一个容器，给使用者提供一个容器对象完成这两种结构的一种。
	 */
	

	public static void main(String[] args) {
       
		DuiLie a = new DuiLie() ;
		a.myAdd("abc1");
		a.myAdd("abc2");
		a.myAdd("abc3");
		a.myAdd("abc4");
		while(!a.isNull()){
			System.out.println(a.myGet());
		}
	}

}
