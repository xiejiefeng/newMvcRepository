(function($){
	//$.StringUtils.isEmpty() 判断字符串是否为空
	$.StringUtils={
	isEmpty:function(str){return str===null ||str=== undefined ? true : /^[\s\xa0]*$/.test(str);},
	isNotEmpty:function(str){return $.StringUtils.isEmpty(str)?false:true;},
	between:function(s,left, right) {
		      var startPos = s.indexOf(left);
		      var endPos = s.indexOf(right);
		      var start = startPos + left.length;
		      return endPos > startPos ? s.slice(start, endPos) : "";
		 }
	 };
	 $.contexts=function(){
		 //获取应用的上下文根路径
		 var pathname=window.location.pathname;
		 var indexNext= pathname.indexOf("/",0);
		 return pathname.substr(0,indexNext);		 
	 };
	 //获取上文根
	 $.context=$.contexts();
	 $.dataResult={"SUCCESS":1,"FAILD":0};
	 $.timeout=10000;
	 
	    /**Ajax方法 POST提交 设置有错误处理超时处理
	     * @param url 请求URL
	     * @param data 请求数据
	     * successfn 成功回调函数
	     * arg 回传值
	     * */
	    $.postajax=function(url,data,successfn,arg,completefn){
	        var successfn=successfn||$.noop;
	        $("#loadImg").fadeIn();
	    	$.ajax({
	            url:url,
	            async:true,
	            type:'post',
	            data:data,
	            dataType:"json",
	        	timeout:$.timeout,
	        	error : function handleAjaxError(xhr, textStatus, error) {
	        		$("#loadImg").fadeOut();
					if (textStatus === "timeout") {
						comAlertObj("连接超时!请稍后再试");
					} else if (textStatus == "error") {
						comAlertObj("系统繁忙,请稍后再试");
					}
				},
	            success : function(data) {
	            	$("#loadImg").fadeOut();
	            	successfn.call(this,data,arg);
	            },
	            complete : function(xhr, ts) {
	            	if (completefn) {
	            		completefn.call(this);
	            	}
	            }
	        });
	    	
	    };
	    $.postjson=function(url,data,successfn,arg){
	        var successfn=successfn||$.noop;
	        $("#loadImg").fadeIn();
	    	$.ajax({
	            url:url,
	            async:true,
	            type:'post',
	            data:data,
	            dataType:"json",
	            contentType:"application/json",
	        	timeout:$.timeout,
	        	error : function handleAjaxError(xhr, textStatus, error) {
	        		$("#loadImg").fadeOut();
					if (textStatus === "timeout") {
						comAlertObj("连接超时!请稍后再试");
					} else if (textStatus == "error") {
						comAlertObj("系统繁忙,请稍后再试");
					}
				},
	            success : function(data) {
	            	$("#loadImg").fadeOut();
	            	successfn.call(this,data,arg);
	            }
	        });
	    	
	    };
	    /**Ajax方法 GET提交 设置有错误处理超时处理
	     * @param url 请求URL
	     * @param data 请求数据
	     * successfn 成功回调函数
	     * arg 回传值
	     * */
	    $.getajax=function(url,data,successfn,arg){
	    	 var successfn=successfn||$.noop;
	    	 $("#loadImg").fadeIn();
	    	$.ajax({
	            url : url,               
	            async : true,
	            type : 'GET', 
	            data:data,
	            dataType:"json",
	        	timeout:$.timeout,
	        	error : function handleAjaxError(xhr, textStatus, error) {
	        		$("#loadImg").fadeOut();
					if (textStatus === "timeout") {
						comAlertObj("连接超时!请稍后再试");
					} else if (textStatus == "error") {
						comAlertObj("系统繁忙,请稍后再试", null);
					}
				},
	            success : function(data) {
	            	$("#loadImg").fadeOut();
	            	successfn.call(this,data,arg);
	            }
	        });
	    };

     	    /**
		 * 公用 弹窗 
		 */
		
		$.openLayer= function(content,callback){
			
			$.closeLayer();
			var _html= '<div class="pop-layer"><div class="pop-content-ct"><div class="pop-layer-close-ct" >'
						+'<div  class="pop-layer-close">x</div></div> <div class="pop-content">'+content+'</div></div></div>';
			$(document.body).append(_html);
			$(".pop-layer").height($(document).height());
			var pop_content= $(".pop-layer .pop-content-ct");
			var _top= ($(window).height()-pop_content.height())/2-50;
			//pop_content.css("top",_top+"px");
			
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
			$(".pop-layer").hide();
		}

})(jQuery);


