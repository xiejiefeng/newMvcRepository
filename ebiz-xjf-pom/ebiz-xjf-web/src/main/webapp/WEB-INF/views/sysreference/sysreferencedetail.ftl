<!DOCTYPE html>
<html>
<head>
    <title>车享家</title>
    <#include "/common/top.ftl" encoding="UTF-8">
    <style>
    html,
    body {
        height: 100%;
    }
    </style>
</head>
<#import "/common/pager.ftl" as pager> 
<body>
<div class="page-wrap form-horizontal">
<form id="sysReferenceForm" method="post" class="form-horizontal margin-top-10" action="${contextPath}/sysReference/referenceDetail.htm">
    <div class="form-group clearfix">
        <div class="col-md-4 padding-left-0">
            <label class="control-label col-md-4 text-right">编码：</label>
            <div class="col-md-8 padding-left-0">
            	
                <input type="hidden" name="refId" value="${queryVo.refId}" id="sys_ref_id">
                <input type="hidden" name="refCode" value="${queryVo.refCode}">
                <input type="text" class="form-control" value="${queryVo.refCode}" disabled>
            </div>
        </div>
        <div class="col-md-4 padding-left-0">
            <label class="control-label col-md-4  text-right">名称：</label>
            <div class="col-md-8 padding-left-0">
           	 	<input type="hidden" name="refName" value="${queryVo.refName}">
                <input type="text" class="form-control" value="${queryVo.refName}" disabled>
            </div>
        </div>
        <div class="col-md-4 padding-left-0">
            <label class="control-label col-md-4  text-right">关键字：</label>
            <div class="col-md-8 padding-left-0">
                <input type="text" class="form-control" id="keyValue" name="keyValue" value="${queryVo.keyValue}">
            </div>
        </div>
    </div>
    <div class="form-group clearfix">
        <div class="col-md-12 text-right padding-right-30">
            <button type="button" id="queryInfo" onclick="submitForm();" class="btn blue"><i class="fa fa-search"></i> 查询</button>
        </div>
    </div>
    <div class="page-wrap form-horizontal">
        <div class="table-wrap" id="sample_2">
            <div class="table-tool">
                <a href="javascript:void(0)" onclick="detail_show_pop('add');" class="btn green btn-sm" data-toggle="modal"><i class="fa fa-plus"></i> 新增参照信息</a>
                <a href="javascript:void(0)" onclick="detail_show_pop('modify');" class="btn green btn-sm" data-toggle="modal"><i class="fa fa-edit"></i> 修改</a>
                <!--<a id="delBtn" class="btn red btn-sm"><i class="fa fa-times" ></i> 停用</a>-->
                <a id="returnBtn" class="btn default btn-sm"><i class="fa fa-undo"></i> 返回</a>
                <a id="pop_href" style="display:none;" href="#infMaintenance" data-toggle="modal"></a>
            </div>
            <table id="grid01" class="table table-striped table-bordered table-hover text-center">
                <thead>
                    <tr>
                        <th class="text-center" width="15%">选择</th>
                        <th class="text-center" width="15%"><strong>编码</strong></th>
                        <th class="text-center" width="15%"><strong>名称</strong></th>
                        <th class="text-center" width="15%"><strong>有效期</strong></th>
                        <th class="text-center" width="15%"><strong>状态</strong></th>
                        <th class="text-center" ><strong>操作</strong></th>
                    </tr>
                </thead>
                <tbody>
	              <#if resultList?exists>
	          		<#list resultList as result>
		          	 <tr>
		          	  <td>
		          	  	<input type="radio" name="reference" value="${result.id}" isDeleted="${result.isDeleted}" refId="${result.refId}" code="${result.refDetailCode}" refName="${result.refDetailName}" refStartTime="${result.refStartTimeStr}" refEndTime="${result.refEndTimeStr}" refDetailValue="${result.refDetailValue}" refDetailRemark="${result.refDetailRemark}" createTime="${result.createTime}"/>
		          	  </td>
		              <td><a onclick="detail_show_pop('view','${result.id}');" href="#">${result.refDetailCode}</a></td>
		              <td>${result.refDetailName}</td>
		              <#if result.refStartTimeStr?exists>
		              	<td>${result.refStartTimeStr} -- ${result.refEndTimeStr}</td>
		              <#else>
		              	<td>永久</td>
		              </#if>
		              <#if result.isDeleted="0" || result.isDeleted="2">
		              	<td><#if result.isDeleted="0">已启用-redis</#if><#if result.isDeleted="2">已启用</#if></td>
		              	<td>
		              		<a onclick="delFunction('${result.id}','${queryVo.refCode}');" class="btn red btn-sm" ><i class="fa fa-times" ></i> 停用</a>
		              	</td>
		              </#if>
		              <#if result.isDeleted="1">
		              	<td>已停用</td>
		              	<td>
		              		<a onclick="reAddFunction('${result.id}','${queryVo.refCode}','A');" class="btn green btn-sm" ><i class="fa fa-plus"></i> 启用-redis</a>&nbsp;
		              		<a onclick="reAddFunction('${result.id}','${queryVo.refCode}','B');" class="btn green btn-sm" ><i class="fa fa-plus"></i> 启用</a>
		              	</td>
		              </#if>
		             </tr>
	          		</#list>
	          	  </#if>
           		</tbody>
            </table>
            <@pager.pager currentPage=pagination.currentPage pagesize=pagination.pagesize totalRows=pagination.totalRows />
        </div>
    </div>
