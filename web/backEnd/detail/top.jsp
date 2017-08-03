<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Frame top</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/backEnd/detail/style/js/jquery.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/backEnd/detail/style/js/page_common.js"></script>
    <link href="${pageContext.request.contextPath}/backEnd/detail/style/css/common_style_blue.css" rel="stylesheet" type="text/css" />
	
	<style type="text/css">
<!--
body {
margin: 0;
}
#Head_1 {
    background: url("${pageContext.request.contextPath}/backEnd/detail/style/images/img/top_head1_bg.gif") repeat-x scroll 0 0 transparent;
    height: 64px;
    margin: 0 auto;
    width: 100%;
}
#Head_1 #Head_1_Logo {
	float: left;
    left: 20px;
    position: absolute;
    top: 12px;
	color: #F1F9FE;
    font-family: Arial Black,Arial;
    font-size: 28px;
}
#Head_1 #Head_1_UserWelcome {
    float: right;
    color: #B3E1FF;
    font-family: "monospace";
    font-size: 12px;
    height: 25px;
	padding-top: 11px;
	margin-right: 20px;
}
#Head_1 #Head_1_FunctionButton {
    float: left;
    position: absolute;
    right: 5px;
    top: 35px;
	margin-right: 15px;
}
#Head_1 #Head_1_FunctionButton img {
margin-left: 10px;
}
#Head_2 {
   background: url("${pageContext.request.contextPath}/backEnd/detail/style/images/img/top_head2_bg.gif") repeat-x scroll 0 0 transparent;
    border-bottom: 1px solid #FFFFFF;
    border-top: 1px solid #A0C6E1;
    height: 36px;
    margin: 0;
    width: 100%;
}
#Head_2 #Head2_Awoke {
	float: left;
    height: 100%;
    padding-left: 19px;
    padding-top: 2px;
}
#Head_2 #Head2_Awoke #AwokeNum {
	position: absolute;
	left: 20px;
	top: 68px;	
	width: 406px;
	/*height: 21px;*/
	margin-top: 0;
	padding: 0;
	padding-top: 2px;
	list-style-type: none;
	margin-bottom: 0;
	margin-left: 0;
}
#Head_2 #Head2_Awoke #AwokeNum li {
  float: left;
    margin: 3px;
	display: inline;
}
#Head_2 #Head2_Awoke #AwokeNum a {
   color: #FFFFFF;
    font-family: "monospace";
    font-size: 12px;
    text-decoration: none;
}
#Head_2 #Head2_Awoke #AwokeNum .Line {
    border-left: 1px solid #005A98;
    border-right: 1px solid #A0C6E1;
    height: 17px;
    width: 0px;
}
#Head_2 #Head2_FunctionList, .Head2_FunctionList {
    color: #FFFFFF;
    float: right;
    font-family: "monospace";
    font-size: 13px;
    height: 100%;
    padding-right: 26px;
    padding-top: 10px;
}
-->
	</style>
</head>

<body>
 	

	<div id="Head_1">

		<div id="Head_1_Logo">
			<b style="font-family: '黑体'">Restaurant Information Management Platform</b> <!-- <img border="0" src="style/images/logo.png" /> -->
        </div>

		<div id="Head_1_UserWelcome">
			<img border="0" width="13" height="14" src="${pageContext.request.contextPath}/backEnd/detail/style/images/user.gif" />
			Hello，<b>Administrator</b>
		</div>

		<div id="Head_1_FunctionButton">
			<a target="right" href="javascript:void(0)">
				<img width="78" height="20" src="${pageContext.request.contextPath}/backEnd/detail/style/images/help2.gif" />
			</a>
			<a target="_parent" href="javascript:void(0)">
				<img width="78" height="20" alt="Exit System" src="${pageContext.request.contextPath}/backEnd/detail/style/images/logout.gif" />
			</a>
		</div>
	</div>

    <div id="Head_2">

        <div id="Head2_Awoke">
			<ul id="AwokeNum">
				
            </ul>
		</div>
		
		<div class="Head2_FunctionList" style="float:left">
			<a href="javascript: window.parent.right.history.back();">
				<img src="${pageContext.request.contextPath}/backEnd/detail/style/images/Header_back.gif" width="24" height="24" style="margin-top: -8px;"/>
				<b>Back</b>
			</a>
			<a href="javascript: window.parent.right.history.forward();">
				<img src="${pageContext.request.contextPath}/backEnd/detail/style/images/Header_forward.gif" width="24" height="24" style="margin-top: -8px;"/>
				<b>Forward</b>
			</a>
        </div>
        
		<div id="Head2_FunctionList">

			<a href="javascript: window.parent.right.history.go(0);">
				<img src="${pageContext.request.contextPath}/backEnd/detail/style/images/Header_refresh.gif" width="24" height="24" style="margin-top: -8px;"/>
				<b>Refresh(IE、Chrome)</b>
			</a>
			<a href="javascript: window.parent.right.location.reload(true);">
				<img src="${pageContext.request.contextPath}/backEnd/detail/style/images/Header_refresh.gif" width="24" height="24" style="margin-top: -8px;"/>
				<b>Refresh(Firefox)</b>
			</a>
		</div>
	</div>
</body>
</html>