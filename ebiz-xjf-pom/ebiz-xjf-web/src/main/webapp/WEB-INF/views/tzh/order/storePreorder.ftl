<!DOCTYPE html>
<html>
<head>
    
    <title>我的预约</title>
     <#include "/tzh/common/tzh_header.ftl" encoding="UTF-8">
    <link rel="stylesheet" href="<@jci.domain url='/tzh/css/dropload.css'/>" type="text/css">
    <script src="<@jci.domain url='/js/TouchSlide.1.1.js'/>"></script>
    <script src="<@jci.domain url='/js/dropload.min.js'/>"></script>
    
    <style>
    
        .inner{
            background: #f2f2f2;}
        .loading{color: red!important;}
        /*.con{ float: left; position: relative;}*/
        a{display: block;overflow: hidden;color: #333;}
    </style>
</head>
<body class="my-order order-detail">
<input type='hidden' id='rowCount' name='rowCount' value='${rowCount}' />
<input type='hidden' id='storeId' name='storeId' value='${storeId}' />
<#include "/tzh/common/tzh_rem.ftl" encoding="UTF-8">
<!-- Tab切换 -->
<div id="tabBox"  class="tabBox">
    <div class="hd">
        <ul>
            <li id="tab01">待确认</li><li id="tab02">已预约</li> <li id="tab03">已取消</li>
        </ul>
    </div>
    <div class="bd" >
        <div class="con">
            <div class="outer" id="outer-1" >
                <div class="inner" id="panel-1">
                    <div class="lists"></div>
                </div>
            </div>
        </div>
        <div class="con"><!-- 高度自适应需添加外层 -->
            <div class="outer" id="outer-2" >
                <div class="inner" id="panel-2">
                    <div class="lists "></div>
                </div>
            </div>
        </div>
        <div class="con"><!-- 高度自适应需添加外层 -->
            <div class="outer" id="outer-3" >
                <div class="inner" id="panel-3">
                    <div class="lists"></div>
                </div>
            </div>
        </div>
    </div>
</div>
<input type='hidden' id='RowCount_1' name='RowCount_1' value='0' />
<input type='hidden' id='RowCount_2' name='RowCount_2' value='0' />
<input type='hidden' id='RowCount_3' name='RowCount_3' value='0' />

<script id="tpl-1" type="text/html">
{{# if(d.dataList.length>0){ }}
        {{# for(var i = 0; i< d.dataList.length; i++){ }}
        <section class="work-order work-order-detail">
            <div class="order-title">
                <span>{{d.dataList[i].carPlate}}</span><span><i>{{d.dataList[i].orderStatusName}}</i></span><span class="color-999">订单编号：{{d.dataList[i].orderNo}}</span>
            </div>
            <div class="order-content">
                <div class="order-con">
                    <span>{{d.dataList[i].custName}}</span><span>
                    <a href="tel:{{d.dataList[i].mobilePhone}}" >
	                    <b class="phone">
	                        <i class="iconfont icon-dianhua"></i>{{d.dataList[i].mobilePhone}}
	                    </b>
                    </a>
                    </span>
                </div>
                <div class="order-con car-style">
                    <span>客户车辆</span><span><img src="{{d.dataList[i].logoUrl}}"><b  class="text-overflow">{{d.dataList[i].carName}}</b></span>
                </div>
                <div class="order-con">
                    <span>到店时间</span>
                    <span>{{d.dataList[i].orderWeek}}</span>
                </div>
                <div class="order-con service">
                    <span>服务项目</span>
                    <span>



                        {{# if(d.dataList[i].orderDetailInfoList.length>3){ }}
                           <ul>
                               {{# for(var r = 0; r< d.dataList[i].orderDetailInfoList.length; r++){ var temp=d.dataList[i].orderDetailInfoList.length-3}}
                               <li>{{d.dataList[i].orderDetailInfoList[r].name}}</li>
                               {{# } }}
                           </ul>
                           <div class="more-btn" >显示其他{{temp}}项<i class="iconfont icon-arrow"></i></div>


                       {{#  }else if(d.dataList[i].orderDetailInfoList.length<=3){  }}
                           <ul>
                               {{# for(var r = 0; r< d.dataList[i].orderDetailInfoList.length; r++){ }}
                               <li>{{d.dataList[i].orderDetailInfoList[r].name}}</li>
                               {{# } }}
                           </ul>

                        {{# } }}


            </span>
                </div>
                <div class="order-con">
                    <span>订单金额</span>
                    <span class="price-r">
                    	{{#if(d.dataList[i].orderTotalMoney!=null){ }}
                    	 {{d.dataList[i].orderTotalMoney}}
                        {{# } }}
                    </span>
                </div>
            </div>
        </section>
        {{# } }}
{{# }else{ }}
  <div class="error">
    <div><i class="iconfont icon-null"></i> </div>
    <div>暂无预约单</div>
  </div>
{{# } }}

</script>
<#include "/common/footer.ftl" encoding="UTF-8">
<script>
var dataList=[];
var rowStart=0;
var rowCount=${rowCount};
var dropload = {};
    $(function(){
    	
    	 //调整宽高
        whAdjust (1);
        whAdjust (2);
        whAdjust (3);
        
        $(".tabBox .hd li").attr('toggleState',1); //重复点击同一tab时状态
        TouchSlide( { slideCell:"#tabBox",
                       endFun:function (index) {
                      	    //清空注册事件
				        	dropload={};
				        	var oTab=$(".tabBox .hd li").eq(index);
				        	var index=index+1;
				        	$("#RowCount_"+index).val(0);
				        	oTab.siblings().attr("toggleState",'1');
				        	//再次点击同一tab时 返回
				         
				          if (oTab.attr('toggleState')==0) {
				            return;
                          }else{
					       initPanel(index, $.context +"/tzh/queryPreorderList.htm");
					        	oTab.attr('toggleState',0);
					      }
        }} );
//     TouchSlide( { slideCell:"#tabBox"});
//     initPanel(1, $.context +"/tzh/queryPreorderList.htm");
//     $(".tabBox .hd li").on('click',function () {
//       	    //清空注册事件
//				        	dropload={};
//				        	var oTab=$(this);
//				        	var index=$(this).index()+1;
//				        	$("#RowCount_"+index).val(0);
//				        	
//				        	oTab.siblings().attr("firstLoad",'1');
//				        	//再次点击同一tab时 返回
//				        	if (oTab.attr('firstLoad')==0) {
//					            return;
//					        }else{
//					        	initPanel(index, $.context +"/tzh/queryPreorderList.htm");
//					        	oTab.attr('firstLoad',0);
//					        }
//     })
        more();
        $(".tabBox .hd").css({"position":"fixed","top":0,"z-index":999});
    });

    // 初始化面板
    function initPanel(index,url){
        var panel= $("#panel-"+index);
        var data = {
                	    "storeId":${storeId},
                        "rowStart": Number($("#RowCount_"+index).val()),
                        "tab": index-1
                    };
        $("#loadImg").css('opacity','1');
        $.postajax(url, data, function(lists){
        	var dataList=lists;
        	
            panel.find(".lists").html(getHTML(dataList,$("#tpl-1").html()));
            
            panel.closest(".bd").height($(document).height());
            $("#RowCount_"+index).val(lists.length);
            $('.inner').scrollTop(0);
            if(lists.length==${rowCount}){
                $('#panel-'+index).off();
                initDropload(index);
            }

        });

    }
    function whAdjust (index) {
    	var panel= $("#panel-"+index);
    	var percent1= (index-1)*100/$("#panel-"+index).closest(".bd").children().size();
        var percent2= 100/$("#panel-"+index).closest(".bd").children().size();
        panel.parent().css("left",percent1+"%");
        panel.css("width",percent2+"%");
        var tab_header_h= $(".tabBox .hd").height();
        var tab_content_h=panel.height();
        panel.closest(".outer").css({"top": tab_header_h+"px"});
        panel.css("margin-bottom", tab_header_h+"px");
    }
    //初始化下拉加载
    function initDropload(index){
         dropload = $('#panel-'+index).dropload({
            loadDownFn : function(me){
                var url = "/tzh/queryPreorderList.htm";
                var data = {
                	    "storeId":${storeId},
                        "rowStart": Number($("#RowCount_"+index).val()),
                        "tab": index-1
                    };
                var preRowCount=Number($("#RowCount_"+index).val());
                $("#loadImg").css('opacity','0');
            	$.postajax(url, data, function(lists){
            		if(lists.length==${rowCount}){
            			$('#panel-'+index+" .lists").append(getHTML(lists,$("#tpl-1").html()));
            		    $("#RowCount_"+index).val(lists.length+preRowCount);
            			me.resetload();
            		}else if(lists.length<${rowCount}&&lists.length>0){
            			$('#panel-'+index+" .lists").append(getHTML(lists,$("#tpl-1").html()));
            		    $("#RowCount_"+index).val(lists.length+preRowCount);
            		    me.resetload();
            		    me.lock();
            		}else if(lists.length==0){
            			 me.resetload();
            		     me.lock();
            		}
                 });
                 return false;
            }
        });
        
    	
    
        
    }
    //获取渲染数据后的DOM
    function getHTML(data,tpl){
        return laytpl(tpl).render({dataList:data});
    }
    //显示更多
    function more(){
        $(".bd").on("click", ".more-btn", function() {
            $(this).toggleClass('on');
            $(this).prev("ul").toggleClass('active');
            var temp=$(this).prev("ul").children().length;
            var temp2=$(this).prev("ul").children().length-3;
            if($(this).hasClass('on')  ){
                $(this).html('收起<i class="iconfont icon-arrow-up"></i>')
            }else{
                $(this).html('显示其他'+temp2+'项<i class="iconfont icon-arrow"></i>')
            }
        });
    }
</script>

</body>
</html>