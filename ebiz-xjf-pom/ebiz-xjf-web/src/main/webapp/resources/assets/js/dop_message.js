//重写jquery load
jQuery.fn.load = function( url, params, callback ) {
	if ( typeof url !== "string" && _load ) {
		return _load.apply( this, arguments );
	}

	var selector, response, type,
		self = this,
		off = url.indexOf(" ");

	if ( off >= 0 ) {
		selector = url.slice( off, url.length );
		url = url.slice( 0, off );
	}

	// If it's a function
	if ( jQuery.isFunction( params ) ) {

		// We assume that it's the callback
		callback = params;
		params = undefined;

	// Otherwise, build a param string
	} else if ( params && typeof params === "object" ) {
		type = "POST";
	}

	// If we have elements to modify, make the request
	if ( self.length > 0 ) {
		jQuery.ajax({
			url: url,
			timeout : 5000,
			error : function (xhr, textStatus, error) {
				if (textStatus === "timeout") {
					callback=function(){
						$.dopErr("连接超时!请稍后再试!!!");
					};
				} else if (textStatus == "error") {
					if(xhr.status!=0){
						callback=function(){
							$.dopErr("系统繁忙!!!,请稍后再试!!!", null);
						};
					}
					
				}
			},
			// if "type" variable is undefined, then "GET" method will be used
			'type': type,
			dataType: "html",
			data: params
		}).done(function( responseText ) {

			// Save response for use in complete callback
			response = arguments;

			self.html( selector ?

				// If a selector was specified, locate the right elements in a dummy div
				// Exclude scripts to avoid IE 'Permission Denied' errors
				jQuery("<div>").append( jQuery.parseHTML( responseText ) ).find( selector ) :

				// Otherwise use the full result
				responseText );

		}).complete( callback && function( jqXHR, status ) {
			self.each( callback, response || [ jqXHR.responseText, status, jqXHR ] );
		});
	}

	return this;
};
//dataTable进度条扩展
/*jQuery.fn.dataTableExt.oApi.fnProcessingIndicator = function(oSettings, onoff) {
	if (typeof (onoff) == 'undefined') {
		onoff = true;
	}
	this.oApi._fnProcessingDisplay(oSettings, onoff);
};*/

// jquery 跳转扩展
$.ajaxSetup({

	contentType : "application/x-www-form-urlencoded;charset=utf-8",
	complete : function(XMLHttpRequest, textStatus) {

		var sessionstatus = XMLHttpRequest.getResponseHeader("sessionstatus"); // 通过XMLHttpRequest取得响应头，sessionstatus，
		if (sessionstatus == "timeout") {
			// 如果超时就处理 ，指定要跳转的页面
			window.location.replace(top.location.href);
		}
	}
});
// alert编写
jQuery.dopAlert = function(message, imageUrl) {
	var page_content = $(document.body);// $("div[class = 'page-content']");
	var alertMessage = '确定要关闭吗？ ';
	var imageTag = '';
	if (message) {
		alertMessage = message;
	}
	if (imageUrl) {
		imageTag = "<img src='" + imageUrl + "' />";
	}
	var content = '<div id="dop_alert_Modal" class="modal fade" aria-hidden="true" role="basic" tabindex="-1" style="display: none;z-index:100001!important;"><div class="modal-dialog" style="width: 300px;margin-top:140px;"><div class="modal-content"><div class="modal-header">	<button class="close" aria-hidden="true" onclick="$.dopAlert.destoryAlert()" type="button"></button><h4 class="modal-title" style="text-align:left;">提示</h4></div><div class="modal-body"> '
			+ imageTag
			+ alertMessage
			+ '</div><div class="modal-footer"><button class="btn blue" type="button" onclick="$.dopAlert.destoryAlert()">确定</button></div></div></div></div>';
	// 添加alert弹出框
	var dop_alert_Modal = [];
	function addAlert() {
		page_content.append(content);
		var dop_alert_Modal_Interval = window.setInterval(function() {
			dop_alert_Modal = $('#dop_alert_Modal');
			if (dop_alert_Modal.length > 0) {
				dop_alert_Modal.modal({
					backdrop : 'static',
					keyboard : false
				});
				dop_alert_Modal.on('hidden.bs.modal', function(e) {
					dop_alert_Modal.remove();
				});
				dop_alert_Modal.modal("show");
				clearInterval(dop_alert_Modal_Interval);
			}
		}, 50);
	}

	addAlert();
};
// 销毁alert弹出框
jQuery.dopAlert.destoryAlert = function() {
	$('#dop_alert_Modal').modal('hide');
};

