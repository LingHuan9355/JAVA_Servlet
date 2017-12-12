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
 * DOM(Document Ojbect Modal)解析
 *
 *@author LH
 *@date 2017-12-12上午11:00:47
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
		
		//1.得到DOM 解析器的工厂实例
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		//2.从 DOM 工厂获得 DOM 解析器
		DocumentBuilder db = dbf.newDocumentBuilder();
		//3.要解析的 XML 文档转化为输入流，以便 DOM 解析器解析它
		InputStream is = new FileInputStream("student.xml");
		//4.解析 XML 文档的输入流，得到一个 Document
		Document doc = db.parse(is);
		
		//5.获取文档中指定名称的节点(集合)
		NodeList nodelist = doc.getElementsByTagName("student");
	    for (int i = 0; i < nodelist.getLength(); i++) {
	    	//在多个节点中按下标获取每个student节点
	    	Element stuNode = (Element) nodelist.item(i);
	    	//获取student节点中的属性内容
	    	String id = stuNode.getAttribute("id");
	    	System.out.println("id:" + id);
	    	
	    	 //获取name节点
	    	NodeList nameNodes = stuNode.getElementsByTagName("name");
	    	Element nameNode = (Element) nameNodes.item(0);
	       //Element nameNode2 =  (Element) stuNode.getChildNodes();
	    	//获取name节点中的文本值
	    	String name = nameNode.getTextContent();
	       //String name2 = nameNode2.getTextContent();
	    	System.out.println("姓名：" + name);
	    	//System.out.println("姓名：" + name2.trim());
		}
		
		
	}
}
