$(function(){
    ;(function(){
//        var href =location.search.substring(1);
//        if(!href){
//            window.location.href='selectCar.html';
//        }
        if(localStorage.getItem("carbrandItem")){
            $('.carbrand-sel').text(localStorage.getItem("carbrandItem"));
        };
        $(".carstyle-list dd  a").each(function(){
            var seriesItem = $(this).find('span').text();
            $(this).click(function(){
                localStorage.setItem("seriesItem",seriesItem);
            })
        });
    })();

});