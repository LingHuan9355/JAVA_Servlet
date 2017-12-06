package com.cshr.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class StrServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
           HttpServletRequest request = (HttpServletRequest) req;
           HttpServletResponse response = (HttpServletResponse) res;
           
           String uname = request.getParameter("uname");
           String country = request.getParameter("country");
           String job = request.getParameter("job");
           
           System.out.println("姓名=" + uname + ",国籍=" + country + ",职位=" +job);
           
           PrintWriter out  =response.getWriter();
           out.println("姓名=" + uname + ",国籍=" + country + ",职位=" +job);
           
	}

}
