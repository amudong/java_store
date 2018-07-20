<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新增供应商信息</title>
</head>
<link href="css/style1.css" rel='stylesheet' type='text/css' media="all" />
<body>
<div class="insert1">
<form action="supplierServlet" method="get">
<input name="sw" type="text" value="3" style="position:absolute;
right:-3000px;"><br/>
	
		
		    编号id：&nbsp;&nbsp;&nbsp;&nbsp;<input name="id" type="text" /><br/>
			新增供应商编码：<input name="supid" type="text"  /><br/>
			新增供应商：&nbsp;&nbsp;<input name="supname" type="text" /><br/>
	
	
	<input type="image" src="./img/submit.png" nclick="javascript:document.forms['borm_2'].submit();" style="    position: absolute;
    left: 580px;
    bottom: 20px;"/>
</form>
</div>
</body>
</html>