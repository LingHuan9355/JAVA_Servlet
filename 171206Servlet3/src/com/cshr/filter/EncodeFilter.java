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
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		String method = request.getMethod();
		//先判断请求的类型
        if("get".equalsIgnoreCase(method)){
        	Enumeration<String> ems = request.getAttributeNames();
            if(ems.hasMoreElements()){
               String key = ems.nextElement();
               String [] values = request.getParameterValues(key);
               if(values != null){
            	   for (int i = 0; i < values.length; i++) {
					  values[i] = new String(values[i].getBytes("iso-8859-1"), "utf-8");
				   }
               }
            }   
            
        }else if("post".equalsIgnoreCase(method)){
        	request.setCharacterEncoding("utf-8");
        }	
		
		//设置响应的编码
         response.setContentType("text/html;charset=utf-8");
         //过滤
        chain.doFilter(request, response);          
	}

	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
