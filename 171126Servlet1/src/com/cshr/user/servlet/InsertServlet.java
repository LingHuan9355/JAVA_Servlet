package com.cshr.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cshr.user.dao.UsersDao;
import com.cshr.user.entity.Users;

/**
 * 
 *<p>Title:InsertServlet </p>
 *<p>Description: </p>
 *6.在一个jsp页面写一个表单，其中两个文本框，可以输入用户名和密码，提交到一个servlet，然后添加到数据库中
 *(要求使用继承HttpServlet的方式完成)
 *@author LH
 *@date 2017-12-3下午05:25:56
 *@version V1.0
 */
@SuppressWarnings("serial")
public class InsertServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
          //1.编码
		 req.setCharacterEncoding("utf-8");
		 resp.setContentType("text/html;charset=utf-8");
		  //2.取值
		 String userName = req.getParameter("userName");
		 String userPassWord = req.getParameter("userPassWord");
		  //3.调dao
		 int num = UsersDao.addUser(new Users(userName, userPassWord));
		  //4.跳jsp
		 if(num > 0){
			 System.out.println("添加成功！");
			    resp.sendRedirect("myJsp.jsp");
		 }

	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
}
