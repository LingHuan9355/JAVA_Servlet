package com.cshr.servlet1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *<p>Title:MyServlet1_lx </p>
 *<p>Description:
 *1.дһ����ʵ��Servlet�ӿڣ�Ȼ����ͻ������һ�θ�ʵ���Ϣ��Ҫ���ʱ��������������⡣ </p>
 *
 *@author LH
 *@date 2017-11-26����11:57:16
 */
public class MyServlet1_lx implements Servlet {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {

		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		out.println("ƤƤϺ�������ߣ�");
	}

}
