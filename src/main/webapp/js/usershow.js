$(document).ready(function() {
	var uid = getCookie("useridss");
	if(uid!=undefined){
		$.ajax({
			url : "userinfo?uid="+uid,
			dataType : "json",
			async : false,
			success : function(result) {
				if(result.code==200){
					$("#info").html(result.data.uname+result.data.utelephone);
				}
			}
		});
		$("#cookie").show();
	}
	$.ajax({
		url : "userinfo?uid="+uid,
		dataType : "json",
		async : false,
		success : function(result) {
			if(result.code==200){
				$('#uname').html(result.data.uname);
				$("#ubirthday").html("生日："+result.data.ubirthday);
				$("#uschool").html(result.data.uschool+"-"+result.data.ustudy);
				$(".up_box .img_box img").attr("src","img/user/"+result.data.upic);
			}
		}
	});
	$.ajax({
		url : "showlessonlink?uid="+uid,
		dataType : "json",
		async : false,
		success : function(result) {
			if(result.code==200){
			var lessontext=``;
			for(var i=0;i<result.data.length;i++){
                lessontext+=`
                <div class="layui-col-md3">
                    <a href="lessoninfo.html?lid=`+result.data[i].lesson.lid+`">
                    <div id="" class="box">
                        <div id="" class="img_box">   
                            <img src="img/lesson/`+result.data[i].lesson.lpic+`" alt="">
                        </div>
                        <strong>`+result.data[i].lesson.lname+`</strong>
                        <span>`+result.data[i].lesson.lmajor+`</span>
                        <span>主讲人：`+result.data[i].lesson.lteacher+`</span>
                        <span class="layui-icon layui-icon-user">`+result.data[i].lesson.lnum+`</span>
                    </div>
                    </a>
                </div>`;
			}
			$('#lesosn_choose').html(lessontext);
			}
		}
    });
    $.ajax({
		url : "showsciencelink?uid="+uid,
		dataType : "json",
		async : false,
		success : function(result) {
			if(result.code==200){
			var sciencetext=``;
			for(var i=0;i<result.data.length;i++){
                sciencetext+=`
                <div class="layui-col-md3">
                    <a href="scienceinfo.html?sid=`+result.data[i].science.sid+`">
                    <div id="" class="box">
                        <div id="" class="img_box">   
                            <img src="img/science/`+result.data[i].science.spic+`" alt="">
                        </div>
                        <strong>`+result.data[i].science.sname+`</strong>
                        <span>发布：`+result.data[i].science.team.tname+`</span>
                        <span class="layui-icon layui-icon-user">`+result.data[i].science.snum+`</span>
                    </div>
                    </a>
                </div>`;
			}
			$('#science_choose').html(sciencetext);
			}
		}
    });
    $.ajax({
		url : "showservicelink?uid="+uid,
		dataType : "json",
		async : false,
		success : function(result) {
			if(result.code==200){
			var servicetext=``;
			for(var i=0;i<result.data.length;i++){
				servicetext+=`
				<div class="layui-col-md4">
                    <a href="serviceinfo.html?sid=`+result.data[i].service.sid+`">
                    <div id="" class="box">
                        <div id="" class="img_box">   
                            <img src="img/service/`+result.data[i].service.spic+`" alt="">
                        </div>
                        <span>服务名：`+result.data[i].service.sname+`</span>
                        <span>发布者：`+result.data[i].service.team.tname+`</span>
                        <span class="layui-icon layui-icon-group">`+result.data[i].service.snum+`</span>
                        <p>简介：`+result.data[i].service.sintro+`</p>
                    </div>
                    </a>
                </div>`;
			}
			$('#service_choose').html(servicetext);
			}
		}
	});
});
layui.use('element', function(){
    var element = layui.element;
});
layui.use('form', function(){
    var form = layui.form;
});
var index;
$(".lis").mouseover(function(){
	$('.head_content').show();
	index=$(this).index()-1;
	$('.head_content .page').eq(index).show();
})
$(".lis").mouseout(function(){
	$('.head_content').hide();
	index=$(this).index()-1;
	$('.head_content .page').eq(index).hide();
})
$('.head_content').mouseover(function(){
	$(this).show();
	$('.head_content .page').eq(index).show();
})
$('.head_content').mouseout(function(){
	$(this).hide();
	$('.head_content .page').eq(index).hide();
})
layui.use('util', function(){
	var util = layui.util;
	util.fixbar({
	  bar1: true,
	  bgcolor:'rgb(104, 157, 255);',
	});
  });
$('body').on('click',"#info",function(){
	window.location.href="usershow.html";
})

$("body").on("click","#exit",function(){
	$.ajax({
		url : "userlogout",
		dataType : "json",
		async : false,
		success : function(result) {
			if(result.code==200){
			layui.use('layer', function(){
				var layer = layui.layer;
					layer.msg(result.msg, {
						icon: 1,
						time:1000
					},function(){
						window.location.href="index.html";
					})
				})
			}
			}
		})
})
function getCookie(cookie_name) {
	var allcookies = document.cookie;
	//索引长度，开始索引的位置
	var cookie_pos = allcookies.indexOf(cookie_name);

	// 如果找到了索引，就代表cookie存在,否则不存在
	if (cookie_pos != -1) {
		// 把cookie_pos放在值的开始，只要给值加1即可
		//计算取cookie值得开始索引，加的1为“=”
		cookie_pos = cookie_pos + cookie_name.length + 1; 
		//计算取cookie值得结束索引
		var cookie_end = allcookies.indexOf(";", cookie_pos);
		
		if (cookie_end == -1) {
			cookie_end = allcookies.length;

		}
		//得到想要的cookie的值
		var value = unescape(allcookies.substring(cookie_pos, cookie_end)); 
	}
	return value;
}