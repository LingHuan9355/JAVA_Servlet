<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>admin.jsp</title>
    <script type="text/javascript" src="js/admin.js"></script>
  </head>
  
  <body>
     <div align="center">
           <h2>试卷表</h2>
           <c:forEach items="${plist}" var="pap" >
             <span id="content">${pap.content}</span><br/>
             <div id="p1">
               <c:if test="${pap.id==1}">
		           <input type="radio" id="hd" name="hd" value="顺治帝" onclick="valGet()"/>A.顺治帝
		           <input type="radio" id="hd" name="hd" value="康熙帝" onclick="valGet()"/>B.康熙帝
		           <input type="radio" id="hd" name="hd" value="雍正帝" onclick="valGet()"/>C.雍正帝
		           <input type="radio" id="hd" name="hd" value="乾隆帝" onclick="valGet()"/>D.乾隆帝  
               </c:if>
           </div>
           <div id="p2">
              <c:if test="${pap.id==2}">
		           <input type="radio" name="hd2" value="顺治帝" />A.顺治帝
		           <input type="radio" name="hd2" value="康熙帝" />B.康熙帝
		           <input type="radio" name="hd2" value="雍正帝" />C.雍正帝
		           <input type="radio" name="hd2" value="乾隆帝" />D.乾隆帝  
               </c:if>
            </div>
            <div id="p3">
                <c:if test="${pap.id ==3}">
		           <input type="radio" name="hd3" value="孙中山" />A.孙中山
		           <input type="radio" name="hd3" value="袁世凯" />B.袁世凯
		           <input type="radio" name="hd3" value="王靖云" />C.王靖云
		           <input type="radio" name="hd3" value="黎元洪" />D.黎元洪  
                 </c:if>
	         </div>
	         <div id="p4">
                <c:if test="${pap.id ==4}">
		           <input type="radio" name="hd4" value="载恬" />A.载恬
		           <input type="radio" name="hd4" value="溥仪" />B.溥仪
		           <input type="radio" name="hd4" value="溥杰" />C.溥杰
		           <input type="radio" name="hd4" value="溥俊 " />D.溥俊  
                 </c:if>
	         </div>
           <br/><br/>
           </c:forEach>
                  
           <br/>
           <a href="submitServlet?sum=${sum}" >交卷</a>
       </div> 
  </body>
</html>


