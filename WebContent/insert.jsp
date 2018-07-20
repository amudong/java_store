<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新增门店信息</title>
</head>
<link href="css/style1.css" rel='stylesheet' type='text/css' media="all" />

<body>
<div class="insert1">
<form action="insertServlet" method="post">
		
			<div>新增门店名称：<input name="Mname" type="text"/><br/></div>
			<div>新增门店地址：<input name="dizhi" type="text"/><br/></div>
			<div>新增门店号码：<input name="Phone" type="text"/><br/></div>
	<input type="image" src="./img/submit.png" nclick="javascript:document.forms['borm_2'].submit();" style="    position: absolute;
    left: 580px;
    bottom: 20px;"/>

</form>
</div>
</body>
</html>