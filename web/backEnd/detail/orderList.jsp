<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

	
<title>Online Order</title>



<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="${pageContext.request.contextPath}/backEnd/detail/style/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/backEnd/detail/style/js/page_common.js"></script>
<link href="${pageContext.request.contextPath}/backEnd/detail/style/css/common_style_blue.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/backEnd/detail/style/css/index_1.css" />
	<script type="text/javascript">
		setInterval(function(){
			window.location.href = "${pageContext.request.contextPath}/order/list.do";
		},1000 * 50);
	</script>
</head>
<body>

	<div id="TitleArea">
		<div id="TitleArea_Head"></div>
		<div id="TitleArea_Title">
			<div id="TitleArea_Title_Content">
				<img border="0" width="13" height="13"
					src="style/images/title_arrow.gif" /> Order List
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>


	<div id="MainArea">
		<table class="MainArea_Content" align="center" cellspacing="0" cellpadding="0">

			<thead>
				<tr align="center" valign="middle" id="TableTitle">
					<td>Order Id</td>
					<td>Table Name</td>
					<td>Order Place Time</td>
					<td>Price</td>
					<td>Status</td>
					<td>Action</td>
				</tr>
			</thead>

			<tbody id="TableData">

					<c:forEach var="item" items="${requestScope.orders}">
						<tr height="30">
							<td>${item.id}</td>
							<td>
								<c:choose>
									<c:when test="${ not empty item.table.name and item.table.name ne '' }">${item.table.name }</c:when>
									<c:otherwise>To Go Order</c:otherwise>
								</c:choose>
							</td>
							<td><fmt:formatDate value="${item.placedDate}" type="both"></fmt:formatDate></td>
							<td>${item.orderSummary}</td>
							<td>${item.status}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							</td>
							<td>
								<a href="${pageContext.request.contextPath}/order/detail/${item.id}.do" class="FunctionButton">Detail</a>
								<a href="#" class="FunctionButton">Bill</a>
							</td>
						</tr>
					</c:forEach>
			</tbody>
		</table>
		<div id="TableTail" align="center">
		</div>
	</div>
</body>
</html>
