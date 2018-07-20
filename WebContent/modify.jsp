<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改页面</title>
</head>
<style>
</style>
<link href="css/style1.css" rel='stylesheet' type='text/css' media="all" />
<body>
<div class="insert1">
<form action="modifyServlet" method="get">
	编号：&nbsp;&nbsp;&nbsp;<input name="mid" type="text" value="<%=request.getParameter("id")%>"/><br/>
			门店名称：&nbsp;<input name="Mname" type="text" value="<%=request.getParameter("mname")%>"/><br/>
			所在的地区：<input name="dizhi" type="text" value="<%=request.getParameter("dizhi")%>"/><br/>
			电话号码：&nbsp;<input name="Phone" type="text" value="<%=request.getParameter("phone")%>"/><br/>
	
	<input type="image" src="./img/submit.png" nclick="javascript:document.forms['borm_2'].submit();" style="    position: absolute;
    left: 570px;
    bottom: 20px;"/>
</form>
</div>
</body>
</html>