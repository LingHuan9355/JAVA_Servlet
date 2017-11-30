<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <title>myJsp.jsp</title>
  </head>
  
  <body>
  <a href="afterClassServlet1?name=卡尔">获取姓名（关于servlet乱码）</a><br/>
  <a href="afterClassServlet2">获取文件内容</a><br/><br/>
  
  <form action="afterClassServlet3" method="get">
       <input type="text" name="first" /><br/>
       <input type="text" name="second" /><br/>
       <input type="text" name="third" /><br/>
       <select name="compare">
           <option value="max">Max</option>
           <option value="min">Min</option>
       </select>
       <input type="submit" value="比较">
  </form>
  </body>
</html>
