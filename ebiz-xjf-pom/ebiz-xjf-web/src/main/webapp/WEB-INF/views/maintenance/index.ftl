<!DOCTYPE html>
<html>

<head>
    <title>保养手册</title>
    <#include "/common/header.ftl" encoding="UTF-8">
</head>

<body>
    <#include "/common/rem.ftl" encoding="UTF-8">
    <section class="car-maintain">
        <div class="car-maintain-tit">
            <img src='${carInfo.logoUrl}' width="24" height="24" alt="car" onerror="errorImg(this)">
            <b>${carInfo.carName}</b>
            <a href="${contextPath}/maintenance/toSelectCar.htm"><span>更换</span><i class="icon-arrows iconfont"></i></a>
        </div>
        <div id="maintainList" class="car-maintain-list">
        </div>
    </section>
    <script src="<@jci.domain url='/js/laytpl.js'/>"></script>
    <script id="maintainCon" type="text/html">
        {{# for(var i = 0; i <maintain.endList.length
        ; i++){ console.log(maintain.endList[i].recentInMileage) }} <dl>
            {{# if(maintain.endList[i].recentInMileage >=1 ){ }}

            <dt>{{maintain.endList[i].recentInMileage}} km</dt>
            {{# } else{ }}
            <dt>? km</dt>
            {{# } }}
            <dd>
                <a href="${contextPath}/order/detail_order_{{maintain.endList[i].orderId}}.htm" data-lable="保养手册-查看订单详情">
                    <div>
                        <p>您于 {{maintain.endList[i].orderDate}} 做过以下保养</p>
                        <ul>
                            {{# for(var o = 0; o< maintain.endList[i].orderDetailInfoList.length;o++){ }} 
                            <li>
                                {{maintain.endList[i].orderDetailInfoList[o].name}}
                            </li>
                            {{# } }}
                        </ul>
                    </div>
                </a>
                {{# if((i+1)==maintain.endList.length && maintenanceOrderList.length > 0 ){ }}
                <section class="car-maintain-f" data-lable="保养手册-建议下次保养时间">建议下次保养时间{{maintain.startData}}</section>
                {{# } }}
            </dd>
            </dl>
            {{# }}} 
            
            {{# if(maintenanceOrderList.length > 0 ) { }}
            {{# for(var h = 0; h< maintain.startList.length; h++){ }} 
            {{# if(maintain.startList[h].orderDetailInfoList.length > 0){ }}
                <dl class="on">
                    {{# if(maintain.startList[h].recentInMileage){  }}
                    <dt>{{maintain.startList[h].recentInMileage}} km</dt>
                    {{# } else{ }}
                    <dt>? km</dt>
                    {{# } }}
                    <dd>
                            <div>
                            	<em>
	                                <ul>
	                                    {{# for(var k = 0; k< maintain.startList[h].orderDetailInfoList.length; k++){ }} 
	                                    <li>
	                                        {{maintain.startList[h].orderDetailInfoList[k].name}}
	                                        {{# if((maintain.startList[h].orderDetailInfoList[k].cycle/12) === 0.5){  }}
	                                        <span>建议{{maintain.startList[h].orderDetailInfoList[k].cycle}}个月更换</span>
	                                        {{# } else if((maintain.startList[h].orderDetailInfoList[k].cycle/12)>=1){ }}
	                                            <span>建议{{maintain.startList[h].orderDetailInfoList[k].cycle/12}}年更换</span>
	                                        {{# } }}
	                                        </li>
	                                        {{# } }}
	                                </ul>
	                                {{# if(maintain.startList[h].orderDetailInfoList.length > 4){  }}
	                                <a href="javascript:void(0)"></a><b><i class="icon-down"></i></b>
	                                {{# } }}
                                </em>
                                <s onclick="_hmt.push(['_trackEvent', 'href', 'click', '保养手册-去保养']);window.location.href='${contextPath}/service/index.htm?products={{maintain.startList[h].code}}'"><span>去保养<i class="icon-arrows iconfont"></i></span></s>
                            </div>
                    </dd>
                    </dl>
                {{# } }}
                {{# } }}
                <dl class="on null">
                    <dt>{{maintain.startList[maintain.startList.length-1].recentInMileage}} km</dt>
                    <dd>
                        <div>暂无数据，你可以考虑换个车了</div>
                    </dd>
                </dl>
                {{#  } }}
    </script>
    <script>
    var historyOrderList = ${historyOrderList};
    var maintenanceOrderList = ${maintenanceOrderList};
    
    function ListInfo(code, cycle, mileage, name, orderDate, orderId){
        this.code = code;
        this.cycle = cycle;
        this.mileage = mileage;
        this.name = name;
        this.orderDate = orderDate;
        this.orderId = orderId;
    }

    function order(data){
        var listCon = [];
        var ls ={
            orderDetailInfoList :[],
            code:[],
            recentInMileage: "",
            orderDate:"",
            orderId: "",
            state: false,
            state3: false,
            state7: false
        };
        var l1 = {"code": "","cycle": "","mileage": 5000,"name": "更换发动机机油"},
        	l2 = {"code": "","cycle": "","mileage": 5000,"name": "更换机油滤清器"},
        	l3 = {"code": "S0032","cycle": "12","mileage": 20000,"name": "更换雨刮片"};
        	l7 = {"code": "S0078","cycle": "","mileage": 40000,"name": "更换火花塞"};
        for (var i = 0; i < data.length; i++) {
            ls ={
                orderDetailInfoList :[],
                code:[],
                recentInMileage: "",
                orderDate:"",
                orderId: "",
                state: false,
	            state3: false,
	            state7: false
            };
            var  il = data[i].orderDetailInfoList;
            ls.recentInMileage = data[i].recentInMileage;
            ls.orderId = data[i].orderId;
            ls.orderDate = data[i].orderDate;
            for (var k = 0; k <  il.length; k++) {
                if( il[k].code == "S0001" || il[k].code == "S0002" || il[k].code == "S0003" || il[k].code == "S0203"){
                    ls.state = true;
                } else if(il[k].code == "S0031" || il[k].code == "S0032"){
                    ls.state3 = true;
                } else if(il[k].code == "S0078" || il[k].code == "S0079"){
                    ls.state7 = true;
                } else {
                    var listInfo = new ListInfo( il[k].code,  il[k].cycle,  il[k].mileage,  il[k].name, il[k].orderDate);
                    ls.orderDetailInfoList.push(listInfo);
                    ls.code.push(il[k].code);
                }
            };
            listCon.push(ls);
            if(ls.state == true){
                ls.orderDetailInfoList.unshift(l2);
                ls.orderDetailInfoList.unshift(l1);
            };
            if (ls.state3 == true) {
                ls.orderDetailInfoList.push(l3);
                ls.code.push(l3.code);
            };
            if (ls.state7 == true) {
                ls.orderDetailInfoList.push(l7);
                ls.code.push(l7.code);
            };
        };
        return listCon;
    }



    var maintain = {
        startData: "${nextDate}",
        endList: order(historyOrderList),
        startList:  order(maintenanceOrderList)
    };
	
    function init() {
        var maintainCon = document.getElementById('maintainCon').innerHTML;
        laytpl(maintainCon).render(maintain, function(html) {
            document.getElementById('maintainList').innerHTML = html;
        });
    }
    init();

    $(".car-maintain-list").on("click", ".on a", function() {
        $(this).next().toggleClass('on');
        $(this).prev("ul").toggleClass('active');
    });
    function firstOffset(){
    	var offsetTop = null;
    	if($(".car-maintain-f").length > 0){
    		offsetTop = $(".car-maintain-f").offset().top;
    	} else{
    		offsetTop = 0;
    	}
        
        var titH = $(".car-maintain-tit").height();
        return  offsetTop-titH;
    }
    var offH = firstOffset();
    $(window).scroll(function() {
           var  scrollTop = $(document).scrollTop();
        if (scrollTop >= (offH-50)) {
            $(".car-maintain-list section").addClass('car-fixed');
        } else {
            $(".car-maintain-list section").removeClass('car-fixed');
        }
    });
    if ($(".car-maintain-f").length === 1) {
            $(document).scrollTop($("dl").find(".car-maintain-f").parents("dl").offset().top - $(".car-maintain-tit").height() - 10);
        };
    </script>
    <#include "/common/footer.ftl" encoding="UTF-8">
</body>

</html>
