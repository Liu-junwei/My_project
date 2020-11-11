<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head lang="en">
<meta charset="UTF-8">
<link rel="icon" href="https://s2.ax1x.com/2019/12/12/QyHjXT.jpg"
	type="image/x-icon" />
<title>菜单管理-订餐管理系统</title>
<link rel="stylesheet" href="css/publics.css" />
<link rel="stylesheet" href="css/mainstyle.css" />
</head>

<body>
	<!--头部-->
	<header class="publicHeader">
		<h1>订餐管理系统</h1>
		<h1 style="font-size:20px;color:yellow">---后台管理</h1>
		<div class="publicHeaderR">
			<p>
				<span>下午好！</span><span style="color: #fff21b">
					${sessionScope.SESSION_user.nickname}</span> , 欢迎你！
			</p>
			<a href="LoginAndRegisterServlet?chose=login">退出</a>
		</div>
	</header>
	<!--主体内容-->
	<section class="publicMian ">
		<div class="left">
			<h2 class="leftH2">
				<span class="span1"></span>功能列表 <span></span>
			</h2>
			<nav>
				<ul class="list">
					<li><a
						href="UserManagerServlet?method=showuser">用户管理</a></li>
					<li id="active"><a
						href="MenuServlet?chose=managemenu&sortway=sortNormol">菜单管理</a></li>
					<li><a
						href="OrderServlet?chose=manageorder">订单管理</a></li>
					<li><a href="LoginAndRegisterServlet?chose=login">退出系统</a></li>
				</ul>
			</nav>
		</div>
		<div class="right">
			<form action=MenuServlet method="post">
				<input type="hidden" name="chose" value="managemenu">
				<div class="search">
					<span>排序方式：</span> 
					<select name="sortway">
						<option value="sortNormol" selected>默认排序</option>
						<option value="sortByPrice">按价格排序</option>
						<option value="sortBySales">按销量排序</option>
					</select>
					 <input style="width:80px;height:30px " type="submit" value="查询" /> 
					 <a href="MenuServlet?chose=goaddmenu">添加菜品</a>
				</div>
			</form>
			<div class="menupic" style="overflow-y: scroll; height: 500px;">
				<ul>
					<c:forEach items="${requestScope.menuList}" var="m">
						<li><a title="${m.describe}"
							href="MenuServlet?menuname=${m.menuname}&chose=gochangemenu">
								<img src="${m.picturepath}" />
								<h3>${m.menuname}</h3>
								<h3>¥${m.price}</h3>
								<p>销量：${m.sales}</p> 
								<a onClick="return confirm('确定删除?');" class="addcar" href="MenuServlet?chose=deletemenu&menuname=${m.menuname}&sortway=sortNormol">
									删除菜品 </a>
						</a></li>
					</c:forEach>
				</ul>
			</div>

		</div>
	</section>


	<script src="js/jquery.js"></script>
	<script src="js/js.js"></script>
	<script src="js/time.js"></script>

</body>

</html>