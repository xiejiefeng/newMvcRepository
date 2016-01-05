<!DOCTYPE html>
<html>
<head>
<title>服务预约2/2</title>
<#include "/common/header.ftl" encoding="UTF-8">
<link rel="stylesheet" type="text/css" href="<@jci.domain url='/css/order.css'/>">
</head>
<script>
var _plates = '${(carInfo.plates)!}';
var carB = "";
var carE = "";
var platesFg = <#if carInfo?? && carInfo.assetId?? && carInfo.assetId!='' && carInfo.plates?? && carInfo.plates!=''>true<#else>false</#if>;//是否可以修改车牌号   false 可以修改   true 不可以修改
</script>
<body class="payment">
<#include "/common/rem.ftl" encoding="UTF-8">
<form action="${contextPath}/service/saveConfirm.htm" id="form-pro" method="post">
    <h2 class="servListTitle">预约信息</h2>
    <section class="pro-car infor-title " data-lable="服务预约2/2-选择门店" >
                <div>
                    <label>选择门店</label>
                     <dl>
                       <#if storeInfo?? && storeInfo.storeNo??>
                         <dt>${storeInfo.storeName}</dt>
                         <dd class="text-overflow">${storeInfo.address}</dd>
                        <#else>
                         <input type="text" placeholder="请选择服务门店" id="carDoor" class="carDoor" name="carDoor" readonly="readonly"/>
                        </#if>
                       <span><i class="iconfont icon-arrows"></i></span>
                     </dl>
                     <input type="hidden" id="storeId" name="storeId" value="<#if storeInfo?? && storeInfo.storeId??>${storeInfo.storeId}</#if>"/>
                     <input type="hidden" id="storeNo" name="storeNo" value="<#if storeInfo?? && storeInfo.storeNo??>${storeInfo.storeNo}</#if>"/>
                     <input type="hidden" id="storeName" name="storeName" value="<#if storeInfo?? && storeInfo.storeName??>${storeInfo.storeName}</#if>"/>
                </div>
    </section>
    <section class="pro-time infor-title" storeIcon  data-lable="服务预约2/2-到店时间">
			<label>到店时间</label>
            <input  type="text" data-modal="mdModal" name="orderDate" id="demo_modatepicer" readonly/>
            <span><a href="#"><i class="iconfont icon-arrows"></i></a></span>
	</section>
    <section class="pro-carStyle infor-title">
				<label>车牌号</label>
				<select name="choose" id="carStyleTitle">
					<option value="沪" selected="selected">沪</option>
					<option value="京">京</option>
					<option value="津">津</option>
					<option value="冀">冀</option>
					<option value="晋">晋</option>
					<option value="蒙">蒙</option>
					<option value="辽">辽</option>
					<option value="吉">吉</option>
					<option value="黑">黑</option>
					<option value="苏">苏</option>
					<option value="浙">浙</option>
					<option value="皖">皖</option>
					<option value="闽">闽</option>
					<option value="赣">赣</option>
					<option value="鲁">鲁</option>
					<option value="豫">豫</option>
					<option value="鄂">鄂</option>
					<option value="湘">湘</option>
					<option value="粤">粤</option>
					<option value="桂">桂</option>
					<option value="琼">琼</option>
					<option value="渝">渝</option>
					<option value="川">川</option>
					<option value="贵">贵</option>
					<option value="云">云</option>
					<option value="藏">藏</option>
					<option value="陕">陕</option>
					<option value="甘">甘</option>
					<option value="青">青</option>
					<option value="宁">宁</option>
					<option value="新">新</option>
					<option value="A">A</option>
					<option value="B">B</option>
					<option value="C">C</option>
					<option value="D">D</option>
					<option value="E">E</option>
					<option value="F">F</option>
					<option value="G">G</option>
					<option value="H">H</option>
					<option value="I">I</option>
					<option value="J">J</option>
					<option value="K">K</option>
					<option value="L">L</option>
					<option value="M">M</option>
					<option value="N">N</option>
					<option value="O">O</option>
					<option value="P">P</option>
					<option value="Q">Q</option>
					<option value="R">R</option>
					<option value="S">S</option>
					<option value="T">T</option>
					<option value="U">U</option>
					<option value="V">V</option>
					<option value="W">W</option>
					<option value="X">X</option>
					<option value="Y">Y</option>
					<option value="Z">Z</option>
				</select>
				<input type="text" placeholder="请输入您的车牌" id="carPlate" maxlength="6" class="required " <#if carInfo?? && carInfo.assetId?? && carInfo.assetId!='' && carInfo.plates?? && carInfo.plates!=''>readonly style="color:#999"</#if> />

			</section>
   
    <section class="infor-title">
			<label>联系人</label>
            <input type="text" maxlength="10" id="custName" name="custName" placeholder="请填写联系人姓名" value="<#if customInfo?? && customInfo.custName??>${customInfo.custName}</#if>" />
	</section>
    <section class="infor-title">
			<label>手机号</label>
			<input type="tel" maxlength="11" id="mobilePhone" name="mobilePhone" placeholder="请输入手机号" value="<#if customInfo?? && customInfo.mobilePhone??>${customInfo.mobilePhone}</#if>" readonly/>
            <input type="hidden" id="custId" name="custId" value="<#if customInfo?? && customInfo.custId??>${customInfo.custId}</#if>"/>
	</section>
    
    <!-- mode of payment -->
    <h2 class="servListTitle">支付方式</h2>
    <ul class="paymode">
    	<#if orderInfo.onlinePayDisplay>
    	<li class="on">
    		在线支付<s>在线支付享折扣</s><span class="ui-checkbox"><i class="iconfont icon-checked"></i></span>
    	</li>
    	</#if>
    	<#if orderInfo.storePayDisplay>
    	<li<#if orderInfo.onlinePayDisplay=false> class="on"</#if>>
    		到店支付<span class="ui-checkbox"><i class="iconfont icon-checked"></i></span>
    	</li>
    	</#if>
    </ul>
    
    <div id="payOnline" style="display:none;">
    <dl class="pay-online pay-money">
    	<#list products as product>
	    	<#if product.productPay??>
	    	<dt>
	    		<#if product.skuList?? && product.skuList?size gt 0>
	    			<#list product.skuList as sku>
	    			<span class="sku"><div>${sku.skuName}</div><div>${product.name}</div></span>
	    			</#list>
	    		<#else>
	    			<span>${product.name}</span>
	    		</#if>
	    		<ul>
	    			<li>${product.productPay.promotionName} <b>￥#{product.promotionPriceAfterPay?number;m2M2}</b></li>
	    			<#if product.promotionPrice!=product.promotionPriceAfterPay><li class="original-price">原价 ￥#{product.promotionPrice?number;m2M2}</li></#if>
	    		</ul>
	    	</dt>
	    	</#if>
    	</#list>
    	<dd>
    		<#if orderInfo.economyMoney?? && orderInfo.economyMoney?number!=0><s>在线支付为您节省#{orderInfo.economyMoney?number;m2M2}元</s></#if>
    		<span>合计<b>￥#{orderInfo.orderTotalMoneyOnlineAfterPay?number;m2M2}</b></span>
    	</dd>
    </dl>
    <#if orderInfo.hasUnPayProduct>
    <dl class="pay-money" style="margin-bottom:5rem">
    	<#list products as product>
	    	<#if !product.productPay??>
	    	<dt>
	    		<span>${product.name}</span>
	    		<ul>
	    			<li>
	    			<#if product.servicePirceType=0>
					￥#{product.promotionPrice?number;m2M2}
                    <#elseif product.servicePirceType=1>
					￥#{product.promotionPrice?number;m2M2}<b>起</b>
                    <#else>
					待定
                    </#if>
	    			</li>
	    		</ul>
	    	</dt>
	    	</#if>
	    </#list>
    	<dd>
    		<#if orderInfo.hasUnFixedProduct>
    			<span>以上项目到店支付，价格仅供参考</span>
    		<#else>
    			<span>合计<b>￥#{orderInfo.orderTotalMoneyOnlineStore?number;m2M2}</b></span>
    		</#if>
    	</dd>
    </dl>
    </#if>
    </div>
    
    <div id="payStore" style="display:none;">
    <dl class="pay-money" style="margin-bottom:5rem">
    	<#list products as product>
	    	<dt>
	    		<span>${product.name}</span>
	    		<ul>
	    			<li>
	    			<#if product.servicePirceType=0>
					￥#{product.promotionPrice?number;m2M2}
	                <#elseif product.servicePirceType=1>
					￥#{product.promotionPrice?number;m2M2}<b>起</b>
	                <#else>
					待定
	                </#if>
	    			</li>
	    		</ul>
	    	</dt>
	    </#list>
    	<dd>
    		<#if orderInfo.hasUnFixedProduct>
    			<span>以上项目到店支付，价格仅供参考</span>
    		<#else>
    			<span>合计<b>￥#{orderInfo.orderTotalMoneyStoreAll?number;m2M2}</b></span>
    		</#if>
    	</dd>
    </dl>
    </div>
        
	<div class="pay-confirm" data-lable="服务预约2/2-确认下单">
		<dl id="payConfirmOnline" style="display:none;">
			<#if orderInfo.hasUnPayProduct || orderInfo.hasUnFixedProduct>
				<dt>在线支付<b>￥#{orderInfo.payMoney?number;m2M2}</b></dt>
				<dd>其它项目需到店支付</dd>
			<#else>
				<#if orderInfo.hasEarnestPay>
					<dt>线上支付定金<b>￥#{orderInfo.payMoney?number;m2M2}</b></dt>
				<#else>
					<dt>在线支付<b>￥#{orderInfo.payMoney?number;m2M2}</b></dt>
				</#if>
				
				<#if orderInfo.balanceMoney?number gt 0>
					<dd>余额到店支付<b>￥#{orderInfo.balanceMoney?number;m2M2}</b></dd>
				</#if>
			</#if>
		</dl>
		<dl id="payConfirmStore" style="display:none;">
			<dt>以上项目需到店支付</dt>
		</dl>
		<input type="button" value="确认下单" class="ui-btn" id="saveConfirm">
	</div>
