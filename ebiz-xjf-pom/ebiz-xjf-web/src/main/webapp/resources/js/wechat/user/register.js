$(function(){
	;(function(obj,errorObj){
		var userName = obj.find(".username"),
			yzm = obj.find("span.yzm"),
			yzmInput = obj.find(".yzm-input"),
			pwd = obj.find(".pwd"),
			flag = true,timer=null,count=60,yzmAnswer="111111",telFlag=false,yzmFlag=false,pwdFlag=false;
		// 手机号验证
		userName.blur(function(){		
			if(/^1[3|4|5|8][0-9]\d{8}$/.test( $(this).val() )){
				yzm.addClass("yzmEnable");						// 允许发送验证flag
				errorObj.html("");
				telFlag=true;
			}else{
				errorObj.html("请输入正确的手机号");
				yzm.removeClass("yzmEnable");
				yzmInput.attr("disabled","disabled");
				$(this).val("").focus();
				telFlag = false;
			}
		});
//		obj.on("click",".yzmEnable",function(event){
//			if(flag){
//				yzmInput.removeAttr("disabled").removeClass("yzmbg");
//				$(this).addClass("enablebg");
//				timer = setInterval(function(){
//					yzm.html("再次获取"+(--count)+"秒");
//					if(count==0){
//						yzm.removeClass("enablebg").html("获取验证码");
//						count=60;
//						flag = true;
//						clearInterval(timer);
//					}
//				},1000);
//			}
//			flag = false;
//		});
		// 手机号验证

		// 短信验证码
//		yzmInput.blur(function(){
//			var value = $(this).val();
//			if( /^\s*$/.test(value) ){
//				errorObj.html("请输入验证码");
//				$(this).val("").focus();
//			}else if(yzmAnswer!=value){
//				errorObj.html("验证码错误，请重新输入!");
//				$(this).val("").focus();
//			}else{
//				errorObj.html("");
//				yzmFlag = true;
//			}
//		});
		// 短信验证码

		// 密码验证
		pwd.blur(function(){
			var value = $(this).val();
			if( /^\s*$/.test(value) ){
				errorObj.html("请输入密码");
				$(this).val("").focus();
			}else if(value.length<4){
				errorObj.html("密码设置最少4个字符！");
				$(this).val("").focus();
			}else{
				errorObj.html("");
				pwdFlag = true;
			}
		}).focus(function(){
			this.style.imeMode='disabled';
		});
		// 密码验证

		obj.submit(function(){
			if(!telFlag){
				userName.trigger("blur");
				return false;
			}
//			if(! yzmFlag){
//				yzmInput.trigger("blur");
//				return false;	
//			}
			if(! pwdFlag){
				pwd.trigger("blur");
				return false;	
			}
			errorObj.css("display","none");
			alert("register success");
//			window.location.href = "homeindex.html";
//			$("#captcha").val()
			var reqData={userName:userName.val(),password:pwd.val(),captcha:123123};
		     var url=$.context+"/user/register.htm";
		     console.log(url);
		     $.postajax(url,reqData,function(data){
		    	  if(data.result==$.dataResult.SUCCESS){
		    		  errorObj.html(data.msg);
		    		  window.location.href=$.context+"/user/registersuccess.htm";
		    	  }else{	    		 
		    		  errorObj.html(data.msg);
		    	  }
		    	  returnFalse();
		     });
			return false;
		});
	})($("#registerForm"),$("#span-error"));	
});