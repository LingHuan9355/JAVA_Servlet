package com.cshr.servlet1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet5 extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		ServletContext context =  this.getServletContext();
		InputStream is = context.getResourceAsStream("/WEB-INF/my.jsp");
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		
		String str = br.readLine();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		while(str !=null){
			out.println(str);
			str = br.readLine();
		}
		
	}

}
