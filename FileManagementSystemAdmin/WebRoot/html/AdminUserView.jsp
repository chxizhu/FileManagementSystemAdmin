<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>后台用户管理</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="../layui/css/layui.css" media="all">
<style>
.blogUser-con .layui-table-view {
	border: none;
}

.blogUser-con .layui-table-box {
	margin-top: 10px;
}

.blogUser-con {
	padding: 0 15px 15px 15px;
	margin-bottom: 50px;
}

.blogUser-con  .layui-table-tool-self {
	display: none;
}

.blogUser-con .not_border_left {
	border-left: none !important;
}

.blogUser-con .blogUser dl dd.layui-this {
	background-color: #1E9FFF !important;
}

.blogUser-con .hide {
	display: none;
}

.blogUser-con .show {
	display: block;
}

.blogUser-con .btn_size {
	height: 28px !important;
	line-height: 28px !important;
}

.blogUser-con .layui-table-body table tbody .layui-table-hover {
	background: #fffdd3 !important;
}

.blogUser-con .layui-table-body table tbody .layui-table-click {
	background: #fdef9b !important;
}

.blogUser-con .layui-table, .layui-table-view {
	border: none;
	margin-top: 0;
}

#add-blogUser {
	display: none;
	z-index: 999 !important;
}

#add-blogUser .artTypeLayer {
	width: 90%;
	margin-left: auto;
	margin-right: auto;
	padding-top: 20px;
}

.adminuserdetail {
	padding: 20px;
	display: none;
}

.adminuserdetail table tr td {
	padding: 15px;
	text-align: center;
}

.adminuserdetail .tdbck {
	background: #f2f2f2;
	width: 30%;
}
</style>
</head>
<body>
	<div class="blogUser-con">
		<blockquote class="layui-elem-quote not_border_left">
			<form class="layui-form" action="">
			
				<div class="layui-input-inline">
					<input type="text" name="realname" id="realname"
						placeholder=" 请输入用户名 " class="layui-input" autocomplete="off">
				</div>
				
				<div class="layui-inline">
					<select name="roleid" id="roleid" lay- filter="roleid">
						<option value="00">请选择用户类型</option>
					</select>
				</div>
				
				<div class="layui-inline">
					<button id="btnselfrontinfo" type="button"
						class="layui-btn layui-bg-blue">查询</button>
				</div>
			</form>
			
		</blockquote>
		
		<!-- 表格开始 -->
		<table class="layui-hide" name="adminUser" id="adminUser"
			lay-filter="adminUser"></table>
		<!-- 表格结束 -->
	</div>
	<script src="../js/jquery-3.3.1.js" charset="utf-8"></script>
	<script src="../layui/layui.js" charset="utf-8"></script>
	<script>
		layui
				.use(['table', 'form', 'layer', 'laytpl', 'element' ],function() {
							var table = layui.table, 
							form = layui.form, 
							layer = layui.layer, 
							$ = layui.jquery, 
							element = layui.element;

							/*加载表格*/
							table.render({
								elem : '#adminUser',
								id : 'adminUser',
								url : '../adduser',
								title : '后台用户数据表',
								height : "full-160",
								skin : 'line',
								even : true,
								cols : [ [ {
									type : 'numbers',
									title : '序号',
									align : 'center',
									width : 80
								}, {
									field : 'userid',
									align : 'center',
									title : '用户名',
								}, {
									field : 'realname',
									align : 'center',
									title : '真实姓名',
								}, {
									field : 'name',
									title : '用户类型',
									align : 'center'
								}, {
									field : 'createtime',
									align : 'center',
									title : '创建时间'
								}, {
									title : '操作',
									toolbar : '#barDemo',
									align : 'center'
								} ] ],
								page : {
									layout : [ 'prev', 'page', 'next', 'skip',
											'count', 'limit' ],
									groups : 5,
									limit : 10,
									limits : [ 10, 20, 30, 40, 50 ],
									theme : '#1E9FFF',
								},
							});

							/* 点击查询对网站用户进行筛选 */
							$("#btnselfrontinfo").click(
									function() {
										var useridornickname = $("#userName").val();
										var selectid = $("#selectid").val();
										var parm = '?realname='+ realname+ '&roleid=' + roleid;
										table.render({
													elem : '#adminUser',
													id : 'adminUser',
													url : '../adduser' + parm,
													title : '后台用户数据表',
													height : "full-160",
													skin : 'line',
													even : true,
													cols : [ [ {
														type : 'numbers',
														title : '序号',
														align : 'center',
														width : 80
													}, {
														field : 'userid',
														align : 'center',
														title : '用户名',
													}, {
														field : 'realname',
														align : 'center',
														title : '真实姓名',
													}, {
														field : 'name',
														title : '用户类型',
														align : 'center'
													}, {
														field : 'createtime',
														align : 'center',
														title : '创建时间'
													}, {
														title : '操作',
														toolbar : '#barDemo',
														align : 'center'
													} ] ],
													page : {
														layout : [ 'prev',
																'page', 'next',
																'skip',
																'count',
																'limit' ],
														groups : 5,
														limit : 10,
														limits : [ 10, 20, 30,
																40, 50 ],
														theme : '#1E9FFF',
													},
												});
									});

						});
	</script>
</body>
</html>