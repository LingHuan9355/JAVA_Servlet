<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    <title>Servlet1</title>
	
  </head>
  
  <body>
  <div>
   <a href="myServlet1">访问第一个Servlet(基本配置)</a><br/>
   <a href="myServlet2">访问第二个Servlet(生命周期)</a><br/>
   <a href="myServlet3?name=李四">访问第三个Servlet（关于servlet乱码）</a>
   <form action="myServlet3" method="post">
                   姓名：<input name="name"><br/>
       <input type="submit" value="提交">
   </form>
   <br/>
   <a href="myServlet4">访问第四个Servlet（继承GenricServlet）</a><br/>
   <a href="myServlet5">访问第五个Servlet（继承HttpServlet）</a><br/>
   <form action="myServlet5" method="post">
                   姓名：<input name="name"><br/>
       <input type="submit" value="提交">
   </form>
   </div>
   <h1>--------我是分割线---------</h1>
   <div>
    <a href="myServlet1_lx">第一个Servlet（歌词）</a><br/>
    <a href="myServlet2_lx">第二个Servlet(生命周期)</a><br/>
    <a href="myServlet3_lx">第三个Servlet(统计次数)</a><br/>
    <form action="myServlet4_lx" method="post">
       <table>
         <tr>
           <td>用户编号：</td>
           <td><input type="text" name="id" /></td>
         </tr>
         <tr>
           <td>用户名：</td>
           <td><input type="text" name="userName" /></td>
         </tr>
         <tr>
           <td>爱好：</td>
           <td>
             <input type="checkbox" name="hobby" value="跑步">跑步
             <input type="checkbox" name="hobby" value="游泳">游泳
             <input type="checkbox" name="hobby" value="爬山">爬山
           </td>
         </tr>
         <tr>
           <td colspan="2" align="center">
             <input type="submit" value="提交">
             <input type="reset" value="重置"/>
           </td>
         </tr>
       </table>    
    </form>
    
    <br/><br/>
        <form action="myServlet5_lx" method="post">
   
                          用户名： <input type="text" name="userName" />
                          密    码： <input type="password" name="passWord" />
               <input type="submit" value="提交">
               <input type="reset" value="重置"/>
        </form>
    <br/><br/>
    <form action="myServlet6_lx" method="get">
         <table border="1" bordercolor="blue" cellspacing="0">
         <tr>
            <td>第一个数字：</td>
            <td><input type="text" name="first" value="0"/></td>
         </tr>
         <tr>
            <td>运算符：</td>
            <td>
             <select name="operator">
                <option >请选择</option>
                <option value="+">+</option>
                <option value="-">-</option>
                <option value="*">*</option>
                <option value="/">/</option>
             </select>
            </td>
         </tr>
         <tr>
            <td>第一个数字：</td>
            <td><input type="text" name="second" value="0"/></td>
         </tr>
         <tr>
            <td colspan="2" align="center">
               <input type="submit" value="提交">
               <input type="reset" value="重置"/>
            </td>
         </tr>
                          
         </table>      
    </form>
    
   </div>
  </body>
</html>
