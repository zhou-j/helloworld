package com.example.xml;

import java.io.InputStream;
import java.util.List;

import android.test.AndroidTestCase;

public class PersonTest extends AndroidTestCase {
	
	public void testLoad() throws Exception{
	PersonService service = new PersonService();
	InputStream in = PersonTest.class.getClassLoader().getResourceAsStream("persons.xml");
    List<Person> persons = service.loadPersons(in);
    for(Person p:persons)
    	System.out.println(p);
         }
}
