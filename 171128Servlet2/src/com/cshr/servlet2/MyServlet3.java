package com.cshr.servlet2;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 *<p>Title:MyServlet3 </p>
 *<p>Description: </p>
 *3.在一个jsp页面中,分别向request，session和application设值，
 *然后转发到一个servlet中，拿出参数名和参数值，打印到 客户端
 *
 *@author LH
 *@date 2017-12-2上午12:11:10
 *@version V1.0
 */
@SuppressWarnings("serial")
public class MyServlet3 extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		//获取session
		HttpSession session = request.getSession();
		//获取application
		ServletContext application = this.getServletContext();
		
		//获取request的值
		String  rname = (String) request.getAttribute("rname");
	    System.out.println("request:" + rname);
		//获取session的值
		String sname = (String) session.getAttribute("sname");
		System.out.println("session:" + sname);
		//获取application的值
	   String aname =  (String) application.getAttribute("aname");
	   System.out.println("application:" + aname);
	    
	    response.sendRedirect("result.jsp");

	}

}