var comAlertObj = null;
var comConfirmObj = null;

$(function(){
	;(function(){
		if( $("#alert").length==1){			// 判断是否需要新建弹框
			return false;						
		}else{
			var str = $("<div class='mask' id='mask'></div><div class='alert' id='alert'></div>");
			var confirmStr = $("<div class='confirm' id='confirm'>" +
					"<table><tr><td colspan=2 id='confirmMsg'></td></tr>" +
					"<tr><td style='height:35px;' align=right><a href='#' id='confirm_cancel' class='confirm-btn'>取消</a></td>" +
					"<td style='height:35px;' align=left><a href='#' id='confirm_ok' class='confirm-btn'>确定</a></td></tr></table></div>");
			var confirmSingleStr = $("<div class='confirm' id='cSingle'>" +
					"<table><tr><td colspan=2 id='cSingleMsg'></td></tr>" +
					"<tr><td colspan=2 style='height:35px;' align=center><a href='#' id='cSingle_ok' class='confirm-btn'>确定</a></td></tr></table></div>");
			$("body").append(str);
			$("body").append(confirmStr);
		}	$("body").append(confirmSingleStr);
	})();
	;(function(){
		// 返回头部
		var backToTop = (function(){
			var instance=null;
			function BackToTop(){
				this.obj =  $("<div class='backtop' id='backToTop'><i class='iconfont icon-top' ></i></div>");	
				this.obj.appendTo($("body"));
				this.obj.click(function(){						// 返回顶部
					$("body,html").animate({"scrollTop":0},200);
				});
			}
			return {
				init:function(){
					var winHeight = $(window).height();
					var bodyHeight= $("body").height();
					$(window).scroll(function(){
		                if ($(window).scrollTop()> winHeight*2){
		                	$('.backtop').fadeIn(500);
		                }else{
		                	$('.backtop').fadeOut(500);
		                }
		            });
					if(bodyHeight/winHeight<3){					// 小于3屏不添加返回顶部按钮
						return false;
					}else{
						if(!instance){							// 大于等于3屏判断是否有此对象
							instance=new BackToTop();
						}else{
							return instance;
						}
					}
				}
			}
		})();
		backToTop.init();		
	})();
	;(function(){
		// 获取页面信息
		var deviceObj = (function(user){				
			return {
				webKit: user.indexOf('AppleWebKit') > -1, //苹果、谷歌内核
				ios: !!user.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/), //ios终端
				mobile: !!user.match(/AppleWebKit.*Mobile.*/), //是否为移动终端
			}
		})(navigator.userAgent);
		 
	});
});

function alertObj(txt){
	var timer = null;
	$("#alert").html(txt);
	var obj = $("#mask").add("#alert");
	obj.fadeIn(300);
	timer = setTimeout(function(){
		obj.fadeOut(1000,function(){
			clearTimeout(timer);
		});
	},2000);
}
comAlertObj = alertObj;

function confirmObj(txt, confirm_ok, confirm_cancel, callback){
	$("#confirmMsg").html(txt);
	var obj = $("#mask").add("#confirm");
	
	$("#confirm_ok").off("click");
	$("#confirm_ok").text(confirm_ok);
	$("#confirm_cancel").off("click");
	$("#confirm_cancel").text(confirm_cancel);
	
	$("#confirm_ok").on("click",function(){
		$("#confirm").removeClass('show');
		$("#mask").fadeOut(200);
		callback(1);
		return false;
	});
	$("#confirm_cancel").on("click",function(){
		$("#confirm").removeClass('show');
		$("#mask").fadeOut(200);
		callback(2);
		return false;
	});
	$("#mask").fadeIn(300);
	$("#confirm").addClass('show');
}
comConfirmObj = confirmObj;

