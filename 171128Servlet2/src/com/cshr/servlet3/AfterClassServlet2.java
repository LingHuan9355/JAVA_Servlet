package com.cshr.servlet3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 *<p>Title:AfterClassServlet2 </p>
 *<p>Description: </p>
 *2.дһ��servlet���̳�GenericServlet),�������е�ͷ��Ϣ���ҵ�������ַ����Ϣ��Ȼ���ӡ���ͻ���
 *
 *@author LH
 *@date 2017-12-2����01:34:30
 *@version V1.0
 */
@SuppressWarnings("serial")
public class AfterClassServlet2 extends GenericServlet {

	@SuppressWarnings("unchecked")
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		//�õ�Request��һЩ��������ͷ�ķ���
		//resp.setContentType("application/vnd.ms-excel;charset=GBK");
		//application/vnd.ms-excel��excel���ķ�ʽ�򿪣�����������Ϊ�����ͻ����������֧�ֵ� ��ʽ
		
		  //ֻ��HttpServletRequest�ڿ��Եõ�ͷ��Ϣ
            HttpServletRequest request = (HttpServletRequest) req;   
		    HttpServletResponse response = (HttpServletResponse) res;
		
		    response.setContentType("text/html;charset=UTF-8");
		    request.setCharacterEncoding("utf-8");
		    PrintWriter out = response.getWriter();

		    //�õ�����ͷ��һ��ö��   
			 Enumeration ems = request.getHeaderNames();
			//�Ա��ķ�ʽ��ӡ����	
			 out.println("<table border='1'>");
			//�Ƿ��и����Ԫ��
			 while (ems.hasMoreElements()) {
				out.println("<tr>");
				//��ö����ȡ�ü�
				String key = (String) ems.nextElement();
				//ͨ����ȡֵ
				String value = request.getHeader(key);
				out.println("<td>" + key + "</td>");
				out.println("<td>" + value + "</td>");
				out.println("<tr>");
			 }
			   out.println("</table>");
	} 

}