// confirm编写
jQuery.dopConfirm = function(message, imageUrl, fn) {
	var page_content = $(document.body);// $("div[class = 'page-content']");
	var alertMessage = '确定要操作吗？ ';
	var r;
	var imageTag = '';

	if (message) {
		alertMessage = message;
	}
	if (imageUrl) {
		imageTag = "<img src='" + imageUrl + "' />";
	}
	var content = '<div id="dop_confirm_Modal" class="modal fade" aria-hidden="true" role="basic" tabindex="-1" style="display: none;z-index:100001!important;"><div class="modal-dialog" style="width: 300px;margin-top:140px;"><div class="modal-content"><div class="modal-header">	<h4 class="modal-title" style="text-align:left;">提示</h4></div><div class="modal-body"> '
			+ imageTag
			+ alertMessage
			+ '</div><div class="modal-footer"><button class="btn blue" data-dismiss="modal" id="okDopConfirmButton" type="button">确定</button><button class="btn default" type="button" id="destoryDopConfirmButton">取消</button></div></div></div></div>';
	// 添加confirm弹出框
	var dop_Confirm_Modal = [];
	function addConfirm() {
		page_content.append(content);
		var dop_confirm_Modal_Interval = window.setInterval(function() {
			dop_Confirm_Modal = $('#dop_confirm_Modal');
			if (dop_Confirm_Modal.length > 0) {
				dop_Confirm_Modal.modal({
					backdrop : 'static',
					keyboard : false
				});
				dop_Confirm_Modal.on('hidden.bs.modal', function(e) {
					dop_Confirm_Modal.remove();
				});
				dop_Confirm_Modal.modal("show");
				$("#destoryDopConfirmButton").bind("click", function() {
					$.dopConfirm.destoryConfirm();
					callBack(false);
				});
				$("#okDopConfirmButton").bind("click", function() {
					callBack(true);
				});
				clearInterval(dop_confirm_Modal_Interval);
			}
		}, 50);
	}
	// 处理回调
	function callBack(r) {
		fn(r);
	}

	addConfirm();
};
// 销毁confirm弹出框
jQuery.dopConfirm.destoryConfirm = function() {
	$('#dop_confirm_Modal').modal('hide');
};

// errAlert编写
jQuery.dopErr = function(message, imageUrl) {
	var page_content = $(document.body);// $("div[class = 'page-content']");
	var alertMessage = '关闭 ';
	var imageTag = '';
	if (message) {
		alertMessage = message;
	}
	if (imageUrl) {
		imageTag = "<img src='" + imageUrl + "' />";
	}
	var content = '<div id="dop_err_Modal" class="modal fade" aria-hidden="true" role="basic" tabindex="-1" style="display: none;"><div class="modal-dialog" style="width: 400px;margin-top:140px;"><div class="modal-content"><div class="modal-header">	<button class="close" aria-hidden="true" onclick="jQuery.dopErr.destoryAlert()" type="button"></button><h4 class="modal-title" style="text-align:left;">异常信息</h4></div><div class="modal-body"> '
			+ imageTag
			+ '<div  style="resize:none; border:1px solid #CCC;width:338px;margin-bottom:-20px; height:180px; overflow:auto">'
			+ alertMessage
			+ '</div>'
			+ '</div><div class="modal-footer"><button class="btn blue" type="button" onclick="jQuery.dopErr.destoryAlert()">确定</button></div></div></div></div>';
	// 添加alert弹出框
	var dop_err_Modal = [];
	function addAlert() {
		page_content.append(content);
		var dop_alert_Modal_Interval = window.setInterval(function() {
			dop_err_Modal = $('#dop_err_Modal');
			if (dop_err_Modal.length > 0) {
				dop_err_Modal.modal({
					backdrop : 'static',
					keyboard : false
				});
				dop_err_Modal.on('hidden.bs.modal', function(e) {
					dop_err_Modal.remove();
				});
				dop_err_Modal.modal("show");
				clearInterval(dop_alert_Modal_Interval);
			}
		}, 50);
	}

	addAlert();
};
// 销毁ErrAlert弹出框
jQuery.dopErr.destoryAlert = function() {
	 $('#dop_err_Modal').modal("hide");
};
