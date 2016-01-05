<!DOCTYPE html>
<html>
<head>
<title>车型排量年份选择</title>
<#include "/common/header.ftl" encoding="UTF-8">
<style>
.text-overflow {
        display: inline-block;
        white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis;
    }   
        /*选择车型*/
.carStyle-header{
    background-color: #fff;
    padding-left: 1.2rem;
    font-size: 1.4rem;
    border-bottom: 1px solid #e7e7e7;
    overflow: hidden;
}
.carStyle-header p{display: block;float: left;
    line-height: 4.6rem;
    height: 4.6rem;
    border-bottom: 1px solid #e5e5e5;
}
.carStyle-header p:last-child{
    border: none;
}
.carStyle-header p span{display:block;float:left;color:#ccc;}
.carStyle-header .logo{display: block;float: left;width: 3.6rem;height: 4.6rem;line-height: 4.6rem;}
.carStyle-header .logo img{width: 2.4rem;height: 2.4rem;display: block;margin-top:1.2rem; }
.carStyle-header  strong{font-size: 1.4rem;}
.no-tit{
	height:.5rem;
}
.carstyle-list{
    background-color: #fff;
    border-top: 1px solid #e7e7e7;
    border-bottom: 1px solid #e7e7e7;
}
.carstyle-list dd{
    font-size: 1.4rem;
    padding: 1.2rem 0 1.2rem  1.2rem;
    color:#333;
    border-bottom: 1px solid #e5e5e5;
    position:relative;
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
.carstyle-list dd a span{font-size: 1.4rem;color:#333;}
.carstyle-list dd:last-child a{
    border-bottom: none;
}
.carstyle-list dd .icon-arrows{
    position: absolute;
    right: 1rem;
    font-size: 1.4rem;
    color: #bfbfbf;
    top: 50%;
    -webkit-transform: translate(-50%,-50%);
    -ms-transform: translate(-50%,-50%);
    transform: translate(-50%,-50%);
}
.sure-txt{
    width: 90%;
    margin: 0 auto;
    color: #969ba0;
    font-size: 1em;
    line-height: 2.4em;
}

</style>

</head>
<body>
<#include "/common/rem.ftl" encoding="UTF-8">
<header class="carStyle-header">
    <p><span class="logo"><img src="${logoUrl}" alt="logo" onerror="errorImg(this)"/></span>
        <span class="f-14" id="brandStorage" style="color:#333">${brandName}</span><span class="iconfont arr-rig" style="padding:0 0.5rem;font-size:1.2rem;color:#333">&gt;</span>
        <span class="f-14 text-overflow" id="seriesStorage" style="color:#333">${seriesName}</span>
    </p>
</header>
<section>
    <h3 class="no-tit">&nbsp;</h3>
    <dl class="carstyle-list carvolume">
        <#list moopioList as moopio>
        <dd class="link-gray">
            <a href="${contextPath}/selectCar/confirmCar.htm?assetId=${assetId}&mdmId=${moopio.mdmId}&carYear=${moopio.carYear}">
                <span>${moopio.mouldName} ${moopio.outputName}${moopio.iomodeName} ${moopio.carYear}年产</span>
                <i class="iconfont icon-arrows"></i>
            </a>
        </dd>
        </#list>
    </dl>
</section>

<#include "/common/footer.ftl" encoding="UTF-8">
</body>
</html>