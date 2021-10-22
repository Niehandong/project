//点击加入购物车的时候触发的函数
function addToCart(pid) {
	
	var stock=$("#stock").html();//获取数据库中商品的实际库存量
	var count=$("#count").val();//获取页面输入的商品的库存量
	
	if(parseInt(count)>parseInt(stock)){
		alert("您选择的数量超过库存!");
	}else{
		$.ajax({
			url : "addToCart",// 请求的servlet地址
			type : "GET",// 请求方式
			data : "" + pid+"_"+count,// 发送到服务器的数据
			dataType : "text",// 设置返回数据类型
			success : function(total) {
				$("#cartCount").html(total);
				alert("成功添加到购物车!");
			},// 响应成功后执行的回调方法data响应文本			
			error : function(XMLHttpRequest, statusText) {
				alert("添加到购物车失败!");
			}// 响应失败后执行的回调方法
		});
	}

}
//用户已经登录以后，直接找到商品，点击立即购买的时候触发的函数
function goingToBuy(pid) {
	window.location.href="goingToBuy?"+pid+"_"+$("#count").val();
}

//-按钮事件，用于减少购买数量
function minus(){

	if($("#count").val()==1){
		$("#count").val(1);
	}else if($("#count").val()>=2){
		var old=$("#count").val();
		$("#count").val(parseInt(old)-1);
	}
}

//+按钮事件，用于增加购买数量
function add(){
	var stock=$("#stock").html();
	var old=$("#count").val();
	if(parseInt(old)<parseInt(stock)){
		$("#count").val(parseInt(old)+1);
	}else{
		alert("您选择的数量超过库存!");
	}
	
}


//当直接输入购买数量的时候，鼠标离开的时候触发的函数
function checkStock(){
	var stock=$("#stock").html();//获取数据库中商品的实际库存数量
	var old=$("#count").val();//获取前端页面输入的商品购买数量
	if(parseInt(old)>parseInt(stock)){
		alert("您选择的数量超过库存!");
	}
}


//用户如果没有登录，点击立即购买的时候触发的函数
function remaind() {
	alert("请先登录亚马逊！");
	window.location.href="login.jsp";
}




