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
					$("#text").val(result.data.uname);
					$(".uid").val(id);
				}
			}
		});
		$("#cookie").show();
	}
	var qid = getUrlParam("qid");
	$.ajax({
		url : "thequestion?qid="+qid,
		dataType : "json",
		async : false,
		success : function(result) {
			if(result.code==200){
				$('#qname').html(result.data.qname);
				$('#uname').html("提出人："+result.data.user.uname);
				$('#qtime').html("发表于："+result.data.qtime);
				$('#qcommon').html(result.data.qcommon);
				$('#qgood').html(result.data.qgood);
				$('#qbad').html(result.data.qbad);
				$('#qcontent').html(result.data.qcontent);
			}
		}
	});
	$.ajax({
		url : "commentlist?qid="+qid,
		dataType : "json",
		async : false,
		success : function(result) {
			if(result.code==200){
				$('.title').html("全部评论/"+result.data.length);
				var rowtext=``;
				for(var i=0;i<result.data.length;i++){
					rowtext+=`
					<li>
						<div class="picbox" id="picbox">
                        	<img src="img/user/`+result.data[i].user.upic+`" alt="">
                    	</div>
                    	<p>`+result.data[i].user.uname+`：</p>
                    	<p>`+result.data[i].ccontent+`</p>
                    	<p>`+result.data[i].ctime+`</p>
                	</li>`;
				}
				$('.common_box ul').html(rowtext);
			}
		}
	});
	$.ajax({
		url : "newquestion",
		dataType : "json",
		async : false,
		success : function(result) {
			if(result.code==200){
				var litext=``;
				for(var i=0;i<result.data.length;i++){
					litext+=`
					<li>
                    	<a href="common.html?qid=`+result.data[i].qid+`"><p>`+result.data[i].qname+`</p></a>
                    	<p>发表于：`+result.data[i].qtime+`</p>
                	</li>`;
				}
				$('.list ul').html(litext);
			}
		}
	});
});
$('#qgood').click(function(){
	var id = getCookie("useridss");
	if(id!=undefined){
		var qid = getUrlParam("qid");
	$.ajax({
		url : "goodquestion?qid="+qid,
		dataType : "json",
		async : false,
		success : function(result) {
			if(result.code==200){
				layui.use('layer', function(){
					var layer = layui.layer;
					layer.msg('你顶了此讨论', {
						icon:1,
						time:1000
					},function(){
						window.location.href="common.html?qid="+qid;
					});
				});
			}
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
$('#qbad').click(function(){
	var id = getCookie("useridss");
	if(id!=undefined){
		var qid = getUrlParam("qid");
	$.ajax({
		url : "badquestion?qid="+qid,
		dataType : "json",
		async : false,
		success : function(result) {
			if(result.code==200){
				layui.use('layer', function(){
					var layer = layui.layer;
					layer.msg('你踩了此讨论', {
						icon:1,
						time:1000
					},function(){
						window.location.href="common.html?qid="+qid;
					});
				});	
			}
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
function getUrlParam(name)
{
var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
var r = window.location.search.substr(1).match(reg);  //匹配目标参数
if (r!=null) return unescape(r[2]); return null; //返回参数值
}
$('.incomment').on("click",function(){
	var id = getCookie("useridss");
	if(id!=undefined){
	var qid = getUrlParam("qid");
	var uid=$('.uid').val();
	var ccontent=$('.ccontent').val();
	if(ccontent!=null&&ccontent!=""){
	$.ajax({
		url : "newcomment?qid="+qid+"&uid="+uid+"&ccontent="+ccontent,
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
						location.href = "common.html?qid=" + qid;
					}); 
				}else{
					layer.msg(result.msg, {
						icon: 2,
						time:1000
					},function(){
						location.href = "common.html?qid=" + qid;
					}); 
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
layui.use('util', function(){
	var util = layui.util;
	util.fixbar({
	  bar1: true,
	  bgcolor:'rgb(104, 157, 255);',
	});
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
layui.use('form', function(){
    var form = layui.form;
});
$('#textarea').on('input',function(){
    var context=$(this).val().length;
    $('#lengg').html(context);
})
$('body').on('click',"#info",function(){
	window.location.href="usershow.html";
})

$("body").on("click","#exit",function(){
	var qid = getUrlParam("qid");
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
						window.location.href="common.html?qid="+qid;
					})
				})
			}
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
