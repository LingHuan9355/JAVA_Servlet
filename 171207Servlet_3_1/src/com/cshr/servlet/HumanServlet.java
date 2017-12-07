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
 *<p>Title:HumanServlet </p>
 *Description: 
 *5.дһ��jsp�������ı��򣬷ֱ���д������סַ��������λ,��post��ʽ�ύ��StrServlet(�̳�GenericServlet),
 *��web-inf׼��һ��str.properties�ļ�; �ļ�����: ������ = **(����), ���� = *** (סַ),�����鱨��=****(������λ)
 *дһ��Filter,��init()��ȡstr.properties����,��doFilter()���г����б���ֵ������г��������е��ַ��ͽ����滻,
 *����֮����StrServlet���õ�����,��ӡ������ͻ���
 *@author LH
 *@date 2017-12-7����05:43:17
 *@version V1.0
 */
@SuppressWarnings("serial")
public class HumanServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
          
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String job = request.getParameter("job");
		
		System.out.println(name+"\t"+address+"\t"+job);
        
		PrintWriter out = response.getWriter();
		out.println(name+"\t"+address+"\t"+job);
		
		  
	}

}
