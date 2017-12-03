package com.cshr.servlet3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 *<p>Title:AfterClassServlet2 </p>
 *<p>Description: </p>
 *2.写一个servlet（继承GenericServlet),从请求中的头信息中找到主机地址的信息，然后打印到客户端
 *
 *@author LH
 *@date 2017-12-2上午01:34:30
 *@version V1.0
 */
@SuppressWarnings("serial")
public class AfterClassServlet2 extends GenericServlet {

	@SuppressWarnings("unchecked")
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		//得到Request的一些常用请求头的方法
		//resp.setContentType("application/vnd.ms-excel;charset=GBK");
		//application/vnd.ms-excel是excel表单的方式打开，还可以设置为其他客户端浏览器所支持的 格式
		
		  //只有HttpServletRequest在可以得到头信息
            HttpServletRequest request = (HttpServletRequest) req;   
		    HttpServletResponse response = (HttpServletResponse) res;
		
		    response.setContentType("text/html;charset=UTF-8");
		    request.setCharacterEncoding("utf-8");
		    PrintWriter out = response.getWriter();

		    //得到请求头的一个枚举   
			 Enumeration ems = request.getHeaderNames();
			//以表格的方式打印出来	
			 out.println("<table border='1'>");
			//是否有更多的元素
			 while (ems.hasMoreElements()) {
				out.println("<tr>");
				//从枚举中取得键
				String key = (String) ems.nextElement();
				//通过键取值
				String value = request.getHeader(key);
				out.println("<td>" + key + "</td>");
				out.println("<td>" + value + "</td>");
				out.println("<tr>");
			 }
			   out.println("</table>");
	} 

}
