<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="day4.*"%>
<%@ page import="java.util.*" %>
		<%@ page import="demo.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>商品列表</title>
<script src="js/jquery-1.8.3.min.js"> </script>
</head>
<link href="css/styleList.css" rel='stylesheet' type='text/css' media="all" />
<style>
ul.pagination {
    display: inline-block;
    padding: 0;
    margin: 0;
}

ul.pagination li {display: inline;}

ul.pagination li a {
    color: black;
    float: left;
    padding: 8px 16px;
    text-decoration: none;
    transition: background-color .3s;
    border: 1px solid #ddd;
}

ul.pagination li a.active {
    background-color: #4CAF50;
    color: white;
    border: 1px solid #4CAF50;
}

ul.pagination li a:hover:not(.active) {background-color: #ddd;}



</style>

<% 
List<goodsDB> ln = goods.selectPage();

int a = goods.selectNum();

//当a取模10的时候 值为4 
int num1 = a/10;

int num = a%10;
if(num>0){
	 num1++;
}

%>


<body>
<div class="tablegoods" >
	<table id="test" border="5">
		<tr> 
			<th>编号</th>
			<th>商品编号</th>
			<th>商品名称</th>
			<th>商品价格</th>
			<th>条形码</th>
			<th>单位</th>
			<th>商品折扣</th>
			<th>会员价格</th>
			<th>供应商</th>
			<th>操作</th>								
		</tr>

	<%
		
		for(int i=0;i<ln.size();i++){	
	%>	<tr>
			<td><%=ln.get(i).getId() %></td>
			<td><%=ln.get(i).getGid()%></td>
			<td><%=ln.get(i).getGname() %></td>
			<td><%=ln.get(i).getPrice() %></td>
			<td><%=ln.get(i).getGcode()%></td>
			<td><%=ln.get(i).getType() %></td>
			<td><%=ln.get(i).getDisc() %></td>
			<td><%=ln.get(i).getHy() %></td>
			<td><%=ln.get(i).getSupname() %></td>
			<td align="center"><a href="goodsServlet?id=<%=ln.get(i).getId()%>&sw=1"><img src="./img/delete16.png"></img></a>&nbsp;<a href="modifyGoods.jsp?id=<%=ln.get(i).getId() %>&gid=<%=ln.get(i).getGid() %>&gname=<%=ln.get(i).getGname() %>
			&price=<%=ln.get(i).getPrice() %>&gcode=<%=ln.get(i).getGcode() %>&type=<%=ln.get(i).getType() %>
			&disc=<%=ln.get(i).getDisc() %>&hy=<%=ln.get(i).getHy() %>"><img src="./img/pencil16.png"></img></a></td>
		</tr>
	<%
	}
	%>
	
	</table>
	
	<a href="insertGoods.jsp" class="insertgoods"><img src="./img/add32.png"></img></a> 
	<div class="page">
   <ul id="numValue" class="pagination">
    <li><a href="#"><img src="./img/left.png"></img></a></li>
    <% for(int i=0;i<num1;i++){
	%>
	<li><a><%=i+1 %></a></li>
	<%
	} %>
    <li><a href="#"><img src="./img/right.png"></img></a></li>
   </ul>
	</div>
	</div>		
</body>

<script type="text/javascript">
   
	//定义一个存储的值
	var value="";
	//# 表示去找到对应的id 
	$("#numValue").click(function(){
		//获取当前的id 为numvalue的对象
		var ul = document.getElementById("numValue");
		
		//获取它a标签节点对象
		var a = ul.getElementsByTagName("a");
		for(var i = 0;i<a.length;i++){
			//当点击a标签的时候，事件就被获取
			a[i].onclick = function(){
				value = this.innerHTML;
			}
		}
		
		//把参数封装
		var values = {
			num:value
			
		};
			
		//实现ajax功能
		$.ajax({
			//设置传输的类型
			type:"get",
			//设置servlet地址
			url:"goodsPage",
			//设置类型
			dataType:"json",
			//设置类型和编码
			contentType:"application/json;charset=utf-8",
			//设置数据
			data:values,
			success:function(data){
				if(data.length>0){
					document.getElementById("test").innerHTML="";
					document.getElementById("test").innerHTML +="<tr> <th>编号</th><th>商品编号</th><th>商品名称</th><th>商品价格</th><th>条形码</th><th>单位</th><th>商品折扣</th><th>会员价格</th><th>供应商</th><th>操作</th></tr>";
				}
				
				
				//data数据已经到了页面，现在需要解析它
				for(var i=0;i<data.length;i++){
					//alert(data[i].mname);
					document.getElementById("test").innerHTML +='<tr><td>'+data[i].id+'</td><td>'+data[i].gid+'</td><td>'+data[i].gname+'</td><td>'+data[i].price+'</td><td>'+data[i].gcode+'</td><td>'+data[i].type+'</td><td>'+data[i].disc+'</td><td>'+data[i].hy+'</td><td>'+data[i].supname+'</td><td align="center"><a href="goodsServlet?id='+data[i].id+'&sw=1"><img src="./img/delete16.png"></img></a>&nbsp;<a href="modifyGoods.jsp?id='+data[i].id+'&gid='+data[i].gid+'&gname='+data[i].gname+'&price='+data[i].price+'&gcode='+data[i].gcode+'&type='+data[i].type+'&disc='+data[i].disc+'&hy='+data[i].hy+'&supname='+data[i].supname+'"><img src="./img/pencil16.png"></img></a></td></tr>';
				}
			}
		});
	});










</script>

</html>