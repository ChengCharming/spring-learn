<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
</head>
<body>
	
</br></br></br></br>
<div align="center">
	
	<hr/>
	<form action="login" method="Post">
	用户名：<input type="text" name="username"/></br>
	密码：<input type ="text" name="password"/></br>
	<input type="submit" value="登录"/>
	</form>
	
	<form action="index.jsp" method ="Post">
	<input type="submit" value="重置"/>
	</form>
	
	<form action="sign.jsp" method ="Post">
	<input type="submit" value="注册"/>
	</form>
	
	<c:if test="${err != null }">
		${err}
	</c:if>
</div>
</body>
</html>