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
 *6.��һ��jspҳ��дһ���������������ı��򣬿��������û��������룬�ύ��һ��servlet��Ȼ����ӵ����ݿ���
 *(Ҫ��ʹ�ü̳�HttpServlet�ķ�ʽ���)
 *@author LH
 *@date 2017-12-3����05:25:56
 *@version V1.0
 */
@SuppressWarnings("serial")
public class InsertServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
          //1.����
		 req.setCharacterEncoding("utf-8");
		 resp.setContentType("text/html;charset=utf-8");
		  //2.ȡֵ
		 String userName = req.getParameter("userName");
		 String userPassWord = req.getParameter("userPassWord");
		  //3.��dao
		 int num = UsersDao.addUser(new Users(userName, userPassWord));
		  //4.��jsp
		 if(num > 0){
			 System.out.println("��ӳɹ���");
			    resp.sendRedirect("myJsp.jsp");
		 }

	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
}
