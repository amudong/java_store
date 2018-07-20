<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="day4.*"%>
<%@ page import="java.util.*" %>
<%@ page import="demo.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<!-- 导入对应的js包 -->
<script src="js/jquery-1.8.3.min.js"> </script>
<link href="css/styleList.css" rel='stylesheet' type='text/css' media="all" />

<title>门店信息</title>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=BNDjrc74i2ifCfNSjaXhVinTtZZHbwTo"></script>

</head>


<style type="text/css">  
	#allmap{
	position:absolute;
	right: 10px;
    width: 50%;
	height:300px;
	}
	#r-result,#r-result table{
	background-color:#FFFFFF;
	position:absolute;
	right:10px;
	bottom:10px;
	width:50%;
	height:50%;
    font-size:12px;}
</style> 
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

div.center {text-align: center;}
</style>

<% 
//在这里使用Java代码
List<mendianshiti> lm = mendian.selectPage(); //2\数据库数据获取


//连接数据库，查询对应的页数
 int a = mendian.selectNum();//44条

 //当a取模10的时候 值为4 
 int num1 = a/10;
 
 int num = a%10;
 if(num>0){
	 num1++;
 }
 
 //页面的总数量
 
%>

<body>
<div class="tablemd">
	<table id="test"  border="5">
		<tr> 
			<th>编号</th>
			<th>门店名称</th>
			<th>所在的地区</th>
			<th>电话号码</th>
			<th>操作</th>
		</tr>

	<%
		//3使用一个for循环操作数据库信息
		
		for(int i=0;i<lm.size();i++){	
	%>	<tr>
			<td><%=lm.get(i).getId() %></td>
			<td><%=lm.get(i).getMname() %></td>
			<td><%=lm.get(i).getDizhi() %><input type="image" src="./img/walk.png" onclick='disp_prompt("<%=lm.get(i).getDizhi()%>")' /></td>
			<td><%=lm.get(i).getPhone() %></td>
			<td align="center"><a href="deleteServlet?mid=<%=lm.get(i).getId()%>"><img src="./img/delete16.png"></img></a>&nbsp;<a href="modify.jsp?id=<%=lm.get(i).getId() %>&mname=<%=lm.get(i).getMname() %>&dizhi=<%=lm.get(i).getDizhi() %>&phone=<%=lm.get(i).getPhone() %>" ><img src="./img/pencil16.png"></img></a></td>
		</tr>
	<%
	}
	%>
	
	</table>
	

	
	<a href="insert.jsp"><img src="./img/add32.png"></img>	</a> 
	<div class="center">
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
	<div id="allmap"></div> 
<div id="r-result"></div>
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
			url:"mendianPage",
			//设置类型
			dataType:"json",
			//设置类型和编码
			contentType:"application/json;charset=utf-8",
			//设置数据
			data:values,
			success:function(data){
				if(data.length>0){
					document.getElementById("test").innerHTML="";
					document.getElementById("test").innerHTML +="<tr> <th>编号</th><th>门店名称</th><th>所在的地区</th><th>电话号码</th><th>操作</th></tr>";
				}
				
				
				//data数据已经到了页面，现在需要解析它
				for(var i=0;i<data.length;i++){
					//alert(data[i].mname);                                                                                                         //jasdfihosado
					document.getElementById("test").innerHTML +='<tr><td>'+data[i].id+'</td><td>'+data[i].mname+'</td><td>'+data[i].dizhi+'<input type="image" src="./img/walk.png" onclick="disp_prompt2()" /></td><td>'+data[i].phone+'</td><td align="center"><a href="deleteServlet?mid='+data[i].id+'"><img src="./img/delete16.png"></img></a>&nbsp;<a href="modify.jsp?id='+data[i].id+'&mname='+data[i].mname+'&dizhi='+data[i].dizhi+'&phone='+data[i].phone+'"><img src="./img/pencil16.png"></img></a></td></tr>';
				}
			}
		});
	});




//daozhe 




</script>

<script type="text/javascript"> 

var map = new BMap.Map("allmap");    
map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
map.centerAndZoom(new BMap.Point(113,27), 14); 
map.addControl(new BMap.NavigationControl());    
map.addControl(new BMap.ScaleControl());    
map.addControl(new BMap.OverviewMapControl());    
map.addControl(new BMap.MapTypeControl());    
map.setCurrentCity("广州"); // 仅当设置城市信息时，MapTypeControl的切换功能才能可用   

//公家车路线 加 导航
var transit = new BMap.TransitRoute(map, {    
renderOptions: {map: map, panel: "r-result"}    
});    


	
// 驾车加导航
// <script type="text/javascript">
// 	// 百度地图API功能
// 	var map = new BMap.Map("l-map");
// 	map.centerAndZoom(new BMap.Point(116.404, 39.915), 12);

// 	 var transit = new BMap.DrivingRoute(map, {
// 		renderOptions: {
// 			map: map,
// 			panel: "r-result",
// 			enableDragging : true //起终点可进行拖拽
// 		},  
// 	});
// 	transit.search("西单","魏公村");	

function disp_prompt(address)
  {
  var add1=prompt("请输入您的当前位置","")
  
  transit.search(add1, address); 

  }
function disp_prompt2()
{
var add1=prompt("请输入您的当前位置","")
var add2=prompt("请输入您的目的位置","")
transit.search(add1, add2); 

}

</script>


</html>