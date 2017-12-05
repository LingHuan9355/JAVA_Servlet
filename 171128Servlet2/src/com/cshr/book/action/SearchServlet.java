package com.cshr.book.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cshr.book.dao.BookDao;
import com.cshr.book.entity.Book;

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
		//编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //取值
    /*    String sid = request.getParameter("epc_id");
		int id = 0;
		if(sid != null){
			id = Integer.parseInt(sid);
		}*/
        int bookId = 0;
        String sbookId = req.getParameter("bookid");
        if(sbookId != null && sbookId !=""){
        	
           bookId =Integer.parseInt(sbookId);
          // System.out.println("bookId="+bookId);
        }
        //调dao
        List<Book> list = BookDao.selById(bookId);

       // System.out.println("list.get(0)=="+list.get(0));
        
        //跳jsp
        if(list.size()>0){
        	req.setAttribute("blist", list);
        	req.setAttribute("bid", bookId);
        	req.getRequestDispatcher("update_book.jsp").forward(req, resp);
        }
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
              doPost(req, resp);
            
	}
}
