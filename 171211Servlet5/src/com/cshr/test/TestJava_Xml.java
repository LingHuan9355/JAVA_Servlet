package com.cshr.test;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * 
 *<p>Title:TestJava_Xml </p>
 *Description: 
 *
 *@author LH
 *@date 2017-12-12下午01:29:24
 *@version V1.0
 */
public class TestJava_Xml {

                 
	/**
	 *  java-->xml
	 * @throws Exception 
	 */
	@Test
	public void TestMain() throws Exception{
		  DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		  DocumentBuilder db = dbf.newDocumentBuilder();
		  Document doc = db.newDocument();
		  
		  //1.自己创建文档中的元素(根节点)
		  Element root = doc.createElement("teachers");
		   //把根节点添加到文档中
		  doc.appendChild(root);
		  
		   //2.创建teacher的子节点
		  Element teacher = doc.createElement("teacher");
		   //设置一个属性
		  teacher.setAttribute("id", "10");
		  
		   //把节点挂到根节点上面
		  root.appendChild(teacher);
		
		  //3. 创建name子节点  
		  Element name = doc.createElement("name");
		  //设置一个属性
		  name.setTextContent("tom");
		  //把节点挂到根节点上面
          teacher.appendChild(name);		  
		  
          //4.创建城管公司
          TransformerFactory tff = TransformerFactory.newInstance();
          //5.城管小队
          Transformer tf = tff.newTransformer();
           //6.指定拆迁源
          DOMSource domSource = new DOMSource(doc);
          //7.拆到哪去
          StreamResult sr = new StreamResult("teacher.xml");
           //8.干活
          tf.transform(domSource, sr);
          
          
	}

}
