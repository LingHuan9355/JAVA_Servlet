<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
      request.setAttribute("rname","tom");
      session.setAttribute("sname","cat");
      application.setAttribute("aname","java");
      
      request.getRequestDispatcher("myServlet3_lx").forward(request,response);
%>


