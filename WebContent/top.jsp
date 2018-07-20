<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script>
    function mytime(){
        var a = new Date();
        var b = a.toLocaleTimeString();
        var c = a.toLocaleDateString();
        document.getElementById("time1").innerHTML = "登陆时间："+c+"&nbsp"+b+"用户:<%=request.getSession().getAttribute("usernametest")%>"+"<a href='login.jsp' target='main.jsp'>退出登陆</a>";
        }
    setInterval(function() {mytime()},1000);
</script>
<style>
#topvalue{
position:absolute;
top:25px;
right:20px;
width:450px;
height:20px;
}
</style>
</head>
<body background="./img/002.png" >
		
			<font size="9"  color="#000000" >
			便利店销售系统
			</font>
		
		
		<div id="topvalue">
		<font size="4" face="Verdana" color="#000000" >
				<div  id="time1" type="text"></div>
		</font>
		</div>
	
</body>
</html>