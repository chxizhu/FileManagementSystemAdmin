<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<title>网站用户管理</title>
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
			margin-bottom:50px;
		}
		.blogUser-con  .layui-table-tool-self{
			display:none;
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
		.adminuserdetail{
			padding:20px;
			display: none;
		}
		.adminuserdetail table tr td{
			padding: 15px;text-align: center;
		}
		.adminuserdetail .tdbck{
			background: #f2f2f2;
			width: 30%;
		}
	</style>
</head>
<body>
	<!--弹框调用内容Start-->
	<div id="adminuserdetail" class="adminuserdetail">			
		<table class="layui-table">
		    <tbody>
		      <tr>
		        <td class="tdbck">ID</td>
		        <td><span id="txtclaid"></span></td>
		      </tr>
		      <tr>
		        <td class="tdbck">角色名称</td>
		        <td><span id="txtadminuserrealname"></span></td>
		      </tr>
		      <tr>
		        <td class="tdbck">角色权限</td>
		        <td><span id="txtadminuserusertype"></span></td>
		      </tr>
		    </tbody>
		  </table>
	</div>
	<!--弹框调用内容END-->	

	<div class="blogUser-con">
		<!-- 条件筛选框Start -->
		<blockquote class="layui-elem-quote not_border_left">
			<form class="layui-form" action="">
			  	<div class="layui-input-inline">
					<input type="text" name="userName" id="userName" placeholder="请输入角色名称" class="layui-input" autocomplete="off">
			    </div>
			    <div class="layui-inline">
	     	   		<button id="btnselfrontinfo" type="button" class="layui-btn layui-bg-blue">查询</button>
			    </div>
				<button type="button" class="layui-btn layui-bg-blue" id="addartType" lay-event="addartType" lay-filter="addartType" style="margin-left: 10px;">新增角色</button>
			</form>
		</blockquote>
		<!-- 条件筛选框End -->

		<table class="layui-hide" name="blogUser" id="blogUser" lay-filter="blogUser"></table>

		<script type="text/html" id="barDemo">
			<a class="layui-btn layui-btn-xs" lay-event="seluser">查看</a>
			<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
		</script>

		<!-- 用户信息添加Start -->
		<div id="add-blogUser">
			<div class="artTypeLayer">
				<form class="layui-form" action="">
					<div class="layui-form-item">
						<label class="layui-form-label">id:</label>
						<div class="layui-input-block">
							<input type="text" name="addUserName" id="addUserName"
								 autocomplete="off" placeholder="请输入用户名" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">角色名称:</label>
						<div class="layui-input-block">
							<input type="text" name="nickName" id="nickName" autocomplete="off" placeholder="请输入昵称" class="layui-input">
						</div>
					</div>
			
					<div class="layui-form-item">
				      <label class="layui-form-label">角色权限:</label>
				      <div class="layui-input-block">
				       	<select id="addusertypeidqqqqq" name="addusertypeidqqqqq">
						 <option value="00" >请选择权限</option>				
						</select> 
				      </div>
				    </div>
				</form>
			</div>
		</div>
		<!-- 用户信息添加End -->
		
	</div>
	<script src="../js/jquery-3.3.1.js" charset="utf-8"></script>
	<script src="../layui/layui.js" charset="utf-8"></script>
	<script>
	layui.use([ 'table', 'form', 'layer', 'laydate', 'laytpl', 'element' ], function() {
		var table = layui.table, form = layui.form, 
			layer = layui.layer, $ = layui.jquery,
			laydate = layui.laydate, laytpl = layui.laytpl,
			element = layui.element;
	
		/*加载表格*/
		table.render({
			elem : '#blogUser',
			id:'blogUserid',
			url : '../systemmodel/rolelist',
			title : '博主用户数据表',
			height: "full-160",
			skin : 'line',
			even : true,
			cols : [ 
			     [ {
					type : 'numbers',
					title : '序号',
					align : 'center',
					width : 80
				}, {
					field : 'roleid',
					title : 'id',
					align : 'center'
				}, {
					field : 'rolename',
					align : 'center',
					title : '角色名称',
				}, {
					field : 'authorityId',
					align : 'center',
					title : '权限'
				},{
					title : '操作',
					toolbar : '#barDemo',
					align : 'center'
				} ] 
			 ],
			 page: {
					layout: ['prev', 'page', 'next', 'skip', 'count', 'limit'],
					groups: 5,
					limit: 10,
					limits: [10, 20, 30, 40, 50],
					theme: '#1E9FFF',						
			 },
		});
		
		/* 点击查询对网站用户进行筛选 */
		$("#btnselfrontinfo").click(function(){
			var useridornickname=$("#userName").val().trim();
			table.render({
				elem : '#blogUser',
				url : '../systemmodel/roleListByName?userName='+useridornickname,
				title : '博主用户数据表',
				height: "full-160",
				skin : 'line',
				even : true,
				cols : [ 
				      [ {
					type : 'numbers',
					title : '序号',
					align : 'center',
					width : 80
				}, {
					field : 'roleid',
					title : 'id',
					align : 'center'
				}, {
					field : 'rolename',
					align : 'center',
					title : '角色名称',
				}, {
					field : 'authorityId',
					align : 'center',
					title : '权限'
				},{
					title : '操作',
					toolbar : '#barDemo',
					align : 'center'
				} ] 
				 ],
				 page: {
					layout: ['prev', 'page', 'next', 'skip', 'count', 'limit'],
					groups: 5,
					limit: 10,
					limits: [10, 20, 30, 40, 50],
					theme: '#1E9FFF',						
				 },
			});
		});
		
		/* 添加一个网站用户 */
		$("#addartType").click(function(){
			$("#addUserName").val("");
			$("#nickName").val("");
			$("#addusertypeidqqqqq").val("");
			layer.open({
				type : 1,
				title : '网站用户添加',
				area : [ '460px', '335px' ],
				shade : 0.4,
				content : $('#add-blogUser'),
				btn : [ '保存', '返回' ],
				yes : function() {
					var addUserName = $("#addUserName").val().trim();
					var nickName = $("#nickName").val().trim();
					var addusertypeidqqqqq = $("#addusertypeidqqqqq").val();

					if(addUserName == "") {
						layer.tips('不能为空', '#addUserName');
						return;
					} 
					if(nickName==""){
						layer.tips('不能为空', '#nickName');
						return;
					}
					 if(addusertypeidqqqqq=="00"){
						layer.tips('不能为空', '#addusertypeidqqqqq');
						return;
					}  
					$.ajax({
						type : 'get',
						url : '../systemmodel/addrole?roleid=' + addUserName + '&rolename=' + nickName+'&authorityId='+addusertypeidqqqqq,
						datatype : 'json',
						success : function(data) {
							if (data.code == "0") {
								layer.confirm(data.msg, {
								  btn: ['确定'],
								  icon:1
								}, function(){
									table.reload("blogUserid", { //此处是上文提到的 初始化标识id
						                where: {
						                	keyword:data.code=='10001'
						                }
						            });	
									layer.closeAll();
								});
							}else{
								layer.confirm(data.msg, {
								  btn: ['确定'],
								  icon:2
								});
								layer.setTop(layero);
							}
						},
						error : function() {}
					});						
				},
				btn2 : function() {layer.closeAll();}
			});
		});
		
		/* 动态加载用户角色 */
	$(function() {
				$.ajax({
					url : "../systemmodel/getAuthoritylist",
					type : "POST",
					data : null,
					dataType : 'json',
					contentType : 'application/json;charset=UTF-8',//contentType 很重要
					success : function(e) {
						//alert(e.msg+"\n"+e.flag+"\n"+ JSON.stringify(e));
						//alert(e.resultoObject[1]);
						var s = $("#addusertypeidqqqqq").html();		
						var str = "";			
						for(var i=0;i<e.resultObject.length;i++){					
							str += '<option value=' + e.resultObject[i].authorityid + '>' + e.resultObject[i].authorityname + '</option>';
						}
						$("#addusertypeidqqqqq").append(str);
						form.render("select");
					},
					error : function(e) {
						alert("error:"+e.msg);
					}
		
				})
			});
	
		//表格工具栏事件 
		table.on('tool(blogUser)', function(obj) {
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
			        		url: "../systemmodel/deleterole?roleid=" + data.roleid,
			        		dataType: 'json',
			        		success:function(data){
			        			if(data.code == 0){
			        				layer.confirm(data.msg, {
									  btn: ['确定']
									}, function(){
										table.reload("blogUserid", { //此处是上文提到的 初始化标识id
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