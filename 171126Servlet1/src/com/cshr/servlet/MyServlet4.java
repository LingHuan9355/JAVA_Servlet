package com.cshr.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *<p>Title:MyServlet4 </p>
 *<p>Description: 
 *�̳�GenericServlet��ֻ��Ҫ��ע��service����
 *�Ѵ���д���������֮��
 *</p>
 *@author LH
 *@date 2017-11-26����11:09:03
 */
@SuppressWarnings("serial")
public class MyServlet4 extends GenericServlet {

	//��������Ǹ��ഴ�������������д�ķ���
/*	public void init()throws ServletException{
		System.out.println("��д����Ĳ�����init����");
	}*/
	@Override
	public void init() throws ServletException {
		super.init();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		//���һ��Ҫ��д�������������Ҫ�������µ����д���
		//�Ա�֤servletconfig�ܱ���ʼ��
		super.init(config);
		System.out.println("��д����Ĵ��ε�init����");
	}
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		//�����service�����У�Ҫ���ֵ��׿ͻ��������get������post����
		//���ü̳�httpserlvet��ķ�ʽ
		@SuppressWarnings("unused")
		HttpServletRequest request = (HttpServletRequest) req;
		@SuppressWarnings("unused")
		HttpServletResponse response = (HttpServletResponse) res;
		System.out.println("GenericServlet....");		
		
		ServletConfig config = this.getServletConfig();
		System.out.println(config);//org.apache.catalina.core.StandardWrapperFacade@c063ad
		//�õ�sevlet����
        System.out.println("Servlet����:"+config.getServletName());

	}

}
