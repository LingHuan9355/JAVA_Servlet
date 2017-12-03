package com.cshr.servlet2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 *<p>Title:MyServlet1 </p>
 *<p>Description: </p>
 *1.дһ��jsp�����к���һ���û������ı���������Ҫ���ύ��һ��servlet(�̳�HttpServlet)
 *Ҫ��ֱ���doGet()��doPost()�����н�������������⣬Ȼ���û����������ӡ������ͻ���
 *
 *@author LH
 *@date 2017-12-1����05:07:55
 *@version V1.0
 */

@SuppressWarnings("serial")
public class MyServlet1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		  String userName =req.getParameter("userName");
		  String passWord = req.getParameter("passWord");
		  if(userName !="" && userName != null){
			  
			  userName = new String(userName.getBytes("iso-8859-1"),"UTF-8");
			  passWord = new String(passWord.getBytes("iso-8859-1"),"UTF-8");
		
		      resp.setContentType("text/html;charset=UTF-8");
		      PrintWriter out = resp.getWriter();
		      out.print("�û�����"+ userName + ",���룺"+passWord);
		      System.out.println(userName + "\t" + passWord);
	      
		  }
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
			doGet(req, resp);
	
	}
}
