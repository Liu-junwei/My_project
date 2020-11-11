<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head lang="en">
<meta charset="UTF-8">
<link rel="icon" href="https://s2.ax1x.com/2019/12/12/QyHjXT.jpg" type="image/x-icon" />
<title>浏览菜单-订餐管理系统</title>
<link rel="stylesheet" href="css/publics.css" />

</head>

<body>
	<!--头部-->
	<header class="publicHeader">
		<h1>订餐管理系统</h1>
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
					<li id="active"><a href="MenuServlet?chose=showmenu&sortway=sortNormol">菜单浏览</a></li>
					<li><a href="CarServlet?userid=${sessionScope.SESSION_user.userid}&chose=showcar">我的购物车</a></li>
					<li><a href="OrderServlet?userid=${sessionScope.SESSION_user.userid}&chose=myorder">我的订单</a></li>
					<li><a href="UserManagerServlet?userid=${sessionScope.SESSION_user.userid}&method=showInformation">我的信息</a></li>
					<li><a href="LoginAndRegisterServlet?chose=login">退出系统</a></li>
				</ul>
			</nav>
		</div>
		<div class="right">
			<div class="location">
				<strong>你现在所在的位置是:</strong> <span>菜单浏览页面</span>
			</div>
			<form action=MenuServlet method="post">
			<input type="hidden" name="chose" value="showmenu">
			<div class="search">
			    <span>排序方式：</span>
				<select name="sortway">
					<option value="sortNormol" selected>默认排序</option>
					<option value="sortByPrice">按价格排序</option>
					<option value="sortBySales">按销量排序</option>
				</select>
			<input style="width:80px;height:30px " type="submit" value="查询" /> 
			</div>
			</form>
			<div class="menupic" style="overflow-y:scroll;	height:450px;">
				<ul>
					<c:forEach items="${requestScope.menuList}" var="m">
					<li>
						<a href="MenuServlet?menuname=${m.menuname}&chose=showMenudetail">
							<img src="${m.picturepath}" />
							<h3>${m.menuname}</h3>
							<h3>¥${m.price}</h3>
							<p>销量：${m.sales}</p>
						</a>
						<a class="addcar" href="CarServlet?chose=addcar&caruserid=${sessionScope.SESSION_user.userid}&carmenuname=${m.menuname}&carpicture=${m.picturepath}&carmenuprice=${m.price}">
						加入购物车
						</a>
					</li>
					</c:forEach>
				</ul>
			</div>

		</div>
	</section>
	
</body>

</html>