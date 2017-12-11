<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  
  <body>
  
      <!-- 监听器:Listener 秘书 -->
   	<%
   		//request.getRequestDispatcher("test.jsp").forward(request,response);
   		//response.sendRedirect("test.jsp");
   	%>           
             
           <!-- servlet filter listener -->
          <a href="myServlet">测试生命周期(requestListener)</a><br/>
          <a href="test.jsp">测试session的监听器(销毁)</a><br/>
          
          <table border="1" bordercolor="blue" cellspacing="0" align="center">
            <tr>
               <th>点击数</th>
               <th>在线人数</th>
               <th>访问量</th>
            </tr>
            <tr>
               <td><%=application.getAttribute("count") %></td>
               <td><%=application.getAttribute("online") %></td>
               <td><%=application.getAttribute("sum") %></td>
            </tr>
          </table>
  </body>
</html>
