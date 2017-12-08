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

	@SuppressWarnings("unchecked")
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
          HttpServletRequest req = (HttpServletRequest) request;
          HttpServletResponse res = (HttpServletResponse) response;
          //注意中文乱码的设置(web.xml中配置全局的过滤乱码，此处注释)
         // req.setCharacterEncoding("utf-8");
          Enumeration<String> ems = req.getParameterNames();
          while (ems.hasMoreElements()) {
			String name =  ems.nextElement();
			String [] values = req.getParameterValues(name);
			if(values != null){
				for (int i = 0; i < values.length; i++) {
					//根据key,从properties中拿到值,如果不为空,则证明一定有非法字符然后替换掉
					if(ps.get(values[i]) !=null){
						 values[i] = ps.getProperty(values[i]);
					}
				}
			}
	      }
		chain.doFilter(req, res);
	}
	
	Properties ps = null;
	//初始化中读取person.properties文件
	public void init(FilterConfig filterConfig) throws ServletException {
		 //读取person.properties文件
		InputStream is =filterConfig.getServletContext()
		                .getResourceAsStream("/WEB-INF/person.properties");
		ps = new Properties();
		try {
			//加载配置文件
			ps.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
