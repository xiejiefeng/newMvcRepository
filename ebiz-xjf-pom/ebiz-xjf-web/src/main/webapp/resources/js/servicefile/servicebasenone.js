  $(function(){
        ;(function(obj){
            var objLi = obj.find("li");
            objLi.click(function(){
                var index = objLi.index(this);
                objLi.removeClass("sel").eq(index).addClass("sel");
            });
        })($(".time-order"));
    });