package com.cshr.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class RequestListener implements ServletRequestListener {

	public RequestListener() {
		super();
          // System.out.println("request�ļ�������������");
	}
	
	//long start ;
	//long end;
	@Override
	public void requestDestroyed(ServletRequestEvent event) {
               // System.out.println("�������١�����");
             //   end = System.currentTimeMillis();
             //   System.out.println("time=" + (end-start));
	}

	@Override
	public void requestInitialized(ServletRequestEvent event) {
      //   start = System.currentTimeMillis();       
		//System.out.println("������ʼ��������");
         
       //�ͻ���ÿ��һ��������Ե�������м�1
        ServletContext application = event.getServletContext();
        int count = (Integer) application.getAttribute("count");
        count++;
        application.setAttribute("count", count);
	}

}
