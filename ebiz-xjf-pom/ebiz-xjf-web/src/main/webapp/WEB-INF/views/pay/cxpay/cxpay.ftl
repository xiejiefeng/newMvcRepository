<!DOCTYPE html>
<html>

<head>
    <title>支付</title>
</head>

<body onload="javascript:payFunction();">
	<form id="form1" method="post" style="display:none;">
	<#if payParam?exists>
		<#list payParam?keys as key>
			${key}：<input type="text" id="${key}" name="${key}" size="30" value="${payParam[key]}"/><br/>
		</#list>
	</#if>
	</form>
</body>
<script language="javascript" type="text/javascript">

function payFunction(){
	if(document.getElementById("openId") == null){
		var form1 = document.getElementById("form1");
		form1.action = "${url}";
		form1.submit();
	}else{
		window.location.href = "${url}?sign=" 
			+ encodeURIComponent(document.getElementById("sign").value) 
			+ "&returnUrl=" + document.getElementById("returnUrl").value 
			+ "&mdseName=" + document.getElementById("mdseName").value 
			+ "&partner=" + document.getElementById("partner").value 
			+ "&notifyUrl=" + document.getElementById("notifyUrl").value 
			+ "&timeout=" + document.getElementById("timeout").value 
			+ "&txnAmount=" + document.getElementById("txnAmount").value 
			+ "&orderId=" + document.getElementById("orderId").value 
			+ "&openId=" + encodeURIComponent(document.getElementById("openId").value) 
			+ "&body=" + document.getElementById("body").value ;
	}
}

</script>
</html>
