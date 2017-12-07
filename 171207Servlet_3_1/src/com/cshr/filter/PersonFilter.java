package com.cshr.filter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PersonFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
          HttpServletRequest req = (HttpServletRequest) request;
          HttpServletResponse res = (HttpServletResponse) response;
          
          Enumeration<String> ems = req.getParameterNames();
          while (ems.hasMoreElements()) {
			String name =  ems.nextElement();
			String [] values = req.getParameterValues(name);
			if(values != null){
				for (int i = 0; i < values.length; i++) {
					if(ps.get(values[i]) !=null){
						 values[i] = ps.getProperty(values[i]);
					}
				}
			}
	      }
		chain.doFilter(req, res);
	}
	
	Properties ps = null;

	public void init(FilterConfig filterConfig) throws ServletException {

		InputStream is =filterConfig.getServletContext()
		                .getResourceAsStream("/WEB-INF/person.properties");
		ps = new Properties();
		try {
			
			ps.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
