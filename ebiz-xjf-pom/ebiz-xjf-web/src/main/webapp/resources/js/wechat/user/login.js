/**登录*/
$(function(){
	(function(obj,mask,alertObj){
		// obj=>form.id; mask=>遮罩层; alertObj=>弹出层;
		var userName = obj.find(".username"),
			pwd = obj.find(".pwd"),
			urltarget = obj.find("#urltarget"),
			objArr=mask.add(alertObj),
			timer=null,
			fadeTime=3000;

		obj.submit(function(){				
			if(	/^\s*$/.test(userName.val())  ){		// 用户名为空
				alertObj.html("请输入账户名");
				fadeInFn(userName);
				return false;
			}else if( /^\s*$/.test(pwd.val()) ){		// 密码为空
				alertObj.html("请输入密码!");
				fadeInFn(pwd);
				return false;
			}
 
		     var reqData={userName:userName.val(),password:pwd.val()};
		     var url=$.context+"/user/loginForm.htm";
		     console.log(url);
		     var result=JSON.stringify(reqData);
		     $.postjson(url,result,function(data){
		    	if(data.result==$.dataResult.SUCCESS){
	    			fadeInFn();
	    		  	alertObj.html(data.msg);
		    		if( obj.data("data-net")=="true"){
						$("#netLogin").css("display","none");
						$("#reserve0").css("display","block");
					}else{
//						if(data.returnUrl!=null){
						if(urltarget.val()){
							window.location.href=$.context+urltarget.val();
						}else{
							window.location.href=$.context+"/user/loginsuccess.htm";
						}
					}			
	    		}else{	
//	    			alert("登录失败,用户名密码错误");
	    		    alertObj.html(data.msg);
		 	        fadeInFn();
//		 	        window.location.href=$.context+"/user/loginfail.htm";
	    	  	}
	    	  	returnFalse();
		     });
			return false;
		});	
		function fadeInFn(obj){
			objArr.fadeIn(1000);
			fadeOutFn(obj);
		}
		function fadeOutFn(obj){
			timer = setTimeout(function(){
				objArr.fadeOut(1000,function(){
					userName[0].focus();

				});
				clearTimeout(timer);
			},fadeTime);
		}
	})($("#loginForm"),$("#mask"),$("#alert"));
});