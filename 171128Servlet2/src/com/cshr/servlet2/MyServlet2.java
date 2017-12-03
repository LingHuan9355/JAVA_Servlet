package com.cshr.servlet2;

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
 *<p>Title:MyServlet2 </p>
 *<p>Description: </p>
 *2.在一个jsp页面中,向request里面设置三个值（用户名，密码，和爱好（爱好，注意对应的value是个字符串数组））,
           然后转发到一个Servlet(继承GenericServlet)里面,拿出参数名和参数值，并输出到客户端（使用表格）
 *@author LH
 *@date 2017-12-1下午05:42:39
 *@version V1.0
 */
public class MyServlet2 extends GenericServlet {

	@SuppressWarnings("unchecked")
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
            HttpServletRequest request = (HttpServletRequest) req;
            HttpServletResponse response = (HttpServletResponse) res;
            
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            
            Enumeration<String> ems = request.getAttributeNames();
            while (ems.hasMoreElements()) {
				String name = (String) ems.nextElement();
				 if(request.getAttribute(name) instanceof String [] ){
					 
					 String [] values = (String[]) request.getAttribute(name);
					 
					 if(null != values){
                         for (int i = 0; i < values.length; i++) {
							System.out.println(name + "\t"+values[i]);
							out.println(name + "="+values[i]);
						}
					 }
				 }else{
					 String value = (String) request.getAttribute(name);
					 System.out.println(name + "\t"+ value);
					 out.println(name + "="+ value);
				 }
				
			}
	}

}
