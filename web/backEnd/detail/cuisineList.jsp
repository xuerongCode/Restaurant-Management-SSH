<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

	
<title>Order Platform</title>



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
					src="${pageContext.request.contextPath}/backEnd/detail/style/images/title_arrow.gif" /> Cuisine List
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>

	<div id="QueryArea">
		<form action="${pageContext.request.contextPath}/cuisine/search.do" method="post">
			<input type="hidden" name="method" value="search">
			<input type="text" name="name" title="Input Food Type">
			<input type="submit" value="Search">
		</form>
	</div>


	<div id="MainArea">
		<table class="MainArea_Content" align="center" cellspacing="0" cellpadding="0">

			<thead>
				<tr align="center" valign="middle" id="TableTitle">
					<td>Cuisine ID</td>
					<td>Cuisine Type</td>
					<td>Action</td>
				</tr>
			</thead>

			<tbody id="TableData">
				
					<c:choose>
						<c:when test="${not empty requestScope.cuisineList}">
							<c:forEach var="item" items="${requestScope.cuisineList}">
								<tr>
									<td>${item.id}</td>
									<td>${item.name}</td>
									<td>
										<a href="${pageContext.request.contextPath}/cuisine/updateView/${item.id}.do" class="FunctionButton">Update</a>
										<a href="${pageContext.request.contextPath}/cuisine/delete/${item.id}.do" class="FunctionButton">Delete</a>
									</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="3">No Date Record</td>
							</tr>
						</c:otherwise>
					</c:choose>
				
			</tbody>
		</table>

		<div id="TableTail" align="center">
			<div class="FunctionButton">
				<a href="${pageContext.request.contextPath}/backEnd/detail/saveCuisine.jsp">ADD</a>
			</div>
		</div>
	</div>
</body>
</html>
