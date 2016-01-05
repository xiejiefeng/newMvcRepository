<!DOCTYPE html>
<html>
<head>
    <title>车享家阶梯团购 </title>
    <meta name="description" content="车享家阶梯团购，人越多价越低，嘉实多小保养套餐6折起！" />
    <meta name="keywords" content="车享家，阶梯团购，嘉实多小保养，300人成团价288元，爱车保养，源自上汽, 分享，我要参团" />
    <#include "/common/active_header.ftl" encoding="UTF-8">
    <link rel="stylesheet" href="<@jci.domain url='/active/css/jttg.css'/>">
    
    
</head>

<body>
	<img style="display:none;" src="<@jci.domain url='/active/image/jttg/share_icon.jpg'/>" />
	<div class="p-banner">
		<img src="<@jci.domain url='/active/image/jttg/top_banner.png'/>" />
	</div>
	<div class="p-content">
		<div class="p-tuan-content-ct">
			<div class="p-tuan-content">
				<div class="service-title" >嘉实多半合成小保养套餐（原价468元）</div>
				<div class="service-sub-title">含4L嘉实多磁护机油和一个机滤</div>
				
				<div class="service-img"><img src="<@jci.domain url='/active/image/jttg/active_2.png'/>" /></div>
				<div class="p-tuan-text-ct">
					<img src='<@jci.domain url='/active/image/jttg/price_content.png'/>' />
					<!-- <table style="width:100%;"><tr>
					<td><div class="p-tuan-discount-item">
					  <img class="discount-img-1" src="<@jci.domain url='/active/image/jttg/8.0.png'/>"  />
					  <div class="price">￥<span class="price-num">368</span></div>
					  <div class="price-desc">
					  	<span>530人成团价</span></br>
					  	<del>原价468元</del>
					  </div>
					</div></td>
					<td><div class="p-tuan-discount-item">
					  <img class="discount-img-2" src="<@jci.domain url='/active/image/jttg/6.0.png'/>" />
					  <div class="price active">￥<span class="price-num active">288</span></div>
					  <div class="price-desc">
					  	<span>300人成团价</span></br>
					  	<del>原价468元</del>
					  </div>
					</div></td>
					</tr></table>  -->
				</div>
				<div class="end-desc dao-ji-shi" >
						已参团<a class="cls-4" id="sign-up-num"><i class="am-icon-spinner am-icon-spin"></i></a>人
						<a id="dao-ji-shi-desc" style="color:#333"> </a>
				</div>
				<div class="btns-ct"  >
						<a href="/active/jttg/active_detail.htm">查看服务详情</a>&nbsp;&nbsp;&nbsp;
						<!--<a href="/active/jttg/next_active.htm"  >&nbsp;&nbsp;&nbsp;下期预告&nbsp;&nbsp;&nbsp;</a> -->
				</div>
				
			</div>
		</div>
		<div class="p-tuan-desc-ct">
			<div class="p-tuan-desc-content">
			
				<div class="content-title">什么是阶梯团？</div>
				<div class="content-text">人数越多越便宜，最终购买价格为团购结束后的价格，视最终成团人数决定。<br/>
				用户只需要输入手机号即可预定，无需支付定金。
				</div>
				
				<img src="<@jci.domain url='/active/image/jttg/dash_line.png'/>" class="dash-line" />
				<div class="content-title">如何参加阶梯团？</div>
				
				<img class="add-way" src="<@jci.domain url='/active/image/jttg/cantuanliucheng.png'/>" />
				<div class="time-ax-ct">
				
				<img class="time-ax" src="<@jci.domain url='/active/image/jttg/time_ax.png'/>" />
				</div>
				<div class="time-ax-desc content-text">
					<table><tr>
						<td class="cls-1">点击参团</td><td class="cls-2">邀好友参团</td>
						<td>团购结束<br/>发放券码</td><td>凭券码到门<br/>店享团购价</td>
					</tr></table>
				</div>
				
				<img src="<@jci.domain url='/active/image/jttg/dash_line.png'/>" class="dash-line"  />
				<div class="content-title">团购的服务有效期多久？</div>
				<div class="content-text">
					团购券使用时间：<br/>
					2015年11月20日-2016年6月30日，除周六、周日及法定节假日外均可使用。
				</div>
				
				<img src="<@jci.domain url='/active/image/jttg/dash_line.png'/>" class="dash-line"  />
				<div class="active-rules">
					<div class="content-title">活动规则</div>
					<div class="content-text">1.同一用户只能预订一个团购名额。</div>
					<div class="content-text">2.参加团购的服务商品不与其他任何优惠同享。</div>
					<div class="content-text">3.客户进店前需在微信提前预约门店及进店时间。</div>
					<div class="content-text">4.团购商品服务可在车享家所有门店使用，车享家门店详情参考车享家介绍页面。</div>
					<div class="content-text">5.团购结束后，车享家在10个工作日内发送团购券码到客户手机。</div>
					<div class="content-text">6.用户参团时需提供正确的手机号，便于接收团购券码。因用户手机号错误导致无法接收券码的，车享家不承担相关责任。</div>
					<div class="content-text">7.本活动最终解释权归车享家所有。</div>
					<div class="content-text service-phone">车享家客服热线： ${crmTel}</div>
				</div>
			</div>
		</div>
		<br/><br/>
	</div>
	
    <div class="p-bottom">
		<div class="p-bottom-left " onclick="$.shareCode();">
		
			<img src="<@jci.domain url='/active/image/jttg/share.png'/>" /><br/><span>分享</span>
		</div>
		
		<img class="cls-3" src="<@jci.domain url='/active/image/jttg/bottom-sp-line.png'/>" />
		<div class="p-bottom-right">
			<div id="baoming_btn" class="p-bottom-button">我要参团</div>
		</div>
	</div>
	
	
	<script type="tpl" id="baoming_tpl">
	 	<form class="tm-form" >
			  	<div class="form-field"><label>手机号：</label><input type="tel" name="mobile" value="" /></div>
			  	<div class="form-field" style="width:52%;float:left;"><label>验证码：</label><input name="code" class="code-input"/></div>
			  	<div class="send-code-btn">发送验证码</div>
			  	<div class="tip-field"><span>请输入正确的手机号，团购成功后将发送相关券码至该手机。</span></div>
			  	
			  	<div class="form-field layer-btn"><button type="button" id="baoming_submit">确  定</button></div>
	  	</form>
	</script>
	<script type="tpl" id="baoming_success_tpl">
	 	<div class="layer-title">恭喜您参团成功</div>
	 	<div class="layer-content">参团人数达300人可享受288元团购价，快叫上小伙伴一起参加吧。</div>
	 	<div class="layer-btn"><button type="button" onclick="$.shareCode();">去喊小伙伴</button></div>
	</script>
	
	<script type="tpl" id="next_active_tpl">
		
	</script>
	
   
    <script src="<@jci.domain url='/active/js/jquery.min.js'/>"></script>
   
    <script src="<@jci.domain url='/active/plugin/layer/layer.m.js'/>"></script>  
     
	<script src="<@jci.domain url='/active/js/jquery.cookie.js'/>"></script> 
	
	<script src="<@jci.domain url='/active/js/jquery.ext.js'/>"></script>
	
	<script>
		var active_id= "${active.id}";
		var start_time= "${startTime}";
		var end_time= "${endTime}";
		var send_captcha_url= "/active/jttg/send_captcha.htm";  //发送手机验证码
		var sign_up_url= "/active/jttg/sign_up.htm";  //报名请求
		var get_members_num_url= "/active/jttg/get_members_num.htm"; //获取已参团人数
		var check_sign_up_url= "/active/jttg/is_already_signUp.htm"; //检查该手机号是否已经报名
		
		$(function(){
			
			setTimeout(function(){
				$("title").html("车享家喊你来参团，嘉实多小保养288元起，震撼优惠，别错过！");
			},1000);
			
			var user_id= $.cookie('Txhj882Bfuud_cx_id');
			var now_time= (new Date()).getTime();
			if($.isEmptyObject(end_time)){  //表示活动已经过期
				$("#dao-ji-shi-desc").html("活动报名已结束");
				$("#baoming_btn").addClass("btn-disable").html("活动报名已结束");
			}else if(now_time<$.string2DateTime(start_time).getTime()){ //表示活动还没有开始
				window.it= setInterval(function(){
					showDaojishi(start_time,'开始');
					if(window.left_times<=0){
						showDaojishi(end_time,'结束');
						$("#baoming_btn").removeClass("btn-disable").html("我要参团");
					}
				},1000);
				$("#baoming_btn").addClass("btn-disable").html("即将开始");
			}else if(now_time>=$.string2DateTime(end_time).getTime()){
				$("#dao-ji-shi-desc").html("活动报名已结束");
				$("#baoming_btn").addClass("btn-disable").html("活动报名已结束");
			}else{
				window.it= setInterval(function(){
					showDaojishi(end_time,'结束');
					if(window.left_times<=0){
						$("#dao-ji-shi-desc").html("活动报名已结束");
						$("#baoming_btn").addClass("btn-disable").html("活动报名已结束");
						clearInterval(window.it);
					}
				},1000);
				if(!$.isEmptyObject(user_id)){
						//验证该手机号是否已经报过名了
						$.getJSON(check_sign_up_url,{cxId: user_id},function(json){
							if(json.result==1){ //已经报过名了
								$("#baoming_btn").addClass("btn-disable").html("我已报名");
							}
						});
				}
			}
			getSignUpMemberTotal();
		
			//轮询 实时查看当前已经报名的人数
			setInterval(function(){
				getSignUpMemberTotal();
			},30*1000);
			
			
			
			$("#baoming_btn").click(function(){
			
				if($(this).hasClass("btn-disable")){
					return false;
				}
				$.openLayer($("#baoming_tpl").html(),function(){
				
					
					$(".send-code-btn").click(function(){
						var sendCodeBtn= $(this);
						var mobile= sendCodeBtn.closest("form").find("input[name='mobile']").val();
						//var telReg = !!mobile.match(/^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/);
						if(mobile.length!=11){
							$.tipShow('请输入正确的手机号！');
							return false;
						}
						if(!sendCodeBtn.data("stop")){
							
							
							//验证该手机号是否已经报过名了
							$.getJSON(check_sign_up_url,{mobile: mobile},function(json){
								if(json.result==1){
									$.tipShow(json.msg);
								}else{
									delayBtn(sendCodeBtn);
									//还未报名，开始发送验证码
									$.ajaxPost(send_captcha_url,{mobile: mobile},function(json){
										if(json.result==1){
											$.tipShow('验证码已发送！');
										}else{
											$.tipShow('验证码发送失败！');
										}
										
									});
								}
								
							});
						}
						return false;
					
					});
				
					$("#baoming_submit").click(function(){
						var mobile= $(this).closest("form").find("input[name='mobile']").val();
						var code=   $(this).closest("form").find("input[name='code']").val();
						if($.isEmptyObject(mobile)){
							$.tipShow('请输入正确的手机号！');
							return false;
						}
						if($.isEmptyObject(code)){
							$.tipShow('请输入验证码！');
							return false;
						}
						$.ajaxPost(sign_up_url,{mobile: mobile,captcha: code,activeId: active_id},function(json){
							if(json.result==1){  //报名成功
								$.cookie('Txhj882Bfuud_cx_id', json.obj);
								$.openLayer($("#baoming_success_tpl").html());
							}else{
								$.tipShow(json.msg);
							}
								
						});
						
						
						return false;
					
					});
				});
			});
			
		
		});
		
		function showNextActive(){
				$.openLayer($("#next_active_tpl").html());
		}
		
		//纯粹的显示倒计时
		function showDaojishi(end_time,status){
				var now= new Date();
				end_time= $.string2DateTime(end_time);
				var times = window.left_times = end_time.getTime() - now.getTime();
				
				var left_days = fullNumber(parseInt(times / (1000 * 60 * 60 * 24))); //剩余天数
				var left_hours= fullNumber(parseInt((times-left_days*24*60*60*1000)/(60*60*1000)));
				var left_minite= fullNumber(parseInt((times-left_days*24*60*60*1000-left_hours*60*60*1000)/(60*1000)));
				var left_second= fullNumber(parseInt((times-left_days*24*60*60*1000-left_hours*60*60*1000-left_minite*60*1000)/1000));
				
				var _html= '距<span class="active-state">'+status+'</span>剩<span num="day">'+left_days.substr(0,1)
				+'</span><span>'+left_days.substr(1,1)+'</span>天<span num="hour">'+left_hours.substr(0,1)+'</span><span>'+left_hours.substr(1,1)
				+'</span>时<span num="minite">'+left_minite.substr(0,1)+'</span><span>'+left_minite.substr(1,1)+'</span>分<span num="second">'
				+left_second.substr(0,1)+'</span><span>'+left_second.substr(1,1)+'</span>秒';
				$("#dao-ji-shi-desc").html(_html);
				
		}
		function getSignUpMemberTotal(){
					$.ajax({
			            url:get_members_num_url,
			            async:true,
			            type:'get',
			            dataType:"json",
			        	cache:false,
			        	error : function handleAjaxError(xhr, textStatus, error) {
						},
			            success : function(json) {
			            	$("#sign-up-num").html(json.obj);
			            }
			        });
		}
		function delayBtn(dom){
			dom.html("<span class='timer-number'>60</span>秒后可重发");
			var iv= setInterval(function(){
				var t_dom= $(".timer-number");
				var t= parseInt(t_dom.html());
				if(t!=0){
					t_dom.html(t-1);
				}else{
					dom.html("发送验证码");
					dom.data("stop",false);
					clearInterval(iv);
					return false;
				}
				
			},1000);
			dom.data("stop",true);
		}
		function fullNumber(num){
			if(num<10){
				num= '0'+num;
			}else{
				num= ''+num;
			}
			return num;
		}
	</script>
	
</body>

</html>
