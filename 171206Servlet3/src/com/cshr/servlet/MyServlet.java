package com.cshr.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyServlet implements Servlet {

	public MyServlet() {
         System.out.println("servlet创建");
	}
	
	public void destroy() {
       System.out.println("servlet销毁...");
	}

	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public void init(ServletConfig config) throws ServletException {
            System.out.println("servlet初始化...");
	}

	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
           System.out.println("servlet启动服务。。。。");
	}

}
