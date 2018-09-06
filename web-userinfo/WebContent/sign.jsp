<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>	

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
</head>
<body>
	
</br></br></br></br>
<div align="center">
	
	<hr/>
	<form action="SignServlet" method="Post">
	用户名：<input type="text" name="userName"/></br>
	密码：<input type ="password" name="password"/></br>
	<input type="submit" value="注册"/>
	</form>
	<form action="index.jsp" method="Post">
	<input type ="submit" value="返回登录">
	</form>

	<c:if test="${err != null }">
		${err}
	</c:if>
</div>
</body>
</html>