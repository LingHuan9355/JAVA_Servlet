package com.cshr.test.sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.cshr.test.entity.Role;

/**
 * 
 *<p>Title:SAXDao </p>
 *Description: 
 *
 *2.用SAX解析上面XMl文件
 *@author LH
 *@date 2017-12-13下午04:33:02
 *@version V1.0
 */
public class SAXDao extends DefaultHandler {

	private List<Role> list = new ArrayList<Role>();
	private Role role = null;
	
	public List<Role> getList() {
		return list;
	}



	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
	         String name = new String(ch, start, length);
	         if(name.trim().length()>0){
	        	 role.setName(name);
	        	 System.out.println(name);
	         }
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("endDocument...");
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
	        if(qName.equals("role")){
	        	list.add(role);
	        }
	         
	}

	@Override
	public void startDocument() throws SAXException {
		System.out.println("startDocument...");
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		 if(qName.equals("role")){
			 role = new Role();
			 String id = attributes.getValue("id");
			 System.out.print(id+"\t");
			 role.setId(id);
		 }
	}

	
}
