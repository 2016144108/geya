$(document).ready(function() {
	var uid = getCookie("useridss");
	if(uid!=undefined){
		$(".sid").val(uid);
	}
	$.ajax({
		url : "../showsciencelink?uid="+uid,
		dataType : "json",
		async : false,
		success : function(result) {
			if(result.code==200){
			var htmltext=``;
			for(var i=0;i<result.data.length;i++){
				htmltext+=`
				<tr>
                    <td>`+result.data[i].science.sname+`</td>
                    <td>`+result.data[i].science.team.tname+`</td>
                    <td>`+result.data[i].science.smajor+`</td>
                    <td>`+result.data[i].science.snum+`人</td>
                    <td>`+result.data[i].science.stime+`</td>
                    <td><span class="layui-icon layui-icon-delete"><label style="display: none;">`+result.data[i].scid+`</label></span></td>
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
$("body").on('click',".layui-icon-delete",function(){
    var scid=$(this).children("label").text();
    $.ajax({
		url : "../deletesciencelink?scid="+scid,
		dataType : "json",
		async : false,
		success : function(result) {
			layui.use('layer', function(){
                var layer = layui.layer;
                layer.msg(result.msg, {
                    icon: 1
                    },function(){
                       window.location.href="sciencelink.html";
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

