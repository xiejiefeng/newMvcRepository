<!DOCTYPE html>
<html>
<head>
<title>洗车</title>
<#include "/common/header.ftl" encoding="UTF-8">
<link rel="stylesheet" type="text/css" href="<@jci.domain url='/css/reset.css'/>">
<style>
body{background: #F5F5F5;}
/*store choose*/
.servListTitle{ height:3.6rem; line-height:3.6rem;background: #FFF;border-bottom:1px solid #e7e7e7;margin-bottom: 1rem; font-size:1.2rem; color:#666; text-indent:1rem; font-weight:bold;	}
.servListTitle span{color: #03a9f4; }
.chooseStore{font-size:1.2rem;}
.chooseStore ul li { background:#fff; color:#999;   border-bottom:1px solid #e7e7e7;margin-bottom: 1rem;}
.chooseStore ul li dl{ padding:1.5rem 1rem 1rem 1rem;font-size:0.875em;position:relative;}
.chooseStore ul li.current{ }
.chooseStore ul li dl dt span{display:inline;color:#fff;padding:0 0.5rem;font-size:1.2rem;border-radius:0.3rem;color:#333;}
.chooseStore ul li dl dt{font-weight:bold;font-size:1.4rem;padding-bottom: 1rem; color: #333333;overflow: hidden;}
.chooseStore ul li dl dt div:nth-last-of-type(2){float: left;}
.chooseStore ul li dl dt div:nth-last-of-type(1){float: right;text-align: right;font-weight: normal;}

.chooseStore ul li .wash-price{ color:#999; line-height:20px;padding-bottom: 1rem;}
.chooseStore ul li .wash-price span:nth-of-type(2){font-size: 1.4rem; color: #ff6600; padding: 0;}
.chooseStore ul li dl dd div:nth-last-of-type(2){float: left;}
.chooseStore ul li dl dd div:nth-last-of-type(1){float: right;}
.chooseStore ul li dl dd {color: #999999;font-size: 1.2rem;overflow: hidden;}
.chooseStore ul li dl dd i{ display:block; float:left;  width:1.5rem; height:2rem; font-size: 1.2rem; color: #999999;}
.chooseStore ul li dl dd span{display:block;float:left; height:2rem;}
.chooseStore ul li .storeDistant{ color:#999; line-height:20px;text-align: right;}

.chooseStore .mapRightIcon{position:absolute;right:0;top:0;width:8rem;height:100%;line-height:6.8rem;padding-right:0.5rem;font-size: 1.2rem;color: #999999;}
.chooseStore .wash-card{height: 4.4rem;line-height: 4.4rem;border-top:1px solid #e7e7e7;position: relative;}
.chooseStore .wash-card .title{float: left;padding-left: 1rem;}
.chooseStore .wash-card .title i{font-size: 1rem;padding-right: 0.5rem;}
.chooseStore .wash-card .title span:nth-of-type(1){color: #FF6600;padding-right: 0.5rem;}
.chooseStore .wash-card .btn{float: right;width: 6.5rem;line-height: 2rem;text-align:center;color: #FF6600;border: 1px solid #FF6600;border-radius:0.5rem;margin-top: 1rem;margin-right: 1rem;}
.chooseStore .wash-card  a{display: block; overflow: hidden;position: absolute;right: 0rem;top: 0rem;}
.chooseStore .pop-box{ width:100%; height:100%; position:absolute; top:0; left:0; text-align:center; font-size:0; } /*font-size：0是为了避免设置display：inline-block的元素产生空隙*/
.chooseStore .pop-box .vertical-span{display:inline-block; vertical-align:middle; height:100%; }
.chooseStore .pop-box .pop-box-content{ display:inline-block; vertical-align:middle; height:auto; font-size:1.2rem;  text-align:center;}
.chooseStore .pop-box .pop-box-content img{ width:50%; float:left;}
@-webkit-keyframes card
{
	100%
	{
		-webkit-transform:translateY(0px);
		opacity:1;
	}	
}
.chooseStore .wash-pop{position: fixed;bottom:0rem;width: 100%;height: 4rem; line-height: 4rem;background: rgba(0,0,0,0.75);color: #fff;padding-left: 1rem;
                       -webkit-transform:translateY(4rem);transform:translateY(4rem); opacity:0; -webkit-animation:1s card; animation:1s card; -webkit-animation-fill-mode:forwards; animation-fill-mode:forwards;
}
.chooseStore .wash-pop i{color: #fff;}
.chooseStore .wash-pop i:nth-of-type(1){font-size: 1.4rem;padding-right: 1rem;}
.chooseStore .wash-pop i:nth-of-type(2){font-size: 1.2rem;padding-left: 1rem;}
</style>

</head>

<body>
<#include "/common/rem.ftl" encoding="UTF-8">
<h2 class="servListTitle">您所在的城市<span>${areaName}</span>，有以下门店</h2>
<section class="chooseStore">
<ul>
  <#list storeList as store>
  <li id="shop_${storeId}" data-url="${contextPath}/store/detail_${store.storeId}.htm">
    <dl>
        <dt><div>${store.storeName}</div><div class="wash-price"><span>普洗价</span><span>￥${cardPrice!}</span></div></dt>
        <dd>
        	<div><i class="iconfont icon-storeadress"></i>${store.address}</div>
        	<div class="storeDistant">
						    <#if (store.distanceFromMe>0)>
						    	${(store.distanceFromMe/1000)?string('0.0')}km
						    </#if>
			</div>
        </dd>
            
    
    </dl>
    
    <div class="wash-card">
    	  <div class="title"><i class="iconfont icon-washcard"></i><span>5次洗车卡100元</span><span>原价125元</span></div>
    	  <div class="btn" data-url="${cardPath!}">立即购买</div>
    </div>
  
  </li>
  </#list>
</ul>
<#if (cardSize!=0)>
<div class="wash-pop">
	<i class="iconfont icon-washcard"></i><span>您已有${cardSize!}张洗车卡，立即去查看</span><i class="iconfont icon-arrows"></i>
</div>
</#if>
</section>
<#include "/common/footer.ftl" encoding="UTF-8">
<script type="text/javascript">
$(function(){
	$(".chooseStore li").on("click",function(){
		goUrl ($(this))
	});
	$(".btn").on("click",function(){
		goUrl ($(this))
		return false;
	});
	
	function goUrl (that) {
		if(that.attr("data-url")){
			window.location.href = that.attr("data-url");
		}
	}
	
})
</script>
</body>
</html>
