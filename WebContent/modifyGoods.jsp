<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="demo.*"%>
<%@ page import="day4.*"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改页面</title>
</head>
<link href="css/style1.css" rel='stylesheet' type='text/css' media="all" />

<%List<supplierDB> g = supplier.select(); %>
<body>
<div class="insert1">
<form action="goodsServlet" method="get">
<input name="sw" type="text" value="2" style="position:absolute;
right:-3000px;">

		
			<br/>编号id：&nbsp;<input name="id" type="text" value="<%=request.getParameter("id")%>"/><br/>
			商品编号：<input name="gid" type="text" value="<%=request.getParameter("gid")%>"/><br/>
			商品名称：<input name="gname" type="text" value="<%=request.getParameter("gname")%>"/><br/>
			商品价格：<input name="price" type="text" value="<%=request.getParameter("price")%>"/><br/>
			条形码：&nbsp;<input name="gcode" type="text" value="<%=request.getParameter("gcode")%>"/><br/>
			单位：&nbsp;&nbsp;<input name="type" type="text" value="<%=request.getParameter("type")%>"/><br/>
			商品折扣：<input name="disc" type="text" value="<%=request.getParameter("disc")%>"/><br/>
			会员价格：<input name="hy" type="text" value="<%=request.getParameter("hy")%>"/><br/>
			
			供应商：&nbsp;<select name="supid">
				
				<% for(int i = 0;i<g.size();i++){
					%>
					<option value="<%=g.get(i).getSupid() %>" ><%=g.get(i).getSupname()%></option>
					<%
				} %>
					
</select>
<br/>

		
	<input type="image" src="./img/submit.png" nclick="javascript:document.forms['borm_2'].submit();" style="    position: absolute;
    left: 570px;
    bottom: 20px;"/>
</form>
</div>
</body>
</html>