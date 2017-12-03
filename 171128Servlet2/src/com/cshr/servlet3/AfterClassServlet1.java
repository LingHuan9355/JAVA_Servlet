package com.cshr.servlet3;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 *<p>Title:AfterClassServlet1 </p>
 *<p>Description: 
 *1.写一个jsp，一个用户名的文本框，三个爱好复选框（篮球，足球，排球），
 *然后提交到一个Servlet（继承GenericServlet），解决中文乱码问题以后，打印输出到客户端
 *</p>
 *
 *@author LH
 *@date 2017-12-2上午01:04:48
 *@version V1.0
 */

@SuppressWarnings("serial")
public class AfterClassServlet1 extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
     
		HttpServletRequest request = (HttpServletRequest) req;
		@SuppressWarnings("unused")
		HttpServletResponse response = (HttpServletResponse) res;
		
		// 统一解决中文乱码问题
		encoding(request);
		
		String uname = request.getParameter("uname");
		String [] hobbys = request.getParameterValues("hobby");
		System.out.println("uname=" + uname);
		for (int i = 0; i < hobbys.length; i++) {
			System.out.println(hobbys[i]);
		}
		
	}

	@SuppressWarnings("unchecked")
	private void encoding(HttpServletRequest request)
			throws UnsupportedEncodingException {
		Map<String,String[]> map = request.getParameterMap();
		for (String key : map.keySet()) {
			String [] values = map.get(key);
			for (int i = 0; i < values.length; i++) {
				if(values !=null){
					values[i] = new String(values[i].getBytes("iso-8859-1"),"UTF-8");
				}
			}
		}
	}

}
