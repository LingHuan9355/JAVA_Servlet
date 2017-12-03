package com.cshr.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cshr.user.dao.UsersDao;
/**
 * 
 *<p>Title:DeleteServlet </p>
 *<p>Description: </p>
 *5.在一个jsp页面写一个表单，其中一个文本框，可以输入用户的编号，提交到一个servlet，根据编号删除数据
 *(要求使用继承HttpServlet的方式完成)
 *@author LH
 *@date 2017-12-3下午04:37:48
 *@version V1.0
 */
@SuppressWarnings("serial")
public class DeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		    doPost(req, resp);
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1.编码
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//2.取值
		String uid = req.getParameter("userId");
		int id = Integer.parseInt(uid);
		//3.调dao
		int num = UsersDao.delUser(id);
	    //4.跳jsp
		if(num>0){
			System.out.println("删除成功！");
		    resp.sendRedirect("myJsp.jsp");
	
		}
   }
	
}
