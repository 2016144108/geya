$(document).ready(function(){
	var uid = getCookie("useridss");
	$.ajax({
		url : "../userinfo?uid="+uid,
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
				$("#upic").attr("src","../img/user/"+result.data.upic);
			}
		}
	});
});
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
layui.use('upload', function(){
    var upload = layui.upload;
    var uploadInst = upload.render({
        elem: '#newpic',
        url: '../editerload', 
        done: function(result){
			layui.use('layer', function(){
				var layer = layui.layer;
				layer.msg(result.msg, {icon: 1});
			}); 
        },
    });
});
$("#editer").click(function(){
	var uid = getCookie("useridss");
    var upassword=$("#newpassword").val();
    var utelephone=$("#utelephone").val();
    var uqq=$("#uqq").val();
    var ubirthday=$("#ubirthday").val();
    var uschool=$("#uschool").val();
    var ustudy=$("#ustudy").val();
    var ugrade=$("#ugrade").val();
    if((utelephone!=""&&utelephone!=null)&&(uqq!=""&&uqq!=null)&&(ubirthday!=""&&ubirthday!=null)&&(uschool!=""&&uschool!=null)&&(ustudy!=""&&ustudy!=null)&&(ugrade!=""&&ugrade!=null)){
		$.ajax({
			url : "../editeruser?uid="+uid+"&upassword="+upassword+"&utelephone="+utelephone+"&uqq="+uqq+"&ubirthday="+ubirthday+"&uschool="+uschool+"&ustudy="+ustudy+"&ugrade="+ugrade,
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
                            window.location.href="personinfo.html";
                        })
					}else{
						layer.msg(result.msg, {
							icon: 2,
							time:1000
					},function(){
                        window.location.href="personinfo.html";
                    })
					}
				});
			}
		});
	}
})
$(".reset").click(function(){
	window.location.href="personediter.html";
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