$(document).ready(function() {
	$.ajax({
		url : "../comments?",
		dataType : "json",
		async : false,
		success : function(result) {
			if(result.code==200){
			var htmltext=``;
			for(var i=0;i<result.data.length;i++){
				htmltext+=`
				<tr>
                    <td>`+result.data[i].user.uname+`</td>
                    <td>`+result.data[i].ccontent+`</td>
                    <td>`+result.data[i].ctime+`</td>
                    <td>`+result.data[i].cstate+`</td>`
                if(result.data[i].cstate=="已通过"){
                    htmltext+=`<td>
                    <span class="rejust">拒绝<label style="display: none;">`+result.data[i].cid+`</label></span>
                    <span class="layui-icon layui-icon-delete"><label style="display: none;">`+result.data[i].cid+`</label></span>
                    </td>
                </tr>`
                }else{
                    htmltext+=`<td>
                        <span class="layui-icon layui-icon-ok pass"><label style="display: none;">`+result.data[i].cid+`</label></span>
                        <span class="layui-icon layui-icon-delete"><label style="display: none;">`+result.data[i].cid+`</label></span>
                    </td>
                </tr>`
                };
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
    var cid=$(this).children("label").text();
    $.ajax({
		url : "../deletecomment?cid="+cid,
		dataType : "json",
		async : false,
		success : function(result) {
			if(result.code==200){
                layui.use('layer', function(){
                    var layer = layui.layer;
                    layer.msg(result.msg, {
                        icon: 1
                        },function(){
                            window.location.href="commonmanage.html";
                        });  
                });
			}else{
                layui.use('layer', function(){
                    var layer = layui.layer;
                    layer.msg(result.msg, {
                        icon: 2
                        },function(){
                            window.location.href="commonmanage.html";
                        });  
                });
            }
		}
	});  
})
$("body").on('click',".pass",function(){
    var cstate=$(this).text();
    var cid=$(this).children("label").text();
    $.ajax({
		url : "../setcomment?cid="+cid+"&cstate="+cstate,
		dataType : "json",
		async : false,
		success : function(result) {
			if(result.code==200){
                layui.use('layer', function(){
                    var layer = layui.layer;
                    layer.msg("已通过", {
                        icon: 1,
                        time: 1000
                        },function(){
                            window.location.href="commonmanage.html";
                        });  
                });
			}
		}
	});  
})