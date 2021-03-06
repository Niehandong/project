<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>亚马逊 - 产品显示</title>
<link href="css/index.css" rel="stylesheet" type="text/css" />
<link href="css/adv.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script src="scripts/jquery-2.1.0.js" type="text/javascript"></script>
<script src="scripts/adv.js" type="text/javascript"></script>
<script type="text/javascript" src="scripts/function.js"></script>
<script type="text/javascript" src="scripts/index.js"></script>
<script type="text/javascript" src="scripts/product_view.js"></script>


</head>
<body>
	<%@ include file="index_top.jsp"%>
	<div id="position" class="wrap">
		<c:set value="${requestScope.categoryForProduct}" var="s"></c:set>
		您现在的位置：<a href="index.jsp">亚马逊</a> &gt; <a
			href="category?cate=parent&hpcId=${s[0] }">${s[1] }</a> &gt; <a
			href="category?cate=child&hpcId=${s[2] }">${s[3] }</a>
	</div>
	<div id="main" class="wrap">
		<div class="lefter">
			<%@ include file="index_product_sort.jsp"%>
		</div>
		<div id="product" class="main">
			<c:set var="p" value="${requestScope.productInfo }"></c:set>
			<h1>商品名称:${p.hpName }</h1>
			<div class="infos">
				<div class="thumb">
					<img style="width: 100px; height: 100px;" src="${p.hpFileName }" />
				</div>
				<div class="buy">
					<p>
						商城价：<span class="price">￥${p.hpPrice }</span>
					</p>
					<c:choose>
						<c:when test="${p.hpStock>0 }">
							<p>
								库 存：<span id="stock">${p.hpStock }</span>(有货)
							</p>
						</c:when>
						<c:otherwise>
							<p>库 存：无货
						</c:otherwise>
					</c:choose>
					<input type="button" id="minus" value=" - " width="3px"	onclick="minus();">
					<input type="text" id="count"	name="count" onblur="checkStock()" value="1" maxlength="5"
						size="1" style="text-align: center; vertical-align: middle">
					<input type="button" id="add" value=" + " width="2px" onclick="add();">
					<c:choose>
						<c:when test="${sessionScope.user==null }">
							<div class="button">
								<input type="button" name="button" value="" onclick="remaind();"
									style="background: url(images/buyNow.png)" /> 
									<input type="image"	name="imageField" 
										src="images/cartbutton.png" onclick="remaind()" />
							</div>

						</c:when>
						<c:otherwise>
							<div class="button">
							 	<!-- 这里是立即购买的图片 -->
								<input type="button" name="button" value=""	onclick="goingToBuy(${p.hpId });" 
									style="background: url(images/buyNow.png)" />
								<!-- 这里是加入购物车的图片 -->
								<input type="image"	name="imageField" src="images/cartbutton.png"
									onclick="addToCart(${p.hpId });" />
							</div>
						</c:otherwise>
					</c:choose>

				</div>
				<div class="clear"></div>
			</div>
			<div class="introduce">
				<h2>
					<strong>商品详情</strong>
				</h2>
				<div class="text">
					商品名字：${p.hpName }<br /> 商品描述：${p.hpDescription }<br />
					商品价格：￥${p.hpPrice }<br /> 商品库存：${p.hpStock }<br />
				</div>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div id="footer">Copyright &copy; 2016 oracle All Rights Reserved.
	</div>
</body>
</html>

