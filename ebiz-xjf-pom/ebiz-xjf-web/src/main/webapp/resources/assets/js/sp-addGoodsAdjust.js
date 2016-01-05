//通用表格多选效果
$("table td input[type='checkbox']").click(function(){
  var $span = $(this).parent();
  var $tr = $(this).closest("tr");
  if( $(this).prop("checked")){
      $tr.addClass("active");
      $span.addClass("checked");
  }else{
      $tr.removeClass("active");
      $span.removeClass("checked");
  }
});
$("table th input[type='checkbox']").click(function(){
  var $tr = $(this).closest("table").find("tbody tr");
  var $span = $(this).closest("table").find("tr .checker span");
  var $allRadio = $(this).closest("table").find("tbody :checkbox");
  if( $(this).prop("checked") ){
      $tr.addClass("active");
      $span.addClass("checked");
      $allRadio.prop("checked", true);
  }else{
      $tr.removeClass("active");
      $span.removeClass("checked");
      $allRadio.prop("checked", false);
  }
});
//商品选择弹窗下拉树
var setting = {
	check: {
		enable: true,
		chkboxType: {"Y":"", "N":""}
	},
	view: {
		dblClickExpand: false
	},
	data: {
		simpleData: {
			enable: true
		}
	},
	callback: {
		beforeClick: beforeClick,
		onCheck: onCheck
	}
};

 var zNodes =[
    { id:0, pId:null, name:"商品自然分类", open:true},
    { id:1, pId:0, name:"改装"},
    { id:11, pId:1, name:"改装"},
    { id:111, pId:11, name:"车内空间"},
    { id:1111, pId:111, name:"定制皮套"},
    { id:1112, pId:111, name:"定制3D脚垫"},
    { id:1113, pId:111, name:"定制丝圈脚垫"},
    { id:1114, pId:111, name:"定制坐垫"},
    { id:112, pId:11, name:"车身"},
    { id:1121, pId:112, name:"贴纸"},
    { id:1122, pId:112, name:"拉花"},
    { id:113, pId:11, name:"电子安全"},
    { id:1131, pId:113, name:"TPMS"},
    { id:2, pId:0, name:"线上精品"},
    { id:21, pId:2, name:"美容清洁"},
    { id:211, pId:21, name:"玻璃洗护"},
    { id:2111, pId:211, name:"玻璃镀膜"},
    { id:2112, pId:211, name:"玻璃防雾"},
    { id:2113, pId:211, name:"玻璃水"},
    { id:2114, pId:211, name:"雨刮精"}
];

function beforeClick(treeId, treeNode) {
	var zTree = $.fn.zTree.getZTreeObj("treeDemo");
	zTree.checkNode(treeNode, !treeNode.checked, null, true);
	return false;
}

function onCheck(e, treeId, treeNode) {
	var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
	nodes = zTree.getCheckedNodes(true),
	v = "";
	for (var i=0, l=nodes.length; i<l; i++) {
		v += nodes[i].name + ",";
	}
	if (v.length > 0 ) v = v.substring(0, v.length-1);
	var cityObj = $("#citySel");
	cityObj.attr("value", v);
}

function showMenu() {
	var cityObj = $("#citySel");
	var cityOffset = $("#citySel").offset();
	console.log( $("#menuContent").length );
	$("#menuContent").css({left:cityOffset.left + "px", top:cityOffset.top + cityObj.outerHeight() + "px"}).slideDown("fast");

	$("body").bind("mousedown", onBodyDown);
}
function hideMenu() {
	$("#menuContent").fadeOut("fast");
	$("body").unbind("mousedown", onBodyDown);
}
function onBodyDown(event) {
	if (!(event.target.id == "menuBtn" || event.target.id == "citySel" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length>0)) {
		hideMenu();
	}
}

$(function(){
    // initlayout and core plugins
    App.init();
    if ( $().datepicker) {
        $('.date-picker').datepicker({
            language:"zh-CN",
            rtl: App.isRTL(),
            autoclose: true
        });
    };

    $.fn.zTree.init($("#treeDemo"), setting, zNodes);

    var $addBtn = $( '#selectGoods' ),
    	$unSelectTable = $addBtn.parent().next( 'table' ),
    	$removeBtn = $( '#removeGoods' ),
    	$selectedTable = $removeBtn.parent().next( 'table' );

    $addBtn.on( 'click', function(){
    	$unSelectTable.find( 'tbody>tr' ).each(function( index, item ){
    		if( $(item).find( ':checkbox' ).prop( 'checked' ) ){
    			console.log( $(item).clone() );
    			$selectedTable.find( 'tbody' ).append( $(item).clone() );
    		}else{
    			$.Alert( '请选择商品！' );
    		}
    	});
    });

});