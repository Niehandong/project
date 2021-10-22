
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>亚马逊-首页</title>
<link href="css/index.css" rel="stylesheet" type="text/css" />
<link href="css/adv.css" rel="stylesheet" type="text/css" />
<!-- 图片轮播器 -->
<script src="scripts/jquery-2.1.0.js" type="text/javascript"></script>
<script src="scripts/adv.js" type="text/javascript"></script>
<script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>
	<%@ include file="index_top.jsp"%>
	<div id="middle">
		<div class="p_left">
			<!--商品分类-->
			<%@ include file="index_product_sort.jsp"%>
			<!--商品分类结束-->

			<div class="pre_look">
				<h3>最近浏览</h3>
				<dl>
					<!-- end=3 表示只能显示下标从0到3的数据 默认start=0-->
					<c:forEach items="${sessionScope.viewedProduct }" var="p" end="3">
						<dt>
							<img style="width: 54px; height: 54px;" src="${p.hpFileName }" />
						</dt>
						<dd>
							<a href="pview?pId=${p.hpId }">${p.hpName }</a>
						</dd>
					</c:forEach>
				</dl>
			</div>
		</div>

		<div class="p_center">
			<!-- 图片轮播器 -->
			<div id="wrapper">
				<div id="focus">
					<ul>
						<li><a href="#"><img src="images/T1.jpg" /> </a>
						</li>
						<li><a href="#"><img src="images/T2.jpg" /> </a>
						</li>
						<li><a href="#"><img src="images/T3.jpg" /> </a>
						</li>
						<li><a href="#"><img src="images/T4.jpg" /> </a>
						</li>
						<li><a href="#"><img src="images/T5.jpg" /> </a>
						</li>
					 </ul>
				</div>
			</div>
			<div class="p_list">
				<div class="p_info">
					<img src="images/icon_sale.png" />商品列表
				</div>
			</div>

			<ul class="product2">
				<c:if test="${requestScope.pageModel.getTotalPage()==0}">
					<h4>找不到您搜索的商品！</h4>
				</c:if>
				<c:forEach items="${requestScope.pageModel.list}" var="p">
					<li>
						<dl>
							<dt>
								<a href="pview?pId=${p.hpId }">
									<img src="${p.hpFileName }" />
								</a>
							</dt>
							<dd class="title">
								<a href="pview?pId=${p.hpId}">${p.hpName }</a>
							</dd>
							<dd class="price">￥${p.hpPrice}</dd>
						</dl>
					</li>
				</c:forEach>
			</ul>

			<!-- 自己写的分页 -->
			<div class="pager">
				<ul>
					<li>
						<a href="ref?page=${pageModel.getPrePage() }&source=${pageModel.source }&hpcId=${pageModel.hpcId}&qname=${pageModel.qname}">上一页</a>
					</li>
						<c:forEach items="${pageModel.pageList }" var="num">
						<li>
							<a href="ref?page=${num }&source=${pageModel.source }&hpcId=${pageModel.hpcId}&qname=${pageModel.qname}">${num }</a>
						</li>
					</c:forEach>
					<li>
						<a href="ref?page=${pageModel.getNextPage() }&source=${pageModel.source }&hpcId=${pageModel.hpcId}&qname=${pageModel.qname}">下一页</a>
					</li>					
				</ul>				
			</div>
		</div>


		<div id="p_right">
			<%@ include file="index_news.jsp"%><!-- 新闻动态 -->
			<%@ include file="hotproduct.jsp"%><!-- 热卖推荐 -->
		</div>
	</div>

	<div id="foot">Copyright © 2016 oracle All Rights Reserved.</div>
</body>
</html>

