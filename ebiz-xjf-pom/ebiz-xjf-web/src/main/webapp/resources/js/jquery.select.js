(function($){

	$.fn.select2Div = function(options) {
	    var defaults = {
	    	'selectClass' : 'select_box',
	    	'disabledClass' : 'select_disabled',
	    	'showClass' : 'select_show',
	    	'optionClass' : 'select_option',
	    	'selectedClass' : 'selected',
	        'beforeClickFnc' : null,
	        'clickFnc' : null
	    };
	    var settings = $.extend({},defaults, options);//将一个空对象做为第一个参数
	    
	    (function(obj){

			//创建select容器，class为select_box，插入到select标签前
			var selectBox = $('<div></div>');//div相当于select标签
			selectBox.addClass(settings.selectClass).insertBefore(obj);
			if (obj.prop("disabled")) selectBox.addClass(settings.disabledClass);
			obj.hide();

			//显示框class为select_show,插入到创建的selectBox中
			var selectShow = $('<div></div>');//显示框
			selectShow.addClass(settings.showClass).appendTo(selectBox);

			//创建option容器，class为select_option，插入到创建的selectBox中
			var selectOptions = $('<ul></ul>');//创建option列表
			selectOptions.addClass(settings.optionClass).appendTo(selectBox);;
			createOptions(obj, selectOptions);//创建option

			//点击显示框,再点击不显示
			selectBox.on('click',function(){
				if (obj.prop("disabled")) return;
				selectOptions.is(":visible")?selectOptions.hide():selectOptions.show();
			});

			//点击选择项
			var selectOption = selectOptions.find('li');
			selectOption.on('click',function(){
				var value=$(this).val(),
					text=$(this).text();
				
				//触发自定义change事件
				if (selectShow.val() != value) {
					// 前处理
					if (typeof(settings.beforeClickFnc) == 'function') {
						settings.beforeClickFnc(value,text,function(){
							afterClick();
						});
						
						return;
					} else {
						afterClick();
					}

					// 后处理
					function afterClick() {
						$(this).addClass(settings.selectedClass)
							.siblings().removeClass(settings.selectedClass);
						selectShow.text(text).val(value);
					
						// 后处理
						if (typeof(settings.clickFnc) == 'function') {
							settings.clickFnc(value,text);
						}
					}
				}
			});
			
			//点击其他控件，则关闭当前控件
			//IOS必须增加touchend
			$(document).on('touchend click',function(e){
				if (selectBox.has(e.target).length==0) {
					selectOptions.hide();
				}
			});

			function createOptions(){
				//获取被选中的元素并将其值赋值到显示框中
				var options = obj.find('option'),
					selected_option = options.filter(':selected'),
					selected_index = selected_option.index();
				selectShow.text(selected_option.text()).val(selected_option.val());
				
				//为每个option建立个li并赋值
				for(var n = 0;n < options.length;n++){
					var tag_option=$('<li></li>'),//li相当于option
						txt_option = options.eq(n).text(),
						val_option = options.eq(n).val();
					tag_option.text(txt_option).val(val_option).appendTo(selectOptions);

					//为被选中的元素添加class为selected
					if(n == selected_index){
						tag_option.addClass(settings.selectedClass);
					}
				}
			}
			
		})($(this));
	};

})(jQuery);


