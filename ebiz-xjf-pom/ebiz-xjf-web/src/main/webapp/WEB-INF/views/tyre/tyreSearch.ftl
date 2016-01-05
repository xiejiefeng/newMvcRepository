<!DOCTYPE html>
<html>

<head>
    <title><#if isMatch=true>${tyreNorms}&nbsp;<#else>全部规格</#if></title>
    <#include "/common/header.ftl" encoding="UTF-8">
</head>

<body class="tire-list">
    <#include "/common/rem.ftl" encoding="UTF-8">
    <div class="box">
        <p class="tit">正品轮胎在线支付95折起</p>
	    <section class="nav"><a href="${contextPath}/tyre/allNorms.htm"><#if isMatch=true>${tyreNorms}<#else>全部规格</#if><i 

class="iconfont icon-arrow-down"></i></a></section>
	    
	    <section class="list">
	        <ul></ul>
	    </section>
    </div>
    <#include "/common/footer.ftl" encoding="UTF-8">
    <script src="<@jci.domain url='/js/dropload.min.js'/>"></script>
    <script>
    var url = $.context + '/tyre/querySkuList.htm';
    var data = {
    		"spec": "${tyreNorms}",
            "rowStart": "0",
            "rowCount": ${rowCount}
        };

    //初始拉取数据
    function loadList() {
        $.getajax(url, data, function(skuList) {
            var result = '';
            for (var i = 0; i < skuList.length; i++) {
             result += '<a href="${contextPath}/tyre/tyreDetail.htm?skuCode='+ skuList[i].skuCode + '&isMatch=${isMatch?string('true','false')}">'
                              +'<li>'
                                      +'<div class="title-img"><img src="' + skuList[i].picUrl + '"/></div>'
	                                  +'<div class="content">'
	                                   +' <div class="title">' + skuList[i].skuName + '</div>'
	                                   +' <div class="price">￥' + skuList[i].originalPrice + '</div>'
	                                 +' </div>'
                                     +' <div class="sale-num">已售' + skuList[i].salesNum + '</div>'
                                 +'</li>'
                               +'</a>'
            }

            if(skuList.length == data.rowCount){
                data.rowStart =  Number(data.rowStart) + Number(data.rowCount);
            } else {
                dropload.lock();
            }
            $('.list ul').append(result);
        });
    }
    loadList()

    var dropload = $('.list').dropload({
        domDown: {
            domClass: 'dropload-down',
            domRefresh: '<div class="dropload-refresh">↑上拉加载更多</div>',
            domUpdate: '<div class="dropload-update">↓释放加载</div>',
            domLoad: '<div class="dropload-load"><span class="loading"></span>加载中...</div>'
        },
        loadDownFn: function(me) {
            
            $.getajax(url, data, function(skuList) {
                var result = '';
                for (var i = 0; i < skuList.length; i++) {
                    result += '<a href="${contextPath}/tyre/tyreDetail.htm?skuCode='+ skuList[i].skuCode + '&isMatch=${isMatch?string('true','false')}">'
                              +'<li>'
                                      +'<div class="title-img"><img src="' + skuList[i].picUrl + '"/></div>'
	                                  +'<div class="content">'
	                                   +' <div class="title">' + skuList[i].skuName + '</div>'
	                                   +' <div class="price">￥' + skuList[i].originalPrice + '</div>'
	                                 +' </div>'
                                     +' <div class="sale-num">已售' + skuList[i].salesNum + '</div>'
                                 +'</li>'
                               +'</a>'
                }
                
                if(skuList.length == data.rowCount){
                    data.rowStart =  Number(data.rowStart) + Number(data.rowCount);
                } else {
                    dropload.lock();
                }

                $('.list ul').append(result);
                // 每次数据加载完，必须重置
                me.resetload();


            });
        }
    });
    </script>
     
   
</body>

</html>