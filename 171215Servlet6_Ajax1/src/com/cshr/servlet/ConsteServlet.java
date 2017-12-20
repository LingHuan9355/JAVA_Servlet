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
 *3.准备一个星座表(id,name,content) id自增,name(星座名),content(星座内容,不要太长，不超过10个字),
 * 写一个index.jsp，当访问这个jsp时，从数据库查出所有的星座的信息，遍历数据然后在表单中生成有12个单选框，
 * 然后在单选框的下面，用一个多行文本域,当点击某个单选框，多行文本域中就显示那个星座的content
 *@author LH
 *@date 2017-12-15下午04:03:34
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
