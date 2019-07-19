layui.use('table', function() {
    var table = layui.table;
    var form = layui.form;
    var $ = layui.jquery;
    var layer = layui.layer;
    var layedit = layui.layedit;


    //第一个实例

    table.render({
        elem: '#plane_table'
        , limit: 30
        , height: 'full-130'
        , cellMinWidth: 80
        , url: '/planeJson' //数据接口
        , page: true //开启分页
        , toolbar: '#toolbarDemo'//开启头部工具栏
        , cols: [[ //表头
            {type: 'numbers'}
            , {field: 'planeId', title: '飞机Id', sort: true}
            , {field: 'planeName', title: '飞机名', event: 'planeDetails', style: 'cursor:pointer'}
            , {field: 'routeName', title: '路线名'}
            , {fixed: 'right', width: 178, title: '操作', toolbar: '#barOption'}
        ]]
        , id: 'planeReload'
    });

    var active = {
        reload: function(){
            var demoReload = $('#demoReload');

            //执行重载
            table.reload('trainReload', {
                url:"/planeSelectJson",
                page:{
                    curr:1
                },where:{
                    planeName:demoReload.val()
                }
            });
        }
    };

    table.on('tool(plane)', function(obj) {
        var data = obj.data;
        if (obj.event === 'edit') {
            layer.open({
                type: 2,
                title: '请选择路线',
                area: ['450px', '330px'],
                maxmin: true,
                content: '/planeModify?planeName=' + encodeURI(data.planeName)
            })
        } else if (obj.event === 'del') {
            layer.confirm('确认删除', function (index) {
                console.log(data);
                $.ajax({
                    url: "/planeDelete",
                    type: "POST",
                    data: {"planeName":data.planeName,"routeName":data.routeName},
                    dataType: "json",
                    success: function (data) {
                        obj.del();
                        layer.close(index);
                        if (data.state === "success") {
                            layer.msg("删除成功");
                        } else {
                            layer.msg("删除失败");
                        }
                    }
                });
            });
        }else if (obj.event === 'planeDetails') {
            layer.open({
                type: 2,
                title: '飞机详细信息',
                area: ['450px', '330px'],
                maxmin: true,
                content: '/planeDetails?planeName=' + encodeURI(data.planeName)
            })
        }
    });

    $('#plane-add').on('click', function () {
        layer.open({
            type: 2,
            title: '添加路线',
            maxmin: true,
            area: ['420px', '330px'],
            shadeClose: false, //点击遮罩关闭
            content: '/planeAdd'
        });
    });

    $('.demoTable .layui-btn').on('click', function(){
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });

    $('#btn-refresh').on('click',function () {
        window.location.reload();
    });

    $('#plane-btn-success').on('click',function () {
        window.parent.location.reload(); //刷新父页面
        var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
        parent.layer.close(index);
        parent.layer.msg("修改成功");
    });

    $('#modify-btn').on('click',function () {
        var count = document.getElementsByTagName("input");
        var arr = new Array();
        for(var i = 0 ; i < count.length ; i++){
            document.getElementsByTagName("input")[i].removeAttribute("disabled");
            document.getElementsByTagName("input")[i].setAttribute("class","layui-input")
        }
    });
});