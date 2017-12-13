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

//ctrl+shift+o ����
public class DOMDao {

	
	private String path = "student.xml";
	
	//��ѯ
	public List<Student> queryList() throws Exception{
		List<Student> list = new ArrayList<Student>();
		
		Document doc = readXML();
		
		//5.��ȡ�ĵ���ָ�����ƵĽڵ�(����)
		NodeList stuNodes = doc.getElementsByTagName("student");
		for (int i = 0; i < stuNodes.getLength(); i++) {
			
			Student student = new Student();
			//�ڶ���ڵ��а��±��ȡÿ��student�ڵ�
			Element stuNode = (Element) stuNodes.item(i);
			//��ȡstudent�ڵ��е���������,�������õ�student������
			student.setId(stuNode.getAttribute("id"));
			
			//��ȡstudent�ڵ��µ�name�ڵ�
			NodeList nameNodes = stuNode.getElementsByTagName("name");
			//�ڽڵ��а��±��ȡ��һ��student�ڵ�
			Element nameNode = (Element) nameNodes.item(0);
			//��ȡname�ڵ��е���������,�������õ�student������
			student.setName(nameNode.getTextContent());
			
			list.add(student);
		}
		
		return list;
	}

	//���
	public void insert(Student stu) throws Exception{
		Document doc =readXML();
		
		Element student = doc.createElement("student");
		student.setAttribute("id", stu.getId());
		
		Element name = doc.createElement("name");
        name.setTextContent(stu.getName());
        
        student.appendChild(name);
        
        //��ȡ������
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
	
	//ɾ��
	public void delete(String sid) throws Exception{
		Document doc = readXML();
		NodeList stuNodes = doc.getElementsByTagName("student");
		for (int i = 0; i < stuNodes.getLength(); i++) {
			 Element stuNode = (Element) stuNodes.item(i);
			 String id = stuNode.getAttribute("id");
			 
			 if(id.equals(sid)){
				  ////ɾ��student�ڵ㣬׷�ݵ��ýڵ�ĸ��ڵ��µĸýڵ�
				 stuNode.getParentNode().removeChild(stuNode);
			 }
		}
		writeXML(doc);
	}

	//д��xml
	private void writeXML(Document doc) throws Exception {
		TransformerFactory tff = TransformerFactory.newInstance();
        Transformer tf = tff.newTransformer();
        DOMSource ds = new DOMSource(doc);
        StreamResult sr = new StreamResult(path);
        tf.transform(ds, sr);
	}
	
	//��ȡ����xml
	private Document readXML() throws Exception {
		//1.�õ�DOM �������Ĺ���ʵ��
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		//2.�� DOM ������� DOM ������
		DocumentBuilder db = dbf.newDocumentBuilder();
		//3.Ҫ������ XML �ĵ�ת��Ϊ���������Ա� DOM ������������
		InputStream is = new FileInputStream(path);
		//4.���� XML �ĵ������������õ�һ�� Document
		Document doc = db.parse(is);
		return doc;
	}
}
