$(document).ready(function() {
	var id = getCookie("useridss");
	if(id!=undefined){
		$.ajax({
			url : "../userinfo?uid="+id,
			dataType : "json",
			async : false,
			success : function(result) {
				if(result.code==200){
					$("#user").html(result.data.uname);
					$(".userimg").attr("src","../img/user/"+result.data.upic);
					$("#info").attr("href","../isinfo?uid="+id);
					$("#tedi").attr("href","../istedi?uid="+id);
					$("#ser").attr("href","../isser?uid="+id);
					$("#serc").attr("href","../isserc?uid="+id);
					$("#sci").attr("href","../issci?uid="+id);
					$("#scic").attr("href","../isscic?uid="+id);
					$("#que").attr("href","../isque?uid="+id);
					$("#com").attr("href","../iscom?uid="+id);
				}
			}
		});
	}
});
$('.layui-nav-item').hover(function(){
    $('.layui-nav-bar').show();
})
$('.logout').hover(function(){
    $('.layui-nav-bar').hide();
})
$('.logout').click(function(){
	$.ajax({
		url : "../outma",
		dataType : "json",
		async : false,
		success : function(result) {
			layui.use('layer', function(){
				var layer = layui.layer;
				layer.msg('用户已注销', {
					icon: 1,
					time:1000
					},function(){
						window.location="../index.html";
					});  
			});
		}
	});
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
