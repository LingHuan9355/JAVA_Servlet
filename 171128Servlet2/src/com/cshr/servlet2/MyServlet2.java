package com.cshr.servlet2;

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
 *<p>Title:MyServlet2 </p>
 *<p>Description: </p>
 *2.��һ��jspҳ����,��request������������ֵ���û��������룬�Ͱ��ã����ã�ע���Ӧ��value�Ǹ��ַ������飩��,
           Ȼ��ת����һ��Servlet(�̳�GenericServlet)����,�ó��������Ͳ���ֵ����������ͻ��ˣ�ʹ�ñ��
 *@author LH
 *@date 2017-12-1����05:42:39
 *@version V1.0
 */
public class MyServlet2 extends GenericServlet {

	@SuppressWarnings("unchecked")
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
            HttpServletRequest request = (HttpServletRequest) req;
            HttpServletResponse response = (HttpServletResponse) res;
            
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            
            Enumeration<String> ems = request.getAttributeNames();
            while (ems.hasMoreElements()) {
				String name = (String) ems.nextElement();
				 if(request.getAttribute(name) instanceof String [] ){
					 
					 String [] values = (String[]) request.getAttribute(name);
					 
					 if(null != values){
                         for (int i = 0; i < values.length; i++) {
							System.out.println(name + "\t"+values[i]);
							out.println(name + "="+values[i]);
						}
					 }
				 }else{
					 String value = (String) request.getAttribute(name);
					 System.out.println(name + "\t"+ value);
					 out.println(name + "="+ value);
				 }
				
			}
	}

}
