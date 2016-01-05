<!DOCTYPE html>
<html>

<head>
    <#include "/common/header.ftl" encoding="UTF-8">
    <title>轮胎</title>
    <link rel="stylesheet" href="<@jci.domain url='/css/flexslider.css'/>">
    <script src="<@jci.domain url='/js/jquery.flexslider-min.js'/>"></script>
    <style>
     .flexslider .slides > li a{display: block; width: 100%;}
     .flex-control-paging li a{width:1rem;height: 1rem;}
     .flex-control-paging li a.flex-active{background: #ff6600;}
     .flex-control-paging li a{background: #cccccc;}
     .flex-control-nav{bottom: -2rem;}
     .flexslider .slides > li a {padding: 0 8rem;display: block;}
     .flexslider .slides img{width:15rem;height: 15rem;}
     .pop-open{overflow: hidden;}
     .pop-content-ct{overflow: hidden;}
    </style>
</head>

<body class="tire-detail">
    <#include "/common/rem.ftl" encoding="UTF-8">
   <section class="slide">
   	 <div class="car-index-banner flexslider">
            <ul class="slides">
                <li>
                    <a href="##">
                        <img src="${skuInfo.picUrl}" alt="tyrePic" />
                    </a>
                </li>
            </ul>
        </div>
        
   </section>
   <!-- slide end -->
   <section class="head">
   	  <div class="title">${skuInfo.skuName}</div>
   	  <div class="price">
   	  	<span>¥${skuInfo.promotionPrice}</span><span>订金</span><span>¥50</span><span>/条</span><span>已售${skuInfo.salesNum}</span>
   	  </div>
   	
   </section>
   <section class="content">
   	<ul>
   	  <li>
   	  	 <span>商品规格</span><span>${skuInfo.spec}</span>
   	  </li>
   	  <li>
   	  	 <span>商品促销 </span><span class="sale">${productPay.promotionName}起</span>
   	  </li>
   	  <li>
   	  	 <span>备货信息 </span><span >现在下单，${time}可到店安装</span>
   	  </li>
   	</ul>  
   </section>
   <section class="des-title">商品描述</section>
   <section class="descripe">
   ${skuInfo.desc}
   </section>

   <section class="payBtn">
     <div>立即下单</div>
   </section>
   <input type="hidden" name="serviceCode" id="serviceCode" value="${productList[0].code}" />
    <#include "/common/footer.ftl" encoding="UTF-8">
   
 <script>
   document.addEventListener("touchstart", function(){}, true);//弹窗后禁止页面滚动
    (function() {
    	$('.flexslider .slides > li a').width($(document).width());
        var aLoopT = true,
            aLoopF = false;
        if ($(".slides li").length > 1) {
            $('.car-index-banner').flexslider({
                animation: "slider",
                slideshowSpeed: 3000,
                directionNav: false,
                animationLoop: aLoopT
            });
        } else {
            $('.car-index-banner').flexslider({
                animation: "slider",
                slideshowSpeed: 3000,
                directionNav: false,
                animationLoop: aLoopF
            });
        }
    })();
</script>
<script>
	$(function () {
		var promotion=${productVojson};
		$("#serviceCode").val(promotion[0].code);
		
		var html='<section class="pop"><div class="title">更换数量</div><ul>'
		<#list productList as product>
		+ '<li <#if product_index=0>class="active"</#if>>${product.name} ${product.productPay.promotionName}</li>'
		</#list>
		+ '</ul><div class="pay"><div><span>线上支付订金</span><span id="dingjin"></span></div>'
		+ '<div><span>余额到店支付</span><span id="payMoney"></span></div>'
		+ '<a href="#" style="display:block;overflow:hidden;" class="btn">'
		+ '<div>确认下单</div></a></div></section>';
		
	    $.openLayer(html);
	    var _top= $(window).height()-$('.pop-content-ct').height();
	    $('.pop-content-ct').css("transition","0");
	    $('.pop-content-ct').css("top",$(window).height());
	    //修复浏览器中有搜索栏 导致window.height变化
	    $(document).on('scroll',function () {
	    	$('.pop-content-ct').css("transition","0");
	    	$('.pop-content-ct').hide();
	    	$('.pop-content-ct').css("top",$(window).height());
	    })
	    $('.pop-content-ct').on('touchmove',function () {
		   	 return false;
		   });
	  
	   //修复end
	   
	    
	    $('#dingjin').html('¥'+promotion[0].payPrice);
	    $('#payMoney').html('¥' + (promotion[0].promotionPriceAfterPay - promotion[0].payPrice).toFixed(2));
	    console.log((promotion[0].promotionPriceAfterPay - promotion[0].payPrice).toFixed(2))
	     $('.payBtn').on('click',function (event) {
	    	$(".pop-layer").show();
	    	$('.pop-content-ct').show();
	    	$('.pop-content-ct').css("transition","300ms");
	    	$('.pop-content-ct').css("top",($(window).height()-$('.pop-content-ct').height())+"px");
	    	$('.mask').fadeIn();
	    	$('body').addClass('pop-open');
	    	 return false;
	    })
	    
	    $('.pop ul li').on('click',function () {
	    	$(this).addClass('active').siblings().removeClass('active');
	    	var index=$(this).index();
	    	$('#dingjin').html('¥'+promotion[index].payPrice);
	    	$('#payMoney').html('¥'+ (promotion[index].promotionPriceAfterPay - promotion[index].payPrice).toFixed(2));
	    	$("#serviceCode").val(promotion[index].code);
		     return false;	
	    })
	   		//点击确认跳转页面
	    	$('.pay').on('click',function () {
			     var url = "${contextPath}/tyre/nextStep.htm";
			     var param ={
		                       skuCode: ${skuInfo.skuCode},
		                       serviceCode: $("#serviceCode").val()
		                     };
		                     
		    	 $.postajax(url, param, function(data) {
		                        if (data.result == $.dataResult.FAILD) {
		                            comAlertObj(data.msg);
		                        } else {
		                            window.location.href = '${contextPath}/service/toConfirm.htm';
		                        }
		                    });
		          return false;
	    	})
	    	
	    	
	    	
	    	
	    
	})
</script>

   
</body>


</html>
