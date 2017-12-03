<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
     request.setAttribute("uname","tomcat");
     request.setAttribute("pwd","admin123");
     
     String [] values = {"编码","学习","看视频 "};
     request.setAttribute("hobby",values);

     request.getRequestDispatcher("myServlet2_lx").forward(request,response);
%>

 