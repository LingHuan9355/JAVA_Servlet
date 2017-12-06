<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    <title>My JSP 'login.jsp' starting page</title>
    
	

  </head>
  
  <body>
       <form action="loginServlet" method="post">
                       用户名：<input type="text" name="userName"><br/>
                      密码：<input type="password" name="passWord"/><br/>
           <input type="submit" value="提交">               
       </form>
  </body>
</html>
