package com.cshr.listener;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
/**
 * 
 *<p>Title:ContextListener </p>
 *Description: 
 *1.ͳ����������������������ͷ��ʵ�������
 *@author LH
 *@date 2017-12-11����03:49:10
 *@version V1.0
 */
public class ContextListener implements ServletContextListener {

	public ContextListener() {
             super();
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {

		ServletContext application =event.getServletContext();
		//��ȡ�������������
		int count = (Integer) application.getAttribute("count");
		int sum = (Integer)application.getAttribute("sum");
		
		//����һ��Propertiesʵ��
		ps = new Properties();
		ps.setProperty("count", count+"");
		ps.setProperty("sum", sum+"");
		
		OutputStream os =null;
		PrintWriter out =null ;
		try {
		      os = new FileOutputStream(application.getRealPath("/WEB-INF")+"/num.properties");
	          out =new PrintWriter(os);
	          ps.list(out);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if( out !=null){
					out.close();
				}
				if(os != null){
						os.close();
				}
		   } catch (IOException e) {
					e.printStackTrace();
		   }
		 }
	}

	Properties ps;
	@Override
	public void contextInitialized(ServletContextEvent event) {
             
		//����application���󣬶�ȡ�ⲿ�ļ����س�һ��Properties����
		ServletContext application = event.getServletContext();
		
		InputStream is = application.getResourceAsStream("/WEB-INF/num.properties");
	   ps = new Properties();
		try {
			ps.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//��ȡ�����
		int count = Integer.parseInt(ps.get("count").toString());
		//��ȡ������
		int sum = Integer.parseInt(ps.get("sum").toString());
		
		//���õ����
		application.setAttribute("count", count);
		//���÷�����
		application.setAttribute("sum", sum);
		//������������
		application.setAttribute("online", 0);
	}

}
