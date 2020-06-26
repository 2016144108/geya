$(document).ready(function(){
    $.ajax({
		url : "../showmajor",
		dataType : "json",
		async : false,
		success : function(result) {
			if(result.code==200){
        var majorlist=`<option value=""></option>`;
        for(var i=0;i<result.data.length;i++){
          majorlist+=`<option value="`+result.data[i].mid+`">`+result.data[i].mname+`</option>`
        }
				$("#tmajor").html(majorlist);
			}
		}
	});
});
layui.use('form', function(){
    var form = layui.form;
});
layui.use('upload', function(){
    var upload = layui.upload;
    var uploadInst = upload.render({
        elem: '#test1',
        url: '../teacherpic', 
        done: function(result){
            layui.use('layer', function(){
              var layer = layui.layer;
              layer.msg(result.msg, {icon: 1});
            }); 
        },
    });
});

$('body').on("click",".send",function(){
	var tname=$("#tname").val();
	var tschool=$("#tschool").val();
	var tstatus=$("#tstatus").val();
	var ttelephone=$("#ttelephone").val();
	var tintro=$("#tintro").val();
	var mid=$("#tmajor").val();
	var tmajor=$("select option:checked").text();
	if((tname!=""&&tname!=null)&&(tschool!=""&&tschool!=null)&&(tstatus!=""&&tstatus!=null)&&(ttelephone!=""&&ttelephone!=null)&&(tintro!=""&&tintro!=null)&&(tmajor!=""&&tmajor!=null)){
        $.ajax({
			url : "../insertteacher?tname="+tname+"&tschool="+tschool+"&tstatus="+tstatus+"&ttelephone="+ttelephone+"&tintro="+tintro+"&mid="+mid+"&tmajor="+tmajor,
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
                            window.location.href="teachermanage.html";
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
	window.location.href="teachercreate.html";
})