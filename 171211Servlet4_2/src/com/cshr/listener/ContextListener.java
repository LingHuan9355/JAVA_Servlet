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
 *1.统计在线人数，请求次数，和访问的总人数
 *@author LH
 *@date 2017-12-11下午03:49:10
 *@version V1.0
 */
public class ContextListener implements ServletContextListener {

	public ContextListener() {
             super();
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {

		ServletContext application =event.getServletContext();
		//获取点击数、访问量
		int count = (Integer) application.getAttribute("count");
		int sum = (Integer)application.getAttribute("sum");
		
		//创建一个Properties实例
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
             
		//利用application对象，读取外部文件加载成一个Properties对象
		ServletContext application = event.getServletContext();
		
		InputStream is = application.getResourceAsStream("/WEB-INF/num.properties");
	   ps = new Properties();
		try {
			ps.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//获取点击率
		int count = Integer.parseInt(ps.get("count").toString());
		//获取访问量
		int sum = Integer.parseInt(ps.get("sum").toString());
		
		//设置点击率
		application.setAttribute("count", count);
		//设置访问量
		application.setAttribute("sum", sum);
		//设置在线人数
		application.setAttribute("online", 0);
	}

}
