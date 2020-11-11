<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8");%>
<%response.setCharacterEncoding("utf-8");%>
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
					<li id="active"><a
						href="UserManagerServlet?method=showuser">用户管理</a></li>
					<li><a
						href="MenuServlet?chose=managemenu&sortway=sortNormol">菜单管理</a></li>
					<li><a
						href="OrderServlet?chose=manageorder">订单管理</a></li>
					<li><a href="LoginAndRegisterServlet?chose=login">退出系统</a></li>
				</ul>
			</nav>
		</div>
		<div class="right">
			<table class="providerTable" cellpadding="0" cellspacing="0">

				<tr class="firstTr">
					<th width="20%">用户账号</th>
					<th width="10%">用户昵称</th>
					<th width="20%">用户密码</th>
					<th width="10%">用户角色</th>
					<th width="20%">操作</th>
				</tr>
				<c:forEach items="${requestScope.userList}" var="u">
					<tr>
						<td>${u.userid}</td>
						<td>${u.nickname}</td>
						<td>${u.password}</td>
						<td>${u.role}</td>
						<td>
						  <a href="UserManagerServlet?method=gochangeuser&userid=${u.userid}">修改</a>
						  <a  onClick="return confirm('确定删除?');" href=" UserManagerServlet?method=deleteuser&userid=${u.userid}" >删除</a>
					    </td>
					</tr>
				</c:forEach>
			</table>

		</div>
	</section>


	<script src="js/jquery.js"></script>
	<script src="js/js.js"></script>
	<script src="js/time.js"></script>

</body>

</html>