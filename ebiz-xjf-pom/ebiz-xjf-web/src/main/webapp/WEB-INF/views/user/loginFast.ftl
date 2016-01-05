<!DOCTYPE html>
<html>

<head>
    <title>短信快捷登录</title>
    <#include "/common/header.ftl" encoding="UTF-8">
</head>

<body>
    <#include "/common/rem.ftl" encoding="UTF-8">
    <section class="car-login">
    	<h2>无密码快捷登录</h2>
        <ul>
            <li>
                <span>手机号码</span>
                <input type="tel" id="mobile" placeholder="请输入手机号码" class="car-text">
                <i class="icon-roundclosefill iconfont"></i>
            </li>
            <li><span>动态密码</span>
                <input type="password" id="captcha" placeholder="输入动态密码" class="car-text">
                <input type="button" value="获取动态密码" class="car-psssword" data-lable="短信快捷登录-获取动态密码">
            </li>
            <li>
                <input type="button" id="login" value="登录" class="car-btn" data-lable="短信快捷登录-登录">
            </li>
            <li><a href="${contextPath}/user/login.htm?targetUrl=${targetUrl}" data-lable="短信快捷登录-车享帐号和密码登录">车享帐号和密码登录</a></li>
        </ul>
        <div>
            <p>登录有困难？请联系客服电话</p>
            <p><i class="icon-call iconfont"></i><a href="tel:${crmTel}" data-lable="短信快捷登录-客服电话">${crmTel}</a></p>
        </div>
    </section>
    <#include "/common/footer.ftl" encoding="UTF-8">
    <script>
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
    // 发送验证码
    $(".car-psssword").on("click", function() {
    	var mobile = $("#mobile").val();
    	// 验证手机号码
    	var isMobile = /^[0-9]{11}$/;
    	if(!isMobile.test(mobile)){
			comAlertObj("亲，请填写正确的手机号！");
		    return;
		}
    	
    	// 发送验证码
    	var url="${contextPath}/user/sendCaptcha.htm";
		var param = {	
			"mobile":mobile
		};
		$.postajax(url, param, function(data){
			if(data.result == $.dataResult.SUCCESS){
				comAlertObj("已发送验证码");
			}
		});
		
		// 重发时间
        var time = 60;
        $(this).addClass('on').val((time--) + '秒后重新发送');
        var setIn = setInterval(function() {
            if (time <= 0) {
                $(".car-psssword").attr({"disabled": false,"data-lable": "短信快捷登录-重新发送动态密码","onclick": "_hmt.push(['_trackEvent', 'href', 'click', '短信快捷登录-重新发送动态密码'])"}).val('重新发送动态密码').removeClass('on');
                clearInterval(setIn);
            } else {
                $(".car-psssword").attr("disabled", true).val((time--) + '秒后重新发送');
            }
        }, 1000);
    });
    // 登录
    $("#login").on("click", function() {
    	var mobile = $("#mobile").val();
    	var captcha = $("#captcha").val();
    	// 验证手机号码
    	var isMob = /^[0-9]{11}$/;
    	if(!isMob.test(mobile)){
			comAlertObj("亲，请填写正确的手机号！");
		    return;
		}
		// 验证验证码
		if(!captcha){
			comAlertObj("亲，请填写验证码！");
		    return;
		}
		// 登录
    	var url="${contextPath}/user/mobileLogin.htm";
		var param = {	
			"mobile":mobile,
			"captcha":captcha
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
