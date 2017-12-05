package com.cshr.book.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 *<p>Title:ShowServlet </p>
 *<p>Description: </p>
 *查询所有数据信息
 *@author LH
 *@date 2017-12-5上午12:00:10
 *@version V1.0
 */
@SuppressWarnings("serial")
public class ShowServlet extends HttpServlet {

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
