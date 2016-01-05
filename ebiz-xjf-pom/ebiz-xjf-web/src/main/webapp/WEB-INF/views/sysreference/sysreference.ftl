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
<!-- 渲染头HTML -->
<#import "/common/pager.ftl" as pager> 
<body>
    <div class="page-wrap form-horizontal">
        <form id="sys_refence" name="sys_refence" class="form-horizontal margin-top-10" method="post" action="${contextPath}/sysReference/querySysRefence.htm">
            <div class="form-group clearfix">
                <div class="col-md-4 padding-left-0">
                    <label class="control-label col-md-4  text-right">关键字：</label>
                    <div class="col-md-8 padding-left-0">
                        <input type="text" class="form-control" id="webCode" name="webCode" value="${queryVo.webCode}">
                    </div>
                </div>
                <div class="stext-right padding-right-30">
                    <button type="button" id="queryInfo" onclick="submitForm();" class="btn blue"><i class="fa fa-search"></i> 查询</button>
                </div>
            </div>
            <div class="table-wrap">
                <div class="table-tool">
                    <a href="javascript:void(0)" onclick="manage_reference();" class="btn green btn-sm" data-toggle="modal"><i class="fa fa-plus"></i> 参照信息维护</a>
                </div>
                <table class="table table-striped table-bordered table-hover text-center">
                    <thead>
                        <tr>
                            <th class="text-center"><strong>选择</strong></th>
                            <th class="text-center"><strong>编码</strong></th>
                            <th class="text-center"><strong>名称</strong></th>
                        </tr>
                    </thead>
                    <tbody>
                    <#if result?exists>
                    <#list result as resultRow>
                        <tr>
                            <td>
                                <input type="radio" name="reference" value="${resultRow.id}" refCode=${resultRow.refCode} refName=${resultRow.refName}>
                            </td>
                            <td>${resultRow.refCode}</td>
                            <td>${resultRow.refName}</td>
                        </tr>
                    </#list>    
                     </#if>
                    </tbody>
                </table>
				<@pager.pager currentPage=pagination.currentPage pagesize=pagination.pagesize totalRows=pagination.totalRows />
            </div>
        </form>
    </div>
    <script>
	
	function submitForm(){
		$("#sys_refence").submit();
	}
	
	//跳转到明细
    function manage_reference() {
        var reference_id = $('input[name="reference"]:checked').val();

		url="${contextPath}/sysReference/referenceDetail.htm?refId=" + reference_id; 
        if (!(reference_id > 0)) {
            $.Alert('请选择参照信息');
            return;
        };
        window.location.href = url;
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
