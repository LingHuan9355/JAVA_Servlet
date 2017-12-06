package com.cshr.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter implements Filter {

	public MyFilter() {
        System.out.println("filter创建...");
	}
	
	public void destroy() {
          System.out.println("filter销毁...");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
           System.out.println("进入filter过滤。。。");
           //过滤中
           chain.doFilter(request, response);
           
           System.out.println("退出filter过滤。。。");
	}

	public void init(FilterConfig filterConfig) throws ServletException {
             System.out.println("filter初始化...");
	}

}
