package cn.itcast.toolclass.arrays.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ToArray {

	public static void main(String[] args) {
		
		/*
		 * ����ת�����顣
		 * 
		 * ʹ�õľ���Collection�ӿ��е�toArray������
		 * 
		 * ����ת�����飺���ԶԼ����е� Ԫ�ز����ķ��������޶������������������ɾ��
		 * 
		 * 
		 * 
		 * */
		List<String> list = new ArrayList<String>();
		list.add("abc1");
		list.add("abc2");
		list.add("abc3");
		/*
		 * toArray������Ҫ����һ��ָ�����͵����顣
		 * ���ȸ���ζ����أ�
		 * ������� С�ڼ��ϵ�Size����ô�÷����ᴴ��һ��ͬ���Ͳ��ͼ�����ͬsize�����顣
		 * ������ȴ��ڼ��ϵ�Size����ô�÷����ͻ�ʹ��ָ�������飬�洢�����е�Ԫ�أ�����λ��Ĭ��Ϊnull��
		 * 
		 * ���Խ��飬��󳤶Ⱦ�ָ��Ϊ���ϵ�size��*/

		String[] arr = list.toArray(new String[5]);
		
		System.out.println(Arrays.toString(arr));
	}

}