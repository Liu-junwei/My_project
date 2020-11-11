
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html lang="zxx">

<head>
<title>注册界面</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8" />
<link rel="icon" href="https://s2.ax1x.com/2019/12/12/QyHjXT.jpg" type="image/x-icon" />
<meta name="keywords"
	content="Classic Register Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />

<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />

</head>

<body>
	<!--header-->
	<h1>
		订餐管理系统
	</h1>
	<!--//header-->
	<!-- content -->
	<div class="main-content-agile">
		<div class="sub-main-w3">
			
			<form action="LoginAndRegisterServlet" method="post">
				<div class="welcome">
					<h2>尊敬的顾客，快来注册属于您的美食账号</h2>
				</div>
			<HR style="border:3 dashed #987cb9" width="100%" color=#987cb9 SIZE=3>

			<input type="hidden" name="method" value="register">
				<div class="form-style-agile">
					<div class="pom-agile">
						<input placeholder="请输入账号" name="userid" type="text"
							required="">
					</div>
				</div>
				<div class="form-style-agile">
					<div class="pom-agile">
						<input placeholder="请输入昵称" name="nickname" type="text"
							required=""> 
					</div>
				</div>

				<div class="form-style-agile">
					<div class="pom-agile">
						<input placeholder="请输入密码" name="password" type="password"
							id="password1" required=""> 
					</div>
				</div>
				
				<div class="form-style-agile">
					<div class="pom-agile">
						<input placeholder="确认密码" name="Confirm Password"
							type="password" id="password2" required="">
					</div>
				</div>
				<div class="clear"></div>
				<input type="submit" value="注册用户">
				<a href="LoginAndRegisterServlet?chose=login" style="float:right;height:30px">已有账号？去登录</a>
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
						"两次密码输入不一致");
			else
				document.getElementById("password2").setCustomValidity('');
			//empty string means no validation error
		}
	</script>
	<!-- //password-script -->

</body>

</html>