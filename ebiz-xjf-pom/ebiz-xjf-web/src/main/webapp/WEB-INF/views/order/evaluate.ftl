<!DOCTYPE html>
<html>

<head>
    <title>订单评价</title>
    <#include "/common/header.ftl" encoding="UTF-8">
</head>

<body>
	<#include "/common/rem.ftl" encoding="UTF-8">
    <div class="score">
        <div class="whole">
            <ul>
                <li class="on">
                    <i class="iconfont icon-star2"></i>
                    <p>很差</p>
                </li>
                <li class="on">
                    <i class="iconfont icon-star2"></i>
                    <p>不太好</p>
                </li>
                <li class="on">
                    <i class="iconfont icon-star2"></i>
                    <p>一般般</p>
                </li>
                <li>
                    <i class="iconfont icon-star2"></i>
                    <p>还不错</p>
                </li>
                <li>
                    <i class="iconfont icon-star2"></i>
                    <p>非常棒</p>
                </li>
            </ul>
            <s></s>
        </div>
        <div class="subentry">
            <ol>
            	<#list orderInfo.orderDetailInfoList as serviceInfo>
	            	<#if serviceInfo.ssType == "1" || serviceInfo.ssType == "4" >
		                <li ssType="${serviceInfo.ssType}">
		                    <span>${serviceInfo.name}</span>
		                    <input type="hidden" value="${serviceInfo.ssId}">
		                    <ul>
		                        <li class="on"><i class="iconfont icon-star2"></i></li>
		                        <li class="on"><i class="iconfont icon-star2"></i></li>
		                        <li class="on"><i class="iconfont icon-star2"></i></li>
		                        <li><i class="iconfont icon-star2"></i></li>
		                        <li><i class="iconfont icon-star2"></i></li>
		                    </ul>
		                </li>
	                </#if>
                </#list>
            </ol>
            <div class="control">
                <textarea placeholder="您对服务还满意么？有任何意见请告诉我们" maxlength="500"></textarea>
                <input type="button" class="ui-btn" value="提交评价" onclick="submitScore()" id="saveScore">
            </div>
        </div>
    </div>
    <#include "/common/footer.ftl" encoding="UTF-8">
    <script>
    	var scoreDetail ={
    		orderId: ${orderInfo.orderId},
    		assessScore: $(".whole li.on").length,
    		detailList: [],
    		assessRemark:$("textarea").val()
    	}
    	
	    function curLeft() {
	        var starOn = $(".whole li.on").length - 1;
	        if (starOn > 0) {
	            $(".whole s").css({
	                'left': (105 + starOn * 90) / 20 + 'rem'
	            })
	        } else {
	            $(".whole s").css({
	                'left': 105 / 20 + 'rem'
	            })
	        }
	
	    }
	    curLeft();
	
	    function addStar(ele) {
	        $(ele).click(function() {
	            var clickI = $(this);
	            var num = clickI.index() + 1;
	            var clickIndx = clickI.index();
	            if (clickIndx < 1) {
	                clickI.addClass('on');
	                clickI.prevAll().addClass('on')
	                clickI.nextAll().removeClass('on')
	
	            } else {
	                clickI.addClass('on')
	                clickI.prevAll().addClass('on')
	                clickI.nextAll().removeClass('on')
	
	            }
	
	            //整体评价联动分项评价
	            if (ele == ".whole li") {
	                var subentryList = $(".subentry ol>li");
	                $(".subentry ul li").removeClass('on'); //每次联动前先清空选中状态
	                for (var i = 0; i <= subentryList.length; i++) {
	                    var subentryListLi = subentryList[i];
	                    for (var j = 0; j <= clickIndx; j++) {
	                        $($(subentryListLi).find("li")[j]).addClass('on')
	                    };
	                };
	            }
	            curLeft();
	        });
	    }
	    addStar(".whole li");
	    addStar(".subentry li");
	    
	    
	    //分项分数
	    function subentryScore(){
	        var subentryList = $(".subentry ol>li");
	        var detail;
	        for (var i = 0; i < subentryList.length; i++) {
	        	detail = {};
	        	detail.ssId=$(subentryList[i]).find("input").val();
	        	detail.ssScore=$(subentryList[i]).find("li.on").length;
	        	detail.ssType=$(subentryList[i]).attr("ssType");
	            scoreDetail.detailList.push(detail);
	        };
	        
	    }
	    
	    
	    
	    function submitScore() {
	    	scoreDetail.detailList = [];
	    	scoreDetail.orderId = ${orderInfo.orderId};
    		scoreDetail.assessScore = $(".whole li.on").length;
    		scoreDetail.assessRemark = $("textarea").val();
    		//判断是否是汉字、字母、数字组成、全角半角符号
    		var regu = "^[0-9a-zA-Z\u4e00-\u9fa5-\u3000-\u301e\ufe10-\ufe19\ufe30-\ufe44\ufe50-\ufe6b\uff01-\uffee-\u0020\u0021\u0022\u002c\u002e\u003f\u003a\u003b\u007e\]+$";
	        var re = new RegExp(regu);
	        if (re.test(scoreDetail.assessRemark) || $("textarea").val() == "") {
	            subentryScore();
		    	var url="${contextPath}/order/regAssess.htm";
		    	
		    	// 防止重复点击
				$("#saveScore").prop("disabled", true);
		    	
		    	$.postjson(url, JSON.stringify(scoreDetail), function(data){
					if(data.result == $.dataResult.SUCCESS){
						window.location.href=$.context+'/order/toEvaluateSuccess.htm?orderId=${orderInfo.orderId}';
					}else{
						comAlertObj(data.msg);
					}
				},
				"",
				function(){
					$("#saveScore").prop("disabled", false);
				});
	        } else {
	        	comAlertObj("请输入正确的字符")
	            return false;
	        }
	    	
	    }
	    
    </script> 
    </body> 
    </html>
