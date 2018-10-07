<%@ page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" errorPage="/error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>连接数据库脚本测试</title>
</head>
<body>

	<%--@ include file="menu.jsp" --%>
	<jsp:include page="menu.jsp"></jsp:include>
	<table>

		<tr>
			<th>Column1</th>
			<th>Column2</th>
		</tr>
		今天的日期是:<%=new Date()%>
		<%
			for (int i = 0; i < 10; i++) {
		%>
		<tr>
			<td>value1</td>
			<td>value2</td>
		</tr>
		<%
			}
		%>
	</table>
	<%!public void jspInit() {
		System.out.print("this is jspInit");
	}

	public void jspDestroy() {
		System.out.print("desisas");
	}%>
	
	<%
		int i = 1/0;
	%>
</body>
</html>