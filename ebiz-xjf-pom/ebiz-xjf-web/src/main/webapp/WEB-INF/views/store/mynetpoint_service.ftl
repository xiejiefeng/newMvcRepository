<!DOCTYPE html>
<html>
<head>
<title>服务网点</title>
<#include "/common/header.ftl" encoding="UTF-8">
<script type="text/javascript" src="<@jci.domain url='/js/TouchSlide.1.1.js'/>"></script>
<style>
/*全部服务tab*/
.tabBox .hd{ height:40px; line-height:40px;  font-size:20px; background:#fff;  position:relative;  }
.tabBox .hd ul{ position:absolute; height:42px; top:0; overflow:hidden; width:100%;  }
.tabBox .hd ul li{ float:left; color:#666; width:33%; box-sizing:border-box; text-align:center;  }
.tabBox .hd ul li a{color:#666;}
.tabBox .hd ul .on{ border-bottom:2px solid #347fe9;  background:#fff; color:#666;   }
.tabBox .hd ul .on a{ display:block; color:#666;/* 修复Android 4.0.x 默认浏览器当前样色无效果bug */  }
.tabBox .bd ul{ padding:10px 0 10px 10px;  }
.tabBox .bd li{ height:33px; line-height:33px;   }
.tabBox .bd li a{ color:#666;  }
.tabBox .bd li a{ -webkit-tap-highlight-color:rgba(0,0,0,0); }  /* 去掉链接触摸高亮 */
</style>

</head>

<body>
			<div id="leftTabBox" class="tabBox">
				<div class="hd">
					<ul>
						<li>保养</li>
						<li>美容</li>
						<li>养护</li>
					</ul>
				</div>
				<div class="bd">
						<ul>
							<img src="<@jci.domain url='/images/baoyang.jpg'/>"/>
						</ul>
						<ul>
							<img src="<@jci.domain url='/images/meirong.jpg'/>"/>
						</ul>
						<ul>
							<img src="<@jci.domain url='/images/yanghu.jpg'/>"/>
						</ul>
				</div>
			</div>
			<#include "/common/footer.ftl" encoding="UTF-8">
			<script type="text/javascript">TouchSlide({ slideCell:"#leftTabBox",effect:"leftLoop" }); </script>
</body>
</html>