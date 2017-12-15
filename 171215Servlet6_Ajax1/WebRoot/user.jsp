<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

      <script type="text/javascript" src="js/user.js"></script>
  </head>
  
  <body>
    
    <form action="" method="get" >
                     用户名：<input type="text" id="userName" onblur="valGet()"/>
                     <span id="msg"></span><br/>
                     密码：<input type="password" name="pwd"/><br/>
            <input type="submit" value="提交"/>
                    
    </form>
  </body>
</html>
