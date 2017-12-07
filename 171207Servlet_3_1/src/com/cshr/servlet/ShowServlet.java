package com.cshr.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 *<p>Title:ShowServlet </p>
 *Description: 
 *4.дһ��jsp,��һ���������������û�����ѡ���Ա�ѡ�񰮺ö����ѡ�򣬸������ϵ��ı���
 *��post�ύ��һ��Servlet��дһ��filter��������������е�ֵ�������Ϊnull���͸���
 *һ�����ַ�����Ȼ����servlet�еõ����ݣ�Ҫ���������������,Ȼ���ӡ������ͻ���.
 *@author LH
 *@date 2017-12-7����04:54:20
 *@version V1.0
 */
@SuppressWarnings("serial")
public class ShowServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
           HttpServletRequest request = (HttpServletRequest) req;
           HttpServletResponse response = (HttpServletResponse) res;
           
           request.setCharacterEncoding("utf-8");
          // response.setContentType("text/html;charset=utf-8");
           
           String userName = request.getParameter("userName");
           String sex = request.getParameter("sex");
           String [] hobbys = request.getParameterValues("hobby");
           String data = request.getParameter("data");
           
           PrintWriter out = response.getWriter();
           out.print("�û�����"+userName+"<br/>�Ա�"+ sex);
           out.print("����:");
   		   out.print("<br/>");
           for (String hb : hobbys) {
			  out.println(hb);
		   }
           out.print("<br/>");
   		   out.print("������Ϣ:"+data);
		
	}

}