</form>
</div>
<form id="refDetailForm">
    <div class="modal fade" id="infMaintenance" tabindex="-1" aria-hidden="true" style="display: none;">
        <div class="modal-dialog modal-fixwidth" style="width:980px;">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                    <h4 class="modal-title" id="pop_title">新增参照信息</h4>
                </div>
                <input type="hidden" name="refId" id="ref_id">
                <input type="hidden" name="id" id="detail_id">
                <input type="hidden" name="createTimeStr" id="create_time">
                <input type="hidden" name="isDeleted" id="isDeleted">
                <input type="hidden" name="refCode" value="${queryVo.refCode}">
                <input type="hidden" id="action">
                <div class="modal-body form-horizontal">
                    <div class="form-group clearfix">
                        <div class="col-md-4 padding-left-0">
                            <label class="control-label col-md-4">编码：</label>
                            <div class="col-md-8 padding-left-0">
                                <input type="text" id="code_show_only" class="form-control" name="refDetailCode">
                            </div>
                        </div>
                        <div class="col-md-4 padding-left-0" style="width:45%;">
                            <label class="control-label col-md-4">名称：</label>
                            <div class="col-md-8 padding-left-0">
                                <input type="text" id="refDetailName" name="refDetailName" class="form-control" value="">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-body form-horizontal" style="padding-top: 0;">
                    <div class="form-group clearfix" style="position: relative;">
                        <div class="col-md-4 padding-left-0">
                            <label class="control-label col-md-4">有效时间：</label>
                            <div class="col-md-8 padding-left-0">
                                <select class="form-control select2me" name="vendorCtg" id='vendorCtg' style="width:115px">
                                    <option value="0" id="option1">永久</option>
                                    <option value="1" id="option">有效区间</option>
                                </select>
                                <div class="input-daterange input-group" id="datepicker" style="position: absolute;top: 0;left: 130px; width: 260px!important;display: none;">
                                    <input type="text" class="input-sm form-control" name="refStartTime" style="height: 34px;" id="start_time"/>
                                    <span class="input-group-addon" style="background:#fff;border:none;padding:0 4px;">至</span>
                                    <input type="text" class="input-sm form-control" name="refEndTime" style="height: 34px;" id="end_time"/>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-body form-horizontal" style="padding-top: 0;">
                    <div class="form-group clearfix">
                        <div class="col-md-4 padding-left-0">
                            <label class="control-label col-md-4">信息值：</label>
                            <div class="col-md-8 padding-left-0">
                                <textarea class="form-control" style="width: 610px;height: 90px;resize: none;" name="refDetailValue" id="refDetailValue"></textarea>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-body form-horizontal" style="padding-top: 0;">
                    <div class="form-group clearfix">
                        <div class="col-md-4 padding-left-0">
                            <label class="control-label col-md-4">备注：</label>
                            <div class="col-md-8 padding-left-0">
                                <textarea class="form-control" style="width: 610px;height: 90px;resize: none;" name="refDetailRemark" id="refDetailRemark"></textarea>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" id="addBtn" class="btn green"><i class="fa fa-check"></i> 提交</button>
                    <button type="button" class="btn" data-dismiss="modal" aria-hidden="true"><i class="fa fa-undo"></i> 返回</button>
                </div>
            </div>
        </div>
    </div>
