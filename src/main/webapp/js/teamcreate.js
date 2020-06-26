$(document).ready(function(){
  var uid = getCookie("useridss");
  var uname = getCookie("uname");
  $("#uid").val(uid);
  $("#uname").val(uname);
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
  layui.use('laydate', function(){
    var laydate = layui.laydate;
    laydate.render({
  elem: "#tdate",
  trigger: 'click',
  format: 'yyyy-MM-dd'
    });
  });
  layui.use('upload', function(){
    var upload = layui.upload;
    var uploadInst = upload.render({
        elem: '#tpic',
        url: '../teamload', 
        done: function(result){
          layui.use('layer', function(){
            var layer = layui.layer;
            layer.msg(result.msg, {icon: 1});
          }); 
        },
    });
});
$('body').on("click","#submit",function(){
	var tname=$("#tname").val();
	var uid=$("#uid").val();
	var mid=$("#tmajor").val();
	var tmajor=$("select option:checked").text();
	var tdate=$("#tdate").val();
	var tintro=$("#tintro").val();
	if((tname!=""&&tname!=null)&&(uid!=""&&uid!=null)&&(tmajor!=""&&tmajor!=null)&&(tdate!=""&&tdate!=null)&&(tintro!=""&&tintro!=null)&&(mid!=""&&mid!=null)){
		$.ajax({
			url : "../insertteam?tname="+tname+"&uid="+uid+"&tmajor="+tmajor+"&tdate="+tdate+"&tintro="+tintro+"&mid="+mid,
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
              window.location.href="information.html";
            })
					}else{
						layer.msg(result.msg, {
							icon: 2,
							time:1000
					},function(){
            window.location.href="teamcreate.html";
          })
					}
				});
			}
		});
	}
})
$('body').on("click",".reset",function(){
	window.location.href="teamcreate.html";
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