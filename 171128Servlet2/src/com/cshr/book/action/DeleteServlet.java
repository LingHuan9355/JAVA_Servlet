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
 *删除数据信息
 *@author LH
 *@date 2017-12-5上午12:09:01
 *@version V1.0
 */
@SuppressWarnings("serial")
public class DeleteServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		   //编码
		   req.setCharacterEncoding("utf-8");
		   //resp.setContentType("text/html;charset=utf-8");
		   //取值
		   int bookId = 0;
		   String sbookId = req.getParameter("bookid");
		   if(sbookId !=null){
			   bookId = Integer.parseInt(sbookId);
		   }
		   //调dao
		    int num = BookDao.delBook(bookId);   
		   //跳jsp
		    if(num > 0){
		       // System.out.println("删除成功！");
		    	resp.sendRedirect("showServlet");
		    }
		 
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
         doPost(req, resp);
	}
}
