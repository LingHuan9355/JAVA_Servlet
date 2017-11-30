package com.cshr.servlet1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 *<p>Title:MyServlet5_lx </p>
 *<p>Description: 
 *5.写一个jsp,jsp中一个用户登录的表单，有用户名和密码，以post方式提交到一个servlet(要求使用继承HttpServlet的方式完成)
 *的doPost()方法中，拿到数据，输出到控制台，然后以表格的形式，再输出到客户端
 *</p>
 *
 *@author LH
 *@date 2017-11-27下午11:29:26
 *@version V1.0
 */
public class MyServlet5_lx extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		     doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		String userName = req.getParameter("userName");
		String passWord = req.getParameter("passWord");
		
		System.out.println("用户名：" + userName + ",密码：" + passWord);
		
		PrintWriter out = resp.getWriter();
		out.print("<table border=1 bordercolor='black' cellspacing=0>" +
				      "<tr><td>用户名：</td><td>"+userName+"</td></tr>" +
				      "<tr><td>密码：</td><td>"+passWord+"</td></tr>" +
				  "</table>");
		
	}
}
