<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	${formBean.errors.message }
    <form action="${pageContext.request.contextPath}/servlet/CenterController?operation=login" method="post">
    	*用户名：<input type="text" name="username" value="${formBean.username }"/>${formBean.errors.username }<br/>
    	*密码：<input type="text" name="password" value=""/>${formBean.errors.password }<br/>
    	<input type="submit" value="登录"/>
    </form>
  </body>
</html>
