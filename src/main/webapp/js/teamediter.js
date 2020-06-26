$(document).ready(function() {
	var id = getCookie("useridss");
	$.ajax({
		url : "../theteam2?uid="+id,
		dataType : "json",
		async : false,
		success : function(result) {
			if(result.code==200){
				$('#tname').val(result.data.tname);
				$('#uname').val(result.data.user.uname);
				$('#tmajor').val(result.data.tmajor);
				$("#tdate").val(result.data.tdate);
				$("#tintro").val(result.data.tintro);
			}
		}
    });
    $(document).ready(function() {
		$.ajax({
			url : "../teamuser2?uid="+id,
			dataType : "json",
			async : false,
			success : function(result) {
				if(result.code==200){
				    var usertext=``;
				    for(var i=0;i<result.data.length;i++){
					    usertext+=`
					    <div id="rolebox">
                        <div id="mode" class="mode layui-icon layui-icon-delete" ><label style="display: none;">`+result.data[i].uid+`</label></div>
                        <img src="../img/user/`+result.data[i].upic+`" title="`+result.data[i].uschool+`-`+result.data[i].uname+` alt="">
                        </div>`;
				    }
				    $('.user').html(usertext);
				}
			}
		});
	});
});
layui.use('form', function(){
    var form = layui.form;
});
$("body").on('mouseover',"#rolebox",function(){
    $(this).children("#mode").show();
})
$("body").on('mouseout',"#rolebox",function(){
    $(this).children("#mode").hide();
})
$("body").on('click',".layui-icon-delete",function(){
    var uid=$(this).children("label").text();
        var id = getCookie("useridss");
        $.ajax({
            url : "../deleuser?uid="+uid+"&id="+id,
            dataType : "json",
            async : false,
            success : function(result) {
                layui.use('layer', function(){
                    var layer = layui.layer;
                    if(result.code==200){
                        layer.msg(result.msg, {
                            icon: 1
                        },function(){
                            window.location.href="teamediter.html";
                        }); 
                    }else{
                        layer.msg(result.msg, {
                            icon: 2
                        },function(){
                            window.location.href="teamediter.html";
                        });   
                    }    
                });
            }
        });  
})
$('body').on("click",".create",function(){
    var uid = getCookie("useridss");
	var tname=$("#tname").val();
	var tintro=$("#tintro").val();
	if((tname!=""&&tname!=null)&&(tintro!=""&&tintro!=null)){
		$.ajax({
			url : "../exitteam?uid="+uid+"&tname="+tname+"&tintro="+tintro,
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
                            window.location.href="information.html";
                        })
					}else{
						layer.msg(result.msg, {
							icon: 2,
							time:1000
					})
					}
				});
			}
		});
	}
})
$('body').on("click",".reset",function(){
    window.location.href="teamediter.html";
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