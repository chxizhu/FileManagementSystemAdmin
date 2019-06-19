<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<title>表格信息数据</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<link rel="stylesheet" href="../layui/css/layui.css" media="all">
	<link rel="stylesheet" href="../css/public.css"/>
	<style type="text/css">
		.pubUser-con .not_border_left {
			border-left: none !important;
		}
		
		.pubUser-con .layui-form-select dl dd.layui-this {
			background-color: #1E9FFF !important;
		}
		.pubUser-con {
			padding: 10px 15px 15px 15px;
			margin-bottom: 20px;
		}
		.pubUser-con .layui-table-tool{
			margin-bottom: 10px;
		}
		.pubUser-con .layui-table-box{
			border: 1px solid #eee;
		}
		.pubUser-con .layui-table-body table tbody .layui-table-hover{
			background: #fffdd3 !important;
		}
		.pubUser-con .layui-table-body table tbody .layui-table-click{
			background: #fdef9b !important;
		}
		.pubUser-con .layui-form-item .layui-input-block .required {
			color: #ffb800; 
			font-size: 32px; 
			float: left; 
			margin-left: 5px; 
			margin-top: 15px;
			position: absolute;
			right: -15px;
		}
		.pubUser-con .layui-table-view{
			border: none !important;
		}
		/* 查看大众端用户信息弹窗样式 */
		.selPubUserDet-con{
			padding: 0px 20px 0px 20px;
			display: none;
		}
		.selPubUserDet-con table tr td{
			padding: 15px;
			text-align: center;
		}
		.selPubUserDet-con .tdbck{
			background: #f2f2f2;
			width: 30%;
		}
		.selPubUserDet-con .layui-table .tdbck{
			width: 20% !important;
		}
		/* 修改大众端用户信息弹窗样式 */
		.editPubUserLayer-con{
			display: none;
			padding:10px 15px 15px 15px;
			margin-bottom: 40px;
		}
		.editPubUserLayer-con .top-inp{
			margin-left: 20px;
		}
		.editPubUserLayer-con .from-con{
			margin: auto;
			background-color: #E2E2E2;
			padding: 10px;
			overflow: hidden;
		}
		.editPubUserLayer-con .from-con .layui-form-item{
			margin:20px 0 ;
		}
		.editPubUserLayer-con .not_border_left {
			border-left: none !important;
		}
		.editPubUserLayer-con .layui-form-item .layui-input-block .required {
			color: #ffb800; 
			font-size: 32px; 
			float: left; 
			margin-left: 5px; 
			margin-top: 5px;
			position: absolute;
			right: -15px;
		}
		.editPubUserLayer-con .layui-form-select dl dd.layui-this{
			background-color: #1E9FFF !important;
		}
		 .editPubUserLayer-con .layui-btn{
			background-color: #1E9FFF !important;
		}
		.editPubUserLayer-con .layui-form-select dl{
			max-height:230px !important;
		}
		.editPubUserLayer-con .layui-row .layui-col-xs4{
			text-align: center;
		}
		.editPubUserLayer-con .layui-row .layui-col-xs4 .layui-upload-img{
			width: 200px;
			height: 150px;
			border: 1px solid #e6e6e6;
			background-color: #FFFFFF;
		}
	</style>
