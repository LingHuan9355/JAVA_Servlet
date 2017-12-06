<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'test.jsp' starting page</title>

  </head>
  
  <body>
      <!-- <jsp:forward page="test2.jsp"></jsp:forward>  -->
      <!-- <jsp:include page="test2.jsp"></jsp:include>  -->
      <%--  <%@ include file="test2.jsp" %>  --%> 
    
      <%
         //请求转发
         request.getRequestDispatcher("test2.jsp").forward(request,response);
          //out.println(10/0);
      %>
       
  </body>
</html>
