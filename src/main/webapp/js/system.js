$(document).ready(function() {
	$.ajax({
		url : "../showcount",
		dataType : "json",
		async : false,
		success : function(result) {
			if(result.code==200){
                var s1=result.data[0];
                var s2=result.data[1];
                var s3=result.data[2];
                var s4=result.data[3];
                var s5=result.data[4];
                $('#lessoncount').html(s1);
                $('#teachercount').html(s2);
                $('#teamcount').html(s3);
                $('#servicecount').html(s4);
                $('#sciencecount').html(s5);
				var pie=document.getElementById("pie");
                var myChart=echarts.init(pie);
                var option = {
                //图标表头
        
                //图标示例
                tooltip: {},
                series: [{
                    //饼图pie
                    type: 'pie',
                    //饼图位置
                    center:['50%',100],
                    //大小
                    radius:80,
                    data: [
                        {name:'创业课程',value:s1},
                        {name:'创业导师',value:s2},
                        {name:'创业团队',value:s3},
                        {name:'技术沙龙',value:s4},
                        {name:'创业服务',value:s5}
                    ]
                }]
            };
            myChart.setOption(option);

            var bar=document.getElementById("bar");
            var myChart2=echarts.init(bar);
            var option2 = {
            //图标表头
            // title: {
            //     text: 'ECharts 柱状图实例'
            // },
            tooltip: {},
            //图标示例
            legend: {
                data:['数目']
            },
            //横坐标
            xAxis: {
                data: ["创业课程","创业导师","创业团队","技术沙龙","创业服务"]
            },
            //纵坐标
            yAxis: {},
            series: [{
                name: '数目',
                //柱状图bar
                type: 'bar',
                data: [s1,s2,s3,s4,s5],
                color:"rgb(104, 157, 255)"
            }]
        };
        myChart2.setOption(option2);
		}
		}
	});
});
