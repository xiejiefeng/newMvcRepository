<!DOCTYPE html>
<html>
<head>
<title>生成二维码</title>
<#include "/common/header.ftl" encoding="UTF-8">
<link rel="stylesheet" type="text/css" href="<@jci.domain url='/css/qrcode/qrcode.css'/>">
</head>
<body>
<div class="head" style="width:50px">
	场景：
</div>
<div class="head" style="width:50px">
	<input type="radio" name="scene" value="1" checked>
	门店
</div>
<div class="head">
	<select id="sceneId1">
		<#list sceneInfoList as sceneInfo>
			<#if sceneInfo.sceneFlag == 1>
				<option value="${sceneInfo.sceneId}">${sceneInfo.sceneId}&nbsp;:&nbsp;${sceneInfo.sceneName}</option>
			</#if>
		</#list>
    </select>
</div>
<!--
<div class="head" style="width:50px">
	<input type="radio" name="scene" value="2">
	活动
</div>
<div class="head">
	<select id="sceneId2">
	    <#list sceneInfoList as sceneInfo>
			<#if sceneInfo.sceneFlag == 2>
				<option value="${sceneInfo.sceneId}">${sceneInfo.sceneId}&nbsp;:&nbsp;${sceneInfo.sceneName}</option>
			</#if>
		</#list>
    </select>
</div>
-->
<div class="head" style="width:50px">
	<input type="radio" name="scene" value="2">
	活动
</div>
<div class="head">
	<input type="text" id="sceneId2" />
</div>

<div class="head" style="width:120px">
	<a href="#" onclick="createQrCode()" class="btn">生成二维码</a>
</div>
<div class="head" style="width:100px">
	<a href="#" onclick="refreshScene()" class="btn">刷新场景</a>
</div>
<div class="line"></div>
<div class="content">
	<img id="qrcode" />
</div>


<footer></footer>
<#include "/common/footer.ftl" encoding="UTF-8">
<script type="text/javascript">
function createQrCode() {
	
	var url=$.context+"/qrcode/create.htm";
	var flg = $(":radio[name=scene]:checked").val();
	var param = [];										//数据提交
	if (flg==1) {
		param = {"sceneId":$("#sceneId1").val()}
	} else {
		param = {"sceneStr":$("#sceneId2").val()}
	}	
	$.getajax(url, param, function(data){
		if (data.result == $.dataResult.SUCCESS) {
			$("#qrcode").attr("src",data.returnUrl);
			$("#qrcode").show();
			alertObj("生成成功！");
		} else {
			$("#qrcode").hide();
			alertObj("生成失败！");
		}
	});
}

function refreshScene(){
	var url=$.context+"/qrcode/refresh.htm";
	var param = {										//数据提交
	};	
	$.getajax(url, param, function(data){
		$("#qrcode").hide();
		if (data.result == $.dataResult.SUCCESS) {
			$("#sceneId1").empty();
			$("#sceneId2").empty();
			for(var i=0;i<data.obj.length;i++){
				$("#sceneId" + data.obj[i].sceneFlag)
					.append("<option value='"+data.obj[i].sceneId+"'>"+data.obj[i].sceneId+" : "+data.obj[i].sceneName+"</option>"); 
			}
			alertObj("刷新成功！");
		} else {
			alertObj("刷新失败！");
		}
	});
}

function alertObj(txt){
	var timer = null;
	$("#alert").html(txt);
	var obj = $("#mask").add("#alert");
	obj.fadeIn(500);
	timer = setTimeout(function(){
		obj.fadeOut(500,function(){
			clearTimeout(timer);
		});
	},1000);
}
</script>
</body>
</html>