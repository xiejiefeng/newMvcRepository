$(function(){
    ;(function(){
//        var href =location.search.substring(1);
//        if(!href){
//            window.location.href='selectCar.html';
//        }
        if(localStorage.getItem("carbrandItem")){
            $('.carbrand-sel').text(localStorage.getItem("carbrandItem"));
        }
        if(localStorage.getItem("seriesItem")){
            $('.carStyle-sel').text(localStorage.getItem("seriesItem"));
        }
        $('.carvolume dd a').each(function(){
            var seriesItem = $(this).find('span').text();
            $(this).click(function(){
                localStorage.setItem("volumeItem",seriesItem);
            })
        })
    })();



});