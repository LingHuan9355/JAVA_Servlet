<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <title>myJsp.jsp</title>
  </head>
  
  <body>
  <a href="afterClassServlet1?name=卡尔">获取姓名（关于servlet乱码）</a><br/>
  <a href="afterClassServlet2">获取文件内容</a><br/><br/>
  
  <form action="afterClassServlet3" method="get">
       <input type="text" name="first" /><br/>
       <input type="text" name="second" /><br/>
       <input type="text" name="third" /><br/>
       <select name="compare">
           <option value="max">Max</option>
           <option value="min">Min</option>
       </select>
       <input type="submit" value="比较">
  </form>
  <br/><br/>
  <h1>---------连接数据库练习user------------</h1>
   <a href="selectServlet4?uname=常青&&upwd=changq">显示用户</a>
   <br/>
   <h4>删除用户</h4>
   <form action="deleteServlet5" method="post">
                           用户编号：<input type="text" name="userId">
          <input type="submit" value="提交">
   </form>
   <br/>
   <h4>添加用户</h4>
   <form action="insertServlet6" method="post">
                           用户名：<input type="text" name="userName"><br/>
                           用户密码：<input type="password" name="userPassWord"><br/>
          <input type="submit" value="提交">
   </form>
   <br/>
   <h4>修改用户</h4>
   <form action="updateServlet7" method="post">
                           用户编号：<input type="text" name="userId"><br/>
                           用户姓名：<input type="text" name="userName"><br/>
                           用户密码：<input type="password" name="userPassWord"><br/>
          <input type="submit" value="提交">
   </form>
  </body>
</html>
