function checkUsername(){
	if("" == $("#username").val()){
		alert("用户名不能为空！");
		$("#username").focus();
		return false;
	}
	var b = false;
	//判断用户名是否存在
	/*$.ajax({
        type: "get",//使用get方法访问后台
        dataType: "json",//返回json格式的数据
        async: false,
        url: $("#path").val()+"/login/isUserExistInfo.action?username="+$("#username").val()+"&time="+new Date(),//要访问的后台地址
        async: false,//同步
        success: function(data){
			b = data.isexist;
		}
	});
	if(!b){
		alert("该用户不存在！");
		$("#username").focus();
		return false;
	}*/
	return checkLogin();
}

function checkPassword(){
	if("" == $("#password").val()){
		alert("密码不能为空！");
		return false;
	}
	var b = false;
	//判断密码是否正确
	/*$.ajax({
        type: "get",//使用get方法访问后台
        dataType: "json",//返回json格式的数据
        async: false,
        url: $("#path").val()+"/login/isPwdCorrect.action?username="+$("#username").val()+"&password="+$("#password").val()+"&time="+new Date(),//要访问的后台地址
        async: false,//同步
        success: function(data){
			b = data.iscorrect;
		}
	});
	if(!b){
		alert("密码输入有误！");
		$("#password").focus();
		return false;
	}*/
	return true;
}
function checkLogin(){
	var b = 1;
	//判断用户是否可以登录
	/*$.ajax({
        type: "get",//使用get方法访问后台
        dataType: "json",//返回json格式的数据
        async: false,
        url: $("#path").val()+"/login/isUserCanLogin.action?username="+$("#username").val()+"&time="+new Date(),//要访问的后台地址
        async: false,//同步
        success: function(data){
			var status = data.user.state;
			b = status;
		}
	});
	if(0 == b){
		alert("该用户还没有通过审核，不能登录，请联系管理员！");
		return false;
	}else if(2 == b){
		alert("该用户已被禁用，不能登录，请联系管理员！");
		return false;
	}else if(3 == b){
		alert("该用户已被锁定，不能登录，请联系管理员！");
		return false;
	}else if(9 == b){
		alert("该用户未被审核通过，不能登录，请联系管理员！");
		return false;
	}*/
	return true;
}