</form>

<script type="text/javascript">
var new_code = "OEM00164";

$(document).ready(function() {
    var flag = true;
    var delArr = [];
    
    //查询
    function submitForm(){
        $("#sysReferenceForm").submit();
    }
	/*
    $("#queryInfoForm").validate({
        submitHandler: function(form) {
            grid01.fnSettings()._iDisplayStart = 0;;
            grid01.fnDraw();
            return false;
        }
    });*/

    $('#returnBtn').click(function() {
        window.location.href = "${contextPath}/sysReference/querySysRefence.htm";
    });
    
    $('#addBtn').click(function() {
    	$("#refDetailValue").val($.trim($("#refDetailValue").val()));
		$("#refDetailRemark").val($.trim($("#refDetailRemark").val()));
		$('input[name="refDetailName"]').val($.trim($('input[name="refDetailName"]').val()));
		
        var act = $('#action').val();
        if ($.trim($("#code_show_only").val()) == '') {
            $.Alert("请输入编码!", null);
            return false;
        } else if ($.trim($("#refDetailName").val()) == '') {
            $.Alert("请输入名称!", null);
            return false;
        }
        switch (act) {
            case "add":
            	var startTime=$("#start_time").val();
            	var endTime=$("#end_time").val();
            	if(endTime!=""){
            		if(startTime==""){
            			$.Alert("请选择有效时间的开始时间!");
            			return;
            		}
            	}
            	if(startTime!=""){
            		if(endTime==""){
            			$.Alert("请选择有效时间的截止时间!");
            			return;
            		}
            	}
            	
                $.ajax({
                    url:"${contextPath}/sysReference/addReferenceDetail.htm",
                    type: "POST",
                    data: $('#refDetailForm').serialize(),
                    success: function(re) {
                        var obj = eval('(' + re + ')');
                        if (obj.msg == "编码只能是英文数字和下划线！") {
                            $.Alert("编码只能是英文数字和下划线！", null, function() {
                                if (obj.message) $.Alert(obj.message, null);
                            });
                        }
						if (obj.msg == "编码已存在！") {
                            $.Alert("编码已存在！!", null, function() {
                                if (obj.message) $.Alert(obj.message, null);
                            });
                        }
                        if (obj.msg == "新增成功！") {
                            $.Alert("新增成功！", null, function() {
                                location.reload();
                            });
                        } else if (obj.msg == "新增失败！") {
                            if (obj.message) $.Alert(obj.message, null);
                        } else {
                            if (obj.message) $.Alert(obj.message, null);
                        }
                    },
                    error: function() {
                        $.Alert("系统异常!", null);
                    }
                });
                break;
            case "modify":
            	var startTime=$("#start_time").val();
            	var endTime=$("#end_time").val();
            	if(endTime!=""){
            		if(startTime==""){
            			$.Alert("请选择有效时间的开始时间!");
            			return;
            		}
            	}
            	if(startTime!=""){
            		if(endTime==""){
            			$.Alert("请选择有效时间的截止时间!");
            			return;
            		}
            	}
                $.dopConfirm("确认修改吗？", null, function(r) {
                    if (r) {
                        $.ajax({
                            url: "${contextPath}/sysReference/modifyReferenceDetail.htm",
                            type: "POST",
                            data: $('#refDetailForm').serialize(),
                            success: function(re) {
                                var obj = eval('(' + re + ')');

                                if (obj.msg == "更新成功！") {
                                    $.Alert("修改成功!", null, function() {
                                        location.reload();
                                    });
                                } else if (obj.msg == "更新失败！") {
                                    if (obj.message) $.Alert(obj.message, null);
                                } else {
                                    if (obj.message) $.Alert(obj.message, null);
                                }
                            },
                            error: function() {
                                $.Alert("系统异常!", null);
                            }
                        });
                    }
                });
                break;
            default:
                break;
        }
    });

    $('#refDetailName').val('');
    $('input[name="reference_detail"]').each(function() {
        $(this).attr("checked", false);
    });
});

