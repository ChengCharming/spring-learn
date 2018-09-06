<%@ page import="java.util.*"%>
<%@ page import="com.qingke.bean.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="ex" uri="WEB-INF/mytag.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test2</title>
</head>
<body>

	<p2>自定义标签:</p2>

	</br>
	<ex:Hello />
	</br>


	<ex:HelloBody>
		hello this is my body tag
	</ex:HelloBody>
	</br>
	

	<ex:HelloAttrTag>
		ooooo
	</ex:HelloAttrTag>
	</br>

	
	<jsp:useBean id="testUseBean" class="com.qingke.bean.TestUseBean"
		scope="request">
		<jsp:setProperty property="name" value="charming1" name="testUseBean" />
		<jsp:getProperty property="name" name="testUseBean" /></br>
	</jsp:useBean>


	<%
		TestUseBean test2 = new TestUseBean();
		test2.setName("charming2");
	%>


		<%=test2.getName()%></br>


	p1:${param.p1}</br>
	p2:<%=request.getParameter("p2")%></br>


	<%
		String sid = session.getId();
		String value = (String) session.getAttribute("key1");
		if (value == null) {
			out.println("has no value for key1");
		} else {
			out.println("has the value for key1 is<p>" + value);
		}
		session.setAttribute("key1", "new value" + Calendar.getInstance().getTimeInMillis());
		value = (String) session.getAttribute("key1");
		out.println("</br>has the new value for key1 is" + value);
		session.removeAttribute("key1");
	%>
	
</body>
</html>