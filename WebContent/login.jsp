<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="keywords" content="" />
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>登录页面</title>
</head>
<link href="css/style.css" rel='stylesheet' type='text/css' media="all" />
<body>
<div class="log">
<div class="content1">

用户登录
	<form action="loginServlet"  method="post" >
	用户名：<input name="username" type="text" /><br/>
    密&nbsp;码：<input name="password" type="password" /><br/>
	<input type="submit" class="submit" value="提交">
	<a href="register.jsp" class="submit1">注册</a> 	
	</form>
</div>
</body>

</html>



