<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>index.jsp</title>

  </head>
  
  <body>
        <a href="user.jsp">在Servlet中统一的解决get方式的乱码问题</a><br/>
        <a href="test.jsp">在Servlet中获取request中的保存的属性值</a><br/>
        <a href="myServlet3">在servlet中获取获取session和application对象(jsp9大内置对象与servlet关联)</a><br/>
        <a href="myServlet4">关于servletcontext和serlvetconfig之间的区别</a><br5/>
        <a href="myServlet5">Servlet中获取web-inf下的文件</a>
  </body>
</html>
