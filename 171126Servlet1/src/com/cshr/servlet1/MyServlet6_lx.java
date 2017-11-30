package com.cshr.servlet1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 *<p>Title:MyServlet6_lx </p>
 *<p>Description: 
 *6.从一个jsp页面上使用get方式提交两个文本框，一个下拉列表，下拉列表中是（+,-,*,/）到Servlet，
 * Servlet根据请求做相应的计算，得到结果后输出到客户端.(要求使用继承HttpServlet的方式完成)
 *</p>
 *
 *@author LH
 *@date 2017-11-27下午11:52:33
 *@version V1.0
 */
@SuppressWarnings("serial")
public class MyServlet6_lx extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String first = "";
		String second = "";
		String operator = "";
		
		first = req.getParameter("first");
		first = new String(first.getBytes("iso-8859-1"), "UTF-8");

		second = req.getParameter("second");
		second = new String(second.getBytes("iso-8859-1"),"UTF-8");

	    operator =req.getParameter("operator");
	    operator = new String(operator.getBytes("iso-8859-1"), "UTF-8");
	   
	    int one = Integer.parseInt(first);
		int two = Integer.parseInt(second);
		 
	    resp.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = resp.getWriter();
	    int result = 0;
	    if("+".equals(operator)){
	    	result = one + two;

	    }else if("-".equals(operator)){
	    	result = one - two;
	    	
	    }else if("*".equals(operator)){
		    result = one * two;
		
        }else if("/".equals(operator)){
	        result = one / two;
	
        }
	    out.println("结果："+result);
		
		

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
