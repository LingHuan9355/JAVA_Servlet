package com.cshr.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cshr.dao.UserDao;
/**
 * 
 *<p>Title:UserServlet </p>
 *Description: 
 *1.写一个用户注册的的表单，可以填入姓名和密码，使用Ajax验证，输入的用户是否可以注册
 *@author LH
 *@date 2017-12-15上午10:21:46
 *@version V1.0
 */

@SuppressWarnings("serial")
public class UserServlet extends HttpServlet {

	   @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String method = request.getMethod();
		System.out.println(method);
		
		String userName = request.getParameter("uname");
		System.out.println("用户名："+userName);
		
		if("get".equalsIgnoreCase(method)){
			 userName = new String(userName.getBytes("iso-8859-1"), "utf-8");
			 System.out.println("get："+userName);
			
		}else if("post".equalsIgnoreCase(method)){
			request.setCharacterEncoding("utf-8");
			System.out.println("post："+userName);	
		}
		
		
		boolean flag = UserDao.findByName(userName);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out =response.getWriter();
		if(flag){
			out.print("<font color='red'>用户名已存在</font>");
		}else{
			out.print("<font color='green'>用户名可使用</font>");
		}
		   
		   
		   
	}
	   
	   @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
                doPost(req, resp);
	   }
	
}
