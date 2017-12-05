<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加书籍</title>
    

  </head>
  
  <body>
     <h3 align="center">添加书籍</h3>
     <form action="addServlet" method="post">
         <table border="1" bordercolor="black" cellspacing="0" align="center" width="200">
            <tr>
               <td align="center">书名</td>
               <td><input type="text" name="bookName" /></td>
            </tr>
            <tr>
               <td align="center">价格</td>
               <td><input type="text" name="bookPrice" /></td>
            </tr>
            <tr>
               <td align="center">作者</td>
               <td><input type="text" name="bookWrite" /></td>
            </tr>
            <tr>
               <td colspan="2" align="center">
                 <input type="submit" value="添加"/>
               </td>
            </tr>
         </table>
     </form>
  </body>
</html>
