package com.cshr.servlet2;

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
 * 
 *<p>Title:AfterClassServlet1 </p>
 *<p>Description: 
 *1.дһ����ʵ��Servlet�ӿڣ�Ȼ�󵱿ͻ�������Servlet֮��servlet�õ��Լ������֣���ӡ���ͻ��ˣ�����������⣩
 *</p>
 *
 *@author LH
 *@date 2017-11-28����08:53:41
 *@version V1.0
 */
public class AfterClassServlet1 implements Servlet {

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
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		//�ж�����ʽ
		String name="";
		String method = request.getMethod();
		if("get".equalsIgnoreCase(method)){
			name = request.getParameter("name");
			name = new String(name.getBytes("iso-8859-1"), "UTF-8");
			
			System.out.println("get��ʽ��" + name);
		}else if("post".equalsIgnoreCase(method)){
             request.setCharacterEncoding("utf-8");
             name = request.getParameter("name");
			System.out.println("post��ʽ��" + name);
			
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("������" + name);
		
		
	}

}
