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
             System.out.println("filter���١�����");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		System.out.println("filter����ǰ....");
		chain.doFilter(request, response);
		System.out.println("filter���˺�....");

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("filter��ʼ��...");

	}

}
