package com.cshr.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cshr.dao.ConsteDao;
import com.cshr.entity.City;
import com.cshr.entity.Conste;

@SuppressWarnings("serial")
public class ContentServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          request.setCharacterEncoding("utf-8");
          String name = request.getParameter("name");
          
          if(name !=null){
        	  name =new String(name.getBytes("iso-8859-1"),"utf-8"); 
          }
          
		//int cid = Integer.parseInt(sid);
		System.out.println(name);
		
		Conste conste = ConsteDao.queryById(name);
		
		 StringBuffer sb = new StringBuffer();
	        sb.append("<constes>");
				sb.append("<conste>");
				sb.append("<id>"+conste.getId()+"</id>");
				sb.append("<name>"+conste.getName()+"</name>");
				sb.append("<content>"+conste.getContent()+"</content>");
				sb.append("</conste>");
	        sb.append("</constes>");
	    
	        response.setContentType("text/xml;charset=utf-8");
	        PrintWriter out = response.getWriter();
	        out.println(sb);
	        System.out.println(sb);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
                    doGet(req, resp);
	}
}
