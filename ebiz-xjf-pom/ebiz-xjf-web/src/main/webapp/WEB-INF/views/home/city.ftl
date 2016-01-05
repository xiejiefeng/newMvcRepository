<!DOCTYPE html>
<html>

<head>
    <title>城市选择</title>
    <#include "/common/header.ftl" encoding="UTF-8">
    <link rel="stylesheet" href="<@jci.domain url='/css/flexslider.css'/>">
</head>

<body>
    <#include "/common/rem.ftl" encoding="UTF-8">
    </script>
    <section class="car-city">
        <div class="car-city-now">定位城市：<span>${area.areaName}</span></div>
        <div id="cityList" class="car-city-list">
        </div>
        <p>其他城市陆续开通中</p>
    </section>
    <#include "/common/footer.ftl" encoding="UTF-8">
    <script src="<@jci.domain url='/js/laytpl.js'/>"></script>
    <script id="cityTpl" type="text/html">
        <ul>
        {{# for(var i = 0; i< cityList.length; i++){ }}
            <li><a href="${contextPath}/home/index.htm?areaCode={{cityList[i].areaCode}}">{{cityList[i].areaName}}</a></li>
        {{# } }} 
        </ul>
    </script>
    <script>
	var cityList = ${areaList};
	function init() {
        var cityTpl = document.getElementById('cityTpl').innerHTML;
        laytpl(cityTpl).render(cityList, function(html) {
            document.getElementById('cityList').innerHTML = html;
        });
    }
    init();
    document.body.addEventListener('touchstart', function () {});  
    </script>
</body>

</html>
