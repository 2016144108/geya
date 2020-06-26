$('.layui-nav-item').hover(function(){
    $('.layui-nav-bar').show();
})
$('.logout').hover(function(){
    $('.layui-nav-bar').hide();
})
$('.logout').click(function(){
	$.ajax({
		url : "../adminout",
		dataType : "json",
		async : false,
		success : function(result) {
			layui.use('layer', function(){
				var layer = layui.layer;
				layer.msg('管理员已注销', {
					icon: 1,
					time:1000
					},function(){
						window.location="denglu.html";
					});  
			});
		}
	});
})
