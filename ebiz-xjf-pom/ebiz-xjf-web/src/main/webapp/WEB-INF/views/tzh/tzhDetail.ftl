<!DOCTYPE html>
<html>
<head>
<title>淘智汇</title>
<#include "/tzh/common/tzh_header.ftl" encoding="UTF-8">
<style>
	body{padding-bottom:20px; background:#e0e0e0;  }
.plr-30{
    padding-left: 4.6875%;
    padding-right: 4.6875%;
}

header.headerTit{
    border-bottom: 1px solid #ededed;
    font-size: 1em;
    line-height: 3em;
    color: #232323;;
    background-color: #fff;
}
.pro-txt{
    background-color: #fff;
    padding:0.6em 4.6875%;
    border-bottom: 1px solid #e0e0e0;
    border-top: 1px solid #e5e5e5;
    font-size: 0.875em;
}
.pic-tits{
    width:20%;
    max-width: 116px;
    margin-right: 3.125%;
    float: left;

}
.pro_sign{
    font-size: 0.75em;
    color: #858585;
}
.pro_money{
    color: #858585;
    font-size: 1.075em;
    font-weight: bold;

}
.item-values{
    width: 72.1875%;
    float: left;
    color: #232323;
}
.pic-tits{
    line-height: 1.6em;
    color: #888;
}
.bigTits{
    font-size: 0.875em;
    color: #b4b4b4;
    line-height: 2.5em;
}
.carsServiceList .pic-tits,.carsServiceList .item-values{
    line-height:1.6em;
}



.headerTit .tits-head{
    border-bottom: 1px solid #e0e0e0;
}
.headerTit div i{
    display: block;
    font-size: 0.9em;
    font-style: normal;
}
.tits-left{
    float: left;
    width: 80%;
    font-size: 1.075em;
}
.tit-rig{
    float: right;
}
.money-total{
    background-color: #ff9a14;
    padding: 0.6em 4.6875%;
    border-bottom: 1px solid #e0e0e0;
    border-top: 1px solid #e5e5e5;
    font-size: 0.875em;
}
.money-total .tits-left,.money-total .pro_sign,.money-total .pro_money{
    color: #fff;
}

body{margin:0;}
.taocontent,.taohead{ padding:15px 10px 0 10px;}
.taocontent .item-values{ color:#606366;}
.taocontent .pro-txt{ margin-bottom:11px; border:0px; padding:0;}
.taocontent .carsServiceList{  background:#fff; border-bottom:1px solid #e6e9ea;  padding-left:8px; clear:both;}
.taocontent .carsServiceList .pic-tits,.taocontent  .carsServiceList .item-values{ line-height:38px;}
.taocontent .bigTits{background:#56c5d4; line-height:46px; height:46px; color:#fff; font-size:16px;}
header.taohead{ background:none; color:#7e7e80; border:0; }
header.taohead .tits-head{background:#fff; border:none; }
.taocontent .mt-10{ background:#fff; line-height:38px; padding:0 10px; margin:0; border-radius:0;border-bottom:1px solid #e6e9ea;}
.taocontent .money-total .tits-left, .taocontent .money-total  .pro_sign,.taocontent   .money-total .pro_money{ color:#51c5d4;}
.taocontent .pro_money{ font-weight:100;}
.taocontent .mt-10 .tits-left,.taocontent .tit-rig{color:#606366;}
.taocontent .money-total .tits-left,.taocontent .money-total .tit-rig{color:#51c5d4;}
.taocontent .money-total{ margin-top:0px; border-top:none;}
.taocontent .money-total .tits-left{width:70%;}
.taocontent .tits-left{width:100%;}

.taocontent .evaltao .carsServiceList .evalIcon{ float:none; width:63px; height:63px; box-sizing:border-box; margin:0 auto; text-align:center; border-radius:63px; border:2px solid #fff;}
.taocontent .eval{background: -webkit-radial-gradient(circle, #ebe6e3, #fff);padding-bottom:10px;}

.taocontent .carsServiceList .evalIcon{ background:url(<@jci.domain url='/images/evalIconSmall.png'/>) no-repeat; background-size:cover; text-indent:40px;}
.taocontent .carsServiceList .evalIcon01{ background-position:0px -1px}
.taocontent .carsServiceList .evalIcon02{ background-position:0 -82px}
.taocontent .carsServiceList .evalIcon03{ background-position:0 -163px}
.taocontent .carsServiceList .evalIcon04{ background-position:0 -244px}
.taocontent .carsServiceList .evalIcon05{ background-position:0 -326px}
.taocontent .eval .pic-tits, .eval .item-values{ height:50px; line-height:50px;}
.taocontent .evaltao .carsServiceList p{ text-align:center; color:#cccccc; text-shadow:0px 0px 9px rgba(0, 0, 0, 0.75); margin-bottom:5px; font-size:16px;} 
.taocontent .evaltao .item-values{ height:auto; width:100%; padding-right:8px;line-height:25px; box-sizing:border-box;}
.taocontent .eval{ margin:0; padding-top:10px;}
.taocontent .eval:before{ display:none;}
.taocontent .eval:after{ display:none;}

</style>
</head>
<body>
<header class="headerTit taohead">
    <div class="plr-30 tits-head clearfix">
        <!--<strong>预约服务</strong>-->
        <i>订单号：${orderInfo.orderNo!}</i>
    </div>
</header>
<section class="taocontent">
<div class="plr-30 bigTits">
        服务门店
</div>
<div class="pro-txt">
    <article class="carsServiceList clearfix">
        <div class="pic-tits">门店名称</div>
        <div class="item-values">
            ${orderInfo.storeName!}
        </div>
    </article>
    <article class="carsServiceList clearfix">
        <div class="pic-tits">服务地址</div>
        <div class="item-values">
            ${orderInfo.storeAddress!}
        </div>
    </article>
    <article class="carsServiceList clearfix">
        <div class="pic-tits">服务日期</div>
        <div class="item-values">
            ${orderInfo.orderWeek!}
        </div>
    </article>
    <article class="carsServiceList clearfix">
        <div class="pic-tits">服务电话</div>
        <div class="item-values">
            <a href="tel:${orderInfo.storeTelPhone!}">${orderInfo.storeTelPhone!}</a>
        </div>
    </article>
</div>
<#if orderInfo.assessScore??>
<div class="plr-30 bigTits">
    服务评价
</div>
<div class="pro-txt evaltao">

    <article class="carsServiceList clearfix eval">
        <div class="item-values evalIcon evalIcon0${orderInfo.assessScore}">
        </div>
        <!--<p>${orderInfo.assessTip!}</p>-->
        
    </article>
    <#if orderInfo.assessInfo != ''>
    <article class="carsServiceList clearfix">
        <div class="item-values" style="min-height:100px;">
        ${orderInfo.assessInfo!}
        </div>
    </article>
    </#if>
</div>
</#if>
<div class="plr-30 bigTits">
    服务车辆
</div>
<div class="pro-txt">
    <article class="carsServiceList clearfix">
        <div class="pic-tits">服务车辆</div>
        <div class="item-values">
            ${orderInfo.carName}
        </div>
    </article>
    <article class="carsServiceList clearfix">
        <div class="pic-tits">车牌号</div>
        <div class="item-values">
            ${orderInfo.carPlate}
        </div>
    </article>
</div>
<div class="plr-30 bigTits">
    个人信息
</div>
<div class="pro-txt">
    <article class="carsServiceList clearfix">
        <div class="pic-tits">姓名</div>
        <div class="item-values">
            ${orderInfo.custName}
        </div>
    </article>
</div>
<div class="plr-30 bigTits">
    订单详情
</div>
<#list orderInfo.orderDetailInfoList as detail >
	<div class="plr-30 mt-10 pro-txt clearfix">
        <p class="tits-left">${detail.name!}</p>
    </div>
</#list>
<div class="plr-30 mt-10 money-total clearfix">
    <p class="tits-left">订单总金额</p>
    <p class="tit-rig"><span class="pro_sign">￥</span><em class="pro_money">${orderInfo.orderPaidMoney}</em></p>
</div>
</section>
</body>
</html>