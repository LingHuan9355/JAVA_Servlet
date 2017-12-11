package com.cshr.listener;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationListener implements ServletContextListener {

	public ApplicationListener() {
		super();
	        //System.out.println("application�����Ĵ���������");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
            //System.out.println("application���������١�����");
		//��ȡ�������������
		ServletContext application = event.getServletContext();
        int count = (Integer) application.getAttribute("count");
        int sum = (Integer) application.getAttribute("sum");
        
        //����properties������
        ps = new Properties();
        ps.setProperty("count", count+"");
        ps.setProperty("sum", sum+"");
        
        try {
        	 //�ֽ������
			 OutputStream os = new FileOutputStream(application.getRealPath("/WEB-INF") + "/count.properties");
		     PrintWriter out = new PrintWriter(os);
		     ps.list(out);
		     
		     out.close();
		     os.close();
        
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	Properties ps;
	@Override
	public void contextInitialized(ServletContextEvent event) {
                 //System.out.println("application�����ĳ�ʼ��");
		//����application���󣬶�ȡ�ⲿ�ļ����س�һ��Properties����
		ServletContext application = event.getServletContext();
		InputStream is = application.getResourceAsStream("/WEB-INF/count.properties");
		ps = new Properties();
		try {
			ps.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//�����
		int count = Integer.parseInt(ps.get("count").toString());
		//������
		int sum = Integer.parseInt(ps.get("sum").toString());
	    
		application.setAttribute("count", count);
		application.setAttribute("sum", sum);
		//��������
		application.setAttribute("online", 0);
	}

}
