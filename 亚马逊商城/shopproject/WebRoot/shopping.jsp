<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>亚马逊- 购物车</title>
<link href="css/index.css" rel="stylesheet" type="text/css" />
<link href="css/adv.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script src="scripts/jquery-2.1.0.js" type="text/javascript"></script>
<script src="scripts/adv.js" type="text/javascript"></script>
<script type="text/javascript" src="scripts/function.js"></script>
<script type="text/javascript" src="scripts/index.js"></script>
<script type="text/javascript" src="scripts/shopping.js"></script>
</head>
<body>
<%@ include file="index_top.jsp"  %>

<div id="position" class="wrap">
	您现在的位置：<a href="index.jsp">亚马逊</a> &gt; 购物车
</div>
<div class="wrap">
	<div id="shopping">
		<form action="doBuy" method="post">
			<table>
				<tr>
					<th>商品名称</th>
					<th>商品价格</th>
					<th>购买数量</th>
					<th>操作</th>
				</tr>
				
				
				<!-- 根据用户购物车生成列表 -->
				<c:forEach items="${requestScope.shoppingList }" var="shopping">
				<tr id="product_id_1">
					<td class="thumb">
						<img style="width: 100px; height: 100px;" src="${shopping.hpFileName }" />
						<a href="pview?pId=${shopping.hpId }">${shopping.hpName }</a>
					</td>
					
					<td class="price" id="price_id_1">
						￥<span id="span_1">${shopping.hpPrice }</span>
						<input type="hidden" id="subPrice" value="${shopping.hpPrice*shopping.quantity }" name="sumPrice"/>
						<input type="hidden"  value="${shopping.hpId }" name="pId"/>
						<input type="hidden"  value="${shopping.hpStock }" name="hpStock" id="hpStock${shopping.hcId }"/>						
					</td>
					
					<td class="number">
							<c:set var="hcid" value="${shopping.hcId }"></c:set>
							
							<input type="button" id="minus" value=" - " width="3px" onclick=" reduce(${hcid })" name="minusButton">
							<input id="${hcid }" type="text" name="number" value="${shopping.quantity }" maxlength="5"
							size="1"  style="text-align:center; vertical-align:middle" onblur="checkStock(${hcid })"/>
							<input type="button" id="add" value=" + " width="2px" onclick=" increase(${hcid })" name="addButton">		
							
					</td>
					<td class="delete"><a href="deleteCart?${shopping.hcId }">删除</a></td>
				</tr>
				</c:forEach>
			</table>
			<div class="button"><input type="submit" value="" /></div>
		</form>
	</div>
</div>
<div id="footer">
	Copyright &copy; 2016 oracle All Rights Reserved.
</div>
</body>
</html>

