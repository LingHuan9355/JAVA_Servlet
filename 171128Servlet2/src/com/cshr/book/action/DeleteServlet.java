package com.cshr.book.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cshr.book.dao.BookDao;

/**
 * 
 *<p>Title:DeleteServlet </p>
 *<p>Description: </p>
 *ɾ��������Ϣ
 *@author LH
 *@date 2017-12-5����12:09:01
 *@version V1.0
 */
@SuppressWarnings("serial")
public class DeleteServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		   //����
		   req.setCharacterEncoding("utf-8");
		   //resp.setContentType("text/html;charset=utf-8");
		   //ȡֵ
		   int bookId = 0;
		   String sbookId = req.getParameter("bookid");
		   if(sbookId !=null){
			   bookId = Integer.parseInt(sbookId);
		   }
		   //��dao
		    int num = BookDao.delBook(bookId);   
		   //��jsp
		    if(num > 0){
		       // System.out.println("ɾ���ɹ���");
		    	resp.sendRedirect("showServlet");
		    }
		 
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
         doPost(req, resp);
	}
}
