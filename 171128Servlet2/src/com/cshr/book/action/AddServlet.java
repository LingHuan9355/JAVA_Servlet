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
 *<p>Title:AddServlet </p>
 *<p>Description: </p>
 *����鼮��Ϣ
 *@author LH
 *@date 2017-12-4����11:58:10
 *@version V1.0
 */
@SuppressWarnings("serial")
public class AddServlet extends HttpServlet {

	  @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		  //����
		  req.setCharacterEncoding("utf-8");
		  resp.setContentType("text/html;charset=utf-8");
		  //ȡֵ
		  String bookName =req.getParameter("bookName");
		  double bookPrice =Double.parseDouble(req.getParameter("bookPrice"));
		  String bookWrite =req.getParameter("bookWrite");
		  //��dao
		   int  num = BookDao.addBook(new Book(bookName, bookPrice, bookWrite));
		  //��jsp
		   if(num >0){
			  // System.out.println("��ӳɹ�");
			   resp.sendRedirect("index_book.jsp");
		   }
	}
	  
	  @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
}
