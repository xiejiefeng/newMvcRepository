<!DOCTYPE html>
<html>

<head>
    <title>套餐卡</title>
    <#include "/common/header.ftl" encoding="UTF-8">
</head>

<body>
    <#include "/common/rem.ftl" encoding="UTF-8">
    </script>
    <section class="car-card">
        <div id="cardList" class="car-card-list">
        </div>
    </section>
    <#include "/common/footer.ftl" encoding="UTF-8">
    <script src="<@jci.domain url='/js/laytpl.js'/>"></script>
    <script id="cardTpl" type="text/html">
        {{# switch (cardState) { case 0:
        	if(!jQuery.isEmptyObject(cardList.card)){
	        	for(var o = 0; o< cardList.card.length; o++){ 
	        		if(cardList.card.length){ 
	        			if(cardList.card[o].cardStatus === '2'){
        }}
    
        <div class="car-card-detail car-bg7">
            <h2>{{ cardList.card[o].cardTemplateName }}
            	<span>No. {{ cardList.card[o].cardNo }}</span>
            	<div><i class="iconfont icon-qiche"></i>{{ cardList.card[o].carPlates }}</div>
            </h2>
            <p>有效期至：{{ cardList.card[o].endDate }}<span>仅限{{ cardList.card[o].cityName }}地区使用</span></p>
            <ul>
                {{# for(var i = 0; i< cardList.card[o].cardItemList.length; i++){ }} 
                <li>
                	<div>
                	{{ cardList.card[o].cardItemList[i].serviceName}}
                    {{# if(cardList.card[o].cardItemList[i].totalTimes > 0 && cardList.card[o].cardItemList[i].totalTimes < 300){ }}
                    <s>（共{{ cardList.card[o].cardItemList[i].totalTimes}}次）</s>
                    {{# }}}
                    </div>
                    {{# if(cardList.card[o].cardItemList[i].remainServiceTimes < 300 ){ }}
                    <span>剩余<b>{{ cardList.card[o].cardItemList[i].remainServiceTimes}}</b>次</span>
                    {{# } else{ }}
                    <span style="color:#fff">不限次数</span>
                    </li>
                    {{# } }}
                    {{# } }}
            </ul>
            <div class="show-more"><span>点击详情</span> <i class="icon-arrows iconfont"></i></div>
        </div>
        {{# } else { }}
        <div class="car-card-detail {{cardList.color[o%6]}}">
            <h2>{{ cardList.card[o].cardTemplateName }}
            	<span>No. {{ cardList.card[o].cardNo }}</span>
            	<div><i class="iconfont icon-qiche"></i>{{ cardList.card[o].carPlates }}</div>
            </h2>
            <p>有效期至：{{ cardList.card[o].endDate }}<span>仅限{{ cardList.card[o].cityName }}地区使用</span></p>
            <ul>
                {{# for(var i = 0; i< cardList.card[o].cardItemList.length; i++){ }} 
                <li>
                	<div>
                	{{ cardList.card[o].cardItemList[i].serviceName}}
                    {{# if(cardList.card[o].cardItemList[i].totalTimes > 0 && cardList.card[o].cardItemList[i].totalTimes < 300){ }}
                    <s>（共{{ cardList.card[o].cardItemList[i].totalTimes}}次）</s>
                    {{# }}}
                    </div>
                    {{# if(cardList.card[o].cardItemList[i].remainServiceTimes < 300 ){ }}
                    <span>剩余<b>{{ cardList.card[o].cardItemList[i].remainServiceTimes}}</b>次</span>
                    {{# } else{ }}
                    <span style="color:#fff">不限次数</span>
                    </li>
                    {{# } }}
                    {{# } }}
            </ul>
            <div class="show-more"><span>点击详情</span> <i class="icon-arrows iconfont"></i></div>
        </div>
        {{# } } } }}
        {{# } else{ }}
        <div class="car-empty">
                <div><i class="icon-qianbao"></i></div>
                <p>您还没有套餐卡</p>
        </div>
        {{# } }}
        {{# break;}} {{# case 1: }} 
        {{# if(!jQuery.isEmptyObject(cardList.coupon)){ }}
        {{# for(var j = 0; j< cardList.coupon.length; j++){ }} 
        <div class="car-coupon-detail">
            <div>
                <p>{{ cardList.coupon[j].name }}</p>
                <p>NO.{{ cardList.coupon[j].No }}</p>
                <p>有效期：{{ cardList.coupon[j].data }}</p>
            </div>
            <div>
                <section>
                <p>原价：¥{{ cardList.coupon[j].presentPrice }}元</p>
                <p>￥<b>{{ cardList.coupon[j].originalPrice }}</b></p>
                </section>
            </div>
            </div>
            {{# } }}
            {{# } else{ }}
            <div class="car-empty">
                <div><i class="icon-coupon"></i></div>
                <p>您还没有抵用劵</p>
            </div>
            {{# } }} 
            {{# break;}}  {{# } }}
    </script>
    <script>
    var cardState = 0;
    $('.car-card-list').on('click', '.car-card-detail', function() {
        var li = $(this).find("li");
        var liH = null;
        $(this).toggleClass('on');
        $(this).find('.show-more').toggleClass('active');
        if($(this).hasClass('on')){
            for (var i = 0; i < li.length; i++) {
                liH +=$(li[i]).outerHeight();
            };
            $(this).find("ul").css("height", liH);
            $(this).find('.show-more span').text('点击收起');
        } else{
            $(this).find('.show-more span').text('点击详情');
            $(this).find("ul").css("height", 0);
        };
    });
    $(".car-card-detail").each(function() {
        if ($(this).hasClass('on')) {
            $(this).find('ul').show();
        }
    });
    
    var cardList = {
        card: ${cardList},
        coupon: {},
        color: ['car-bg1', 'car-bg2', 'car-bg3', 'car-bg4', 'car-bg5', 'car-bg6']
    };

    function init() {
        var cardTpl = document.getElementById('cardTpl').innerHTML;
        laytpl(cardTpl).render(cardList, function(html) {
            document.getElementById('cardList').innerHTML = html;
        });
        $("[data-lable]").each(function(){
	        var opt_label = $(this).attr("data-lable");
	        $(this).attr("onclick","_hmt.push(['_trackEvent', 'href', 'click', '"+opt_label+"'])");
	     });
    }
    init();
    
    document.body.addEventListener('touchstart', function() {});
    </script>
</body>

</html>
