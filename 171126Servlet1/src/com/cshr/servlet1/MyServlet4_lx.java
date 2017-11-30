package com.cshr.servlet1;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 *<p>Title:MyServlet4_lx </p>
 *<p>Description: 
 *4.��һ��jspҳ����ʹ��post��ʽ�ύһ���û���ţ�һ���û������Ͱ��õ�������ѡ�Servlet��
 *  Servlet���պ���������⣬���������̨��(�̳�GenericServlet)
 *</p>
 *
 *@author LH
 *@date 2017-11-27����11:08:01
 *@version V1.0
 */
@SuppressWarnings("serial")
public class MyServlet4_lx extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		HttpServletRequest request = (HttpServletRequest) req;
		@SuppressWarnings("unused")
		HttpServletResponse response = (HttpServletResponse) res;
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String userName = request.getParameter("userName");
		String [] hobbys = request.getParameterValues("hobby");
		
		System.out.println("�û����:" + id + "���û���:" + userName);
	    for (String love : hobbys) {
			System.out.println(love);
		}
		

	}

}
