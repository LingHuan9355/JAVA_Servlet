package com.cshr.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 *<p>Title:LoginServlet </p>
 *Description: 
 *3.��WebRootĿ¼���潨һ��save�ļ��У�����дһ��save.jsp,jsp��д��"�������ܱ�����ҳ��"��Ȼ��������ĵ�¼ҳ�棬������
  Ȼ����post��ʽ�ύ��LoginServlet��,��servlet�н��post��ʽ���������룬Ȼ���õ��û���,���û������õ�session�У�
  Ȼ���ض���/save/save.jsp��,׼��һ�������������˵���/save/save.jsp����������doFilter()�м��session�����ֵ�Ƿ�Ϊ�գ�
  ���Ϊ�գ��ض��򵽵�¼ҳ�档ע��:filter���á�
 *@author LH
 *@date 2017-12-7����03:32:59
 *@version V1.0
 */
@SuppressWarnings("serial")
public class LoginServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession();
        
        request.setCharacterEncoding("utf-8");
        
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        
        System.out.println("userName=" + userName+ ",pwd=" + passWord);
        
        if("����".equals(userName) && "123".equals(passWord)){
        	session.setAttribute("uname", userName);
        	response.sendRedirect("save/save.jsp");
        }else{
        	response.sendRedirect("login3.jsp");
        }
        
		
		
	}

}
