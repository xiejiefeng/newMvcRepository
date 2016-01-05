<!DOCTYPE html>
<html>

<head>
    <title>
    	<#if viewType=2>
    		<#if products??>
    			${products[0].name}
    		</#if>
    	<#else>
    	服务预约1/2
    	</#if>
    </title>
    <#include "/common/header.ftl" encoding="UTF-8">
        <style>
        form {
            font-size: 1.4rem;
        }
        
        .pro-list {
            background: #fff;
            border-bottom: .1rem solid #e7e7e7;
        }
        
        .pro-list .tabContent {
            display: none;
            position: relative;
            padding-bottom: 2.1rem;
        }
        
        .down-list .tabContent {
            position: relative;
            overflow: hidden;
            border-bottom: .1rem solid #e7e7e7;
            margin-bottom: .8rem;
            border-top: .1rem solid #e7e7e7;
            background-color: #fff;
        }
        
        .pro-list>div:nth-child(2) {
            display: block;
            padding-bottom: 2.1rem;
        }
        
        .pro-list .tabContent .tit {
            overflow: hidden;
        }
        
        .pro-list .tabContent .more {
            position: absolute;
            right: 0;
            color: #c6c6cc;
            top: 60%;
            -webkit-transform: translate(-50%, -50%);
            -moz-transform: translate(-50%, -50%);
            transform: translate(-50%, -50%);
        }
        
        .pro-list a.block-link {
            color: #4f4f4f;
        }
        
        .pro-list dl {
            overflow: hidden;
            padding: 0 1.5rem;
        }
        
        .pro-list dt {
            float: left;
            border: 0.1rem solid #e7e7e7;
            width: 7rem;
            height: 7rem;
        }
        
        .pro-list dt img {
            vertical-align: top;
        }
        
        .pro-list dd {
            float: left;
            width: 17rem;
            padding-left: 1rem;
        }
        
        .pro-list p {
            float: left;
            height: 5rem;
            line-height: 5rem;
            overflow: hidden;
            vertical-align: middle;
            font-size: 1.2rem;
            padding-left: 3.5rem;
        }
        
        .pro-list p s {
            height: 1.9rem;
            line-height: 1.9rem;
            padding: 0 .8rem;
            font-size: 1rem;
            color: #ff6600;
            background: #ffede1;
            border-radius: .3rem;
            display: inline-block;
        }
        
        .pro-list span {
            color: #ff6702;
            display: block;
            float: right;
            height: 5rem;
            line-height: 5rem;
            padding-right: 1.5rem;
            text-align: right;
            font-size: 1.2rem;
        }
        
        .pro-list span b {
            background-color: #ff6702;
            padding: 0.2rem 0.3rem;
            border-radius: 0.5rem;
            color: #fff;
            font-size: 1.2rem;
            font-weight: normal;
        }
        
        .pro-list .tabContent ul li {
            font-size: 1.2rem;
            position: relative;
            padding-left: 1.2rem;
            color: #666;
            font-size: 1.1rem;
        }
        
        .pro-list .tabContent ul li:first-child {
            padding-left: 0;
            color: #333;
            margin-bottom: .3rem;
        }
        
        .pro-list .tabContent ul li:first-child:after {
            width: 0;
            height: 0;
        }
        
        .pro-list .tabContent ul li:after {
            content: "";
            width: .5rem;
            height: .5rem;
            background: #dbdbdb;
            border-radius: 50%;
            position: absolute;
            top: 50%;
            left: 0;
            margin-top: -.25rem;
        }
        
        .mask {
            z-index: 20;
        }
        
        .servListTitle {
            height: 3.5rem;
            line-height: 3.5rem;
            font-size: 1.2rem;
            color: #999;
            font-weight: normal;
            padding-left: 1.5rem;
        }
        
        .car-style-choose {
            background: #fff;
            overflow: hidden;
            width: 100%;
            position: relative;
            border-bottom: .1rem solid #e7e7e7;
        }
        
        .car-style-choose a,
        .car-style-choose a input {
            padding: 0;
            display: block;
            width: 100%;
            height: 4.3rem;
            color: #b2b2b2;
        }
        
        .car-style-choose a img {
            display: inline-block;
            width: 2.4rem;
            height: 2.4rem;
            margin: 1rem 0 0 1rem;
            position: absolute;
            top: 50%;
            margin-top: -1.2rem;
        }
        
        .car-style-choose s {
            padding-left: 4.25rem;
            color: #333;
            font-size: 1.2rem;
            display: inline-block;
            position: absolute;
            top: 50%;
            -webkit-transform: translate(0, -50%);
            -moz-transform: translate(0, -50%);
            transform: translate(0, -50%);
            width: 70%;
        }
        
        .car-style-choose s b {
            color: #666;
        }
        
        .car-style-choose a {
            color: #b2b2b2;
        }
        
        .car-style-choose a span {
            position: absolute;
            height: 4.3rem;
            line-height: 4.3rem;
            color: #2d2d2d;
            right: 1rem;
            top: 0;
            color: #666;
            font-size: 1.2rem;
        }
        
        .car-style-choose a span i {
            color: #c6c6cc;
            padding-left: 。5rem;
        }
        
        .pro-list a {
            clear: both;
            display: block;
        }
        
        .pro-list a ul {
            font-size: 1.2rem;
            color: #707070;
        }
        
        .pro-list .tabBtn ul {
            overflow: hidden;
            border-top: .1rem solid #e7e7e7;
        }
        
        .pro-list .tabBtn li {
            width: 50%;
            height: 3.9rem;
            line-height: 3.9rem;
            text-align: center;
            font-size: 1.3rem;
            border-bottom: .25rem solid #e0e0e0;
            float: left;
            list-style: none;
        }
        
        .pro-list .tabBtn li:first-child {
            border-right: .1rem solid #e7e7e7;
        }
        
        .pro-list .tabBtn .currentBtn {
            border-color: #17a3eb;
            color: #17a3eb;
        }
        
        .down-list {
            height: auto;
            overflow: hidden;
            margin-bottom: 70px;
            width: 100%;
        }
        
        .down-list a {
            position: relative;
            border-bottom: 0.1rem solid #e7e7e7;
        }
        
        .down-list a dl {
            width: 100%;
            height: auto;
            overflow: hidden;
            border-bottom: .1rem solid #e7e7e7;
        }
        
        .down-list dt,
        .down-list dd {
            float: left;
            color: #333;
            height: 4rem;
            line-height: 4rem;
        }
        
        .down-list dt {
            padding-left: 3.7rem;
            font-size: 1.2rem;
        }
        .down-list dt s{
        	display:inline-block;
        	  height: 1.9rem;
			  line-height: 1.9rem;
			  padding: 0 0.8rem;
			  font-size: 1rem;
			  color: #ff6600;
			  background: #ffede1;
			  border-radius: 0.3rem;
			  margin-left: 1rem;
        }
        .down-list dl dd {
            float: right;
            margin-right: 1.25rem;
        }
        
        .down-list dl dd p {
            color: #ff6702;
            font-size: 1.2rem;
        }
        
        .down-list dl dd p i {
            color: #c6c6cc;
            padding-left: 0.8rem;
        }
        
        .down-list dl dd p b {
            font-size: 1.2rem;
            font-weight: normal;
        }
        
        .down-list a>div {
            padding: 1rem 1.5rem;
            position: relative;
        }
        
        .down-list a>div p {
            font-size: 1.1rem;
            color: #666;
            width: 90%;
        }
        
        .down-list a>div i {
            position: absolute;
            right: .25rem;
            color: #c6c6cc;
            top: 50%;
            -webkit-transform: translate(-50%, -50%);
            -moz-transform: translate(-50%, -50%);
            transform: translate(-50%, -50%);
        }
        
        .serviceChooseBtn {
            position: absolute;
            left: .5rem;
            top: 0;
            width: 5rem;
            height: 4.6rem;
        }
        
        .origPrice {
            position: absolute;
            right: 3rem;
            top: 3rem;
            font-size: 1.2rem;
            text-decoration: line-through;
            color: #707070;
        }
        
        .car-style-choose a input {
            display: block;
            float: left;
            width: 22rem;
            overflow: hidden;
            text-overflow: ellipsis;
            left: 0;
            color: #2d2d2d;
        }
        
        input[type="checkbox"] {
            display: none;
        }
        
        input[type="radio"] {
            display: none;
        }
        
        input[type="checkbox"] + label {
            cursor: pointer;
            font-size: 1.4rem;
        }
        
        [id^="checkbox-1-"] + label {
            display: inline-block;
            position: absolute;
            width: 5rem;
            height: 5rem;
            text-align: center;
        }
        
        [id^="checkbox-1-"] + label i {
            display: block;
        }
        
        [id^="checkbox-1-"] + label i:before {
            content: "";
            display: block;
            width: 1.5rem;
            height: 1.5rem;
            line-height: 1.5rem;
            border: 1px solid #ccc;
            border-radius: 0.2rem;
            display: block;
            margin: 1.2rem 0 0 1rem;
        }
        
        [id^="checkbox-1-"]:checked + label i:before {
            content: "\e608";
            font-size: 1.2rem;
            background: #17a3eb;
            color: #fff;
            border: 1px solid #17a3eb;
        }
        
        .pro-list [id^="checkbox-1-"] + label i:before {
            margin-top: 1.7rem;
        }
        
        .listNextStep {
			  width: 100%;
			  background: rgba(0, 0, 0, 0.8);
			  font-size: 1.3rem;
			  color: #fff;
			  margin-top: 0.6rem;
			  position: fixed;
			  bottom: 0;
			  left: 0;
			  padding: .8rem 0;
        }
        
        .listNextStep button {
            width: 90%;
            border-radius: 0.5rem;
            margin-left: 5%;
            height: 3.5rem;
            line-height: 3.5rem;
            text-align: center;
            background: #ff6702;
            color: #fff;
        }
        
        input {
            color: #2d2d2d;
            font-size: 1.4rem;
            width: 100%;
            display: block;
            line-height: normal;
        }
        
        select {
            display: none;
        }
        
        .moreBtn {
            text-align: center;
            margin-top: 1rem;
        }
        
        .moreBtn span {
            padding: 0.5rem 1rem;
            background: #cdcdcb;
            font-size: 1.2rem;
            color: #fff;
            border-radius: 2rem;
        }
        .down-list.downFen{
        	margin-bottom:5rem;
        }
        </style>
