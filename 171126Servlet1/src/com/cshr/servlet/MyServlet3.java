package com.cshr.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *<p>Title:MyServlet3 </p>
 *<p>Description: 
 * ������������
 * a.���������;
 * b.��Ӧ������;
 *</p>
 *
 *@author LH
 *@date 2017-11-26����10:24:09
 */
public class MyServlet3 implements Servlet {

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
		//ǿ��ת��
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response =(HttpServletResponse) res;
	
		//�ж�����ķ�ʽ
		String name = "";
		String method = request.getMethod();
		if("GET".equalsIgnoreCase(method)){
			//get����
			 name = request.getParameter("name");
			 name = new String(name.getBytes("iso-8859-1"),"UTF-8");
			 System.out.println(name+"1");
		}else if("POST".equalsIgnoreCase(method)){
			request.setCharacterEncoding("UTF-8");
			name = request.getParameter("name");
			System.out.println(name+"2");
		}
		
		//ע�����д����λ�ã�Ҫ����printwriter֮ǰ����
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("����Ϊ��"+name);
	}

}
