<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=session.getAttribute("userName")%></title>
</head>
<body>
	<%
		if (session.getAttribute("userName") == null) {
			response.sendRedirect("index.jsp");
		}
	%>
	<div align="center">
		</br>
		</br>
		</br>
		</br>
		</br> 欢迎你，<%=session.getAttribute("userName")%>
		</br>
		<form action="ReadServlet" method="post">
			<input type="submit" value="查看成绩" />
		</form>
		<form action="add.jsp" method="post">
			<input type="submit" value="添加成绩" />
		</form>
		<form action="logout.jsp" method="post">
			<input type="submit" value="退出" />
		</form>
		<c:if test="${err != null }">
		${err}
	</c:if>
	</div>



</body>
</html>