<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1, minimum-scale=1, user-scalable=no">
<title>设定OpenId</title>
<#include "/common/header.ftl" encoding="UTF-8">
<link rel="stylesheet" type="text/css" href="<@jci.domain url='/css/cookie/cookie.css'/>">
</head>
<body>
<div class="head" style="width:120px">
	OpenType：
</div>

<div class="head" style="width:120px">
	<a href="javascript:setOpenId()" class="btn">设定Cookie</a>
</div>

<div class="clear"></div>
${name}
${testTime('')}
${time}
<div class="head" style="width:240px">
	(${wx}:微信;${cxb}:车享宝;${cxh}:车享汇;${mz}:M站)
</div>

<div class="head">
	<input id="openType" name="openType" value="${openType}" style="width:50px"/>
</div>

<div class="clear"></div>

<div class="head" style="width:120px">
	OpenId：
</div>

<div class="clear"></div>

<div class="head">
	<input id="openId" name="openId" value="${openId}" style="width:300px"/>
</div>

<div class="clear"></div>

<div class="head" style="width:120px">
	UserKey：
</div>

<div class="clear"></div>

<div class="head">
	<input id="userKey" name="userKey" value="${key}" style="width:300px"/>
</div>

<div class="clear"></div>

<div class="head" style="width:120px">
	车享Id：
</div>

<div class="head">
	<input id="cxId" name="cxId" value="${cxId}" style="width:170px"/>
</div>

<div class="clear"></div>

<div class="head" style="width:120px">
	经度：
</div>

<div class="head">
	<input id="x" name="x" value="${x}" style="width:170px"/>
</div>

<div class="clear"></div>

<div class="head" style="width:120px">
	纬度：
</div>

<div class="head">
	<input id="y" name="y" value="${y}" style="width:170px"/>
</div>

<div class="line"></div>

<div class="head" style="width:120px">
	来源：
</div>

<div class="head" style="width:120px">
	<a href="javascript:getParam()" class="btn">获取参数</a>
</div>

<div class="clear"></div>

<div class="head" style="width:240px">
(0:车享家;1:车享汇;2:车享宝)
</div>

<div class="head">
	<input id="sourceType" name="sourceType" value="" style="width:50px"/>
</div>

<div class="clear"></div>

<div class="head" style="width:120px">
	城市：
</div>

<div class="head">
	<input id="cityName" name="cityName" value="" style="width:170px"/>
</div>

<div class="clear"></div>

<div class="head">
	<textarea id="userInfo" name="userInfo" style="width:300px;height:200px" readonly></textarea>
</div>

<div class="line"></div>

<div class="head" style="width:120px">
	<a href="${contextPath}/home/index.htm" class="btn">首页</a>
</div>

<div class="head" style="width:120px">
	<a href="${contextPath}/service/index.htm" class="btn">保养预约</a>
</div>

<div class="clear"></div>

<div class="head" style="width:120px">
	<a href="${contextPath}/user/login-fast.htm" class="btn">注册绑定</a>
</div>

<div class="head" style="width:120px">
	<a href="${contextPath}/maintenance/index.htm" class="btn">保养手册</a>
</div>

<div class="clear"></div>

<div class="head" style="width:120px">
	<a href="${contextPath}/selectCar/toSelectCar.htm" class="btn">车辆选择</a>
</div>

<div class="head" style="width:120px">
	<a href="${contextPath}/selectCar/toSelectCarBrand.htm" class="btn">车型选择</a>
</div>

<div class="clear"></div>

<div class="head" style="width:120px">
	<a href="${contextPath}/tyre/index.htm" class="btn">轮胎预约</a>
</div>

<div class="head" style="width:120px">
	<a href="${contextPath}/store/cardSale.htm" class="btn">洗车销售</a>
</div>

<div class="clear"></div>

<div class="head" style="width:120px">
	<a href="${contextPath}/store/mylist.htm" class="btn">门店选择</a>
</div>

<div class="head" style="width:120px">
	<a href="${contextPath}/store/list.htm" class="btn">网点查询</a>
</div>

<div class="clear"></div>

<div class="head" style="width:120px">
	<a href="${contextPath}/personalInfo/toPersonInfo.htm" class="btn">用户中心</a>
</div>

<div class="head" style="width:120px">
	<a href="${contextPath}/selectCar/toSelectCar.htm?readonly=true" class="btn">我的爱车</a>
</div>

<div class="clear"></div>

<div class="head" style="width:120px">
	<a href="${contextPath}/card/list.htm" class="btn">我的卡券</a>
</div>

<div class="head" style="width:120px">
	<a href="${contextPath}/order/list.htm" class="btn">我的订单</a>
</div>
<!--
<div class="clear"></div>

<div class="head" style="width:120px">
	<a href="${contextPath}/about/card.htm" class="btn">卡类业务</a>
</div>

<div class="head" style="width:120px">
	<a href="${contextPath}/about/activity.htm" class="btn">优惠活动</a>
</div>
-->
<div class="clear"></div>

<div class="head" style="width:120px">
	<a href="${contextPath}/errorPage404.htm" class="btn">错误页面1</a>
</div>

<div class="head" style="width:120px">
	<a href="${contextPath}/error.htm" class="btn">错误页面2</a>
</div>
<!--
<div class="line"></div>

<div class="head" style="width:120px">
	<a href="javascript:createMenu()" class="btn">创建菜单</a>
</div>
<div class="head" style="width:120px">
	<a href="${contextPath}/qrcode/index.htm" class="btn">生成二维码</a>
</div>
-->
<div class="line"></div>

<div class="head" style="width:120px">
	<a href="${contextPath}/sysReference/querySysRefence.htm" class="btn">配置参数</a>
</div>

