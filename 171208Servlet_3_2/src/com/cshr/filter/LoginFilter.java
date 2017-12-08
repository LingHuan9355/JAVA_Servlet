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
 *(2)写一个过滤器LoginFilter只针对loginServlet的请求，进行过滤,在登录请求重回LoginFilter之后，也就是下面的
 *要写的代码必须在doFilter()之后,产生一个六位的整数(提示:Math.random()),将这个整数写到硬盘的一个dync.txt中保存起来，
 *另外将这个整数设置到session中，关闭响应的输出流。
 *	//文件写入，要用到输出流FileOutputStream
 * 步骤：
 *     1.找到目标文件
 *     2.建立通道
 *     3.写入数据
 *     4.关闭资源
 *@author LH
 *@date 2017-12-8上午11:09:12
 *@version V1.0
 */
public class LoginFilter implements Filter{
      
    //// 向文件dync.txt，写入内容
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
		//产生一个六位的整数
		int number = (int)((Math.random()*9+1)*100000);
		System.out.println(number);
		String snumber = number+"";
		File file = new File(filePath);
		 
		FileOutputStream fos =null;
		try {
			// 创建输出流
			fos = new FileOutputStream(file);
			// 把String类型的字符串转化为byte数组的数据保存在输出流中(此处为int类型)
			fos.write(snumber.getBytes());
			
			//整数设置到session中
			session.setAttribute("number", snumber);
			
		} catch (Exception e) {
			 System.out.println("写入异常");
            throw new RuntimeException(e);
		}finally{
			
			if(fos != null ){
				// 关闭输出流
				fos.close();
			}
		}
	

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

}
