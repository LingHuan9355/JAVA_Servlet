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
 *һ.��̬������֤
 *(1)дһ����¼ҳ��login.jsp�����������û���������,��post��ʽ�ύ��LoginServlet���̳�GenericServlet���У�
 *��LoginServlet���õ��û���������,�ж��û����������ǲ��Ƕ���"admin",����ǣ��ض���dync.jsp�������ض���error.jsp��
 *  
 *(2)дһ��������LoginFilterֻ���loginServlet�����󣬽��й���,�ڵ�¼�����ػ�LoginFilter֮��Ҳ���������
 *Ҫд�Ĵ��������doFilter()֮��,����һ����λ������(��ʾ:Math.random()),���������д��Ӳ�̵�һ��dync.txt�б���������
 *���⽫����������õ�session�У��ر���Ӧ���������
    
 *(3)��dync.jsp,��һ���������С�  ���������Ķ�̬����:�����ı���,��Ҫ��dync.txt���ҵ���̬���룬���뵽�ı�����,
 *Ȼ����post��ʽ�ύ��DyncServlet(�̳�HttpServlet,��дdoPost())�С�

 *(4)��DyncServlet��,�õ����ύ������ֵ���õ�session�ڵ�ֵ���������ֵ��ȣ�ת�����ɹ�ҳ�棬�������ȣ��ض��򵽵�¼ҳ��.

 *@author LH
 *@date 2017-12-8����10:30:30
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
           
           String userName = request.getParameter("userName");
           String passWord = request.getParameter("passWord");
           
           System.out.println("name" + userName + "/pwd" + passWord);
           
           if("admin".equals(userName) && "admin".equals(passWord)){
        	   session.setAttribute("uname", userName);
        	   response.sendRedirect("dync.jsp");
        	   
           }else{
        	   response.sendRedirect("error.jsp");
           }
           
           
	}

}
