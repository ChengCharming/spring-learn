<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h2 align="center">
		<b>
		你总共进入了<%=session.getAttribute("count")%>次
		</b>
</h2>
<h1 align="center">
		<b>
		地球人总共进入了<%=session.getServletContext().getAttribute("allcount")%>次
		</b>
</h1>
