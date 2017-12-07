<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 
    <title>My JSP 'person.jsp' starting page</title>

  </head>
  
  <body>
      <form action="humanServlet" method="post">
  		姓名:<input type="text" name="name"/><br/>
  		地址:<input type="text" name="address"/><br/>
  		工作单位:<input name="job"/><br/>
  		<input type="submit" value="提交"/>
  	</form>
  
  </body>
</html>
