$(function(){
    ;(function(){
//        var href =location.search.substring(1);
//        if(!href){
//            window.location.href=contextPath+'/selectCar/toSelectCarSure.htm';
//        }
        if(localStorage.getItem("carbrandItem")){
            $('.carbrand-sel').text(localStorage.getItem("carbrandItem"));
        };
        if(localStorage.getItem("seriesItem")){
            $('.carStyle-sel').text(localStorage.getItem("seriesItem"));
        }
        if(localStorage.getItem("volumeItem")){
            $('.carvolume-sel').text(localStorage.getItem("volumeItem"));
        }
        $('.carsDate dd a').each(function(){
            var seriesItem = $(this).find('span').text();
            $(this).click(function(){
                localStorage.setItem("DateItem",seriesItem);
            })
        })
    })();


});