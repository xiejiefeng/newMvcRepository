
/**
 * 公用 弹窗 
 */

$.openLayer= function(content,callback){
	
	$.closeLayer();
	var _html= '<div class="pop-layer"><div class="pop-content-ct"><div class="pop-layer-close-ct" >'
				+'<div  class="pop-layer-close"></div></div> <div class="pop-content">'+content+'</div></div></div>';
	$(document.body).append(_html);
	$(".pop-layer").height($(document).height());
	var pop_content= $(".pop-layer .pop-content-ct");
	var _top= ($(window).height()-pop_content.height())/2-50;
	pop_content.css("top",_top+"px");
	
	$(".pop-layer-close").click(function(){
		$.closeLayer();
	});
	$(".pop-layer").click(function(){
		$.closeLayer();
	});
	$(".pop-content-ct").click(function(){
		return false;
	});
	callback&&callback();
};

$.tipShow= function(text){
	layer.open({content:text,time: 2});
}
$.closeLayer= function(){
	$(".pop-layer").remove();
}

/**
 * 异步请求 封装
 */
$.timeout= 10000;
$.ajaxPost=function(url,data,successfn,arg){
	
	$.ajax({
        url:url,
        async:true,
        type:'post',
        data:data,
        dataType:"json",
    	timeout: $.timeout,
    	beforeSend: function(xhr){
    		 layer.open({type:2});
    	},
    	error : function(xhr, textStatus, error) {
    		
    		
    		layer.closeAll();
			if (textStatus === "timeout") {
				 layer.open({content:'连接超时!请稍后再试',time: 2});
			} else if (textStatus == "error") {
				 layer.open({content:'连接超时! 请稍后再试',time: 2});
			}
		},
        success : function(data) {
        	layer.closeAll();
        	successfn.call(this,data,arg);
        },
        complete: function(xhr, textStatus, error) {
        	
        	
        }
    });
};
/**Ajax方法 GET提交 设置有错误处理超时处理
 * @param url 请求URL
 * @param data 请求数据
 * successfn 成功回调函数
 * arg 回传值
 * */
$.ajaxGet=function(url,data,successfn,arg){
	$.ajax({
        url:url,
        async:true,
        type:'get',
        data:data,
        dataType:"json",
    	timeout:$.timeout,
    	beforeSend: function(xhr){
    		 layer.open({type:2});
    	},
    	error : function(xhr, textStatus, error) {
    		layer.closeAll();
			if (textStatus === "timeout") {
				 layer.open({content:'连接超时!请稍后再试',time: 2});
			} else if (textStatus == "error") {
				 layer.open({content:'连接超时! 请稍后再试',time: 2});
			}
			
		},
        success : function(data) {
        	layer.closeAll();
        	successfn.call(this,data,arg);
        },
        complete: function(xhr, textStatus, error) {
        	
        	
        }
    });
};


/**
 * 显示 分享引导页面
 */
$.shareCode = function(){
	$.closeLayer();
	var _html= '<div class="share-guide"><img src="'+resourcesDomain+'/active/image/share_guide.png"/></div>';
	$(document.body).append(_html);
	$(".share-guide").height($(document).height());
	$(".share-guide").click(function(){
	    $(this).remove();
	});
}
/**
 * 将日期类型转换成字符串型格式yyyy-MM-dd hh:mm
 */
$.string2DateTime= function(stringIn){
	
	return new Date(Date.parse(stringIn.replace(/-/g, "/")));  
}

/**
 * 将日期类型转换成字符串型格式yyyy-MM-dd hh:mm
 */
$.dateTime2String= function(DateIn)
{
	var Year=0;
	var Month=0;
	var Day=0;
	var Hour = 0;
	var Minute = 0;
	var CurrentDate="";
	
	//初始化时间
	Year      = DateIn.getYear();
	Month     = DateIn.getMonth()+1;
	Day       = DateIn.getDate();
	Hour      = DateIn.getHours();
	Minute    = DateIn.getMinutes();
	
	
	CurrentDate = Year + "-";
	if (Month >= 10 )
	{
	CurrentDate = CurrentDate + Month + "-";
	}
	else
	{
	CurrentDate = CurrentDate + "0" + Month + "-";
	}
	if (Day >= 10 )
	{
	CurrentDate = CurrentDate + Day ;
	}
	else
	{
	CurrentDate = CurrentDate + "0" + Day ;
	}
	
	if(Hour >=10)
	{
	CurrentDate = CurrentDate + " " + Hour ;
	}
	else
	{
	CurrentDate = CurrentDate + " 0" + Hour ;
	}
	if(Minute >=10)
	{
	CurrentDate = CurrentDate + ":" + Minute ;
	}
	else
	{
	CurrentDate = CurrentDate + ":0" + Minute ;
	}      
	return CurrentDate;
}



