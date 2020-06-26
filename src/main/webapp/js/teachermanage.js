$(document).ready(function() {
	$.ajax({
		url : "../showteacher",
		dataType : "json",
		async : false,
		success : function(result) {
			if(result.code==200){
			var htmltext=``;
			for(var i=0;i<result.data.length;i++){
				htmltext+=`
				<tr>
                        <td>`+result.data[i].tname+`</td>
                        <td>`+result.data[i].tschool+`</td>
                        <td>`+result.data[i].tstatus+`</td>
                        <td>`+result.data[i].tmajor+`</td>
                        <td>
                          <div class="picbox" id="picbox">
                            <img src="../img/teacher/`+result.data[i].tpic+`" alt="">
                        </div>
                        </td>
                        <td>`+result.data[i].ttelephone+`</td>
                        <td>`+result.data[i].tintro+`</td>
                        <td>
                            <span class="layui-icon layui-icon-edit"><label style="display: none;">`+result.data[i].tid+`</label></span>
                            <span class="layui-icon layui-icon-delete"><label style="display: none;">`+result.data[i].tid+`</label></span>
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
    var tid=$(this).children("label").text();
    $.ajax({
		url : "../deleteteacher?tid="+tid,
		dataType : "json",
		async : false,
		success : function(result) {
			layui.use('layer', function(){
                var layer = layui.layer;
                layer.msg(result.msg, {
                    icon: 1
                    },function(){
                       window.location.href="teachermanage.html";
                    });  
            });
		}
	});
})
$("body").on('click',".layui-icon-edit",function(){
	var tid=$(this).children("label").text();
	window.location.href="teacherediter.html?tid="+tid;
})