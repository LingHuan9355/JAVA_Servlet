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
 *继承GenericServlet类只需要关注其service方法
 *把代码写在这个方法之中
 *</p>
 *@author LH
 *@date 2017-11-26下午11:09:03
 */
@SuppressWarnings("serial")
public class MyServlet4 extends GenericServlet {

	//这个方法是父类创建给子类进行重写的方法
/*	public void init()throws ServletException{
		System.out.println("重写父类的不带参init方法");
	}*/
	@Override
	public void init() throws ServletException {
		super.init();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		//如果一定要重写这个方法，则需要加上以下的这行代码
		//以保证servletconfig能被初始化
		super.init(config);
		System.out.println("重写父类的带参的init方法");
	}
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		//如果在service方法中，要区分到底客户端请的是get请求还是post请求
		//则用继承httpserlvet类的方式
		@SuppressWarnings("unused")
		HttpServletRequest request = (HttpServletRequest) req;
		@SuppressWarnings("unused")
		HttpServletResponse response = (HttpServletResponse) res;
		System.out.println("GenericServlet....");		
		
		ServletConfig config = this.getServletConfig();
		System.out.println(config);//org.apache.catalina.core.StandardWrapperFacade@c063ad
		//拿到sevlet名字
        System.out.println("Servlet名字:"+config.getServletName());

	}

}
