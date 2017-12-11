package com.cshr.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class RequestListener implements ServletRequestListener {

	public RequestListener() {
		super();
          // System.out.println("request的监听创建。。。");
	}
	
	//long start ;
	//long end;
	@Override
	public void requestDestroyed(ServletRequestEvent event) {
               // System.out.println("监听销毁。。。");
             //   end = System.currentTimeMillis();
             //   System.out.println("time=" + (end-start));
	}

	@Override
	public void requestInitialized(ServletRequestEvent event) {
      //   start = System.currentTimeMillis();       
		//System.out.println("监听初始化。。。");
         
       //客户端每发一次请求，则对点击数进行加1
        ServletContext application = event.getServletContext();
        int count = (Integer) application.getAttribute("count");
        count++;
        application.setAttribute("count", count);
	}

}
