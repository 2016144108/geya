$(document).ready(function(){
    var uid = getCookie("useridss");
      $.ajax({
          url : "../themyteam?uid="+uid,
          dataType : "json",
          async : false,
          success : function(result) {
            if(result.code==200){
            $("#tname").val(result.data.tname);
            $("#smajor").val(result.data.tmajor);
            $("#mid").val(result.data.mid);
            $("#tid").val(result.data.tid);
          }
        }
      });
      $.ajax({
        url : "../serviceuser?uid="+uid,
        dataType : "json",
        async : false,
        success : function(result) {
            if(result.code==200){
            var userlist=`<option value=""></option>`;
            for(var i=0;i<result.data.length;i++){
                userlist+=`<option value="`+result.data[i].uid+`">`+result.data[i].uname+`</option>`
            }
        $("#uname").html(userlist);
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
        elem: "#start",
        trigger: 'click',      
        format: 'yyyy-MM-dd HH:mm:ss'
    });
    laydate.render({
        elem: "#end",
        trigger: 'click',
        format: 'yyyy-MM-dd HH:mm:ss'
    });
});
layui.use('upload', function(){
    var upload = layui.upload;
    var uploadInst = upload.render({
        elem: '#test1',
        url: '../servicepic', 
        done: function(result){
            layui.use('layer', function(){
              var layer = layui.layer;
              layer.msg(result.msg, {icon: 1});
            }); 
        },
    });
});
layui.use('upload', function(){
    var upload = layui.upload;
    var uploadInst = upload.render({
        elem: '#test2',
        accept:'file',
        url: '../servicefile', 
        done: function(result){
            layui.use('layer', function(){
              var layer = layui.layer;
              layer.msg(result.msg, {icon: 1});
            }); 
        },
    });
});
$('body').on("click",".send",function(){
	var sname=$("#sname").val();
	var tid=$("#tid").val();
	var uid=$("#uname").val();
	var stelephone=$("#stelephone").val();
	var mid=$("#mid").val();
	var smajor=$("#smajor").val();
	var sstime=$("#start").val();
	var setime=$("#end").val();
	var sintro=$("#sintro").val();
	if((sname!=""&&sname!=null)&&(uid!=""&&uid!=null)&&(stelephone!=""&&stelephone!=null)&&(sstime!=""&&sstime!=null)&&(setime!=""&&setime!=null)&&(sintro!=""&&sintro!=null)){
		$.ajax({
			url : "../newservice?sname="+sname+"&tid="+tid+"&uid="+uid+"&stelephone="+stelephone+"&mid="+mid+"&smajor="+smajor+"&sstime="+sstime+"&setime="+setime+"&sintro="+sintro,
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
                            window.location.href="service.html";
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
	window.location.href="servicecreate.html"
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