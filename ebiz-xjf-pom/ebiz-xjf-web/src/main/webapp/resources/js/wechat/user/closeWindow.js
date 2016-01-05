var confirm = document.getElementById("confirm");
confirm.addEventListener("click",function(e){
	WeixinJSBridge.invoke('closeWindow',{},function(res){});
	e.preventDefault();
},false);