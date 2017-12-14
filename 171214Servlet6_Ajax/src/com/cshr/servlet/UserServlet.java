package com.cshr.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cshr.dao.UsersDao;


@SuppressWarnings("serial")
public class UserServlet extends HttpServlet {

	  @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
           
		  request.setCharacterEncoding("utf-8");
		  String method = request.getMethod();
		  String userName = request.getParameter("uname");
		  
		  if("GET".equalsIgnoreCase(method)){
		     if(userName != null){
		         userName = new String(userName.getBytes("iso-8859-1"), "utf-8");
		     }
		  }else if("POST".equalsIgnoreCase(method)){
			  
			  request.setCharacterEncoding("utf-8");
			  
		  }
		  
		  UsersDao userDao = new UsersDao();
		  boolean flag = userDao.findByName(userName);
		  
		  response.setContentType("text/html;charset=UTF-8");
		  PrintWriter out = response.getWriter();
		  
		  if(flag){
			  out.println("<font color='red'>用户名已存在</font>");
		  }else{
			  out.println("<font color='green'>用户名可使用</font>");
			  
		  }
		  
	  }
	  
	  @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
                 doGet(req, resp);
	  }
}
