$(document).ready(function() {
    var lid = getUrlParam("lid");
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
	$.ajax({
		url : "../show?lid="+lid,
		dataType : "json",
		async : false,
		success : function(result) {
			$("#lname").val(result.data.lname);
			$("#lteacher").val(result.data.lteacher);
			$("#lstar").val(result.data.lstar);
			$("#lurl").val(result.data.lurl);
			$("#lintro").val(result.data.lintro);
			$("#lmajor").val(result.data.mid);
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
    var lid = getUrlParam("lid");
	var lname=$("#lname").val();
	var lteacher=$("#lteacher").val();
	var lstar=$("#lstar").val();
	var lurl=$("#lurl").val();
	var lintro=$("#lintro").val();
	var mid=$("#lmajor").val();
	var lmajor=$("select option:checked").text();
	if((lname!=""&&lname!=null)&&(lteacher!=""&&lteacher!=null)&&(lstar!=""&&lstar!=null)&&(lurl!=""&&lurl!=null)&&(lintro!=""&&lintro!=null)&&(lmajor!=""&&lmajor!=null)){
        $.ajax({
			url : "../uplesson?lid="+lid+"&lname="+lname+"&lteacher="+lteacher+"&lstar="+lstar+"&lurl="+lurl+"&lintro="+lintro+"&mid="+mid+"&lmajor="+lmajor,
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
    var lid = getUrlParam("lid");
    window.location.href="lessonediter.html?lid="+lid;
})
function getUrlParam(name)
{
var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
var r = window.location.search.substr(1).match(reg);  //匹配目标参数
if (r!=null) return unescape(r[2]); return null; //返回参数值
}
function getUrlParam(name)
{
var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
var r = window.location.search.substr(1).match(reg);  //匹配目标参数
if (r!=null) return unescape(r[2]); return null; //返回参数值
}
