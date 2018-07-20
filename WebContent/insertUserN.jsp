<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新增用户信息</title>
</head>
<link href="css/style1.css" rel='stylesheet' type='text/css' media="all" />

<body>
<div class="insert1">
<form action="user_nServlet" method="get">
<input name="switch" type="text" value="3"style="position:absolute;
right:-3000px;">
	

		    编号id：&nbsp;&nbsp;&nbsp;<input name="id" type="text" /><br/>
		    新增用户编码：<input name="uid" type="text"  /><br/>
		    新增用户名：&nbsp;<input name="name" type="text" /><br/>
		    新增用户性别：<input name="sex" type="text" /><br/>
	        新增用户号码：<input name="phone" type="text"/><br/>
	<input type="image" src="./img/submit.png" nclick="javascript:document.forms['borm_2'].submit();" style="    position: absolute;
    left: 570px;
    bottom: 20px;"/>
</form>
</div>
</body>
</html>