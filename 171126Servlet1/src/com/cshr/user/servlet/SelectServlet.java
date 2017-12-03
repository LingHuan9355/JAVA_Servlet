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
 *4.��׼��һ��Users��������id��name,pwd),����һЩ���ݣ�
 * ��һ��jspҳ��д�ϡ���ʾ�û����ĳ����ӵ�һ��servlet�������û��������룬��servlet���õ����ݣ��������ݿ��ж�
 * �û����������Ƿ���ȷ�������ȷ���鴦���ݣ��Ա�����ʽ��ӡ���ͻ��ˣ������������ȷ(Ҫ��ʹ�ü̳�HttpServlet�ķ�ʽ���)
 * ���ѣ��������⣬��������get��ʽ

 *@author LH
 *@date 2017-12-3����04:02:42
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
					  		" <tr><th>���</th>" +
					  		"<td>�û���</td>" +
					  		"<td>����</td></tr>");
					  out.println("<tr><td>"+users.getId()+"</td>" +
					  		"<td>"+users.getUserName()+"</td>" +
					  				"<td>"+users.getUserPwd()+"</td></tr>");
					 
					  out.println("</table>");
				  }else{
					  out.print("�û��������벻��ȷ \t");
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
