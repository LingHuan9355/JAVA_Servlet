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
 *2.������Ŀ������ʱ�䣺дһ��ContextLtr��(�̳�ServletContextListener)������ServletContext�Ĵ��������٣�
 *��contextInitialized�����еõ�ϵͳ�ĵ�ǰʱ�䣬Ȼ�����õ�ServletContext�����У������ͼ�¼����Ŀ�����Ŀ�ʼʱ�䣬
 *Ȼ����contextDestroyed������ͬ���ٵõ�ϵͳ�ĵ�ǰʱ�䣬Ȼ��ServletContext���� ���ó���ʼʱ�䣬Ȼ�����ʱ��
 *���ļ��������ʱ��������һ���ļ���.������tomcat,��һ����ʱ��ر�tomcat��
 *@author LH
 *@date 2017-12-11����02:42:23
 *@version V1.0
 */
public class ContextLtr implements ServletContextListener {

	public static final String FILEPATH="D:\\JAVA_WorkSpace2\\171211Servlet4_1\\WebRoot\\WEB-INF\\time.txt";
	
	public ContextLtr() {
         System.out.println("application��������");
	}
	
	long start;
	long end;
	
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("application���١�����");
		end = System.currentTimeMillis();
         System.out.println("ʱ�����" + (end-start));
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
       System.out.println("application��ʼ��");
       start = System.currentTimeMillis();
	}

}
