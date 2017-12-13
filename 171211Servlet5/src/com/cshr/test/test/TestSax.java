package com.cshr.test.test;

import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.junit.Test;


import com.cshr.test.entity.Role;
import com.cshr.test.sax.SAXDao;


public class TestSax {

	@Test
	public void TestMian() throws Exception{
        SAXDao saxDao = new SAXDao();
		
		SAXParserFactory spf = SAXParserFactory.newInstance();
		SAXParser sp = spf.newSAXParser();
		
		sp.parse("role.xml", saxDao);
		
		List<Role> list = saxDao.getList();
		System.out.println(list.size());
	}
}
