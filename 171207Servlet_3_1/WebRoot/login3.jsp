<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录页面</title>

  </head>
  
  <body>
  
     <form action="loginServlet" method="post">
          用户名：   <input type="text" name="userName"/><br/>
          密    码：   <input type="text" name="passWord"/><br/>
          <input type="submit" value="提交"/>
     </form>
  </body>
</html>
