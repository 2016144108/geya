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
	var sid = getUrlParam("sid");
	$.ajax({
		url : "thestory?sid="+sid,
		dataType : "json",
		async : false,
		success : function(result) {
			if(result.code==200){
				$('#sname').html(result.data.sname);
				$('#stime').html("时间："+result.data.stime);
				$('#sread').html("浏览量："+result.data.sread);
				$("#scontent").html(result.data.scontent);
			}
		}
	});
});
layui.use('util', function(){
	var util = layui.util;
	util.fixbar({
	  bar1: true,
	  bgcolor:'rgb(104, 157, 255);',
	});
  });
function getUrlParam(name)
{
var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
var r = window.location.search.substr(1).match(reg);  //匹配目标参数
if (r!=null) return unescape(r[2]); return null; //返回参数值
}
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
	var sid = getUrlParam("sid");
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
						window.location.href="storyinfo.html?sid="+sid;
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
