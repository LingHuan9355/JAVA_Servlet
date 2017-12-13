package com.cshr.test.test;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * 
 *<p>Title:MyTestDomXML </p>
 *Description: 
 *2.构建使用Document对象,构建一个类似于下面的xml,写入xml文件
 *<users>
      <user id="1001" sex="男">
         <name>tom</name>
         <birth>2005-01-01</birth>
      </user>


      <user id="1002" sex="女">
         <name>jerry</name>
         <birth>2008-03-03</birth>
      </user>
  </users>
 *@author LH
 *@date 2017-12-13上午11:34:37
 *@version V1.0
 */
public class MyTestDomXML {
           
			/**
			 * java-->xml
			 * @throws Exception 
			 */
	      @Test
	      public void myTest() throws Exception{
	    	    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	    	    DocumentBuilder db = dbf.newDocumentBuilder();
                Document doc = db.newDocument();
                
                Element root = doc.createElement("users");
                doc.appendChild(root);
                
                Element user = doc.createElement("user");
                user.setAttribute("id", "1001");
                user.setAttribute("sex", "男");
                root.appendChild(user);
                
                Element user2 = doc.createElement("user");
                user2.setAttribute("id", "1002");
                user2.setAttribute("sex", "女");
                root.appendChild(user2);
                
                
                
                Element name = doc.createElement("name");
                name.setTextContent("Tom");
                Element birth = doc.createElement("birth");
                birth.setTextContent("2017-12-13");                
                user.appendChild(name);
                user.appendChild(birth);
                
                Element name2 = doc.createElement("name");
                name2.setTextContent("Cat");
                Element birth2 = doc.createElement("birth");
                birth2.setTextContent("2017-12-14");
                user2.appendChild(name2);
                user2.appendChild(birth2);
                
                TransformerFactory tff = TransformerFactory.newInstance();
                Transformer tf = tff.newTransformer();
                DOMSource ds = new DOMSource(doc);
                StreamResult sr = new StreamResult("user.xml");
                tf.transform(ds, sr);
	      }
}
