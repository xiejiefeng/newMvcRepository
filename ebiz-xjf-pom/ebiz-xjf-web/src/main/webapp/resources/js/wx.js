var CXJ_WX = null;
$(function(){
	CXJ_WX = (function(){
		var _opt;
		
		// 初始化
		_config = function(){
			// 注入权限验证配置
			wx.config({
		      debug: false,
		      appId: _opt.config.appId,
		      timestamp: _opt.config.timestamp,
		      nonceStr: _opt.config.nonceStr,
		      signature: _opt.config.signature,
		      jsApiList: [
		        'onMenuShareTimeline',
		        'onMenuShareAppMessage',
		        'onMenuShareQQ',
		        'onMenuShareWeibo',
		        'onMenuShareQZone'
		      ]
			});
			
			// 处理成功验证
			wx.ready(function(){
				if (_opt.share) {
					_shareEvent();
				}
			});
			
			// 处理失败验证
			wx.error(function(res){
				//alert(JSON.stringify(res));
			});
		};
		
		// 分享事件
		_shareEvent = function() {
			// 监听“分享给朋友”，按钮点击、自定义分享内容及分享结果接口
			_menuShareAppMessage = function() {
				var apiName = "分享给朋友";
			    wx.onMenuShareAppMessage({
			      title: _opt.share.title,
			      desc: _opt.share.desc,
			      link: _opt.share.link,
			      imgUrl: _opt.share.imgUrl,
			      trigger: function (res) {
			        // 不要尝试在trigger中使用ajax异步请求修改本次分享的内容，因为客户端分享操作是一个同步操作，这时候使用ajax的回包会还没有返回
			        trigger(res, apiName);
			      },
			      success: function (res) {
			        success(res, apiName);
			      },
			      cancel: function (res) {
			        cancel(res, apiName);
			      },
			      fail: function (res) {
			        fail(res, apiName);
			      }
			    });
		    }

			// 监听“分享到朋友圈”按钮点击、自定义分享内容及分享结果接口
			_menuShareTimeline = function() {
				var apiName = "分享到朋友圈";
			    wx.onMenuShareTimeline({
			      title: _opt.share.title,
			      link: _opt.share.link,
			      imgUrl: _opt.share.imgUrl,
			      trigger: function (res) {
			        // 不要尝试在trigger中使用ajax异步请求修改本次分享的内容，因为客户端分享操作是一个同步操作，这时候使用ajax的回包会还没有返回
			        trigger(res, apiName);
			      },
			      success: function (res) {
			        success(res, apiName);
			      },
			      cancel: function (res) {
			        cancel(res, apiName);
			      },
			      fail: function (res) {
			        fail(res, apiName);
			      }
			    });
		    }

			// 监听“分享到QQ”按钮点击、自定义分享内容及分享结果接口
			_menuShareQQ = function() {
				var apiName = "分享到QQ";
			    wx.onMenuShareQQ({
			      title: _opt.share.title,
			      desc: _opt.share.desc,
			      link: _opt.share.link,
			      imgUrl: _opt.share.imgUrl,
			      trigger: function (res) {
			        trigger(res, apiName);
			      },
			      complete: function (res) {
			        complete(res, apiName);
			      },
			      success: function (res) {
			        success(res, apiName);
			      },
			      cancel: function (res) {
			        cancel(res, apiName);
			      },
			      fail: function (res) {
			        fail(res, apiName);
			      }
			    });
		    }
		  
			// 监听“分享到微博”按钮点击、自定义分享内容及分享结果接口
			_menuShareWeibo = function() {
				var apiName = "分享到微博";
			    wx.onMenuShareWeibo({
			      title: _opt.share.title,
			      desc: _opt.share.desc,
			      link: _opt.share.link,
			      imgUrl: _opt.share.imgUrl,
			      trigger: function (res) {
			        trigger(res, apiName);
			      },
			      complete: function (res) {
			        complete(res, apiName);
			      },
			      success: function (res) {
			        success(res, apiName);
			      },
			      cancel: function (res) {
			        cancel(res, apiName);
			      },
			      fail: function (res) {
			        fail(res, apiName);
			      }
			    });
		    }

			// 监听“分享到QZone”按钮点击、自定义分享内容及分享接口
			_menuShareQZone = function() {
				var apiName = "分享到QZone";
			    wx.onMenuShareQZone({
			      title: _opt.share.title,
			      desc: _opt.share.desc,
			      link: _opt.share.link,
			      imgUrl: _opt.share.imgUrl,
			      trigger: function (res) {
			        trigger(res, apiName);
			      },
			      complete: function (res) {
			        complete(res, apiName);
			      },
			      success: function (res) {
			        success(res, apiName);
			      },
			      cancel: function (res) {
			        cancel(res, apiName);
			      },
			      fail: function (res) {
			        fail(res, apiName);
			      }
			    });
		    }
		    
		    function trigger(res, apiName) {
		    	//alert("trigger");
		    	//alert(JSON.stringify(res));
		    }
		    function complete(res, apiName) {
		    	//alert("complete");
		    	//alert(JSON.stringify(res));
		    }
		    function success(res, apiName) {
		    	//alert("success");
		    	//alert(JSON.stringify(res));
		    	var url = $.context+"/jsapi/share.htm";
		    	var param = {
		    			"apiName" : apiName,
		    			"url" : _opt.config.url
		    	}
		    	// 服务器统计
				$.postajax(url, param, function(data){
					if(data.result == $.dataResult.SUCCESS){
					}
				});
		    	var title = $("title").text();
		    	// 百度统计
		    	_hmt.push(['_trackEvent', 'jsapi', 'share', title+'-'+apiName]);
		    }
		    function cancel(res, apiName) {
		    	//alert("cancel");
		    	//alert(JSON.stringify(res));
		    }
		    function fail(res, apiName) {
		    	//alert("fail");
		    	//alert(JSON.stringify(res));
		    }

			_menuShareAppMessage();
			_menuShareTimeline();
			_menuShareQQ();
			_menuShareWeibo();
			_menuShareQZone();
		};
		
		return {
			init : function(opt) {
				if (opt) {
					_opt = opt;
					
					// 初始化
					if (_opt.config) {
						_config();
					}
				}
			}
		};
	})();
});