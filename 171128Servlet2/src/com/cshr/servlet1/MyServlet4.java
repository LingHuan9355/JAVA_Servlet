package com.cshr.servlet1;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 *<p>Title:MyServlet4 </p>
 *<p>Description:
 *ServletContext与ServletConfig的区别
 * </p>
 *
 *@author LH
 *@date 2017-11-30下午11:15:32
 *@version V1.0
 */
public class MyServlet4 extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		//ServletContext-->Servlet(上下文)---Servlet的环境信息
		String sname  = this.getServletContext().getInitParameter("school");
		//ServletConfig-->Serlvet的(自身)配置信息
		String uname = this.getServletConfig().getInitParameter("uname");
		
		System.out.println(sname + "=="+ uname);
		
	}

}
