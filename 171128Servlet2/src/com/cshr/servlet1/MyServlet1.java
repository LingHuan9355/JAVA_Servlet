package com.cshr.servlet1;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class MyServlet1 extends GenericServlet {

	@SuppressWarnings("unchecked")
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
          HttpServletRequest request = (HttpServletRequest) req;
          HttpServletResponse response = (HttpServletResponse) res;
          
          response.setContentType("text/html;charset=UTF-8");
          PrintWriter out = response.getWriter();
          
          //encode(request, out);
		
          encode2(request, out);
          
          String userName = request.getParameter("userName");
          String sex = request.getParameter("sex");
          String address = request.getParameter("address");
          String [] hobby = request.getParameterValues("hobby");
		  out.println(userName +"\t" + sex + "\t" +address);
          for (String ho : hobby) {
			out.println("\t"+ho);
		}
	}

	@SuppressWarnings("unchecked")
	private void encode2(HttpServletRequest request, PrintWriter out)
			throws UnsupportedEncodingException {
		//获取表单以name的值为key，以value值为value;
          Map<String,String[]> map = request.getParameterMap();
          for (String key: map.keySet()) {
			String [] values = map.get(key);
			if(values !=null){
				for (int i = 0; i < values.length; i++) {
					values[i] = new String(values[i].getBytes("iso-8859-1"),"UTF-8");
					/*System.out.println(values[i]);
					out.println(values[i]);*/
				}
			}
		}
	}

	@SuppressWarnings({ "unchecked", "unused" })
	private void encode(HttpServletRequest request, PrintWriter out)
			throws UnsupportedEncodingException {
		//统一一次性的获取表单所有控件的name值
          Enumeration<String> ens = request.getParameterNames();
          while(ens.hasMoreElements()){
        	//拿出每个表单的name属性值 
        	  String name = ens.nextElement();
        	//根据name属性值，获取表单中的内容(数组)
        	  String [] values = request.getParameterValues(name);
        	  if(values != null){
        		  for (int i = 0; i < values.length; i++) {
					values[i] = new String(values[i].getBytes("iso-8859-1"),"UTF-8");
					/*System.out.println(values[i]);
					out.println(values[i]);*/
				}
        	  }
          }
	}

}
