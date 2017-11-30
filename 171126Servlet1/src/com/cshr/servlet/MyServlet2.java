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
 *Servlet的生命周期 
 * Servlet只在第一次访问时创建一个对象 ，单例模式
 * 构造方法   在第一次访问时调用
 * init() 在第一次访问时调用
 * service()  服务方法，每次访问时都会调用
 * destory()  在关闭服务器(tomcat)时会调用
 *</p>
 *
 *@author LH
 *@date 2017-11-26下午10:08:48
 */
public class MyServlet2 implements Servlet {

	
    private ServletConfig config;
    
    public MyServlet2(){
    	System.out.println("servlet出生...");
    }
	
	@Override
	public void destroy() {
		System.out.println("servlet销毁...");
	}

	//ServletConfig Servlet的配置信息的对象
	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	//获取当前的Serlvet的描述信息
	@Override
	public String getServletInfo() {
		return "这是自定义的一个servlet...";
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
           System.out.println("servlet初始化...");
           this.config = config;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		System.out.println("servlet开始服务...");
		
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		out.println("服务 hello world！");
		
		String  encoding = config.getInitParameter("ecoding");
		System.out.println(encoding);
                    
	}

}
