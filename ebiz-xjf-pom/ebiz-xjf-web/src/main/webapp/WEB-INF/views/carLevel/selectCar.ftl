<!DOCTYPE html>
<html>

	<head>
		<title>选择车辆</title>
		<#include "/common/header.ftl" encoding="UTF-8">
	</head>

	<body style="background: #efeff4;">
		<#include "/common/rem.ftl" encoding="UTF-8">
        <#if carInfoList?size = 0>
			<section class="carEmpty">
				<section class="section-title">
					<div>
						<div class="icon"><i></i></div>
						<#if readonly=false>
						<p class="text">您当前的车辆未添加</p>
						<p class="text">请先添加车辆</p>
						<#else>
						<p class="text">您当前的车辆为空</p>
						</#if>
					</div>
				</section>
			</section>
		<#else>
			<div class="car-list">
		        <h2>您当前的车辆</h2>
		        <ul>
		        	<#list carInfoList as carInfo>
		        	<li <#if readonly=false>onclick="selectCar('${carInfo.assetId}')" class="on"</#if>>
		                <img src="${carInfo.logoUrl}" alt="car-brand" onerror="errorImg(this)">
		                <dl>
		                    <dt>${carInfo.carName}</dt>
		                    <dd><span>${carInfo.plates}</span>
		                    <#if carInfo.isVerificated=1><b>已认证</b></#if>
		                    </dd>
		                </dl>
		                <#if readonly=false&&carInfo.assetId=assetIdSelected>
		                <i class="iconfont icon-gouxuan"></i>
		                </#if>
		            </li>
				    </#list>
		        </ul>
	    	</div>
		</#if>
		<#if readonly=false>
		<section class="btn2" style="background:rgba(0,0,0,.8);padding:1rem 0 1rem 0">
			<a href="${contextPath}/selectCar/toSelectCarBrand.htm" ><button>添加车辆</button></a >
		</section>
		</#if>
		<script >
		function selectCar(assetId) {
			window.location.href = "${contextPath}/selectCar/confirmCar.htm?assetId="+assetId;
		}
		
		$(".car-list").on("click", "li", function(){
			$(this).addClass("on").siblings().removeClass("on");
		});
		</script>
		<#include "/common/footer.ftl" encoding="UTF-8">
	</body>
</html>