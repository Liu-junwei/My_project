<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head lang="en">
<meta charset="UTF-8">
<link rel="icon" href="https://s2.ax1x.com/2019/12/12/QyHjXT.jpg"
	type="image/x-icon" />
<title>餐厅管理系统</title>
<link rel="stylesheet" href="css/publics.css" />
<link rel="stylesheet" href="css/myorder.css" />
<style>
.orde{
width:100%;
display:block;
font-size:20px;
}
</style>
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
					<li><a href="UserManagerServlet?method=showuser">用户管理</a></li>
					<li><a href="MenuServlet?chose=managemenu&sortway=sortNormol">菜单管理</a></li>
					<li id="active"><a href="OrderServlet?chose=manageorder">订单管理</a></li>
					<li><a href="LoginAndRegisterServlet?chose=login">退出系统</a></li>
				</ul>
			</nav>
		</div>
		<div class="right">
			<div  style="height: 550px; overflow-y: scroll;">
				<h3 style="text-align: center" class="common_title2">订单管理</h3>
				
				<ul class="order_list_th w978 clearfix">
					<li class="orde">下单时间:${orderDetail.ordertime}</li>
					<li class="orde">订单号:${orderDetail.orderid}</li>
					<li class="orde">下单人账号:${orderDetail.userid}</li>
					<li class="orde">收货人:${orderDetail.receivename}</li>
					<li class="orde">手机号:${orderDetail.receivetel}</li>
					<li class="orde">收货地址:${orderDetail.receiveaddr}</li>
				</ul>

				<table class="order_list_table w980">
					<tbody>
					    <tr>
							<td width="55%">菜品信息</td>
							<td width="15%">总价格</td>
							<td width="15%">订单状态 </td>
						</tr>
						<tr>
							<td width="55%">
							<c:forEach items="${requestScope.orderDetailList}" var="o">
								<ul class="order_goods_list clearfix">
									<li class="col01">
									<img src="${o.carmenupicture}"/>
									</li>
									<li class="col02">
									${o.carmenuname}
									<em>
									${o.carmenuprice}/份
									</em>
									</li>
									<li class="col03">${o.carnum}份</li>
									<li class="col04">¥${o.carprice}</li>
								</ul> 
							</c:forEach>
							</td>
							<td width="15%">¥${orderDetail.orderprice}</td>
							<td width="15%">${orderDetail.orderstatus} </td>
						</tr>
					
					</tbody>
				</table>
			</div>
		</div>

	</section>

	<footer class="footer"> </footer>

	<script src="js/jquery.js"></script>
	<script src="js/js.js"></script>
	<script src="js/time.js"></script>

</body>

</html>