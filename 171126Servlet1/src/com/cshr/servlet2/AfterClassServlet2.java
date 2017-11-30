package com.cshr.servlet2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 *<p>Title:AfterClassServlet2 </p>
 *<p>Description: 
 *2.写一个类继承GenericServlet,在service方法中读取硬盘的一个文本文档的内容(自拟),读到方法中，再输出到客户端
 *
 *</p>
 *@author LH
 *@date 2017-11-28下午09:52:25
 *@version V1.0
 */
@SuppressWarnings("serial")
public class AfterClassServlet2 extends GenericServlet {

	String filePath = "D:\\JAVA_WorkSpace2\\link.txt";
	
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
           HttpServletResponse response = (HttpServletResponse) res;
           
           FileReader fr = new FileReader(filePath);
           BufferedReader br = new BufferedReader(fr);
           
           String str = br.readLine();
            while(str != null){
            	System.out.println(str);
            	response.setContentType("text/html;charset=utf-8");
            	PrintWriter out = response.getWriter();
            	out.println(str);
            	str=br.readLine();
            }
		     br.close();
		     fr.close();
	}

}
