package com.cshr.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class DyncServlet extends HttpServlet {

	  @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

	     doPost(req, resp);
	  }
	  @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		  HttpSession session = req.getSession();
		  
		  String snumber =  (String) session.getAttribute("number");
          int number = Integer.parseInt(snumber);
          
		  String sdynamicPwd = req.getParameter("dynamicPwd");
	      int dynamicPwd = Integer.parseInt(sdynamicPwd);
          if(number == dynamicPwd){
        	  
        	req.getRequestDispatcher("success.jsp").forward(req, resp);
        	
          }	else{
        	resp.sendRedirect("login.jsp");  
          }    
	      
	      
		  
	  }
}
