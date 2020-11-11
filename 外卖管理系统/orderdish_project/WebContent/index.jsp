<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜单浏览</title>
</head>
<body>
	index success 欢迎 ${sessionScope.SESSION_user.userid}登录
	<br>
	<table width="100%" height="600px">
		<tr>
			<th>账号</th>
			<th>昵称</th>
			<th>密码</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${requestScope.userList}" var="u">
			<tr>
				<td>${u.userid}</td>
				<td>${u.nickname}</td>
				<td>${u.password}</td>
				<td>
				<a href="UserManagerServlet?userid=${u.userid}&method=delete">删除</a>
				&nbsp;
				<a href="UserManagerServlet?userid=${u.userid}&method=showDetail">查看详情</a>
				
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>