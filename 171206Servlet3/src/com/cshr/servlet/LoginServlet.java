package com.cshr.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.registry.infomodel.User;

@SuppressWarnings("serial")
public class LoginServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
         HttpServletRequest request = (HttpServletRequest) req;
         HttpServletResponse response = (HttpServletResponse) res;
         HttpSession session = request.getSession();
         
         String userName = request.getParameter("userName");
         String pwd = request.getParameter("passWord");
        // System.out.println(userName + "==" + pwd);
         
        PrintWriter out = response.getWriter();
        
         //µÇÂ¼
        if("admin".equals(userName) && "123".equals(pwd)){
        	session.setAttribute("uname", userName);
        	response.sendRedirect("admin/admin.jsp");
        }else{
        	 out.println("´íÎó"+userName + "=" + pwd);
        }
         		
	}

}
