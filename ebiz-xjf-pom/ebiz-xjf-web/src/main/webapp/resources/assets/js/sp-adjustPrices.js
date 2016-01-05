$(function(){
    // initlayout and core plugins
    App.init();
    if ( $().datepicker) {
        $('.date-picker').datepicker({
            language:"zh-CN",
            rtl: App.isRTL(),
            autoclose: true
        });
    };
});