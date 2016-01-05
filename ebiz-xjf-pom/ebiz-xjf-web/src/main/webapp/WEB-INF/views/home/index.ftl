<!DOCTYPE html>
<html>

<head>
    <title>车享家</title>
    <#include "/common/header.ftl" encoding="UTF-8">
    <link rel="stylesheet" href="<@jci.domain url='/css/flexslider.css'/>">
</head>

<body >
    <#include "/common/rem.ftl" encoding="UTF-8">
    <section class="car-index">
        <div class="car-index-banner flexslider">
            <a href="${contextPath}/home/toSelectCity.htm" data-lable="首页-选择城市"><span>${area.areaName!}<i class="iconfont icon-arrows"></i></span></a>
            <ul class="slides">
            	<#list bannerList as banner>
                <li>
                	<#if banner.bannerUrl??><a href="${banner.bannerUrl}"></#if>
                	<img src="<@jci.domain url='/images/banner/${banner.bannerImg}'/>" alt="banner" />
                	<#if banner.bannerUrl??></a></#if>
                </li>
                </#list>
            </ul>
        </div>
        
        <!-- pro nav begin -->
        <nav class="car-pro-nav">
            <ul>
                <li>
                	<a href="${menuConfigMap["YYXBY"]}">
                		<section class="pro">
	                        <div>
	                            <h3>小保养
	                                <p>在线支付<span>享9折</span></p>
	                            </h3>
	                        </div>
	                        <img src="<@jci.domain url='/images/homepro/project-img1.png'/>">
                        </section>
                    </a>
                </li>
                <li>
                    <a href="${menuConfigMap["HLT"]}">
                    	<section class="pro">
	                        <div>
	                            <h3>换轮胎
	                                <p>正品轮胎<span>95折起</span></p>
	                            </h3>
	                        </div>
	                        <img src="<@jci.domain url='/images/homepro/project-img2.png'/>">
                        </section>
                    </a>
                </li>
            </ul>
            
            <#if !menuDispAreaMap?? || !menuDispAreaMap["CBN_DISPLAY_FLG"]?? || menuDispAreaMap["CBN_DISPLAY_FLG"] = '1'>
            <ol>
                <li>
                    <a href="${menuConfigMap["BYTC"]}">
                        <dl>
                            <dt>
                                <h3>冬季保养套餐</h3></dt>
                            <dt><img src="<@jci.domain url='/images/homepro/project-img3.png'/>"><span>套餐价<br><b>￥558</b></dt>
                            <dd> • 嘉实多极护全合成机油</dd>
                            <dd> • 发动机内部清洗</dd>
                            <dd> • 车内空气净化</dd>
                        </dl>
                    </a>
                </li>
                <li>
                    <a href="${menuConfigMap["ZH_KTYH"]}">
                        <section>
                            <div>
                                <h3>空调系统养护<br>车内空气净化</h3>
                                <p><span>￥99<span></p>
                        </div>
                        <img src="<@jci.domain url='/images/homepro/project-img4.png'/>">
                    </section>
                    </a>
                    <ul>
                        <li>
                        <a href="${menuConfigMap["QCPG"]}">
                            <div>
                                <h3>全车抛光</h3>
                                <p>含免费检测和洗车<span>￥398</span></p>
                            </div>
                            <img src="<@jci.domain url='/images/homepro/project-img5.png'/>">
	                    </a>
	                </li>
                <li>
                    <a href="${menuConfigMap["JQDL"]}">
                        <div>
                            <h3>机器打蜡</h3>
                            <p>含洗车<span>￥58</span></p>
                        </div>
                        <img src="<@jci.domain url='/images/homepro/project-img6.png'/>">
                    </a>
                </li>
                </ul>
                </li>
            </ol>
			</#if>
        </nav>
        <!-- new nav begin -->
        
        <!-- new nav begin -->
        <ul class="car-index-nav">
            <li>
                <a href="${menuConfigMap["GHYS"]}" data-lable="服务大全-雨刮片">
                    <div>
                        <span class="bg-wiperchange"><i class="iconfont icon-wiperchange"></i></span>
                        <p>雨刮片</p>
                    </div>
                </a>
            </li>
            <li>
                <a href="${menuConfigMap["GHKTL"]}" data-lable="首页-空调滤">
                    <div>
                        <span class="bg-airconditioningfilter"><i class="iconfont icon-airconditioningfilter"></i></span>
                        <p>空调滤清器</p>
                    </div>
                </a>
            </li>
            <li>
                <a href="${menuConfigMap["GHKL"]}" data-lable="服务大全-空滤">
                    <div>
                        <span class="bg-cabinfilterchange"><i class="iconfont icon-cabinfilterchange"></i></span>
                        <p>空气滤清器</p>
                    </div>
                </a>
            </li>
            <li>
                <a href="${menuConfigMap["GHQYL"]}" data-lable="服务大全-汽油滤">
                    <div>
                        <span class="bg-gasolinefilterchange"><i class="iconfont icon-gasolinefilterchange"></i></span>
                        <p>汽油滤清器</p>
                    </div>
                </a>
            </li>
            <!-- 2 end -->
            <li>
                <a href="${menuConfigMap["GHHHS"]}" data-lable="服务大全-火花塞">
                    <div>
                        <span class="bg-sparkplugchange"><i class="iconfont icon-sparkplugchange"></i></span>
                        <p>火花塞</p>
                    </div>
                </a>
            </li>
            <li>
                <a href="${menuConfigMap["GHFDY"]}" data-lable="服务大全-防冻液">
                    <div>
                        <span class="bg-antifreezeoilchange"><i class="iconfont icon-antifreezeoilchange "></i></span>
                        <p>防冻液</p>
                    </div>
                </a>
            </li>
            <li>
                <a href="${menuConfigMap["GHSCY"]}" data-lable="服务大全-刹车油">
                    <div>
                        <span class="bg-breakfluidchange"><i class="iconfont icon-breakfluidchange"></i></span>
                        <p>刹车油</p>
                    </div>
                </a>
            </li>
            <li>
                <a href="${menuConfigMap["GHCLY"]}" data-lable="服务大全-齿轮油">
                    <div>
                        <span class="bg-gearoilchange">
                        <i class="iconfont icon-gearoilchange"></i>
                        </span>
                        <p>齿轮油</p>
                    </div>
                </a>
            </li>
            <li>
                <a href="${menuConfigMap["RYXT"]}" data-lable="服务大全-燃烧室免拆清洗">
                    <div>
                        <span class="bg-combustorcleaning">
                        <i class="iconfont icon-combustorcleaning"></i>
                        </span>
                        <p>燃烧室
                            <br>免拆清洗</p>
                    </div>
                </a>
            </li>
            <li>
                <a href="${menuConfigMap["GHQS"]}" data-lable="服务大全-前刹车片">
                    <div>
                        <span class="bg-frontbreakchange">
                        <i class="iconfont icon-frontbreakchange"></i>
                        </span>
                        <p>前刹车片</p>
                    </div>
                </a>
            </li>
            <li>
                <a href="${menuConfigMap["GHHS"]}" data-lable="服务大全-后刹车片">
                    <div>
                        <span class="bg-rearbreakchange">
                        <i class="iconfont icon-rearbreakchange"></i>
                        </span>
                        <p>后刹车片</p>
                    </div>
                </a>
            </li>
            <li>
                <a href="${menuConfigMap["*MORE*"]}" data-lable="首页-更多">
                    <div>
                        <span class="bg-more"><i class="iconfont icon-more"></i></span>
                        <p>全部服务</p>
                    </div>
                </a>
            </li>
        </ul>
        <ul class="car-index-footer">
            <li>
                <a href="${menuConfigMap["FWWD"]}" data-lable="首页-服务网点">
                    <div>
                        <i class="iconfont icon-icon"></i>
                        <p>服务网点 </p>
                    </div>
                </a>
            </li>
            <li>
                <a href="${menuConfigMap["BYSC"]}" data-lable="首页-保养手册">
                    <div>
                        <i class="iconfont icon-handbook"></i>
                        <p>保养手册 </p>
                    </div>
                </a>
            </li>
            <li>
                <a href="${menuConfigMap["WDKQ"]}" data-lable="首页-我的卡券">
                    <div>
                        <i class="iconfont icon-ticket"></i>
                        <p>套餐卡</p>
                    </div>
                </a>
            </li>
            <li>
                <a href="${menuConfigMap["WDDD"]}" data-lable="首页-我的订单">
                    <div>
                        <i class="iconfont icon-orders"></i>
                        <p>我的订单</p>
                    </div>
                </a>
            </li>
        </ul>
        
    </section>
    
    <#include "/common/footer.ftl" encoding="UTF-8">
    <script src="<@jci.domain url='/js/jquery.flexslider-min.js'/>"></script>
    <script>
    (function(){
    	var aLoopT = true,
    		aLoopF = false;
    	if ($(".slides li").length > 1) {
            $('.car-index-banner').flexslider({
                animation: "slider",
                slideshowSpeed: 3000,
                directionNav: false,
                animationLoop: aLoopT
            });
        } else{
            $('.car-index-banner').flexslider({
                animation: "slider",
                slideshowSpeed: 3000,
                directionNav: false,
                animationLoop: aLoopF
            });
         }
    })();
    </script>
</body>
</html>