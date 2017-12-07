package com.cshr.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EncodeFilter implements Filter {

	public void destroy() {}

	@SuppressWarnings("unchecked")
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        
        String method = req.getMethod();
        if("get".equalsIgnoreCase(method)){
	        Enumeration<String> ems =  req.getAttributeNames();
	        while (ems.hasMoreElements()) {
				String name = (String) ems.nextElement();
				String []values = req.getParameterValues(name);
				if(values != null){
					for (int i = 0; i < values.length; i++) {
						values[i] = new String(values[i].getBytes("iso-8859-1"),"utf-8");
					}
				}
			}
        }else if("post".equalsIgnoreCase(method)){
        	req.setCharacterEncoding("utf-8");
        }
		
        res.setContentType("text/html;charset=utf-8");
        chain.doFilter(req, res);
	}

	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
