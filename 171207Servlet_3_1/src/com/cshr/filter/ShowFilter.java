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

public class ShowFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse res = (HttpServletResponse) response;
            
           Enumeration<String> ems = req.getParameterNames();
           while (ems.hasMoreElements()) {
				String name = ems.nextElement();
				String [] values = req.getParameterValues(name);
					for (int i = 0; i < values.length; i++) {
						if(values[i].equalsIgnoreCase("NULL")){
							values[i] = "XXXX";
						}
					}
		    }
           chain.doFilter(req, res);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
