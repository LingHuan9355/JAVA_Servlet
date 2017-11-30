<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>user.jsp</title>
    
  </head>
  
  <body>
      <form action="myServlet1" method="get">
                                 用户名：<input type="text" name="userName" /><br/>
                                 性    别：
                 <input type="radio" name="sex" value="boy" />男                     
                 <input type="radio" name="sex" value="girl" />女<br/>
                                 地    址：<input type="text" name="address"/> <br/>
                                 爱    好：
                 <input type="checkbox" name="hobby" value="阅读"/>阅读                                               
                 <input type="checkbox" name="hobby" value="跑步"/>跑步                                               
                 <input type="checkbox" name="hobby" value="游泳"/>游泳<br/>
            <input type="submit" value="提交">                                                    
      </form>
  </body>
</html>
