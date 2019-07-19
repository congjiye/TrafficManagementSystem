layui.use('table', function() {
    var table = layui.table;
    var form = layui.form;
    var $ = layui.jquery;
    var layer = layui.layer;
    var layedit = layui.layedit;


    //第一个实例
    //公交信息
    table.render({
        elem: '#subway_table'
        , limit: 30
        , height: 'full-130'
        , cellMinWidth: 80
        , url: '/subwayJson' //数据接口
        , page: true //开启分页
        , toolbar: '#toolbarDemo'//开启头部工具栏
        , cols: [[ //表头
            {type: 'numbers'}
            // ,{field: 'busId', title: 'ID', width:80, sort: true}
            , {field: 'subwayId', title: '地铁Id',sort:true}
            , {field: 'subwayName', title: '地铁名', event: 'subwayDetails',style:'cursor:pointer'}
            , {field:'routeName',title:'路线名', event:'subwayRoute',style: 'cursor:pointer'}
            , {fixed: 'right', width: 178, title: '操作', toolbar: '#barOption'}
        ]]
        , id: 'subwayReload'
    });

    var active = {
        reload: function(){
            var demoReload = $('#demoReload');

            //执行重载
            table.reload('subwayReload', {
                url:"/subwaySelectJson",
                page:{
                    curr:1
                },where:{
                    subwayName:demoReload.val()
                }
            });

            table.reload('subwayStationReload',{
                url:"/subwayStationSelectJson",
                page:{
                    curr:1
                },where:{
                    stationName:demoReload.val()
                }
            })
        }
    };

    $('.demoTable .layui-btn').on('click', function(){
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });

    table.on('tool(subway)', function(obj){
        var data = obj.data;
        if(obj.event === 'edit'){
            layer.open({
                type:2,
                title:'修改地铁信息',
                maxmin:true,
                area:['450px','460px'],
                shadeClose:true,
                content:"/subway/SubwayModify?subwayName=" + encodeURI(data.subwayName)
            });
        }else if (obj.event === 'del') {
            layer.confirm('确认删除',function (index) {
                console.log(data);
                $.ajax({
                    url: "/subwayDelete",
                    type: "POST",
                    data:{"subwayId":data.subwayId},
                    dataType: "json",
                    success:function (data) {
                        obj.del();
                        layer.close(index);
                        if(data.state === "success"){
                            layer.msg("删除成功");
                        }else {
                            layer.msg("删除失败");
                        }
                    }
                });

            });
        }else if(obj.event === "subwayDetails"){
            layer.open({
                type:2,
                title:'地铁详细信息',
                maxmin:true,
                area:['450px','460px'],
                shadeClose:true,
                content:"/subway/SubwayDetails?subwayName=" + encodeURI(data.subwayName)
            });
        }else if(obj.event === "subwayRoute"){
            layer.open({
               type:2,
               title:"路线详细信息",
               maxmin:true,
               area:['450px','460px'],
               shadeClose:true,
               content:"/subway/SubwayRouteDetails?routeName=" + encodeURI(data.routeName)
            });
        }
    });

    $('#subway-add').on('click', function () {
        layer.open({
            type: 2,
            title: '添加地铁',
            maxmin: true,
            area: ['420px', '330px'],
            shadeClose: false, //点击遮罩关闭
            content: '/subwayAdd'
        });
    });

    $('#subway-btn-success').on('click',function () {
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

    table.render({
        elem: '#subwayStation_table'
        , limit: 30
        , height: 'full-130'
        , cellMinWidth: 80
        , url: '/subwayStationJson' //数据接口
        , page: true //开启分页
        , toolbar: '#toolbarDemo'//开启头部工具栏
        , cols: [[ //表头
            {type: 'numbers'}
            , {field: 'stationId', title: '站点Id'}
            , {field: 'stationName', title: '站点名'}
            , {field:'routeId',title:'路线Id', event:'routeIdInfo',style: 'cursor:pointer'}
            , {fixed: 'right', width: 178, title: '操作', toolbar: '#barOption'}
        ]]
        , id: 'subwayStationReload'
    });

    table.on('tool(subwayStation)', function(obj){
        var data = obj.data;
        if(obj.event === 'edit'){
            layer.prompt({
                formType: 0,
                value:data.stationName,
                title: '输入站点名',
                area: ['800px', '350px'] //自定义文本域宽高
            }, function(value, index){
                $.ajax({
                    url:"/stationEdit",
                    type:"POST",
                    data:{"stationId":data.stationId,"stationName":value},
                    dataType:"json"
                });
                obj.update({
                    stationName:value
                });
                layer.msg("修改成功");
                layer.close(index);
            });
        }else if (obj.event === 'del') {
            layer.confirm('确认删除',function (index) {
                console.log(data);
                $.ajax({
                    url: "/subwayStationDelete",
                    type: "POST",
                    data:{"stationId":data.stationId},
                    dataType: "json",
                    success:function (data) {
                        obj.del();
                        layer.close(index);
                        if(data.state === "success"){
                            layer.msg("删除成功");
                        }else {
                            layer.msg("删除失败");
                        }
                    }
                });

            });
        }else if (obj.event === 'routeIdInfo') {
            $.ajax({
                url:"/routeInfoName",
                type:"POST",
                data:{"routeId":data.routeId},
                success:function (data) {
                   layer.msg(data);
                }
            });
        }
    });

    $('#subwayStation-add').on('click',function () {
       layer.open({
           type: 2,
           title: '添加站点',
           maxmin: true,
           area: ['420px', '330px'],
           shadeClose: false, //点击遮罩关闭
           content: '/StationAdd'
       });
    });

    $('#btn-refresh').on('click',function () {
        window.location.reload();
    });
});