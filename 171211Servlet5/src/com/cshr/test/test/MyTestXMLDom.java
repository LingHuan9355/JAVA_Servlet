package com.cshr.test.test;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * 
 *<p>Title:MyTestDom </p>
 *Description: 
 *1.手写一个books.xml中写入以下标签使用DOM解析方式，读出xml的元素
 <books>
   <book id="1001">
       <name>java</name>
   </book>
   
   <book id="1002">
       <name>c#</name>
   </book>
</books>

 *@author LH
 *@date 2017-12-13上午11:03:30
 *@version V1.0
 */
public class MyTestXMLDom {

	        public static final String PATH = "books.xml";         
	
			@Test
			public void TestMain() throws Exception{
				
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				DocumentBuilder db =dbf.newDocumentBuilder();
				InputStream is = new FileInputStream(PATH);
				Document doc = db.parse(is);
				
				NodeList nodeLists = doc.getElementsByTagName("book");
				for (int i = 0; i < nodeLists.getLength(); i++) {
					Element bookNode = (Element) nodeLists.item(i);
					String id = bookNode.getAttribute("id");
					System.out.println("id=" + id);
					
					NodeList nameNodes =bookNode.getElementsByTagName("name");
					Element nameNode = (Element) nameNodes.item(0);
					String name = nameNode.getTextContent();
					System.out.println("name=" + name);
				}
			}
			
	
	
	
	
	
}
