package com.cshr.filter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 *<p>Title:LoginFilter </p>
 *Description: 
 *(2)дһ��������LoginFilterֻ���loginServlet�����󣬽��й���,�ڵ�¼�����ػ�LoginFilter֮��Ҳ���������
 *Ҫд�Ĵ��������doFilter()֮��,����һ����λ������(��ʾ:Math.random()),���������д��Ӳ�̵�һ��dync.txt�б���������
 *���⽫����������õ�session�У��ر���Ӧ���������
 *	//�ļ�д�룬Ҫ�õ������FileOutputStream
 * ���裺
 *     1.�ҵ�Ŀ���ļ�
 *     2.����ͨ��
 *     3.д������
 *     4.�ر���Դ
 *@author LH
 *@date 2017-12-8����11:09:12
 *@version V1.0
 */
public class LoginFilter implements Filter{
      
    //// ���ļ�dync.txt��д������
	String filePath = "D:\\JAVA_WorkSpace2\\171208Servlet_3_2\\WebRoot\\WEB-INF\\dync.txt";
	
	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException,  ServletException {
         HttpServletRequest req = (HttpServletRequest) request;
         HttpServletResponse res = (HttpServletResponse) response;
         HttpSession session = req.getSession();
         
     	chain.doFilter(req, res);
		//����һ����λ������
		int number = (int)((Math.random()*9+1)*100000);
		System.out.println(number);
		String snumber = number+"";
		File file = new File(filePath);
		 
		FileOutputStream fos =null;
		try {
			// ���������
			fos = new FileOutputStream(file);
			// ��String���͵��ַ���ת��Ϊbyte��������ݱ������������(�˴�Ϊint����)
			fos.write(snumber.getBytes());
			
			//�������õ�session��
			session.setAttribute("number", snumber);
			
		} catch (Exception e) {
			 System.out.println("д���쳣");
            throw new RuntimeException(e);
		}finally{
			
			if(fos != null ){
				// �ر������
				fos.close();
			}
		}
	

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

}
