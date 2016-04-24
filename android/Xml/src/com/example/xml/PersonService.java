package com.example.xml; 
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;

import android.util.Xml;

public class PersonService {
	
	public List<Person> loadPersons(InputStream in) throws Exception {
		XmlPullParser parser = Xml.newPullParser();//获取解析器
		parser.setInput(in,"UTF-8");               //设置输入流
		
		ArrayList<Person> persons = new ArrayList<Person>();
		Person p = null;
		
		//最初赋值为第一个事件，只要不是文档结束就循环，每次循环后解析下一个事件
		for(int type = parser.getEventType();type !=XmlPullParser.END_DOCUMENT;type = parser.next()){ 
			if(type == XmlPullParser.START_TAG){	//如果遇到了标签开始事件
			if(parser.getName().equals("person")){   //如果标签名为person
				      p = new Person();                   //创建对象
				      String id = parser.getAttributeValue(0); //获取第一个属性的属性值
				      p.setId(Integer.parseInt(id));        //转为int，设置id
				      persons.add(p);                        //装入集合
				}else if (parser.getName().equals("name")){  //如果标签名为name
					String name = parser.nextText();          //设置下一个文本
					 p.setNameString(name);                  //设置name
				}else if (parser.getName().equals("age")) {   //如果标签名为“age"
					String age = parser.nextText();          //获取下一个文本
					p.setAge(Integer.parseInt(age));          //设置age
					
				}
			}
		}
		return persons;    
	}

}
