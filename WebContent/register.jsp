<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册页面</title>
</head>
<link href="css/style.css" rel='stylesheet' type='text/css' media="all" />
<body background= "./img/002.png">
<div class="log">
<div class="content3">
用户注册
<form action="registerServlet" method="post">
注册用户名：<input name=username type="text" /><br/>
注册密码：<input name=password type="text" /><br/>
<a href="login.jsp" class="submit1"> 返回</a>
<input type="submit" class="submit" value="提交"/> 
</form>
</div>
</div>
</body>

</html>