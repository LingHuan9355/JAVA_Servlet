package com.cshr.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 *<p>Title:LoginServlet </p>
 *Description: 
 *3.在WebRoot目录下面建一个save文件夹，里面写一个save.jsp,jsp中写上"这里是受保护的页面"，然后复制上题的登录页面，重命名
  然后以post方式提交到LoginServlet中,在servlet中解决post方式的中文乱码，然后拿到用户名,将用户名设置到session中，
  然后重定向“/save/save.jsp”,准备一个过滤器，过滤掉“/save/save.jsp”的请求，在doFilter()中检查session里面的值是否为空，
  如果为空，重定向到登录页面。注意:filter配置。
 *@author LH
 *@date 2017-12-7下午03:32:59
 *@version V1.0
 */
@SuppressWarnings("serial")
public class LoginServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession();
        
        request.setCharacterEncoding("utf-8");
        
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        
        System.out.println("userName=" + userName+ ",pwd=" + passWord);
        
        if("李四".equals(userName) && "123".equals(passWord)){
        	session.setAttribute("uname", userName);
        	response.sendRedirect("save/save.jsp");
        }else{
        	response.sendRedirect("login3.jsp");
        }
        
		
		
	}

}
