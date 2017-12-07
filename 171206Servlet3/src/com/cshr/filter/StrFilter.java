package com.cshr.filter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StrFilter implements Filter {

	public void destroy() {}

	@SuppressWarnings("unchecked")
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse res = (HttpServletResponse) response;
            
            Enumeration<String> ems = req.getParameterNames();
            while (ems.hasMoreElements()) {
				String key = (String) ems.nextElement();
				String [] values = req.getParameterValues(key);
				if(values !=null){
					//������ύ��ֵ��properties�ļ��д���
					for (int i = 0; i < values.length; i++) {
						if(ps.get(values[i]) != null){
						    values[i] =ps.getProperty(values[i]);
						}
					}
				}
				
			}
		    chain.doFilter(req, res);
		
	}

     Properties ps= null;
	
	//��ʼ���ж�ȡstr.properties�ļ�
	public void init(FilterConfig filterConfig) throws ServletException {
		
		try {
		   //��ȡstr.properties�ļ�
           ServletContext application = filterConfig.getServletContext();
           InputStream is = application.getResourceAsStream("/WEB-INF/str.properties");
            ps = new Properties();
            //���������ļ�
		    ps.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
