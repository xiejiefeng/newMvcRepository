<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script type="text/javascript" src="<@jci.domain url='/js/wx.js'/>"></script>
<script type="text/javascript">
$(function(){
	var config = {
		appId: '${wxAppId}',
		timestamp: ${wxTimestamp},
      	nonceStr: '${wxNonceStr}',
      	signature: '${wxSignature}',
      	url: '${wxUrl}'
	};
	var share = {
		title: '${shareTitle}',
		desc: '${shareDesc}',
		link: '${shareLink}',
		imgUrl: '${shareImgUrl}'
	};
	
	var opt = {
		"config" : config,
		"share" : share
	}
	CXJ_WX.init(opt);
});
</script>