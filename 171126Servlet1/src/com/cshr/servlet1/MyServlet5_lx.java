package com.cshr.servlet1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 *<p>Title:MyServlet5_lx </p>
 *<p>Description: 
 *5.дһ��jsp,jsp��һ���û���¼�ı������û��������룬��post��ʽ�ύ��һ��servlet(Ҫ��ʹ�ü̳�HttpServlet�ķ�ʽ���)
 *��doPost()�����У��õ����ݣ����������̨��Ȼ���Ա�����ʽ����������ͻ���
 *</p>
 *
 *@author LH
 *@date 2017-11-27����11:29:26
 *@version V1.0
 */
public class MyServlet5_lx extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		     doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		String userName = req.getParameter("userName");
		String passWord = req.getParameter("passWord");
		
		System.out.println("�û�����" + userName + ",���룺" + passWord);
		
		PrintWriter out = resp.getWriter();
		out.print("<table border=1 bordercolor='black' cellspacing=0>" +
				      "<tr><td>�û�����</td><td>"+userName+"</td></tr>" +
				      "<tr><td>���룺</td><td>"+passWord+"</td></tr>" +
				  "</table>");
		
	}
}