function delFunction(id,refCode) {
	$.dopConfirm("确认停用吗？", null, function(r) {
        if (r) {
            $.ajax({
                url:"${contextPath}/sysReference/delReferenceDetail.htm",
                type: "POST",
                data: {"id":id,"refCode":refCode},
                success: function(re) {
                    var obj = eval('(' + re + ')');

                    if (obj.msg == "停用成功！") {
                        $.Alert("停用成功！", null, function() {
                            location.reload();
                        });
                    } else if (obj.msg == '停用失败！') {
                        if ("停用失败！") $.Alert(obj.message, null);
                    }
                },
                error: function() {
                    $.Alert("系统异常!", null);
                }
            });

        }
    });
}

function reAddFunction(id,refCode,type) {
	$.dopConfirm("确认启用吗？", null, function(r) {
        if (r) {
            $.ajax({
                url:"${contextPath}/sysReference/reAddReferenceDetail.htm",
                type: "POST",
                data: {"id":id,"refCode":refCode,"isDeleted":type},
                success: function(re) {
                    var obj = eval('(' + re + ')');

                    if (obj.msg == "启用成功！") {
                        $.Alert("启用成功！", null, function() {
                            location.reload();
                        });
                    } else if (obj.msg == '启用失败！') {
                        if ("启用失败！") $.Alert(obj.message, null);
                    }
                },
                error: function() {
                    $.Alert("系统异常!", null);
                }
            });

        }
    });
}

function submitForm() {
    $("#sysReferenceForm").submit();
}

