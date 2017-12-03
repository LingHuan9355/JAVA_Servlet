package com.cshr.servlet2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 *<p>Title:MyServlet4 </p>
 *<p>Description: 
 *4.дһ��servlet(�̳�GenericServlet)�������ļ�������������ʼ��ֵ��
 *Ȼ���ڹ���������Ϣ��Ҳ����������ʼ��ֵ��Ȼ����service�������ó�ֵ����ӡ������ͻ���
 *
 *</p>
 *@author LH
 *@date 2017-12-2����12:26:35
 *@version V1.0
 */
@SuppressWarnings("serial")
public class MyServlet4 extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		String school = this.getServletConfig().getInitParameter("SEX");
		String sex = this.getServletContext().getInitParameter("school");
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("school=" + school + ",sex=" + sex);
		
	}

}
