<!DOCTYPE html>
<html>
<head>
<title>服务网点</title>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="Cache-Control" content="no-transform " />
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="format-detection" content="telephone=no" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<#import "/common/jci.ftl" as jci/>
<link rel="stylesheet" type="text/css" href="<@jci.resources url='/css/fontlibrary/font.css'/>" />
<script src="http://webapi.amap.com/maps?v=1.3&key=b0d549863a154ddd0deaf5d547f07dbb"></script>
<style>
    html,body,h2,p,span{
        margin: 0;
        padding: 0;
    }
    .store-map .marker{
        width: 19rem;
        background: rgba(255,255,255,.9);
        -webkit-box-sizing: border-box;
        -moz-box-sizing: border-box;
        box-sizing: border-box;
        padding: .8rem 1rem;
        position: absolute;
        bottom: 3rem;
        left: 1rem;
        -webkit-transform: translateX(-50%);
        -ms-transform: translateX(-50%);
        box-shadow: 1px 1px 3px rgba(102,102,102,.6);
    }
    .store-map .marker h2{
        font-size: 1.4rem;
        font-weight: normal;
        color: #333;
    }
    .store-map .marker p{
          font-size: 1.1rem;
          margin-top: .5rem;
          height: 1.5rem;
          line-height: 1.5rem;
          overflow: hidden;
          color: #666;
          text-overflow: ellipsis;
          white-space: nowrap;
    }

    .store-map .detail{
        width: 100%;
        height: 5rem;
        position: fixed;
        bottom: 0;
        left: 0;
        padding: .9rem 1rem;
        background: #fff;
        box-shadow: 0 0 .2rem rgba(0,0,0,.6);
        -webkit-box-sizing: border-box;
        -moz-box-sizing: border-box;
        box-sizing: border-box;
    }
    .store-map .detail div{
        display: inline-block;
        font-size: 1.2rem;
        color:#333;
    }
    .store-map .detail div i{
        display: inline-block;
        vertical-align: top;
        color:#999;
        margin-right: .2rem;
    }
    .store-map .detail div span{
        width: 17rem;
        display: inline-block;
    }
    .store-map .detail input{
        width: 9.2rem;
        height: 3.2rem;
        line-height: 3.2rem;
        font-size: 1.3rem;
        color:#fff;
        background: #ff6600;
        border: none;
        border-radius: .5rem;
        position: absolute;
        top: .9rem;
        right:  1rem;
        -webkit-text-size-adjust: none;
        -webkit-appearance: none;
        -moz-appearance: none;
    }
    /* iconfont begin */
    @font-face {
        font-family: "iconfont";
        src: url('<@jci.resources url='/css/fontlibrary/fonts/iconfont.ttf'/>') format('truetype'), 
        url('<@jci.resources url='/css/fontlibrary/fonts/iconfont.svg#iconfont'/>') format('svg');
        /* iOS 4.1- */
    }
    .iconfont {
        font-family: "iconfont" !important;
        font-size: 1.4rem;
        font-style: normal;
        -webkit-font-smoothing: antialiased;
        -webkit-text-stroke-width: 0.2px;
        -moz-osx-font-smoothing: grayscale;
        color:#7f7f7f;
    }
    .icon-location2:before { content: "\e634"; }
    .icon-location3:before { content: "\e635"; }
    .icon-location3{
        font-size: 2.2rem;
        color:#ff6600;
    }
</style>
</head>

<body>
<#include "/common/rem.ftl" encoding="UTF-8">
<div class="store-map">
    <div id="map"></div>
    <div class="detail">
        <div>
            <i class="iconfont icon-location2"></i>
            <span>${store.address!}</span>
        </div>
        <a href="http://mo.amap.com/?to=${store.localX},${store.localY}(${store.storeName})"><input type="button" value="查看路线"></a>
    </div>
</div>
    
<script language="javascript">
	//初始化地图对象，加载地图
	var mapObj
	
	function mapInit() {
	    mapObj = new AMap.Map("map", {
	        dragEnable: true,
	        zoomEnable: true,
	        zooms: [3, 18],
	        //二维地图显示视口
	        view: new AMap.View2D({
	            center: new AMap.LngLat(${store.localX}, ${store.localY}), //地图中心点
	            zoom: 16 //地图显示的缩放级别
	        })
	    });
	    var marker = new AMap.Marker({
	        position: mapObj.getCenter(),
	        size: new AMap.Size(23, 25),
	        content: "<i class='iconfont icon-location3'></i><div class='marker'><h2>${store.storeName}</h2><p>${store.address!}</p></div>"
	    });
	    marker.setMap(mapObj);
	
	    mapObj.plugin('AMap.Geolocation', function() {
	        geolocation = new AMap.Geolocation({
	            enableHighAccuracy: true, //是否使用高精度定位，默认:true
	            timeout: 10000, //超过10秒后停止定位，默认：无穷大
	            maximumAge: 0, //定位结果缓存0毫秒，默认：0
	            convert: true, //自动偏移坐标，偏移后的坐标为高德坐标，默认：true
	            showButton: true, //显示定位按钮，默认：true
	            buttonPosition: 'LB', //定位按钮停靠位置，默认：'LB'，左下角
	            buttonOffset: new AMap.Pixel(10, 20), //定位按钮与设置的停靠位置的偏移量，默认：Pixel(10, 20)
	            showMarker: true, //定位成功后在定位到的位置显示点标记，默认：true
	            showCircle: true, //定位成功后用圆圈表示定位精度范围，默认：true
	            panToLocation: true, //定位成功后将定位到的位置作为地图中心点，默认：true
	            zoomToAccuracy: true //定位成功后调整地图视野范围使定位位置及精度范围视野内可见，默认：false
	        });
	        mapObj.addControl(geolocation);
	    });
	
	}
	mapInit();
	
	function fullHeight(){
        var winH = document.documentElement.clientHeight,
            cheMap = document.getElementById('map'),
            detailH = document.querySelectorAll(".detail")[0].offsetHeight;
        cheMap.style.height = (winH - detailH) +'px';
    }
    fullHeight()
</script>
</body>
</html>