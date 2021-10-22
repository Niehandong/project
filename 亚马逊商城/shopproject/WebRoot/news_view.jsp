<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>亚马逊 - 新闻显示</title>
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
<div id="position" class="wrap">
	您现在的位置：<a href="ProductServlet">亚马逊</a> &gt; 阅读新闻
</div>
<div id="main" class="wrap">
	<div class="left-side">
		<%@ include file="index_news.jsp" %>
	</div>
	<div id="news" class="right-main">
		<c:set var="news" value="${requestScope.newsInfo }"></c:set>
		<h1>标题：${news.hnTitle }</h1>
		<div class="content">
			<p style="text-align: right;">创建时间：${news.hnCreateTime }</p>
			内容：${news.hnContent }			
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2016 oracle All Rights Reserved.
</div>
</body>
</html>

