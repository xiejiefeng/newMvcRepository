<!DOCTYPE html>
<html>
<head>
<title>网点详情</title>
<#include "/common/header.ftl" encoding="UTF-8">
<style>
.net-intro{clear:both;border-top:1px solid #e5e5e5;border-bottom:1px solid #e5e5e5;font-size:1.2rem; color: #666; line-height: 3.6rem;}
.net-article{padding:1rem 1rem;border:1px solid #e5e5e5;border-top:none;font-size:1.2rem;line-height:1.8rem;background-color: #fff}
</style>

</head>
<body>
<#include "/common/rem.ftl" encoding="UTF-8">

<div class="service-info">
    <div class="title">
        <img src="<#if store.image1??&& store.image1?length gt 0>${store.image1}<#else><@jci.domain url='/images/default-store2.jpg'/></#if>" >
        <div >
            <b>${store.storeName}<span><#if store.businesstime??&& store.businesstime?length gt 0>(${store.businesstime!})</#if></span></b>
	        <#if (store.distanceFromMe>0) >
	        	<span>${(store.distanceFromMe/1000)?string('0.0')}km</span>
	        </#if>
        </div>
    </div>
    <ul class="detail">
        <li>
            <div><a href="${contextPath}/store/toMapPage.htm?storeId=${store.storeId}"><span>${store.address!}</span><i class="icon-arrows iconfont"></i></a>
            </div>
            <a href="tel:${store.telephone}"><i class="iconfont icon-call"></i></a>
        </li>
    </ul>
</div>

<div class="service-choose" style="background:#fff">
    <h3>门店技师</h3>
    <ul>
    	<#list artificerInfo as artificer>
        <li>
        	<a href="${contextPath}/employee/empScoreInit.htm?storeId=${store.storeId}&empNo=${artificer.artificerNo}">
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


<div class="service-describe">
    <h3>门店介绍</h3>
    <div>${store.intro}</div>
</div>

<#include "/common/footer.ftl" encoding="UTF-8">
<!--<a href="${contextPath}/store/myservice.htm" class="btn-bottom">全部服务</a>-->
</body>

</html>