<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<%
	response.setCharacterEncoding("utf-8");
%>
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
					<li id="active"><a href="UserManagerServlet?method=showuser">用户管理</a></li>
					<li><a href="MenuServlet?chose=managemenu&sortway=sortNormol">菜单管理</a></li>
					<li><a
						href="OrderServlet?userid=${sessionScope.SESSION_user.userid}&chose=myorder">订单管理</a></li>
					<li><a
						href="UserManagerServlet?userid=${sessionScope.SESSION_user.userid}&method=showInformation">我的信息</a></li>
					<li><a href="LoginAndRegisterServlet?chose=login">退出系统</a></li>
				</ul>
			</nav>
		</div>
		<div class="right">

			<div class="providerAdd">
				<form action="UserManagerServlet" method="post">
					<input type="hidden" name="method" value="changeuser" />
					<div class="">
						<label for="billId">用户账号：</label> <input readonly type="text"
							name="userid" id="billId" value="${userDetail.userid}"
							required /> <span>用户账号不可修改</span>
					</div>
					<div>
						<label for="billName">用户昵称：</label> <input type="text"
							name="nickname" id="billName"
							value="${userDetail.nickname}" required /> <span>*请输入修改后的用户昵称</span>
					</div>
					<div>
						<label for="billCom">用户密码：</label> <input type="password" name="password"
							id="billCom" value="${userDetail.password}" required /> <span>*请输入修改后的用户密码</span>
					</div>
					<div>
						<label for="billNum">用户角色：</label> <input type="text"
							name="role" id="billNum" value="${userDetail.role}"
							required /> <span>*请输入修改后的用户角色</span>
					</div>
					<div class="providerAddBtn">
						<input type="submit" value="确认修改" />
					</div>
				</form>
			</div>

		</div>
	</section>


	<script src="js/jquery.js"></script>
	<script src="js/js.js"></script>
	<script src="js/time.js"></script>

</body>

</html>