package com.cshr.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 
 *<p>Title:SessionLtr </p>
 *Description: 
 *3.计算一个用户登录的时间：写一个SessionLtr类(继承HttpSessionListener)，监听session创建和销毁，
 *在sessionCreated方法中得到系统的当前时间，然后设置到HttpSession对象中，这样就记录了登录的开始时间，
 *然后在sessionDestroyed方法中同样再得到系统的当前时间，然后从HttpSession对象中拿出开始时间，
 *然后算出时间差，打印出来到后台 访问index.jsp，开始创建Session，在index.jsp中有个超链接"退出",
 *超链接到out.jsp中，销毁session(session.invalidate())
 *@author LH
 *@date 2017-12-11下午03:17:32
 *@version V1.0
 */
public class SessionLtr implements HttpSessionListener {

	public SessionLtr() {
          System.out.println("session监听创建");
	}
	
	long start;
	long end;
	
	public void sessionCreated(HttpSessionEvent event) {
          System.out.println("session监听初始化");
		start = System.currentTimeMillis();
		event.getSession().setAttribute("start", start); 
	}

	public void sessionDestroyed(HttpSessionEvent event) {
          System.out.println("session监听销毁");
          start = (Long) event.getSession().getAttribute("start");
          end = System.currentTimeMillis();
          System.out.println("session会话时间戳：" +(end-start));
	}

}
