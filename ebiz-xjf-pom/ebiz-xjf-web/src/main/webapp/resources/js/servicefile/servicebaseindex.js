 $(function(){
        ;(function(){
            var navLi = $('.base-navs').find('li'),
                    reserveList =$('section');
            navLi.click(function(){
                var thisindex =$(this).index();
                $(this).addClass('sel').siblings().removeClass('sel');
                reserveList.eq(thisindex).show().siblings('section').hide();
            })
        })();
    })