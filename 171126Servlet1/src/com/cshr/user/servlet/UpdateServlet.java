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
 *<p>Title:UpdateServlet </p>
 *<p>Description: </p>
 *7.在一个jsp页面写一个表单，其中三个文本框，可以输入用户编号、用户名和密码，提交到一个servlet，
 *查询有没有 此id，根据用户编号id，修改用户名和密码(要求使用继承HttpServlet的方式完成)
 *@author LH
 *@date 2017-12-3下午05:53:55
 *@version V1.0
 */
@SuppressWarnings("serial")
public class UpdateServlet extends HttpServlet {

	
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
    	//String userId = req.getParameter("userId");
    	int userId =Integer.parseInt(req.getParameter("userId")); 
    	String userName = req.getParameter("userName");
    	String userPassWord = req.getParameter("userPassWord");
    	//3.调dao
    	int num = UsersDao.updateUser(new Users(userId, userName, userPassWord));
    	//4.跳jsp
    	if(num > 0){
    		System.out.println("修改成功！");
		    resp.sendRedirect("myJsp.jsp");
    	}
    }
}