function detail_show_pop(act,code) {
	$(".modal-footer").show();
	$("#start_time").val("");
	$("#end_time").val("");
	$("#start_time").removeAttr("disabled");
	$("#end_time").removeAttr("disabled");
	$('input[name="refDetailName"]').removeAttr("readonly");
	$("#refDetailValue").removeAttr("readonly");
	$("#refDetailRemark").removeAttr("readonly");
	$('#vendorCtg').removeAttr("disabled");
	$("#datepicker").hide();
	$("#option1").attr("selected","true");
    switch (act) {
        case "modify":
            $("#pop_title").html("修改参照信息");
            $("#action").val("modify");
            var select_reference = $('#sample_2 input[type="radio"][name="reference"]:checked');
			$("#detail_id").val(select_reference.val());
            if (select_reference.size() < 1) {
                $.Alert("请选取一条参照信息!", null);
                return false;
            } else if (select_reference.size() > 1) {
                $.Alert("只能选一条参照信息!", null);
                return false;
            } else if (select_reference.attr("isDeleted") == '0') {
            	$.Alert("该参照信息已被启用!<br/>若要修改请先停用!", null);
                return false;
            }
            
            $("#detail_id").val(select_reference.val());
            $("#ref_id").val(select_reference.attr("refId"));
            $("#code_show_only").val(select_reference.attr("code"));
            $("#refDetailValue").val(select_reference.attr("refDetailValue"));
            $('input[name="refDetailName"]').val(select_reference.attr("refName"));
            $("#refDetailRemark").val(select_reference.attr("refDetailRemark"));
            var startTime=select_reference.attr("refStartTime");
            var endTime=select_reference.attr("refEndTime");
            $("#code_show_only").attr("readonly","true");
            $("#create_time").val(select_reference.attr("createTime"));
            $("#ref_detail_code").val(select_reference.attr("code"));
            $("#isDeleted").val(select_reference.attr("isDeleted"));
            if(startTime!=""&&endTime!=""){
            	$("#start_time").val(startTime);
            	$("#end_time").val(endTime);
             	$("#datepicker").show();
             	$("#option").attr("selected","true");
            	$("#datepicker").find("input").eq(0).focus();
            }
            $("#pop_href").click();
            $('.input-daterange').datepicker({
        		language: "zh-CN"
    		});
            break;
        case "view":
        	$("#pop_title").html("查看参照信息");
        	var select_reference = $('#sample_2 input[type="radio"][name="reference"][value="'+code+'"]');
        	$("#detail_id").val(select_reference.val());
            $("#ref_id").val(select_reference.attr("refId"));
            $("#code_show_only").val(select_reference.attr("code"));
            $("#refDetailValue").val(select_reference.attr("refDetailValue"));
            
            $('input[name="refDetailName"]').val(select_reference.attr("refName"));
            $('input[name="refDetailName"]').attr("readonly","true");
            $("#refDetailValue").attr("readonly","true");
            $("#refDetailRemark").val(select_reference.attr("refDetailRemark"));
            $("#refDetailRemark").attr("readonly","true");
            var startTime=select_reference.attr("refStartTime");
            var endTime=select_reference.attr("refEndTime");
            $("#code_show_only").attr("readonly","true");
            $("#create_time").val(select_reference.attr("createTime"));
            $("#ref_detail_code").val(select_reference.attr("code"));
            
            $('#vendorCtg').prop("disabled","disabled");
            if(startTime!=""&&endTime!=""){
            	$("#start_time").val(startTime);
            	$("#end_time").val(endTime);
            	$("#start_time").attr("disabled","disabled");
            	$("#end_time").attr("disabled","disabled");
             	$("#datepicker").show();
             	$("#option").attr("selected","true");
            } else {
            	$("#option1").attr("selected","true");
            }
            $("#pop_href").click();
            $(".modal-footer").hide();
        	break;
        case "add":
        	$("#action").val("add");
            $("#detail_id").val("");
            $("#ref_id").val($("#sys_ref_id").val());
            $("#code_show_only").val("");
            $("#refDetailValue").val("");
            $('input[name="refDetailName"]').val("");
            $("#refDetailRemark").val("");
            $("#code_show_only").removeAttr("readonly");
            $('.input-daterange').datepicker({
        		language: "zh-CN"
    		});
        default:
            $("#pop_title").html("新增参照信息");
			$("#action").val("add");
            $("#detail_id").val("");
            $("#ref_id").val($("#sys_ref_id").val());
            $("#code_show_only").val("");
            $("#refDetailValue").val("");
            $('input[name="refDetailName"]').val("");
            $("#refDetailRemark").val("");
            $("#code_show_only").removeAttr("disabled");
            $("#pop_href").click();
    }

    $("#action").val(act);
    
    $(".select2me").change(function() {
        if ($(this).find("option:selected").text() != "永久") {
            $("#datepicker").show();
            $("#datepicker").find("input").eq(0).focus();
        } else {
            $("#start_time").val("");
            $("#end_time").val("");
            $("#datepicker").hide();
        }
    });
}
var alertMessage = "";
var ajaxStatusSuccess = "success";
jQuery(document).ready(function() {

    //App.init(); // initlayout andore plugins

    if (alertMessage) {
        tools.message(alertMessage);
    }

});
</script>
</body>
</html>
