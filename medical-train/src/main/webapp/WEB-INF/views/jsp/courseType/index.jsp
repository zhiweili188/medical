<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ include file="/WEB-INF/views/jsp/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		    
  <script type="text/javascript">
	var datagrid;
	var rowEditor=undefined;
	$(function(){
		datagrid=$("#dg").datagrid({
			url:"${ctx}/courseType/list.do",//加载的URL
		    isField:"id",
			pagination:true,//显示分页
			pageSize:10,//分页大小
			pageList:[10,15,20],//每页的个数
			fit:true,//自动补全
			fitColumns:true,
			iconCls:"icon-save",//图标
			
			columns:[[      //每个列具体内容
		              {field:'id', hidden:true },   
		              {field:'name', title:'类型名称',  width:100,align:'center' },
		              {field:'status', title:'状态',  width:100, align:'center',
		            	formatter: function(val,row, index) {
		            		if (val == 0){
		        				return '<span>正常('+val+')</span>';
		        			} else if (val == 9) {
		        				return '<span style="color:red;">停用('+val+')</span>';;
		        			}
		            	}  
		              }
		          ]],
			toolbar:[              //工具条
			        {text:"增加",iconCls:"icon-add",handler:function(){//回调函数
			        	
			        	 $('#dd').dialog('open');
			        }},
			        {text:"修改",iconCls:"icon-edit",handler:function(){
			        	var rows=datagrid.datagrid('getSelections');
			        	if(rows.length==1)
			        	{
			        		$.ajax({
	        					url : '${ctx}/courseType/id'+rows[0].id+'.do',
	        					data : param,
	        					dataType : 'json',
	        					success : function(r) {
	        						if (r.id) {
	        							 $('#dd').dialog('open');
	        							$("#name").textbox("setValue", r.roleName);
	        							$("#id").val(r.id);
	        							
	        						} else {
	        							
	        							$.messager.alert('错误', r.msg, 'error');
	        						}
	        					}
	        				});
			        	} else {
			        		$.messager.alert('错误', "只能选择一个数据进行修改", 'error');
			        	}
			        }},
			        {text:"启用",iconCls:"icon-remove",handler:function(){
			        	var rows=datagrid.datagrid('getSelections');
			  
			        	if(rows.length<=0)
			        	{
			        		$.messager.alert('警告','您没有选择','error');
			        	}
			        	else
			        	{
			        		var rows = datagrid.datagrid('getSelections');
			        		for(var i=0; i<rows.length; i++){
	        					if(rows[i].isSys == 1){
	        						$.messager.alert('错误', "不能操作系统用户", 'error');
				        			return;
	        					}
	        				}
			        		$.messager.confirm('确定','您确定要启用吗',function(t){
			        			if(t)
			        			{
			        				var ids = [];
			        				var rows = datagrid.datagrid('getSelections');
			        				for(var i=0; i<rows.length; i++){
			        					ids.push(rows[i].id);
			        				}
			        				//alert(ids.join(','));
			        			
			        				$.ajax({
			        					url : '${ctx}/courseType/updateStatus.do',
			        					data : 'status=0&ids='+ids.join(','),
			        					method: 'POST',
			        					dataType : 'text',
			        					success : function(r) {
			        						if (r=="success") {
			        							$.messager.show({
			        								msg : "操作成功",
			        								title : '成功'
			        							});
			        							datagrid.datagrid('reload');
			        						} else {
			        							$.messager.alert('错误',"操作失败", 'error');
			        						}
			        						datagrid.datagrid('unselectAll');
			        					}
			        				});
			        			
			        			}
			        		})
			        	}
			        	
			        	
			        }},
			        {text:"停用",iconCls:"icon-remove",handler:function(){
			        	var rows=datagrid.datagrid('getSelections');
			  
			        	if(rows.length<=0)
			        	{
			        		$.messager.alert('警告','您没有选择','error');
			        	}
			        	else
			        	{
			        		var rows = datagrid.datagrid('getSelections');
			        		for(var i=0; i<rows.length; i++){
	        					if(rows[i].isSys == 1){
	        						$.messager.alert('错误', "不能操作系统用户", 'error');
				        			return;
	        					}
	        				}
			        		$.messager.confirm('确定','您确定要停用吗',function(t){
			        			if(t)
			        			{
			        				var ids = [];
			        				var rows = datagrid.datagrid('getSelections');
			        				for(var i=0; i<rows.length; i++){
			        					ids.push(rows[i].id);
			        				}
			        				//alert(ids.join(','));
			        			
			        				$.ajax({
			        					url : '${ctx}/courseType/updateStatus.do',
			        					data : 'status=9&ids='+ids.join(','),
			        					method: 'POST',
			        					dataType : 'text',
			        					success : function(r) {
			        						if (r=="success") {
			        							$.messager.show({
			        								msg : "操作成功",
			        								title : '成功'
			        							});
			        							datagrid.datagrid('reload');
			        						} else {
			        							$.messager.alert('错误',"操作失败", 'error');
			        						}
			        						datagrid.datagrid('unselectAll');
			        					}
			        				});
			        			
			        			}
			        		})
			        	}
			        }}
			        ]

		});
		
		 $('#dd').dialog({
             title: "My Dialog",
             closed:true,
             modal: true, //dialog继承自window，而window里面有modal属性，所以dialog也可以使用
             toolbar: [{
					text:'Ok',
				iconCls:'icon-ok',
				handler:function(){
					$('#ff').form('submit',{
						onSubmit:function(){
							var isValid = $(this).form('validate');
							if(isValid) {
								
							}
							return isValid;
						},
						success: function(data){
							$('#ff').form('clear');
							$('#dd').dialog('close');
						}
					});
				
				}
			},{
				text:'Cancel',
				handler:function(){
					$('#dd').dialog('close');
					$('#ff').form('clear');
				}
			}],
			onOpen: function() {
			 
			},
			onClose: function() {
				$('#ff').form('clear');
				datagrid.datagrid('unselectAll');
				datagrid.datagrid('reload');
				// $('#privilege-tree').tree('reload');
			}
         });
		 
	    
		$("#btn_search").click(function(){
			var param = $("#searchForm").serializeJson();
			datagrid.datagrid('load', param);

		});
	});
	
	
    </script>
    <style type="text/css">
    
    </style>
</head>
<body style="padding:0 4px; margin:0;  overflow: hidden; ">
<div class="easyui-layout" style="width:100%;height:100%;" data-options="fit:true">
		<div title="课程类型管理" data-options="region:'north'" style="height:100px">
		 <form id="searchForm" >
			<table cellpadding="5">
				    		<tr>
				    			<td>类型:</td>
				    			<td><input class="easyui-textbox" type="text" id="qName"  name="name" ></input></td>
				
				    			<td ><a href="#" id="btn_search" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="width:80px">Search</a></td>
				    		</tr>
				    		<tr>
				    		</tr>
				    	</table>
				  </form>
		</div>
		<div data-options="region:'center'" >
			<table id="dg" >
			</table>
		</div>

			
	<div id="dd" title="My Dialog"  style="width:600px;height:450px; text-align: center; " data-options="closed:true"> 
				    <form id="ff" method="post" action="${ctx}/courseType/save.do" >
				    		<input type="hidden" id="id" name="id">
				    		<input type="hidden" id="privileges" name="privileges">
				    		<div style="margin:10px 0">
								类型名:<input class="easyui-textbox" type="text" id="name"  name="name" data-options="required:true"></input>
							</div>
				    		
				    </form>
				    
			</div>
			
			
		</div>
</body>
</html>