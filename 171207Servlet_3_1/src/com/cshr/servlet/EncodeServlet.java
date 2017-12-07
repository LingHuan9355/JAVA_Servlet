package com.cshr.servlet;

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
 *<p>Title:EncodeServlet </p>
 *Description: 
 *2.дһ���û�����¼��jsp��������д������û������ύ����¼��Encodeservlet��,дһ��filter����������
 *����������������⣨get/post������Ӧ�������������⣬Ȼ����servlet�еõ����ݣ�Ȼ���ӡ������ͻ���
 *@author LH
 *@date 2017-12-7����02:59:45
 *@version V1.0
 */
@SuppressWarnings("serial")
public class EncodeServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
       HttpServletRequest request = (HttpServletRequest) req;
       HttpServletResponse response = (HttpServletResponse) res;
       
       String userName = request.getParameter("userName");
       String passWord = request.getParameter("passWord");
       
       System.out.println("userName" + userName+ ",pwd=" + passWord);
       
       PrintWriter out = response.getWriter();
       out.println("userName" + userName+ ",pwd=" + passWord);
	}

}
