<!DOCTYPE html>
<html>

<head>
    
    <title>轮胎规格</title>
    <#include "/common/header.ftl" encoding="UTF-8">
</head>

<body class="tire-norms">
	<#include "/common/rem.ftl" encoding="UTF-8">
	<style>
		 .car-style-choose {
            background: #fff;
            overflow: hidden;
            width: 100%;
            position: relative;
            border-bottom: .1rem solid #e7e7e7;
        }
        
        .car-style-choose a,
        .car-style-choose a input {
            padding: 0;
            display: block;
            width: 100%;
            height: 4.3rem;
            color: #b2b2b2;
            text-indent: 10px;
        }
        
        .car-style-choose a img {
            display: inline-block;
            width: 2.4rem;
            height: 2.4rem;
            margin: 1rem 0 0 1rem;
            position: absolute;
            top: 50%;
            margin-top: -1.2rem;
        }
        
        .car-style-choose s {
            padding-left: 4.25rem;
            color: #333;
            font-size: 1.2rem;
            display: inline-block;
            position: absolute;
            top: 50%;
            -webkit-transform: translate(0, -50%);
            -moz-transform: translate(0, -50%);
            transform: translate(0, -50%);
            width: 70%;
        }
        
        .car-style-choose s b {
            color: #666;
        }
        
        .car-style-choose a {
            color: #b2b2b2;
        }
        
        .car-style-choose a span {
            position: absolute;
            height: 4.3rem;
            line-height: 4.3rem;
            color: #2d2d2d;
            right: 1rem;
            top: 0;
            color: #666;
            font-size: 1.2rem;
        }
        
        .car-style-choose a span i {
            color: #c6c6cc;
            padding-left: 0.5rem;
        }
        
        .car-style-choose a input {
            display: block;
            float: left;
            width: 22rem;
            overflow: hidden;
            text-overflow: ellipsis;
            left: 0;
            color: #2d2d2d;
        }
        .list{margin-top: 1rem;border-top: 1px solid #e7e7e7;}
	</style>
     <#include "/common/rem.ftl" encoding="UTF-8">
    	<div class="car-style-choose">
            <a href="${contextPath}/tyre/toSelectCar.htm?products=${productCode}&singleCode=${singleCode}">
                <img src="${carInfo.logoUrl}" onerror="errorImg(this)" />
                <s id="carName" class="text-overflow">
                    <#if carInfo!=null && carInfo.carName!=null>
                        ${carInfo.carName}
                        <#else>
                            <b>请选择预约车辆</b>
                    </#if>
                </s>
                <span>更换<i class="iconfont icon-arrows"></i></span>
            </a>
        </div>
        <input type="hidden" name="carLevel" id="carLevel" value="${carInfo.carLevel}" />
        <input type="hidden" name="carId" id="carId" value="${carInfo.carId}" />
	    <section class="list">
	        <ul id="list">
	        	<!--<li><span>215/55R16</span><span class="qian">前</span><span class="qian">后</span></li>-->
	        	
	        </ul>
	    </section>
	    <a href="${contextPath}/tyre/allNorms.htm">
		    <section class="other">
		                        全部规格<i class="iconfont icon-arrows"></i>
		    </section>
	    </a>
	    <section class="tips">轮胎胎侧可以查看轮胎型号</section>
	    
	    <section style="border-top: 1px solid #e7e7e7;">
	    <img src="<@jci.domain url='/images/tireTips.jpg'/>">
	    </section>
	    <#include "/common/footer.ftl" encoding="UTF-8">
	   	<script src="<@jci.domain url='/js/laytpl.js'/>"></script>
	    <script type="text/html" id="tireTpl">
	    	
	     {{# for(var i=0;i<d.length;i++){ }}
	      
	       <li onclick="tyreSearch('{{d[i].tireStandard}}','{{d[i].front}}','{{d[i].rear}}')" class="on">
	       	  <span>{{d[i].tireStandard}}</span>
	       	  {{#if(d[i].front==true&&d[i].rear==false){ }}
	       	  	<span class="qian">前</span>
	       	  {{# }else if(d[i].front==false&&d[i].rear==true){ }}
	       	  <span class="qian">后</span>
	       	  {{# }else if(d[i].front==true&&d[i].rear==true){ }}
	       	  
	       	  {{# } }}
	       </li>
	      
	      {{# } }}
	    </script>  
	    <script>
	    var datalist=${tyreList};
	    function tyreSearch(tireStandard,front,rear) {
			window.location.href = "${contextPath}/tyre/tyreSearch.htm?front="+front+"&rear="+rear+"&tireStandard="+encodeURI(encodeURI(tireStandard));
		}
	    function init() {
	        var tireTpl = document.getElementById('tireTpl').innerHTML;
	        laytpl(tireTpl).render(datalist, function(html) {
	            document.getElementById('list').innerHTML = html;
	        });
	    }
	    init();
	   
	     </script>
   
</body>

</html>