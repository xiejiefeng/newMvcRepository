<!DOCTYPE html>
<html>
<head>
<title>技师详情</title>
<#include "/common/header.ftl" encoding="UTF-8">

</head>

<body style="position: static;">
	<#include "/common/rem.ftl" encoding="UTF-8">
	<div class="technical">
        <div class="detail">
            <img src="<#if empInfo.artificerPic??> ${empInfo.artificerPic} <#else><@jci.domain url='/images/person-default.png'/></#if>">
            <p>${empInfo.artificerName}
                <s>${empInfo.artificerLevel}</s>
            </p>
            <div class="score-star">
                <p>
                    <b></b>
                    <b class="score" style="width:#{(empInfo.artificerScore?number)*20}%"></b>
                </p>
                <span>#{empInfo.artificerScore?number;m1M1}</span>
            </div>
            <div class="store">
                <i class="iconfont icon-store"></i>${empInfo.storeName}
            </div>
        </div>
        <h2>客户评分</h2>
        <div class="list">
            <ul></ul>
        </div>
    </div>
	<script src="<@jci.domain url='/js/dropload.min.js'/>"></script>
	<#include "/common/footer.ftl" encoding="UTF-8">
	<script>
		var url = $.context + '/employee/queryEmpScoreInfo.htm';
        var data = {
        		"empNo":"${empInfo.artificerNo}",
                "rowStart": "0",
                "rowCount": ${rowCount}
            };
            
        //初始拉取数据
		function loadList(){
			$.getajax(url, data, function(obj) {
	                var result = '';
	                if(obj.moneyList.length <= 0) {
	                	$('.list').append('<div class="null">暂无评分</div>');
	                }
	                for (var i = 0; i < obj.moneyList.length; i++) {
	            		result += '<li><div><span>' + obj.moneyList[i].ssName + '</span><div class="score-star"><p><b></b>' + '<b class="score" style="width:' + obj.moneyList[i].score * 20 + '%"></b></p></div></div>' + '<div class="time"><span>' + obj.moneyList[i].mobilePhone + '</span><b>' + obj.moneyList[i].orderAuditTime + '</b></div></li>'
	                }
					if(obj.moneyList.length == data.rowCount){
	                	data.rowStart =  Number(data.rowStart) + Number(data.rowCount);
	                } else {
	                	dropload.lock();
	                }
	                $('.list ul').append(result);
	            });
		}
		loadList()
		
		//注册下拉事件
	    var dropload = $('.list').dropload({
	        domDown: {
	            domClass: 'dropload-down',
	            domRefresh: '<div class="dropload-refresh">↑上拉加载更多</div>',
	            domUpdate: '<div class="dropload-update">↓释放加载</div>',
	            domLoad: '<div class="dropload-load"><span class="loading"></span>加载中...</div>'
	        },
	        loadDownFn: function(me) {
	            $.getajax(url, data, function(obj) {
	                var result = '';
	                for (var i = 0; i < obj.moneyList.length; i++) {
                		result += '<li><div><span>' + obj.moneyList[i].ssName + '</span><div class="score-star"><p><b></b>' + '<b class="score" style="width:' + obj.moneyList[i].score * 20 + '%"></b></p></div></div>' + '<div class="time"><span>' + obj.moneyList[i].mobilePhone + '</span><b>' + obj.moneyList[i].orderAuditTime + '</b></div></li>'
	                }
	                if(obj.moneyList.length == data.rowCount){
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