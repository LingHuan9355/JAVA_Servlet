package com.cshr.servlet2;

import java.io.IOException;
import java.io.PrintWriter;

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
 *4.写一个servlet(继承GenericServlet)在配置文件中配置三个初始化值，
 *然后在公共配置信息中也配置三个初始化值，然后在service方法中拿出值，打印输出到客户端
 *
 *</p>
 *@author LH
 *@date 2017-12-2上午12:26:35
 *@version V1.0
 */
@SuppressWarnings("serial")
public class MyServlet4 extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		String school = this.getServletConfig().getInitParameter("SEX");
		String sex = this.getServletContext().getInitParameter("school");
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("school=" + school + ",sex=" + sex);
		
	}

}
