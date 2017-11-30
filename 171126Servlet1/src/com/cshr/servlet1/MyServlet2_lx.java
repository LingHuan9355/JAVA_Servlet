package com.cshr.servlet1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * 
 *<p>Title:MyServlet2_lx </p>
 *<p>Description: 
 *2.写一个类实现Servlet接口,测试servlet的生命周期,
 *</p>
 *
 *@author LH
 *@date 2017-11-27下午10:08:55
 *@version V1.0
 */
public class MyServlet2_lx implements Servlet {

	public MyServlet2_lx() {
         System.out.println("服务器诞生了....");
	}
	
	@Override
	public void destroy() {
         System.out.println("服务器被销毁了...");
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
          System.out.println("服务器初始化...");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
            
            res.setContentType("text/html;charset=UTF-8");
            PrintWriter out = res.getWriter();
            out.println("服务器正在运行中....");
            
	}

}
