/**
 *  need iScroll v5+
 */
;
(function($) {
    var todayDate = new Date(),
        tomorrowDate = new Date(todayDate.valueOf() + 1 * 24 * 60 * 60 * 1000);
    $.extend($.fn, {
        "modatepicer": function(opt) {
            opt = $.extend({
                num: 7, //默认显示后7天(包含今天)
                sDate: tomorrowDate, //开始日期加一天, date对象
                maskTap: true, //点击遮罩层时是否关闭当前弹窗
                sd: "",
                fg: false,
                ap: 0,
                okCallback: $.noop //点击确定的回调函数, 用于取值
                    //closeCallback: $.noop //todo
                    //...todo more   
            }, opt);

            return this.each(function() {
                var _this = this,
                    $modal = $('#' + $(this).data('modal')), //通过点击对象上的input data-modal属性取得对应modal ID
                    $iScroll = $modal.find('.iscrollbar_1'),
                    $iScroll_2 = $modal.find('.iscrollbar_2'),
                    $iscrollWrap = $modal.find('.iscrollbar-con-1'),
                    $iscrollWrap_2 = $modal.find('.iscrollbar-con-2'),
                    $moTitle = $modal.find('.md-title'),
                    dataArr = getDaysArr(opt.num), //获取所有日期数据集合(数组)

                    index = 0, //取得当前选中日期的索引
                    index_2 = 0,
                    daysArr = ['周日', '周一', '周二', '周三', '周四', '周五', '周六'],
                    daysArrW = ['星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六'],
                    dayAp = ['上午', '下午'];
                // var myScroll = new IScroll( '.iscrollbar_1' , { snap: true, momentum: false, tap: true, });
                // var myScroll_2 = new IScroll( '.iscrollbar_2' , { snap: true, momentum: false, tap: true, });

                /** 日期转字符串
                 *  @ (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
                 *  @ (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18
                 */
                Date.prototype.Format = function(format) {
                    var o = {
                        "M+": this.getMonth() + 1, // month
                        "d+": this.getDate(), // day
                        "h+": this.getHours(), // hourz
                        "m+": this.getMinutes(), // minute
                        "s+": this.getSeconds(), // second
                        "q+": Math.floor((this.getMonth() + 3) / 3), // quarter
                        "S": this.getMilliseconds()
                    };
                    if (/(y+)/.test(format))
                        format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
                    for (var k in o)
                        if (new RegExp("(" + k + ")").test(format))
                            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
                    return format;
                };

                //字符串转日期对象, exp：'2015-05-21'.toDate()
                String.prototype.toDate = function() {
                    return new Date(Date.parse(this.replace(/-/g, "/")));
                };

                //设置当前值
                function setCurDate(index, iscrollWrap) {
                    var $curLi = iscrollWrap.find('li').eq(Math.round(index));
                    // d = ( $curLi.find( '.md-data-date' ).data( 'md-date' ) ).toDate();
                    //$moTitle.find( '.md-date' ).text( d.Format( 'yyyy年M月d日' ) );
                    // $moTitle.find( '.md-day' ).text( daysArrW[ d.getDay() ] );
                    iscrollWrap.find('li').removeClass();
                    $curLi.addClass('cur');
                    $curLi.next().addClass('cur-side');
                    $curLi.prev().addClass('cur-side');

                };

                //取得与date相隔days(可为负数)天的date
                function getDate(date, days) {
                    var d = new Date(date);
                    d.setDate(d.getDate() + days);
                    var month = d.getMonth() + 1;
                    var day = d.getDate();
                    month = (month < 10) ? "0" + month : month;
                    day = (day < 10) ? "0" + day : day;
                    var val = d.getFullYear() + "-" + month + "-" + day;
                    return val;
                };

                //取得待选择日期数组['2015-05-05', '2015-05-06',...]
                function getDaysArr(num) {
                    var arr = [];
                    for (i = 0; i < num; i++) {
                        arr.push(getDate(opt.sDate, i));
                    };
                    return arr;
                };

                //显示弹窗函数，并加载iScroll滚动列表
                function showModal($obj) {
                    $obj.show().siblings('.md-mask').show();
                    //body打开弹窗标识
                    $('body').addClass('modal-open');
                    //禁止ios回弹
                    function preventDefault(ev) {
                        ev.preventDefault()
                    };
                    $obj.get(0).addEventListener('touchmove', preventDefault, false);
                    $obj.siblings('.md-mask').get(0).addEventListener('touchmove', preventDefault, false);
                    //判断是否已经渲染
                    if (!$iscrollWrap.hasClass('rendered')) {
                        $.each(dataArr, function(index, day) {
                            var curDate = day.toDate();
                            m = curDate.getMonth() + 1,
                                d = curDate.getDate(),
                                dayStr = m + '月' + d + '日';
                            $iscrollWrap.append('<li><span data-md-date="' + day + '" class="md-data-date">' + dayStr + '</span><span class="md-data-week">' + daysArr[curDate.getDay()] + '</span></li>');


                        });
                        //添加已渲染标识
                        $iscrollWrap.addClass('rendered');

                    };
                    //设置默认索引及默认显示日期
                    initIscroll();

                    index = (index == -1) ? $.inArray(opt.sDate.Format('yyyy-MM-dd'), dataArr) : index;
                    if (index == 0) {
                        initIscroll_2();
                    }
                    setCurDate(index, $iscrollWrap);



                };

                //隐藏弹窗
                function hideModal($obj) {
                    $obj.hide().siblings('.md-mask').hide();
                    //body关闭弹窗标识
                    $('body').removeClass('modal-open');
                };

                //初始化iScroll

                function initIscroll() {
                    var myScroll = new IScroll('.iscrollbar_1', {
                        snap: true,
                        momentum: false,
                        tap: true,
                    });
                    var myScroll_2 = new IScroll('.iscrollbar_2', {
                        snap: true,
                        momentum: false,
                        tap: true,
                    });
                    myScroll.goToPage(0, index, 200);
                    myScroll_2.goToPage(0, index_2, 200);
                    //捕获滚动结束事件

                    myScroll.on('scrollEnd', function() {
                        opt.fg = false;
                        index = Math.abs(this.y / 40); //重置索引  this.y当前页的y坐标

                        $(".iscrollbar-con-2").html("<li>上午</li><li>下午</li>");
                        initIscroll_2()
                        setCurDate(index, $iscrollWrap);
                        setCurDate(index_2, $iscrollWrap_2);



                    });
                    //捕获tap事件
                    $iscrollWrap.find('li').on('tap', function() {
                        index = $(this).index();
                        myScroll.goToPage(0, index, 200);
                        setCurDate(index, $iscrollWrap);
                        //                      needConfirm();

                    });
                };

                function initIscroll_2() {

                    var myScroll_2 = new IScroll('.iscrollbar_2', {
                        snap: true,
                        momentum: false,
                        tap: true,
                    });

                    myScroll_2.goToPage(0, index_2, 200);
                    //捕获滚动结束事件
                    myScroll_2.on('scrollEnd', function() {
                        opt.fg = false;
                        index_2 = Math.abs(this.y / 40); //重置索引

                        setCurDate(index_2, $iscrollWrap_2);


                    });
                    //捕获tap事件
                    $iscrollWrap_2.find('li').on('tap', function() {
                        index_2 = $(this).index();
                        myScroll_2.goToPage(0, index_2, 200);
                        setCurDate(index_2, $iscrollWrap_2);



                    });
                };




                //设置input值
                function setInputVal(index) {
                    var AP = "";
                    var c;
                    if (opt.fg) {
                        c = $.inArray(opt.sd.Format('yyyy-MM-dd'), dataArr);
                        if (opt.ap == 0 || opt.ap == "" || opt.ap == 1) {
                            index_2 = 0;
                        } else {
                            index_2 = 0;

                        }
                    } else {

                        c = index;

                    }

                    //如果计算错误我们重置他为1
                    if (c == -1) {
                        c = 1
                    }
                    var curDate = dataArr[c].toDate();
                    var conf;
                    if (c == 0) {
                        conf = index_2;
                    } else {
                        conf = index_2;
                    }

                    var valStr = curDate.Format('M月d日') + ' ' + daysArr[curDate.getDay()] + ' ' + dayAp[conf];
                    if (dayAp[conf] == "需确认") AP = "";
                    if (dayAp[conf] == "上午") AP = "1";
                    if (dayAp[conf] == "下午") AP = "2";
                    $(_this).data('ap', AP);
                    $(_this).data('val', dataArr[c]).val(valStr);


                };

                //设置input初始值
                $(function() {

                    setInputVal(index);
                });

                //显示弹窗, todo: 委托绑定
                $(this).on('focus', function() {
                    index = $.inArray($(this).data('val'), dataArr);

                    showModal($modal);
                    return false;
                });

                //确定赋值并关闭弹窗
                $modal.on('click', '.md-submit', function() {
                    //设置文本框的值为当前选中日期
                    setInputVal(index);
                    //关闭弹窗
                    hideModal($modal);
                    opt.okCallback();
                });

                //根据参数判定点击遮罩是否关闭弹窗
                if (opt.maskTap) {
                    $('body').on('click', '.md-mask', function() {
                        hideModal($modal);
                    });
                };
                //点击关闭
                $('body').on('click', '.md-close', function() {
                    hideModal($modal);
                    return false;
                });
            });
        }
    });
})(jQuery);
