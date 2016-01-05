$(function(){
	var global = {};
	global.spanDataArr = {};
	var iosDevice = (function(){			// 判断是iso版本
		var u = navigator.userAgent;
		if( u.indexOf('iPhone') > -1 ){
			return true;
		}else{
			return false;
		}
	})();	
	
	if(getSessionItem("license")){							//车牌号保存
		$("#plates").val(getSessionItem("license"));
	}
	
	if(/^\s*$/.test($("#newTel").val())){
		$("#newTel").removeAttr("readonly");
	}else{
		$("#newTel").attr("readonly","readonly");
	}
	
	;(function(obj,popupObj){	
		// 选择车型按钮
		var flag = true,					// flag=true 表示已绑定
			selectCarNum = 2,				// selectCarNum 表示已经选择了几辆车
			oLi = popupObj.find("li"),objI = popupObj.find("li i"),txt=null,
			objPara = popupObj.find("p"),
			btnObj = popupObj.find(".select-car-unbtn");
		obj.click(function(){			// 更换车型按钮触发事件 
			//if(flag){
			var plates = $("#plates").val();
			oLi.each(function(){
				if( $(this).attr("data-plates")==plates){
					oLi.removeClass("selected");
					$(this).addClass("selected");
					return true;
				}
			});
			popupObj.animate({"left":0},400);
			//}else{							// 未绑定则跳转到品牌选择页
				//window.location.href ==$.context+"/selectCar/toSelectCar.htm";
			//}
		});
		objI.click(function(){									// 删除一个车型数据
			oLi = popupObj.find("li");
			// if(oLi.length==1){return false;}					// 最后一个可以删除
			var _this = $(this);
			var alertMask = $("#popup").add("#mask");
			alertMask.css("display","block");
			$("#popup").on("click",".confirm",function(){
				_this.parent().remove();
				btnObj.addClass("select-car-btn"); 
				objPara.css("display","none");
				alertMask.css("display","none");
				return false;
			});
			$("#popup").on("click",".cancel",function(){
				alertMask.css("display","none");
				return false;
			});
			return false;
		});
		popupObj.on("click",".select-car-btn",function(){		// 添加车辆按钮
			window.location.href =$.context+"/selectCar/toSelectCar.htm";
		});
		
		oLi.click(function(event){
			var olderPlateValue = $("#plates").val();
			txt = $(this).find("span").text();
			var index = oLi.index(this);
			oLi.removeClass("selected").eq(index).addClass("selected");	// 样式切换
			$("#carCode").val($(this).attr("data-carCode"));
			$("#carName").val($(this).attr("data-carName"));
			$("#plates").val($(this).attr("data-plates"));
			$("#carSeries").val($(this).attr("data-carShortName"));
			popupObj.animate({"left":"1500px"},400);				// 关闭弹窗并赋值
			setSessionItem("license",$(this).attr("data-plates"));
			 									// 车牌号清空
			var url=$.context+"/preorder/change.htm";
			var paramObj = {										//数据提交
				"carCode":$(this).attr("data-carcode"),
				"carName":$(this).attr("data-carname"),
				"plates":$(this).attr("data-plates")
			};		
			$.postajax(url,paramObj,function(data){});
		});
	})($("#select-car"),$("#selectCarDiv"));

	(function(obj,selectpro,address){
		// switch 切换效果
		var count = 0;
		var showObj = selectpro.add(address),flag=true;			
		// flag 表示是否需要加载三级联动数据
		obj.click(function(){
			if(count==2){
				count=0;
			}
			if(count==0){
				obj.addClass("switch-btn-contentbg");
				showObj.css("display","block");
				$("#doorToDoorService").val("1");
				if(flag){
					global.selFun();
					flag = false;
				}
			}else{
				obj.removeClass("switch-btn-contentbg");
				showObj.css("display","none");
				$("#doorToDoorService").val("0");
			}
			count++;
		});
	})($("#switch-btn-content"),$("#selectprovince"),$("#address"));

	(function(obj,gloabal){
		// 三级联动效果
		var selObj = obj.find("select");
		var str0=str1=str2="<option>请选择</option>",selData=null;
		var changeFlag = true;
		global.selFun = function(){
			$.getJSON($.context+"/resources/js/area.js",function(data){
				selData = data;
				selFun();
				selObj.eq(0).find("option:eq(9)").change();
				selObj.eq(1).find("option:eq(1)").change();
				if(iosDevice){
					$("#selectprovince input:last").val("徐汇区");
				}
				changeFlag = false;
			});
		};
		function selFun(){					// 三级联动效果
			var index=null;
			$.each(selData,function(index,value){
				if(value.text=="上海市" && changeFlag){
					str0+="<option value='"+value.text+"' selected>"+value.text+"</option>";
				}else{
					str0+="<option value='"+value.text+"'>"+value.text+"</option>";
				}
			});	
			selObj.eq(0).html(str0);
			if(iosDevice){
				global.selFormat($("#seldown0"));
			}
		 	selObj.eq(0).change(function(){
		 		if( $(this).val() == "请选择"){
		 			selObj.eq(1).html("<option>请选择</option>");
		 			selObj.eq(2).html("<option>请选择</option>");
		 			if(iosDevice){
						global.selFormat($("#seldown1"),true);
						global.selFormat($("#seldown2"),true);
					}
		 			return false;
		 		}
				str0=str1=str2="<option>请选择</option>";
				index = $(this).find("option:selected").index()-1;		
				//已经选择的option的index索引值
				$.each(selData[index].children,function(index,value){
					if(value.text == "上海市" && changeFlag){
						str1+=" <option value='"+value.text+"' selected>"+value.text+"</option>";
					}else{
						str1+=" <option value='"+value.text+"'>"+value.text+"</option>";
					}
				});
				selObj.eq(1).html(str1);
				selObj.eq(2).html("<option>请选择</option>");
				if(iosDevice){
					global.selFormat($("#seldown1"));
					global.selFormat($("#seldown2"));
				}
			});
			selObj.eq(1).change(function(){
				if( $(this).val() == "请选择"){
		 			selObj.eq(2).html("<option>请选择</option>");
		 			if(iosDevice){
						global.selFormat($("#seldown2"),true);
					}
		 			return false;
		 		}
				str1=str2="<option>请选择</option>";
				var index2 = $(this).find("option:selected").index()-1;
				$.each(selData[index].children[index2].children,function(index,value){
					if(value.text=="徐汇区" && changeFlag){
						str2+=" <option value='"+value.text+"' selected>"+value.text+"</option>";
					}else{
						str2+=" <option value='"+value.text+"'>"+value.text+"</option>";
					}
				});
				selObj.eq(2).html(str2);
				if(iosDevice){
					global.selFormat($("#seldown2"));
				}
			});
		}
	})($("#selectprovince"),global);
		
	(function(obj){				// 提交验证
		var carSeriesFlag=false,carlicenseFlag=false,carDoorFlag=false,carTimeFlag=false,
			carAddressFlag=false,userNameFlag=false,telFlag=false,winScrollCount=1;
			// winScrollVar  第一个验证错误的对象
		var carSeriesObj = obj.find(".carSeries"),
			carlicenseObj= obj.find(".carlicense"),
			carDoorObj = obj.find(".carDoor"),
			carTimeObj = obj.find(".carTime"),
			carAddressObj = obj.find(".carAddress"),
			userName = obj.find(".userName"),
			tel = obj.find(".tel");
		var errorObj = obj.find("span.error");
		var errorMessage = ["选择车型","填写该车车牌号","选择服务门店","选择服务时间","填写取车地址","填写您的称呼","填写手机号码"];
		function winScroll(obj){							// 返回到某个错误位置
			var scrolltop = obj.offset().top+"px";
			
			$("html,body").stop().animate({"scrollTop":scrolltop},300);
		}
		function htmlAndBlock(obj,txt){
			if(txt){
				obj.html(txt).css("display","block");	
			}else{
				obj.css("display","none");
			}
		}
		function firstErrorObj(obj){					// 报错只执行一次
			if(winScrollCount<=1){
				winScroll(obj);
			}
			winScrollCount++;
		}
		carSeriesObj.blur(function(){					// 验证车型
			var value = $(this).val();
			if(/^\s*$/.test(value)  && /^\s*$/.test(carlicenseObj.val() )){
				errorObj.eq(0).html("选择车型、填写该车车牌号").css("display","block");
				firstErrorObj(errorObj.eq(0));
				return false;
			}
			if(/^\s*$/.test(value)){
				htmlAndBlock(errorObj.eq(0),errorMessage[0]);
				carSeriesFlag = false;
				firstErrorObj(errorObj.eq(0));
			}else{
				htmlAndBlock(errorObj.eq(0));
				carSeriesFlag = true;
			}
		});

		carlicenseObj.blur(function(){					// 验证车牌
			var value = $(this).val();
			if(/^\s*$/.test(value)  && /^\s*$/.test(carSeriesObj.val() )){
				errorObj.eq(0).html("选择车型、填写该车车牌号").css("display","block");
				firstErrorObj(errorObj.eq(0));
				return false;
			}
			if(/^\s*$/.test(value)){
				htmlAndBlock(errorObj.eq(0),errorMessage[1]);
				firstErrorObj(errorObj.eq(0));
				carlicenseFlag= false;
			}else{
				if(/^[\u4e00-\u9fa5]{1}[A-Z]{1}[A-Z_0-9]{5}$/i.test(value)){		
					// 车牌号验证
					htmlAndBlock(errorObj.eq(0));
					carlicenseFlag= true;
					$(this).val(value.toUpperCase());
					setSessionItem("license",value);
				}else{
					errorObj.eq(0).html("车牌格式不正确").css("display","block");
					carlicenseFlag= false;
					firstErrorObj(errorObj.eq(0));
				}
			}
		});

		carDoorObj.blur(function(){						// 门店验证
			var value = $(this).val();
			if(/^\s*$/.test(value)){
				htmlAndBlock(errorObj.eq(1),errorMessage[2]);
				firstErrorObj(errorObj.eq(1));
				carDoorFlag= false;
			}else{
				htmlAndBlock(errorObj.eq(1));	
				carDoorFlag = true;
			}
		});
		
		carTimeObj.blur(function(){						// 服务时间
			var value = $(this).val();
			if(/^\s*$/.test(value) && carAddressObj.is(":visible") && /^\s*$/.test(carAddressObj.val() )){
				errorObj.eq(2).html("选择服务时间、填写取车地址").css("display","block");
				firstErrorObj(errorObj.eq(2));
				return false;
			}
			if(/^\s*$/.test(value)){
				htmlAndBlock(errorObj.eq(2),errorMessage[3]);
				firstErrorObj(errorObj.eq(2));
				carTimeFlag= false;
				firstErrorObj(errorObj.eq(2));
			}else{
				htmlAndBlock(errorObj.eq(2));	
				carTimeFlag = true;
			}
		});

		carAddressObj.blur(function(){					//  取车地址
			var value = $(this).val();
			if(/^\s*$/.test(value) && /^\s*$/.test(carTimeObj.val() )){
				errorObj.eq(2).html("选择服务时间、填写取车地址").css("display","block");
				firstErrorObj(errorObj.eq(2));
				return false;
			}
			if(/^\s*$/.test($(this).val())){
				htmlAndBlock(errorObj.eq(2),errorMessage[4]);
				carAddressFlag= false;
				firstErrorObj(errorObj.eq(2));
			}else{
				var sel = $("#selectprovince select");			// 省份验证
				if( sel.eq(0).val() =="请选择" || sel.eq(1).val() =="请选择" || sel.eq(2).val() =="请选择"){
					carAddressFlag= false;	
					errorObj.eq(2).html("填写取车地址").css("display","block");
					firstErrorObj(errorObj.eq(2));
					return false;
				}else{
					htmlAndBlock(errorObj.eq(2));
					carAddressFlag= true;	
				}
				if(/^\s*$/.test( $("#contDate").val() )){				//日期选择
					errorObj.eq(2).html("填写取车日期").css("display","block");
					carAddressFlag= false;
					firstErrorObj(errorObj.eq(2));
					return false;
				}
				if(! nameCheck($("#contName").val())){	// 用户名选择
					errorObj.eq(2).html("填写取车联系人").css("display","block");
					carAddressFlag= false;
					firstErrorObj(errorObj.eq(2));
					return false;
				}
				if(! /^1[3|4|5|8][0-9]\d{8}$/.test( $("#contPhone").val() )){	// 电话选择
					errorObj.eq(2).html("填写取车联系电话").css("display","block");
					carAddressFlag= false;
					firstErrorObj(errorObj.eq(2));
					return false;
				}else{
					carAddressFlag= true;
					
				}
			}
		});
		$("#contName").blur(function(){
			observeFn([				// 数据映射关系函数
			    {
			    	"curObj":"#contName",
			    	"responseObj":"#form-pro .userName"
			    },
			    {
			    	"curObj":"#contPhone",
			    	"responseObj":"#form-pro .tel"
			    }
            ]);
		});
		$("#contPhone").blur(function(){
			observeFn([				// 数据映射关系函数
			    {
			    	"curObj":"#contName",
			    	"responseObj":"#form-pro .userName"
			    },
			    {
			    	"curObj":"#contPhone",
			    	"responseObj":"#form-pro .tel"
			    }
            ]);
		});
		userName.blur(function(){
			var value = $(this).val();
			if(/^\s*$/.test(value) && /^\s*$/.test(tel.val() )){
				errorObj.eq(3).html("填写您的称呼、手机号码").css("display","block");
				firstErrorObj(errorObj.eq(3));
				return false;
			}
			if(nameCheck(value)){
				htmlAndBlock(errorObj.eq(3));
				userNameFlag = true;
				observeFn([		// 数据映射关系函数
				    {
				    	"curObj":"#form-pro .userName",
				    	"responseObj":"#contName"
				    },
				    {
				    	"curObj":"#form-pro .tel",
				    	"responseObj":"#contPhone"
				    }
				]);
			}else{
				htmlAndBlock(errorObj.eq(3),errorMessage[5]);
				userNameFlag = false;
			}
		});
		
		function nameCheck(val){
			var count=0,flag=true,arr=val.split(""),len=arr.length;
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
		
		tel.blur(function(){
			var value = $(this).val();
			if(/^\s*$/.test(value) && /^\s*$/.test(userName.val() )){
				errorObj.eq(3).html("填写您的称呼、手机号码").css("display","block");
				firstErrorObj(errorObj.eq(3));
				return false;
			}
			if(/^1[3|4|5|8][0-9]\d{8}$/.test(value)){
				telFlag = true;
				htmlAndBlock(errorObj.eq(3));
				observeFn([		// 数据映射关系函数
				    {
				    	"curObj":"#form-pro .userName",
				    	"responseObj":"#contName"
				    },
				    {
				    	"curObj":"#form-pro .tel",
				    	"responseObj":"#contPhone"
				    }
				]);
				setSessionItem("newUserName",value);
			}else{
				if(/^\s*$/.test(value)){
					htmlAndBlock(errorObj.eq(3),errorMessage[6]);
					telFlag = false;
				}else{
					errorObj.eq(3).html("手机号码错误").css("display","block");			
					telFlag = false;
				}
			}
		});

		var checkPromote = "";
		obj.submit(function(){
			winScrollCount=1;
			if(!carSeriesFlag){											// 车型
				carSeriesObj.trigger("blur");
			}								
			if(!carlicenseFlag  && carSeriesFlag){						// 车牌号
				carlicenseObj.trigger("blur");
			}
			if(!carDoorFlag){											// 门店服务
				carDoorObj.trigger("blur");
			}
			if(!carTimeFlag){											// 服务时间
				carTimeObj.trigger("blur");
			}
			errorObj.eq(2).css("display","none");						// 隐藏省份验证
			if(! carAddressObj.is(":hidden")){		// 上门取车时验证
				carAddressObj.trigger("blur");
			}else{
				carAddressFlag=true;
			}
			if(!userNameFlag){
				userName.trigger("blur");
			}
			if(!telFlag && userNameFlag){
				tel.trigger("blur");
			}
			if(carSeriesFlag && carlicenseFlag && carDoorFlag && carTimeFlag&&carAddressFlag && userNameFlag && telFlag){		
				errorObj.css("display","none");
				var serializeArr = $(this).serialize().split("&");
				$.each(serializeArr,function(index,value){
					var arr = value.split("=");
					global.spanDataArr[arr[0]] = decodeURIComponent(arr[1],true);
				});
				global.spanDataArr["carName"] = $("#carName").val(); 
//				var url=$.context+"/preorder/submit.htm";
				var url=$.context+"/preorder/check.htm";
				
				var result=JSON.stringify(global.spanDataArr);
				// 所有表单(有name值的)验证通过数据(select三级联动数据具体判断)
				console.log(result);
				var confirmTxt = "只有选择工作日到门店接受服务可减20元，您确定选择 "+$("#date").val()+" ？";
				checkPromote = "";
				$.postjson(url,result,function(data){
			    	if(data.result==$.dataResult.SUCCESS){
//			    		window.location.href=$.context+"/preorder/success.htm";
			    		sumit(0);
		    		}else if (data.result==2) {
		    			checkPromote = data.obj;
		    			comConfirmObj(confirmTxt,sumit);
		    		} else {
		    			comAlertObj(data.msg);
		    			return false;
		    		}
			     });
				return false;
			}else{
				// 需求需要全局显示报错信息
				return false;
			}
		});
		
		function sumit(confirmResult) {
			checkPromote = checkPromote||"";
			if (confirmResult != 2) {
				var url = $.context+"/preorder/submit.htm?delPromote="+checkPromote;
				$.getajax(url,"",function(data){
			    	if(data.result==$.dataResult.SUCCESS){
			    		window.location.href=$.context+"/preorder/success.htm";
		    		}else{
		    			comAlertObj(data.msg);
		    			return false;
		    		}
			     });
			}
		}
	})($("#form-pro"));
	
	(function(obj){												// 自定义下拉框选择
		if(!iosDevice){
			$("#selectprovince").find("input,i").css("display","none");
			$("#selectprovince").find("select").addClass("show");
			
			$("#pro-date-1").find("input,i").css("display","none");
			$("#pro-date-1").find("select").addClass("show");
			return false;
		}
		function selFormat(obj,flag){
			var sel = obj.parent().find("select"),
				input = obj.parent().find("input:first");
			if(input.attr("class")!="afterMoon"){
				input.val("请选择");
			}
			sel.removeAttr("name");
			obj.parent().addClass("ios-device");
			obj.add(input).click(function(){
				sel.trigger("focus");
			});
			sel.change(function(){
				var txt = $(this).find("option:selected").text();
				input.val(txt);
			});
			if(flag){
				input.val("请选择");
			}
		}
		global.selFormat = selFormat;
		global.selFormat(obj);
	})($("#drop-down"));
	
	$("#date").focus(function(){
		WdatePicker({minDate:$(this).attr("data-min")});
		return false;
	});
	$("#contDate").focus(function(){
		WdatePicker(
			{
				maxDate:$("#date").val(),
				minDate:$("#useDate").val()
			}
		);
		return false;
		 
	});
	
	function setSessionItem(name,str){
		sessionStorage.setItem(name,str);
	}
	function getSessionItem(name){
		var val = sessionStorage.getItem(name);
		if(val){
			return val;
		}
	}
	
	
	function observeFn(vArg){					//累计赋值
		for(var i=0,len=vArg.length;i<len;i++){
			if(/^\s*$/.test($(vArg[i].responseObj).val()) ){		// 为空是赋值
				$(vArg[i].responseObj).val( $(vArg[i].curObj).val() );
			}
		}
	}
});