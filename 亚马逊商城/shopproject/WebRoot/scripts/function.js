// JavaScript Document

//登录时，表单提交触发的函数
function loginCheck(){
	
	if($("[name=userName]").val()==""){
		alert("请输入用户名！")
		return false;
	}
	
	if($("[name=passWord]").val()==""){
		alert("请输入用户密码！")
		return false;
	}	
}

//注册页面的时候，表单提交调用的函数
function checkForm(frm) {
	var els = frm.getElementsByTagName("input");

	for (var i = 0; i < els.length; i++) {
		
			if (!CheckItem(els[i])){
				return false;
			}
	}
	return true;
}

//当输入框获取焦点的时候，清空对验证的提示信息
function FocusItem(obj) {
	obj.parentNode.parentNode.className = "current";
	var msgBox = obj.parentNode.getElementsByTagName("span")[0];
	msgBox.innerHTML = "";
	msgBox.className = "";
}



//登录，注册时，对表单中的各input输入框内容的验证
function CheckItem(obj) {
	obj.parentNode.parentNode.className = "";
	var msgBox = obj.parentNode.getElementsByTagName("span")[0];
	var regEmail = /^\w+@\w+(\.[a-zA-Z]{2,3}){1,2}$/;   //xiaoye@qq.com  xiao@123.com.cn
	var regIdentity = /(^\d{15}$)|(^\d{17}([0-9]|X)$)/;  //验证身份证
	var regMobile = /^1\d{10}$/;  //手机号验证
	var regBirth = /^((19\d{2})|(200\d))-(0?[1-9]|1[0-2])-(0?[1-9]|[1-2]\d|3[0-1])$/; // 1999-11-10
	var regName = /^[a-zA-Z][a-zA-Z0-9]{3,15}$/; //用户名验证
	var regPass = /^[a-zA-Z0-9]{4,10}$/; //密码验证
	switch (obj.name) {
	case "userName":
		if (obj.value == "" || regName.test(obj.value) == false) {
			msgBox.style.display = "inline";
			msgBox.innerHTML = "用户名不能为空并且只能是字母开头和字母数字结尾，长度在4-16之间";
			msgBox.className = "error";
			return false;
		}else{
			return checkUserName();
		}
		break;
	case "passWord":
		if (obj.value == "" || regPass.test(obj.value) == false) {
			msgBox.innerHTML = "密码不能为空并且不能含有非法字符，长度在4-10之间";
			msgBox.className = "error";
			return false;
		}
		break;
	case "rePassWord":
		if (obj.value == "") {
			msgBox.innerHTML = "确认密码不能为空";
			msgBox.className = "error";
			return false;
		} else if (obj.value != document.getElementById("passWord").value) {
			msgBox.innerHTML = "两次输入的密码不相同";
			msgBox.className = "error";
			return false;
		}
		break;	
	case "birthday":
		if (obj.value == "" || regBirth.test(obj.value) == false) {
			msgBox.innerHTML = "出生日期不能空,格式为（1990-01-01）";
			msgBox.className = "error";
			return false;
		}
		break;
	case "identity":
		if (obj.value == "" || regIdentity.test(obj.value) == false) {
			msgBox.innerHTML = "输入的身份证号长度不对，或者号码不符合规定！\n15位号码应全为数字，18位号码末位可以为数字或X";
			msgBox.className = "error";
			return false;
		}
		break;
	case "email":
		if (obj.value == "" || regEmail.test(obj.value) == false) {
			msgBox.style.display = "inline";
			msgBox.innerHTML = "电子邮件不能为空,格式为web@sohu.com";
			msgBox.className = "error";
			return false;
		}else{
			return emailExist();
		}
		break;
	case "mobile":
		if (regMobile.test(obj.value) == false) {
			msgBox.innerHTML = "手机不能为空必须为11位并且只能是数字";
			msgBox.className = "error";
			return false;
		}
		break;
	case "address":
		if (obj.value == "") {
			msgBox.innerHTML = "地址不能为空";
			msgBox.className = "error";
			return false;
		}
		break;
	}
	return true;
}


//注册时，对邮箱的验证，要求邮箱唯一
function emailExist() {
	var flag=true
	var email=$("[name=email]").val()
	$.ajax({
		url : "checkEmail",// 请求的servlet地址
		type : "GET",// 请求方式
		data : "" + email,// 发送到服务器的数据		
		dataType : "text",// 设置返回数据类型
		success : function(test) {
			if (test == 1) {
				var msgBox = document.getElementById("uemail");
				msgBox.style.display = "inline";
				msgBox.innerHTML = "该邮箱已经注册！";
				flag= false;
			} else {
				var msgBox = document.getElementById("uemail");
				msgBox.style.display = "none";
				
				
			}
		},// 响应成功后执行的回调方法data响应文本
		complete : function(XMLHttpRequest, statusText) {

		},// 响应完成后执行的回调方法
		error : function(XMLHttpRequest, statusText) {
			alert("操作失败!")
		}// 响应失败后执行的回调方法
	})
	return flag;
}

//在注册时对用户名进行验证，要求用户名唯一
function checkUserName() {
	var userName = document.getElementById("userName");
	var flag=true;
	$.ajax({
		url : "checkUserName",// 请求的servlet地址
		type : "POST",// 请求方式		
		data : "userName=" + userName.value,// 发送到服务器的数据
		dataType : "text",// 设置返回数据类型
		success : function(test) {
			if (test == 1) {
				var msgBox = document.getElementById("uName");
				msgBox.style.display = "inline";
				msgBox.innerHTML = "用户名已存在！";
				flag= false;
			} else {
				var msgBox = document.getElementById("uName");
				//当用户名不存在时，说明是可以注册的，不需要提示信息
				msgBox.style.display = "none";//隐藏span,不显示
				
			}
		},// 响应成功后执行的回调方法data响应文本		
		error : function(XMLHttpRequest, statusText) {
			alert("操作失败!");
		}// 响应失败后执行的回调方法
	});
	return flag;
}





