<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>文件资源后台管理</title>
		<meta name="renderer" content="webkit|ie-comp|ie-stand">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<link rel="stylesheet" href="../css/font.css">
		<link rel="stylesheet" href="../css/index.css">
		<link rel="stylesheet" href="../layui/css/layui.css" />
		<style type="text/css">
		.layui-tab-title li .layui-tab-close{
			display:none;
		}
		.navacolor{
			color:#148cf1;
		}
		.layuibgblack{
		color:#2F4056;
		}
		.font{
		color:	#FFFFFF;
		}
		</style>
	</head>
	
	<body>
		<!-- 顶部开始 -->
		<div class="container layui-bg-black">
			<div class="logo">
				<a href="../html/index.jsp">文件资源管理后台端</a>
			</div>
			<div class="left_open">
				<i title="展开左侧栏" class="iconfont">&#xe699;</i>
			</div>
			<ul class="layui-nav  fast-add layui-layout-right layui-bg-black" lay-filter="">
			
			 
				<li class="layui-nav-item">
					<a href="javascript:;"><span class="font">欢迎您：${user.name } ${user.realname }<span id="userrole"></span>
					</span></a>
					<dl class="layui-nav-child">
						<dd>
							<a id="loginout" class="loginout" href="javascript:">退出系统</a>
						</dd>
					</dl>
				</li>
			</ul>
			
			
		</div>
		<!-- 顶部结束 -->
		
		<!-- 中部开始 -->
		<!-- 左侧菜单开始 -->
		<div class="left-nav" style="overflow-x: hidden; width:200px;">
			<div id="side-nav" style="overflow-x: hidden;height:100%">
				<ul id="nav">	
				</ul>
			</div>
		</div>
		<!-- 左侧菜单结束 -->
		
		<!-- 右侧主体开始 -->
		<div class="page-content">
			<div class="layui-tab tab" lay-filter="wenav_tab" id="WeTabTip" lay-allowclose="true">
				<ul class="layui-tab-title" id="tabName">
					<li id="liformtitle">我的桌面</li>
				</ul>
				<div class="layui-tab-content">
					<div class="layui-tab-item layui-show">
						<iframe id="ifram1" src="../html/homePage.html" frameborder="0" scrolling="yes" class="weIframe"></iframe>
					</div>
				</div>
			</div>
		</div>
		<!-- 右侧主体结束 -->
		<!-- 中部结束 -->
		
		<!-- 底部开始 -->
		<div class="footer">
			<center>
			<div class="layuibgblack"><span class="font">Copyright ©2018 云南工商学院.软件技术</span></div>
			</center>
			
		</div>
		<!-- 底部结束 -->
		
		<script type="text/javascript" src="../layui/layui.all.js" charset="utf-8"></script>
		<script type="text/javascript" src="../js/jquery-3.3.1.js" ></script>
		<script type="text/javascript" src="../js/admin.js" ></script>
	</body>
</html>