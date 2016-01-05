<!DOCTYPE html>
<html>
<head>
    
    <title>我的工单</title>
     <#include "/tzh/common/tzh_header.ftl" encoding="UTF-8">
    <link rel="stylesheet" href="<@jci.domain url='/tzh/css/dropload.css'/>" type="text/css">
    <script src="<@jci.domain url='/js/dropload.min.js'/>"></script>
    <style>
        a{display: block;overflow: hidden;color: #333;}
    </style>

</head>
<body>
<#include "/tzh/common/tzh_rem.ftl" encoding="UTF-8">

    <div class="outer">
        <div class="inner" id="inner" >
            <div class="lists"></div>
        </div>
    </div>
<script id="work-order" type="text/html">
{{# if(d.length>0){  }}
        {{# for(var i = 0; i< d.length; i++){ }}
        <section class="work-order">
         
            <div class="order-title">
                <span>{{d[i].carPlate}}</span><span><i>{{d[i].orderStatusName}}</i></span><span class="color-999">订单编号：{{d[i].orderNo}}</span>
            </div>
            <div class="order-content">
                <div class="order-con order-con-first">
                    <span>{{d[i].custName}}</span>
                    <span >
                             <a href="tel:{{d[i].mobilePhone}}" >
                                <b class="phone">
                                    <i class="iconfont icon-dianhua"></i>{{d[i].mobilePhone}}
                                </b>
                              </a> 
                            </span>
                </div>
                <a href="${contextPath}/tzh/tzh_order_detail_{{d[i].orderId}}.htm?empNo=${empNo}" >
                <div class="order-ct">
                    <div class="order-con">
                        <span >下单时间</span><span>{{d[i].orderDateTime}}</span>
                    </div>
                    <div class="order-con">
                        <span>订单总金额</span><span><b>{{d[i].orderPaidMoney}}</b>（已支付）</span>
                    </div>
                    {{# if(d[i].orderType=='3'){ var temp=d[i].assessScore*20}}
                   
                    <div class="order-con eval">
                        <span>服务评价</span>
                            <span>
                                <div class="star">
                                    <p>
                                        <b></b>
                                        <b class="score" style="width: {{temp}}%;"></b>
                                    </p>
                               </div>

                              &nbsp;&nbsp;{{d[i].assessTip}}
                            </span>
                    </div>
                   
                   
                     {{# } }}
                     
                    <div class="arrow">
                        
                           <div><i class="iconfont icon-arrow"></i></div>
                        
                    </div>
                    
                </div>
               </a>
            </div>
           
        </section>
        {{# } }}


{{# }else{  }}

<section class="error">
    <div><i class="iconfont icon-null"></i> </div>
    <div>暂无工单</div>
</section>

{{#}  }}

</script>


<#include "/common/footer.ftl" encoding="UTF-8">

<script>
    var url = $.context + "/tzh/queryOrderList.htm";
    var data = {
        empNo : "${empNo}",
        rowStart : 0,
        rowCount : "${rowCount}"
    };
    
    var loadHistory = function(){
        
        $.postajax(url, data, function(lists){
            
             if(lists.length == data.rowCount){
                data.rowStart =  Number(data.rowStart) + Number(data.rowCount);
             }else {
                dropload.lock();
            }
            init(lists);
        });
    }
    loadHistory();
    
     
     var dropload = $('.inner').dropload({
        domDown: {
            domClass: 'dropload-down',
            domRefresh: '<div class="dropload-refresh">↑上拉加载更多</div>',
            domUpdate: '<div class="dropload-update">↓释放加载</div>',
            domLoad: '<div class="dropload-load"><span class="loading"></span>加载中...</div>'
        },
        loadDownFn: function(me) {
            $("#loadImg").css('opacity','0');
            $.postajax(url, data, function(lists) {
                if(lists.length == data.rowCount){
                    data.rowStart =  Number(data.rowStart) + Number(data.rowCount);
                    init(lists);
                }else{
                    dropload.lock();
                }
                 me.resetload();
            });
        }
    });
     
  
        
     //获取渲染数据后的DOM

        function init(info) {
            var carOrder = document.getElementById('work-order').innerHTML;
            laytpl(carOrder).render(info, function(html) {
                document.querySelector(".lists").innerHTML += html;
            });
        
        }
</script>
</body>
</html>
