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
 *<p>Title:MyServlet4_lx </p>
 *<p>Description: 
 *4.从一个jsp页面上使用post方式提交一个用户编号，一个用户名，和爱好的两个复选项到Servlet，
 *  Servlet接收后处理编码问题，输出到控制台。(继承GenericServlet)
 *</p>
 *
 *@author LH
 *@date 2017-11-27下午11:08:01
 *@version V1.0
 */
@SuppressWarnings("serial")
public class MyServlet4_lx extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		HttpServletRequest request = (HttpServletRequest) req;
		@SuppressWarnings("unused")
		HttpServletResponse response = (HttpServletResponse) res;
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String userName = request.getParameter("userName");
		String [] hobbys = request.getParameterValues("hobby");
		
		System.out.println("用户编号:" + id + "，用户名:" + userName);
	    for (String love : hobbys) {
			System.out.println(love);
		}
		

	}

}
