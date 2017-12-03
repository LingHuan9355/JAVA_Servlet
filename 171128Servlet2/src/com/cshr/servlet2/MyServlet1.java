package com.cshr.servlet2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 *<p>Title:MyServlet1 </p>
 *<p>Description: </p>
 *1.写一个jsp，其中含有一个用户名的文本框和密码框，要求提交到一个servlet(继承HttpServlet)
 *要求分别在doGet()和doPost()方法中解决中文乱码问题，然后将用户名和密码打印输出到客户端
 *
 *@author LH
 *@date 2017-12-1下午05:07:55
 *@version V1.0
 */

@SuppressWarnings("serial")
public class MyServlet1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		  String userName =req.getParameter("userName");
		  String passWord = req.getParameter("passWord");
		  if(userName !="" && userName != null){
			  
			  userName = new String(userName.getBytes("iso-8859-1"),"UTF-8");
			  passWord = new String(passWord.getBytes("iso-8859-1"),"UTF-8");
		
		      resp.setContentType("text/html;charset=UTF-8");
		      PrintWriter out = resp.getWriter();
		      out.print("用户名："+ userName + ",密码："+passWord);
		      System.out.println(userName + "\t" + passWord);
	      
		  }
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
			doGet(req, resp);
	
	}
}
