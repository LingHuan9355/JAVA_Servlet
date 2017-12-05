package com.cshr.book.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 *<p>Title:AddServlet </p>
 *<p>Description: </p>
 *添加书籍信息
 *@author LH
 *@date 2017-12-4下午11:58:10
 *@version V1.0
 */
@SuppressWarnings("serial")
public class AddServlet extends HttpServlet {

	  @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	}
	  
	  @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
}
