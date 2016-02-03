<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 编写文件上传表单
	1、提供文件上传输入项 <input type="file" />
	2、input file 必须提供name 属性（没有name 属性表单项，不会提交）
	3、表单method属性 必须post（GET提交方式，提交数据有长度限制，上传文件可能会很大）
	4、form的enctype属性 必须设置 multipart/form-data
 -->
 <form action="/HeartGuardServer/servlet/UploadServlet" method="post" enctype="multipart/form-data">
 	用户名 <input type="text" name="username"/><br/>
 	上传文件 <input type="file" name="uploadfile"/><br/>
 	<input type="submit" name="submit" value="提交"/>
 </form>
</body>
</html>