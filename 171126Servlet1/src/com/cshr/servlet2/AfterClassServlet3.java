package com.cshr.servlet2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 *<p>Title:AfterClassServlet3 </p>
 *<p>Description:
 *3.��һ��jspҳ����ʹ��get��ʽ�ύ�����ı���(������)��һ�������б������б�������ѡ�max,min����Servlet��
 * Servlet���ݴ�����������,�����max,�����������������ֵ��������Сֵ��Ȼ���ӡ���ͻ���
 * int max=(a>b?a:b)>c?(a>b?a:b):c;
 * int min=(a<b?a:b)<c?(a<b?a:b):c;
 *</p>
 *
 *@author LH
 *@date 2017-11-28����10:23:11
 *@version V1.0
 */
@SuppressWarnings("serial")
public class AfterClassServlet3 extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	            String first = req.getParameter("first");
	            String second = req.getParameter("second");
	            String third = req.getParameter("third");
	            String compare = req.getParameter("compare");
	
	            int a = Integer.parseInt(new String(first.getBytes("iso-8859-1"),"utf-8"));
	            int b = Integer.parseInt(new String(second.getBytes("iso-8859-1"),"utf-8"));
	            int c = Integer.parseInt(new String(third.getBytes("iso-8859-1"),"utf-8"));
	            
	            String MM = new String(compare.getBytes("iso-8859-1"),"utf-8");
	               
	            resp.setContentType("text/html;charset=utf-8");
	            PrintWriter out = resp.getWriter();
	            if("max".equalsIgnoreCase(MM)){
	            	/*int max = a;
	            	if(max < b){
	            		max = b;
	            	}
	            	if(max < c){
	            		max = c;
	            	}*/
	            	int max=(a>b?a:b)>c?(a>b?a:b):c;
	            System.out.println("max = " + max);
	            out.println("max = " + max);
	            	
	            }else if("min".equalsIgnoreCase(MM)){
	            	/*int min = a;
	            	if(min > b){
	            		min = b;
	            	}
	            	if(min >c){
	            		min = c;
	            	}*/
	            	int min=(a<b?a:b)<c?(a<b?a:b):c;
	            	
	            	System.out.println("min = " + min);
	            	out.println("min = " + min);
	            }
	             
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

	            doGet(req, resp);
	}
}
