<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆页面</title>

</head>
<body> 
<form action="${pageContext.request.contextPath }/login.action" method="post">
	<table align="center" width="100" height="100">
		用户名：<input type="text" name="username" value="请输入用户名" />
		<input type="submit" value ="提交"/>
	</table>
</form>
</body>

</html>