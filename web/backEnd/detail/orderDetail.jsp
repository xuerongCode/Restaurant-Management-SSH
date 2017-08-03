<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

	
<title>Online Order</title>



<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="${pageContext.request.contextPath}/backEnd/detail/style/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/backEnd/detail/style/js/page_common.js"></script>
<link href="${pageContext.request.contextPath}/backEnd/detail/style/css/common_style_blue.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/backEnd/detail/style/css/index_1.css" />
</head>
<body>

	<div id="TitleArea">
		<div id="TitleArea_Head"></div>
		<div id="TitleArea_Title">
			<div id="TitleArea_Title_Content">
				<img border="0" width="13" height="13"
					src="${pageContext.request.contextPath}/backEnd/detail/style/css/images/title_arrow.gif" /> Order Detail
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>


	<div id="MainArea">
		<table class="MainArea_Content" align="center" cellspacing="0" cellpadding="0">
			<thead>
				<tr align="center" valign="middle" id="TableTitle">
					<td>Dish</td>
					<td>Price</td>
					<td>Amount</td>
				</tr>
			</thead>

			<tbody id="TableData">

					<c:forEach var="item" items="${requestScope.order.midOrderDishSet}">
						<tr height="30">
							<td>${item.dish.name}</td>
							<td>${item.dish.price}</td>
							<td>${item.amount}</td>
						</tr>
					</c:forEach>

			 	
			</tbody>
		</table>

		<div id="TableTail" align="center">
			 <a href="javascript:history.go(-1);" class="FunctionButton">Return</a>
		</div>
	</div>
</body>
</html>
