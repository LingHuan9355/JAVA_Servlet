package com.cshr.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cshr.dao.ProvinceDao;
import com.cshr.entity.Province;

@SuppressWarnings("serial")
public class ProvinceServlet extends HttpServlet {

	   @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
                  
		   List<Province> list = ProvinceDao.queryList();
		     /*for (Province province : list) {
				  System.out.println(province.getPid()+"\t"+province.getName());
			 }*/
		     
		     request.setAttribute("plist",list);
		     request.getRequestDispatcher("city.jsp").forward(request, response);
	          
	 }
	   
	   @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
