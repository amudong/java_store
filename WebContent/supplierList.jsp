<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="day4.*"%>
<%@ page import="java.util.*" %>
<%@ page import="demo.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="js/jquery-1.8.3.min.js"> </script>


<title>供应商列表</title>
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
List<supplierDB> ln = supplier.selectPage(); 
int a = supplier.selectNum();//44条

//当a取模10的时候 值为4 
int num1 = a/10;

int num = a%10;
if(num>0){
	 num1++;
}

%>


<body>
<div class="tablesup">
	<table id="test" border="5">
		<tr> 
			<th>编号</th>
			<th>供应商编号</th>
			<th>供应商名称</th>
			<th>操作</th>
		</tr>

	<%
		
		for(int i=0;i<ln.size();i++){	
	%>	<tr>
			<td><%=ln.get(i).getId() %></td>
			<td><%=ln.get(i).getSupid() %></td>
			<td><%=ln.get(i).getSupname() %></td>
			<td align="center"><a href="supplierServlet?id=<%=ln.get(i).getId()%>&sw=1"><img src="./img/delete16.png"></img></a>&nbsp;<a href="modifySup.jsp?id=<%=ln.get(i).getId() %>&supid=<%=ln.get(i).getSupid() %>&supname=<%=ln.get(i).getSupname() %>"><img src="./img/pencil16.png"></img></a></td>
		</tr>
	<%
	}
	%>
	
	</table>
	
	<a href="insertSup.jsp" class="insertsup"><img src="./img/add32.png"></img></a>
	
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
			url:"supplierPage",
			//设置类型
			dataType:"json",
			//设置类型和编码
			contentType:"application/json;charset=utf-8",
			//设置数据
			data:values,
			success:function(data){
				if(data.length>0){
					document.getElementById("test").innerHTML="";
					document.getElementById("test").innerHTML +="<tr> <th>编号</th><th>供应商编号</th><th>供应商名称</th><th>操作</th></tr>";
				}
				
				
				//data数据已经到了页面，现在需要解析它
				for(var i=0;i<data.length;i++){
					//alert(data[i].mname);
					document.getElementById("test").innerHTML +='<tr><td>'+data[i].id+'</td><td>'+data[i].supid+'</td><td>'+data[i].supname+'</td><td align="center"><a href="supplierServlet?id='+data[i].id+'&sw=1"><img src="./img/delete16.png"></img></a>&nbsp;<a href="modifySup.jsp?id='+data[i].id+'&supid='+data[i].supid+'&supname='+data[i].supname+'"><img src="./img/pencil16.png"></img></a></td></tr>';
				}
			}
		});
	});










</script>

</html>