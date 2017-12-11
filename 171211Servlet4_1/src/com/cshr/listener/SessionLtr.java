package com.cshr.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 
 *<p>Title:SessionLtr </p>
 *Description: 
 *3.����һ���û���¼��ʱ�䣺дһ��SessionLtr��(�̳�HttpSessionListener)������session���������٣�
 *��sessionCreated�����еõ�ϵͳ�ĵ�ǰʱ�䣬Ȼ�����õ�HttpSession�����У������ͼ�¼�˵�¼�Ŀ�ʼʱ�䣬
 *Ȼ����sessionDestroyed������ͬ���ٵõ�ϵͳ�ĵ�ǰʱ�䣬Ȼ���HttpSession�������ó���ʼʱ�䣬
 *Ȼ�����ʱ����ӡ��������̨ ����index.jsp����ʼ����Session����index.jsp���и�������"�˳�",
 *�����ӵ�out.jsp�У�����session(session.invalidate())
 *@author LH
 *@date 2017-12-11����03:17:32
 *@version V1.0
 */
public class SessionLtr implements HttpSessionListener {

	public SessionLtr() {
          System.out.println("session��������");
	}
	
	long start;
	long end;
	
	public void sessionCreated(HttpSessionEvent event) {
          System.out.println("session������ʼ��");
		start = System.currentTimeMillis();
		event.getSession().setAttribute("start", start); 
	}

	public void sessionDestroyed(HttpSessionEvent event) {
          System.out.println("session��������");
          start = (Long) event.getSession().getAttribute("start");
          end = System.currentTimeMillis();
          System.out.println("session�Ựʱ�����" +(end-start));
	}

}
