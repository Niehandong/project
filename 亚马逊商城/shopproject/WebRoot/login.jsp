<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>亚马逊 - 登录</title>
<link href="css/index.css" rel="stylesheet" type="text/css" />
<link href="css/adv.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script src="scripts/jquery-2.1.0.js" type="text/javascript"></script>
<script src="scripts/adv.js" type="text/javascript"></script>
<script type="text/javascript" src="scripts/function.js"></script>
<script type="text/javascript" src="scripts/index.js"></script>
</head>
<body>
<%@ include file="index_top.jsp"  %>
<div id="register" class="wrap">
	<div class="shadow">
		<em class="corner lb"></em>
		<em class="corner rt"></em>
		<div class="box">
			<h1>欢迎回到亚马逊</h1>
			<form id="loginForm" method="post" action="login" onsubmit="return loginCheck()">
				<table>
					<tr>
						<td class="field">用户名：</td>
						<td>
							<input class="text" type="text" name="userName" onfocus="FocusItem(this)" onblur="CheckItem(this);" />
							<span></span>
						</td>
					</tr>
					<tr>
						<td class="field">登录密码：</td>
						<td><input class="text" type="password" id="passWord" name="passWord" onfocus="FocusItem(this)" onblur="CheckItem(this);" />
							<a href="retrieve_password.jsp">忘记密码</a>
							<span></span>
						</td>
					</tr>					
					<tr>
						<td></td>
						<td><label class="ui-green"><input type="submit" name="submit" value="立即登录" /></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2016 oracle All Rights Reserved
</div>
</body>
</html>
