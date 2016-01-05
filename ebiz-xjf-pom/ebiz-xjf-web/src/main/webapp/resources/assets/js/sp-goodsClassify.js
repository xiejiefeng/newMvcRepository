$(function(){
    // initlayout and core plugins
    App.init();
    //ztree 示例
    var setting = {
        data: {
            simpleData: {
                enable: true
            }
        },
        callback: {
            onClick: zTreeOnClick
        }
    };

    var selectedNode;
        $treeInfo = $( '#treeInfo' ),
        $path = $treeInfo.find( '.form-control-static:eq(0)' ),
        $name = $treeInfo.find( 'input:eq(0)' ),
        $no = $treeInfo.find( 'input:eq(1)' ),
        $order = $treeInfo.find( 'input:eq(2)' ),
        $saveBtn = $treeInfo.find( 'button:eq(0)' ),
        $delBtn = $treeInfo.find( 'button:eq(1)' ),
        $addBtn = $treeInfo.find( 'button:eq(2)' );
    //获取节点路径
    function getPath( treeNode ){
        var path = treeNode.name;
        while( treeNode.getParentNode() ){
            path = treeNode.getParentNode().name + ' <span class="text-lightgrey">>></span> ' + path;
            treeNode = treeNode.getParentNode();
        };
        return path;
    };

    //节点点击事件
    function zTreeOnClick(event, treeId, treeNode) {
        console.log( treeNode );
        //显示树节点信息
        $treeInfo.show();
        //获取当前节点
        selectedNode = treeNode;
        //重新赋值
        $path.html( getPath( treeNode ) );
        $name.val( treeNode.name );
        $no.val( treeNode.id );
        //根节点禁用保存按钮
        treeNode.level == 0 ? $saveBtn.addClass( 'disabled' ).prop( 'disabled', true ) : $saveBtn.removeClass( 'disabled' ).removeProp( 'disabled' );
        //
        $delBtn.removeClass( 'disabled' ).removeProp( 'disabled' );
        $addBtn.removeClass( 'disabled' ).removeProp( 'disabled' );
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
    $.fn.zTree.init( $("#treeDemo"), setting, zNodes );
    var treeObj = $.fn.zTree.getZTreeObj( "treeDemo" );

    //保存
    $saveBtn.on( 'click', function(){
        var msg;
        $delBtn.prop( 'disabled' ) ? ( msg = '数据已添加！' ) : ( msg = '数据已更新！' );
        console.log( msg );
        $.Alert( msg, '', function(){
            $treeInfo.hide();
            treeObj.reAsyncChildNodes(null, "refresh");
        });
        /*$.Alert( '数据已更新！', '', function(){
            $treeInfo.hide();
            treeObj.reAsyncChildNodes(null, "refresh");
        });*/
    });
    //删除
    $delBtn.on( 'click', function(){
        selectedNode.isParent ? $.Alert( '当前商品分类还包含子商品分类，请先删除对应的子结点！' ) : $.Confirm( '您确定要删除这条信息？' );
    });
    //增加
    $addBtn.on( 'click', function(){
        $delBtn.prop( 'disabled', true ).addClass( 'disabled' );
        $addBtn.prop( 'disabled', true ).addClass( 'disabled' );
    })
});