<!DOCTYPE html>
<html>

<head>
    <title>订单详情</title>
    <#include "/common/header.ftl" encoding="UTF-8">
</head>

<body>
    <#include "/common/rem.ftl" encoding="UTF-8">
    </script>
    <section class="car-order-detail">
        <p class="car-order-fixed">编号：${order.orderNo}<span>${order.orderStatusName}</span></p>
        
        <dl class="car-details">
        	<#list order.orderDetailInfoList as detail>
            	<dt>${detail.name}
            		<span>
	            		<#if order.orderType=1>
			            	<#if detail.priceType=0 || detail.priceType=3>
			            		￥#{detail.price?number;m2M2}
			            	<#else>
			            		待定
		            		</#if>
            			</#if>
            		</span>
            	</dt>
            	
            	<#list detail.skuInfo as sku>
            		<dd>${sku.skuName}</dd>
            	</#list>
            </#list>
            <#if order.orderType=2||order.orderType=3||order.orderType=5>
		            <dt class="total">总计：<span>￥#{order.orderPaidMoney?number;m2M2}</span></dt>
		     </#if>
        </dl>
        
        <#list order.payList as payInfo>
        	<div class="car-pay">在线支付<span>￥#{payInfo.payMoney?number;m2M2}</span></div>
        </#list>
        
        <h4>服务门店</h4>
        <div class="car-info">
            <p><i class="icon-store iconfont"></i>${order.storeName}</p>
            <ol>
                <li>
                    <s>门店地址</s><span>${order.storeAddress}</span></li>
                <li>
                    <s>服务时间</s><span>${order.orderWeek}</span></li>
                <li>
                    <s>门店电话</s><span><a href="tel:${order.storeTelPhone}">${order.storeTelPhone}</a></span></li>
            	<#if order.artificerInfo?size gt 0>
            	<li>
                    <s class="vt">施工技师</s>
                    <dl>
                    	<#list order.artificerInfo as artificerDetail>
                        <dd>${artificerDetail.artificerName}<span>（${artificerDetail.artificerLevel}）</span></dd>
                        </#list>
                    </dl>
                </li>
                </#if>
            </ol>
        </div>
        <h4>服务车辆</h4>
        <div class="car-info">
            <p class="car-brand"><img src="${order.logoUrl}" alt="car brand" onerror="errorImg(this)"><span>${order.carName}</span></p>
            <ol>
                <li>
                    <s>车辆车牌</s><span>${order.carPlate}</span></li>
                <li>
                    <s>联系人</s><span>${order.custName}<b>${order.mobilePhone}</b></span></li>
            </ol>
        </div>
        
        <#if order.orderType=3 && order.assessScore??>
        <h4>服务评价</h4>
        <div class="car-service">
            <s>服务评价</s>
            <div class="score-star">
                <p>
                    <b></b>
                    <b class="score" style="width:#{(order.assessScore?number)*20}%"></b>
                </p>
                <span>${order.assessTip}</span>
            </div>
            <span>查看明细<i class="icon-arrows iconfont"></i></span>
        </div>
        </#if>
        
        <p class="car-call"><a href="tel:${crmTel}"><i class="iconfont icon-call"></i><b>${crmTel}</b></a></p>
        <#if order.orderType=1 || order.orderType=2 || order.orderType=3>
        <div class="car-margin"></div>
        <div class="car-control">
        	<#if order.orderType=1 && order.payStatus=0>
        	<div class="car-timeleft">
                <p>付款剩余时间</p>
                <p class="time">
                </p>
            </div>
        	</#if>
        	<#if order.orderType=1 && order.orderStatus=1  && order.payStatus != 1>
        	<input type="button" id="btnCancel" value="取消预约" data-lable="订单详情-取消预约">
        	</#if>
        	<#if order.orderType=2 || order.orderType=3>
        	<input type="button" id="btnMaintenance" value="查看下次保养时间" data-lable="订单详情-查看下次保养时间">
            </#if>
            <#if order.orderType=2>
            <input type="button" id="btnEvaluate" value="立即评价" class="car-orange" data-lable="订单详情-立即评价">
        	</#if>
        	<#if order.orderType=1 && order.payStatus=0>
        	<input type="button" id="btnPay" value="去付款" class="car-orange" data-lable="订单详情-去付款">
            </#if>
        </div>
        </#if>
    </section>
    
    <!-- Popup score begin -->
    <#if order.orderType=3>
    <div class="score popup">
        <div class="whole">
            <h2>#{order.assessScore?number;m1M1}</h2>
            <ul>
                <li class="<#if order.assessScore gt 0>on</#if>">
                    <i class="iconfont icon-star2"></i>
                    <p>很差</p>
                </li>
                <li class="<#if order.assessScore gt 1>on</#if>">
                    <i class="iconfont icon-star2"></i>
                    <p>不太好</p>
                </li>
                <li class="<#if order.assessScore gt 2>on</#if>">
                    <i class="iconfont icon-star2"></i>
                    <p>一般般</p>
                </li>
                <li class="<#if order.assessScore gt 3>on</#if>">
                    <i class="iconfont icon-star2"></i>
                    <p>还不错</p>
                </li>
                <li class="<#if order.assessScore gt 4>on</#if>">
                    <i class="iconfont icon-star2"></i>
                    <p>非常棒</p>
                </li>
            </ul>
            <s></s>
        </div>
        <div class="subentry">
        	
            <ol>
            	<#list order.orderDetailInfoList as detail>
				<#if detail.ssScore??>
                <li>
                    <span>${detail.name}</span>
                    <ul>
                        <li class="<#if detail.ssScore gt 0>on</#if>"><i class="iconfont icon-star2"></i></li>
                        <li class="<#if detail.ssScore gt 1>on</#if>"><i class="iconfont icon-star2"></i></li>
                        <li class="<#if detail.ssScore gt 2>on</#if>"><i class="iconfont icon-star2"></i></li>
                        <li class="<#if detail.ssScore gt 3>on</#if>"><i class="iconfont icon-star2"></i></li>
                        <li class="<#if detail.ssScore gt 4>on</#if>"><i class="iconfont icon-star2"></i></li>
                    </ul>
                </li>
                </#if>
    			</#list>
            </ol>
            	
            <div class="control">确定</div>
        </div>
    </div>
    </#if>
    
    <#include "/common/footer.ftl" encoding="UTF-8">
    <script>
		// 取消预约单;
		$("#btnCancel").click(function(){
			confirmObj("您确定取消预约？","暂不取消","取消预约",function(flg){
				if (flg==2) {
					var url=$.context+"/order/cancel.htm";
					var reqData={"orderId":"${order.orderId}","orderNo":"${order.orderNo}"};
					$.getajax(url,reqData,function(data){
				    	if(data.result==$.dataResult.SUCCESS){
				    	 	window.location.href=$.context+"/order/list.htm?notLoad=true";
						}else{
							comAlertObj(data.msg);
						}
				    });
				}
			});
			return false;
		});
		// 立即评价;
		$("#btnEvaluate").click(function(){
			window.location.href=$.context+"/order/toEvaluate.htm?orderId=${order.orderId}";
			return false;
		});
		// 查看保养;
		$("#btnMaintenance").click(function(){
			window.location.href=$.context+"/maintenance/index.htm?carPlate="+encodeURI(encodeURI("${order.carPlate}"));
			return false;
		});
		
	    $("#btnPay").click(function(){
			<#if order.payList??>
				// 防止重复点击
				$("#btnPay").prop("disabled", true);
				var url = "${contextPath}/order/toPay.htm";
				var param = {	
					"orderId":"${order.orderId}",
				 	"orderNo":"${order.orderNo}",
				 	"payMoney":"${order.payList[0].payMoney}"
				};
				
				// 防止重复点击
				$("#btnPay").prop("disabled", true);
				
				$.postajax(url, param, function(data){
					if(data.result == $.dataResult.FAILD){
						comAlertObj(data.msg);
					}else{
						window.location.href=data.returnUrl;
					}
				},
				"",
				function(){
					$("#btnPay").prop("disabled", false);
				});
			</#if>
		});
	    
	    // 评价弹层
	    function curLeft() {
	        var starOn = $(".whole li.on").length - 1;
	        if (starOn > 0) {
	            $(".whole s").css({
	                'left': (74 + starOn * 90) / 20 + 'rem'
	            })
	        } else {
	            $(".whole s").css({
	                'left': 74 / 20 + 'rem'
	            })
	        }
	    }
		// 评价弹层
	    function pop() {
	        var winH = $(window).height(),
	            popH = $(".popup").height();
	        curLeft();
	        $(".popup").css({
	            'top': (winH - popH) / 2 + 'px'
	        });
	        $(".car-service").on('click', function() {
	            $(".popup").addClass('show');
	            $(".mask").fadeIn(300);
	        });
	        $(".popup .control").click("on", function() {
	            $(".popup").removeClass('show');
	            $(".mask").fadeOut(300);
	        })
	    }
	    pop();
	
		// 倒计时
        var orderType = ${order.orderType};
        if (orderType == '1') {
            var timeOutSec = 0;
        	<#if order.timeOutMs??>
				timeOutSec = ${order.timeOutMs};
			</#if>
			var timeLeft = setInterval("countDown()", 1000);
	    	var timeLine = 0;
	    	
	    	if (timeOutSec > 0) {
	    		timeLine = parseInt(timeOutSec/1000);
	    	} else {
	    		<#if order.payStatus != -1>
	    			$(".car-margin").hide();
	    			$(".car-control").hide();
	    		</#if>
	    	}
	    	
		    //补零
		    function fillNum(num) {
		        if (num < 10) {
		            return "0" + parseInt(num)
		        }
		        return parseInt(num)
		    }
		
		    function formatSecend(secend) {
		        var min = fillNum(secend / 60)
		        var sec = fillNum(secend % 60)
		
		        if (min >= 60) {
		            var hour = fillNum(min / 60)
		            var _min = fillNum(min % 60)
		            return $(".car-timeleft .time").html(hour + '小时' + _min + '分钟' + sec + '秒');
		
		        } else {
		            return $(".car-timeleft .time").html( '00小时' + min + '分钟' + sec + '秒');
		
		        }
		    }
		    formatSecend(timeLine)
		    
		    function countDown(){
		    	if(timeLine == 0) {
		    		clearInterval(timeLeft);
		    		<#if order.payStatus=0>
		    			$(".car-margin").hide();
	    				$(".car-control").hide();
		    		</#if>
		    		return false;
		    	}
		        timeLine--;
		        formatSecend(timeLine);
		    };
	    }
		
		document.body.addEventListener('touchstart', function() {});
		
		$(function() {
	    	<#if payFail=true>
	    		// 支付失败提醒
	    		comAlertObj("支付失败，请重新尝试！");
	    	</#if>
    	});
    </script>
</body>

</html>
