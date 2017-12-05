package com.cshr.book.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.registry.infomodel.User;

import com.cshr.book.dao.BookDao;
import com.cshr.book.entity.Book;

/**
 * 
 *<p>Title:ShowServlet </p>
 *<p>Description: </p>
 *��ѯ����������Ϣ
 *@author LH
 *@date 2017-12-5����12:00:10
 *@version V1.0
 */
@SuppressWarnings("serial")
public class ShowServlet extends HttpServlet {

	  @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		   //1.����
	       // req.setCharacterEncoding("utf-8");
	       resp.setContentType("text/html;charset=utf-8");
	       //2.ȡֵ
	       //��dao
	       List<Book> list = BookDao.selList();
	       //��jsp
	       if(list.size()>0){
	    	   req.setAttribute("blist",list);
	    	   req.getRequestDispatcher("show_book.jsp").forward(req, resp);
	       }
	  }
	  
	  @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		  
		      doPost(req, resp);
	}
}
