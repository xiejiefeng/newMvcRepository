$(function(){
    ;(function(){
        if(localStorage.getItem("carbrandItem")){
            $('.carbrand-sel').text(localStorage.getItem("carbrandItem"));
        };
        if(localStorage.getItem("seriesItem")){
            $('.carStyle-sel').text(localStorage.getItem("seriesItem"));
        }
        if(localStorage.getItem("volumeItem")){
            $('.carvolume-sel').text(localStorage.getItem("volumeItem"));
        }
        if(localStorage.getItem("DateItem")){
            $('.carvDate-sel').text(localStorage.getItem("DateItem"));
        }
    })();
    
    $("#confirmBtn").on("click",function(){
    	var carNo=$(this).attr("data-carNo");
    	var carName=$(this).attr("data-carName");
    	window.location.href=$.context+"/preorder/selectcar.htm?carNo="+carNo+"&carName="+carName;
    	return false;
    });
});