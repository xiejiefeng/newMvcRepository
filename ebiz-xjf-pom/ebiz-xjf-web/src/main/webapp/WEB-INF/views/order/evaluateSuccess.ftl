<!DOCTYPE html>
<html>
<head>
<title>订单评价</title>
<#include "/common/header.ftl" encoding="UTF-8">
<link rel="stylesheet" type="text/css" href="<@jci.domain url='/css/project.css'/>">
</head>
<body>
<section class="evaServ evaluateSuc">
    <div class="evalSucIcon"><img src="<@jci.domain url='/images/evalSucIcon.jpg'/>" width="50px" height="49px"/></div>
    <p>评价提交成功！</p>
    <p>感谢您帮助改进我们的服务</p>
</section>
<button class="closeEval" id="closeEval">返回订单明细</button>
<input type="hidden" id="orderId" value="${orderId}" />
<!-----------无预约信息
<footer>本页面由A车站提供安全保障,请放心使用</footer>----------->
<#include "/common/footer.ftl" encoding="UTF-8">
<script type="text/javascript">
$(function(){
	$("#closeEval").on('click', function() {
		window.location.href=$.context+"/order/detail_order_"+$("#orderId").val()+".htm";
	})
});
</script>
</body>
</html>