package com.cshr.servlet1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 *<p>Title:MyServlet2 </p>
 *<p>Description: </p>
 *��Servlet�л�ȡrequest�еı��������ֵ
 *@author LH
 *@date 2017-11-30����12:03:06
 *@version V1.0
 */
public class MyServlet2 extends GenericServlet {

	@SuppressWarnings("unchecked")
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {

		HttpServletRequest request = (HttpServletRequest) req;
		@SuppressWarnings("unused")
		HttpServletResponse response = (HttpServletResponse) res;
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//��ȡreqeust������������м���
		Enumeration<String> ems = request.getAttributeNames();
		
		while (ems.hasMoreElements()) {
			String name = (String) ems.nextElement();
			
			String values = (String) request.getAttribute(name);
			System.out.println(name + "=" +values);
			//out.println(name + "=" +values);
			
		}
		
		//uri(���·��)
		//���·��:/171128Servlet2/myServlet2
		String uri = request.getRequestURI();
		System.out.println("���·��:"+uri);
		out.println("���·��:"+uri +"\t");
		
		//url(����·��)
		//����·��:http://localhost:8080/171128Servlet2/myServlet2
		StringBuffer url = request.getRequestURL();
		System.out.println("����·��:"+url);
		out.println("����·��:"+url+"\t");
		
		//��ȡ��ǰ��Ŀ��ָ���ļ����ڷ������еľ���·��
		//ֱ��д˫���ű�ʾ��Ŀ�ĸ�·��
		//E:\libs\apache-tomcat\apache-tomcat-6.0.32\webapps\171128Servlet2
		String realPath = this.getServletContext().getRealPath("");
		 System.out.println(realPath);
		 out.println(realPath+"\t");
		 
		 //E:\libs\apache-tomcat\apache-tomcat-6.0.32\webapps\171128Servlet2
		 String realPath1 = request.getRealPath("");
		 System.out.println(realPath1);
		 out.println(realPath1+"\t");
		 
		 //E:\libs\apache-tomcat\apache-tomcat-6.0.32\webapps\171128Servlet2\WEB-INF
		 String realPath2 = request.getRealPath("/WEB-INF");
		 //String realPath2 = request.getRealPath("/web-inf");
		 System.out.println(realPath2);
		 out.println(realPath2+"\t");
		
		
	}

}
