<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="utf-8">
		<title>后台用户管理</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
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
			
			.blogUser-con .layui-table-tool-self {
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
			
			.blogUser-con .layui-table,
			.layui-table-view {
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

					<div class="layui-inline">
						<select name="type" id="type" lay- filter="type">
							 <option value="">请选择</option>
		       				 <option value="图片">图片</option>
					        <option value="文档">文档</option>
					        <option value="视频">视频</option>
					          <option value="其它">其它</option>
							
						</select>
					</div>
					<div class="layui-input-inline">
						<input type="text" name="method" id="method" placeholder=" 请输入文件标题" class="layui-input" autocomplete="off">
					</div>
					<div class="layui-input-inline">
						<input type="text" name="realname" id="realname" placeholder=" 请输入上传用户名 " class="layui-input" autocomplete="off">
					</div>

				
				     <div class="layui-input-inline">
				                   时间：
				      </div>
				      <div class="layui-input-inline">
				            
				        <input type="text" name="starttime" id="starttime" lay-verify="date" placeholder="开始时间" autocomplete="off" class="layui-input">
				       </div>
				       <div class="layui-input-inline">
				        <input type="text" name="endtime" id="endtime" lay-verify="date" placeholder="结束时间" autocomplete="off" class="layui-input">
				      </div>
					<div class="layui-inline">
						<button id="btnselfrontinfo" type="button" class="layui-btn layui-bg-blue">查询</button>
					</div>
				</form>

			</blockquote>

			<!-- 表格开始 -->
			<table class="layui-hide" name="adminUser" id="adminUser" lay-filter="adminUser"></table>
			<script type="text/html" id="barDemo">
			<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
		    </script>
			<!-- 表格结束 -->
		</div>
		<script src="../js/jquery-3.3.1.js" charset="utf-8"></script>
		<script src="../layui/layui.js" charset="utf-8"></script>
		<script>
			layui.use(
					['table', 'form', 'layer', 'laytpl', 'element','laydate'],
					function() {
						var table = layui.table,
							form = layui.form,
							layer = layui.layer,
							$ = layui.jquery,
							element = layui.element;
						var laydate = layui.laydate;
						
						    //日期选择
							  laydate.render({
							    elem: '#starttime'
							  });
							  
							  laydate.render({
							    elem: '#endtime'
							  });

						/*加载表格*/
						table.render({
							elem: '#adminUser',
							id: 'adminUser',
							url: '../systemmodel/userfile',
							title: '后台用户数据表',
							height: "full-160",
							skin: 'line',
							even: true,
							cols: [
								[{
									type: 'numbers',
									title: '序号',
									align: 'center',
									width: 80
								}, {
									field: 'filename',
									align: 'center',
									title: '文件名',
								}, {
									field: 'typename',
									align: 'center',
									title: '类型',
								}, {
									field: 'dscribe',
									title: '说明',
									align: 'center'
								}, {
									field: 'filesize',
									align: 'center',
									title: '文件大小'
								}, {
									field: 'authorityname',
									align: 'center',
									title: '文件权限'
								}, {
									field: 'username',
									align: 'center',
									title: '上传作者'
								}
								
								, {
									field: 'uptime',
									align: 'center',
									title: '创建时间',
									templet:'<div>{{ layui.util.toDateString(d.uptime, "yyyy-MM-dd") }}</div>'
								}, {
									title: '操作',
									toolbar: '#barDemo',
									align: 'center'
								}]
							],
							page: {
								layout: ['prev', 'page', 'next', 'skip',
									'count', 'limit'
								],
								groups: 5,
								limit: 10,
								limits: [10, 20, 30, 40, 50],
								theme: '#1E9FFF',
							},
						});

						/* 点击查询对网站用户进行筛选 */
						$("#btnselfrontinfo").click(
							function() {

							var selectid = $("#type").val();
							var method = $("#method").val();
							var realname = $("#realname").val();
							var starttime = $("#starttime").val();
							var endtime = $("#endtime").val();
								
								var parm = '?selectid=' + selectid +'&method=' + method+'&realname=' + realname+'&starttime=' + starttime+'&endtime=' + endtime;
								
								table.render({
										elem: '#adminUser',
										id: 'adminUser',
										url: '../systemmodel/userfileByName' + parm,
										title: '后台用户数据表',
										height: "full-160",
										skin: 'line',
										even: true,
										cols: [
											[{
									type: 'numbers',
									title: '序号',
									align: 'center',
									width: 80
								}, {
									field: 'filename',
									align: 'center',
									title: '文件名',
								}, {
									field: 'typename',
									align: 'center',
									title: '类型',
								}, {
									field: 'dscribe',
									title: '说明',
									align: 'center'
								}, {
									field: 'filesize',
									align: 'center',
									title: '文件大小'
								}, {
									field: 'rolename',
									align: 'center',
									title: '文件权限'
								}, {
									field: 'username',
									align: 'center',
									title: '上传作者'
								}
								
								, {
									field: 'uptime',
									align: 'center',
									title: '创建时间',
									templet:'<div>{{ layui.util.toDateString(d.uptime, "yyyy-MM-dd") }}</div>'									
								}, {
									title: '操作',
									toolbar: '#barDemo',
									align: 'center'
								}]
										],
										page: {
											layout: ['prev',
												'page', 'next',
												'skip',
												'count',
												'limit'
											],
											groups: 5,
											limit: 10,
											limits: [10, 20, 30,
												40, 50
											],
											theme: '#1E9FFF',
										},
									});
							});
							
				//表格工具栏事件 
		    table.on('tool(adminUser)', function(obj) {
			var data = obj.data;
			$("#txtclaid").text(data.roleid);
			$("#txtadminuserrealname").text(data.rolename);
			$("#txtadminuserusertype").text(data.authorityId);
			
			
			switch (obj.event) {
				case 'seluser':
					layer.open({
				        type: 1, 
				        title: '管理员信息详情',
				        area: ['600px', '430px'],
				        shade: 0.8,
				        content: $('#adminuserdetail'),
				        btn: ['返回'], 
				        yes: function(){
				          layer.closeAll();
				          $(".adminuserdetail").css("display","none");
				        },
				        cancel: function(){ 
						  $(".adminuserdetail").css("display","none");
						}
				    });
				break;
				
				//删除按钮操作
				case 'del':
					layer.confirm('确定要删除么？', {
					  btn: ['确定','取消'],
					  icon:3
					}, function(){
						$.ajax({
			        		type: 'get',
			        		url: "../systemmodel/deleteFile?fileid=" + data.fileid,
			        		dataType: 'json',
			        		success:function(data){
			        			if(data.code == 0){
			        				layer.confirm(data.msg, {
									  btn: ['确定']
									}, function(){
										table.reload("adminUser", { //此处是上文提到的 初始化标识id
							                where: {
							                	keyword:data.code=='0'
							                }
							            });	
										layer.closeAll();
									});          				 
			        			}
			        			else{
			        				layer.confirm(data.msg, {
										  btn: ['确定']
									});
			        			}
			        		},
			        		error:function(){
			        			layer.confirm('出现错误，删除失败，请重试！', {
									  btn: ['确定']
								});
			        		},
			        	});   
					}, function(){ 
						layer.closeAll();
					});
				break;
				
			}
			;
		});
							

					});
		</script>

	</body>

</html>