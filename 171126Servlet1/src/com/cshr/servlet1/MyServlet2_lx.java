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
 *2.дһ����ʵ��Servlet�ӿ�,����servlet����������,
 *</p>
 *
 *@author LH
 *@date 2017-11-27����10:08:55
 *@version V1.0
 */
public class MyServlet2_lx implements Servlet {

	public MyServlet2_lx() {
         System.out.println("������������....");
	}
	
	@Override
	public void destroy() {
         System.out.println("��������������...");
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
          System.out.println("��������ʼ��...");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
            
            res.setContentType("text/html;charset=UTF-8");
            PrintWriter out = res.getWriter();
            out.println("����������������....");
            
	}

}
