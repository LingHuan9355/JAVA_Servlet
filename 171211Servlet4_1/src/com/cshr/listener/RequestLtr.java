package com.cshr.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * 
 *<p>Title:RequestLtr </p>
 *Description: 
 *1.计算一次请求的运行时间： 写一个RequestLtr类(继承ServletRequestListener),监听Request对象的创建和销毁,
 *在requestInitialized方法中得到系统的当前时间，然后设置到ServletRequest对象中，这样就记录了请求的开始时间，
 *然后在requestDestroyed方法中同样再得到系统的当前时间，然后ServletRequest对象中拿出开始时间，然后算出时间差，
 *打印出来到后台
 *@author LH
 *@date 2017-12-11下午01:50:33
 *@version V1.0
 */
public class RequestLtr implements ServletRequestListener {

	public RequestLtr() {
            System.out.println("request监听创建");
	}
	
	long start;
	long end;
	public void requestDestroyed(ServletRequestEvent sre) {
          System.out.println("request监听销毁");
		end = System.currentTimeMillis();
		System.out.println("request对象创建到销毁的时间："+(end-start));
	}

	public void requestInitialized(ServletRequestEvent sre) {
           System.out.println("request监听初始化");
	       start  = System.currentTimeMillis();
	         
	}

}
