<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=session.getAttribute("userName") %></title>
</head>
<body>
<div align="center">
	</br></br></br></br></br>
	欢迎你，<%=session.getAttribute("userName") %>
		你的成绩为：</br>
		数学:<%=session.getAttribute("math") %>   
		语文:<%=session.getAttribute("chinese") %>   
		英语:<%=session.getAttribute("english") %>

<form action ="main.jsp" method="post">
<input type="submit" value="返回"/>
</form>
</div>
</body>
</html>