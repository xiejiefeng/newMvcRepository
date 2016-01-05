$(function(){
	var global = {};
	 
	/*
	(function(global){											// 总金额方法 对象
		global.moneyMethod = (function(){
			var priceArr = [];
			var str="";
			function addPrice(price){							// 添加金额
				priceArr.push(price);
			}
			function setItem(strArg){
				str=str+strArg+",";
				return str;
			}
			function getLength(){								// 数组长度
				return priceArr.length;
			}
			function removePrice(price){						// 移除金额
				priceArr.splice($.inArray(price,priceArr),1);
			}
			function cal(sign,total,num,type1){							// 减少金额
				if(sign=="+"){
					return (total+num*1).toFixed(2);
				}else if(sign=="-"){
					return (total-num*1).toFixed(2);
				}else if(sign=="*"){
					return (total*(num*1)/100).toFixed(2);
				}
			}
			function getTotal(rate){							// 共额
				var totalPrice = 0;
				var len = getLength(priceArr);
				while(len--){
					totalPrice+=rate?priceArr[len]*1*rate:priceArr[len]*1;
				}
				return totalPrice;
			}
			return {
				"addPrice":addPrice,
				"cal":cal,
				"getLength":getLength,
				"removePrice":removePrice,
				"setItem":setItem,
				"getTotal":getTotal
			};
		})();
	})(global);
	*/

	function setSessionItem(name,str){
		sessionStorage.setItem(name,str);
	}
	function getSessionItem(name){
		var val = sessionStorage.getItem(name);
		if(val){
			return val;
		}
	}
	
	function returnEmpty(obj,name){								// 判断是否为空 Fn
		var val = null;
		if(typeof obj == "object"){
			val = obj.attr(name);	
		}else{
			val = obj;
		}
		var isEmpty = $.StringUtils.isEmpty(val);
		if(isEmpty){
			return "";
		}else{
			return val;
		}
	}			

	/*
	(function(obj){
		var dataProduct = "",											// id 字符串
			totalPriceSpan = $("#totalPriceSpan"),						// 初始价格对象
			totalPriceParent = totalPriceSpan.parent(),					// 初始价格对象父级
			giftParams = [],									// 比较多的服务的保存数组
		 	priceCode = totalPriceParent.attr("data-code");				// 初始化 code
		$("#buy .pro-txt em").each(function(index){					// 计算总金额/删除金额函数
			global.moneyMethod.addPrice( $(this).text() );
			dataProduct = global.moneyMethod.setItem($(this).next().attr("data-product"));// id str 拼接
			setSessionItem("productRecondNum",dataProduct);		// 记录商品的总数目和商品的id
		});
		
		var totalNum = (global.moneyMethod.getTotal()).toFixed(2),			// 初始化价格
			totalOrialNum = totalNum,
			pro_moneyTitle = $("#pro_moneyTitle");
		totalPriceSpan.text(totalNum);
		totalPriceParent.attr("data-price",totalNum),					// 初始化最原始价格
		pro_moneyTitle.text(totalNum);
		obj.each(function(){
			if($(this).attr("data-condition")*1>totalNum){
				$(this).parents(".sev-list").css("display","none");
			}
		});	
		$("#buy .pro-txt i").click(function(){							// 删除数据内容
			var _this = $(this);	
			var productId=_this.data("product");
			var reqdata={"productId":productId};
			global.moneyMethod.removePrice(_this.prev().text());	//删除数组中的price 数据
   		 	totalPriceSpan.text(global.moneyMethod.getTotal().toFixed(2));	// 重新计算总金额
   		 	totalNum = totalPriceSpan.text();
   		 	totalOrialNum = totalNum; 
   		 	
   		 	if(totalPriceSpan.text()*1==0){							// 为0 不需要跳转页面
   		 		$("#full-info-btn").css("display","none");
   		 	}
   		 	
   		 	totalPriceParent.attr("data-price",totalPriceSpan.text());	
    		pro_moneyTitle.text($("#totalPriceSpan").text());
    		var url=$.context+"/preorder/delproduct.htm";
    		obj.each(function(){
    			if($(this).attr("data-condition")*1>totalNum){
    				$(this).parents(".sev-list").css("display","none");
    			}
    		});	
    		$.postajax(url,reqdata,function(data){
		    	if(data.result==$.dataResult.SUCCESS){
		    		_this.parents("div.pro-txt").remove();
					obj.removeClass("bg");	
					sessionStorage.removeItem("operate");						// 清除 session 数据
				}else{
	    		    alertObj.html(data.msg);
	    	  	}
		     });
		});
		
		global.spanDataArr = 										// 没有选择的时候默认参数
		    {
				"code":priceCode,
				"storeId":returnEmpty(obj.eq(0).attr("data-storeId")),
				"price":returnEmpty($("#totalPriceSpan").text()),
				"discountType":returnEmpty(obj.eq(0).attr("data-discounttype"))
			};
		var curObj = null,priceFlag=null,signFlag=null;
		var clickData = {};
		obj.on("click",function(e){
			// 实际点中的是i标签 		
			if(totalNum==0){								// 总价为0时返回操作
				obj.removeClass("bg");
				
				return false;
			}
			if( curObj == this ){									// 同一个取消选中
				totalPriceSpan.text(totalOrialNum);
				pro_moneyTitle.text(totalOrialNum);
				$(this).removeClass("bg");
				curObj=null;
				return false;
			}else{
				curObj = this;
			}						
			global.spanDataArr=
				{
					"price":returnEmpty($("#totalPriceSpan").text()),
					"discountType":returnEmpty($(this).attr("data-discounttype")),
					"promoteCode":returnEmpty($(this).attr("parentPromoteCode")),
					"discountPrice":totalPriceSpan.text()
				};
			
			if(totalPriceSpan.text()*1<$(this).attr("data-condition")*1){
				return false;										// 不满价格直接返回
			}
			obj.removeClass("bg");					
			$(this).addClass("bg");
			setSessionItem("operate",$(this).attr("id"));	// session保存
			dataFn($(this).attr("data-discounttype"),$(this));	
			clickData = {
				discountType:$(this).attr("data-discounttype"),
				promoteCode:$(this).attr("data-promotecode"),
				discountValue:$(this).attr("data-discountvalue")
			}
		});
		
		if( getSessionItem("operate") ){								// reload数据保存
			var emLength = $("#buy .pro-txt em").length,
				emArr = getSessionItem("productRecondNum").split(","),emFlag = true;
//		 	$("#buy .pro-txt em").each(function(index){
//				if( $(this).attr("data-product")!=emArr[index]){
//					emFlag = false;
//				}
//			})	
		} 
		 
		if(emFlag){
			var arrItem = getSessionItem("operate");					// 多个服务id;
			$("#"+ getSessionItem("operate")).addClass("bg").trigger("click");
		}
		
		function dataFn(index,obj,flag){						// 获取数据格式方法Fn
			if(index==2){								// 为2的时候返回初始值
				totalPriceSpan.text(totalOrialNum);
			}
			var dataArr = [
				{"sign":"*"},
				{"sign":"-"},
				{"sign":""},
				{"sign":"+"}
			][index];
			signFlag = dataArr.sign;
			priceFlag = obj.attr("data-discountvalue");
			totalNum = global.moneyMethod.cal(dataArr.sign,totalOrialNum*1,obj.attr("data-discountvalue"));			
			totalPriceSpan.text(totalNum);
			pro_moneyTitle.text(totalNum);
			totalPriceParent.attr("data-price",totalNum);					 
			global.spanDataArr["discountPrice"]= totalNum;
		}
		
		$("#btnNext").click(function(){
			var price=totalOrialNum;				// 原始影藏的data价格
			var discountType=clickData.discountType?clickData.discountType:"";			// 类型
			var discountPrice=$.StringUtils.isEmpty(totalNum)?"0":totalNum;		// 客户看到的价格
			var promoteCode=clickData.promoteCode?clickData.promoteCode:"";		//  span 上的
			var discountValue=clickData.discountValue?clickData.discountValue:"";		//  span 上的
			window.location.href=$.context+"/preorder/next.htm?price="+price+"&discountType="+discountType+"&discountPrice="+discountPrice+"&promoteCode="+promoteCode+"&discountValue="+discountValue;
			return false;
		});
	})($("#dl-list span")); 
	*/
	
	function observeFn(vArg){					//累计赋值
		for(var i=0,len=vArg.length;i<len;i++){
			if(/^\s*$/.test($(vArg[i].responseObj).val()) ){		// 为空是赋值
				$(vArg[i].responseObj).val( $(vArg[i].curObj).val() );
			}
		}
	}
	if(! /^\s*/.test($("#storeId").val())){
		sessionStorage.setItem("store",$("#storeId").val() );
	}
	
	(function(global){
		// 总金额方法 对象
		global.moneyMethod = (function(){
			var priceArr = [];
			var promoteArr = [];
			// 添加金额
			function addPrice(price){
				priceArr.push(price);
			}
			// 移除金额
			function removePrice(price){
				priceArr.splice($.inArray(price,priceArr),1);
			}
			// 金额数组长度
			function getPriceLength(){								
				return priceArr.length;
			}
			// 计算服务总价
			function getTotal(rate){							// 共额
				var totalPrice = 0;
				var len = getPriceLength();
				while(len--){
					totalPrice+=rate?priceArr[len]*1*rate:priceArr[len]*1;
				}
				return totalPrice;
			}
			// 添加促销
			function addPromote(promote){
				promoteArr.push(promote);
			}
			// 移除促销
			function removePromote(promote){
				var index = -1;
				for(var i=0;i<getPromoteLength();i++){
					if (promote.promoteCode == promoteArr[i].promoteCode) {
						index = i;
						break;
					}
				}
				if (index > -1) {
					promoteArr.splice(index,1);
				}
			}
			// 促销数组长度
			function getPromoteLength(){
				return promoteArr.length;
			}
			// 获取促销
			function getPromote(){
				return promoteArr;
			}
			// 获取加钱购
			function setGift(promoteCode) {
				var chkChecked = $(":checkbox[id^='"+promoteCode+"']:checked");		// 选中加价购项目
				var discountValue = 0;
				var giftServiceArr = [],giftSkuArr = [];
				
				// 计算加钱购金额
				chkChecked.each(function(index){
					discountValue += $(this).attr("data-projectPrice")*1;
					if ($(this).attr("data-codeType") == 1) {			// 服务
						giftService = {
								"serviceCode":$(this).attr("data-giftCode")
						};
						giftServiceArr.push(giftService);
					} else if (chkChecked.eq(i).attr("data-codeType") == 2) {	// 精品
						giftSku = {
								"skuCode":$(this).attr("data-giftCode")
						};
						giftSkuArr.push(giftSku);
					}
				});
				
				for(var i=0;i<getPromoteLength();i++){
					if (promoteArr[i].promoteCode == promoteCode) {
						promoteArr[i].discountValue = discountValue;
						promoteArr[i].promoteGiftServiceInfo = giftServiceArr;
						promoteArr[i].promoteGiftSkuInfo = giftSkuArr;
						break;
					}
				}
			}
			// 计算金额
			function calPrice(){
				var result = getTotal();
				for(var i=0;i<getPromoteLength();i++){
					if(promoteArr[i].discountType == "0"){			// 折扣
						result = (result*(promoteArr[i].discountValue*1)/100);
					}else if(promoteArr[i].discountType == "1"){	// 减金额
						result = (result-(promoteArr[i].discountValue*1));
					}else if(promoteArr[i].discountType == "3"){	// 加钱购
						result = (result+(promoteArr[i].discountValue*1));
					}
				}
				
				return result.toFixed(2);
			}
			
			return {
				"addPrice":addPrice,
				"removePrice":removePrice,
				"getPriceLength":getPriceLength,
				"addPromote":addPromote,
				"removePromote":removePromote,
				"getPromoteLength":getPromoteLength,
				"calPrice":calPrice,
				"getPromote":getPromote,
				"setGift":setGift,
				"getTotal":getTotal
			};
		})();
	})(global);
	
	(function(obj){
		var totalPriceSpan = $("#totalPriceSpan"),					// 初始价格对象
			pro_moneyTitle = $("#pro_moneyTitle");					// 条件价格对象
		
		$("#buy .pro-txt em").each(function(index){					// 计算总金额/删除金额函数
			global.moneyMethod.addPrice( $(this).text() );
		});
		
		var totalNum = (global.moneyMethod.getTotal()).toFixed(2);	// 初始化价格
		totalPriceSpan.text(totalNum);
		pro_moneyTitle.text(totalNum);
		
		// 初始化订单促销
		obj.each(function(){
			if($(this).attr("data-condition")*1>totalNum){
				$(this).parents(".sev-list").css("display","none");
			}
		});
		
		global.spanDataArr =											// 没有选择的时候默认参数
	    {
			"price":returnEmpty(totalPriceSpan.text())
		};
		
		var chk = obj.parent().find(":checkbox");
		
		// 删除服务，重新计算订单金额及订单促销显示
		$("#buy .pro-txt i").click(function(){
			var _this = $(this);	
			var productId=_this.data("product");
			var reqdata={"productId":productId};
//			global.moneyMethod.removePrice(_this.prev().text());	// 删除数组中的price 数据
//			totalNum = global.moneyMethod.getTotal().toFixed(2);	// 重新计算总金额
//   		 	totalPriceSpan.text(totalNum);	
//   		 	pro_moneyTitle.text(totalNum);
//   		 	
//   		 	// 无服务项目
//   		 	if($("#buy .pro-txt").length == 0){
//   		 		$("#full-info-btn").css("display","none");
//   		 	} else {
//	   		 	obj.each(function(){
//		 			if($(this).attr("data-condition")*1>totalNum){
//		 				$(this).parents(".sev-list").css("display","none");
//		 			}
//		 		});
//   		 	}
//    		
   		 	// 重置购物车
    		var url=$.context+"/preorder/delproduct.htm";
    		$.postajax(url,reqdata,function(data){
		    	if(data.result==$.dataResult.SUCCESS){
		    		window.location.replace($.context+"/preorder/index.htm?storeId=" + $("#storeId").val());	
				}else{
	    		    alertObj.html(data.msg);
	    	  	}
		     });
			
			return false;
		});
		
		// 选择订单促销
		obj.on("click",function(e){
			if ($(this).parent().hasClass("sev-list-disabled")) return;			// 不可选择
			
			var className = returnEmpty($(this).attr("class")),					// 样式
			promoteCode = returnEmpty($(this).attr("data-promoteCode")),		// 促销代码
			rulesRelation = returnEmpty($(this).attr("data-rulesRelation")),	// 规则
			discountType = returnEmpty($(this).attr("data-discountType")),		// 优惠方式(0:折扣 1:减金额 2:赠品 3:加钱购)
			discountValue = returnEmpty($(this).attr("data-discountValue"));	// 优惠金额
			condition = returnEmpty($(this).attr("data-condition"));			// 优惠条件
			
			// 无服务项目
   		 	if($("#buy .pro-txt").length == 0){
				obj.removeClass("bg");
				return false;
			}
   		 	
   		 	var promote = {
					"promoteCode":promoteCode,
					"rulesRelation":rulesRelation,
					"discountType":discountType,
					"discountValue":discountValue
			};
   		 	
   		 	// 实际点中的是i标签 	
   		 	if( className.indexOf("bg") > -1 ){									// 同一个取消选中
   		 		// 移除促销数组
				global.moneyMethod.removePromote(promote);
				// 取消选中
				$(this).removeClass("bg");
				
				// 取消加钱购项目
				if(discountType == "3"){
					$(":checkbox[id^='"+promoteCode+"']").prop("checked",false);
				}
			}else{
				// 不满价格直接返回
				if(totalNum*1 < condition*1){
					return false;										
				}
				
				// 排他组
				if (rulesRelation == "0") {
					var spans = $("#dl-list span");
					// 取消所有选中
					for(var i=0;i<spans.length;i++){
						if (returnEmpty(spans.eq(i).attr("class")).indexOf("bg") > -1) {
							spans.eq(i).trigger("click");
							break;
						}
					}
				}
				
				// 增加促销数组
				global.moneyMethod.addPromote(promote);
				// 选中
				$(this).addClass("bg");
				
				// 计算加钱购价格
				if(discountType == "3"){
					var chkChecked = $(":checkbox[id^='"+promoteCode+"']:checked");
					var chkLength = chkChecked.length;
					if (chkLength == 0) {
						$(":checkbox[id^='"+promoteCode+"']").prop("checked",true);
					}
					
					global.moneyMethod.setGift(promoteCode);
				}
			}
   		 	
   		 	// 计算金额
			totalNum = global.moneyMethod.calPrice();
			totalPriceSpan.text(totalNum);
			pro_moneyTitle.text(totalNum);
			
			// 获取促销
			global.spanDataArr.promotionList = global.moneyMethod.getPromote();
		});
		
		// 加钱购复选框
		chk.on("click",function(e){
			// 不可选择
			if ($(this).parent().hasClass("sev-list-disabled")) {
				$(this).prop("checked", false);
				return;			
			}
			
			var promoteCode = returnEmpty($(this).attr("data-promoteCode"));	// 促销代码
			var className = returnEmpty($("#"+promoteCode).attr("class"));		// 样式
			var chkChecked = $(":checkbox[id^='"+promoteCode+"']:checked");		// 选中加价购项目
			var chkLength = chkChecked.length;									// 选中个数
			
			// 有加钱购项目，加钱购未选择 或 无加钱购项目，加钱购已选择
			if (chkLength == 0 && className.indexOf("bg") > -1
				|| chkLength > 0 && className.indexOf("bg") == -1) {
				$("#"+promoteCode).trigger("click");
			} else {
				global.moneyMethod.setGift(promoteCode);
				totalNum = global.moneyMethod.calPrice();
				totalPriceSpan.text(totalNum);
				pro_moneyTitle.text(totalNum);
			}
		});
		
		$("#btnNext").click(function(){
			var url=$.context+"/preorder/next.htm";
			var result=JSON.stringify(global.spanDataArr);
			$.postjson(url,result,function(data){
		    	if(data.result==$.dataResult.SUCCESS){
		    		window.location.replace($.context+"/preorder/confirm.htm");	
	    		}else{
	    			comAlertObj(data.msg);
	    		}
		     });
			return false;
		});
	})($("#dl-list span"));
});