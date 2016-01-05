<!DOCTYPE html>
<html>
	<head>
		<title>我的提成</title>
	    <#include "/tzh/common/tzh_header.ftl" encoding="UTF-8">
        <link rel="stylesheet" href="<@jci.domain url='/tzh/css/dropload.css'/>" type="text/css">
        <script src="<@jci.domain url='/js/dropload.min.js'/>"></script>
	</head>
	<body class="bonus">
<#include "/tzh/common/tzh_rem.ftl" encoding="UTF-8">		
<input type='hidden' id='RowCount_1' name='RowCount_1' value='0' />
<input type='hidden' id='RowCount_2' name='RowCount_2' value='0' />
<input type='hidden' id='RowCount_3' name='RowCount_3' value='0' />
<input type='hidden' id='currentDate' name='currentDate' value='${dateTime}' />
<input type='hidden' id='originYue' name='originYue' value='' />
   <section  style="" class="head">
        <section class="title" >
			<div class="title-head">
				<div id="last_month"><i class="iconfont icon-arrow-left"></i><span>2015年9月</span></div>
				<div><b id="current_month">10</b>月提成</div>
				<div id="next_month"><span>2015年11月</span><i class="iconfont icon-arrow-right"></i></div>
			</div>
			
		</section>
        <section class="contentTotal"  > 
            <div class="title-con">
					<span class="biIcon">&nbsp;&nbsp;<b>币</b></span><span id="totalMoneyBefore">0</span>.<span id="totalMoneyAfter">00</span>
				</div>
			<section class="detail">
				<div class="nav">
					<div><span class="nav-text">全部提成</span><i class="iconfont icon-arrow"></i></div>
				</div>
				
			</section>
            
        </section>  
   </section>
   <section class="detail-content"  style="position: absolute;top:21.9rem; width: 100%;">
				<div class="con">
					
					<div  class="outer">
					    <div class=" inner" id="panel-1">
						      <div class="lists">
							   
						      </div>
					    </div>
					</div>
				</div>
				<div class="con" style="display: none;">
					<div  class="outer">
					    <div class=" inner" id="panel-2">
						      <div class="lists">
							   
						      </div>
					    </div>
					</div>
				</div>
				<div class="con" style="display: none;">
					<div  class="outer">
					    <div class=" inner" id="panel-3">
						      <div class="lists">
							   
						      </div>
					    </div>
					</div>
				</div>
				
			</section>
		
		<script id="bonusTpl"  type="text/html">
	     {{#if(d.moneyList.length>0){ }}
			{{# for(var i=0; i<d.moneyList.length; i++){var temp=Number(d.moneyList[i].score)*20 }}
			{{#if(d.moneyList[i].orderId != '' && d.moneyList[i].orderId != null){ }}
		      <a href="${contextPath}/tzh/tzh_order_detail_{{d.moneyList[i].orderId}}.htm?empNo=${empNo}">
		     {{# } }}
		       <div class="item">
					<dl>
						<dt><span>订单编号&nbsp;&nbsp;{{d.moneyList[i].orderNo}} </span>
						{{#if(d.moneyList[i].empStatus==1){ }}
								<span class="kaidan">开单</span>
						{{#}else if(d.moneyList[i].empStatus==2){ }}
							    <span class="shigong">施工</span>
						{{# } }}
						</dt>
						<dd>{{d.moneyList[i].ssName}}</dd>
						<dd>{{d.moneyList[i].orderAuditTime}}</dd>
						<dd>{{d.moneyList[i].ssMoney}}</dd>
						<dd>
							<div class="star">
								<p>
									<b></b>
									<b class="score" style="width: {{temp}}%;"></b>
								</p>
							</div>
						</dd>
					</dl>
				</div>
			{{#if(d.moneyList[i].orderId != '' && d.moneyList[i].orderId != null){ }}
			 </a> 
			 {{# } }}
			{{# } }}
		  {{# }else if(d.moneyList.length==0){ }}
		    <div class="kong">暂无提成</div>
		  {{# } }}
		</script>
<#include "/common/footer.ftl" encoding="UTF-8">


	</body>
<script>
var rowStart=0;
var rowCount=${rowCount};
var currentDate=$('#currentDate').val();

var empNo="${empNo}";
var dropload =  $('.inner').dropload();
$('#originYue').val('${dateTime}'.substring(4,7));
var originYue=Number($('#originYue').val());
console.log(${dateTime});
document.addEventListener("touchstart", function(){}, true)//弹窗后禁止页面滚动
    $(function () {
    	
    	datePicker();
    	initPanel(1,$.context +"/tzh/getEmpMoneyList.htm");
    	pop();
    	$('.pop-content ul li').attr('firstLoad',1);
    	
    	$('.pop-content ul li').attr('toggleState',1); //重复点击同一tab时状态
    	$('.pop-content ul li').eq(0).attr('toggleState',0); //初始化第一个tab状态为0
    	$('.pop-content ul li').on('click',function () {
    		var index=$(this).index()+1;
    		$(this).siblings().attr("toggleState",'1');
    		if ($(this).attr('toggleState')==0) {
				            return;
	          }else{
		       initPanel(index, $.context +"/tzh/getEmpMoneyList.htm");
		        $(this).attr('toggleState',0);
		      }
    	})
    	
    	
    	
    })
    //点击上下月后执行
    function monthClick () {
    	initPanel(1,$.context +"/tzh/getEmpMoneyList.htm");
    	$('.con').eq(0).show().siblings().hide();//初始化第一个con显示其他隐藏
    	$('.nav-text').html('全部提成');//初始化第一个con显示其他隐藏
    	$('.pop-content ul li').attr('firstLoad',1);
    	$('.pop-content ul li').attr('toggleState',1); //重复点击同一tab时状态
    	$('.pop-content ul li').eq(0).attr('toggleState',0); //初始化第一个tab状态为0
    	$('.pop-content ul li').on('click',function () {
    		var index=$(this).index()+1;
    		$(this).siblings().attr("toggleState",'1');
    		if ($(this).attr('toggleState')==0) {
				            return;
	          }else{
		       initPanel(index, $.context +"/tzh/getEmpMoneyList.htm");
		        	$(this).attr('toggleState',0);
		      }
    	})
    }
    
    // 初始化面板
    function initPanel(index,url){
    	var currentDate=$('#currentDate').val();
        var data= {
                	    "empNo":empNo,
                        "rowStart": 0,
                        "dateTime":$('#currentDate').val(),
                        "empStatus": index-1
                    };
                   
        var panel= $("#panel-"+index);
        if(index==1){
        	 var data= {
                	    "empNo":empNo,
                        "rowStart": 0,
                        "dateTime":$('#currentDate').val(),
              };
        }
        $("#loadImg").css('opacity','1');
        $.postajax(url, data, function(lists){
        	if(lists.totalMoney!=null){
        		var totalMoney=lists.totalMoney;
	        	var totalMoneyArry=totalMoney.split('.');
	        	var totalMoneyBefore=totalMoneyArry[0];
	        	var totalMoneyAfter=totalMoneyArry[1];
	        	$('#totalMoneyBefore').html(totalMoneyBefore);
	        	$('#totalMoneyAfter').html(totalMoneyAfter);
        	}else{
        		$('#totalMoneyBefore').html("0");
        		$('#totalMoneyAfter').html("00");
        	}
        	
            panel.find(" .lists").html(getHTML(lists,$("#bonusTpl").html()));
            $('.kong').css('height',$(window).height()+"px");
            $("#RowCount_"+index).val(lists.moneyList.length);
            panel.closest(".bd").height(panel.find(" .lists").height()+44);
           
           $('.detail-content').height($(window).height()-$('.head').height());
           $(document).on('scroll',function () {
		    	$('.detail-content').height($(window).height()-$('.head').height());
		    })
            if(lists.moneyList.length==${rowCount}){
            	$('#panel-'+index).off();
            	initDropload(index,url);
            	
            }else {
                  dropload.lock();
             }
            
        });

    }
    //初始化下拉加载
    function initDropload(index,url){
        dropload=$('#panel-'+index).dropload({
            loadDownFn : function(me){
               var url2 = url;
               var data = {
                	    "empNo":empNo,
                        "rowStart": Number($("#RowCount_"+index).val()),
                        "dateTime":$('#currentDate').val(),
                        "empStatus": index-1
                    };
               if(index==1){
		        	 var data= {
		                	    "empNo":"${empNo}",
		                        "rowStart": Number($("#RowCount_"+index).val()),
		                        "dateTime":$('#currentDate').val(),
		              };
                } 
                var preRowCount=Number($("#RowCount_"+index).val());
                $("#loadImg").css('opacity','0');
                $.postajax(url2, data, function(lists){
                    if(lists.moneyList.length==${rowCount}){
            			$('#panel-'+index+" .lists").append(getHTML(lists,$("#bonusTpl").html()));
            		    $("#RowCount_"+index).val(lists.moneyList.length+preRowCount);
            			me.resetload();
            		}else if(lists.moneyList.length<${rowCount}&&lists.moneyList.length>0){
            			$('#panel-'+index+" .lists").append(getHTML(lists,$("#bonusTpl").html()));
            		    $("#RowCount_"+index).val(lists.moneyList.length+preRowCount);
            		    me.resetload();
            		    me.lock();
            		}else if(lists.moneyList.length==0){
            			 me.resetload();
            		     me.lock();
            		}
                });
            }
        });
        $('.pop-content ul li').eq(index-1).attr('firstLoad',0);
    }
    
    //再次点击tab下拉加载
    function onemoreDropload(index,url){
               var url2 = url;
               var data = {
                	    "empNo":empNo,
                        "rowStart": Number($("#RowCount_"+index).val()),
                        "dateTime":$('#currentDate').val(),
                        "empStatus": index-1
                    };
               if(index==1){
		        	 var data= {
		                	    "empNo":"${empNo}",
		                        "rowStart": Number($("#RowCount_"+index).val()),
		                        "dateTime":$('#currentDate').val(),
		              };
                } 
                var preRowCount=Number($("#RowCount_"+index).val());
                $("#loadImg").css('opacity','0');
                $.postajax(url2, data, function(lists){
                   
                    if(lists.moneyList.length==${rowCount}){
            			$('#panel-'+index+" .lists").append(getHTML(lists,$("#bonusTpl").html()));
            		    $("#RowCount_"+index).val(lists.moneyList.length+preRowCount);
            			me.resetload();
            		}else if(lists.moneyList.length<${rowCount}&&lists.moneyList.length>0){
            			$('#panel-'+index+" .lists").append(getHTML(lists,$("#bonusTpl").html()));
            		    $("#RowCount_"+index).val(lists.moneyList.length+preRowCount);
            		    me.resetload();
            		    me.lock();
            		}else if(lists.moneyList.length==0){
            			 me.resetload();
            		     me.lock();
            		}
                });
            
        
    }

    

     //获取渲染数据后的DOM
    function getHTML(data,tpl){
        return laytpl(tpl).render(data);
    }
    
    	//弹出框
    function pop () {
    		var html='<div>选择提成类型</div><ul><li class="active" id="full">全部提成</li><li id="kaidan">开单提成</li><li id="shigong">施工提成</li></ul>'
		    $.openLayer(html);
		   var _top= ($(window).height()-$('.pop-content-ct').height());
		    $('.pop-content-ct').css("transition","0");
		    $('.pop-content-ct').css("top",$(window).height());
		//修复浏览器中有搜索栏 导致window.height变化
	    $(document).on('scroll',function () {
	    	$('.pop-content-ct').css("transition","0");
	    	$('.pop-content-ct').hide();
	    	$('.pop-content-ct').css("top",$(window).height());
	    })
	  
	  
	   //修复end
		    
			$('.nav').on('click',function () {
			    $('.pop-content-ct').show();
			    $('.pop-content-ct').css("transition","1s");
	    	    $('.pop-content-ct').css("top",_top+"px");
			    $('.mask').fadeIn();
			})
			
			$('.pop-content ul li').on('click',function () {
				$('.pop-content-ct').css("top",$(window).height());
				$('.mask').fadeOut();
				var text=$(this).html();
				$('.nav-text').html(text);
				$(this).addClass('active').siblings().removeClass('active');
				var index=$(this).index();
				$('.con').eq(index).show().siblings().hide();
				$(this).attr('firstLoad',0);
			})
			
    	}
			
		//点击切换上一月 下一月	
		function datePicker () {
			var str=currentDate;
			var str1=str.substring(0,4);
			var nian=Number(str1);
			var str2=str.substring(4,7);
			var yue=Number(str2);
			var Nian=nian;
			var Yue=yue;
			var lastYear;
			var lastMonth;
			var last;
			var nextYear;
			var nextMonth;
			var next;
			
			if (yue==1) {
				lastYear=nian-1;
				lastMonth=12;
				last=lastYear+'年'+lastMonth+'月';
			}else{
				lastYear=nian;
				lastMonth=yue-1;
				last=lastYear+'年'+lastMonth+'月';
			}
			if (yue==12) {
				nextYear=nian+1;
				nextMonth=1;
				next=nextYear+'年'+nextMonth+'月';
			}else{
				nextYear=nian;
				nextMonth=yue+1;
				next=nextYear+'年'+nextMonth+'月';
			}
			
			$('#last_month span').html(last);
			$('#current_month').html(yue);
			$('#next_month span').html(next);
			
			if(Number($('#current_month').html())==originYue){
				$('#next_month').hide();
			}
			
			
			
			//点击上一月
			$('#last_month').on('click',function () {
				$('#next_month').show();
				
				//上一月
				var lastArry=reduceOneMonth(lastYear,lastMonth);
				lastYear=lastArry[0];
				lastMonth=lastArry[1];
				last=lastYear+'年'+lastMonth+'月';
				$('#last_month span').html(last);
				//当月
				var currentArry=addOneMonth(lastYear,lastMonth);
				yue=currentArry[1];
				nian=currentArry[0];
				$('#current_month').html(yue);
				//下一月
				var nextArry=addOneMonth(nian,yue);
				nextYear=nextArry[0];
				nextMonth=nextArry[1];
				next=nextYear+'年'+nextMonth+'月';
				$('#next_month span').html(next);
				if(yue<10){
					yue='0'+yue;
				}
				$('#currentDate').val(nian+''+yue);
				monthClick ();
				
				if(yue==originYue){
				  $('#next_month').hide();
			    }
				
				
				
				
			})
			
			//点击下一月
			$('#next_month').on('click',function () {
				
					//下一月
				var nextArry=addOneMonth(nextYear,nextMonth);
				nextYear=nextArry[0];
				nextMonth=nextArry[1];
				next=nextYear+'年'+nextMonth+'月';
				$('#next_month span').html(next);
				//当月
				var currentArry=reduceOneMonth(nextYear,nextMonth);
				yue=currentArry[1];
				nian=currentArry[0];
				$('#current_month').html(yue);
				//上一月
				var lastArry=reduceOneMonth(nian,yue);
				lastYear=lastArry[0];
				lastMonth=lastArry[1];
				last=lastYear+'年'+lastMonth+'月';
				$('#last_month span').html(last);
				
				if (nian==Nian&&yue==Yue) {
				  $(this).hide();
				}
				if(yue<10){
					yue='0'+yue;
				}
				$('#currentDate').val(nian+''+yue);
				monthClick ();
				
				if(yue==originYue){
				  $('#next_month').hide();
			    }
				
				
				
			})
			
		}	
			
		function reduceOneMonth(year,month) {
			if (month==1) {
				month=12;
				year=year-1;
				return [year,month];
				
			}else{
				month=month-1;
				return [year,month];
			}
		}
		function addOneMonth(year,month) {
			if (month==12) {
				month=1;
				year=year+1;
				return [year,month];
				
			}else{
				month=month+1;
				return [year,month];
			}
		}
		
		
			
			
			
		</script>


	

</html>