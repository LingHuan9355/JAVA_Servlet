package com.cshr.servlet3;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 *<p>Title:AfterClassServlet3 </p>
 *<p>Description: </p>
 *3.写一个index.jsp其中含有一个用户名的文本框，三个单选框，表示三个产品（苹果，梨子，香蕉）的表单,表单提交到一个
  servlet（继承HttpServlet）中，将用户名和产品保存到session中,然后从定向到result.jsp,显示用户名和产品名称
 *@author LH
 *@date 2017-12-2上午01:46:37
 *@version V1.0
 */

@SuppressWarnings("serial")
public class AfterClassServlet3 extends HttpServlet {

	
	  @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
              doPost(req, resp);
	  }

      @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    
             HttpSession session = req.getSession();
             
             // 统一解决中文乱码问题
             encoding(req);
             
             String uname = req.getParameter("uname");
             String fruit = req.getParameter("fruit");
                   
             session.setAttribute("sname", uname);
             session.setAttribute("sfruit", fruit);
             
             resp.sendRedirect("result3.jsp");
      }

	@SuppressWarnings("unchecked")
	private void encoding(HttpServletRequest req)
			throws UnsupportedEncodingException {
		Map<String ,String[]> map = req.getParameterMap();
		  for (String key : map.keySet()) {
			   String [] values = map.get(key);
			   for (int j = 0; j < values.length; j++) {
				if(values != null){
					values[j] = new String(values[j].getBytes("iso-8859-1"),"UTF-8");
				}
			}
		}
	}
}
