layui.use('table', function(){
    var table = layui.table;
    var form = layui.form;
    var $ = layui.jquery;
    var layer = layui.layer;
    var layedit = layui.layedit;


    //第一个实例
    //公交信息
    table.render({
        elem: '#bus_table'
        ,limit:30
        ,height: 'full-130'
        ,cellMinWidth: 80
        ,url: '/busJson' //数据接口
        ,page: true //开启分页
        ,toolbar: '#toolbarDemo'//开启头部工具栏
        ,cols: [[ //表头
            {type:'numbers'}
            // ,{field: 'busId', title: 'ID', width:80, sort: true}
            ,{field: 'bus_name', title: '公交车名',event:'busDetails',style:'cursor:pointer'}
            ,{field:'route_name',title:'公交车路线',event:'routeDetails',style:'cursor:pointer'}
            ,{fixed: 'right', width: 178, title:'操作', toolbar: '#barOption'}
        ]]
        ,id:'testReload'
    });

    var active = {
        reload: function(){
            var demoReload = $('#demoReload');

            //执行重载
            table.reload('testReload', {
                url:"/busSelectJson",
                page:{
                    curr:1
                },where:{
                    bus_name:demoReload.val()
                }
            });

            table.reload('routeTest', {
                url:"/routeSelectJson",
                page:{
                    curr:1
                },where:{
                    routeId:demoReload.val()
                }
            });

            table.reload('stationTest', {
                url:"/stationSelectJson",
                page:{
                    curr:1
                },where:{
                    routeId:demoReload.val()
                }
            });
        }
    };

    $('.demoTable .layui-btn').on('click', function(){
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });

    table.on('toolbar(bus_table)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        switch(obj.event){
            case 'add':
                layer.msg('添加');
                break;
        }
    });

    table.on('tool(bus)', function(obj){
        var data = obj.data;
        if(obj.event === 'edit'){
            layer.open({
                type:2,
                title:'请选择行驶路线',
                area:['450px','330px'],
                maxmin:true,
                content:'/busModify?bus_name=' + encodeURI(data.bus_name)
            })
        }else if (obj.event === 'del') {
            layer.confirm('确认删除',function (index) {
                console.log(data);
                $.ajax({
                    url: "/busDelete",
                    type: "POST",
                    data:{"bus_name":data.bus_name,"route_name":data.route_name},
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
        }else if (obj.event === 'busDetails') {
            layer.open({
                type: 2,
                title: '公交车详细信息',
                maxmin: true,
                area:['450px','460px'],
                shadeClose: false, //点击遮罩关闭
                content: "/Bus/BusDetails?bus_name=" + encodeURI(data.bus_name)
            });
        }else if (obj.event === 'routeDetails') {
            layer.open({
               type:2,
               title:'路线详细信息',
               maxmin:true,
               area:['450px','460px'],
               shadeClose:true,
               content:"/Bus/RouteDetails?route_name=" + encodeURI(data.route_name)
            });
        }
    });



    $('#bus-btn-success').on('click',function () {
        var busName = $("#busName").val();
        var route = $("#route").val();
        $.ajax({
            type:"POST",
            url:"/add",
            data:{"busName":busName,"route":route},
            success:function (data) {
                if(data === "true"){
                    alert("添加成功");
                    window.parent.location.reload();
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);
                }else if (data === "false") {
                    alert("公交已存在，请重新输入");
                }
            }
        })
    });



    $('#bus-add').on('click', function () {
        layer.open({
            type: 2,
            title: '添加公交',
            maxmin: true,
            area: ['420px', '330px'],
            shadeClose: false, //点击遮罩关闭
            content: '/busAdd',
        });
    });




    $('#modify-btn').on('click',function () {
        var count = document.getElementsByTagName("input");
        var arr = new Array();
        for(var i = 0 ; i < count.length ; i++){
            document.getElementsByTagName("input")[i].removeAttribute("disabled");
            document.getElementsByTagName("input")[i].setAttribute("class","layui-input")
        }
    })

    //路线信息
    table.render({
        elem: '#route_table'
        ,limit:30
        ,height: 'full-130'
        ,cellMinWidth: 80
        ,url: '/routeJson' //数据接口
        ,page: true //开启分页
        ,toolbar: '#toolbarDemo'//开启头部工具栏
        ,cols: [[ //表头
            {type:'numbers'}
            // ,{field: 'busId', title: 'ID', width:80, sort: true}
            ,{field: 'routeId', title: '路线Id',sort:true}
            ,{field:'routeName',title:'始发站-终点站',event:'routeDetails',style:'cursor:pointer'}
            // ,{fixed: 'right', width: 178, title:'操作', toolbar: '#barOption'}
        ]]
        ,id:'routeTest'
    });

    table.on('toolbar(route_table)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        switch(obj.event){
            case 'add':
                layer.msg('添加');
                break;
        }
    });

    $('#bus-route-btn-success').on('click',function () {
        var routeId = $("#routeId").val();
        var routeName = $("#routeName").val();
        $.ajax({
            type:"POST",
            url:"/addRoute",
            data:{"routeId":routeId,"routeName":routeName},
            success:function (data) {
                if(data === "true"){
                    alert("添加成功");
                    window.parent.location.reload();
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);
                }else if (data === "false") {
                    alert("路线已存在，请重新输入");
                }
            }
        })
    });

    table.on('tool(route)', function(obj){
        var data = obj.data;
        if(obj.event === 'edit'){
            layer.open({
                type:2,
                title:'请选择行驶路线',
                area:['450px','330px'],
                maxmin:true,
                content:'/busModify?bus_name=' + encodeURI(data.bus_name)
            })
        }else if (obj.event === 'del') {
            layer.confirm('确认删除',function (index) {
                console.log(data);
                $.ajax({
                    url: "/routeDelete",
                    type: "POST",
                    data:{"routeId":data.routeId,"routeName":data.routeName},
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
        }else if (obj.event === 'routeDetails') {
            layer.open({
                type:2,
                title:'路线详细信息',
                maxmin:true,
                area:['450px','460px'],
                shadeClose:true,
                content:"/Bus/RouteDetails?route_name=" + encodeURI(data.routeName)
            });
        }
    });

    $('#route-add').on('click', function () {
        layer.open({
            type: 2,
            title: '添加路线',
            maxmin: true,
            area: ['420px', '330px'],
            shadeClose: false, //点击遮罩关闭
            content: '/routeAdd'
        });
    });

    table.render({
        elem: '#station_table'
        ,limit:30
        ,height: 'full-130'
        ,cellMinWidth: 80
        ,url: '/stationJson' //数据接口
        ,page: true //开启分页
        ,toolbar: '#toolbarDemo'//开启头部工具栏
        ,cols: [[ //表头
            {type:'numbers'}
            // ,{field: 'busId', title: 'ID', width:80, sort: true}
            ,{field: 'stationId', title: '站点Id'}
            ,{field:'busPostison',title:'站点位置',sort:true}
            ,{field:'routeId',title:'线路Id',event:'stationDetails',style:'cursor:pointer',sort:true,id:'route'}
            ,{field:'stationName',title:'站点名'}
            ,{fixed: 'right', width: 178, title:'操作', toolbar: '#barOption'}
        ]]
        ,id:'stationTest'
    });


    table.on('tool(station)', function(obj){
        var data = obj.data;
        if(obj.event === 'edit'){

        }else if (obj.event === 'del') {
            layer.confirm('确认删除',function (index) {
                console.log(data);
                $.ajax({
                    url: "/stationDelete",
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
        }else if (obj.event === 'stationDetails') {
            $.ajax({
                url:"/stationDetail",
                type:"POST",
                data:{"routeId":data.routeId},
                success:function (result) {
                    var r = result;
                    layer.msg(r);
                }
            })
        }
    });

    $('#station-add').on('click', function () {
        layer.open({
            type: 2,
            title: '添加路线',
            maxmin: true,
            area: ['420px', '530px'],
            shadeClose: false, //点击遮罩关闭
            content: '/stationAdd'
        });
    });

    $('#btn-refresh').on('click',function () {
        window.location.reload();
    });

    $('#bus-station-btn-success').on('click',function () {
       var stationId = $("#stationId").val();
       var stationName = $("#stationName").val();
       var route = $("#route").val();
       var stationPosition = $("#stationPosition").val();
        $.ajax({
            type:"POST",
            url:"/addStation",
            data:{"stationId":stationId,"stationName":stationName,"route":route,"stationPosition":stationPosition},
            success:function (data) {
                if(data === "true"){
                    alert("添加成功");
                    window.parent.location.reload();
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);
                }else if (data === "false") {
                    alert("站点已存在，请重新输入");
                }
            }
        })
    });

    $("#bus-success").on('click',function () {
        window.parent.location.reload(); //刷新父页面
        var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
        parent.layer.close(index);
        parent.layer.msg("修改成功");
    })
});