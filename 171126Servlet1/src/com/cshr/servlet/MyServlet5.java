package com.cshr.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *<p>Title:MyServlet5 </p>
 *<p>Description: 
 *继承httpservlet是一般不去重写其service方法
 *</p>
 *
 *@author LH
 *@date 2017-11-26下午11:19:52
 */
public class MyServlet5 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("get请求...");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("post请求...");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//此方法如果一定要重写，请加上这行代码，以保证doget和dopost可以被成功的调用
		super.service(req, resp);
	}
}
