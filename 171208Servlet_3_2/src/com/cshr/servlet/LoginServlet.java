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
 *一.动态密码验证
 *(1)写一个登录页面login.jsp，可以填入用户名和密码,以post方式提交到LoginServlet（继承GenericServlet）中，
 *在LoginServlet中拿到用户名和密码,判断用户名和密码是不是都是"admin",如果是，重定向到dync.jsp，否则重定向到error.jsp。
 *  
 *(2)写一个过滤器LoginFilter只针对loginServlet的请求，进行过滤,在登录请求重回LoginFilter之后，也就是下面的
 *要写的代码必须在doFilter()之后,产生一个六位的整数(提示:Math.random()),将这个整数写到硬盘的一个dync.txt中保存起来，
 *另外将这个整数设置到session中，关闭响应的输出流。
    
 *(3)在dync.jsp,有一个表单，其中“  请输入您的动态密码:”的文本框,你要从dync.txt中找到动态密码，填入到文本框中,
 *然后以post方式提交到DyncServlet(继承HttpServlet,重写doPost())中。

 *(4)在DyncServlet中,拿到表单提交过来的值，拿到session内的值，如果两个值相等，转发到成功页面，如果不相等，重定向到登录页面.

 *@author LH
 *@date 2017-12-8上午10:30:30
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
           
           String userName = request.getParameter("userName");
           String passWord = request.getParameter("passWord");
           
           System.out.println("name" + userName + "/pwd" + passWord);
           
           if("admin".equals(userName) && "admin".equals(passWord)){
        	   session.setAttribute("uname", userName);
        	   response.sendRedirect("dync.jsp");
        	   
           }else{
        	   response.sendRedirect("error.jsp");
           }
           
           
	}

}
