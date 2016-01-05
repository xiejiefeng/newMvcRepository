<!DOCTYPE html>
<html>
<head>
<title>厂家车系选择</title>
<#include "/common/header.ftl" encoding="UTF-8">
<style type="text/css">
	/*选择车型*/
 .text-overflow {
        display: inline-block;
        white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis;
    }	
.carStyle-header{
    background-color: #fff;
    padding:0 0 0 1rem;
    font-size: 1.4rem;
    border-bottom: 1px solid #dcdcdc;overflow: hidden;
}
.carStyle-header p{display: block;float: left;
    line-height: 4.6rem;
    height: 4.6rem;
    border-bottom: 1px solid #e5e5e5;
}
.carStyle-header p:last-child{
    border: none;
}
.carStyle-header .logo{display: block;float: left;width: 3.6rem;height: 4.6rem;line-height: 4.6rem;}
.carStyle-header .logo img{width: 2.4rem;height: 2.4rem;display: block;margin-top:1.2rem; }
.carStyle-header  strong{font-size: 1.4rem;font-weight: normal;color: #ccc;}
.carstyle-tit{
    font-size: 1.4rem;
    line-height: 3.5rem;
    border-bottom: 1px solid #e5e5e5;
    font-weight: normal;
    color: #666;
    padding-left:1rem;
}
.no-tit{
	height:.5rem;
}
.carstyle-list{
    background-color: #fff;
    border-top: .1rem solid #e7e7e7;
    border-bottom: .1rem solid #e7e7e7;
}
.carstyle-list dd{
    padding-left:1rem;
    font-size: 1.4rem;
    line-height: 4.5rem;
    border-bottom: .1rem solid #e7e7e7;
    color:#333;
}
.carstyle-list dd:last-child{
	border-bottom:none;
}
.carstyle-list dd a{
    font-size: 1.4rem;
    display: block;
    position: relative;
    padding-right:3rem;
}
.carstyle-list dd a span{font-size: 1.4rem;display:inline-block; line-height:3rem;}
.carstyle-list dd:last-child a{
    border-bottom: none;
}
.carstyle-list dd .icon-arrows{
    position: absolute;
    right: 1rem;
    font-size: 1.4rem;
    color: #bfbfbf;
}
.sure-txt{
    width: 90%;
    margin: 0 auto;
    color: #969ba0;
    font-size: 1em;
    line-height: 2.4em;
}
/**/
</style>
</head>
<body>
<#include "/common/rem.ftl" encoding="UTF-8">
<header class="carStyle-header">
    <p><span class="logo"><img src="${logoUrl}" alt="logo" onerror="errorImg(this)"/></span><span class="f-14" id="brandStorage">${brandName}</span><i style="padding:0 0.5rem;">&gt;</i><strong class="carbrand-sel">请选择车型</strong></p>
</header>
<section>
	<#list veseList as vender>
    <#if veseList?size gt 1><h3 class="carstyle-tit">${vender.venderName}</h3><#else><h3 class="no-tit">&nbsp;</h3></#if>
    <dl class="carstyle-list">
    	<#list vender.subCarModelList as series>
        <dd class="link-gray">
            <a href="${contextPath}/selectCar/toSelectCarMoopio.htm?assetId=${assetId}&brandId=${series.brandId}&venderId=${series.venderId}&seriesId=${series.seriesId}">
                <span>${series.seriesName}</span>
                <i class="iconfont icon-arrows"></i>
            </a>
        </dd>
        </#list>
    </dl>
    </#list>
</section>

<#include "/common/footer.ftl" encoding="UTF-8">
</body>
</html>