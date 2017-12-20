<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>成绩单</title>
    
  </head>
  
  <body>
       <div align="center">
          <table border="1" bordercolor="black" cellspacing="0">
              <tr>
                  <th>用户名</th>
                  <th>成绩总分</th>
              </tr>
              <tr align="center">
                  <td>${userName}</td>
                  <td>${sum}</td>
              </tr>
          </table>
       </div>
  
  
  </body>
</html>
