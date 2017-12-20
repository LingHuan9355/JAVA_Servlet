package com.cshr.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cshr.dao.ConsteDao;
import com.cshr.entity.Conste;

/**
 * 
 *<p>Title:ConsteServlet </p>
 *Description: 
 *3.׼��һ��������(id,name,content) id����,name(������),content(��������,��Ҫ̫����������10����),
 * дһ��index.jsp�����������jspʱ�������ݿ������е���������Ϣ����������Ȼ���ڱ���������12����ѡ��
 * Ȼ���ڵ�ѡ������棬��һ�������ı���,�����ĳ����ѡ�򣬶����ı����о���ʾ�Ǹ�������content
 *@author LH
 *@date 2017-12-15����04:03:34
 *@version V1.0
 */
@SuppressWarnings("serial")
public class ConsteServlet extends HttpServlet {

	  @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  
             ConsteDao consteDao = new ConsteDao();
             List<Conste> list= consteDao.queryList();
             
             request.setAttribute("clist", list);
             
		     request.getRequestDispatcher("conste.jsp").forward(request, response);
	     
	}
	
	  @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
	            doGet(req, resp);
	  }
	  
}
