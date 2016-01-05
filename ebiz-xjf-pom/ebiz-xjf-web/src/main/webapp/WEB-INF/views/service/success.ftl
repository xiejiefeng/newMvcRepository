<!DOCTYPE html>
<html>
<head>
<title>预约成功</title>
<#include "/common/header.ftl" encoding="UTF-8">
</head>
<body class="reserveSuccess booking">
<#include "/common/rem.ftl" encoding="UTF-8">
<section class="section-title">
  <div>
    <div class="icon"><i class="iconfont icon-succeed"></i></div>
    <p class="text">您的预约单已成功提交</p>
  </div>
</section>
<section class="pro-car infor-title ">
    <div>
         <a href="${contextPath}/store/detail_${order.storeId}.htm">
	         	<dl>
	             <dt>${order.storeName}</dt>
	             <dd  class="text-overflow">${order.storeAddress}</dd>
	         </dl>
         </a>
    </div>
    <span><i class="iconfont icon-arrows"></i></span>
    <b class="iconfont icon-store"></b>
</section>
 <section class="infor-title pro-time">
    <input  type="text" value="${order.orderWeek}" readonly/>
	<b class="iconfont icon-time"></b>
</section>
 <section class="infor-title pro-time">
 	<a href="${contextPath}/order/detail_preorder_${order.orderId}.htm">
   <p>查看预约详情</p>
   <span><i class="iconfont icon-arrows"></i></span>
  </a>
</section>
<div class="service-choose" style="background:#fff">
	<h3>可能会由以下技师为您服务</h3>
	<ul>
		<#list artificerInfo as artificer>
	    <li>
	    	<a href="${contextPath}/employee/empScoreInit.htm?storeId=${order.storeId}&empNo=${artificer.artificerNo}">
	        <p><img src="<#if artificer.artificerPic??> ${artificer.artificerPic} <#else><@jci.domain url='/images/person-default.png'/></#if>"></p>
	        <dl>
	            <dd>${artificer.artificerName}</dd>
	            <dd>${artificer.artificerLevel}</dd>
	            <dd>
	                <div class="score-star">
	                    <p>
	                        <b></b>
	                        <b class="score" style="width:#{(artificer.artificerScore?number)*20}%"></b>
	                    </p>
	                </div>
	            </dd>
	            <dd>#{artificer.artificerScore?number;M1m1}分</dd>
	        </dl>
	        </a>
	    </li>
	    </#list>
	</ul>
</div>
<footer style="position: relative;width:100%;">
 <p>如有任何问题请联系车享家客服电话</p>
 <p><i class="iconfont icon-call"></i><a href="tel:${crmTel}" data-lable="预约成功-客服电话">${crmTel}</a></p>
</footer>
<#include "/common/footer.ftl" encoding="UTF-8">
	
</body>
</html>