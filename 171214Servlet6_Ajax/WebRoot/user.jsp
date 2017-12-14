<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%  %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <title>添加用户</title>
   <script type="text/javascript" src="js/user.js"></script>
  </head>
  
  <body>
        <form action="" method="post">
                                 用户名：<input type="text"  id="userName" onblur="valPost()"/>
            <span id="msg"></span><br/>
                                 密     码：<input type="text" name="pwd"/><br/>
            <input type="submit" value="提交"/>
        </form>
  </body>
</html>
