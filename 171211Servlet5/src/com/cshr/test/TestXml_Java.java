package com.cshr.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


/**
 * 
 *<p>Title:MyTestXml </p>
 *Description: 
 * DOM(Document Ojbect Modal)����
 *
 *@author LH
 *@date 2017-12-12����11:00:47
 *@version V1.0
 */
public class TestXml_Java  {
	
     /**
      *  xml-->java
     * @throws IOException 
     * @throws SAXException 
      */
	@Test
	public void TestMain() throws Exception{
		
		//1.�õ�DOM �������Ĺ���ʵ��
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		//2.�� DOM ������� DOM ������
		DocumentBuilder db = dbf.newDocumentBuilder();
		//3.Ҫ������ XML �ĵ�ת��Ϊ���������Ա� DOM ������������
		InputStream is = new FileInputStream("student.xml");
		//4.���� XML �ĵ������������õ�һ�� Document
		Document doc = db.parse(is);
		
		//5.��ȡ�ĵ���ָ�����ƵĽڵ�(����)
		NodeList nodelist = doc.getElementsByTagName("student");
	    for (int i = 0; i < nodelist.getLength(); i++) {
	    	//�ڶ���ڵ��а��±��ȡÿ��student�ڵ�
	    	Element stuNode = (Element) nodelist.item(i);
	    	//��ȡstudent�ڵ��е���������
	    	String id = stuNode.getAttribute("id");
	    	System.out.println("id:" + id);
	    	
	    	 //��ȡname�ڵ�
	    	NodeList nameNodes = stuNode.getElementsByTagName("name");
	    	Element nameNode = (Element) nameNodes.item(0);
	       //Element nameNode2 =  (Element) stuNode.getChildNodes();
	    	//��ȡname�ڵ��е��ı�ֵ
	    	String name = nameNode.getTextContent();
	       //String name2 = nameNode2.getTextContent();
	    	System.out.println("������" + name);
	    	//System.out.println("������" + name2.trim());
		}
		
		
	}
}
