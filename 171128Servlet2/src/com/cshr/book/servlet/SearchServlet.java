package com.cshr.book.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 *<p>Title:SearchServlet </p>
 *<p>Description: </p>
 *查询单个书籍信息
 *@author LH
 *@date 2017-12-5上午12:04:05
 *@version V1.0
 */
@SuppressWarnings("serial")
public class SearchServlet extends HttpServlet {

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
