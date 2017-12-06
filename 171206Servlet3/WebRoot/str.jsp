<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>My JSP 'str.jsp' starting page</title>
  
  </head>
  
  <body>
        <form action="strServlet" method="post">
		           姓名：<input  name="uname"/><br/>
		           国家：<input  name="country"><br/>
		           职位：<input  name="job"><br/>
		        <input type="submit" value="提交"/>
        </form>
  </body>
</html>
