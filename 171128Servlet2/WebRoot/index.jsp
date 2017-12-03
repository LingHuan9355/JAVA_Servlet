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
        <a href="myServlet4">关于servletcontext和serlvetconfig之间的区别</a><br/>
        <a href="myServlet5">Servlet中获取web-inf下的文件</a>
        <h1>----------练习一-------------</h1>
        <br/><br/>
        <form action="myServlet1_lx" method="post">
                                   用户名：<input type="text" name="userName" /><br/>
                                   密码：<input type="password" name="passWord" /><br/>
             <input type="submit" value="提交"> 
        </form>
        <br/>
        <a href="test2.jsp">获取request中的保存的属性值</a><br/>
        <a href="test3.jsp">获取三种内置对象的属性值</a><br/>
        <a href="myServlet4_lx">关于servletcontext和serlvetconfig之间的区别</a>
        <br/><br/>
        <h1>============练习二===============</h1>
        <form action="afterClassServlet1" method="post">
           	用户名:<input  name = "uname"/><br/>
           	爱    好:
           	<input type="checkbox" name="hobby" value="篮球">篮球
           	<input type="checkbox" name="hobby" value="足球">足球
           	<input type="checkbox" name="hobby" value="排球">排球<br/>
           	<input type="submit" value="提交"/>
        </form><br/>
        
        <a href="afterClassServlet2">获取主机地址的信息</a>
        <br/>
        
        <form action="afterClassServlet3" method="post">
                               用户名:<input  name = "uname"/><br/>
                              水果:
           	<input type="radio" name="fruit" value="苹果">苹果
           	<input type="radio" name="fruit" value="梨子">梨子
           	<input type="radio" name="fruit" value="香蕉">香蕉<br/>
           	<input type="submit" value="提交"/>
        </form>
  </body>
</html>