</head>

<body>
    <#include "/common/rem.ftl" encoding="UTF-8">
        <div class="car-style-choose <#if viewType=2>cbn-tit</#if>">
            <a href="${contextPath}/service/toSelectCar.htm?products=${productCode}&singleCode=${singleCode}&cbnCode=${cbnCode}">
                <img src="${carInfo.logoUrl}" onerror="errorImg(this)" />
                <s id="carName">
                    <#if carInfo!=null && carInfo.carName!=null>
                        ${carInfo.carName}
                        <#else>
                            <b>请选择预约车辆</b>
                    </#if>
                </s>
                <span>更换<i class="iconfont icon-arrows"></i></span>
            </a>
        </div>
        <input type="hidden" name="carLevel" id="carLevel" value="${carInfo.carLevel}" />
        <input type="hidden" name="carId" id="carId" value="${carInfo.carId}" />
        <#if viewType=0>
            <h2 class="servListTitle">请选择保养套餐</h2>
            <div class="pro-list" id="sceneId1">
                <div class="tabBtn">
                    <ul>
                        <li class="currentBtn">优选保养套餐</li>
                        <li>尊享保养套餐</li>
                    </ul>
                    <input type="hidden" id="indexR" />
                </div>
                <#list products as product>
                    <div class="tabContent">
                        <a href="/service/${product.code}.html" class="block-link " data-lable=" 服务预约1/2-${product.name}">
                            <div class="tit">
                                <div class="serviceChooseBtn">
                                    <input type="radio" <#if product_index=0>checked="checked"</#if> id="checkbox-1-${product.code}" name="code" value="${product.code}" />
        <label for="checkbox-1-${product.code}"><i class="iconfont"></i></label>
        </div>
        <p>${product.name}
            <#if product.productPay??><s>${product.productPay.promotionName}</s></#if>
        </p>
        <span>￥#{product.promotionPrice?number;m2M2}</span>
        </div>
        <dl>
            <dt><img src="<#if product.imageUrl??&& product.imageUrl?length gt 0><@jci.domain url='/images/service/${product.imageUrl}'/><#else><@jci.domain url='/images/defaultImg.jpg'/></#if>" width="100%" /></dt>
            <dd>
                <ul>
                    <li>${product.desc}</li>
                </ul>
            </dd>
        </dl>
        <div>
            <input type="hidden" name="name" value="${product.name}" />
            
        </div>
        <i class="iconfont icon-arrows more"></i>
        </a>
        </div>
        </#list>
        </div>
        <div class="down-list" style="margin-bottom: 0;">
            <#list products2 as product>
                <div class="tabContent">
                    <a href="/service/${product.code}.html" class="block-link">
                        <dl>
                            <dt>${product.name}</dt>
                            <dd>
                                <p>
                                    <#if product.servicePirceType=0>
                                        ￥#{product.promotionPrice?number;m2M2}
                                        <#elseif product.servicePirceType=1>
                                            ￥#{product.promotionPrice?number;m2M2}<b>起</b>
                                            <#else>
                                                待定
                                    </#if>
                                </p>
                            </dd>
                        </dl>
                        <div>
                            <p>${product.desc}</p>
                            <i class="iconfont icon-arrows"></i>
                        </div>
                    </a>
                    <div class="serviceChooseBtn">
                        <input type="hidden" name="name" value="${product.name}" />
                        <input type="checkbox" id="checkbox-1-${product.code}" name="code" value="${product.code}" checked/>
                        <label for="checkbox-1-${product.code}"><i class="iconfont"></i></label>
                    </div>
                </div>
            </#list>
        </div>
        <div class="downPart">
            <#list products as product>
                <#if product.recommandProduct?? && product.recommandProduct?size gt 0>
                    <div id="other_${product.code}" class="<#if product_index!=0>hide</#if> down-tabContent">
                        <h2 class="servListTitle">您可能还需要</h2>
                        <div class="down-list" id="sceneId2">
                            <#list product.recommandProduct as other>
                                <div class="tabContent">
                                    <a href="/service/${other.code}.html" class="block-link">
                                        <dl>
                                            <dt>${other.name}</dt>
                                            <dd>
                                                <p>
                                                    <#if other.servicePirceType=0>
                                                        ￥#{other.promotionPrice?number;m2M2}
                                                        <#elseif other.servicePirceType=1>
                                                            ￥#{other.promotionPrice?number;m2M2}<b>起</b>
                                                            <#else>
                                                                待定
                                                    </#if>
                                            </dd>
                                        </dl>
                                        <div>
                                            <p>${other.desc}</p>
                                            <i class="iconfont icon-arrows"></i>
                                        </div>
                                    </a>
                                    <div class="serviceChooseBtn">
                                        <input type="hidden" name="name" value="${other.name}" />
                                        <input type="checkbox" id="checkbox-1-${product.code}-${other.code}" name="code" value="${other.code}" />
                                        <label for="checkbox-1-${product.code}-${other.code}"><i class="iconfont"></i></label>
                                    </div>
                                </div>
                            </#list>
                        </div>
                    </div>
                </#if>
            </#list>
        </div>
        <#elseif viewType=1>
            <h2 class="servListTitle">请选择服务项目</h2>
            <div class="down-list" style="margin-bottom: 0;">
                <#list products as product>
                    <div class="tabContent">
                        <a href="/service/${product.code}.html" class="block-link">
                            <dl>
                                <dt>${product.name}<#if product.productPay??><s>${product.productPay.promotionName}</s></#if></dt>
                                <dd>
                                    <p>
                                        <#if product.servicePirceType=0>
                                            ￥#{product.promotionPrice?number;m2M2}
                                            <#elseif product.servicePirceType=1>
                                                ￥#{product.promotionPrice?number;m2M2}<b>起</b>
                                                <#else>
                                                    待定
                                        </#if>
                                    </p>
                                </dd>
                            </dl>
                            <div>
                                <p>${product.desc}</p>
                                <i class="iconfont icon-arrows"></i>
                            </div>
                        </a>
                        <div class="serviceChooseBtn">
                            <input type="hidden" name="name" value="${product.name}" />
                            <input type="checkbox" id="checkbox-1-${product.code}" name="code" value="${product.code}" checked/>
                            <label for="checkbox-1-${product.code}"><i class="iconfont"></i></label>
                        </div>
                    </div>
                </#list>
            </div>
            <div class="moreBtn"><span>选择更多服务项目</span></div>
            <h2 class="servListTitle downFen" style="display: none;margin-top: -.8rem">您可能还需要</h2>
            <div class="down-list downFen" style="display: none;">
                <#list products2 as product>
                    <div class="tabContent">
                        <a href="/service/${product.code}.html" class="block-link">
                            <dl>
                                <dt>${product.name}<#if product.productPay??><s>${product.productPay.promotionName}</s></#if></dt>
                                <dd>
                                    <p>
                                        <#if product.servicePirceType=0>
                                            ￥#{product.promotionPrice?number;m2M2}
                                            <#elseif product.servicePirceType=1>
                                                ￥#{product.promotionPrice?number;m2M2}<b>起</b>
                                                <#else>
                                                    待定
                                        </#if>
                                    </p>
                                </dd>
                            </dl>
                            <div>
                                <p>${product.desc}</p>
                                <i class="iconfont icon-arrows"></i>
                            </div>
                        </a>
                        <div class="serviceChooseBtn">
                            <input type="hidden" name="name" value="${product.name}" />
                            <input type="checkbox" id="checkbox-1-${product.code}" name="code" value="${product.code}" />
                            <label for="checkbox-1-${product.code}"><i class="iconfont"></i></label>
                        </div>
                    </div>
                </#list>
            </div>
            <#elseif viewType=2>
            	<#list products as product>
            		<input type="checkbox" id="checkbox-1-${product.code}" name="code" value="${product.code}" checked/>
            		
            		<#include "/service/cbn/${product.imageUrl}" encoding="UTF-8">
            		<div class="ui-pay">
			            <span>在线支付<b>￥${product.originalPrice}</b></span>
			            <input id="nextStep" type="button" class="ui-btn" value="立即下单">
			        </div>
            	</#list>
            </#if>
            <#if viewType!=2>
            <div class="listNextStep">
                <button id="nextStep" data-lable="服务预约1/2-下一步">下一步</button>
            </div>
            </#if>
            <input type="hidden" name="name" class="show-states" value="0" />
            <#include "/common/footer.ftl" encoding="UTF-8">
                <script type="text/javascript">
                $(function() {
                    var tabStatus;
                    //tab切换
                    $(".pro-list .tabBtn li").click(function() {
                        //头部tab
                        var numIndex = $(this).index();
                        $(this).addClass("currentBtn").siblings().removeClass("currentBtn");
                        $(".pro-list .tabContent").hide();
                        $(".pro-list .tabContent").eq(numIndex).show();
                        //头部tab点击时radio为选中
                        var chk = $(".pro-list .tabContent").eq(numIndex).find(":radio");
                        chk.prop("checked", true);
                        //尾部tab
                        $(".down-tabContent").hide();
                        $(".down-tabContent").eq(numIndex).show();
                        //尾部tab切换时除去上一个tab的checkbox选中状态
                        $(".down-tabContent").eq(numIndex).siblings().find(":checkbox").prop("checked", false);
                        $("#indexR").val(numIndex);



                    });
                    //返回恢复刚刚tab状态
                    tabStatus = $("#indexR").val();

                    function tabReturn(num) {
                        if (num) {
                            $(".pro-list .tabBtn li").eq(num).click();
                        }
                    }
                    tabReturn(tabStatus);

                    // 点击下一步按钮
                    $("#nextStep").click(function() {
                        // 判断车辆
                        var carName = $("#carName").text();
                        if (!carName) {
                            comAlertObj("亲，请选择车辆！");
                            return false;
                        }
                        // 判断服务
                        var code = $("input[name^='code']:checked");
                        if (code.length == 0) {
                            comAlertObj("亲，请选择您所需的服务！");
                            return false;
                        }

                        var url = "${contextPath}/service/nextStep.htm";
                        var codeArr = [];
                        code.each(function(index) {
                            codeArr.push($(this).val());
                        });
                        var param = {
                            codes: codeArr.join(",")
                        };

                        // 提交
                        $.postajax(url, param, function(data) {
                            if (data.result == $.dataResult.FAILD) {
                                comAlertObj(data.msg);
                            } else {
                                window.location.href = '${contextPath}/service/toConfirm.htm';
                            }
                        });
                    });
                    /*
                    if (localStorage) {
                        //tab跳转返回时恢复之前的状态
                        tabStatus = localStorage.getItem("tabStatus");

                        function tabReturn(num) {
                            if (num) {
                                $(".pro-list .tabBtn li").eq(num).click();
                            }
                        }
                        tabReturn(tabStatus);
                    }
                    */
                    $('.moreBtn').on('click', function() {
                        $('.downFen').show();
                        $(this).hide();
                        $(".show-states").val("1");

                    });
                    if($(".show-states").val() == 1) 
                    {
                    	console.log(1);
                    	$('.moreBtn').click();
                    }
                    $(window).scrollTop(0);
                });
                </script>
</body>

</html>
