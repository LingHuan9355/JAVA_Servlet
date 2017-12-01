package com.cshr.servlet1;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class MyServlet3 extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		//session
		HttpSession session = request.getSession();
		//application
		ServletContext application = this.getServletContext();
		
		session.setAttribute("sname", "tom");
		application.setAttribute("aname", "cat");
		
		response.sendRedirect("result.jsp");
	}

}
