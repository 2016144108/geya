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
				$("#lmajor").html(majorlist);
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
        url: '../lessonpic', 
        done: function(result){
            layui.use('layer', function(){
              var layer = layui.layer;
              layer.msg(result.msg, {icon: 1});
            }); 
        },
    });
});

$('body').on("click",".send",function(){
	var lname=$("#lname").val();
	var lteacher=$("#lteacher").val();
	var lstar=$("#lstar").val();
	var lurl=$("#lurl").val();
	var lintro=$("#lintro").val();
	var mid=$("#lmajor").val();
	var lmajor=$("select option:checked").text();
	if((lname!=""&&lname!=null)&&(lteacher!=""&&lteacher!=null)&&(lstar!=""&&lstar!=null)&&(lurl!=""&&lurl!=null)&&(lintro!=""&&lintro!=null)&&(lmajor!=""&&lmajor!=null)){
        $.ajax({
			url : "../insertlesson?lname="+lname+"&lteacher="+lteacher+"&lstar="+lstar+"&lurl="+lurl+"&lintro="+lintro+"&mid="+mid+"&lmajor="+lmajor,
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
                            window.location.href="lessonmanage.html";
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
	window.location.href="lessoncreate.html";
})