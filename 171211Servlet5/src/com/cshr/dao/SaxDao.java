package com.cshr.dao;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.cshr.entity.Student;

public class SaxDao extends DefaultHandler {

	private List<Student> list = new ArrayList<Student>();
	private Student stu = null;
	public List<Student> getList(){
		return list;
	}
	
	@Override
	public void startDocument() throws SAXException {
		//System.out.println("startDocument...");
	}


	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		//System.out.println("start..." +qName);
		if(qName.equals("student")){
			stu = new Student();
			String id = attributes.getValue("id");
			System.out.println(id);
			stu.setId(id);
		}
	}

	
	@Override
	public void characters(char[] ch, int start, int length)
	throws SAXException {
		//System.out.println("characters...");
		String name = new String(ch, start, length);
		if(name.trim().length()>0){
			stu.setName(name);
			System.out.println(name);
		}
	}
	
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		//System.out.println("end..." + qName);
		if(qName.equals("student")){
			list.add(stu);
		}
	}

	@Override
	public void endDocument() throws SAXException {
		//System.out.println("endDocument...");
	}
	
}
