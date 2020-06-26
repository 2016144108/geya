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
		url : "../showlesson",
		dataType : "json",
		async : false,
		success : function(result) {
			if(result.code==200){
			var htmltext=``;
			for(var i=0;i<result.data.length;i++){
				htmltext+=`
				<div class="layui-col-md3">
                    <div>
                        <img src="../img/lesson/`+result.data[i].lpic+`" alt="">
                        <p>`+result.data[i].lname+`</p>
                        <span>`+result.data[i].lteacher+`&nbsp;&nbsp;|</span>
                        <span>`+result.data[i].lmajor+`</span>
                        <span>认证</span>
						<p>`+result.data[i].lnum+`人最近报名</p>
						<label class="layui-icon layui-icon-star-fill"><label style="display: none;">`+result.data[i].lid+`</label></label>
                    </div>
                </div>`;
			}
			$('.layui-row').html(htmltext);
			}
		}
	});
});
$('body').on('click',".layui-icon-star-fill",function(){
	var uid = getCookie("useridss");
	var lid = $(this).children("label").text();
	$.ajax({
		url : "../joinmylesson?uid="+uid+"&lid="+lid,
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
						window.location.href="lesson.html";
					})
				}else{
					layer.msg(result.msg, {
						icon: 2,
						time:1000
					},function(){
						window.location.href="lesson.html";
					})
				}
				})
			}
	})
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