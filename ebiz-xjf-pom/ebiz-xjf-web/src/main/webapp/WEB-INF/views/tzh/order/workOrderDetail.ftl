<!DOCTYPE html>
<html>
<head>
	
	<title>工单详情</title>
	<#include "/tzh/common/tzh_header.ftl" encoding="UTF-8">
    <link rel="stylesheet" href="<@jci.domain url='/tzh/css/dropload.css'/>" type="text/css">
    <script src="<@jci.domain url='/js/dropload.min.js'/>"></script>
    <style>
    	.pop-open{
    		overflow: hidden;
    	}
    </style>
</head>
<body class="order-detail">
<#include "/tzh/common/tzh_rem.ftl" encoding="UTF-8">


<section class="work-order work-order-detail">
	<div class="order-title">
		<span>${order.carPlate}</span><span><i>已结算</i></span><span class="color-999">订单编号：${order.orderNo}</span>
	</div>
	<div class="order-content">
		<div class="order-con order-con-first">
			<span>${order.custName}</span><span>
			    		<a href="tel:${order.mobilePhone}">
			    			<b class="phone">
							   <i class="iconfont icon-dianhua"></i>${order.mobilePhone}
						     </b>
						</a>
	    		    </span>
	    		    <!--<span>
	    		   		<#if order.createFlg=1 && order.constructorFlg!=1><i class="open">开单</i>
	    		   		<#elseif order.constructorFlg=1 && order.createFlg!=1><i class="do">施工</i>
	    		   		<#elseif order.constructorFlg=1 && order.createFlg=1><i class="open">开单</i><i class="do">施工</i></#if>
		    		</span>-->
		</div>
		<div class="order-con carStyle">
			<span><img src="<#if order.logoUrl??>${order.logoUrl}<#else><@jci.domain url='/images/car-brand-defalut.png'/></#if>"></span>&nbsp;&nbsp;<span style="padding-left: 0.5rem;">${order.carName}</span>
		</div>
		<div class="order-con shigong-person">
			<span>施工人</span>
			<span style='width: 26rem;'>
				<#list order.artificerInfo as detail>
					<#if detail_index == 0>
						${detail.artificerName}
					<#else>
						&nbsp;/&nbsp;${detail.artificerName}
					</#if>
				</#list>
			</span>
		</div>
		<div class="order-con">
			<span>开单人</span>
			<span>
				${order.createUserName}
			</span>
		</div>
		<div class="order-con">
			<span>下单时间</span>
			<span>${order.createTime}</span>
		</div>
		<div class="order-con">
			<span>结算时间</span>
			<span>${order.orderDateTime}</span>
		</div>

		<div class="order-ct">
			<div class="order-con">
				<span >订单总金额</span><span>${order.orderPaidMoney}（已支付）</span>
			</div>

		</div>
		<div class="order-con">
			<span>订单状态</span>
			<span>已结算</span>
		</div>
		<div class="order-con eval">
			<#if order.assessScore?? && order.assessScore != ''>
				<span>服务评价</span>
				<span>
						
					    <div class="star">
	                            <p>
	                                <b></b>
	                                <b class="score" style="width: #{(order.assessScore?number)*20}%;"></b>
	                            </p>
	                    </div>
	                    <#if order.assessInfo?? && order.assessInfo != ''>
					    	<div>${order.assessInfo}</div>
					    </#if>
						<!--<div>评价内容，不超过500个中文字符。评价内容填写在这里</div>-->
				</span>
			</#if>
		</div>
		</div>

	</div>
</section>
<section class="category">
	<div class="title">
		<span>服务项目</span>
	</div>
	<div class="category-content">
        <#list order.orderDetailInfoList as detail>
		<table>
		<thead>
		<th  colspan="4">项目编号&nbsp;${detail.code}</th>
		</thead>
		<tbody>
		<tr>
		<td>项目名称&nbsp;</td><td colspan="3">${detail.name}</td>
		</tr>
		<!--
		<tr>
		<td>金&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;额</td><td colspan="3"  class="price-r">${detail.price}</td>
		</tr>-->
		<#if detail.ssScore?? && detail.ssScore != ''>
		<tr>
		    <td>客户评分</td>
			<td colspan="3">
	           <div class="star">
	                        <p>
	                            <b></b>
	                            <b class="score" style="width: #{(detail.ssScore?number)*20}%;"></b>
	                        </p>
	            </div>
			</td>
		</tr>
		</#if>
		</tbody>
		</table>
		</#list>
		<!--<table>-->
			<!--<thead>-->
			<!--<th  colspan="4">项目编号 S0066</th>-->
			<!--</thead>-->
			<!--<tbody>-->
			<!--<tr>-->
				<!--<td>项目名称</td><td colspan="3">7座及SUV洗车</td>-->
			<!--</tr>-->
			<!--<tr>-->
				<!--<td>金&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;额</td><td  class="price-r">￥35</td><td>折后金额</td><td class="price-r">￥10</td>-->
			<!--</tr>-->
			<!--<tr>-->
				<!--<td>促销活动</td><td colspan="3">满二送一</td>-->
			<!--</tr>-->
			<!--<tr>-->
				<!--<td>备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注</td><td colspan="3">最终解释权归车享家所有</td>-->
			<!--</tr>-->
			<!--</tbody>-->
		<!--</table>-->
	</div>
</section>

<section id="service">
	
</section>
<script>

</script>

</body>
</html>
