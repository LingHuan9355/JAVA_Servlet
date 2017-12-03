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
 *7.��һ��jspҳ��дһ���������������ı��򣬿��������û���š��û��������룬�ύ��һ��servlet��
 *��ѯ��û�� ��id�������û����id���޸��û���������(Ҫ��ʹ�ü̳�HttpServlet�ķ�ʽ���)
 *@author LH
 *@date 2017-12-3����05:53:55
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
    	//1.����
    	req.setCharacterEncoding("utf-8");
    	resp.setContentType("text/html;charset=utf-8");
    	//2.ȡֵ
    	//String userId = req.getParameter("userId");
    	int userId =Integer.parseInt(req.getParameter("userId")); 
    	String userName = req.getParameter("userName");
    	String userPassWord = req.getParameter("userPassWord");
    	//3.��dao
    	int num = UsersDao.updateUser(new Users(userId, userName, userPassWord));
    	//4.��jsp
    	if(num > 0){
    		System.out.println("�޸ĳɹ���");
		    resp.sendRedirect("myJsp.jsp");
    	}
    }
}
