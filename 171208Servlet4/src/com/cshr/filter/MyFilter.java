package com.cshr.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter implements Filter {

	@Override
	public void destroy() {
             System.out.println("filter销毁。。。");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		System.out.println("filter过滤前....");
		chain.doFilter(request, response);
		System.out.println("filter过滤后....");

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("filter初始化...");

	}

}
