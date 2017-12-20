package com.cshr.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 *<p>Title:SubmitServlet </p>
 *Description: 
 *5.��������Ծ�ĳ�����,�г�����û��ķ���.
 *@author LH
 *@date 2017-12-19����05:04:22
 *@version V1.0
 */
@SuppressWarnings("serial")
public class SubmitServlet extends HttpServlet {

	
	   @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		   
		   HttpSession session = req.getSession();
		   String userName = (String) session.getAttribute("uname");
		   String sum = session.getAttribute("sum").toString();
		 //  System.out.println(userName+"�����ܷ�:"+sum);
		   
		   session.setAttribute("userName", userName);
		   session.setAttribute("sum", sum);
           req.getRequestDispatcher("score.jsp").forward(req, resp);
	}
	   @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

	          doGet(req, resp);
	   }
}
