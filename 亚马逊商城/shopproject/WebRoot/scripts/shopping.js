
//-按钮事件
function reduce(id){
	alert(id);
	if($("#"+id).val()==1){
		$("#"+id).val(1);
	}else if($("#"+id).val()>=2){
		var old=$("#"+id).val();
		alert(old);
		$("#"+id).val(parseInt(old)-1);
	}
	alert("id"+id);
	alterCount(id);
	alert("减少结束");
}

//+按钮事件
function increase(id){	
	var stock=$("#hpStock"+id).val();//获得库存
	var old=$("#"+id).val();//获得原来的数量
	if(parseInt(old)<parseInt(stock)){
		$("#"+id).val(parseInt(old)+1);
		alert("id"+id);
		alterCount(id);
		alert("添加结束");
	}else{
		alert("您选择的数量超过库存!");
	}	
}

function checkStock(id){
	var stock=$("#hpStock"+id).val();//获得库存
	var old=$("#"+id).val();//获得原来的数量
	if(parseInt(old)>parseInt(stock)){
		alert("您选择的数量超过库存!");
	}else{
		alterCount(id);
	}
}

function buttonTest(id) {
	alert("测试id="+id);
}











