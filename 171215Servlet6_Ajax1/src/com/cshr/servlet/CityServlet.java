package com.cshr.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cshr.dao.CityDao;
import com.cshr.entity.City;

@SuppressWarnings("serial")
public class CityServlet extends HttpServlet {

	
	    @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	    		throws ServletException, IOException {
	    
	    	int pid = Integer.parseInt(req.getParameter("pid"));
	    	//System.out.println(pid);
	    	CityDao cityDao = new CityDao();
	    	List<City> list = cityDao.queryById(pid);
 	        StringBuffer sb = new StringBuffer();
 	        sb.append("<citys>");
 	        for (City city : list) {
				sb.append("<city>");
				sb.append("<cid>"+city.getCid()+"</cid>");
				sb.append("<cname>"+city.getCname()+"</cname>");
				sb.append("</city>");
			}
 	        sb.append("</citys>");
	    
 	        resp.setContentType("text/xml;charset=utf-8");
 	        PrintWriter out = resp.getWriter();
 	        out.println(sb);
 	        System.out.println(sb);
 	        
 	        
	    }
	    
	    @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	    	throws ServletException, IOException {
                     doGet(req, resp);
	    }
}
