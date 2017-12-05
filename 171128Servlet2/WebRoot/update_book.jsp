<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>修改书籍信息</title>
    
	

  </head>
  
  <body>
           <h3 align="center">书籍详情</h3>
      <!--<form action="updateServlet?bid=${bid}" method="post"> -->
    <form action="updateServlet" method="post">
           <table border="1" bordercolor="black" cellspacing="0" align="center" width="200" >
	            <c:forEach items="${blist}" var="list">
	            <tr>
	              <td align="center">编号</td>
	              <td><input type="text" name="bookId" value="${list.bookId}" readonly="readonly"/></td>
	            </tr>
	            <tr>
	              <td align="center">书名</td>
	              <td><input type="text" name="bookName" value="${list.bookName}" /></td>
	            </tr>
	            <tr>
	              <td align="center">价格</td>
	              <td><input type="text" name="bookPrice" value="${list.bookPrice}" /></td>
	            </tr>
	            <tr>
	              <td align="center">作者</td>
	              <td><input type="text" name="bookWrite" value="${list.bookWrite}" /></td>
	            </tr>
	            </c:forEach>
	            <tr>
	              <td colspan="2" align="center">
		              <input type="submit" value="修改"/>
		              <input type="reset"  value="取消"/>
	              </td>
	            </tr>
	
	      </table>
      </form>
  </body>
</html>
