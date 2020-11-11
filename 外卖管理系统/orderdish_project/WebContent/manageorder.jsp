<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.itshixun.dao.OrderDao"%>
<%@ page import="com.itshixun.pojo.Order"%>
<%@ page import="com.itshixun.pojo.OrderDetail"%>

<%@ page import="com.itshixun.dao.impl.OrderDaoImpl"%>
<%@ page import="java.util.List"%>


<!DOCTYPE html>
<html>

<head lang="en">
<meta charset="UTF-8">
<link rel="icon" href="https://s2.ax1x.com/2019/12/12/QyHjXT.jpg"
	type="image/x-icon" />
<title>餐厅管理系统</title>
<link rel="stylesheet" href="css/publics.css" />
<link rel="stylesheet" href="css/myorder.css" />

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
			<div style="height: 550px; overflow-y: scroll;">
				<h3 style="text-align: center" class="common_title2">订单管理</h3>
				<%
                 OrderDao orderDao=new OrderDaoImpl();
                 List<Order> list=orderDao.findAllOrder();
                 for(int i=0;i<list.size();i++){
         	     Order order=list.get(i);
            %>
				<ul class="order_list_th w978 clearfix">
					<li class="col01"><%=order.getOrdertime()%></li>
					<li class="col02">订单号:<%=order.getOrderid()%></li>
					<li class="col02">下单人账号:<%=order.getUserid()%></li>
				</ul>

				<table class="order_list_table w980">
					<tbody>
						<tr>
							<td width="55%">
								<%
						  String orderid=order.getOrderid();
						  List<OrderDetail> list1=orderDao.findOrderDetail(orderid);
						  for(int j=0;j<list1.size();j++){
				         	     OrderDetail orderDetail=list1.get(j);  
						  %>
								<ul class="order_goods_list clearfix">
									<li class="col01">
									<img src=<%=orderDetail.getCarmenupicture()%>>
									</li>
									<li class="col02">
									<%=orderDetail.getCarmenuname()%>
									<em>
									¥<%=orderDetail.getCarmenuprice()%>/份
									</em>
									</li>
									<li class="col03"><%=orderDetail.getCarnum()%>份</li>
									<li class="col04">¥<%=orderDetail.getCarprice()%></li>
								</ul> <%} %>
							</td>
							<td width="15%">¥<%=order.getOrderprice()%></td>
							<td width="15%"><%=order.getOrderstatus()%> <%
							   if("已付款".equals(order.getOrderstatus())){%> <a
								onClick="return confirm('确定为顾客派送吗?');" href="OrderServlet?userid=${sessionScope.SESSION_user.userid}&chose=changestatus&orderid=<%=order.getOrderid()%>&orderstatus=<%=order.getOrderstatus()%>">派送订单</a></td>
							<%   
							   }
							%>
							<td width="15%"><a href="OrderServlet?chose=adminshoworderdetail&orderid=<%=order.getOrderid()%>" class="oper_btn">订单详情</a></td>
						</tr>
					</tbody>
				</table>
				<% }%>
			</div>
		</div>

	</section>

	<footer class="footer"> </footer>

	<script src="js/jquery.js"></script>
	<script src="js/js.js"></script>
	<script src="js/time.js"></script>

</body>

</html>