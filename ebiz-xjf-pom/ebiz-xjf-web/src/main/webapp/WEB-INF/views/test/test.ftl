<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1, minimum-scale=1, user-scalable=no">
<title>设定OpenId</title>
<#include "/common/header.ftl" encoding="UTF-8">
<link rel="stylesheet" type="text/css" href="<@jci.domain url='/css/cookie/cookie.css'/>">
		
</head>
<body>
<div class="line"></div>

<div class="head" style="width:120px">
	<a href="javascript:test1()" class="btn">测试1</a>
</div>

<div class="clear"></div>

<div class="head" style="width:120px">
	<a href="javascript:resetRedis('sysReference')" class="btn">重置系统参数</a>
</div>

<div class="head" style="width:120px">
	<a href="javascript:resetRedis('reference')" class="btn">重置业务参数</a>
</div>

<div class="clear"></div>
<footer></footer>
<#include "/common/footer.ftl" encoding="UTF-8">
<script type="text/javascript">
function test1() {
	var url=$.context+"/test2/test.htm";
	$.ajax(url, {
		dataType: "json",
	    type: 'post',
	    async:false,
	    contentType: "application/x-www-form-urlencoded",
	    data: {"inputDate" : "2016-10-08你好"}, 
	    success: function(data){
	    	alert(data.msg + "       " + data.obj);
	    }
	});
}


</script>
</body>
</html>