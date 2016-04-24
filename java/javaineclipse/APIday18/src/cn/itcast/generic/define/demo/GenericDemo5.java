package cn.itcast.generic.define.demo;

public class GenericDemo5 {

	public static void main(String[] args) {
		InterImp1 in = new InterImp1();
		in.show("abc");
		InterImp12<Integer> in2 = new InterImp12<Integer>();
		in2.show(5);

	}

}

interface Inter<T>{
	public void show(T t);
	
}

class InterImp12<Q> implements Inter<Q>{
	public void show(Q q){
		System.out.println("show :"+q);
	}
}

class InterImp1 implements Inter<String>{
	public void show(String str){
		System.out.println("show :"+str);
	}
}
