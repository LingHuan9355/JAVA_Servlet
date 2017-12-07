<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <title>My JSP 'show.jsp' starting page</title>


  </head>

  <body>
        <form action="showServlet" method="post">
	             用户名：<input type="text" name="userName" ><br/>
	             性别：<input type="radio" name="sex" value="男">男
	         <input type="radio" name="sex" value="女">女<br/>
	             爱好：
	        <input type="checkbox" name="hobby" value="编程">编程
	        <input type="checkbox" name="hobby" value="学习">学习
	        <input type="checkbox" name="hobby" value="影音">影音
	        <input type="checkbox" name="hobby" value="跑步">跑步<br/>
                      个人资料：<br/>
                <textarea rows="20" cols="50" name="data">
               </textarea><br/>
            <input type="submit" value="提交">  
        </form>
  </body>
</html>
