<script type="text/javascript">
	$("[data-lable]").each(function(){
        var opt_label = $(this).attr("data-lable");
        $(this).on("click", function(){_hmt.push(['_trackEvent', 'href', 'click', opt_label])});
     });
</script>
<script type="text/javascript" src="<@jci.domain url='/js/common.js'/>"></script>
<!--<#include "/common/wx.ftl" encoding="UTF-8">-->
