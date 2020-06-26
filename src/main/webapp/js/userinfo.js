$(document).ready(function(){
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
				$('#userid').val(result.data.userid);
				$('#uname').val(result.data.uname);
				$('#upassword').val(result.data.upassword);
				$("#utelephone").val(result.data.utelephone);
				$("#uqq").val(result.data.uqq);
				$("#ubirthday").val(result.data.ubirthday);
				$("#uschool").val(result.data.uschool);
				$("#ustudy").val(result.data.ustudy);
				$("#ugrade").val(result.data.ugrade);
				$("#upic").attr("src","img/user/"+result.data.upic);
			}
		}
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
layui.use('form', function(){
    var form = layui.form;
});
layui.use('laydate', function(){
    var laydate = layui.laydate;
    laydate.render({
        elem: ".birthday",
        trigger: 'click',      
        format: 'yyyy-MM-dd'
    });
});
$('body').on('click',"#info",function(){
	window.location.href="usershow.html";
})
layui.use('util', function(){
	var util = layui.util;
	util.fixbar({
	  bar1: true,
	  bgcolor:'rgb(104, 157, 255);',
	});
  });
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
