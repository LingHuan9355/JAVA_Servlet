package com.cshr.test.dao;

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

import com.cshr.test.entity.Role;

/**
 * 
 *<p>Title:XMLDao </p>
 *Description: 
 *
 *在XMLDao中添加以下方法
 *public List findAll();
 *public void addRole(Role r);
 *public void updateRoleById(String id);
 *public void deleteRoleById(String id);
 *测试上面的方法
 *
 *@author LH
 *@date 2017-12-13下午03:32:49
 *@version V1.0
 */
public class XMLDao {

	public static final String PATH="role.xml";
	
	//查询
	@SuppressWarnings("unchecked")
	public List findAll() throws Exception{
		List<Role> list = new ArrayList<Role>();
		
		Document doc = readXML();
		
		NodeList nodeLists = doc.getElementsByTagName("role");
		for (int i = 0; i < nodeLists.getLength(); i++) {
			     Role role = new Role();
			
			     Element roleNode = (Element) nodeLists.item(i);
			     role.setId(roleNode.getAttribute("id"));
			     
			     NodeList nameNodes = roleNode.getElementsByTagName("name");
			     Element nameNode = (Element) nameNodes.item(0);
			     role.setName(nameNode.getTextContent());
			     
			     list.add(role);
			     
		}
		
		return list;
	}

	//添加
	public void addRole(Role r) throws Exception{
		  Document doc = readXML();
          Element role = doc.createElement("role");
          role.setAttribute("id", r.getId());
          
          Element name = doc.createElement("name");
          name.setTextContent(r.getName());
          
          role.appendChild(name);
          
        //获取根对象
          Element root = (Element) doc.getElementsByTagName("roles").item(0);
          root.appendChild(role);
          
          //写入数据
          writeXML(doc);
          
	}
	
	//修改
	public void updateRoleById(String id) throws Exception{
		Document doc = readXML();
		NodeList roleLists  =doc.getElementsByTagName("role");
		for (int i = 0; i < roleLists.getLength(); i++) {
			Element roleList = (Element) roleLists.item(i);
			String sid = roleList.getAttribute("id");
			if(sid.equals(id)){
				Element nameNode = (Element) roleList.getElementsByTagName("name").item(0);
				nameNode.setTextContent("nonfemet");
			}
		}
		
		writeXML(doc);
		
	}
	//删除
	public void deleteRoleById(String id) throws Exception{
		 Document doc = readXML();
		 NodeList roleNodes = doc.getElementsByTagName("role");
		 for (int i = 0; i < roleNodes.getLength(); i++) {
			     Element roleNode = (Element) roleNodes.item(i);
			     String  sid = roleNode.getAttribute("id");
			     if(sid.equals(id)){
			    	 roleNode.getParentNode().removeChild(roleNode);
			     }
			
		}
		 writeXML(doc);
	}
	
	
     //写入数据
	private void writeXML(Document doc)
			throws TransformerFactoryConfigurationError,
			TransformerConfigurationException, TransformerException {
		TransformerFactory tff = TransformerFactory.newInstance();
          Transformer tf = tff.newTransformer();
          DOMSource ds = new DOMSource(doc);
          StreamResult sr = new StreamResult(PATH);
          tf.transform(ds, sr);
	}
	
	//读取xml
	private Document readXML() throws ParserConfigurationException,
			FileNotFoundException, SAXException, IOException {
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		InputStream is = new FileInputStream(PATH);
		Document doc = db.parse(is);
	        
		return doc;
	}
}
