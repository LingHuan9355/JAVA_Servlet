package com.cshr.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 
 *<p>Title:SessionListener </p>
 *Description: 
 *1.统计在线人数，请求次数，和访问的总人数
 *@author LH
 *@date 2017-12-11下午03:49:06
 *@version V1.0
 */
public class SessionListener implements HttpSessionListener {

	public SessionListener() {
          super();
	}
	
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		//每一个session就是一个在线人数(加1)
	    ServletContext application = event.getSession().getServletContext();
	    //获取在线人数
	    int online = (Integer) application.getAttribute("online");
	    //获取访问量
	    int sum = (Integer) application.getAttribute("sum");
	    
	    online++;
	    sum++;
	    //设置在线人数
	    application.setAttribute("online", online);
	    //设置访问量
	    application.setAttribute("sum", sum);
	    
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
          
		//session当销毁时，就要下线，那么就是在线人数减1
	    ServletContext application = event.getSession().getServletContext();
		int online = (Integer) application.getAttribute("online");
		
		online--;
		//设置在线人数
		application.setAttribute("online", online);
		
	}

}
