package com.cshr.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	public void destroy() {

	}

	@SuppressWarnings("null")
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse res = (HttpServletResponse) response;
            
            HttpSession session = req.getSession();
             String roleName = (String) session.getAttribute("uname");
             String rolePwd = (String) session.getAttribute("pwd");
           //拿到项目的路径，相当于"/项目名"
            System.out.println("-------------"+req.getContextPath());
            
            if(roleName ==null && rolePwd ==null 
            		|| !roleName.equals("李四") && !rolePwd.equals("123")){
            	res.sendRedirect(req.getContextPath() + "/login3.jsp");
            }else {
            	chain.doFilter(req, res);
            }
		
		
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
