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
	        //System.out.println("application监听的创建。。。");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
            //System.out.println("application监听的销毁。。。");
		//获取点击数、访问量
		ServletContext application = event.getServletContext();
        int count = (Integer) application.getAttribute("count");
        int sum = (Integer) application.getAttribute("sum");
        
        //进入properties对象中
        ps = new Properties();
        ps.setProperty("count", count+"");
        ps.setProperty("sum", sum+"");
        
        try {
        	 //字节输出流
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
                 //System.out.println("application监听的初始化");
		//利用application对象，读取外部文件加载成一个Properties对象
		ServletContext application = event.getServletContext();
		InputStream is = application.getResourceAsStream("/WEB-INF/count.properties");
		ps = new Properties();
		try {
			ps.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//点击数
		int count = Integer.parseInt(ps.get("count").toString());
		//访问量
		int sum = Integer.parseInt(ps.get("sum").toString());
	    
		application.setAttribute("count", count);
		application.setAttribute("sum", sum);
		//在线人数
		application.setAttribute("online", 0);
	}

}
