<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'show_book.jsp' starting page</title>

  </head>
  
  <body>
          <h3 align="center">书籍信息</h3>
          <h4 align="center"><a href="index_book.jsp" >返回首页</a></h4>
          <table border="1" bordercolor="black" cellspacing="0" align="center" width="800" >
            <tr>
              <th>编号</th>
              <th>书名</th>
              <th>价格</th>
              <th>作者</th>
              <th>操作</th>
            </tr>
            
            <c:forEach items="${blist}" var="list" >
            <tr>
            <!-- 
              <td><c:out value="${list.bookId}"></c:out></td>
              <td><c:out value="${list.bookName}"></c:out></td>
              <td><c:out value="${list.bookPrice}"></c:out></td>
              <td><c:out value="${list.bookWrite}"></c:out></td>
              -->
              <td align="center">${list.bookId} </td>
              <td>${list.bookName} </td>
              <td align="center">￥ ${list.bookPrice} </td>
              <td>${list.bookWrite} </td>
              <td colspan="2" align="center">
                 <a href="searchServlet?bookid=${list.bookId}" >修改</a>
                 <!--<a href="deleteServlet?bookid=${list.bookId}" >删除</a>-->
                 <a href="javascript:Delete(${list.bookId},'${list.bookName}');" >删除</a>
              </td>
            </tr>
            </c:forEach>
              
          </table>
  <script type="text/javascript">
      function Delete(obj,bookName){
		if (confirm("确定删除'" + bookName+ "'吗 ？ ")) {
		
			location.href="deleteServlet?bookid="+obj;
		}
	}
    
  </script>
  </body>
</html>
