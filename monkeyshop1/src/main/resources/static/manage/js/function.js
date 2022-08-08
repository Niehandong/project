function change(img){
	img.src="getcode?"+new Date().getTime();
}

function FocusItem(obj){
	if($(obj).attr('name') =='veryCode'){
		$(obj).next.next().html('').removeClass('error');
	}else{
		$(obj).next('span').html('').removeClass('error');
	}
	
}

function CheckItem(obj){
	var msgBox=$(obj).next('span');
		switch($(obj).attr('name')){
		case "userName":
			if(obj.value == ""){
				msgBox.html('用户不能为空');
				msgBox.addClass('error');
			}else{
				var url="usernamecheck?name="+encodeURI($(obj).val())+"&"+new Date().getTime();
				$.get(url,function(date){
					if(date=="false"){
						msgBox.html('用户不能为空');
						msgBox.addClass('error');
					}else{
						msgBox.html().removeClass('error');
					}
				});
			}
			break;
		
		case "passWord":
			if(obj.value == ""){
				msgBox.html('用户密码不能为空');
				msgBox.addClass('error');
			}
				break;
		case "repassWord":
			if(obj.value == ""){
				msgBox.html('用户确认密码不能为空');
				msgBox.addClass('error');
			}else if($(obj).val() !=$('input[name="passWord"]').val()){
				msgBox.html('用户两次输入的密码不一致');
				msgBox.addClass('error');
			}
				break;
		case "veryCode":
			var numshow =$(obj).next().next();
			if(obj.value == ""){
				numshow.html('验证码不能为空');
				numshow.addClass('error');
			}
				break;
		}
}