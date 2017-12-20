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
 *1.дһ����¼�û���ҳ�棬��¼��һ��servlet��,���û����ŵ�session��,��Ҫ���û����ݲ��뵽���ֱ�
  ��,ת������/admin/admin.jsp����̨���Ծ�ҳ��
 *@author LH
 *@date 2017-12-18����03:36:55
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
			 //��ѯ������Ŀ
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
