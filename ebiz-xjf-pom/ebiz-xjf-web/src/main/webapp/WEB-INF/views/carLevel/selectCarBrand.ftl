<!DOCTYPE html>
<html>
<head>
    <title>品牌选择</title>
    <#include "/common/header.ftl" encoding="UTF-8">
    <style type="text/css">
    html,
    body,
    body div,
    span,
    object,
    iframe,
    h1,
    h2,
    h3,
    h4,
    h5,
    h6,
    p,
    blockquote,
    pre,
    abbr,
    address,
    cite,
    code,
    del,
    dfn,
    em,
    img,
    ins,
    kbd,
    q,
    samp,
    small,
    strong,
    sub,
    sup,
    var,
    b,
    i,
    dl,
    dt,
    dd,
    ol,
    ul,
    li,
    fieldset,
    form,
    label,
    legend,
    table,
    caption,
    tbody,
    tfoot,
    thead,
    tr,
    th,
    td,
    article,
    aside,
    figure,
    footer,
    header,
    menu,
    nav,
    section,
    time,
    mark,
    audio,
    video,
    details,
    summary {
        margin: 0;
        padding: 0;
        border: 0;
        font-size: 100%;
        font-weight: normal;
        vertical-align: baseline;
        background: transparent;
    }
    
    article,
    aside,
    figure,
    footer,
    header,
    nav,
    section,
    details,
    summary {
        display: block;
    }
    /* Handle box-sizing while better addressing child elements:
			   http://css-tricks.com/inheriting-box-sizing-probably-slightly-better-best-practice/ */
    
    html {
        box-sizing: border-box;
    }
    
    ul,
    ol {
        list-style: none;
    }
    
    header div {
        position: fixed;
        height: 10.65rem;
        width: 100%;
        background-color: white;
        top: 0;
        font-family: "微软雅黑";
        z-index: 100;
    }
    .zimu{
        border-bottom: .2rem solid #17a3eb;
        overflow: hidden;
        width:110%;
        background:#fff;
    }
    .zimu li {
        width: 3.6rem;
        height: 3.6rem;
        line-height: 3.6rem;
        font-size: 1.4rem;
        text-align: center;
        border-bottom: 1px solid #efeff4;
        border-right: 1px solid #efeff4;
        float: left;
        color: #17a3eb;
        -webkit-box-sizing: border-box;
        -moz-box-sizing: border-box;
        -ms-box-sizing: border-box;
        box-sizing: border-box;
    }
    
    .zimu li:nth-child(n+19) {
        border-bottom: none;
    }
    
    .click {
        width: 8vw;
        height: 0;
        background-color: #17a3eb;
        font-size: 1em;
        color: white!important;
        text-align: center;
    }
    
    .pp {
        background-color: white;
    }
    
    .pp p {
        height: 4rem;
        line-height: 4rem;
        border-bottom: .1rem solid #e7e7e7;
        background-color: #efeff4;
        padding-left: 1rem;
        font-size: 1.4rem;
        color: #6e6e6e;
    }
    
    #bb {
        transition: top .3s;
        -webkit-transition: top .3s;
        -moz-transition: top .3s;
    }
    
    .wd {
        top: -10.9rem;
    }
    
    .mark {
        width: 100%;
        border-top: .2rem solid #17a3eb;
        transition: opacity 2s;
        -webkit-transition: opacity 2s;
        -moz-transition: opacity 2s;
        opacity: 0;
    }
    
    .mark span {
        position: absolute;
        top: 0;
        left: 1rem;
        width: 3.5rem;
        height: 3rem;
        line-height: 3rem;
        background-color: #17a3eb;
        color: #fff;
    }
    
    .op {
        opacity: 1;
    }
    
    .aa {
        margin-top: 0px;
    }
    
    .container ul {
        padding: 1rem 1.5rem;
        font-size: 0;
        background: #fff;
        border-bottom: .1rem solid #e7e7e7;
        overflow: hidden;
    }
    
    .container ul li {
        width: 7.25rem;
        text-align: center;
        float: left;
        font-size: 1.2rem;
    }
    
    .container ul li section {
        width: 7.25rem;
        height: 4.2rem;
        display: -webkit-box;
        display: -moz-box;
        display: -ms-box;
        -webkit-box-pack: center;
        -moz-box-pack: center;
        -ms-box-pack: center;
        box-pack: center;
        -webkit-box-align: center;
        -moz-box-align: center;
        -ms-box-align: center;
        box-align: center;
    }
    
    .container ul li section img {
        -webkit-box-pack: center;
        -moz-box-pack: center;
        -ms-box-pack: center;
        box-pack: center;
        -webkit-box-align: center;
        -moz-box-align: center;
        -ms-box-align: center;
        box-align: center;
        width:4rem;
        height:4rem;
    }
    .container ul li a{
        text-decoration: none;
        color:#707070;
    }
    .container ul li span {
        margin-top: .8rem;
        display: block;
    }
    .icon-top:before{color:#fff;}
    </style>
</head>

<body>
	<#include "/common/rem.ftl" encoding="UTF-8">
    <header>
        <div id="num" class="click mark"><span>A</span></div>
        <div id="bb">
            <ul class="zimu" id="zimu">
            <#if keys??>
				<#list keys as key>
				<li>${key}</li>
				</#list>
		    </#if>
            </ul>
        </div>
    </header>
    <div id="container" class="container">
        <div id="cc" style="height: 10.65rem;"></div>
        <#if keys??>
			<#list keys as key>
				<#assign brandList=brandMap[key] >
				<div id="${key}" class="pp">
		            <p>${key}</p>
		            
		            <#list brandList as brand>
		            	<#if brand_index % 4 = 0>
		            	<ul>
		            	</#if>
		            	
		            	<li>
		                    <a href="${contextPath}/selectCar/toSelectCarVese.htm?assetId=${assetId}&brandId=${brand.brandId}">
		                    <section><img data-original="${brand.logoUrl}" src="<@jci.domain url='/images/load.gif'/>" alt="logo" onerror="errorImg(this)"></section>
		                    <span>${idx}${brand.brandName}</span>
		                    </a>
		                </li>
		                
		                <#if brand_index % 4 = 3>
		            	</ul>
		            	</#if>
		            </#list>
		        </div>
		    </#list>
	    </#if>
        </div>
    </div>
</body>
<#include "/common/footer.ftl" encoding="UTF-8">
<script type="text/javascript" src="<@jci.domain url='/js/jquery.lazyload.js'/>"></script>
<script type="text/javascript">
var chi = $("#zimu li");
var numId = 0;
var positionTop = [];
$(function() {
    FastClick.attach(document.body);
});
function init() {
    //			document.addEventListener("touchstart",function(){
    //				 event.preventDefault();      
    //			})
    $('html,body').scrollTop(0);
    $("#num").on("click", function() {
        $('#bb').removeClass("wd");
        $('#cc').removeClass("wd");
    })
    $(chi[numId]).addClass("click");
    for (var i = 0; i < chi.length; i++) {
        $(chi[i]).attr("dataId", i)
        if($("#" + $(chi[i]).text()).length!=0) {
        positionTop.push($("#" + $(chi[i]).text()).offset().top);
        chi[i].addEventListener("click", function() {
            if (numId != $(this).attr("dataId")) {
                $(chi[numId]).removeClass("click");
                $(this).addClass("click");
                numId = $(this).attr("dataId");
                $("#num span").text($(this).text());
                var top = $("#" + $(this).text()).offset().top - $(window).width() * 0.3333;
 				$('html,body').scrollTop(top);

            }
        });
        }
    }
}
init();
var ttp = 0;
document.getElementById("container").addEventListener("touchstart", function() {})
document.getElementById("container").addEventListener("touchmove", function() {
    var t = $(window).scrollTop() + $(window).width() * 0.3333;
    var k = getK(t);
    if ($(window).scrollTop() == 10) {
        k = 0;
    }
    if (numId != $(chi[k]).attr("dataId")) {
        $(chi[numId]).removeClass("click");
        $(chi[k]).addClass("click");
        $("#num span").text($(chi[k]).text());
        numId = $(chi[k]).attr("dataId");
    }
})

function getK(t) {
    for (var k = 0; k <= positionTop.length; k++) {
        if ((k + 1) < positionTop.length) {
            if (positionTop[k] - $(window).height() * 0.30 < t && positionTop[k + 1] - $(window).height() * 0.30 > t) {
                return k;
            }
        } else {
            return positionTop.length - 1;
        }
    }
}
var cb = 0;
window.onscroll = function(e) {
    var e = e || window.event;
    var scrolltop = document.documentElement.scrollTop || document.body.scrollTop;
    var box = document.getElementById('A');
    if (scrolltop > $(window).width() * 0.3333 && scrolltop - cb > 0) {
        $('#bb').addClass("wd");
        $('#cc').addClass("wd");
        $('#num').addClass("op");
    } else {
        $('#bb').removeClass("wd");
        $('#cc').removeClass("wd");
        $('#num').removeClass("op");
    }
    cb = scrolltop;
}


//图片延时加载
$("img").lazyload({
	effect : "fadeIn"
});

function defaultImg(){
	var img = $("#container img"),
		gifSrc = "<@jci.domain url='/images/load.gif'/>";
	for (var i = 0; i < img.length; i++) {
        if ($(img[i]).attr("src") == gifSrc) {
        	$(img[i]).attr("src", $.resourcesDomain+'/images/car-brand-defalut.png')
        }
    };
}

setTimeout("defaultImg()", 8000);
</script>

</html>