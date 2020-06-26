$("body").on('click',".layui-icon-star-fill",function(){
    layui.use('layer', function(){
        var layer = layui.layer;
        layer.msg('收藏成功', {
            icon: 1
            });  
    });
})