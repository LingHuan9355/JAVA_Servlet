<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'conste.jsp' starting page</title>
    
	<script type="text/javascript" src="js/conste.js"></script>

  </head>
  
  <body>
      <h3>十二星座</h3>
     <c:forEach items="${clist}" var="con" >
    	 <input type="radio" id="conste" value="${con.name}" onchange="getRadio()" >${con.name}
     </c:forEach><br/>
     <textarea rows="10" cols="100" id="content">
     </textarea>

  </body>
</html>
