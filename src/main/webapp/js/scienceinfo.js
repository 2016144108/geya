$(document).ready(function() {
	var id = getCookie("useridss");
	if(id!=undefined){
		$.ajax({
			url : "userinfo?uid="+id,
			dataType : "json",
			async : false,
			success : function(result) {
				if(result.code==200){
					$("#info").html(result.data.uname+result.data.utelephone);
					$('#unames').val(result.data.uname);
				}
			}
		});
		$("#cookie").show();
		$('#uids').val(id);
	}
	var sid = getUrlParam("sid");
	$.ajax({
		url : "thescience?sid="+sid,
		dataType : "json",
		async : false,
		success : function(result) {
			if(result.code==200){
				$('#sname').html(result.data.sname);
				$('#uname').html("负责人："+result.data.uname);
				$('#stime').html("成立时间："+result.data.stime);
				$("#smajor").html("所属领域："+result.data.smajor);
				$("#tname").html("所属团队："+result.data.tname);
				$("#snum").html(`<label class="layui-icon layui-icon-group"></label>热度：`+result.data.snum);
				$("#sintro").html(result.data.sintro);
				$(".img_box img").attr("src","img/science/"+result.data.spic);
			}
		}
	});
	$.ajax({
		url : "question?sid="+sid,
		dataType : "json",
		async : false,
		success : function(result) {
			if(result.code==200){
				var rowtext=``;
				for(var i=0;i<result.data.length;i++){
					rowtext+=`
					<a href="common.html?qid=`+result.data[i].qid+`">
                        <div class="layui-col-md12">
                            <div id="" class="box">
                                <span>`+result.data[i].qname+`</span>
                                <span>`+result.data[i].user.uname+`</span>
                                <span>发表于 - `+result.data[i].qtime+`</span>
                                <span class="layui-icon layui-icon-dialogue">`+result.data[i].qcommon+`</span>
                                <span class="layui-icon layui-icon-praise">`+result.data[i].qgood+`</span>
                                <span class="layui-icon layui-icon-tread">`+result.data[i].qbad+`</span>
                            </div>
                        </div>
                    </a>`
				}
				$("#sque").html(`<label class="layui-icon layui-icon-reply-fill"></label>话题：`+result.data.length);
				$('.question').html(rowtext);
			}
		}
	});
});

$("body").on('click',".join",function(){	
	var uid = getCookie("useridss");
    var sid = getUrlParam("sid");
	if(uid!=undefined){
		$.ajax({
			url : "joinscience?uid="+uid+"&sid="+sid,
			dataType : "json",
			async : false,
			success : function(result) {
				layui.use('layer', function(){
					var layer = layui.layer;
					if(result.code==200){
						layer.msg(result.msg, {
							icon: 1
							},function(){
							   window.location.href="scienceinfo.html?sid="+sid;
						});
					}else{
						layer.msg(result.msg, {
							icon: 2
						});
					}
	                  
	            });
			}
		});
	}else{
		layui.use('layer', function(){
			var layer = layui.layer;
			layer.msg('请先登录', {
				icon:5,
				time:1000
			},function(){
				window.location.href="index.html";
			});
		});
	}
})
layui.use('util', function(){
	var util = layui.util;
	util.fixbar({
	  bar1: true,
	  bgcolor:'rgb(104, 157, 255);',
	});
  });
function getUrlParam(name)
{
var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
var r = window.location.search.substr(1).match(reg);  //匹配目标参数
if (r!=null) return unescape(r[2]); return null; //返回参数值
}
layui.use('element', function(){
    var element = layui.element;
});
layui.use('form', function(){
    var form = layui.form;
});
var index;
$(".lis").mouseover(function(){
	$('.head_content').show();
	index=$(this).index()-1;
	$('.head_content .page').eq(index).show();
})
$(".lis").mouseout(function(){
	$('.head_content').hide();
	index=$(this).index()-1;
	$('.head_content .page').eq(index).hide();
})
$('.head_content').mouseover(function(){
	$(this).show();
	$('.head_content .page').eq(index).show();
})
$('.head_content').mouseout(function(){
	$(this).hide();
	$('.head_content .page').eq(index).hide();
})

$('body').on('click',"#info",function(){
	window.location.href="usershow.html";
})

$("body").on("click","#exit",function(){
	var sid = getUrlParam("sid");
	$.ajax({
		url : "userlogout",
		dataType : "json",
		async : false,
		success : function(result) {
			if(result.code==200){
			layui.use('layer', function(){
				var layer = layui.layer;
					layer.msg(result.msg, {
						icon: 1,
						time:1000
					},function(){
						window.location.href="scienceinfo.html?sid="+sid;
					})
				})
			}
			}
		})
})
$("#create").click(function(){
	layui.use('layer', function(){
		var layer = layui.layer;
		var $=layui.jquery;
		layer.open({
			type:1, 
			fixed:true,
			area: ['800px', '300px'],
			shadeClose:true,
			title:"新增话题",
			content:$("#model"),	
			success: function(layero, index){
    			$('.layui-layer-content').css({"height":"500px"});
  			}
		});
	});  
})

$('body').on("click","#model #submit",function(){
	var id = getCookie("useridss");
	if(id!=undefined){
	var uid=$("#uids").val();
	var qname=$("#qname").val();
	var qcontent=$(".qcontent").val();
	var sid = getUrlParam("sid");
	if((qname!=""&&qname!=null)&&(qcontent!=""&&qcontent!=null)){
		$.ajax({
			url : "createque?uid="+uid+"&qname="+qname+"&qcontent="+qcontent+"&sid="+sid,
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
							window.location.href="scienceinfo.html?sid="+sid;
						})
					}else{
						layer.msg(result.msg, {
							icon: 2,
							time:1000
					},function(){
						window.location.href="scienceinfo.html?sid="+sid;
					})
					}
				});
			}
		});
	}else{
	layui.use('layer', function(){
		var layer = layui.layer;
			layer.msg("你还没有评论", {
				icon: 5,
				time:1000
			})
		});
	}
	}else{
		layui.use('layer', function(){
			var layer = layui.layer;
			layer.msg('请先登录', {
				icon:5,
				time:1000
			},function(){
				window.location.href="index.html";
			});
		});
	}
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

// $('body').on("change","#stytle",function(){
// 	var sid = getUrlParam("sid");
// 	var style=$("select option:checked").val();
// 	window.location.href="questionstyle?style="+style+"&sid="+sid;
// });