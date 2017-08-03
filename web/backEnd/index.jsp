<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Order Management</title>
</head>
	<frameset rows="100px,*,19px" framespacing="0" border="0" frameborder="0">
		<frame src="${pageContext.request.contextPath}/backEnd/detail/top.jsp" scrolling="no" noresize />
		<frameset cols="178px,*">
			<frame noresize src="${pageContext.request.contextPath}/backEnd/detail/left.jsp" scrolling="yes" />
			<frame noresize name="right" src="${pageContext.request.contextPath}/backEnd/detail/right.jsp" scrolling="yes" />
		</frameset>
		<frame noresize name="status_bar" scrolling="no" src="${pageContext.request.contextPath}/backEnd/detail/bottom.jsp" />
	</frameset>
	<noframes>
		<body>
			Your browser can not support this framework. You cant use<a href="http://www.firefox.com.cn/download/" style="text-decoration: none;">Foxfire Browser</a>,
			<a href="http://www.google.cn/intl/zh-CN/chrome/" style="text-decoration: none;">Google Browser</a>
		</body>
	</noframes>
</html>