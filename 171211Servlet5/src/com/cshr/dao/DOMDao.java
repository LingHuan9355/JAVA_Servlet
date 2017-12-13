package com.cshr.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.cshr.entity.Student;

//ctrl+shift+o 导包
public class DOMDao {

	
	private String path = "student.xml";
	
	//查询
	public List<Student> queryList() throws Exception{
		List<Student> list = new ArrayList<Student>();
		
		Document doc = readXML();
		
		//5.获取文档中指定名称的节点(集合)
		NodeList stuNodes = doc.getElementsByTagName("student");
		for (int i = 0; i < stuNodes.getLength(); i++) {
			
			Student student = new Student();
			//在多个节点中按下标获取每个student节点
			Element stuNode = (Element) stuNodes.item(i);
			//获取student节点中的属性内容,并且设置到student对象中
			student.setId(stuNode.getAttribute("id"));
			
			//获取student节点下的name节点
			NodeList nameNodes = stuNode.getElementsByTagName("name");
			//在节点中按下标获取第一个student节点
			Element nameNode = (Element) nameNodes.item(0);
			//获取name节点中的属性内容,并且设置到student对象中
			student.setName(nameNode.getTextContent());
			
			list.add(student);
		}
		
		return list;
	}

	//添加
	public void insert(Student stu) throws Exception{
		Document doc =readXML();
		
		Element student = doc.createElement("student");
		student.setAttribute("id", stu.getId());
		
		Element name = doc.createElement("name");
        name.setTextContent(stu.getName());
        
        student.appendChild(name);
        
        //获取根对象
        Element root =(Element) doc.getElementsByTagName("students").item(0);
        root.appendChild(student);
        
        writeXML(doc);
	}
	
	public void modify(Student stu) throws Exception{
		Document doc = readXML();
		 
		NodeList stuNodes = doc.getElementsByTagName("student");
		for (int i = 0; i < stuNodes.getLength(); i++) {
			   Element stuNode = (Element) stuNodes.item(i);
			   String id = stuNode.getAttribute("id");
			   
			   if(id.equals(stu.getId())){
				   Element nameNode = (Element) stuNode.getElementsByTagName("name").item(0);
				   nameNode.setTextContent(stu.getName());
				   //stuNode.removeChild(nameNode);
			   }
		}
		 writeXML(doc);
	}
	
	//删除
	public void delete(String sid) throws Exception{
		Document doc = readXML();
		NodeList stuNodes = doc.getElementsByTagName("student");
		for (int i = 0; i < stuNodes.getLength(); i++) {
			 Element stuNode = (Element) stuNodes.item(i);
			 String id = stuNode.getAttribute("id");
			 
			 if(id.equals(sid)){
				  ////删除student节点，追溯到该节点的父节点下的该节点
				 stuNode.getParentNode().removeChild(stuNode);
			 }
		}
		writeXML(doc);
	}

	//写入xml
	private void writeXML(Document doc) throws Exception {
		TransformerFactory tff = TransformerFactory.newInstance();
        Transformer tf = tff.newTransformer();
        DOMSource ds = new DOMSource(doc);
        StreamResult sr = new StreamResult(path);
        tf.transform(ds, sr);
	}
	
	//读取解析xml
	private Document readXML() throws Exception {
		//1.得到DOM 解析器的工厂实例
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		//2.从 DOM 工厂获得 DOM 解析器
		DocumentBuilder db = dbf.newDocumentBuilder();
		//3.要解析的 XML 文档转化为输入流，以便 DOM 解析器解析它
		InputStream is = new FileInputStream(path);
		//4.解析 XML 文档的输入流，得到一个 Document
		Document doc = db.parse(is);
		return doc;
	}
}