<div class="line"></div>

<div class="head" style="width:120px">
	<a href="${contextPath}/active/jttg/index.htm" class="btn">阶梯团购</a>
</div>

<div class="head" style="width:120px">
	<a href="${contextPath}/about/index.html" class="btn">关于我们</a>
</div>

<div class="clear"></div>

<div class="head" style="width:120px">
	<a href="${contextPath}/tzh/tzhWorkBench.htm?empNo=112233" class="btn">淘-首页</a>
</div>

<div class="head" style="width:120px">
	<a href="${contextPath}/tzhServiceFile/tzhServiceFileDetail.htm?orderId=5111" class="btn">淘-订单</a>
</div>

<div class="line"></div>

<div class="head" style="width:120px">
	<a href="javascript:resetRedis('all')" class="btn">一键重置</a>
</div>

<div class="clear"></div>

<div class="head" style="width:120px">
	<a href="javascript:resetRedis('sysReference')" class="btn">重置系统参数</a>
</div>

<div class="head" style="width:120px">
	<a href="javascript:resetRedis('reference')" class="btn">重置业务参数</a>
</div>

<div class="clear"></div>

<div class="head" style="width:120px">
	<a href="javascript:resetRedis('store')" class="btn">重置门店</a>
</div>

<div class="head" style="width:120px">
	<a href="javascript:resetRedis('product')" class="btn">重置服务</a>
</div>

<div class="clear"></div>

<div class="head" style="width:120px">
	<a href="javascript:resetRedis('sku')" class="btn">重置配件</a>
</div>

<div class="head" style="width:120px">
	<a href="javascript:resetRedis('carModel')" class="btn">重置车型</a>
</div>

<div class="clear"></div>

<div class="head" style="width:120px">
	<a href="javascript:resetRedis('maintenance')" class="btn">重置保养</a>
</div>

<div class="head" style="width:120px">
	<a href="javascript:resetRedis('artificer')" class="btn">重置技师</a>
</div>

<div class="line"></div>

<div class="head" style="width:120px">
	<a href="javascript:resetRedis('shopping')" class="btn">重置购物车</a>
</div>

<div class="line"></div>

<div class="head" style="width:120px">
	Key：
</div>

<div class="head" style="width:120px">
	<a href="javascript:getRedis()" class="btn">获取Redis</a>
</div>

<div class="clear"></div>

<div class="head">
	<input id="redisKey" name="redisKey" value="" style="width:300px"/>
</div>

<div class="clear"></div>

<div class="head" style="width:120px">
	Value：
</div>

<div class="clear"></div>

<div class="head">
	<textarea id="redisValue" name="redisValue" style="width:300px;height:200px" readonly></textarea>
</div>

<!--
<div class="line"></div>

<div class="head" style="width:120px">
	<a href="javascript:checkJsapi()" class="btn">检查JsApi</a>
</div>
-->
<footer></footer>
<#include "/common/footer.ftl" encoding="UTF-8">
<script type="text/javascript">
function setOpenId() {
	
	var url=$.context+"/cookie/setCookie.htm";
	var param = {										//数据提交
		"openId":$("#openId").val(),
		"openType":$("#openType").val(),
		"cxId":$("#cxId").val(),
		"x":$("#x").val(),
		"y":$("#y").val(),
		"key":$("#userKey").val()
	};		
	$.getajax(url, param, function(data){
		if (data.result == $.dataResult.SUCCESS) {
			alertObj("设定成功！");
		} else {
			alertObj("设定失败！");
		}
	});
}

function createMenu() {
	
	var url=$.context+"/cookie/createMenu.htm";
	var param = {										//数据提交
	};		
	$.getajax(url, param, function(data){
		if (data.result == $.dataResult.SUCCESS) {
			alertObj("创建成功！");
		} else {
			alertObj("创建失败！");
		}
	});
}

function resetRedis(index) {
	
	var url=$.context+"/cookie/resetRedis.htm";
	var param = {									//数据提交
		"index":index
	};		
	$.getajax(url, param, function(data){
		if (data.result == $.dataResult.SUCCESS) {
			alertObj("重置成功！");
		} else {
			alertObj("重置失败！");
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

function checkJsapi(){
	wx.checkJsApi({
      jsApiList: [
        'onMenuShareTimeline',
        'onMenuShareAppMessage',
        'onMenuShareQQ',
        'onMenuShareWeibo',
        'onMenuShareQZone'
      ],
      success: function (res) {
        alert(JSON.stringify(res));
      },
    });
}

function getParam(){
	$("#userInfo").val("");

	var url=$.context+"/cookie/getParam.htm";
	var param = {										//数据提交
		"sourceType":$("#sourceType").val(),
		"userId":$("#cxId").val(),
		"openId":$("#openId").val(),
		"cityName":$("#cityName").val(),
		"localX":$("#x").val(),
		"localY":$("#y").val()
	};
	if (!param.sourceType) {
		alertObj("来源必须填写！");
		return;
	}
	
	$.getajax(url, param, function(data){
		if (data.result == $.dataResult.SUCCESS) {
			var param = "?userInfo="+data.obj;
			$("#userInfo").val(param);
		} else {
			alertObj("获取失败！");
		}
	});
}

function getRedis(){
	$("#userInfo").val("");

	var url=$.context+"/cookie/getRedis.htm";
	var param = {										//数据提交
		"key":$("#redisKey").val()
	};
	if (!param.key) {
		alertObj("Key必须填写！");
		return;
	}
	
	$.getajax(url, param, function(data){
		if (data.result == $.dataResult.SUCCESS) {
			$("#redisValue").val(data.obj);
		} else {
			alertObj("获取失败！");
		}
	});
}
</script>
</body>
</html>