<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'out.jsp' starting page</title>

  </head>
  
  <body>
     <h1>当前用户已退出</h1>
    <%
      session.invalidate();
   %>
  </body>
</html>
