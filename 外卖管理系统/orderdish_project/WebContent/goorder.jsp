<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head lang="en">
<meta charset="UTF-8">
<title>餐厅管理系统</title>
<link rel="stylesheet" href="css/publics.css" />
<link href="css/gouwuche.css" rel="stylesheet" />
<style>
.xinxi label {
	font-size: 20px;
}

.xinxi input {
	display: block;
	font-size: 20px;
	margin-right: 50px;
}
</style>
</head>

<body>
	<!--头部-->
	<header class="publicHeader">
		<h1>餐厅管理系统</h1>
		<div class="publicHeaderR">
			<p>
				<span>下午好！</span><span style="color: #fff21b">
					${sessionScope.SESSION_user.nickname}</span> , 欢迎你！
			</p>
			<a href="LoginAndRegisterServlet?chose=login">退出</a>
		</div>
	</header>
	<!--时间-->
	<section class="publicTime" style="">
		<span id="time">2015年1月1日 11:11 星期一</span> <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
	</section>
	<!--主体内容-->
	<section class="publicMian ">
		<div class="left">
			<h2 class="leftH2">
				<span class="span1"></span>功能列表 <span></span>
			</h2>
			<nav>
				<ul class="list">
					<li><a href="MenuServlet?chose=showmenu&sortway=sortNormol">菜单浏览</a></li>
					<li id="active"><a
						href="CarServlet?userid=${sessionScope.SESSION_user.userid}&chose=showcar">我的购物车</a>
					</li>
					<li><a href="userList.html">我的订单</a></li>
					<li><a
						href="UserManagerServlet?userid=${sessionScope.SESSION_user.userid}&method=showInformation">我的信息</a>
					</li>
					<li><a href="LoginAndRegisterServlet?chose=login">退出系统</a></li>
				</ul>
			</nav>
		</div>
		<div class="right">

			<div class="location">
				<strong>你现在所在的位置是:</strong> <span>购物车页面</span>
			</div>

			<div class="shouhuo"
				style="display: block; width: 100%; height: 200px; background-color: #FFE4C4;">
				<h1 style="color: #AC2925; text-align: center;">收货地址</h1>
				<hr />
				<div style="display: block; margin: auto; width: 40%;">
					<form action="OrderServlet" method="post">
						<div class="xinxi">
							<label>收货人:</label> <input type="text" name="receivename" />
						</div>
						<div class="xinxi">
							<label>手机号:</label> <input type="text" name="receivetel" />
						</div>
						<div class="xinxi">
							<label>收货地址:</label> <input type="text" name="receiveaddr" />
						</div>
						
						<%//获取下单时当前时间
		                      Date d = new Date();
		                      SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		                      String now = df.format(d);
	                    %>
	                    <%//通过当前时间和随机数获取唯一订单编号
		                      Date date = new Date();
		                      SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		                      String time = sdf.format(date);
		                      String result="";
		                      Random random=new Random();
		                      for(int i=0;i<3;i++){
		                          result+=random.nextInt(10);
		                      }
		                      String orderid=time+result;
	                    %>
	                    
	                    <input type="hidden" name="chose" value="addorder">
					    <input type="hidden" name="orderid" value="<%=orderid%>">
					    <input type="hidden" name="userid" value="${sessionScope.SESSION_user.userid}">
					    <input type="hidden" name="ordertime" value="<%=now%>">
					    <input type="hidden" name="ordernum" value="${requestScope.allnum}">
					    <input type="hidden" name="orderprice" value="${requestScope.allprice}">
					    <input type="hidden" name="orderstatus" value="<%="已付款"%>">
				</div>
			</div>
			<div class="gouwuche"
				style="display: block; margin-top: 20px; width: 100%; background-color: #FFE4C4;">
				<h1 style="color: #AC2925; text-align: center;">菜品信息</h1>
				<hr />
				<table width="750" cellpadding="0" cellspacing="0" id="gwcTable">
					<tr>
						<td width="175">商品</td>
						<td width="92">单价</td>
						<td width="80">数量</td>
						<td width="96">小计</td>
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
							<td class="count"><input type="text" disabled
								class="inputCountCss" id="inputCountCss1" value="${c.carnum}"
								size="2" /></td>

							<td id="stotal3">${c.carprice}</td>
						</tr>
					</c:forEach>

				</table>
			</div>
			<div id="jiesuan">
				<div class="t jisuanbtn">
					<input id="btnOrder" type="submit" value="确认付款">
				</div>
				</form>
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