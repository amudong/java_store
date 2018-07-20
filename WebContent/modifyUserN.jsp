<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改页面</title>
</head>
<link href="css/style1.css" rel='stylesheet' type='text/css' media="all" />
<body>
<div class="insert1">
<form action="user_nServlet" method="get">
<input name="switch" type="text" value="2" style="position:absolute;
right:-3000px;">
	编号id：&nbsp;<input name="id" type="text" value="<%=request.getParameter("id")%>"/><br/>
		用户编号：<input name="uid" type="text" value="<%=request.getParameter("uid")%>"/><br/>
			用户名：&nbsp;<input name="name" type="text" value="<%=request.getParameter("name")%>"/><br/>
			用户性别：<input name="sex" type="text" value="<%=request.getParameter("sex")%>"/><br/>
			电话号码：<input name="phone" type="text" value="<%=request.getParameter("phone")%>"/><br/>
		
	<input type="image" src="./img/submit.png" nclick="javascript:document.forms['borm_2'].submit();" style="    position: absolute;
    left: 570px;
    bottom: 20px;"/>
</form>
</div>
</body>
</html>