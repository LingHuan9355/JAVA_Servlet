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
 *1.дһ�����ӣ�����filter��servlet����������
 *@author LH
 *@date 2017-12-7����02:38:46
 *@version V1.0
 */
public class MyServlet1 implements Servlet{

	
	public MyServlet1() {
		System.out.println("servlet����...");
	}
	
	public void destroy() {
		System.out.println("servlet����...");
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
            System.out.println("servlet��ʼ����������");		
	}

	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
             System.out.println("servlet������....");		
	}

}
