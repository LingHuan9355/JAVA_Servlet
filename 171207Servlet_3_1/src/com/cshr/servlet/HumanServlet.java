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
 *<p>Title:HumanServlet </p>
 *Description: 
 *5.写一个jsp，三个文本框，分别填写姓名，住址，工作单位,以post方式提交到StrServlet(继承GenericServlet),
 *在web-inf准备一个str.properties文件; 文件内容: 二狗子 = **(姓名), 地狱 = *** (住址),中央情报局=****(工作单位)
 *写一个Filter,在init()读取str.properties内容,在doFilter()中列出所有表单的值，如果有出现上述中的字符就进行替换,
 *过滤之后，在StrServlet中拿到数据,打印输出到客户端
 *@author LH
 *@date 2017-12-7下午05:43:17
 *@version V1.0
 */
@SuppressWarnings("serial")
public class HumanServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
          
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String job = request.getParameter("job");
		
		System.out.println(name+"\t"+address+"\t"+job);
        
		PrintWriter out = response.getWriter();
		out.println(name+"\t"+address+"\t"+job);
		
		  
	}

}
