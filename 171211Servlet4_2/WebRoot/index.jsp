<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <title>My JSP 'index.jsp' starting page</title>

  </head>
  <body>
                点击数：<%=application.getAttribute("count") %><br/>
                在线数：<%=application.getAttribute("online") %><br/>
               访问 数：<%=application.getAttribute("sum") %><br/>
     <a href="out.jsp">退出</a>
  </body>
</html>
