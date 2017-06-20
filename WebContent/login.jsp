<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>Title</title>
    <link rel="stylesheet" href="static/css/bootstrap.min.css">
    <style>
        body{
            background-color: #444845;
        }
    .container{
        width:400px;
        height: 310px;
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%,-50%);
        background-color: #58c3c9;
        border-radius: 10px;
    }
    </style>
    <script type="text/javascript" src="static/js/jquery-1.11.2.min.js"></script>
    <script src="static/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container">
  <form id="login"  class="center-block ">
      <h3 class="text-center">管理员登录</h3>
      <div class="form-group has-success">
          <label for="username">用户名:</label>
          <input type="text" id="username" class="form-control" placeholder="请输入账号">
      </div>
      <div class="form-group has-error">
          <label for="password">密码</label>
          <input type="password" id="password" class="form-control" placeholder="请输入密码">
      </div>
      <div class="checkbox">
          <label ><input type="checkbox" >记住我</label>
          <span id="warning" style="float: right;color:red"></span>
      </div>
      <div class="form-group">
          <input type="button" onclick="login()" class="btn btn-primary btn-block" value="登录">
      </div>

  </form>
</div>
<script>
 function login(){
	var username=$("#username").val();
	var password=$("#password").val();
	if(check()){
		$.post("user/login",{"userName":username,"userPass":password},function(result){
			if(result.code=="100"){
				location.href=result.msg;
			}else{
				 $("#warning").fadeIn(200);
					$("#warning").text("用户名或密码错误");
					$("#warning").fadeOut(3000);
			}
		})
	}
	
} 
 
 
function check(){
	if($("#username").val()==""){
		 $("#warning").fadeIn(200);
		$("#warning").text("账户名不能为空");
		$("#warning").fadeOut(3000);
		return false;
	}if($("#password").val()==""){
		$("#warning").fadeIn(200);
		$("#warning").text("密码不能为空");
		$("#warning").fadeOut(3000);
		return false;
	}
	return true;
}
</script>


</body>
</html>