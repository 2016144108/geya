$(document).ready(function() {
	// var id = getCookie("useridss");
	// console.log(id);
	// if(id!=undefined){
	// 	var name = getCookie("uname");
	// 	var telephone = getCookie("utelephone");
	// 	$("#info").html(name+telephone);
	// 	$("#cookie").show();
	// }
	$.ajax({
		url : "../showteacher2",
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
                        <td><span class="layui-icon layui-icon-reply-fill"><label style="display: none;">`+result.data[i].tintro+`</label></span><span class="layui-icon layui-icon-cellphone-fine"><label style="display: none;">`+result.data[i].ttelephone+`</label></span></td>
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
$("body").on('click',".layui-icon-cellphone-fine",function(){
    var telephone=$(this).children("label").text();
    layui.use('layer', function(){
        var layer = layui.layer;
        layer.open({
            type:0, 
			shadeClose:true,
            title :'联系方式',
            content:telephone,
            area: ['600px', '200px']
        });
    });
})
$("body").on('click',".layui-icon-reply-fill",function(){
    var intro=$(this).children("label").text();
    layui.use('layer', function(){
        var layer = layui.layer;
        layer.open({
            type:0, 
			shadeClose:true,
            title :'个人简介',
            content:intro,
            area: ['600px', '200px']
        });
    });
})
