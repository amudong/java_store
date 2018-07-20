<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加会员</title>
</head>
<link href="css/style1.css" rel='stylesheet' type='text/css' media="all" />

<body>
<div class="insert1">
<form action="insertVipServlet"  method="get">
		    
			编号id：&nbsp;&nbsp;&nbsp;&nbsp;<%=request.getParameter("id")%><br/>
			用户编号：&nbsp;&nbsp;<input name="uid" type="text" value="<%=request.getParameter("uid")%>"/>(*不可修改)<br/>
			用户名：&nbsp;&nbsp;&nbsp;<%=request.getParameter("name")%><br/>
			用户性别：&nbsp;&nbsp;<%=request.getParameter("sex")%><br/>
			电话号码：&nbsp;&nbsp;<%=request.getParameter("phone")%><br/>
			添加会员编号：<input name="hid" type="text"/><br/>
		
	
	<input type="image" src="./img/submit.png" nclick="javascript:document.forms['borm_2'].submit();" style="    position: absolute;
    left: 570px;
    bottom: 20px;"/>
</form>
</div>
</body>
</html>