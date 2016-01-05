<!DOCTYPE html>
<html>

<head>
    
    <title>全部规格</title>
    <#include "/common/header.ftl" encoding="UTF-8">
</head>

<body class="tire-norms">
	 <#include "/common/rem.ftl" encoding="UTF-8">
	    <section class="list">
	        <ul id="list">
	        	<!--<li><span>215/55R16</span><span class="qian">前</span><span class="qian">后</span></li>-->
	        	
	        </ul>
	    </section>
	   <#include "/common/footer.ftl" encoding="UTF-8">
	   	 <script src="<@jci.domain url='/js/laytpl.js'/>"></script>
	    <script type="text/html" id="tireTpl">
	     {{# for(var i=0;i<d.length;i++){ }}
	     
	       <li  class='other-list' onclick="tyreSearch('{{d[i]}}')" class="on">
	       	  <span>{{d[i]}}</span>
	       	  {{#if(d[i].tireState==0){ }}
	       	  	<span class="qian">前</span>
	       	  {{# }else if(d[i].tireState==1){ }}
	       	  <span class="qian">后</span>
	       	  {{# }else if(d[i].tireState==2){ }}
	       	  <span class="qian">前</span>
	       	  <span class="qian">后</span>
	       	  {{# } }}
	       </li>
	       
	      {{# } }}
	    </script>  
	    <script>
	    var datalist=${tyreNorms};
	    
	    function tyreSearch(tireStandard) {
			window.location.href = "${contextPath}/tyre/tyreSearch.htm?front=true&rear=true&tireStandard="+encodeURI(encodeURI(tireStandard));
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