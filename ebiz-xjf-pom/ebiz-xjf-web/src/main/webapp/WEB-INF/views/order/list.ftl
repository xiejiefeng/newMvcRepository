<!DOCTYPE html>
<html>

<head>
    <title>我的订单</title>
    <#include "/common/header.ftl" encoding="UTF-8">
</head>

<body style="position: static;">
    <#include "/common/rem.ftl" encoding="UTF-8">
        </script>
        <section class="car-order">
            <div class="car-order-nav">
                <ul>
                    <li class="active" data-lable="我的订单-已预约">已预约</li>
                    <li data-lable="我的订单-待评价">待评价</li>
                    <li data-lable="我的订单-已评价">已完成</li>
                    <li data-lable="我的订单-已取消">已取消</li>
                </ul>
                <input type="hidden" id="tabNum" value='${tab}' />
                <div class="active-line"></div>
            </div>
            <div id="orderList0" class="car-order-list" style="display: block;">
                <div class='dropList'></div>
            </div>
            <div id="orderList1" class="car-order-list">
                <div class='dropList'></div>
            </div>
            <div id="orderList2" class="car-order-list">
                <div class='dropList'></div>
            </div>
            <div id="orderList3" class="car-order-list">
                <div class='dropList'></div>
            </div>
            <input type='hidden' id='bmsRowCount' name='bmsRowCount' value='${bmsRowCount}' />
            <input type='hidden' id='orderRowCount' name='orderRowCount' value='${orderRowCount}' />
            <input type='hidden' id='preorderRowCount' name='preorderRowCount' value='${preorderRowCount}' />
        </section>
        <#include "/common/footer.ftl" encoding="UTF-8">
            <script src="<@jci.domain url='/js/laytpl.js'/>"></script>
            <script src="<@jci.domain url='/js/dropload.min.js'/>"></script>
            <script>
            var navNum = 0;
            </script>
            <script id="carOrder" type="text/html">
                {{# switch (navNum) { case 0:}} {{# if(config.dataList[navNum].length > 0){ }} {{# for(var u = 0; u
                < config.dataList[navNum].length; u++){ }} <ul>
                    <li>
                        <i class="icon-store iconfont"></i>{{ config.dataList[navNum][u].storeName }}
                        <b>{{config.dataList[navNum][u].orderNo}}</b>
                    </li>
                    <li>
                        <s>门店地址</s><span>{{ config.dataList[navNum][u].storeAddress }}</span></li>
                    <li>
                        <s>到店时间</s><span>{{ config.dataList[navNum][u].orderWeek }}</span>
                    </li>
                    <li>
                        <s>服务项目</s><span>{{ config.dataList[navNum][u].orderTitle }} <a href="##">等 {{ config.dataList[navNum][u].number }} 项</a></span></li>
                    <li><span>共 {{ config.dataList[navNum][u].number }} 项服务</span> {{# if(config.dataList[navNum][u].orderStatus == 1 && (config.dataList[navNum][u].payStatus == -1 || (config.dataList[navNum][u].payStatus == 0 && config.dataList[navNum][u].timeOutMs > 0))){ }}
                        <input class="btnCancel" type="button" value="取消预约" onclick="_hmt.push(['_trackEvent', 'href', 'click', '我的订单-取消预约']);btnCancel(this, '{{config.dataList[navNum][u].orderId}}', '{{config.dataList[navNum][u].orderNo}}')"> {{# } }}
                    </li>
                    <li><a href="${contextPath}/order/detail_preorder_{{config.dataList[navNum][u].orderId}}.htm" data-lable="我的订单-查看订单详情"><i class="icon-arrows iconfont"></i></a></li>
                    </ul>
                    {{# } }} {{# } else{ }}
                    <div class="car-empty">
                        <div><i class="icon-order"></i></div>
                        <p>您还没有相关的订单</p>
                        <input type="button" value="立即去预约" onclick="_hmt.push(['_trackEvent', 'href', 'click', '我的订单-立即去预约']);window.location.href='${contextPath}/service/index.htm'">
                    </div>
                    {{# } }} {{# break;}} {{# case 1: }} {{# if(config.dataList[navNum].length > 0){ }} {{# for(var o = 0; o
                    < config.dataList[navNum].length; o++){ }} <ul>
                        <li>
                            <i class="icon-store iconfont"></i>{{ config.dataList[navNum][o].storeName }}
                            <b>{{ config.dataList[navNum][o].orderNo }}</b>
                        </li>
                        <li>
                            <s>门店地址</s><span>{{ config.dataList[navNum][o].storeAddress }}</span></li>
                        <li>
                            <s>到店时间</s><span>{{ config.dataList[navNum][o].orderWeek }}</span></li>
                        <li>
                            <s>服务项目</s><span>{{ config.dataList[navNum][o].orderTitle }} <a href="##">等 {{ config.dataList[navNum][o].number }} 项</a></span></li>
                        <li>
                            <span>共 {{ config.dataList[navNum][o].number }} 项服务，合计: <b>￥{{ config.dataList[navNum][o].orderPaidMoney }}</b></span>
                            <input class="orange" type="button" value="评价服务" onclick="_hmt.push(['_trackEvent', 'href', 'click', '我的订单-评价服务']);window.location.href='${contextPath}/order/toEvaluate.htm?orderId={{config.dataList[navNum][o].orderId}}'" />
                        </li>
                        <li><a href="${contextPath}/order/detail_order_{{config.dataList[navNum][o].orderId}}.htm" data-lable="我的订单-查看订单详情"><i class="icon-arrows iconfont"></i></a></li>
                        </ul>
                        {{# } }} {{# } else{ }}
                        <div class="car-empty">
                            <div><i class="icon-order"></i></div>
                            <p>您还没有相关的订单</p>
                            <input type="button" value="立即去预约" onclick="_hmt.push(['_trackEvent', 'href', 'click', '我的订单-立即去预约']);window.location.href='${contextPath}/service/index.htm'">
                        </div>
                        {{# } }} {{# break;}} {{# case 2: }} {{# if(config.dataList[navNum].length > 0){ }}
                            {{# for(var p = 0; p
                            < config.dataList[navNum].length; p++){ }} <ul>
                                <li>
                                    <i class="icon-store iconfont"></i>{{ config.dataList[navNum][p].storeName }}
                                    <b>{{ config.dataList[navNum][p].orderNo }}</b>
                                </li>
                                <li>
                                    <s>门店地址</s><span>{{ config.dataList[navNum][p].storeAddress }}</span></li>
                                <li>
                                    <s>到店时间</s><span>{{ config.dataList[navNum][p].orderWeek }}</span></li>
                                <li>
                                    <s>服务项目</s><span>{{ config.dataList[navNum][p].orderTitle }} <a href="##">等 {{ config.dataList[navNum][p].number }} 项</a></span></li>
                                <li><span>共 {{ config.dataList[navNum][p].number }} 项服务，合计: <b>￥{{ config.dataList[navNum][p].orderPaidMoney }}</b></span>
                                </li>
                                <li><a href="${contextPath}/order/detail_order_{{config.dataList[navNum][p].orderId}}.htm" data-lable="我的订单-查看订单详情"><i class="icon-arrows iconfont"></i></a></li>
                                </ul>
                               
                                {{# } }}
                        {{# } else{ }}
                        <div class="car-empty">
                            <div><i class="icon-order"></i></div>
                            <p>您还没有相关的订单</p>
                            <input type="button" value="立即去预约" onclick="_hmt.push(['_trackEvent', 'href', 'click', '我的订单-立即去预约']);window.location.href='${contextPath}/service/index.htm'">
                        </div>
                       
                        {{# } }} {{# break;}} {{# case 3: }} {{# if(config.dataList[navNum].length > 0){ }} {{# for(var i = 0; i
                        < config.dataList[navNum].length; i++){ }} <ul>
                            <li>
                                <i class="icon-store iconfont"></i>{{ config.dataList[navNum][i].storeName }}
                                <b>{{ config.dataList[navNum][i].orderNo }}</b> {{# if((config.dataList[navNum][i].orderStatus == 0 && config.dataList[navNum][i].cancelStatus != 1) || config.dataList[navNum][i].orderStatus == 3){ }}
                                <i class="icon-cancel"><s>已取消</s></i> {{# } else if(config.dataList[navNum][i].orderStatus == 0 && config.dataList[navNum][i].cancelStatus == 1){ }}
                                <i class="icon-cancel2"><s>已取消<span>支付超时</span></s></i> {{# } }}
                            </li>
                            <li>
                                <s>门店地址</s><span>{{ config.dataList[navNum][i].storeAddress }}</span></li>
                            <li>
                                <s>到店时间</s><span>{{ config.dataList[navNum][i].orderWeek }}</span>
                            </li>
                            <li>
                                <s>服务项目</s><span>{{ config.dataList[navNum][i].orderTitle }} <a href="##">等 {{ config.dataList[navNum][i].number }} 项</a></span>
                            </li>
                            </ul>
                            {{# } }} {{# } else{ }}
                            <div class="car-empty">
                                <div><i class="icon-order"></i></div>
                                <p>您还没有相关的订单</p>
                                <input type="button" value="立即去预约" onclick="_hmt.push(['_trackEvent', 'href', 'click', '我的订单-立即去预约']);window.location.href='${contextPath}/service/index.htm'">
                            </div>
                            {{# } }} {{# break;}} {{# } }}
            </script>
            <script>
            var firstLoad = 1;
            var bmsRowStart = 0;
            var orderRowStart = 0;
            var dropload =  $('.car-order-list').dropload();
            var config = {
                dataList: [], //tab对应数据
                btnState:[true, true, true, true, true], //下拉加载状态 true代表下拉加载事件注册  false代表不可注册
                tabReturn: function (num) {
                	if (num) {
						$(".car-order-nav li").eq(num).click();
					} else {
						$(".car-order-nav li").eq(0).click();
					}
                },//切换页面返回之前选择状态
                init: function(num) {
                    var carOrder = document.getElementById('carOrder').innerHTML;
                    laytpl(carOrder).render(config.dataList, function(html) {
                        document.getElementById('orderList' + num).children[0].innerHTML = html;
                        $("[data-lable]").each(function() {
                            var opt_label = $(this).attr("data-lable");
                            $(this).attr("onclick", "_hmt.push(['_trackEvent', 'href', 'click', '" + opt_label + "'])");
                        });
                    });
                }, //数据模板化加载
                loadHistory: function() {
                    var url = $.context + '/order/getBmsOrderList.htm';
                    var data = "rowStart=" + bmsRowStart;
                    $("#loadImg").css('opacity','1');
                    $.postajax(url, data, function(lists) {
                    
                        var result = '';
                        for (var i = 0; i < lists.length; i++) {
                            result += '<ul>' + '<li><i class="icon-store iconfont"></i>' + lists[i].storeName + '<b>' + lists[i].orderNo + '</b></li>' + '<li><s>门店地址</s><span>' + lists[i].storeAddress + '</span></li>' + '<li><s>到店时间</s><span>' + lists[i].orderWeek + '</span></li>' + '<li><s>服务项目</s><span>' + lists[i].orderTitle + ' <a href="##">等 ' + lists[i].number + ' 项</a></span></li>' + '<li><span>共 ' + lists[i].number + ' 项服务，合计: <b>￥' + lists[i].orderPaidMoney + '</b></span></li>' + '<li><a href="' + $.context + '/order/bmsOrderDetail_' + lists[i].orderNo + '.htm" data-lable="我的订单-查看订单详情"><i class="icon-arrows iconfont"></i></a></li>' + '</ul>'
                        }
                        $('#bmsCount').val(lists.length);
                        
                        
                        $(".load-more").hide();
                        
                        if( lists.length > 0 ) $(".car-empty").remove();
                        
                        $('#orderList2 .dropList').append(result);
                        
                        if (lists.length == $('#bmsRowCount').val()) {
                            var rowStart = Number(bmsRowStart) + Number($('#bmsRowCount').val());
                            bmsRowStart = rowStart;
                        } else {
                            dropload.lock();
                        }
                        
                    });
                    //下拉加载
                    if(config.btnState[4] === true){
	                    //config.btnState[4] = false;
	                     dropload = $('#orderList2').dropload({
	                        domDown: {
	                            domClass: 'dropload-down',
	                            domRefresh: '<div class="dropload-refresh">↑上拉加载更多</div>',
	                            domUpdate: '<div class="dropload-update">↓释放加载</div>',
	                            domLoad: '<div class="dropload-load"><span class="loading"></span>加载中...</div>'
	                        },
	                        loadDownFn: function(me) {
	                            data = "rowStart=" + bmsRowStart;
	                            $("#loadImg").css('opacity','0');
	                            $.postajax(url, data, function(lists) {
	                                var result = '';
	                                for (var i = 0; i < lists.length; i++) {
	                                    result += '<ul>' + '<li><i class="icon-store iconfont"></i>' + lists[i].storeName + '<b>' + lists[i].orderNo + '</b></li>' + '<li><s>门店地址</s><span>' + lists[i].storeAddress + '</span></li>' + '<li><s>到店时间</s><span>' + lists[i].orderWeek + '</span></li>' + '<li><s>服务项目</s><span>' + lists[i].orderTitle + ' <a href="##">等 ' + lists[i].number + ' 项</a></span></li>' + '<li><span>共 ' + lists[i].number + ' 项服务，合计: <b>￥' + lists[i].orderPaidMoney + '</b> 元</span></li>' + '<li><a href="' + $.context + '/order/bmsOrderDetail_' + lists[i].orderNo + '.htm" data-lable="我的订单-查看订单详情"><i class="icon-arrows iconfont"></i></a></li>' + '</ul>'
	                                }
	                                $('#bmsCount').val(lists.length);
	                                if (lists.length == $('#bmsRowCount').val()) {
	                                    var rowStart = Number(bmsRowStart) + Number($('#bmsRowCount').val());
	                                    bmsRowStart = rowStart;
	                                } else {
	                                    dropload.lock();
	                                }
	                                $('#orderList2 .dropList').append(result);
	                                me.resetload();
	                            });
	
	                        }
	                    });
                    }
                }, //以上，加载历史就订单
                initLoad: function(num) {
                    url = $.context + '/order/queryOrderList.htm';
                    var data = {
                        "rowStart": orderRowStart,
                        "tab": num
                    };
                   	$(".dropList").html("");//初始化清空数据
                    $("#loadImg").css('opacity','1');
                    dropload.unlock();
                    
                    $.postajax(url, data, function(lists) {
                        config.dataList[num] = lists;
                        if (config.dataList[num].length > 0) {
                            var rowStart = Number(orderRowStart) + config.dataList[num].length;
                            orderRowStart = rowStart;

                            // 初始话加载AJAX请求，数据件数小于系统参数规定数值，不能加载
                            var count = 0;
                            if (num == 0 || num == 3) {
                                count = Number($('#preorderRowCount').val());
                            } else if (num == 1 || num == 2) {
                                count = Number($('#orderRowCount').val());
                            }
                            // 数据件数等于系统参数规定数值，可加载
                            if (lists.length == count) {
                            	
                                if(config.btnState[num] === true){
                                dropload = $('#orderList' + num).dropload({
                                    domDown: {
                                        domClass: 'dropload-down',
                                        domRefresh: '<div class="dropload-refresh">↑上拉加载更多</div>',
                                        domUpdate: '<div class="dropload-update">↓释放加载</div>',
                                        domLoad: '<div class="dropload-load"><span class="loading"></span>加载中...</div>'
                                    },
                                    loadDownFn: function(me) {
                                    	data = {
					                        "rowStart": orderRowStart,
					                        "tab": num
					                    };
					                    
					                    $("#loadImg").css('opacity','0');
                                        $.postajax(url, data, function(lists) {
                                            for (var i = 0; i < lists.length; i++) {
                                                config.dataList[num].push(lists[i]);
                                            }

                                            if (num == 0 || num == 3) {
                                                count = Number($('#preorderRowCount').val());
                                            } else if (num == 1 || num == 2) {
                                                count = Number($('#orderRowCount').val());
                                            }
                                            
                                            config.init(num);
                                            me.resetload();
                                            // 数据件数等于系统参数规定数值，可加载
                                            
                                            if (lists.length == count) {
                                                var rowStart = Number(orderRowStart) + Number(count);
                                                orderRowStart = rowStart;
                                            } else {
                                                dropload.lock();
                                                // tab=2的时候，新数据下拉完成，要显示加载历史数据button
                                                if(num == 2) {
                                                    $("#orderList2").append("<div class='load-more'>查看更多历史订单</div>");
                                                }

                                            }
                                            
                                        });
                                    }
                                });
                              } 
                                
                            } else {
                                // tab=2的时候，新数据下拉完成，要显示加载历史数据button
                                
                                if(num == 2) {
                                    $("#orderList2").append("<div class='load-more'>查看更多历史订单</div>");
                                }
                            }
                        } else {
                            // tab=2的时候，新数据没有，要加载历史数据
                            if(num == 2) {
                            	config.loadHistory();
                            	//新数据和老数据都为空判断
                            	if(config.dataList[2].length <= 0){
                            		$(".dropList").append('<div class="car-empty"><div><i class="icon-order"></i></div><p>您还没有相关的订单</p><input type="button" value="立即去预约"></div>');
                            		$(".car-empty").on('click', function(){
                            			_hmt.push(['_trackEvent', 'href', 'click', '我的订单-立即去预约']);
                            			window.location.href='${contextPath}/service/index.htm'
                            		})
                            	}
                            	return false;
                            }
                        }
                        config.init(num);
                    });
                } //请求数据并添加下拉加载

            };

            //TAB切换
            $('.car-order-nav li').on('click', function() {
            		var tabNum = $("#tabNum").val();
            		
	            	bmsRowStart = 0;
	                orderRowStart = 0;
	                var index = $(this).index(),
	                    width = $(this).width();
	                navNum = index;

	                if (tabNum != '' && tabNum == navNum && firstLoad != '1') {
	                	return;
	                }
	                dropload.init();
	                $(this).addClass('active').siblings().removeClass('active');
	                $('.active-line').css('left', index * width + 'px');
	                $(".car-order-list").eq(navNum).show().siblings('.car-order-list').hide();
	                config.initLoad(navNum);
	               	$(".load-more").remove();
	               	$("#tabNum").val(index);
	               	$(document).scrollTop(0);
	               	firstLoad = '0';
            });

			config.tabReturn($("#tabNum").val());
			
			
            //历史加载更多
            $("#orderList2").on('click', '.load-more', function(){
                $('#orderList2').dropload({isloack:false});
                config.loadHistory();
            })

            // 取消预约单;
            function btnCancel(btn, orderId, orderNo) {
                confirmObj("您确定取消预约？", "暂不取消", "取消预约", function(flg) {
                    if (flg == 2) {
                        var url = $.context + "/order/cancel.htm";
                        var reqData = {
                            "orderId": orderId,
                            "orderNo": orderNo
                        };
                        $.getajax(url, reqData, function(data) {
                            if (data.result == $.dataResult.SUCCESS) {
                                window.location.href = $.context + "/order/list.htm?notLoad=true";
                            } else {
                                comAlertObj(data.msg);
                            }
                        });
                    }
                });
                return false;
            };

            document.body.addEventListener('touchstart', function() {}, false);
            </script>
</body>

 
</html>
