<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/views/jsp/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="margin:200px 400px;">
	<div class="easyui-panel" title="登录" style="width:400px;">
		<div style="padding:10px 60px 20px 60px">
	    <form id="ff" class="easyui-form" method="post" action="${ctx}/login/ajaxLogin.do" data-options="novalidate:true">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>用户名:</td>
	    			<td><input class="easyui-textbox" type="text" id="username"  name="userName" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>密码:</td>
	    			<td><input class="easyui-textbox" type="password" id="password" name="password" data-options="required:true"></input></td>
	    		</tr>
	    	</table>
	    </form>
	    <div id="msgContent" style="display: none; color: red;">ddddd</div>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">确定</a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">取消</a>
	    </div>
	    </div>
	</div>
</div>
</body>
<script>
var message=
{
	1:"用户名或密码错误",
	2:"该帐号已停用"	
};
	function submitForm(){
		$('#ff').form('submit',{
			onSubmit:function(){
				return $(this).form('enableValidation').form('validate');
			},
		    success:function(r){
		    	var data = eval('(' + r + ')');
		       if(data.code == "0") {
		    	   window.location = "${ctx}/login/main.do";
		       } else {
		    	   $("#msgContent").html(message[data.code]);
		    	   $("#msgContent").css("display","");
		       }
		    }
		});
	}
	function clearForm(){
		$('#ff').form('clear');
	}
$(function() {
	$('.textbox-text').keydown(function(e) {
		var keyCode = e.keyCode ? e.keyCode : e.which ? e.which : e.charCode; 
		if (keyCode == 13){ 
			submitForm();      					
		}
	});
	
	$('#username').next().find("input").eq(0).focus();
});
</script>
</html>