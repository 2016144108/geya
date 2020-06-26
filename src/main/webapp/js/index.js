$(document).ready(function(){
	var id = getCookie("useridss");
	if(id!=undefined){
		$.ajax({
			url : "userinfo?uid="+id,
			dataType : "json",
			async : false,
			success : function(result) {
				if(result.code==200){
					$("#info").html(result.data.uname+result.data.utelephone);
					$("#gutelephone").val(result.data.utelephone);
					$("#chtitle").val("用户："+result.data.utelephone);
				}
			}
		});
		$("#login").hide();
		$("#cookie").show();
		$(".click_box").hide();
		$("#chuid").val(id);
	}
	
	$.ajax({
		url : "indexscience",
		dataType : "json",
		async : false,
		success : function(result) {
			if(result.code==200){
			var litext=``;
			for(var i=0;i<result.data.length;i++){
				litext+=`
				<a href="scienceinfo.html?sid=`+result.data[i].sid+`">
                    <li>
                        <div id="" class="img_box">
                            <img src="img/science/`+result.data[i].spic+`" alt="">
                        </div>
                        <span>`+result.data[i].sname+`</span>
                        <span>负责人：`+result.data[i].user.uname+`</span>
                        <span>浏览量：`+result.data[i].snum+`</span>
                    </li>
                </a>`;
			}
			$('#lun_box ul').html(litext);
			}
		}
	});
	$.ajax({
		url : "indexteam",
		dataType : "json",
		async : false,
		success : function(result) {
			if(result.code==200){
			var htmltext=``;
			for(var i=0;i<result.data.length;i++){
				htmltext+=`
				<div class="layui-col-md3">
                    <div id="" class="box2">
                        <label id="tid" style="display: none;">`+result.data[i].tid+`</label>
                        <div id="" class="img_box">
                            <img src="img/team/`+result.data[i].tpic+`" alt="">
                        </div>
                        <span>`+result.data[i].tname+`</span>
                        <span>负责人：`+result.data[i].user.uname+`</span>
                        <span>成员：`+result.data[i].tnum+`</span>
                    </div>
                </div>`;
			}
			$('.right_box').html(htmltext);
			}
		}
	});
	$.ajax({
		url : "showsch",
		dataType : "json",
		async : false,
		success : function(result) {
			if(result.code==200){
			var schtext=`<a href="school.html"><li>注册高校</li></a>`;
			for(var i=0;i<result.data.length;i++){
				schtext+=`<a href="school.html"><li><img src="img/school/`+result.data[i].spic+`" alt="">`+result.data[i].sname+`</li></a>`;
			}
			$('#schlist').html(schtext);
			}
		}
	});
});
layui.use('util', function(){
  var util = layui.util;
  util.fixbar({
    bar1: true,
	bgcolor:'rgb(104, 157, 255);',
  });
});
layui.use('form', function(){
    var form = layui.form;
});
layui.use('laydate', function(){
    var laydate = layui.laydate;
    laydate.render({
        elem: ".birthday",
        trigger: 'click',      
        format: 'yyyy-MM-dd'
    });
});
layui.use('upload', function(){
    var upload = layui.upload;
    var uploadInst = upload.render({
        elem: '#newpic',
        url: 'upload', 
        done: function(result){
			layui.use('layer', function(){
				var layer = layui.layer;
				layer.msg(result.msg, {icon: 1});
			}); 
        },
    });
});
$(".abox1").mouseenter(function(){
    $(this).children("p").animate({"width":"100%"});
})
$(".abox2").mouseenter(function(){
    $(this).children("p").animate({"height":"180px","padding-top":"120px"});
})
$(".abox1").mouseleave(function(){
    $(this).children("p").animate({"width":"60%"});
})
$(".abox2").mouseleave(function(){
    $(this).children("p").animate({"height":"80px","padding-top":"20px"});
})

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

$('.body_two_content h4').click(function(){
	location.href="sciencelist.html";
})
$('.left_up strong').click(function(){
	location.href="teamlist.html";
})
$('.right_box').on('click',".box2",function(){
	var tid=$(this).children("#tid").text();
	location.href="teaminfo.html?tid="+tid;
})
layui.use('carousel', function(){
	var carousel = layui.carousel;
	carousel.render({
  elem: '.flush_box',
  width: '100%',
  anim:'fade',
  autoplay:true,
  interval:4000,
  arrow:'hover'
	});
  });
