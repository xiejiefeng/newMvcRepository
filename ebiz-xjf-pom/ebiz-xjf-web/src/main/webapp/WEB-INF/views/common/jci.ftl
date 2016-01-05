<#assign contextPath = request.contextPath/>
<#assign version = .now?string("yyyyMMddHHmmss")/>
<!--<#macro domain url>${jscssUrl(url)}?t=${version}</#macro>-->
<#macro domain url>${contextPath}/resources${url}?t=${version}</#macro>
<#macro resources url>${contextPath}/resources${url}?t=${version}</#macro>