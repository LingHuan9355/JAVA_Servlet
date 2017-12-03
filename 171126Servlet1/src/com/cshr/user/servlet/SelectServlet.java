package com.cshr.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cshr.user.dao.UsersDao;
import com.cshr.user.entity.Users;

/**
 * 
 *<p>Title:SelectServlet </p>
 *<p>Description: </p>
 *4.（准备一个Users表，列名（id，name,pwd),插入一些数据）
 * 在一个jsp页面写上“显示用户”的超链接到一个servlet，带上用户名和密码，在servlet中拿到数据，查找数据库判断
 * 用户名和密码是否正确，如果正确，查处数据，以表格的形式打印到客户端，否则输出不正确(要求使用继承HttpServlet的方式完成)
 * 提醒：编码问题，超链接是get方式

 *@author LH
 *@date 2017-12-3下午04:02:42
 *@version V1.0
 */
@SuppressWarnings("serial")
public class SelectServlet extends HttpServlet {

	      @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	    		throws ServletException, IOException {

	    	  String uname = "";
	    	  String upwd = "";
	    	  
	    	  uname = req.getParameter("uname");
	    	  upwd = req.getParameter("upwd");
	    	  
	    	  uname = new String(uname.getBytes("iso-8859-1"), "utf-8");
	    	  upwd  = new String(upwd.getBytes("iso-8859-1"), "utf-8");
	    	  
	    	  System.out.println(uname + "=" +upwd);
	    	  List<Users> list = UsersDao.select();
	    	  
	    	  resp.setContentType("text/html;charset=utf-8");
	    	  PrintWriter out = resp.getWriter();
	    	  
	    	   for (Users users : list) {
				  if(uname.equals(users.getUserName()) 
						  && upwd.equals(users.getUserPwd())){
					  out.println("<table border=1 >" +
					  		" <tr><th>编号</th>" +
					  		"<td>用户名</td>" +
					  		"<td>密码</td></tr>");
					  out.println("<tr><td>"+users.getId()+"</td>" +
					  		"<td>"+users.getUserName()+"</td>" +
					  				"<td>"+users.getUserPwd()+"</td></tr>");
					 
					  out.println("</table>");
				  }else{
					  out.print("用户名或密码不正确 \t");
				  }
				 System.out.println(users.getUserName()+"\t" +users.getUserPwd());
			}
	    	  
	      }
	      
	      
	      
	      @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	    	throws ServletException, IOException {
	        doGet(req, resp);
	    }
}
