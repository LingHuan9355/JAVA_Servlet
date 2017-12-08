<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'dync.jsp' starting page</title>


  </head>
  
  <body>
           
           <form action="dyncServlet" method="post">
                                    请输入您的动态密码:<br/>
              <input type="text" name="dynamicPwd"  value="请输入内容" onfocus="javascript:if(this.value=='请输入内容')this.value='';">
              <input type="submit" value="提交" >
           </form>
  </body>
</html>
