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
		<div class="publicHeaderR">
			<p>
				<span>下午好！</span><span style="color: #fff21b">
					${sessionScope.SESSION_user.nickname}</span> , 欢迎你！
			</p>
			<a href="LoginAndRegisterServlet?chose=login">退出</a>
		</div>
	</header>
	<!--时间-->
	<section class="publicTime">
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
					<li><a
						href="UserManagerServlet?method=showuser">用户管理</a></li>
					<li id="active"><a href="MenuServlet?chose=managemenu&sortway=sortNormol">菜单管理</a></li>
					<li><a
						href="OrderServlet?userid=${sessionScope.SESSION_user.userid}&chose=myorder">订单管理</a></li>
					<li><a
						href="UserManagerServlet?userid=${sessionScope.SESSION_user.userid}&method=showInformation">我的信息</a></li>
					<li><a href="LoginAndRegisterServlet?chose=login">退出系统</a></li>
				</ul>
			</nav>
		</div>
		<div class="right">
			<div class="location">
				<strong>你现在所在的位置是:</strong> <span>菜单管理页面>菜品添加页面</span>
			</div>
			<div class="providerAdd">
				<form action="MenuServlet" method="post">
				<input type="hidden" name="chose" value="addmenu"/>
					<div class="">
						<label for="billId">菜品名称：</label> <input type="text" name="menuname"
							id="billId" required /> <span>*请输入菜品名称</span>
					</div>
					<div>
						<label for="billName">菜品图片路径：</label> <input type="text"
							name="picturepath" id="billName" required /> <span>*请输入菜品图片路径</span>
					</div>
					<div>
						<label for="billCom">菜品价格：</label> <input type="text"
							name="price" id="billCom" required /> <span>*请输入菜品价格</span>

					</div>
					<div>
						<label for="billNum">菜品描述：</label> <input type="text"
							name="describes" id="billNum" required /> <span>*菜品描述</span>
					</div>
					<div class="providerAddBtn">
						<input type="submit" value="确认添加" /> 
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