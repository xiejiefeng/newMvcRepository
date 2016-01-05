$(function(){
    ;(function(obj){
        var arr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ#".split("");	// 字符串26个字符化成长度为26的数组
        // 自运行函数
        var winHeight = document.documentElement.clientHeight || document.body.clientHeight; // 获取屏幕的高度
        var everyHeight = parseInt(winHeight/arr.length);
        // 屏幕的高度除以26,得到26个字母等分高度
        var str = "";									// 字符串为空
        for(var i=0,len=arr.length;i<len;i++){			// 循环26次（因为有26个字母）
            str+="<a href='#letter"+i+"' style='height:"+everyHeight+"px;overflow:hidden;'>"+arr[i]+"</a>";
            // 拼字符串并赋高度值
        }
        obj.append(str);			// 将26个字符插入到页面中
        
        obj.on("touchmove",function(){
            $(this).addClass("car-gray");
        });
        obj.on("touchend",function(e){
            $(this).removeClass("car-gray");
            obj.find("a").removeClass("active");
            $(e.target).addClass("active");
            var txt = $(e.target).html();
            if( $("#brand-list dt:contains("+txt+")").length==1 ){
            	var objTop = $("#brand-list dt:contains("+txt+")").position().top;
            	$("body,html").scrollTop(objTop);   
            	$("#letter-selected").html(txt);
            } 
        });
    })($("#letterRelation"));
    ;(function(){
        $(".letter-order dd a").each(function(){
            var seriesItem = $(this).text();
            $(this).click(function(){
                localStorage.setItem("carbrandItem",seriesItem);
            })
        });
    })();
   
    (function(){
    	var obj = $("#brand-list dt");
    	var arr = [];
    	obj.each(function(){
    		arr.push($(this).position().top);	
    	});
    	console.log(arr);
    	$(window).scroll(function(){
    		var scrolltop = $("body").scrollTop();
    		$.each(arr,function(index,value){
    			if(scrolltop<arr[index]){
    				var txt = obj.eq(index).text();
    				$("#letter-selected").text(txt);
    				$("#letterRelation a").removeClass("active");
    				$("#letterRelation a:contains("+txt+")").addClass("active");
    				return false; 
    			}
    		});	
    	});
    	 
    })();
    
});