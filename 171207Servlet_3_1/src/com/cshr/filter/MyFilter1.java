package com.cshr.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter1 implements Filter{

	
	public MyFilter1() {
		System.out.println("������filter����....");
	}
	
	public void destroy() {
           System.out.println("������filter����...");		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
           System.out.println("����ǰ��������");
           chain.doFilter(request, response);
           System.out.println("���˺󡣡���");
		
	}

	public void init(FilterConfig filterConfig) throws ServletException {
             System.out.println("������filter��ʼ��...");		
	}

}
