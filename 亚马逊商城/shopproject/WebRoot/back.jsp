<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'back.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<!-- 注意带上作用域，因为可能别的作用域中也有user -->
  	<c:if test="${requestScope.user!=null }">
	   	<p>&nbsp;密码已找回，请记录：${user.getPassword() }</p>
	   	<p><a href="login.jsp">返回登录页面</a></p>
   	</c:if>
   	<c:if test="${requestScope.user==null }">
	   	<p>&nbsp;用户名或邮箱不正确，请重新填写</p>
	   	<p><a href="retrieve_password.jsp">返回找回密码页面</a></p>
   	</c:if>
  </body>
</html>