$('body').on('click',"#info",function(){
	window.location.href="usershow.html";
})

$("#re").click(function(){
	$('.layui-layer-content').css({'height':'500px'});
	layui.use('layer', function(){
		var layer = layui.layer;
		var $=layui.jquery;
		layer.open({
			type:1, 
			fixed:true,
			area: ['1000px', '500px'],
			shadeClose:true,
			title:"登陆",
			content:$("#model1"),	
			success: function(layero, index){
    			$('.layui-layer-content').css({"height":"500px"});
  			}
		});
	});  
})

$(".lo").click(function(){
	$('.layui-layer-content').css({'height':'360px'});
	layui.use('layer', function(){
		var layer = layui.layer;
		var $=layui.jquery;
		layer.open({
			type:1, 
			fixed:true,
			area: ['720px', '360px'],
			shadeClose:true,
			title:"登陆",
			content:$("#model2"),
			success: function(layero, index){
    			$('.layui-layer-content').css({"height":"360px"});
  			}
		});
	});  
})
$("#loginbox").click(function(){
	$('.layui-layer-content').css({'height':'360px'});
	layui.use('layer', function(){
		var layer = layui.layer;
		var $=layui.jquery;
		layer.open({
			type:1, 
			fixed:true,
			area: ['720px', '360px'],
			shadeClose:true,
			title:"登陆",
			content:$("#model2"),
			success: function(layero, index){
    			$('.layui-layer-content').css({"height":"360px"});
  			}
		});
	});  
})

$("#register").click(function(){
	$('.layui-layer-content').css({'height':'500px'});
	layui.use('layer', function(){
		var layer = layui.layer;
		var $=layui.jquery;
		layer.open({
			type:1, 
			fixed:true,
			area: ['1000px', '500px'],
			shadeClose:true,
			title:"登陆",
			content:$("#model1"),	
			success: function(layero, index){
    			$('.layui-layer-content').css({"height":"500px"});
  			}
		});
	}); 
})

$(".syslo").click(function(){
	var id = getCookie("useridss");
	if(id!=undefined){
	layui.use('layer', function(){
		var layer = layui.layer;
		var $=layui.jquery;
		layer.open({
			type:1, 
			fixed:true,
			area: ['400px', '300px'],
			shadeClose:true,
			title:"登陆",
			content:$("#model3"),
			success: function(layero, index){
    			$('.layui-layer-content').css({"height":"300px"});
  			}
		});
	});
	}else{
		layui.use('layer', function(){
			var layer = layui.layer;
				layer.msg("用户还没有登录", {
					icon: 5,
					time:1000
				},function(){
					layui.use('layer', function(){
						var layer = layui.layer;
						var $=layui.jquery;
						layer.open({
							type:1, 
							fixed:true,
							area: ['720px', '360px'],
							shadeClose:true,
							title:"登陆",
							content:$("#model2"),
							success: function(layero, index){
								$('.layui-layer-content').css({"height":"360px"});
							  }
						});
					});  
				})
		});
	}
})