</form>  
<!-- 日历弹窗 -->
<div class="md-mask"></div>
<div id="mdModal" class="md-modal">
	<div class="md-modal-header">
		<h3 class="md-title">
			<span>选择日期</span>
		</h3>
		<a class="md-close" href="javascrip:;">取消</a>
		<button type="button" class="md-submit">确 定</button>
	</div>
	<div class="md-modal-body">
		<div class="md-content">
			<div class="md-select-date iscrollbar iscrollbar_1 ">
				<ul class="iscrollbar-con iscrollbar-con-1 md-select-date-list">
					<!--js生成-->
				</ul>
				<div class="md-data-selected"></div>
			</div>
			<div class="md-select-date iscrollbar iscrollbar_2">
				<ul class="iscrollbar-con iscrollbar-con-2 md-select-date-list">
					<li>上午</li>
					<li>下午</li>
				</ul>
				<div class="md-data-selected"></div>
			</div>
		</div>
		
	</div>
	
</div>

<script type="text/javascript" src="<@jci.domain url='/js/maintenance/jquery.select.js'/>"></script>
<script type="text/javascript" src="<@jci.domain url='/js/maintenance/iscroll.js'/>"></script>
<script type="text/javascript" src="<@jci.domain url='/js/maintenance/jquery.modatepicer.js'/>"></script>
<#include "/common/footer.ftl" encoding="UTF-8">
<script type="text/javascript">
	Date.prototype.Format = function(format) {
		var o = {
			"M+": this.getMonth() + 1, // month
			"d+": this.getDate(), // day
			"h+": this.getHours(), // hour
			"m+": this.getMinutes(), // minute
			"s+": this.getSeconds(), // second
			"q+": Math.floor((this.getMonth() + 3) / 3), // quarter
			"S": this.getMilliseconds()
		};
		if (/(y+)/.test(format))
			format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
		for (var k in o)
			if (new RegExp("(" + k + ")").test(format))
				format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
		return format;
	};
	
	function getPayStatus() {if($(".paymode li").eq(0).hasClass("on")){return 0} else { return -1 }}
	
	$(function(){
		
		if(_plates!==""){
			carB = _plates.substring(0,1);
			carE= _plates.substring(1);
			var str = /^[A-Za-z]*$/;
		if (str.test(carB))
		{
			$("#zh").hide()
			$("#en").show()
		}else{
			$("#zh").show()
			$("#en").hide()
		}

		for(var j = 0 ; j < $(".select_option li").length; j++){
			if($($(".select_option li")[j]).text()==carB){
				$($(".select_option li")[j]).addClass('selected').siblings().removeClass('selected');
			}
		}
		if(platesFg == true) { $('.select_showbox').css('color', '#999');}
		$('.select_showbox').text(carB);
		$("#carPlate").val(carE)
	}
	var opt = {};
	<#if orderInfo?? && orderInfo.orderDate??>
	 opt.sd = new Date('${orderInfo.orderDate}');
     opt.fg=true;
     opt.ap ="${orderInfo.timeFlag}";
	</#if>
	$('#demo_modatepicer').modatepicer(opt);
	
	//$("#carStyleContent").on('input propertychange', function() {
	//	$(this).val($(this).val().toUpperCase());
	//});
	
	$("#saveConfirm").click( function(){
		$("#carPlate").val($("#carPlate").val().toUpperCase());
	    
		var orderDate = $("#demo_modatepicer").data('val');
		var timeFlag = $("#demo_modatepicer").data('ap');// 上午下午
		var storeId=$("#storeId").val();//门店
		var carStyle=$("#carPlate").val().trim();
		var carPlate=$(".select_showbox").text()+$("#carPlate").val().trim();//车牌号
		var custId=$("#custId").val();//用户id
		var custName=$("#custName").val().trim();//联系人
		var mobilePhone=$("#mobilePhone").val().trim();//手机号
		var payStatus = getPayStatus(); //0：选中在线支付 -1：选中到店支付
		if(!storeId){
			comAlertObj("亲，请选择预约门店！");
			return false;
		}
		
		if(!orderDate){
			comAlertObj("亲，请选择到店时间！");
			return false;
		}
		
		if(!carStyle){
			comAlertObj("亲，请填写车牌号！");
			return false;
		}
		
		var isPlate = /^[A-Z_\u4e00-\u9fa5]{1}[A-Z]{1}[A-Z_0-9]{4}[A-Z_0-9_\u4e00-\u9fa5]{1}$/;
		if(!isPlate.test(carPlate)){
			comAlertObj("车牌格式错误！");
		    return false;
		}
	
		if(!custName){
			comAlertObj("亲，请填写联系人！");
			return false;
		}
		
		if(!mobilePhone){
			comAlertObj("亲，请填写手机号！");
			return false;
		}
		
		if( payStatus != 0 && payStatus != -1){
			comAlertObj("亲，请选择支付方式！");
			return false;
		}

		//var isMob = /^((\+?86)|(\(\+86\)))?(13[012356789][0-9]{8}|15[012356789][0-9]{8}|18[02356789][0-9]{8}|147[0-9]{8}|1349[0-9]{7})$/;
		//if(!isMob.test(mobilePhone)){
		//if(mobilePhone.length!=11){
		var isMobile = /^[0-9]{11}$/;
    	if(!isMobile.test(mobilePhone)){
			comAlertObj("亲，请填写正确的手机号！");
		    return;
		}
		
		var url = "${contextPath}/service/saveConfirm.htm";
		var param = {	
			"storeId":storeId,
		 	"orderDate":orderDate,
		 	"timeFlag":timeFlag,
		 	"plates":carPlate,
		 	"custName":custName,
		 	"mobilePhone":mobilePhone,
		 	"custId":custId,
		 	"payStatus": payStatus
		};
		
		// 防止重复点击
		$("#saveConfirm").prop("disabled", true);
		
		$.postajax(url, param, function(data){
			if(data.result == $.dataResult.FAILD){
				comAlertObj(data.msg);
			}else{
				/*
				if (localStorage) {
					localStorage.removeItem("tabStatus");
				}
				*/
				comAlertObj(data.msg);
				window.location.href=data.returnUrl;
			}
		},
		"",
		function(){
			$("#saveConfirm").prop("disabled", false);
		});
	});
  
	$(".pro-car").click( function(){
		toStore();
	});
	//$("#demo_modatepicer").val($(".iscrollbar-con li.cur").text()); 
		
	//车牌弹层充满整个屏幕
	$(".select_option").height($(window).height());
	
	<#if orderInfo.onlinePayDisplay>
		$("#payOnline").show();
		$("#payStore").hide();
		$("#payConfirmOnline").show();
		$("#payConfirmStore").hide();
	<#else>
		$("#payOnline").hide();
		$("#payStore").show();
		$("#payConfirmOnline").hide();
		$("#payConfirmStore").show();
	</#if>
});

