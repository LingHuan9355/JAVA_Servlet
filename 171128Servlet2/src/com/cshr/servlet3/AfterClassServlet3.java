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
 *3.дһ��index.jsp���к���һ���û������ı���������ѡ�򣬱�ʾ������Ʒ��ƻ�������ӣ��㽶���ı�,���ύ��һ��
  servlet���̳�HttpServlet���У����û����Ͳ�Ʒ���浽session��,Ȼ��Ӷ���result.jsp,��ʾ�û����Ͳ�Ʒ����
 *@author LH
 *@date 2017-12-2����01:46:37
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
             
             // ͳһ���������������
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
