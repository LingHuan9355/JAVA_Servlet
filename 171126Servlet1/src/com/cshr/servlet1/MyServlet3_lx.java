package com.cshr.servlet1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 
 *<p>Title:MyServlet3_lx </p>
 *<p>Description:
 *3.写一个类实现Servlet接口,统计此servlet被请求了多少次，输出到客户端,在销毁此Servlet的时候，
 *将请求次数写到硬盘的文本文档中.
 * </p>
 *
 *@author LH
 *@date 2017-11-27下午10:35:50
 *@version V1.0
 */
public class MyServlet3_lx implements Servlet {

	String filePath = "D:\\JAVA_WorkSpace2\\link.txt";
	int num;
	
	@Override
	public void destroy() {
		System.err.println("销毁此Servlet");
		 WriteStringToFile(filePath);
		 WriteStringToFile2(filePath);
		 
	}

	public void WriteStringToFile2(String filePath) {
		FileWriter fw;
		try {
			fw = new FileWriter(filePath, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.append("在已有的基础上添加字符串");
			bw.append("&"+num+"$");// 往已有的文件上添加字符串
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void WriteStringToFile(String filePath) {
		//File file = new File(filePath);
        // PrintStream ps = new PrintStream(new FileOutputStream(file));
        File file = new File(filePath);
        PrintStream ps;
		try {
			ps = new PrintStream(new FileOutputStream(file));
			ps.println("#"+num+"#");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {

		res.setContentType("text/html;charset=UTF-8");
		num++;
		PrintWriter out = res.getWriter();
		out.println("此servlet被请求了" + num + "次");
		System.out.println("servlet被调用了"+num+"次");
	}

}
