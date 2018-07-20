<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="demo.*"%>
<%@ page import="day4.*"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新增商品信息</title>
</head>
<link href="css/style1.css" rel='stylesheet' type='text/css' media="all" />
<%List<supplierDB> g = supplier.select(); %>

<body>
<div class="insert1"><form action="goodsServlet" method="get">

<input class="input1" name="sw" type="text" value="3" style="position:absolute;
right:-3000px;"><br/>
	
		
		       编号id：&nbsp;&nbsp;&nbsp;&nbsp;<input name="id" type="text" /><br/>
			新增商品编码：&nbsp;<input name="gid" type="text"  /><br/>
			新增商品名称：&nbsp;<input name="gname" type="text" /><br/>
			新增商品价格：&nbsp;<input name="price" type="text" /><br/>
			新增商品条形码：<input name="gcode" type="text" /><br/>
			新增商品单位：&nbsp;<input name="type" type="text" /><br/>
			新增商品折扣：&nbsp;<input name="disc" type="text" /><br/>
			新增商品会员价：<input name="hy" type="text" /><br/>
			新增商品供应商：<select name="supid">
				
				<% for(int i = 0;i<g.size();i++){
					%>
					<option value="<%=g.get(i).getSupid() %>" ><%=g.get(i).getSupname()%></option>
					<%
				} %>
					
</select>
			
	
	
	<br/><input type="image" src="./img/submit.png" nclick="javascript:document.forms['borm_2'].submit();" style="    position: absolute;
    left: 590px;
    bottom: 20px;"/>
</form>
</div>

</body>
</html>