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
 *3.дһ����ʵ��Servlet�ӿ�,ͳ�ƴ�servlet�������˶��ٴΣ�������ͻ���,�����ٴ�Servlet��ʱ��
 *���������д��Ӳ�̵��ı��ĵ���.
 * </p>
 *
 *@author LH
 *@date 2017-11-27����10:35:50
 *@version V1.0
 */
public class MyServlet3_lx implements Servlet {

	String filePath = "D:\\JAVA_WorkSpace2\\link.txt";
	int num;
	
	@Override
	public void destroy() {
		System.err.println("���ٴ�Servlet");
		 WriteStringToFile(filePath);
		 WriteStringToFile2(filePath);
		 
	}

	public void WriteStringToFile2(String filePath) {
		FileWriter fw;
		try {
			fw = new FileWriter(filePath, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.append("�����еĻ���������ַ���");
			bw.append("&"+num+"$");// �����е��ļ�������ַ���
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
		out.println("��servlet��������" + num + "��");
		System.out.println("servlet��������"+num+"��");
	}

}
