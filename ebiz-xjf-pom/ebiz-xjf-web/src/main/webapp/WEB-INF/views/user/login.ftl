<!DOCTYPE html>
<html>

<head>
    <title>车享用户登录</title>
    <#include "/common/header.ftl" encoding="UTF-8">
</head>

<body>
    <#include "/common/rem.ftl" encoding="UTF-8">
    <section class="car-login">
    	<h2>车享用户登录</h2>
        <ul>
            <li>
                <span>账号</span>
                <input type="text" id="userName" placeholder="请输入账号" class="car-text"> 
                <i class="icon-roundclosefill iconfont"></i>
            </li>
            <li>
                <span>密码</span>
                <input type="password" id="password" placeholder="请输入密码" class="car-text">
                <i class="icon-roundclosefill iconfont"></i>
            </li>
            <li>
                <input type="button" id="login" value="登录" class="car-btn" data-lable="车享用户登录-登录">
            </li>
            <li><a href="${contextPath}/user/login-fast.htm?targetUrl=${targetUrl}" data-lable="车享用户登录-忘记密码？通过手机登录">忘记密码？通过手机登录</a></li>
        </ul>
        <div>
            <p>登录有困难？请联系客服电话</p>
            <p><i class="icon-call iconfont"></i><a href="tel:${crmTel}" data-lable="车享用户登录-客服电话">${crmTel}</a></p>
        </div>
    </section>
    <#include "/common/footer.ftl" encoding="UTF-8">
    <script type="text/javascript">
    $(".car-text").on("input propertychange", function() {
        if ($(this).val().length > 0) {
            $(this).parent().find('i').fadeIn(200);
        } else {
            $(this).parent().find('i').fadeOut(200);
        }
    });
    $(".icon-roundclosefill").on("click", function(){
        $(this).parent().find(".car-text").val("");
        $(this).hide();
    });
    // 登录
    $("#login").on("click", function() {
    	var userName = $("#userName").val();
    	var password = $("#password").val();
    	// 验证用户名
    	if(!userName){
			comAlertObj("亲，请填写用户名！");
		    return;
		}
		// 验证密码
		if(!password){
			comAlertObj("亲，请填写密码！");
		    return;
		}
		// 登录
    	var url="${contextPath}/user/passwdLogin.htm";
		var param = {	
			"userName":userName,
			"password":password
		};
		$.postajax(url, param, function(data){
			if(data.result == $.dataResult.SUCCESS){
				window.location.href=$.context+'${targetUrl}';
			}else{
				comAlertObj(data.msg);
			}
		});
    });
    </script>
</body>

</html>
