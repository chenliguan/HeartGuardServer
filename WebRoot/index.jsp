<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>上海传智论坛</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<c:if test="${sessionScope.user==null}">
  		<a href="${pageContext.request.contextPath}/login.jsp">登录</a>&nbsp;&nbsp;
  		<a href="${pageContext.request.contextPath}/regist.jsp">还木有账号</a>
  	</c:if>
  	<c:if test="${sessionScope.user!=null}">
  		欢迎您：${sessionScope.user.nick==""?sessionScope.user.username:sessionScope.user.nick}&nbsp;&nbsp;
  		<a href="${pageContext.request.contextPath}/servlet/CenterController?operation=logout">注销</a>
  	</c:if>
   	<hr/>
    <h1>欢迎光临上海传智论坛</h1>
  </body>
</html>
