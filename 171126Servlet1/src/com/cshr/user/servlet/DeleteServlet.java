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
 *5.��һ��jspҳ��дһ����������һ���ı��򣬿��������û��ı�ţ��ύ��һ��servlet�����ݱ��ɾ������
 *(Ҫ��ʹ�ü̳�HttpServlet�ķ�ʽ���)
 *@author LH
 *@date 2017-12-3����04:37:48
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
		//1.����
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//2.ȡֵ
		String uid = req.getParameter("userId");
		int id = Integer.parseInt(uid);
		//3.��dao
		int num = UsersDao.delUser(id);
	    //4.��jsp
		if(num>0){
			System.out.println("ɾ���ɹ���");
		    resp.sendRedirect("myJsp.jsp");
	
		}
   }
	
}
