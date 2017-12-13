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

import com.cshr.test.entity.User;

/**
 * 
 *<p>Title:MyTestDomDao </p>
 *Description: 
 *  
 *3.在user.xml中添加一个user
 *4.修改user中id = 1002 的姓名与生日
 *5.删除user中id = 1002
 *@author LH
 *@date 2017-12-13上午11:30:57
 *@version V1.0
 */
public class DomDao {

    private String path="user.xml";
	    
	//查询
    public List<User> queryList() throws Exception{
    	List<User> list = new ArrayList<User>();
    	
    	Document doc = readXML();
    	
        NodeList nodeLists = doc.getElementsByTagName("user");
        for (int i = 0; i < nodeLists.getLength(); i++) {
			  User us = new User();
			  Element userNode = (Element) nodeLists.item(i);
			  us.setId(userNode.getAttribute("id"));
			  us.setSex(userNode.getAttribute("sex"));
			  
			  NodeList nameNode = userNode.getElementsByTagName("name");
		      NodeList birthNode = userNode.getElementsByTagName("birth");
		      
		      Element name = (Element) nameNode.item(0);
		      Element birth = (Element) birthNode.item(0);
		      
		      us.setName(name.getTextContent());
		      us.setBrith(birth.getTextContent());
		      
		      list.add(us);
		}
    	
    	return list;
    }
    
	//添加
	public void insert(User us) throws Exception{
		    Document doc = readXML();
		    
		    Element user = doc.createElement("user");
		    user.setAttribute("id", us.getId());
		    user.setAttribute("sex", us.getSex());
		    
		    Element name = doc.createElement("name");
		    name.setTextContent(us.getName());
		    user.appendChild(name);
		    
		    Element birth = doc.createElement("birth");
		    birth.setTextContent(us.getBrith());
		    user.appendChild(birth);
		    
		    //获取根对象
		    Element root = (Element) doc.getElementsByTagName("users").item(0);
		    root.appendChild(user);
		    
		    WriteXML(doc);
	  }

	//修改
	public void modify(User us) throws Exception{
		Document doc = readXML();
		
		NodeList nodeLists = doc.getElementsByTagName("user");
		for (int i = 0; i < nodeLists.getLength(); i++) {
			Element userNode = (Element) nodeLists.item(i);
			String id = userNode.getAttribute("id");
			if(id.equals(us.getId())){
				Element nameNode = (Element) userNode.getElementsByTagName("name").item(0);
				Element birthNode = (Element) userNode.getElementsByTagName("birth").item(0);
				
				nameNode.setTextContent(us.getName());
				birthNode.setTextContent(us.getBrith());
			}
		}   
		WriteXML(doc);
	}
	
	//删除
	public void delete(String sid) throws Exception{
		   Document doc = readXML();
		   
		   NodeList nodeLists = doc.getElementsByTagName("user");
		   for (int i = 0; i <nodeLists.getLength(); i++) {
			        Element userNode =(Element) nodeLists.item(i);
			        String id = userNode.getAttribute("id");
			        if(id.equals(sid)){
			        	/*Element nameNode = (Element) userNode.getElementsByTagName("name").item(0);
			        	Element birthNode = (Element) userNode.getElementsByTagName("birth").item(0);
			        	
			        	userNode.removeChild(nameNode);
			        	userNode.removeChild(birthNode);*/
			        	userNode.getParentNode().removeChild(userNode);
			        }
			        
		    }
		   WriteXML(doc);
	}

	private void WriteXML(Document doc)
			throws TransformerFactoryConfigurationError,
			TransformerConfigurationException, TransformerException {
		TransformerFactory tff = TransformerFactory.newInstance();
		Transformer tf = tff.newTransformer();
		DOMSource ds = new DOMSource(doc);
		StreamResult sr = new StreamResult(path);
		tf.transform(ds, sr);
	}


	private Document readXML() throws ParserConfigurationException,
			FileNotFoundException, SAXException, IOException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		InputStream is = new FileInputStream(path);
		Document doc = db.parse(is);
		return doc;
	}
	  
	
	 
}
