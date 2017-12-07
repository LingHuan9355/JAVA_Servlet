package com.cshr.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 
 *<p>Title:MyServlet1 </p>
 *Description: 
 *1.写一个例子，测试filter和servlet的生命周期
 *@author LH
 *@date 2017-12-7下午02:38:46
 *@version V1.0
 */
public class MyServlet1 implements Servlet{

	
	public MyServlet1() {
		System.out.println("servlet创建...");
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
            System.out.println("servlet初始化。。。。");		
	}

	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
             System.out.println("servlet运行中....");		
	}

}
