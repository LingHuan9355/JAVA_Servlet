package com.cshr.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 
 *<p>Title:SessionListener </p>
 *Description: 
 *1.ͳ����������������������ͷ��ʵ�������
 *@author LH
 *@date 2017-12-11����03:49:06
 *@version V1.0
 */
public class SessionListener implements HttpSessionListener {

	public SessionListener() {
          super();
	}
	
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		//ÿһ��session����һ����������(��1)
	    ServletContext application = event.getSession().getServletContext();
	    //��ȡ��������
	    int online = (Integer) application.getAttribute("online");
	    //��ȡ������
	    int sum = (Integer) application.getAttribute("sum");
	    
	    online++;
	    sum++;
	    //������������
	    application.setAttribute("online", online);
	    //���÷�����
	    application.setAttribute("sum", sum);
	    
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
          
		//session������ʱ����Ҫ���ߣ���ô��������������1
	    ServletContext application = event.getSession().getServletContext();
		int online = (Integer) application.getAttribute("online");
		
		online--;
		//������������
		application.setAttribute("online", online);
		
	}

}
