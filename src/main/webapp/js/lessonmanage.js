$(document).ready(function() {
	$.ajax({
		url : "../showlesson",
		dataType : "json",
		async : false,
		success : function(result) {
			if(result.code==200){
			var htmltext=``;
			for(var i=0;i<result.data.length;i++){
				htmltext+=`
				<tr>
                        <td>`+result.data[i].lname+`</td>
                        <td>`+result.data[i].lmajor+`</td>
                        <td>`+result.data[i].lteacher+`</td>
                        <td>`+result.data[i].lstar+`</td>
                        <td>
                          <div class="picbox" id="picbox">
                            <img src="../img/lesson/`+result.data[i].lpic+`" alt="">
                          </div>
                        </td>
                        <td>`+result.data[i].lintro+`</td>
                        <td>`+result.data[i].lurl+`</td>
                        <td>
                            <span class="layui-icon layui-icon-edit"><label style="display: none;">`+result.data[i].lid+`</label></span>
                            <span class="layui-icon layui-icon-delete"><label style="display: none;">`+result.data[i].lid+`</label></span>
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
    var lid=$(this).children("label").text();
    $.ajax({
		url : "../deletelesson?lid="+lid,
		dataType : "json",
		async : false,
		success : function(result) {
			layui.use('layer', function(){
                var layer = layui.layer;
                layer.msg(result.msg, {
                    icon: 1
                    },function(){
                       window.location.href="lessonmanage.html";
                    });  
            });
		}
	});
})
$("body").on('click',".layui-icon-edit",function(){
    var lid=$(this).children("label").text();
    window.location.href="lessonediter.html?lid="+lid;
})

