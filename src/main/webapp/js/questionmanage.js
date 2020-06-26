$(document).ready(function() {
	$.ajax({
		url : "../allquestion",
		dataType : "json",
		async : false,
		success : function(result) {
			if(result.code==200){
			var htmltext=``;
			for(var i=0;i<result.data.length;i++){
				htmltext+=`
				<tr>
                        <td>`+result.data[i].qname+`</td>
                        <td>`+result.data[i].user.uname+`</td>
                        <td>`+result.data[i].qtime+`</td>
                        <td>`+result.data[i].qcontent+`</td>
                        <td>
                        <span class="layui-icon layui-icon-ok"><label style="display: none;">`+result.data[i].qid+`</label></span>
                        <span class="layui-icon layui-icon-close"><label style="display: none;">`+result.data[i].qid+`</label></span>
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

$("body").on('click',".layui-icon-ok",function(){
    var qid=$(this).children("label").text();
    $.ajax({
		url : "../upquestion?qid="+qid,
		dataType : "json",
		async : false,
		success : function(result) {
			if(result.code==200){
                layui.use('layer', function(){
                    var layer = layui.layer;
                    layer.msg(result.msg, {
                        icon: 1
                        },function(){
                            window.location.href="questionmanage.html";
                        });  
                });
			}else{
                layui.use('layer', function(){
                    var layer = layui.layer;
                    layer.msg(result.msg, {
                        icon: 2
                        },function(){
                            window.location.href="questionmanage.html";
                        });  
                });
            }
		}
	});  
})
$("body").on('click',".layui-icon-close",function(){
    var qid=$(this).children("label").text();
    $.ajax({
		url : "../deletequestion?qid="+qid,
		dataType : "json",
		async : false,
		success : function(result) {
			if(result.code==200){
                layui.use('layer', function(){
                    var layer = layui.layer;
                    layer.msg("已驳回", {
                        icon: 1
                        },function(){
                            window.location.href="questionmanage.html";
                        });  
                });
			}else{
                layui.use('layer', function(){
                    var layer = layui.layer;
                    layer.msg(result.msg, {
                        icon: 2
                        },function(){
                            window.location.href="questionmanage.html";
                        });  
                });
            }
		}
	});  
})