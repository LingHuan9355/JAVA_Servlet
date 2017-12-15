<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <title>My JSP 'city.jsp' starting page</title>
    

    <script type="text/javascript" src="js/city.js"></script>
  </head>
  
  <body>
        <select id="province" onchange="getCity()">
           <option value="0">--省份--</option>
           <c:forEach items="${plist}" var="pro">
                <option value="${pro.pid}">${pro.pname}</option>
           </c:forEach>
        </select>
        
        <select id="city">
           <option value="0">--城市--</option>
        </select>
  </body>
</html>
