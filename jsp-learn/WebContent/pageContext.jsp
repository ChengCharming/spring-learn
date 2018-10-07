<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
//使用pageContext向其它域 存取 数据

request.setAttribute("name", "charMing");
pageContext.setAttribute("name", "jinnan", PageContext.REQUEST_SCOPE);
pageContext.setAttribute("name", "jinnan", PageContext.SESSION_SCOPE);
pageContext.setAttribute("name", "jinnan", PageContext.APPLICATION_SCOPE);

%>
<%=request.getAttribute("name")%>
<%=pageContext.getAttribute("name",PageContext.REQUEST_SCOPE)%>

<jsp:include page="/error.jsp"></jsp:include>
</body>
</html>