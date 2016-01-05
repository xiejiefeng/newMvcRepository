$(function(){
	if(sessionStorage.getItem("name")){							// 如果用户名已经修改成功
		$("#wxName").val(sessionStorage.getItem("name"));
	}
	
	(function(){
		var arrText = ["修改","确定"];
		var single = (function(){
			return {
				init:function(){
					this.btn = $("#wxNamesBtn");					// 按钮
					this.input = $("#wxName");						// input 表单
					this.originData = $("#wxName").val();			// 原始值
					this.mask = $("#mask")
					this.alert1 = $("#popupAlert1");				// 格式不对弹窗
					this.alert2 = $("#popupAlert2");				// 是否保存弹窗
					this.clickFn();
				},
				clickFn:function(){
					var _this = this;
					this.btn.on("click",function(){
						_this.emptyInput();							// 清空并可输入
						_this.btn.val(arrText[1]);	
						_this.input.one("blur",function(){
							if( /^\s*$/.test($(this).val()) ){
								_this.recover();						//返回原始状态
							}else{
								var flag = _this.rule();				
								if(flag){								// 格式正确									
									_this.show(_this.alert2,true);		// false 表示 格式错误弹窗
								}else{									// 格式不正确
									_this.show(_this.alert1,false);		// true  表示 保存弹窗
								}
							}
						});
						
					});
					
				},
				show:function(obj,flag){
					var _this = this;
					this.mask.css("display","block");
					obj.css("display","block");
					obj.find(".cancel").on("click",function(){
						_this.recover();						   // 不保存按钮   保留原称呼
						_this.hide(obj);
					});
					obj.find(".confirm").on("click",function(){
						if(flag){										// 保存
							 var url=$.context+"/personalInfo/doEditUserInfo.htm";
							 $.postajax(url,{"custName":_this.input.val()},function(data){
			                	if(data.result==$.dataResult.SUCCESS){
			                    	comAlertObj(data.msg);
			                    	window.location.reload();
			                     }
			                });
						}else{
							_this.emptyInput()						   // 重新填写
							_this.btn.trigger("click");				   // 重新绑定blur
						}	
						_this.hide(obj);
					});
				},
				hide:function(obj){
					this.mask.css("display","none");
					obj.css("display","none");
				},
				emptyInput:function(){
					this.input.removeAttr("readonly").val("").focus();// 清空并可输入
					this.btn.text(arrText[1]);
				},
				recover:function(){
					this.input.val(this.originData).attr("readonly","readonly");				// input 返回原始值
					this.btn.text(arrText[0]);
				},
				rule:function(){
					var count=0,flag=true,arr=this.input.val(),len=arr.length;
					for(var i=0;i<len;i++){
						if(count>20){return false;}
						if(/^[\u4e00-\u9fa5]$/.test(arr[i])){
							count+=2;
						}else if(/^[a-zA-Z]$/.test(arr[i])){
							count+=1;
						}else{
							return false;
						}
					} 
					if(count>20){
						return false;
					}else{
						return true;
					}
				}
			}
		})();
		single.init();
	})();
})



