<!DOCTYPE html>
<html>
<head>
<title>服务网点</title>
<#include "/common/header.ftl" encoding="UTF-8">

</head>

<body>
<#include "/common/rem.ftl" encoding="UTF-8">

<div class="stroe-area choose-store">
    <h2>${areaName}当前有${storeCount}家门店</h2>
    <ul>
        <#list storeList as store>
        <li data-url="${contextPath}/store/setStore.htm?storeId=${store.storeId}" <#if store.storeId == storeIdCurrent>class="current"</#if>>
            
                <dl>
                    <dt>
                        <b>${store.storeName} <#if store.storeId == storeIdLast><s>去过</s></#if></b>
                        <span>
                            <#if (store.distanceFromMe>0 && store.distanceFromMe<1000) >
                                ${(store.distanceFromMe)?string('0.0')}m
                            <#elseif ((store.distanceFromMe>1000)) >
                                ${(store.distanceFromMe/1000)?string('0.0')}km  
                            </#if>
                        </span>
                    </dt>
                    <dd>
                        <i class="iconfont icon-location2"></i>
                        <span>${store.address}</span>
                    </dd>
                </dl>
                <i class="iconfont icon-gouxuan"></i>
        </li>
        </#list>
    </ul>
</div>


<#include "/common/footer.ftl" encoding="UTF-8">
<script type="text/javascript">
$(function(){
    $(".choose-store li").on("click",function(e){
        $(this).find(".icon-gouxuan").show().parents("li").siblings().find(".icon-gouxuan").hide();
        if($(this).attr("data-url")){
            window.location.href = $(this).attr("data-url");
            return false;
        }
    });
})
</script>
</body>
</html>