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
 *@date 2017-12-12����01:29:24
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
		  
		  //1.�Լ������ĵ��е�Ԫ��(���ڵ�)
		  Element root = doc.createElement("teachers");
		   //�Ѹ��ڵ���ӵ��ĵ���
		  doc.appendChild(root);
		  
		   //2.����teacher���ӽڵ�
		  Element teacher = doc.createElement("teacher");
		   //����һ������
		  teacher.setAttribute("id", "10");
		  
		   //�ѽڵ�ҵ����ڵ�����
		  root.appendChild(teacher);
		
		  //3. ����name�ӽڵ�  
		  Element name = doc.createElement("name");
		  //����һ������
		  name.setTextContent("tom");
		  //�ѽڵ�ҵ����ڵ�����
          teacher.appendChild(name);		  
		  
          //4.�����ǹܹ�˾
          TransformerFactory tff = TransformerFactory.newInstance();
          //5.�ǹ�С��
          Transformer tf = tff.newTransformer();
           //6.ָ����ǨԴ
          DOMSource domSource = new DOMSource(doc);
          //7.����ȥ
          StreamResult sr = new StreamResult("teacher.xml");
           //8.�ɻ�
          tf.transform(domSource, sr);
          
          
	}

}
