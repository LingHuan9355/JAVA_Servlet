package com.cshr.test;

import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.junit.Test;

import com.cshr.dao.SaxDao;
import com.cshr.entity.Student;


public class TestSax {

	@Test
	public void TestMain() throws Exception{
		  SaxDao saxDao = new SaxDao();
		  
		  //����sax����ʵ��
		  SAXParserFactory spf = SAXParserFactory.newInstance();
		  //�ӹ������sax������
		  SAXParser sp = spf.newSAXParser();
		  sp.parse("student.xml", saxDao);
		  
		 // char [] arrys = {'a','b','c','d','e'};
		 // String str = new String(arrys, 0, arrys.length);
		 // System.out.println(str);
		  
		  List<Student> list = saxDao.getList();
		  System.out.println(list.size());
	}
}
