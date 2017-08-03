<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	
<title>Online Order Platform</title>


<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="${pageContext.request.contextPath}/backEnd/detail/style/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/backEnd/detail/style/js/page_common.js"></script>
<link href="${pageContext.request.contextPath}/backEnd/detail/style/css/common_style_blue.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/backEnd/detail/style/css/index_1.css" />
</head>
<body>
<!-- Page Title -->
<div id="TitleArea">
	<div id="TitleArea_Head"></div>
	<div id="TitleArea_Title">
		<div id="TitleArea_Title_Content">
			<img border="0" width="13" height="13" src="${pageContext.request.contextPath}/backEnd/detail/style/images/title_arrow.gif"/> Table List
		</div>
    </div>
	<div id="TitleArea_End"></div>
</div>


<!-- Filter -->
<div id="QueryArea">
	<form action="${pageContext.request.contextPath}/table/search.do" method="post">
		<input type="hidden" name="method" value="search">
		<input type="text" name="key" title="Input table name">
		<input type="submit" value="Search">
	</form>
</div>


<!-- List Table-->
<div id="MainArea">
    <table class="MainArea_Content" cellspacing="0" cellpadding="0">
        <!-- Table Head-->
        <thead>
            <tr align="center" valign="middle" id="TableTitle">
				<td>ID</td>
				<td>Table Name</td>
				<td>Status</td>
				<td>Capacity</td>
				<td>Order Time</td>
				<td>Action</td>
			</tr>
		</thead>	
		<!--Data List -->
        <tbody id="TableData">

		<c:choose>
			<c:when test="${not empty requestScope.tableList}">
				<c:forEach var="item" items="${requestScope.tableList}">
					<tr class="TableDetail1">
						<td align="center">${item.id}&nbsp;</td>
						<td align="center"> ${item.name}&nbsp;</td>
						<c:choose>
							<c:when test="${item.status eq 'IDLE'}">
								<td align="center">IDLE</td>
							</c:when>
							<c:when test="${item.status eq 'RESEVERED'}">
								<td align="center">RESEVERED</td>
							</c:when>
							<c:otherwise>
								<td align="center">UNAVAIBLE</td>
							</c:otherwise>
						</c:choose>
						<td align="center"> ${item.maxCapacity}&nbsp;</td>
						<td align="center"><fmt:formatDate value="${item.reserveDate}" type="both"></fmt:formatDate> </td>
						<td align="center">
							<c:choose>
								<c:when test="${item.status eq 'IDLE'}">
									<a href="${pageContext.request.contextPath}/table/reserve/${item.id}.do" class="FunctionButton">Reserve</a>
								</c:when>
								<c:when test="${item.status eq 'RESEVERED'}">
									<a href="${pageContext.request.contextPath}/table/cancel/${item.id}.do" class="FunctionButton">Cancel</a>
								</c:when>
							</c:choose>
							<a href="${pageContext.request.contextPath}/table/delete/${item.id}.do" onClick="return delConfirm();"class="FunctionButton">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="5">No Data in Database</td>
				</tr>
			</c:otherwise>
		</c:choose>

        
        </tbody>
    </table>
	
   <!-- Add Function -->
	<div id="TableTail" align="center">
		<div class="FunctionButton"><a href="${pageContext.request.contextPath}/backEnd/detail/saveBoard.jsp">Add</a></div>
    </div> 
</div>
</body>
</html>
