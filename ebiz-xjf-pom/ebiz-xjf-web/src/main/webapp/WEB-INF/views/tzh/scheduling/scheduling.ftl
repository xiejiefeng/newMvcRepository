<!DOCTYPE html>
<html>
<head>
    
    <title>我的排班</title>
    <#include "/tzh/common/tzh_header.ftl" encoding="UTF-8">
    <script src="<@jci.domain url='/js/jquery.datepicker.js'/>"></script>
</head>
<body>
	<script>

	    function setFontsize() {
	        document.querySelector('html').style.fontSize = (document.body.clientWidth / 320 * 16 + 'px');
	    }
	    setFontsize();
	   
	</script>
	<div class="scheduling" style="position: relative">
	    <div id="datepicker"></div>
	    <div class="info">
	        <h2></h2>
	        <ul>
	        </ul>
	    </div>
	    <a href="/tzh/tzhScheduleInit.htm?empNo=${empNo}" style="position: absolute;top: 0;right: 0;height: 2.4rem;width: 30%;opacity: 0;">12312312312</div>
	</div>
	<div id="courseList"></div>
    <script type="text/javascript">
    $(function() {
        var curYear = new Date().getFullYear().toString(),
            curMonth = (new Date().getMonth() + 1).toString(),
            curDay = new Date().getDate().toString();
        
        var nextYear = new Date().getFullYear() + 1;
        var courseList;
		//请求排班数据
		function loadList(year, month){
			var url = $.context + '/tzh/getTzhSchedule.htm?empNo=${empNo}&dutyDate='+year+month;
			$.ajax({
			    url: url,
			    async: false,
			    type: "get",
			    dataType: "json",
			    success: function(data) {
			       courseList = data;
			    }
			
			});
			return courseList;
		}
		loadList(curYear, curMonth)
		
		
		
        function dataInit() {

            //日历面板初始化

            $('#datepicker').datepicker({
                yearRange: curYear + ':' + nextYear,
                prevText: '',
                nextText: '',
                yearSuffix: '年',
                changeYear: false,
                changeMonth: false,
                dateFormat: "yy-mm-dd",
                firstDay: 0,
                showMonthAfterYear: true,
                showOtherMonths: true,
                showButtonPanel: true,
                currentText: '返回今天',
                dayNamesMin: ['日', '一', '二', '三', '四', '五', '六'],
                monthNames: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月'],
                beforeShowDay: function(date) {
                    //每一个日期在显示之前都会过这里
                    var thisDay = date.getTime();
                    //添加排班日历标记 start
                    var counter = 0;
                    for (var i in courseList.scheduleList) {
                        var beginTime = parseInt(courseList.scheduleList[i].dutyDateStart);
                        var year = new Date(beginTime).getFullYear(),
                            month = new Date(beginTime).getMonth(),
                            day = new Date(beginTime).getDate();
                        var beginDay = new Date(year, month, day, 0, 0, 0);
                        //安排工作当天的00:00:00
                        var nextDay = new Date(year, month, day + 1, 0, 0, 0);
                        //安排工作当天的24:00:00
                        if (beginDay <= thisDay && thisDay < nextDay) {
                            counter++;
                            // continue;//当天重复的排班就不计算了
                        }
                    }
                    if (counter > 0) {
                        if (counter > 3) counter = 3; //显示当天排班次数
                        var addtionCls = 'course_count_' + counter;
                        return [true, 'hasCourse ' + addtionCls + ' day_' + date.getFullYear()+(date.getMonth()+1)+date.getDate(), '排班'];
                    } else {
                        return [true, 'noCourse', '没有排班'];
                    }
                    //添加排班日历标记 end
                },
                onSelect: function(dateText, inst) {
                    var arr = dateText.split('-');
                    var year = arr[0],
                        month = arr[1],
                        day = parseInt(arr[2]);
                    var thisDay = new Date(year, month - 1, day, 0, 0, 0);
                    //选中日期当天的00:00:00
                    var nextDay = new Date(year, month - 1, day + 1, 0, 0, 0);
                    //选中日期当天的24:00:00
                    var curDateList = [];
                    var hasJob = false;
					
                    //判断日历中已安排的工作时间
                    for (var i in courseList.scheduleList) {
                        var beginTime = parseInt(courseList.scheduleList[i].dutyDateStart),
                            beginTimeDetail = new Date(beginTime).getHours() + ":" + fillNum(new Date(beginTime).getMinutes());
                        var endTime = parseInt(courseList.scheduleList[i].dutyDateEnd),
                            endTimeDetail = new Date(endTime).getHours() + ":" + fillNum(new Date(endTime).getMinutes());
                        if (thisDay <= beginTime && endTime <= nextDay) {
                            curDateList.push("<li>"+beginTimeDetail + " ~ " + endTimeDetail + "<span>已排</span></li>");
                            hasJob = true;
                        }
                    }
                    
                    $(".info h2").text(year + "年" + month + "月" + fillNum(day) + "日排班");
                    //判断是否是当天
                    if (thisDay.toDateString() == new Date().toDateString()) {
                        $(".info h2").addClass('cur');
                    } else {
                        $(".info h2").removeClass();
                    }
                    //判断是否有时间安排
                    if (hasJob) {
                        $(".info ul").removeClass().html(curDateList.join(''));
                    } else {
                        $(".info li").addClass('no-job').html('暂无排班');
                    }
                },
                onChangeMonthYear: function(year, month, inst){
                	loadList(year, fillNum(month))
                }
            });
        }
        dataInit();

        //分钟补零
        function fillNum(num) {
            if (num < 10) {
                return "0" + num
            }
            return num
        }
		
		//判断今天是否排班
        function curToday() {
        	var curArr = []; 
            $(".info h2").text(curYear + "年" + curMonth + "月" + curDay + "日排班").addClass('cur');
            if ($(".ui-state-highlight").parent().attr("title") === "排班") {
                 for (var i in courseList.scheduleList) {
                    var beginTime = parseInt(courseList.scheduleList[i].dutyDateStart),
                        beginTimeDetail = new Date(beginTime).getHours() + ":" + fillNum(new Date(beginTime).getMinutes());
                    var endTime = parseInt(courseList.scheduleList[i].dutyDateEnd),
                        endTimeDetail = new Date(endTime).getHours() + ":" + fillNum(new Date(endTime).getMinutes());
                    if(new Date().toDateString() === new Date(beginTime).toDateString()){
                    	curArr.push("<li>"+beginTimeDetail + " ~ " + endTimeDetail + "<span>已排</span></li>");
                        
                    }
                 }
                 $(".info ul").removeClass().html(curArr.join(''));
                
            } else {
                $(".info li").addClass('no-job').html('暂无排班');
            }
        }
        curToday()
		
		
		

    });
    </script>

</body>
</html>