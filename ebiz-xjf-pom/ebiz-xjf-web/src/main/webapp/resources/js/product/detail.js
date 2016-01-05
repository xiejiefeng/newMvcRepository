$(function(){
	//购物车
	backet.init();
	var global ={};		// 全局对象
	;(function(obj){			
		// obj ==>  点击展开项目详情的id
		var btn = obj.find(".toggle-btn"),
			content = obj.find(".toggle-content"),
            dropDown =obj.find('.drop-down'),
            dropUp =obj.find('.drop-up');
        var index=0,top=obj[0].offsetTop;
        dropDown.show();
		btn.click(function(){
			if(index==2){
				index=0;
			}
			if(index==0){
				obj.addClass("click-position").css("top",top);
				obj.animate({"top":0},1000);
				$("#buy").css("opacity",0);
				content.fadeIn();
				dropDown.hide();
                dropUp.show();
                $(document).scrollTop(0);
			}
			if(index==1){
				content.fadeOut();
				$("#buy").css("opacity",1);
				obj.animate({"top":top},1000,function(){
					$(this).removeClass("click-position").css("top",0);
					dropDown.show();
                	dropUp.hide();
                });
			}
			index++;
		});
	})($("#click-detail"));
	/*
	;(function(global,total){									// 总金额方法 对象
		global.moneyMethod = (function(){
			var priceArr = [];
			function addPrice(price){							// 添加金额
				priceArr.push(price);
			}
			function getLength(){								// 数组长度
				return priceArr.length;
			}
			function removePrice(price){						// 移除金额
				priceArr.splice($.inArray(price,priceArr),1);
			}
			function cal(sign,num){							// 减少金额
				if(sign=="+"){
					return (total+num*1).toFixed(2);
				}else if(sign=="-"){
					return (total-num*1).toFixed(2);
					//return (total-( parseInt(total/type1.condition)*type1.discountvalue )).toFixed(2);
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
				"getTotal":getTotal
			};
		})();
	})(global,($("#totalPriceSpan").parent().attr("data-price"))*1);
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
	;(function(obj){													// obj为需要打钩的圈
		var totalPriceSpan = $("#totalPriceSpan"),						// 初始价格对象
			totalPriceParent = totalPriceSpan.parent(),					// 初始价格对象父级
			priceCode = totalPriceParent.data("code"),					// 初始化 code
			storeId = totalPriceParent.data("storeid"),					// 初始storeId
			totalNum = totalPriceSpan.text()*1,							// 初始化价格
			totalOrialNum = totalPriceParent.attr("data-price")*1;		// 实际价格
		global.spanDataArr =									// 没有选择的时候默认参数
		    {
				"code":priceCode,
				"storeId":returnEmpty(totalPriceParent,"data-storeId"),
				"storeId":returnEmpty(storeId),
				"price":returnEmpty(totalPriceSpan.text())
			};
		var curObj = null,priceFlag=null,signFlag=null;
		obj.on("click",function(e){		
			// 实际点中的是i标签
			if( curObj == this ){									// 同一个取消选中
				if(signFlag=="+"){
					totalNum=(totalNum*1-priceFlag*1).toFixed(2);		
				}else if(signFlag=="-"){
					totalNum=(totalNum*1+priceFlag*1).toFixed(2);
				}else if(signFlag=="*"){
					totalNum=(totalNum*1/(priceFlag/100*1)).toFixed(2);		
				}
				totalPriceSpan.text(totalNum);
				$(this).removeClass("bg");
				global.spanDataArr.promoteCode = "";
				curObj=null;
				return false;
			}else{
				curObj = this;
			}						
			global.spanDataArr=										// 单个服务list
				{
					"code":priceCode,
					"storeId":returnEmpty(totalPriceParent,"storeid"),
					"price":returnEmpty(totalPriceSpan.text()),
					"discountType":returnEmpty($(this).attr("data-discounttype")),
					"promoteCode":returnEmpty($(this).attr("data-promoteCode")),
					"discountValue":returnEmpty($(this).attr("data-discountvalue"))
				};
		 	obj.removeClass("bg");					
			$(this).addClass("bg");
			setSessionItem("operate",$(this).attr("id"));			// session保存
			dataFn($(this).attr("data-discounttype"),$(this));			 // 价格计算		
		});
		if( getSessionItem("operate") ){								// reload数据保存
			$("#"+getSessionItem("operate")).addClass("bg").trigger("click");
		}
		function dataFn(index,obj){						// 获取数据格式方法Fn
			if(index==2){								// 为2的时候返回初始值
				totalPriceSpan.text(totalOrialNum.toFixed(2));
			}
			var dataArr = [
				{"sign":"*"},
				{"sign":"-"},
				{"sign":""},
				{"sign":"+"}
			][index];
			signFlag = dataArr.sign;
			priceFlag = obj.attr("data-discountvalue");
			totalNum = global.moneyMethod.cal(dataArr.sign,obj.attr("data-discountvalue"));
			totalPriceSpan.text(totalNum);	//报错规避NaN
			 
		}
	})($("#dl-list span"));
	*/
	
	(function(global,total){
		// 总金额方法 对象
		global.moneyMethod = (function(){
			var promoteArr = [];
			// 添加促销
			function addPromote(promote){
				promoteArr.push(promote);
			}
			// 移除促销
			function removePromote(promote){
				var index = -1;
				for(var i=0;i<getLength();i++){
					if (promote.promoteCode == promoteArr[i].promoteCode) {
						index = i;
						break;
					}
				}
				if (index > -1) {
					promoteArr.splice(index,1);
				}
			}
			// 数组长度
			function getLength(){
				return promoteArr.length;
			}
			// 促销方式排序(0:减金额、1:折扣、2:赠品、3:加钱购)
			function sortPromote(promote1,promote2) {
				return promote1.orderNo - promote2.orderNo;
			}
			// 计算金额
			function calPrice(total,isProduct){
				isProduct = isProduct?isProduct:false;
				promoteArr.sort(sortPromote);
				var result = total;
				for(var i=0;i<getLength();i++){
					if(promoteArr[i].discountType == "0"){			// 折扣
						result = (result*(promoteArr[i].discountValue*1)/100);
					}else if(promoteArr[i].discountType == "1"){	// 减金额
						result = (result-(promoteArr[i].discountValue*1));
						if (result < 0) result = 0;
					}else if(promoteArr[i].discountType == "3"){	// 加钱购
						if (isProduct == false) {
							result = (result+(promoteArr[i].discountValue*1));
						}
					}
				}
				return result.toFixed(2);
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
				
				for(var i=0;i<getLength();i++){
					if (promoteArr[i].promoteCode == promoteCode) {
						promoteArr[i].discountValue = discountValue;
						promoteArr[i].promoteGiftServiceInfo = giftServiceArr;
						promoteArr[i].promoteGiftSkuInfo = giftSkuArr;
						break;
					}
				}
			}
			return {
				"addPromote":addPromote,
				"removePromote":removePromote,
				"getLength":getLength,
				"sortPromote":sortPromote,
				"calPrice":calPrice,
				"getPromote":getPromote,
				"setGift":setGift
			};
		})();
	})(global,($("#totalPriceSpan").parent().attr("data-price"))*1);
	
	(function(obj){												// obj为需要打钩的圈
		var totalPriceSpan = $("#totalPriceSpan"),						// 初始价格对象
			totalPriceParent = totalPriceSpan.parent(),					// 初始价格对象父级
			priceCode = totalPriceParent.data("code"),					// 初始化 code
			storeId = totalPriceParent.data("storeid"),					// 初始storeId
			totalNum = totalPriceSpan.text()*1,							// 初始化价格
			totalOrialNum = totalPriceParent.data("price")*1;			// 实际价格
		
		var chk = obj.parent().find(":checkbox");
		
		global.spanDataArr =											// 没有选择的时候默认参数
		    {
				"code":priceCode,
				"storeId":returnEmpty(storeId),
				"price":returnEmpty(totalPriceSpan.text())
			};
		
		// 促销选择
		obj.on("click",function(e){
			if ($(this).parent().hasClass("sev-list-disabled")) return;			// 不可选择
			
			var className = returnEmpty($(this).attr("class")),					// 样式
			promoteCode = returnEmpty($(this).attr("data-promoteCode")),		// 促销代码
			rulesRelation = returnEmpty($(this).attr("data-rulesRelation")),	// 规则
			discountType = returnEmpty($(this).attr("data-discountType")),		// 优惠方式(0:折扣 1:减金额 2:赠品 3:加钱购)
			discountValue = returnEmpty($(this).attr("data-discountValue"));	// 优惠金额
		
			// 促销方式排序(0:减金额、1:折扣、2:赠品、3:加钱购)
			var orderNo = 99;
			if(discountType == "0"){
				orderNo = 1;
			}else if(discountType == "1"){
				orderNo = 0;
			}else if(discountType == "2"){
				orderNo = 2;
			}else if(discountType == "3"){
				orderNo = 3;
			}
			
			var promote = {
					"promoteCode":promoteCode,
					"rulesRelation":rulesRelation,
					"discountType":discountType,
					"discountValue":discountValue,
					"orderNo":orderNo
			};
			
			// 实际点中的是i标签
			if( className.indexOf("bg") > -1 ){							// 同一个取消选中
				// 移除促销数组
				global.moneyMethod.removePromote(promote);
				// 取消选中
				$(this).removeClass("bg");
				
				// 取消加钱购项目
				if(discountType == "3"){
					$(":checkbox[id^='"+promoteCode+"']").prop("checked",false);
				}
			}else{
				// 排他组
				if (rulesRelation == "0") {
					var spans = $("#dl-list0 span");
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
			totalNum = global.moneyMethod.calPrice(totalOrialNum);
			totalPriceSpan.text(totalNum);
			
			// 获取促销
			global.spanDataArr.promotionList = global.moneyMethod.getPromote();
			
//			// session保存
//			setSessionItem("operate-product", JSON.stringify(global.moneyMethod.getPromote()));
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
				totalNum = global.moneyMethod.calPrice(totalOrialNum);
				totalPriceSpan.text(totalNum);
			}
			
			// 保存选中状态
			var chkIdArr = [];
			$(":checkbox:checked").each(function(index){
				chkIdArr.push(this.id);
			});
			
//			// session保存
//			setSessionItem("checkbox-product",chkIdArr.join(","));
		});
//		// reload数据保存
//		if( getSessionItem("operate-product") ){
//			var promoteArr = JSON.parse(getSessionItem("operate-product"));
//			for (var i=0;i<promoteArr.length;i++) {
//				$("#"+promoteArr[i].promoteCode).trigger("click");
//			}
//			
//			if ( getSessionItem("checkbox-product") ) {
//				var chkChecked = getSessionItem("checkbox-product");
//				$(":checkbox").each(function(index){
//					if((chkChecked.indexOf(this.id) > -1 && !this.checked)
//						|| (chkChecked.indexOf(this.id) == -1 && this.checked)) {
//						$("#"+this.id).trigger("click");
//					}
//				});
//			}
//		}
	})($(".dl-list span"));
	
	
	;(function(){
		// 提交数据验证;
		$("#ajaxBtn").click(function(){
			var url=$.context+"/service/preorder.htm";
			var _code=$(this).data("code");
			var _storeId=$(this).data("storeid");
			var result=JSON.stringify(global.spanDataArr);
			$.postjson(url,result,function(data){
		    	if(data.result==$.dataResult.SUCCESS){
		    		window.location.replace($.context+"/preorder/index.htm?code="+_code+"&storeId="+_storeId);	
	    		}else{
	    			comAlertObj(data.msg);
	    		}
		     });
			return false;
		});	
		
		$("#ajaxDeatilBtn").click(function(){
			$("#ajaxBtn").click();
		});
	})();
});