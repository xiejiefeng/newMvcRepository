<!DOCTYPE html>
<html>

	<head>
		<title>用户中心</title>
		<#include "/common/header.ftl" encoding="UTF-8">
	</head>

	<body class="userCenter">
		<#include "/common/rem.ftl" encoding="UTF-8">
		<section class="userImage">
			<img src="${wxuser.headimgurl}" />
			<p>${wxuser.nickname}</p>
			<p>${(customInfo.mobilePhone)!}</p>
		</section>
		<section class="bar bar-first">
			<a href="${contextPath}/selectCar/toSelectCar.htm?readonly=true"><div class="bar-left">
							<span class="iconfont icon-car"></span>
							<span>我的车辆</span>
						</div>
			<div class="arrow"><i class="iconfont icon-arrows"></i></div></a>
		</section>
		<section class="bar ">
			<a href="${contextPath}/card/list.htm"><div class="bar-left">
							<span class="iconfont icon-ticket"></span>
							<span>我的卡券</span>
						</div>
			<div class="arrow"><i class="iconfont icon-arrows"></i></div></a>
		</section>
		<section class="bar">
			<a href="${contextPath}/order/list.htm"><div class="bar-left">
							<span class="iconfont icon-orders"></span>
							<span>我的订单</span>
						</div>
			<div class="arrow"><i class="iconfont icon-arrows"></i></div></a>
		</section>
		<section class="chelogo"><img src="<@jci.domain url='/images/chelogo.png'/>" /></section>
		<#include "/common/footer.ftl" encoding="UTF-8">
	</body>

</html>