<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

	<head lang="en">
		<meta charset="UTF-8">
		<link rel="icon" href="https://s2.ax1x.com/2019/12/12/QyHjXT.jpg" type="image/x-icon" />
		<title>${menuDetail.menuname}-订餐管理系统</title>
		<link rel="stylesheet" href="css/publics.css" />
		<link rel="stylesheet" href="css/mainstyle.css" />
	</head>

	<body>
		<!--头部-->
		<header class="publicHeader">
			<h1>订餐管理系统</h1>
			<div class="publicHeaderR">
				<p><span>下午好！</span><span style="color: #fff21b">
                 ${sessionScope.SESSION_user.nickname}  </span> , 欢迎你！</p>
				<a href="LoginAndRegisterServlet?chose=login">退出</a>
			</div>
		</header>
		<!--主体内容-->
		<section class="publicMian ">
			<div class="left">
				<h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
				<nav>
					<ul class="list">
						<li id="active">
							<a href="MenuServlet?chose=showmenu&sortway=sortNormol">菜单浏览</a>
						</li>
						<li>
							<a href="CarServlet?userid=${sessionScope.SESSION_user.userid}&chose=showcar">我的购物车</a>
						</li>
						<li><a href="OrderServlet?userid=${sessionScope.SESSION_user.userid}&chose=myorder">我的订单</a></li>
						<li>
							<a href="UserManagerServlet?userid=${sessionScope.SESSION_user.userid}&method=showInformation">我的信息</a>
						</li>
						<li>
							<a href="LoginAndRegisterServlet?chose=login">退出系统</a>
						</li>
					</ul>
				</nav>
			</div>
			<div class="right">
				<div class="location">
					<strong>你现在所在的位置是:</strong>
					<span>菜单浏览页面</span>
				</div>
				<div class="search">

					<label style="margin-left:400px ; font-size: 30px;color: #FF0000;">${menuDetail.menuname}</label>

					<a href="billAdd.html">添加订单</a>
				</div>
				<div style="display: block;width: 70%;height: 80%;background-color:white;margin: auto;">
					<div style="display: block;width: 60%;height: 80%;float: left;background-color: white;">
						<img width="90%" src="${menuDetail.picturepath}" />
					</div>
					<div style="display: block;width: 39%;height: 70%;float: right;background-color:#d38299;">
						<table style="font-size: 18px;" width="100%" height="200px">
							<tr>
								<th>菜品名：</th>
								<td>${menuDetail.menuname}</td>
							</tr>
							<tr>
								<th>菜品价格：</th>
								<td>${menuDetail.price}</td>
							</tr>
							<tr>
								<th>菜品销量：</th>
								<td>${menuDetail.sales}</td>
							</tr>
							<tr>
								<th>菜品描述：</th>
								<td>${menuDetail.describe}</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</section>

	</body>

</html>