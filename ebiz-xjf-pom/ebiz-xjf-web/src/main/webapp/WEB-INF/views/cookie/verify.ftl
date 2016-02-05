<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1, minimum-scale=1, user-scalable=no">
<title>验证</title>
<#include "/common/header.ftl" encoding="UTF-8">
<link rel="stylesheet" type="text/css" href="<@jci.domain url='/css/cookie/cookie.css'/>">
</head>
<body>

<div class="head" style="width:70px">
	UID：
</div>

<div class="head" style="width:200px">
	${uid}
</div>

<div class="clear"></div>

<div class="head" style="width:70px">
	验证码：
</div>

<div class="head">
	<input id="code" name="code" style="width:100px"/>
</div>

<div class="head" style="width:100px">
	<a id="send" class="btn">获取</a>
</div>

<div class="clear"></div>

<div class="head" style="width:300px">
	<a id="verify" class="btn">验证</a>
</div>

<footer></footer>

<#include "/common/footer.ftl" encoding="UTF-8">

<script type="text/javascript">
$(function(){
	var sendBlock = false;
	// 获取验证码
	$("#send").on("click",function() {
		if (sendBlock) return;
		// 不可点击
		diabled($(this),true);
		
		var url=$.context+"/cookie/verifySend.htm";
		var param = {	//数据提交
		};
		
		$.getajax(url, param, function(data){
			if (data.result == $.dataResult.SUCCESS) {
				comAlertObj("发送成功！请问管理员索要！");
			} else {
				// 可点击
				diabled($(this),false);
				comAlertObj("发送失败！");
			}
		});
		
		countDown($(this));

		// 倒计时
		function countDown(obj) {
			// 重发时间
	    	var time = 60;
	    	
	    	obj.text((time--) + '秒');
		    var setIn = setInterval(function() {
		        if (time <= 0) {
		        	// 可点击
					diabled(obj,false);
		        	obj.text("获取");
		        	clearInterval(setIn);
		        } else {
		        	obj.text((time--) + '秒');
		        }
		    }, 1000);
		}
		
		// 可否点击
		function diabled(obj,block){
			sendBlock = block;
			if (block) {
				obj.css("background","#c6c6cc");
			}else{
				obj.css("background","#ff9a14");
			}
		}
	});
	
	// 验证
	$("#verify").on("click",function(){
		var url=$.context+"/cookie/verifyCheck.htm";
		var param = {	//数据提交
			code : $("#code").val().trim()
		};
		$.getajax(url, param, function(data){
			if (data.result == $.dataResult.SUCCESS) {
				comAlertObj("验证成功！");
				window.location.href = $.context+"/cookie/menu.htm"
			} else {
				comAlertObj("验证失败！");
			}
		});
	});
});
</script>
</body>
</html>