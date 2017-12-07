package com.cshr.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 *<p>Title:ShowServlet </p>
 *Description: 
 *4.写一个jsp,有一个表单，可以输入用户名，选择性别，选择爱好多个复选框，个人资料的文本域，
 *用post提交到一个Servlet，写一个filter过滤请求遍历所有的值，如果有为null，就给它
 *一个空字符串，然后在servlet中得到数据，要解决中文乱码问题,然后打印输出到客户端.
 *@author LH
 *@date 2017-12-7下午04:54:20
 *@version V1.0
 */
@SuppressWarnings("serial")
public class ShowServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
           HttpServletRequest request = (HttpServletRequest) req;
           HttpServletResponse response = (HttpServletResponse) res;
           
           request.setCharacterEncoding("utf-8");
          // response.setContentType("text/html;charset=utf-8");
           
           String userName = request.getParameter("userName");
           String sex = request.getParameter("sex");
           String [] hobbys = request.getParameterValues("hobby");
           String data = request.getParameter("data");
           
           PrintWriter out = response.getWriter();
           out.print("用户名："+userName+"<br/>性别："+ sex);
           out.print("爱好:");
   		   out.print("<br/>");
           for (String hb : hobbys) {
			  out.println(hb);
		   }
           out.print("<br/>");
   		   out.print("个人信息:"+data);
		
	}

}
