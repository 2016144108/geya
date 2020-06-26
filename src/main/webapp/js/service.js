$(document).ready(function() {
    var uid = getCookie("useridss");
    $("#userid").val(uid);
	$.ajax({
		url : "../showmyservice?uid="+uid,
		dataType : "json",
		async : false,
		success : function(result) {
			if(result.code==200){
			var htmltext=``;
			for(var i=0;i<result.data.length;i++){
				htmltext+=`
				<tr>
                    <td>`+result.data[i].sname+`</td>
                    <td>`+result.data[i].team.tname+`</td>
                    <td>
                        <div class="picbox" id="picbox">
                            <img src="../img/service/`+result.data[i].spic+`" alt="">
                        </div>
                    </td>
                    <td>`+result.data[i].smajor+`</td>
                    <td>`+result.data[i].sctime+`</td>
                    <td>`+result.data[i].sstate+`</td>
                    <td>
                        <span class="layui-icon layui-icon-edit"><label style="display: none;">`+result.data[i].sid+`</label></span>
                        <span class="layui-icon layui-icon-delete"><label style="display: none;">`+result.data[i].sid+`</label></span>
                    </td>
                  </tr>`;
			}
			$('tbody').html(htmltext);
			}
		}
	});
});
layui.use('table', function(){
    var table = layui.table;
    table.init('demo2', {
        page:{theme: 'blue'},
        toolbar: true ,
        defaultToolbar: ['filter', 'print', 'exports'],
        limit: 10
}); 
});
$("body").on('click',".layui-icon-edit",function(){
    var sid=$(this).children("label").text();
    window.location.href="serviceediter.html?sid="+sid;
})
$("body").on('click',".layui-icon-delete",function(){
    var sid=$(this).children("label").text();
    $.ajax({
		url : "../deleteservice?sid="+sid,
		dataType : "json",
		async : false,
		success : function(result) {
			if(result.code==200){
                layui.use('layer', function(){
                    var layer = layui.layer;
                    layer.msg(result.msg, {
                        icon: 1
                        },function(){
                            window.location.href="service.html";
                        });  
                });
			}else{
                layui.use('layer', function(){
                    var layer = layui.layer;
                    layer.msg(result.msg, {
                        icon: 2
                        },function(){
                            window.location.href="service.html";
                        });  
                });
            }
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
