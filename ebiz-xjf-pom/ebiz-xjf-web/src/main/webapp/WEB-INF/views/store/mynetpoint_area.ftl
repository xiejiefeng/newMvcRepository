<!DOCTYPE html>
<html>
<head>
<title>服务网点</title>
<#include "/common/header.ftl" encoding="UTF-8">
</head>

<body>
<#include "/common/rem.ftl" encoding="UTF-8">
<div class="stroe-area">
    <div class="choose">
        <span>${area.areaName}</span><i class="iconfont icon-arrows"></i>
        <select>
            <#list areaList as a>
            <option value="${a.areaCode}" <#if a.areaCode == area.areaCode>selected</#if>> ${a.areaName} </option>
            </#list>
        </select>
    </div>
    
    <#list areaList as area>
    <#assign storeList=storeMap[area.areaCode] >
    <ul class="<#if area.areaCode != areaCode>hide</#if>" id="area${area.areaCode}">
        <#list storeList as store>
        <li>
            <a href="${contextPath}/store/detail_${store.storeId}.htm">
                <img src="<#if store.image1??&& store.image1?length gt 0>${store.image1}<#else><@jci.domain url='/images/default-store.png'/></#if>" >
                <dl>
                    <dt>
                        <b>${store.storeName}</b>
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
            </a>
        </li>
        </#list>
    </ul>
    </#list>
</div>

<#include "/common/footer.ftl" encoding="UTF-8">
<script type="text/javascript" src="<@jci.domain url='/js/maintenance/iscroll.js'/>"></script>
<script type="text/javascript">
    function sltControl() {
        $("ul[id='area${area.areaCode}']").show();
        $(".choose select").change(function() {
            var oSltOpt = $(this).find("option:selected").text();
            var areaCode = $(this).find("option:selected").val();
            $(this).siblings('span').text(oSltOpt);
            $("ul[id='area"+areaCode+"']").show();
            $("ul[id!='area"+areaCode+"']").hide();
        });
    };
    sltControl();
</script>


</body>
</html>