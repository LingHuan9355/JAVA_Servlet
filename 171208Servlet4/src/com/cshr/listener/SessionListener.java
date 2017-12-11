package com.cshr.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

	public SessionListener() {
		super();
         // System.out.println("session�ļ�������������");	

	}
	
	@Override
	public void sessionCreated(HttpSessionEvent event) {
             // System.out.println("session�����ĳ�ʼ��������");
		//ÿһ��session����һ����������(��1)
		ServletContext application = event.getSession().getServletContext();
        int online = (Integer) application.getAttribute("online");
      //�ܷ�����
	    int sum = (Integer) application.getAttribute("sum");
	    online++;
	    sum++;
	    //�洢
	    application.setAttribute("online", online);
	    application.setAttribute("sum", sum);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
             //  System.out.println("session���������١�����");
		//session������ʱ����Ҫ���ߣ���ô��������������1
		ServletContext application = event.getSession().getServletContext();
		int online = (Integer) application.getAttribute("online");
		online--;
		application.setAttribute("online", online);
	}

}
