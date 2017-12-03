<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    request.setAttribute("name","王通");
    request.setAttribute("age","25");
    
    request.getRequestDispatcher("myServlet2").forward(request,response);
%>

