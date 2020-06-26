$(document).ready(function() {
	$.ajax({
		url : "../showservice",
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
                            window.location.href="servicemanage.html";
                        });  
                });
			}else{
                layui.use('layer', function(){
                    var layer = layui.layer;
                    layer.msg(result.msg, {
                        icon: 2
                        },function(){
                            window.location.href="servicemanage.html";
                        });  
                });
            }
		}
	});  
})