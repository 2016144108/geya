$('#submit').click(function(){
    var uname=$("#uname").val();
    var upassword=$("#upassword").val();
	$.ajax({
		url : "../adminlogin?uname="+uname+"&upassword="+upassword,
		dataType : "json",
		async : false,
		success : function(result) {
			layui.use('layer', function(){
                var layer = layui.layer;
                if(result.code==200){
                    layer.msg(result.msg, {
                        icon: 1,
                        time:1000
                        },function(){
                            window.location="manage.html";
                    });
                }else{
                    layer.msg(result.msg, {
                        icon: 1,
                        time:1000
                    });
                }
				  
			});
		}
	});
})