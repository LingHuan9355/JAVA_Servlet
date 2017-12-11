package com.cshr.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * 
 *<p>Title:RequestListener </p>
 *Description: 
 *1.统计在线人数，请求次数，和访问的总人数
 *@author LH
 *@date 2017-12-11下午03:49:01
 *@version V1.0
 */
public class RequestListener implements ServletRequestListener {

	public RequestListener() {
              super();
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		// TODO Auto-generated method stub

	}

	@Override
	public void requestInitialized(ServletRequestEvent event) {
		
		//客户端每发一次请求，则对点击数进行加1
		ServletContext application = event.getServletContext();
		int  count = (Integer) application.getAttribute("count");
		count++;
		application.setAttribute("count", count);
	}

}
