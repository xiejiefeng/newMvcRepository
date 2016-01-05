<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1, minimum-scale=1, user-scalable=no">
<#include "/common/header.ftl" encoding="UTF-8">
<title>404错误页面</title>
<style>
.error { text-align:center; padding-top:10.8rem;}
.error div{ width:12.6rem; height:12.6rem;line-height:12.6rem;border-radius:6.3rem; background:#e7e7e7; margin:0 auto; }
.error div i{font-size:7.6rem;color:#d2d2d2;}
.error p {text-align:center;font-size:1.4rem; line-height:5rem;}
.error p span:nth-of-type(1){ color:#6e6e6e;}
.error p a{ color:#17a3eb;}
footer{position:fixed; bottom:2.2rem;line-height:2.5rem;font-size:1.2rem;width:32rem;}
footer p{line-height:2.5rem;font-size:1.2rem;}
footer p a{color:#17a3eb;font-size:1.2rem;}
footer .iconfont{color:#17a3eb;padding-right:0.5rem; font-size:1.2rem}
</style>
</head>
<body>
<#include "/common/rem.ftl" encoding="UTF-8">
<section class="error">
    <div><i class="iconfont icon-404"></i></div>
    <p ><span>出错了！你访问的页面不存在!</span></p>
</section>
<footer><p>如反复出现请联系客服</p><p><a href="tel:${crmTel}"><i class="iconfont icon-phone"></i>${crmTel}</a></p></footer>
<#include "/common/footer.ftl" encoding="UTF-8">

</body>
</html>