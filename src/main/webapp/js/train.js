layui.use('table', function() {
    var table = layui.table;
    var form = layui.form;
    var $ = layui.jquery;
    var layer = layui.layer;
    var layedit = layui.layedit;


    //第一个实例
    //公交信息
    table.render({
        elem: '#train_table'
        , limit: 30
        , height: 'full-130'
        , cellMinWidth: 80
        , url: '/trainJson' //数据接口
        , page: true //开启分页
        , toolbar: '#toolbarDemo'//开启头部工具栏
        , cols: [[ //表头
            {type: 'numbers'}
            , {field: 'trainId', title: '列车Id',sort:true}
            , {field: 'trainName', title: '列车号', event: 'trainDetails', style: 'cursor:pointer'}
            , {field: 'routeName', title: '路线名'}
            , {fixed: 'right', width: 178, title: '操作', toolbar: '#barOption'}
        ]]
        , id: 'trainReload'
    });

    var active = {
        reload: function(){
            var demoReload = $('#demoReload');

            //执行重载
            table.reload('trainReload', {
                url:"/trainSelectJson",
                page:{
                    curr:1
                },where:{
                    trainName:demoReload.val()
                }
            });

            table.reload('trainStationReload',{
                url:"/trainStationSelect",
                page:{
                    curr:1
                },where:{
                    routeName:demoReload.val()
                }
            })
        }
    };

    table.on('tool(train)', function(obj) {
        var data = obj.data;
        if (obj.event === 'edit') {
            layer.open({
                type: 2,
                title: '请选择行驶路线',
                area: ['450px', '330px'],
                maxmin: true,
                content: '/trainModify?trainName=' + encodeURI(data.trainName)
            })
        } else if (obj.event === 'del') {
            layer.confirm('确认删除', function (index) {
                console.log(data);
                $.ajax({
                    url: "/trainDelete",
                    type: "POST",
                    data: {"trainId":data.trainId,"trainName":data.trainName},
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
        }else if(obj.event === 'trainDetails'){
            layer.open({
                type: 2,
                title: '列车详细信息',
                area: ['450px', '330px'],
                maxmin: true,
                content: '/trainDetails?trainId=' + encodeURI(data.trainId)
            })
        }
    });

    $('#train-add').on('click', function () {
        layer.open({
            type: 2,
            title: '添加列车',
            maxmin: true,
            area: ['420px', '530px'],
            shadeClose: false, //点击遮罩关闭
            content: '/trainAdd'
        });
    });

    $('.demoTable .layui-btn').on('click', function(){
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });

    $('#train-btn-success').on('click',function () {
        window.parent.location.reload(); //刷新父页面
        var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
        parent.layer.close(index);
        parent.layer.msg("修改成功");
    });

    table.render({
        elem: '#station_train'
        , limit: 30
        , height: 'full-130'
        , cellMinWidth: 80
        , url: '/trainStationJson' //数据接口
        , page: true //开启分页
        , toolbar: '#toolbarDemo'//开启头部工具栏
        , cols: [[ //表头
            {type: 'numbers'}
            , {field: 'routeId', title: '路线Id',sort:true}
            , {field: 'routeName', title: '路线名'}
            , {fixed: 'right', width: 178, title: '操作', toolbar: '#barOption'}
        ]]
        , id: 'trainStationReload'
    });

    table.on('tool(station_train)', function(obj) {
        var data = obj.data;
        if (obj.event === 'edit') {
            layer.prompt({
                formType: 0,
                value:data.routeName,
                title: '输入站点名',
                area: ['800px', '350px'] //自定义文本域宽高
            }, function(value, index){
                $.ajax({
                    url:"/trainStationEdit",
                    type:"POST",
                    data:{"routeId":data.routeId,"routeName":value},
                    dataType:"json"
                });
                obj.update({
                    routeName:value
                });
                layer.msg("修改成功");
                layer.close(index);
            });
        } else if (obj.event === 'del') {
            layer.confirm('确认删除', function (index) {
                console.log(data);
                $.ajax({
                    url: "/trainStationDelete",
                    type: "POST",
                    data: {"routeId":data.routeId,"routeName":data.routeName},
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
        }
    });

    $('#train-station-add').on('click', function () {
        layer.open({
            type: 2,
            title: '添加路线',
            maxmin: true,
            area: ['420px', '330px'],
            shadeClose: false, //点击遮罩关闭
            content: '/trainStationAdd'
        });
    });

    $('#modify-btn').on('click',function () {
        var count = document.getElementsByTagName("input");
        var arr = new Array();
        for(var i = 0 ; i < count.length ; i++){
            document.getElementsByTagName("input")[i].removeAttribute("disabled");
            document.getElementsByTagName("input")[i].setAttribute("class","layui-input")
        }
    });

    $('#btn-refresh').on('click',function () {
        window.location.reload();
    });
});