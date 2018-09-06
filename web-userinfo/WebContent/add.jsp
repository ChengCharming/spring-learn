<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加成绩</title>
</head>
<body>
	<div align="center">

		请输入各项成绩
		<form action="AddServlet" method="Post">
			数学成绩：<input type="text" name="math" /></br> 语文成绩：<input type="text"
				name="chinese" /></br> 英语成绩：<input type="text" name="english" /></br> <input
				type="submit" value="确认" />
		</form>

		<form action="add.jsp" method="Post">
			<input type="submit" value="重置" />
		</form>
		<form action="main.jsp" method="Post">
			<input type="submit" value="返回" />
		</form>
		<c:if test="${err != null }">
		${err}
	</c:if>

	</div>
</body>
</html>