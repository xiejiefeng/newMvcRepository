<!DOCTYPE html>
<html>
<head>
	<title>车享家员工端</title>
    <#include "/tzh/common/tzh_header.ftl" encoding="UTF-8">
</head>
<body class="staff-index">
<#include "/tzh/common/tzh_rem.ftl" encoding="UTF-8">
<header>
    
    <div class="user-logo">
       <#if pic?? && pic != ''>
       	<img src="${pic}" />
       	<#else>
       	<i class="iconfont icon-iconfontwo "></i>
       </#if>
       
    </div>
    <div class="user-infor">
        <div>${name}</div>
        <div>${mobile}</div>
    </div>

</header>
<nav>
    <a href="/tzh/preorderListInit.htm?storeId=${storeId}" > <div class="nav-item"><i class="iconfont icon-iconfontsearch2"></i><span>预约查询</span></div></a>
    <a href="/tzh/orderListInit.htm?empNo=${empNo}" > <div class="nav-item"><i class="iconfont icon-iconfontjiedan"></i><span>我的工单</span></div></a>
    <a href="/tzh/tzhEmpMoneyInit.htm?empNo=${empNo}" > <div class="nav-item"><i class="iconfont icon-iconfontqian"></i><span>我的提成</span></div></a>
    <a href="/tzh/tzhScheduleInit.htm?empNo=${empNo}" > <div class="nav-item"><i class="iconfont icon-iconfontrili"></i><span>我的排班</span></div></a>

</nav>

<script type="text/javascript">
</script>

</body>

</html>