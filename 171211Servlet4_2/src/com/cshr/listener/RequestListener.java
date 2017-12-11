package com.cshr.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * 
 *<p>Title:RequestListener </p>
 *Description: 
 *1.ͳ����������������������ͷ��ʵ�������
 *@author LH
 *@date 2017-12-11����03:49:01
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
		
		//�ͻ���ÿ��һ��������Ե�������м�1
		ServletContext application = event.getServletContext();
		int  count = (Integer) application.getAttribute("count");
		count++;
		application.setAttribute("count", count);
	}

}
