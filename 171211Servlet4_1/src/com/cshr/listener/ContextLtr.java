package com.cshr.listener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 
 *<p>Title:ContextLtr </p>
 *Description: 
 *2.计算项目的运行时间：写一个ContextLtr类(继承ServletContextListener)，监听ServletContext的创建和销毁，
 *在contextInitialized方法中得到系统的当前时间，然后设置到ServletContext对象中，这样就记录了项目开启的开始时间，
 *然后在contextDestroyed方法中同样再得到系统的当前时间，然后ServletContext对象 中拿出开始时间，然后算出时间差，
 *用文件输出流将时间差输出到一个文件里.（开启tomcat,过一定的时间关闭tomcat）
 *@author LH
 *@date 2017-12-11下午02:42:23
 *@version V1.0
 */
public class ContextLtr implements ServletContextListener {

	public static final String FILEPATH="D:\\JAVA_WorkSpace2\\171211Servlet4_1\\WebRoot\\WEB-INF\\time.txt";
	
	public ContextLtr() {
         System.out.println("application监听创建");
	}
	
	long start;
	long end;
	
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("application销毁。。。");
		end = System.currentTimeMillis();
         System.out.println("时间戳：" + (end-start));
         String time = (end-start)+"";
         File file;
         FileOutputStream fos = null;
	      try {
	    	  file = new File(FILEPATH);
			  fos = new FileOutputStream(file);
			  
			  if(!file.exists()){
				file.createNewFile();  
			  }
			  byte [] num = time.getBytes();
			  fos.write(num);
			  fos.flush();
			  
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(fos !=null){
				   fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void contextInitialized(ServletContextEvent sce) {
       System.out.println("application初始化");
       start = System.currentTimeMillis();
	}

}
