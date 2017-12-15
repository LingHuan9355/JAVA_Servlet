package com.cshr.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cshr.dao.BaseDao;
import com.cshr.dao.ProvinceDao;
import com.cshr.entity.Province;

/**
 * 
 *<p>Title:ProvinceServlet </p>
 *Description: 
 *
 *2.写一个省份和城市的二级联动下拉列表
 *@author LH
 *@date 2017-12-15下午01:11:52
 *@version V1.0
 */
@SuppressWarnings("serial")
public class ProvinceServlet extends HttpServlet {

	    @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	    		throws ServletException, IOException {

	    	      ProvinceDao proDao = new ProvinceDao();
	              List<Province> list = proDao.queryList();
	              for (Province province : list) {
					System.out.println(province.getPid()+":"+province.getPname());
				  }
	              
	              req.setAttribute("plist", list);
	              req.getRequestDispatcher("city.jsp").forward(req, resp);
	              
	    }
	    
	    @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	    	throws ServletException, IOException {
                     doGet(req, resp);
	    
	    }
}
