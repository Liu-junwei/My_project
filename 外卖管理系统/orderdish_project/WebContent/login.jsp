<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>
<html lang="zxx">

<head>

<title>登录页面</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8" />
<link rel="icon" href="https://s2.ax1x.com/2019/12/12/QyHjXT.jpg"
	type="image/x-icon" />
<meta name="keywords"
	content="Classic Register Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />

<!-- Meta tag Keywords -->
<!-- css files -->
<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
<!-- Style-CSS -->
<link rel="stylesheet" href="css/font-awesome.css">
<!-- Font-Awesome-Icons-CSS -->
<!-- //css files -->
<!-- web-fonts -->
<link
	href="//fonts.googleapis.com/css?family=Oswald:200,300,400,500,600,700"
	rel="stylesheet">
<link
	href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i"
	rel="stylesheet">
<!-- //web-fonts -->
</head>

<body>
	<!--header-->
	<h1>订餐管理系统</h1>
	<!--//header-->
	<!-- content -->
	<div class="main-content-agile">
		<div class="sub-main-w3">
			<form action="LoginAndRegisterServlet" method="post">
				<div class="welcome">
					<h2>顾客您好，欢迎登录</h2>
				</div>
				<HR style="border: 3 dashed #987cb9" width="100%" color=#987cb9
					SIZE=5>
				<HR style="border: 3 dashed #987cb9" width="100%" color=white
					SIZE=10>
				<input type="hidden" name="method" value="login">
				<div class="form-style-agile">
					<div class="pom-agile">
						<input placeholder="请输入账号" name="userid" type="text" required=""> 
					</div>
				</div>

				<div class="form-style-agile">
					<div class="pom-agile">
						<input placeholder="请输入密码" name="password" type="password"
							id="password1" required="" >
					</div>
				</div>
				<div class="form-style-agile">
					<div class="pom-agile">
						顾客： <input type="radio"  checked="checked" name="role" value="顾客" />
						管理员：<input type="radio" name="role" value="老板" />
					</div>
				</div>

				<div class="clear"></div>
				<input type="submit" value="登录"> <a
					href="LoginAndRegisterServlet?chose=register"
					style="float: right; height: 30px">没有账号？去注册</a>
			</form>
		</div>
	</div>
	<!-- //content -->

	<!-- password-script -->
	<script>
		window.onload = function() {
			document.getElementById("password1").onchange = validatePassword;
			document.getElementById("password2").onchange = validatePassword;
		}

		function validatePassword() {
			var pass2 = document.getElementById("password2").value;
			var pass1 = document.getElementById("password1").value;
			if (pass1 != pass2)
				document.getElementById("password2").setCustomValidity(
						"Passwords Don't Match");
			else
				document.getElementById("password2").setCustomValidity('');
			//empty string means no validation error
		}
	</script>
	<!-- //password-script -->

</body>

</html>