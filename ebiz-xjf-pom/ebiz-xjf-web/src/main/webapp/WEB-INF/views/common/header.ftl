<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="Cache-Control" content="no-transform " />
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="format-detection" content="telephone=no" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<#import "/common/spring.ftl" as spring/>
<#import "/common/jci.ftl" as jci/>
<link rel="dns-prefetch" href="${jscssUrl('/')?replace('http:','')}"/>
<link rel="shortcut icon" href="<@jci.domain url='/jia.ico'/>"/>
<link rel="bookmark" href="<@jci.domain url='/jia.ico'/>"/>
<link rel="stylesheet" type="text/css" href="<@jci.domain url='/css/reset.css'/>" />
<link rel="stylesheet" type="text/css" href="<@jci.domain url='/css/style.css'/>" />
<link rel="stylesheet" type="text/css" href="<@jci.domain url='/css/main.css'/>" />
<link rel="stylesheet" type="text/css" href="<@jci.domain url='/css/jquery.modatepicer.css'/>" />
<link rel="stylesheet" type="text/css" href="<@jci.resources url='/css/fontlibrary/font.css'/>" />

<!--<link rel="stylesheet" type="text/css" href="<@jci.domain url='/css/main.min.css'/>" /> -->
<script type="text/javascript" src="<@jci.domain url='/js/jqmin.js'/>"></script>
<script src="//cdn.bootcss.com/fastclick/1.0.6/fastclick.min.js"></script>
<script>
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "//hm.baidu.com/hm.js?${tongji}";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();

$.resourcesDomain="${jscssUrl('/')}";

//没有图片时默认图片
function errorImg(img) { 
	img.src = $.resourcesDomain+'/images/car-brand-defalut.png'; 
	img.onerror = null; 
}
</script>

