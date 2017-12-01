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
 *<p>Title:MyServlet4 </p>
 *<p>Description:
 *ServletContext��ServletConfig������
 * </p>
 *
 *@author LH
 *@date 2017-11-30����11:15:32
 *@version V1.0
 */
public class MyServlet4 extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		//ServletContext-->Servlet(������)---Servlet�Ļ�����Ϣ
		String sname  = this.getServletContext().getInitParameter("school");
		//ServletConfig-->Serlvet��(����)������Ϣ
		String uname = this.getServletConfig().getInitParameter("uname");
		
		System.out.println(sname + "=="+ uname);
		
	}

}
