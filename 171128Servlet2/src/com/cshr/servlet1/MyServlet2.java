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
 *在Servlet中获取request中的保存的属性值
 *@author LH
 *@date 2017-11-30上午12:03:06
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
		//获取reqeust中所保存的所有键名
		Enumeration<String> ems = request.getAttributeNames();
		
		while (ems.hasMoreElements()) {
			String name = (String) ems.nextElement();
			
			String values = (String) request.getAttribute(name);
			System.out.println(name + "=" +values);
			//out.println(name + "=" +values);
			
		}
		
		//uri(相对路径)
		//相对路径:/171128Servlet2/myServlet2
		String uri = request.getRequestURI();
		System.out.println("相对路径:"+uri);
		out.println("相对路径:"+uri +"\t");
		
		//url(绝对路径)
		//绝对路径:http://localhost:8080/171128Servlet2/myServlet2
		StringBuffer url = request.getRequestURL();
		System.out.println("绝对路径:"+url);
		out.println("绝对路径:"+url+"\t");
		
		//获取当前项目中指定文件夹在服务器中的绝对路径
		//直接写双引号表示项目的根路径
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
