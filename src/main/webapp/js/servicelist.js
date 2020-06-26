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
	$.ajax({
		url : "showservice",
		dataType : "json",
		async : false,
		success : function(result) {
			if(result.code==200){
			$('.li_show').html(result.msg);
			var htmltext=``;
			for(var i=0;i<result.data.length;i++){
				htmltext+=`
				<div class="layui-col-md4">
                	<div id="" class="box">
                    	<label>`+result.data[i].sid+`</label>
                    	<div id="" class="img_box">   
                        	<img src="img/service/`+result.data[i].spic+`" alt="">
                   	 	</div>
                    	<span>服务名：`+result.data[i].sname+`</span>
                    	<span>发布者：`+result.data[i].team.tname+`</span>
                    	<span class="layui-icon layui-icon-group">`+result.data[i].snum+`</span>
                    	<p>`+result.data[i].sintro+`</p>
                	</div>
            	</div>`;
			}
			$('.layui-row').html(htmltext);
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
layui.use('form', function(){
  	var form = layui.form;
});
$('body').on("click",".box",function(){
    var sid=$(this).children('label').text();
    location.href = "serviceinfo.html?sid=" + sid;
})
$('ul').on('click','.li_choose',function(){
	var type=$(this).text();
    location.href = "servicechoose?type=" + type;
})
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
						window.location.href="servicelist.html";
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
