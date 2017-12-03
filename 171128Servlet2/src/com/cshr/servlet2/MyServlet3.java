package com.cshr.servlet2;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 *<p>Title:MyServlet3 </p>
 *<p>Description: </p>
 *3.��һ��jspҳ����,�ֱ���request��session��application��ֵ��
 *Ȼ��ת����һ��servlet�У��ó��������Ͳ���ֵ����ӡ�� �ͻ���
 *
 *@author LH
 *@date 2017-12-2����12:11:10
 *@version V1.0
 */
@SuppressWarnings("serial")
public class MyServlet3 extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		//��ȡsession
		HttpSession session = request.getSession();
		//��ȡapplication
		ServletContext application = this.getServletContext();
		
		//��ȡrequest��ֵ
		String  rname = (String) request.getAttribute("rname");
	    System.out.println("request:" + rname);
		//��ȡsession��ֵ
		String sname = (String) session.getAttribute("sname");
		System.out.println("session:" + sname);
		//��ȡapplication��ֵ
	   String aname =  (String) application.getAttribute("aname");
	   System.out.println("application:" + aname);
	    
	    response.sendRedirect("result.jsp");

	}

}
