package com.cshr.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


/**
 *<p>Title:MyServlet2 </p>
 *<p>Description:
 *Servlet���������� 
 * Servletֻ�ڵ�һ�η���ʱ����һ������ ������ģʽ
 * ���췽��   �ڵ�һ�η���ʱ����
 * init() �ڵ�һ�η���ʱ����
 * service()  ���񷽷���ÿ�η���ʱ�������
 * destory()  �ڹرշ�����(tomcat)ʱ�����
 *</p>
 *
 *@author LH
 *@date 2017-11-26����10:08:48
 */
public class MyServlet2 implements Servlet {

	
    private ServletConfig config;
    
    public MyServlet2(){
    	System.out.println("servlet����...");
    }
	
	@Override
	public void destroy() {
		System.out.println("servlet����...");
	}

	//ServletConfig Servlet��������Ϣ�Ķ���
	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	//��ȡ��ǰ��Serlvet��������Ϣ
	@Override
	public String getServletInfo() {
		return "�����Զ����һ��servlet...";
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
           System.out.println("servlet��ʼ��...");
           this.config = config;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		System.out.println("servlet��ʼ����...");
		
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		out.println("���� hello world��");
		
		String  encoding = config.getInitParameter("ecoding");
		System.out.println(encoding);
                    
	}

}
