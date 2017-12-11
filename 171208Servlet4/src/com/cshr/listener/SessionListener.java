package com.cshr.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

	public SessionListener() {
		super();
         // System.out.println("session的监听创建。。。");	

	}
	
	@Override
	public void sessionCreated(HttpSessionEvent event) {
             // System.out.println("session监听的初始化。。。");
		//每一个session就是一个在线人数(加1)
		ServletContext application = event.getSession().getServletContext();
        int online = (Integer) application.getAttribute("online");
      //总访问量
	    int sum = (Integer) application.getAttribute("sum");
	    online++;
	    sum++;
	    //存储
	    application.setAttribute("online", online);
	    application.setAttribute("sum", sum);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
             //  System.out.println("session监听的销毁。。。");
		//session当销毁时，就要下线，那么就是在线人数减1
		ServletContext application = event.getSession().getServletContext();
		int online = (Integer) application.getAttribute("online");
		online--;
		application.setAttribute("online", online);
	}

}
