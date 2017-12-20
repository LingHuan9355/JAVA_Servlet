package com.cshr.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cshr.dao.PaperDao;
import com.cshr.dao.ScoreDao;
import com.cshr.entity.Paper;
import com.cshr.entity.Score;
/**
 * 
 *<p>Title:LoginServlet </p>
 *Description: 
 *1.写一个登录用户的页面，登录到一个servlet中,将用户名放到session中,还要将用户数据插入到评分表
  中,转发到“/admin/admin.jsp”后台的试卷页面
 *@author LH
 *@date 2017-12-18下午03:36:55
 *@version V1.0
 */
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	   @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		   
        // req.setCharacterEncoding("utf-8");
         HttpSession session = req.getSession();
            
		 String userName = req.getParameter("userName");
		 
	     boolean flag = ScoreDao.queryByName(userName);
		 
	     if(flag){
			 //查询所有题目
			 List<Paper> list = PaperDao.queryList();
			 
			 session.setAttribute("uname", userName);
			 req.setAttribute("plist", list);
		     req.getRequestDispatcher("admin/admin.jsp").forward(req, resp);
		       
		 }else{
			  resp.sendRedirect("login.jsp");
		 }
		 
	  }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

	             doPost(req, resp);
	}   
	   
}
