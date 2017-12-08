<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    <title>My JSP 'login.jsp' starting page</title>
    
	

  </head>
  
  <body>
      <form action="loginServlet" method="post">
         <table border="1" bordercolor="black" cellspacing="0" align="center">
            <tr>
               <th>用户名</th>
               <td><input type="text" name="userName"/></td>
            </tr>
            <tr>
               <th>密码</th>
               <td><input type="text" name="passWord"/></td>
            </tr>
            <tr>
               <td colspan="2" align="center">
                 <input type="submit" value="登录">
               </td>
            </tr>
         </table>
      </form>
  </body>
</html>
