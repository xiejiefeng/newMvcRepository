<#-- 自定义的分页指令 (powered by tantun)
    属性：
   currentPage      当前页号(int类型)
   pagesize    每页要显示的记录数(int类型)
   totalRows 总记录数(int类型)
 -->
<#macro pager currentPage pagesize totalRows>  
  <#-- 定义局部变量pageCount保存总页数 -->
  <#assign totalRowsForShow=totalRows>
  <#if totalRows==-1><#assign totalRowsForShow=0></#if>
  <#assign pageCount=((totalRowsForShow + pagesize - 1) / pagesize)?int>  
<#-- 输出分页样式 -->
<!--<style type="text/css">
.pagination {padding: 5px;float:right;font-size:12px;}
.pagination a, .pagination a:link, .pagination a:visited {padding: 2px 5px;margin: 2px;border: 1px solid #aaaadd;text-decoration: none;color: #006699;}
.pagination a:hover, .pagination a:active {border: 1px solid #ff0000;color: #000;text-decoration: none;}
.pagination span.current {padding: 2px 5px;margin: 2px;border: 1px solid #ff0000;font-weight: bold;background-color: #ff0000;color: #FFF;}
.pagination span.disabled {padding: 2px 5px;margin: 2px;border: 1px solid #eee; color: #ddd;}
</style>-->
<#-- 页号越界处理 -->
  <#if (currentPage > pageCount)>
    <#assign currentPage=pageCount>
  </#if>
  <#if (currentPage < 1)>
    <#assign currentPage=1>
  </#if>
<#-- 输出分页表单 -->

<div class="clearfix">
	<div class="col-md-6">
		<div class="dataTables_info" id="grid01_info" role="status" aria-live="polite">每页显示 ${pagesize} 条，共 ${totalRowsForShow} 条记录</div>
	</div>
	<div class="col-md-6 padding-right-0">
		<div class="dataTables_paginate paging_bootstrap" id="grid01_paginate">
			<div class="pagination-m">
				<input type="hidden" id="currentPage" name="pager.currentPage" value="1"/>
				<#-- 上一页处理 -->
				<#if (totalRows > 0)>
				  <#if (currentPage == 1)>
			
				  <span class="disabled">&laquo;&nbsp;上一页</span>
				  <#else>
				<a href="javascript:turnOverPage(${currentPage - 1})">&laquo;&nbsp;上一页</a>
				  </#if>
				<#-- 如果前面页数过多,显示... -->
				 <#assign start=1>
				 <#if (currentPage > 4)>
				    <#assign start=(currentPage - 1)>
				<a href="javascript:turnOverPage(1)">1</a>
				<a href="javascript:turnOverPage(2)">2</a>&hellip;
				 </#if>
				<#-- 显示当前页号和它附近的页号 -->
				 <#assign end=(currentPage + 1)>
				 <#if (end > pageCount)>
				  <#assign end=pageCount>
				 </#if>
				  <#list start..end as i>
				    <#if (currentPage==i)>
				<span class="current">${i}</span>
				  <#else>
				<a href="javascript:turnOverPage(${i})">${i}</a>      
				    </#if>
				  </#list>
				<#-- 如果后面页数过多,显示... -->
				  <#if (end < pageCount - 2)>
				&hellip;  
				  </#if>
				  <#if (end < pageCount - 1)>
				<a href="javascript:turnOverPage(${pageCount - 1})">${pageCount-1}</a>
				  </#if>
				  <#if (end < pageCount)>
				<a href="javascript:turnOverPage(${pageCount})">${pageCount}</a>
				  </#if>
				<#-- 下一页处理 -->
				  <#if (currentPage == pageCount)>
				<span class="disabled">下一页&nbsp;&raquo;</span>
				  <#else>
				<a href="javascript:turnOverPage(${currentPage + 1})">下一页&nbsp;&raquo;</a>
				  </#if>
				  </#if>
				  <#if (totalRows <= 0)>
                  <span class="disabled">&laquo;&nbsp;上一页</span>
                  <span class="disabled">下一页&nbsp;&raquo;</span>
				  </#if>
				<script language="javascript">
				  function turnOverPage(no){
				    if(no>${pageCount}){no=${pageCount};}
				    if(no<1){no=1;}
				    document.getElementById("currentPage").value=no;	
				    submitForm();
				  }
				</script>
				</div> 
			</div>
	</div>
</div>
</#macro>
