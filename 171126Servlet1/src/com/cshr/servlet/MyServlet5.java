package com.cshr.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *<p>Title:MyServlet5 </p>
 *<p>Description: 
 *�̳�httpservlet��һ�㲻ȥ��д��service����
 *</p>
 *
 *@author LH
 *@date 2017-11-26����11:19:52
 */
public class MyServlet5 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("get����...");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("post����...");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//�˷������һ��Ҫ��д����������д��룬�Ա�֤doget��dopost���Ա��ɹ��ĵ���
		super.service(req, resp);
	}
}
