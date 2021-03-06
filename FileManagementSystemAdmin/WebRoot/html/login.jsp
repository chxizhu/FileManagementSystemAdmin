<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html class="loginHtml">
<head>
	
	<meta charset="utf-8">
	<title>系统登录</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="../layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="../css/login.css" media="all" />
</head>
<script type="text/javascript">

</script>
<body class="loginBody">
	<form class="layui-form" id="loginForm" method="post" action="">
		<div class="login-title">企业文件资源后台管理</div>
		<div class="layui-form-item input-item layui-input-active">
			<label for="userName">用户名</label>
			<input type="text" placeholder="登录用户名"  name="loginId" id="user_name"  class="layui-input" lay-verify="required" >
		</div>
		<div class="layui-form-item input-item layui-input-active">
			<label for="password">密码</label>
			<input type="password" placeholder="登录密码" autocomplete="off" id="user_password"  name="loginPwd" class="layui-input" lay-verify="required" >
		</div>
		<div class="layui-form-item">
			<button type="button" lay-submit id ="login-button" class="layui-btn layui-block" lay-filter="login" >登录</button>
		</div>
	</form>
	<script type="text/javascript" src="../layui/layui.js"></script>
	<script src="../js/jquery-3.3.1.js" charset="utf-8"></script>
	<script>
		layui.use(['form','layer'], function(){
			var layer = layui.layer
			var form = layui.form;	  
			var $ = layui.jquery;
			
			/* 点击登录 */
			$("#login-button").click(function(){
				var username=$("#user_name").val().trim();
				var password=$("#user_password").val().trim();
		
			 	if(username==null || username=="" || username==undefined){
					$("#user_name").focus();
					return;
				}
				if(password==null || password=="" || password==undefined){
					$("#user_password").focus();
					return;
				}
				if(password.length<6 || password.length>18){
					layer.alert('密码长度不符合规范!', {icon: 2});
					return;
				} 
				
				/*
				var enpwd = hex_md5(fix(Encryption_key,password));
				$("#inppassword").val(enpwd);
				*/
				 var index = layer.load(0, {shade: 0.1});
				$.ajax({
 					 url : '../Admin/AdminLogin?userid='+username+'&pwd='+password, 
					datatype : 'json',
					success : function(data) {
						if (data.code == 0) {
							window.location.href = "../html/index.jsp";
						} else {
							layer.alert(data.msg, {icon: 2});
							layer.close(index);
							$("input").val("");
						}
					},
					error:function(e){
	    	        	 layer.alert(e.msg); 
	    	        	
	    	        }
				}); 
				
				
				
       
				
				
			});
				
			
		});
	</script>
</body>
</html>
