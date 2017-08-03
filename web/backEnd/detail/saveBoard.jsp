<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	
<title>Online Order Platform</title>



<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="${pageContext.request.contextPath}/backEnd/detail/style/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/backEnd/detail/style/js/page_common.js"></script>
<link href="${pageContext.request.contextPath}/backEnd/detail/style/css/common_style_blue.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/backEnd/detail/style/css/index_1.css" />
    <script type="text/javascript">
	function openWin(){
		window.open('common_page_list.html');
		this.close();
	}
	</script>
</head>
<body>


<!-- Page Title -->
<div id="TitleArea">
	<div id="TitleArea_Head"></div>
	<div id="TitleArea_Title">
		<div id="TitleArea_Title_Content">
			<img border="0" width="13" height="13" src="${pageContext.request.contextPath}/backEnd/detail/style/images/title_arrow.gif"/>  Add New Table
		</div>
    </div>
	<div id="TitleArea_End"></div>
</div>


<!-- Data List -->
<div id="MainArea">
	<!-- Form -->
	<form action="${pageContext.request.contextPath}/table/add.do" method="post">

		<div class="ItemBlock_Title">
        	<img width="4" height="7" border="0" src="${pageContext.request.contextPath}/backEnd/detail/style/images/item_point.gif"> Table Info&nbsp;
        </div>

        <div class="ItemBlockBorder">
            <div class="ItemBlock">
				<div class="ItemBlock2">
					<table cellpadding="0" cellspacing="0" class="mainForm">
						<tr>
							<td width="80px">Table Name</td>
							<td><input type="text" name="name" class="InputStyle"/>*</td>
						</tr>
						<tr>
							<td width="80px">Capacity</td>
							<td><input type="text" name="maxCapacity" class="InputStyle"/>*</td>
						</tr>
					</table>
				</div>
            </div>
        </div>
		

		<div id="InputDetailBar">
            <input type="submit" value="Add" class="FunctionButtonInput">
            <a href="javascript:history.go(-1);" class="FunctionButton">Return</a>
        </div>
	</form>
	
</div>

</body>
</html>