$("#ma").click(function(){
	$('.layui-layer-content').css({'height':'360px'});
	layui.use('layer', function(){
		var layer = layui.layer;
		var $=layui.jquery;
		layer.open({
			type:1, 
			fixed:true,
			area: ['400px', '300px'],
			shadeClose:true,
			title:"登陆",
			content:$("#model4"),
			success: function(layero, index){
    			$('.layui-layer-content').css({"height":"300px"});
  			}
		});
	});  
})
$('body').on("click",".rece",function(){
	var uid=$("#chuid").val();
	$.ajax({
		url : "regisma?uid="+uid,
		dataType : "json",
		async : false,
		success : function(result) {
			layui.use('layer', function(){
				var layer = layui.layer;
				if(result.code==200){
					layer.msg(result.msg+"为:"+result.data.uma, {
						icon: 1,
						time:3000
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
})

$('body').on("click","#model3 #submit",function(){
	var utelephone=$("#gutelephone").val();
	var uma=$("#guma").val();
	if(uma!=""&&uma!=null){
		$.ajax({
			url : "loginsys?uma="+uma+"&utelephone="+utelephone,
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
							window.location.href="manage/main.html";
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

$('body').on("click","#model2 #submit",function(){
	var upassword=$("#lupassword").val();
	var utelephone=$("#lutelephone").val();
	if((upassword!=""&&upassword!=null)&&(utelephone!=""&&utelephone!=null)){
		$.ajax({
			url : "login?upassword="+upassword+"&utelephone="+utelephone,
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
							window.location.href="index.html";
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

$('body').on("click","#model1 #submit",function(){
	var uname=$("#runame").val();
	var upassword=$("#rupassword").val();
	var utelephone=$("#rutelephone").val();
	var uqq=$("#ruqq").val();
	var ubirthday=$("#rubirthday").val();
	var uschool=$("#ruschool").val();
	var ustudy=$("#rustudy").val();
	var ugrade=$("#rugrade").val();
	if((uname!=""&&uname!=null)&&(upassword!=""&&upassword!=null)&&(utelephone!=""&&utelephone!=null)&&(uqq!=""&&uqq!=null)&&(ubirthday!=""&&ubirthday!=null)&&(uschool!=""&&uschool!=null)&&(ustudy!=""&&ustudy!=null)&&(ugrade!=""&&ugrade!=null)){
		$.ajax({
			url : "register?uname="+uname+"&upassword="+upassword+"&utelephone="+utelephone+"&uqq="+uqq+"&ubirthday="+ubirthday+"&uschool="+uschool+"&ustudy="+ustudy+"&ugrade="+ugrade,
			dataType : "json",
			async : false,
			success : function(result) {
				layui.use('layer', function(){
					var layer = layui.layer;
					if(result.code==200){
						layer.msg(result.msg, {
							icon: 1,
							time:1000
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

$('body').on("click","#model1 #reset",function(){
	$("#runame").val("");
	$("#rupassword").val("");
	$("#rutelephone").val("");
	$("#ruqq").val("");
	$("#rubirthday").val("2020-10-10");
	$("#ruschool").val("");
	$("#rustudy").val("");
	$("#rugrade").val("2014级");
})

$("body").on("click","#exit",function(){
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
						window.location.href="index.html";
					})
				})
			}
			}
		})
})


var lun_box = document.getElementById("lun_box");
var uls=lun_box.children[0];
			var as=uls.children;
			var left=document.getElementById("left");
			var right=document.getElementById("right");
			var ulWidths=uls.offsetWidth/10;
            var piccs=0;
			left.onclick=function(){
				if(piccs===0){
					return ;
				}
				piccs--;
                var targets=-piccs*ulWidths/3;
				animate(uls,targets);
			}
			right.onclick=function(){
				if(piccs===as.length-1){
					piccs=0;
				}else{
					piccs++;
				}
				var targets=-piccs*ulWidths/3;
				animate(uls,targets);
            }
            lun_box.onmouseover=function(){
				clearInterval(timer);
			}
			lun_box.onmouseout=function(){
				timer=setInterval(function(){
				if(piccs===as.length-1){
					uls.style.left=0+"px";
					piccs=0;
				}
				piccs++;
				var target=-piccs*ulWidths/3;
				animate(uls,target);
			},3000);
			}
			timer=setInterval(function(){
				if(piccs===as.length-1){
					uls.style.left=0+"px";
					piccs=0;
				}
				piccs++;
				var target=-piccs*ulWidths/3;
				animate(uls,target);
			},3000);
			function animate(obj,target){
				clearInterval(obj.timer);
				obj.timer=setInterval(function(){
					var leader =obj.offsetLeft;
					var step=10;
					step=leader<target?step:-step;
					if(Math.abs(leader-target)>=Math.abs(step)){
						leader=leader+step;
						obj.style.left=leader+"px";
					}
					else{
						obj.style.left=target+"px";
						clearInterval(obj,target);
					}
				},1);
			}

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