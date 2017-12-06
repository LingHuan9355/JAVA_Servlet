package com.cshr.book.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cshr.book.dao.BookDao;
import com.cshr.book.entity.Book;

/**
 * 
 *<p>Title:UpdateServlet </p>
 *<p>Description: </p>
 *�޸��鼮��Ϣ
 *@author LH
 *@date 2017-12-5����12:09:55
 *@version V1.0
 */
@SuppressWarnings("serial")
public class UpdateServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
         //����
		   req.setCharacterEncoding("utf-8");
		   resp.setContentType("text/html;charset=utf-8");
		 //ȡֵ
		   int bookId = 0;
		   double bookPrice = 0;
		   //String sbookId = req.getParameter("bookId");
		   String sbookId = req.getParameter("bid");
		   if(sbookId !=null){
			   bookId = Integer.parseInt(sbookId);
			   System.out.println(bookId);
		   }
		   String bookName = req.getParameter("bookName");
		   String sbookPrice  = req.getParameter("bookPrice");
		   if(sbookPrice != null){
			   bookPrice = Double.parseDouble(sbookPrice);   
		   }
		   String bookWrite = req.getParameter("bookWrite");
		 //��dao
		   int num = BookDao.updateBook(new Book(bookId, bookName, bookPrice, bookWrite));
		 //��jsp
		   if(num > 0){
			  // System.out.println("�޸ĳɹ���");
			   resp.sendRedirect("showServlet");
		   }
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

				doPost(req, resp);
	}
}
