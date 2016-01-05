<!DOCTYPE html>
<html>
<head>
<title>空调系统养护</title>
<script type="text/javascript" src="<@jci.domain url='/js/jquery.lazyload.js'/>"></script>
</head>
<body >
    <#include "/common/rem.ftl" encoding="UTF-8">
    <section class="car-acticity">
        <img src="<@jci.domain url='/images/load-activity.gif'/>" data-original="<@jci.domain url='/images/activity/activity2-01.jpg'/>">
        <img src="<@jci.domain url='/images/load-activity.gif'/>" data-original="<@jci.domain url='/images/activity/activity2-02.jpg'/>">
        <h2>服务包含</h2>
        <ul>
            <li>空调系统养护<span>1次</span></li>
            <li>车内空气净化 <span>1次</span></li>
        </ul>
        <h2>服务详情</h2>
        <div class="info">
            <h3>空调系统养护服务</h3>
            <p>使用通过德国权威检测机构检测的产品，<br>特有的空调系统清洁设备以8个科学有效的喷头喷射的<br>水柱及带有足够压力的气体同时喷射，<br>能有效冲洗蒸发器各个角落的污垢和灰尘，<br>有效恢复空调系统冷热交换，<br>并改善空调制冷效果。</p>
        </div>
        <img src="<@jci.domain url='/images/load-activity.gif'/>" data-original="<@jci.domain url='/images/activity/activity2-03.jpg'/>">
        <div class="info">
            <h3>车内空气净化服务</h3>
            <p>专业操作人员使用专业的空气净化设备，<br>专业的空气治理技术，三力齐发，<br>短短20分钟达到净化空气，<br>去除异味，分解甲醛等物质的目的，使车内的空气清新、<br>让您健康舒适。</p>
        </div>
        <img src="<@jci.domain url='/images/load-activity.gif'/>" data-original="<@jci.domain url='/images/activity/activity2-04.jpg'/>">
        <img src="<@jci.domain url='/images/load-activity.gif'/>" data-original="<@jci.domain url='/images/activity/activity-common-01.jpg'/>">
        <img src="<@jci.domain url='/images/load-activity.gif'/>" data-original="<@jci.domain url='/images/activity/activity-common-02.jpg'/>" class="last-img">
    </section>
    <script>
        $("img").lazyload({
            effect: "fadeIn",
            failure_limit: 10
        });
    </script>
</body>
</html>