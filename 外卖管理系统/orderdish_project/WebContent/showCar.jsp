<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head lang="en">
<meta charset="UTF-8">
<link rel="icon" href="https://s2.ax1x.com/2019/12/12/QyHjXT.jpg" type="image/x-icon" />
<title>订餐管理系统</title>
<link rel="stylesheet" href="css/publics.css" />
<link href="css/gouwuche.css" rel="stylesheet" />

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
					<li>
					  <a href="MenuServlet?chose=showmenu&sortway=sortNormol">菜单浏览</a>
					</li>
					<li id="active">
					  <a href="CarServlet?userid=${sessionScope.SESSION_user.userid}&chose=showcar">我的购物车</a>
					</li>
					<li>
					    <a href="OrderServlet?userid=${sessionScope.SESSION_user.userid}&chose=myorder">我的订单</a></li>
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
				<strong>你现在所在的位置是:</strong> <span>购物车页面</span>
			</div>
			<div class="search">

				<label style="margin-left: 400px; font-size: 30px; color: #FF0000;">购物车</label>

			</div>
			<div>
				<table width="750" cellpadding="0" cellspacing="0" id="gwcTable">
					<tr>
						<td width="175">商品</td>
						<td width="92">单价</td>
						<td width="201">数量</td>
						<td width="96">小计</td>
						<td width="79">操作</td>
					</tr>
					<c:forEach items="${requestScope.carList}" var="c">
						<tr>

							<td>
								<p>
									<img src="${c.carmenupicture}" />
								</p>
								<p>${c.carmenuname}</p>
							</td>
							<td>${c.carmenuprice}</td>
							<td class="count">
							   <a class="reduceCss" href="CarServlet?chose=reducenum&userid=${sessionScope.SESSION_user.userid}&menuname=${c.carmenuname}&carnum=${c.carnum}">-</a>
								<input type="text" readonly class="inputCountCss" 
								id="inputCountCss1" value="${c.carnum}" size="2" />
								<a class="addCss" href="CarServlet?chose=addnum&userid=${sessionScope.SESSION_user.userid}&menuname=${c.carmenuname}&carnum=${c.carnum}">+</a>
							</td>
							
							<td id="stotal3">${c.carprice}</td>
							<td><a href="CarServlet?chose=deletecar&userid=${sessionScope.SESSION_user.userid}&menuname=${c.carmenuname}" class="a">删除</a></td>
						</tr>
					</c:forEach>

				</table>
			</div>
			<div id="jiesuan">
				<div class="t jisuanbtn">
		           <a href="CarServlet?chose=goorder&userid=${sessionScope.SESSION_user.userid}" id="btnOrder">立即结算</a>
				</div>
				<div class="t TotalMoney">
					合计：￥<span id="priceTotal">${requestScope.allprice}</span>
				</div>
				<div class="t">
					已选商品 <span id="countTotal">${requestScope.allnum}</span> 件
				</div>
			</div>

		</div>
	</section>
</body>

</html>