function toStore(){
	$("#carPlate").val($("#carPlate").val().toUpperCase());
	
	var url="${contextPath}/service/toStore.htm";
	var orderDate = $("#demo_modatepicer").data('val');
	var timeFlag = $("#demo_modatepicer").data('ap');// 上午下午
	var storeId=$("#storeId").val();//门店
	var carPlate=$(".select_showbox").text()+$("#carPlate").val().trim();//车牌号
	var custId=$("#custId").val();//用户id
	var custName=$("#custName").val().trim();//联系人
	var mobilePhone=$("#mobilePhone").val().trim();//手机号
	var payStatus = getPayStatus(); //0：选中在线支付 -1：选中到店支付
	var param = {	
		"storeId":storeId,
	 	"orderDate":orderDate,
	 	"timeFlag":timeFlag,
	 	"plates":carPlate,
	 	"custName":custName,
	 	"mobilePhone":mobilePhone,
	 	"custId":custId,
	 	"payStatus": payStatus
	};
	
	$.postajax(url, param, function(data){
		if(data.result == $.dataResult.SUCCESS){
			window.location.href='${contextPath}/store/mylist.htm';
		}
	});
	
	
}

$(".paymode li").on("click", function(){
	$(this).addClass("on").siblings().removeClass("on");
	if($(this).index() === 0){
		$("#payOnline").show();
		$("#payStore").hide();
		$("#payConfirmOnline").show();
		$("#payConfirmStore").hide();
	} else {
		$("#payOnline").hide();
		$("#payStore").show();
		$("#payConfirmOnline").hide();
		$("#payConfirmStore").show();
	}
})

	
</script>
</body>
</html>