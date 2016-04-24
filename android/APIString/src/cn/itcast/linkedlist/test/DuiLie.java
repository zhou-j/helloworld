package cn.itcast.linkedlist.test;

import java.util.LinkedList;

public class DuiLie {
	private LinkedList link;

	public DuiLie() {
		link = new LinkedList();
	}

	public void myAdd(Object obj) {
		link.addLast(obj);

	}
	public Object myGet(){
		return link.removeFirst();
	}
	
	public boolean isNull(){
		return link.isEmpty();
	}

	public static void main(String[] args) {

	}

	
}
