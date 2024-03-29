$(document).ready(function() {
	var id = getCookie("useridss");
	if(id!=undefined){
		$.ajax({
			url : "userinfo?uid="+id,
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
	var tid = getUrlParam("tid");
	$.ajax({
		url : "theteam?tid="+tid,
		dataType : "json",
		async : false,
		success : function(result) {
			if(result.code==200){
				$("#headbox #imgbox img").attr("src","img/team/"+result.data.tpic);
				$('#tname').html(result.data.tname);
				$('#uname').html("负责人："+result.data.user.uname);
				$('#tmajor').html("服务领域："+result.data.tmajor);
				$("#tdate").html("成立时间："+result.data.tdate);
				$("#tintro").html("团队简介："+result.data.tintro);
				$("#tcontent").html(result.data.tintro+result.data.tintro+result.data.tintro+result.data.tintro+result.data.tintro);
			}
		}
	});
	$(document).ready(function() {
		$.ajax({
			url : "teamuser?tid="+tid,
			dataType : "json",
			async : false,
			success : function(result) {
				if(result.code==200){
				var usertext=``;
				for(var i=0;i<result.data.length;i++){
					usertext+=`
					<div class="layui-col-md2">
                        <div id="box">
                            <div id="imgbox">
                                <img src="img/user/`+result.data[i].upic+`" title="`+result.data[i].uschool+`-`+result.data[i].uname+`">
                            </div>
                            <title id="role">`+result.data[i].uname+`</title>
                        </div>
                    </div>`;
				}
				$('.user').html(usertext);
				}
			}
		});
	});
	$(document).ready(function() {
		$.ajax({
			url : "teamservice?tid="+tid,
			dataType : "json",
			async : false,
			success : function(result) {
				if(result.code==200){
				var servicetext=``;
				for(var i=0;i<result.data.length;i++){
					servicetext+=`
					<div class="layui-col-md6">
                        <div id="servicebox" class="servicebox">
                            <label id="sid" class="sid" style="display: none;">`+result.data[i].sid+`</label>
                            <div id="imgbox">
                                <img src="img/service/`+result.data[i].spic+`" alt="" srcset="">
                            </div>
                            <span>`+result.data[i].sname+`</span>
                            <span>`+result.data[i].smajor+`</span>
                            <span>`+result.data[i].sintro+`</span>
                        </div>
                    </div>`;
				}
				$('.service').html(servicetext);
				}
			}
		});
	});
	$(document).ready(function() {
		$.ajax({
			url : "teamstory?tid="+tid,
			dataType : "json",
			async : false,
			success : function(result) {
				if(result.code==200){
				var storytext=``;
				var stortlist=``;
				for(var i=0;i<result.data.length;i++){
					storytext+=`
					<a href="storyinfo.html?sid=`+result.data[i].sid+`">
					<div class="layui-col-md12">
                        <div id="ibox">
                            <p id="info">标题：`+result.data[i].sname+`</p>
                            <p id="info">发布时间：`+result.data[i].stime+`</p>
                        </div>
					</div></a>`;
					stortlist+=`
					<a href="storyinfo.html?sid=`+result.data[i].sid+`">
					<li class="layui-timeline-item">
                        <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                        <div class="layui-timeline-content layui-text">
                            <h3 class="layui-timeline-title">`+result.data[i].stime+`</h3>
                            <p>`+result.data[i].sname+`<br>`+result.data[i].sintro+`</p>
                        </div>
                    </li></a>`;
				}
				$('.story').html(storytext);
				$('.layui-timeline').html(stortlist);
				}
			}
		});
	});
});
function getUrlParam(name)
{
var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
var r = window.location.search.substr(1).match(reg);  //匹配目标参数
if (r!=null) return unescape(r[2]); return null; //返回参数值
}
layui.use('element', function(){
    var element = layui.element;
});
$('.layui-tab-item').eq(3).on("click",".servicebox",function(){
    var sid=$(this).children('#sid').text();
    location.href = "serviceinfo.html?sid=" + sid;
})
layui.use('util', function(){
	var util = layui.util;
	util.fixbar({
	  bar1: true,
	  bgcolor:'rgb(104, 157, 255);',
	});
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
$('body').on('click',"#info",function(){
	window.location.href="usershow.html";
})

$("body").on("click","#exit",function(){
	var tid = getUrlParam("tid");
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
						window.location.href="teaminfo.html?tid="+tid;
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