function cSingleObj(txt, cSingle_ok, cSingle_class, callback){
	$("#cSingleMsg").html(txt);
	$("#cSingle").addClass(cSingle_class);
	var obj = $("#mask").add("#cSingle");
	
	$("#cSingle_ok").off("click");
	$("#cSingle_ok").text(cSingle_ok);
	
	$("#cSingle_ok").on("click",function(){
		$("#mask").fadeOut(200);
		$("#cSingle").removeClass('show');
		callback(1);
		return false;
	});
	$("#mask").fadeIn(300);
	$("#cSingle").addClass('show');
}



;(function(){													// tab 切换
	var netGlobal=null;
    ;(function(){
        var maxLength = 15;										// 最大15条数据
        var objMore = $("#getMore");
        var divNone = $("#hide");
        netGlobal=(function(){
            return {
                currentObj:$("#reserve0"),
                getLi:function(obj){
                    return obj.find("ul>li");
                },
                init:function(obj){
                    if( obj.attr("data-hasClick")=="true"){             // 保存已点更多状态
                        return false;
                    }    
                    var oLi = this.getLi(obj);
                    this.currentObj = obj;
                    if(oLi.length>maxLength){                           // 大于默认最大条数
                        oLi.slice(0,maxLength).css("display","block");
                        oLi.slice(maxLength).css("display","none");
                        this.hide(divNone);
                        this.show(objMore); 
                    }else if(oLi.length==0){                            // 无数据显示
                        this.hide(objMore);
                        this.show(divNone);
                    }else{                                              // 小于默认条数
                        this.hide(objMore,divNone);
                    }
                    this.clickShow();
                },
                show:function(obj){
                    $.each(arguments,function(){
                        $(this).css("display","block");
                    });
                },
                hide:function(){
                    $.each(arguments,function(){
                        $(this).css("display","none");
                    });
                },
                clickShow:function(){
                    var _this = this;
                    objMore.click(function(){
                        _this.getLi(_this.currentObj).css("display","block");
                        _this.currentObj.attr("data-hasClick","true");  // 已点击过并全部显示
                        $(this).css("display","none");
                    });
                }
            }
        })(); 
        netGlobal.init( $("#reserve0") );
    })();
    ;(function(obj){
        var objLi = obj.find("li");
        var objDiv = $("#reserve0").add("#reserve1").add("#reserve2").add("#reserve3");
        objLi.click(function(){
            var index = objLi.index(this);
            objLi.removeClass("sel").eq(index).addClass("sel");
            $("#hide").css("display","none");
            $("#getMore").css("display","none");
            objDiv.css("display","none").eq(index).css("display","block");
            var subDiv = objDiv.eq(index);
            netGlobal.currentObj = subDiv;
            if(index==0 && $(this).attr("id")=="servicebase"){
            	return false;
            }
            netGlobal.init( netGlobal.currentObj );
        });
    })($("#extent"));
})();
var backet = null;
;(function(){
	var load = $('<div id="loadImg" class="loadImg"><p><img src="'+$.resourcesDomain+'/images/loading.gif"/></p></div>');	// loading 效果
	$("body").append(load);			// 为每个页面插入load 的dom 结构
	
	backet = (function(){											// 添加购物车 和 loading图标						
		var backetObj = null,str="";
		var strFoward ='<div class="buycar" id="buycar"><a href="'+$.context+'/preorder/index.htm"><i class="buycarfont"><span>&#x3475;</span><em>';
		var strBack = '</em></i></a></div>';
		function BacketFn(num){
			str=strFoward+num+strBack;
			$("body").append(str);
		}
		return {
			init:function(){
				if(!backetObj){
					$.postajax($.context+"/preorder/shoppingcart.htm","",function(data){
						if(data.obj.productNums && data.obj.productNums*1>0){
							return backetObj = new BacketFn(data.obj.productNums);
						} 
					});
				}else{
					return backetObj;
				}
			}
		};
	})();
	// backet.init(); 创建购物车方法
})();

(function(){
	Number.prototype.toFixed = function(s) {
		changenum=(parseInt(this * Math.pow( 10, s ) + 0.5)/ Math.pow( 10, s )).toString();
		index=changenum.indexOf(".");
		if(index<0&&s>0){
			changenum=changenum+".";
			for(var i=0;i<s;i++){
				changenum=changenum+"0";
			}
		}else {
			index=changenum.length-index;
			for(var i=0;i<(s-index)+1;i++){
				changenum=changenum+"0";
			}
		}
		return changenum;
	};
})();