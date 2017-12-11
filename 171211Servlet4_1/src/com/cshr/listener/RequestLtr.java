package com.cshr.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * 
 *<p>Title:RequestLtr </p>
 *Description: 
 *1.����һ�����������ʱ�䣺 дһ��RequestLtr��(�̳�ServletRequestListener),����Request����Ĵ���������,
 *��requestInitialized�����еõ�ϵͳ�ĵ�ǰʱ�䣬Ȼ�����õ�ServletRequest�����У������ͼ�¼������Ŀ�ʼʱ�䣬
 *Ȼ����requestDestroyed������ͬ���ٵõ�ϵͳ�ĵ�ǰʱ�䣬Ȼ��ServletRequest�������ó���ʼʱ�䣬Ȼ�����ʱ��
 *��ӡ��������̨
 *@author LH
 *@date 2017-12-11����01:50:33
 *@version V1.0
 */
public class RequestLtr implements ServletRequestListener {

	public RequestLtr() {
            System.out.println("request��������");
	}
	
	long start;
	long end;
	public void requestDestroyed(ServletRequestEvent sre) {
          System.out.println("request��������");
		end = System.currentTimeMillis();
		System.out.println("request���󴴽������ٵ�ʱ�䣺"+(end-start));
	}

	public void requestInitialized(ServletRequestEvent sre) {
           System.out.println("request������ʼ��");
	       start  = System.currentTimeMillis();
	         
	}

}
