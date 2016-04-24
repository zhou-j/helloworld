package cn.itcast.otherapi;

import java.util.Random;

public class MathDemo {

	public static void main(String[] args) {

		 /*
		  * Math:提供了操作数学运算的方法，是静态的。
		  * 
		  * 常用方法：
		  * ciel()；返回回大于参数的最小整数。
		  * floor();返回小于参数的最大整数。
		  * round()；返回四舍五入的整数。
		  * pow(a,b):a的b次方。
		  * */
	//	double d1 = Math.ceil(12.56);
	//	double d2 = Math.floor(12.56);
	//	double d3 = Math.round(12.56);
	//	
	//	sop("d1="+d1);
	//	sop("d2="+d2);
	//	sop("d3="+d3);
	//	double d = Math.pow(2,10);
	//	sop("d="+d);
		Random r = new Random();
		for(int i =0;i<10;i++){
			
		//	double d = Math.floor(Math.random()*10);
			double d = (int)(r.nextDouble()*6 +1);
			System.out.println(d);
		}
		
}

	public static void sop(String string) {
		System.out.println(string);
	}
	}