</head>
<body>
	<div class="pubUser-con">
		<script type="text/html" id="toolbarDemo">
			<div class="layui-inline">
				<div class="layui-input-inline">
					<input id="selUserName" name="selUserName" type="text" autocomplete="off" placeholder="请输入用户名" class="layui-input">
				</div>
				<div class="layui-inline">
					<button type="button" class="layui-btn layui-bg-blue" lay-event="seleBtn" lay-submit="" lay-filter="seleBtn">查询</button>	
				</div>
			</div>		
		</script>
		
		<table class="layui-hide" id="tabExpert" lay-filter="tabExpert"></table>

		<script type="text/html" id="barDemo">
			<a class="layui-btn layui-btn-xs layui-btn-normal" lay-event="select">查看</a>
			<a class="layui-btn layui-btn-xs layui-btn-normal" lay-event="edit">编辑</a>
			<a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="delete">删除</a>
		</script>

		<!-- 查看大众端用户信息弹窗开始 -->
		<div id="selExpertDet" class="selPubUserDet-con">
			<table class="layui-table">
				<tbody>
					<tr>
						<td class="tdbck">用户名</td>
						<td><span id="sellayUserName"></span></td>
						<td class="tdbck">真实姓名</td>
						<td><span id="selRealName"></span></td>
					</tr>
					<tr>
						<td class="tdbck">性别</td>
						<td><span id="selSex"></span></td>
						<td class="tdbck">出生日期</td>
						<td><span id="selBirthday"></span></td>
					</tr>
					<tr>
						<td class="tdbck">联系电话</td>
						<td><span id="selPhone"></span></td>
						<td class="tdbck">添加日期</td>
						<td><span id="selCreateTime"></span></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- 查看大众端用户信息弹窗开始 -->
		
		<!-- 修改大众端用户信息弹窗开始 -->
		<div class="editPubUserLayer-con" id="editPubUserLayer">
			<div class="from-con">
				<div style="width: 80%;">
					<form class="layui-form" action="">
					  	<div class="layui-form-item" style="margin-top: 10px;">
						    <label class="layui-form-label">用户名</label>
						    <div class="layui-input-block">
						      <input id="userName" type="text" style="float: left;position: relative;" name="userName" lay-verify="required" placeholder="请输入用户名" class="layui-input layui-disabled" disabled="disabled" autocomplete="off">
						      <i class="required">*</i>
						    </div>
					  	</div>
					  	<div class="layui-form-item" style="margin-top: 10px;">
						    <label class="layui-form-label">真实姓名</label>
						    <div class="layui-input-block">
						      <input id="realname" type="text" style="float: left;position: relative;" name="realname" lay-verify="required" placeholder="请输入真实姓名" class="layui-input" autocomplete="off">
						      <i class="required">*</i>
						    </div>
					  	</div>
						<div class="layui-form-item">
						    <label class="layui-form-label">性别</label>
						    <div class="layui-input-block" name="sex">
						      <input type="radio" name="sex" value="男" title="男" checked class="sex">
						      <input type="radio" name="sex" value="女" title="女" class="sex">
						    </div>
						</div>
						<div class="layui-form-item">
						    <label class="layui-form-label">电话</label>
						    <div class="layui-input-block">
						    	<input id="phone" name="phone" type="tel" class="layui-input layui-disabled" disabled="disabled" placeholder="请输入联系电话" autocomplete="off">
						    </div>
						</div>
						<div class="layui-form-item">
						    <label class="layui-form-label">出生日期</label>
						    <div class="layui-input-block">
						    	<input type="text" name="birthday" id="birthday" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
						    </div>
						</div>
					  	<div class="layui-form-item">
						    <div class="layui-input-block">
						      <button type="button" id="savePubUser" lay-submit="" lay-filter="savePubUser" class="layui-btn layui-btn-normal" style="float: right;">保  存 </button>
						    </div>
					  	</div>
					</form>
				</div>
			</div>
		</div>
		<!-- 修改大众端用户信息弹窗结束 -->
	</div>
	<script src="../js/jquery-3.3.1.js"></script>
	<script src="../layui/layui.js" charset="utf-8"></script>
	<script type="text/javascript">
		layui.use(['table','form','layer','laydate','laytpl','element'], function() {
			var table = layui.table;
			form = layui.form,
		    $ = layui.jquery,
		    laydate = layui.laydate,
		    laytpl = layui.laytpl,
		    element = layui.element;

		    //日期
			laydate.render({
			    elem: '#birthday'
			});
			
			table.render({
				elem: '#tabExpert',
				id: 'pubUserid',
				url: '../json/table.json',
				toolbar: '#toolbarDemo',
				title: '大众端用户信息数据表',
				height:"full-80",
				skin: 'line',
				even: true,
				cols: [
					[{
						type: 'numbers',
						align: "center",
						title: '序号'
					},{
						field: 'username',
						title: '用户名',
						align: "center"
					}, {
						field: 'realname',
						title: '真实姓名',
						align: "center"
					},{
						field: 'phone',
						title: '电话',
						align: "center"
					}, {
						field: 'createtime',
						title: '添加时间',
						align: "center"
					}, {
						title: '操作',
						toolbar: '#barDemo',
						align: "center"
					}]
				], page: {
					layout: ['prev', 'page', 'next', 'skip', 'count', 'limit'],
					groups: 5,
					limit: 10,
					theme: '#1E9FFF',						
				}
			});
			
			table.on('toolbar(tabExpert)', function(obj) {
				var checkStatus = table.checkStatus(obj.config.id);
				switch(obj.event) {
					case 'seleBtn':
						var username = $("#selUserName").val().trim();
						table.render({
							elem: '#tabExpert',
							id: 'pubUserid',
							url: '../syspublicusermanagement/getpublicuserlist?username=' + username,
							toolbar: '#toolbarDemo',
							title: '大众端用户数据表',
							height:"full-80",
							skin: 'line',
							even: true,
							cols: [
								[{
									type: 'numbers',
									align: "center",
									title: '序号'
								},{
									field: 'username',
									title: '用户名',
									align: "center"
								}, {
									field: 'realname',
									title: '真实姓名',
									align: "center"
								},{
									field: 'phone',
									title: '电话',
									align: "center"
								}, {
									field: 'createtime',
									title: '添加时间',
									align: "center"
								}, {
									title: '操作',
									toolbar: '#barDemo',
									align: "center"
								}]
							], page: {
								layout: ['prev', 'page', 'next', 'skip', 'count', 'limit'],
								groups: 5,
								limit: 10,
								theme: '#1E9FFF',						
							}
						});
						$("#selUserName").val(username);
						loadDownBox(roleid);
						break;
					};
			});
		    
			//将表格的一条数据加载到表单中
		    table.on('tool(tabExpert)', function(obj){
			    var data = obj.data;
			    if(obj.event === 'select'){
			      $("#sellayUserName").text(data.username);
				  $("#selRealName").text(data.realname);
				  $("#selSex").text(data.sex);
				  $("#selPhone").text(data.phone);
				  $("#selBirthday").text(data.birthday);
				  $("#selCreateTime").text(data.createtime);
			      layer.open({
			        type: 1, 
			        title: '大众端用户信息详情',
			        area: ['800px', '430px'],
			        shade: 0.8,
			        content: $('#selExpertDet'),
			        cancel: function(){ 
					   $(".selPubUserDet-con").css("display","none");
					}
			      });
			    }
			    if(obj.event === 'edit'){
			    	$("#userName").val(data.username);
				    $("#realname").val(data.realname);
				    $("#phone").val(data.phone);
				    $("#birthday").val(data.birthday);
					$(".sex").each(function(){
						if($.trim($(".sex")[0].value) == $.trim(data.sex)){
							$(".sex")[0].checked = true;
							form.render("radio");
						}
						if($.trim($(".sex")[1].value) == $.trim(data.sex)){
							$(".sex")[1].checked = true;
							form.render("radio");
						}
					});
					var index=layer.open({
						type: 1, 
					    title: '修改大众端用户信息',
				        area: ['830px', '95%'],
				        shade: 0.8,
				        maxmin: true,
				        content: $('#editPubUserLayer'),
				        cancel: function(){ 
						   $(".editPubUserLayer-con").css("display","none");
						}
				    });
			    	layer.full(index);
			    	
			    	/*保存修改*/
			        $("#savePubUser").click(function(){
			        	var username=$("#userName").val();
			    		var realname=$("#realname").val();
			    		var sex=$("input[name='sex']:checked").val()
			    		var birthday=$("#birthday").val();
			    		var phone=$("#phone").val();
			    		
			    		$.ajax({
			    			url: '../syspublicusermanagement/updatepublicuser',  
			    	        type: 'get', 
			    	        dataType: 'json',  
			    	        data:{username:username,realname:realname,sex:sex,
			    	        	birthday:birthday,phone:phone},
			    	        success: function (savedata) {
			    	          if (savedata.code == 10001) { 
			    	        	  layer.confirm('用户信息修改成功！', {
			    					  btn: ['确定']
			    				  }, function(){
			    					  layer.closeAll();
			    					  table.reload("pubUserid", { //此处是上文提到的 初始化标识id
				    		                where: {
				    		                	keyword:savedata.code=='10001'
				    		                }
				    		          });	
			    				  });
			    	          }else { 
			    	        	  layer.alert('用户信息修改失败！', {icon: 5});
			    	        	  return false;
			    	          }  
			    	        },
			    	        error:function(){
			    	        	layer.alert('用户信息修改失败！', {icon: 5}); 
			    	        }
			    		});
			        });
			    }
			    if(obj.event === 'delete'){	    	
			    	layer.confirm('你确定要删除吗？', {
			    		icon:3,
			    		  btn: ['确定','取消'] 
			    		}, function(){
			    	    	$.ajax({
			        			url: '../syspublicusermanagement/deletepublicuser',  
			        	        type: 'get', 
			        	        dataType: 'json',  
			        	        data:{username:data.username},
			        	        success: function (getdata) {
			        	          if (getdata.code == 10001) { 
			        	        	  layer.alert(getdata.msg, {icon: 6});
			        	        	  table.reload("pubUserid", { //此处是上文提到的 初始化标识id
							              where: {
							            	  keyword:getdata.code == '10001'
							              }
						            });
			        	          }else { 
			        	        	  layer.alert(getdata.msg, {icon: 5});
			        	          }  
			        	        },
			        	        error:function(){
			        	        	layer.alert(getdata.msg, {icon: 5}); 
			        	        }
			        		});
			    		}, function(){ }
			    	);
			    }
		    });
		});
	</script>
</body>
</html>