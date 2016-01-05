<!DOCTYPE html>
<html>

<head>
    <title>全部服务</title>
    <#include "/common/header.ftl" encoding="UTF-8">
    <link rel="stylesheet" href="<@jci.domain url='/css/flexslider.css'/>">
</head>

<body >
    <#include "/common/rem.ftl" encoding="UTF-8">
    <section class="car-index">
        <ul class="car-index-nav more">
            <li>
                <a href="${menuConfigMap["YYXBY"]}" data-lable="服务大全-小保养">
                    <div>
                        <span class="bg-baoyang">
                        <i class="iconfont icon-baoyang"></i>
                        </span>
                        <p>小保养</p>
                    </div>
                </a>
            </li>
            <li>
                <a href="${menuConfigMap["HLT"]}" data-lable="服务大全-轮胎">
                    <div>
                        <span class="bg-luntai">
                        <i class="iconfont icon-luntai"></i>
                        </span>
                        <p>轮胎</p>
                    </div>
                </a>
            </li>
            <li>
                <a href="${menuConfigMap["FDJQX"]}" data-lable="服务大全-发动机清洗与养护">
                    <div>
                        <span class="bg-enginemaintenance">
                        <i class="iconfont icon-enginemaintenance"></i>
                        </span>
                        <p>发动机清洗
                            <br>与养护</p>
                    </div>
                </a>
            </li>
            <li>
                <a href="${menuConfigMap["KTYH"]}" data-lable="服务大全-空调系统养护">
                    <div>
                        <span class="bg-acmaintencne">
                        <i class="iconfont icon-acmaintencne "></i>
                        </span>
                        <p>空调系统
                            <br>养护</p>
                    </div>
                </a>
            </li>
            <li>
                <a href="${menuConfigMap["GHYS"]}" data-lable="服务大全-雨刮片">
                    <div>
                        <span class="bg-wiperchange">
                        <i class="iconfont icon-wiperchange"></i>
                        </span>
                        <p>雨刮片</p>
                    </div>
                </a>
            </li>
            <!-- 1 end -->
            <li>
                <a href="${menuConfigMap["GHKTL"]}" data-lable="首页-空调滤">
                    <div>
                        <span class="bg-airconditioningfilter">
                        <i class="iconfont icon-airconditioningfilter "></i>
                        </span>
                        <p>空调滤清器</p>
                    </div>
                </a>
            </li>
            <li>
                <a href="${menuConfigMap["GHKL"]}" data-lable="服务大全-空滤">
                    <div>
                        <span class="bg-cabinfilterchange">
                        <i class="iconfont icon-cabinfilterchange "></i>
                        </span>
                        <p>空气滤清器</p>
                    </div>
                </a>
            </li>
            <li>
                <a href="${menuConfigMap["GHQYL"]}" data-lable="服务大全-汽油滤">
                    <div>
                        <span class="bg-gasolinefilterchange">
                        <i class="iconfont icon-gasolinefilterchange"></i>
                        </span>
                        <p>汽油滤清器</p>
                    </div>
                </a>
            </li>
            <li>
                <a href="${menuConfigMap["GHHHS"]}" data-lable="服务大全-火花塞">
                    <div>
                        <span class="bg-sparkplugchange">
                        <i class="iconfont icon-sparkplugchange"></i>
                        </span>
                        <p>火花塞</p>
                    </div>
                </a>
            </li>
            <!-- 2 end -->
            <li>
                <a href="${menuConfigMap["GHFDY"]}" data-lable="服务大全-防冻液">
                    <div>
                        <span class="bg-antifreezeoilchange">
                        <i class="iconfont icon-antifreezeoilchange "></i>
                        </span>
                        <p>防冻液</p>
                    </div>
                </a>
            </li>
            <li>
                <a href="${menuConfigMap["GHSCY"]}" data-lable="服务大全-刹车油">
                    <div>
                        <span class="bg-breakfluidchange">
                        <i class="iconfont icon-breakfluidchange"></i>
                        </span>
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
            <!-- 3 end -->
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
            <li></li>
        </ul>
    </section>
    <img src="<@jci.domain url='/images/index-bg.png'/>" class="car-index-bg"/>
    <#include "/common/footer.ftl" encoding="UTF-8">
</body>
</html>
