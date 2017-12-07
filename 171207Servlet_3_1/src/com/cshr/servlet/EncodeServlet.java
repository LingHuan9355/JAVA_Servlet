package com.cshr.servlet;

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
 *<p>Title:EncodeServlet </p>
 *Description: 
 *2.写一个用户名登录的jsp，可以填写密码和用户名，提交到登录的Encodeservlet中,写一个filter过滤请求解决
 *请求的中文乱码问题（get/post）和响应的中文乱码问题，然后在servlet中得到数据，然后打印输出到客户端
 *@author LH
 *@date 2017-12-7下午02:59:45
 *@version V1.0
 */
@SuppressWarnings("serial")
public class EncodeServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
       HttpServletRequest request = (HttpServletRequest) req;
       HttpServletResponse response = (HttpServletResponse) res;
       
       String userName = request.getParameter("userName");
       String passWord = request.getParameter("passWord");
       
       System.out.println("userName" + userName+ ",pwd=" + passWord);
       
       PrintWriter out = response.getWriter();
       out.println("userName" + userName+ ",pwd=" + passWord);
	}

}
