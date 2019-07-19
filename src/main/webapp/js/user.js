layui.use('table', function(){
    var table = layui.table;
    var form = layui.form;
    var $ = layui.jquery;
    var layer = layui.layer;
    var layedit = layui.layedit;


    //第一个实例
    table.render({
        elem: '#user_table'
        ,limit:30
        ,height: 'full-130'
        ,cellMinWidth: 80
        ,url: '/userJson' //数据接口
        ,page: true //开启分页
        ,toolbar: '#toolbarDemo'//开启头部工具栏
        ,cols: [[ //表头
             // {type: 'checkbox',fixed:'left'}
            {type:'numbers'}
            // ,{field: 'userId', title: 'ID', width:80, sort: true}
            ,{field: 'userName', title: '用户名'}
            ,{field:'userPassword',title:'密码'}
            ,{fixed: 'right', width: 178, title:'操作', toolbar: '#barOption'}
        ]]
        ,id:'userTest'
    });

    table.on('tool(table)', function(obj){
        var data = obj.data;
        if(obj.event === 'edit'){
            layer.prompt({
                formType: 0,
                value: data.userPassword,
                title: '请输入密码'+'  账号：'+data.userName,
                area: ['800px', '350px'] //自定义文本域宽高
            }, function(value, index, elem){
                $.ajax({
                    url:"/userEdit",
                    type:"POST",
                    data:{"userId":data.userId,"userName":data.userName,"userPassword":value},
                    dataType:"json"
                });
                obj.update({
                   userPassword:value
                });
                layer.msg("修改成功");
                layer.close(index);
            });
        }else if (obj.event === 'del') {
            layer.confirm('确认删除',function (index) {
                console.log(data);
                $.ajax({
                    url: "/userDelete",
                    type: "POST",
                    data:{"userId":data.userId,"userName":data.userName,"userPassword":data.userPassword},
                    dataType: "json"
                });
                layer.msg("删除成功");
                obj.del();
                layer.close(index);
            });
        }
    });

    table.on('toolbar(user_table)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        switch(obj.event){
            case 'add':
                layer.msg('添加');
                break;
            case 'delete':
                layer.msg('删除');
                break;
            case 'update':
                layer.msg('编辑');
                break;
        };
    });

    var active = {
        reload: function(){
            var demoReload = $('#demoReload');

            //执行重载
            table.reload('userTest', {
                url:"/userSelectJson",
                page:{
                    curr:1
                },where:{
                    userName:demoReload.val()
                }
            });
        }
    };

    $('.demoTable .layui-btn').on('click', function(){
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });

    //user_add
    $('#btn-add').on('click', function () {
        layer.open({
            type: 2,
            title: '添加用户',
            maxmin: true,
            area: ['420px', '330px'],
            shadeClose: false, //点击遮罩关闭
            content: '/userAdd',
        });
    });

    table.render({
        elem: '#authority_table'
        ,limit:30
        ,height: 'full-130'
        ,cellMinWidth: 80
        ,url: '/authorityJson' //数据接口
        ,page: true //开启分页
        ,toolbar: '#toolbarDemo'//开启头部工具栏
        ,cols: [[ //表头
            // {type: 'checkbox',fixed:'left'}
            {type:'numbers'}
            ,{field: 'userId', title: 'ID', width:80, sort: true}
            ,{field: 'username', title: '用户名'}
            ,{field:'authority',title:'权限',edit:'text'}
            // ,{fixed: 'right', width: 178, title:'操作', toolbar: '#barOption'}
        ]]
    });

    table.on('edit(authority)', function(obj){
        var value = obj.value,
            data = obj.data;//得到修改后的值
        $.ajax({
            url:"/editAuthority",
            data:{"userId":data.userId,"authority":value},
            type:"POST"
        });
        layer.msg("修改成功");
    });


    $('#btn-refresh').on('click',function () {
        window.location.reload();
    });

    $('#btn-success').on('click',function () {
        window.parent.location.reload(); //刷新父页面
        var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
        parent.layer.close(index);
        parent.layer.msg("添加成功");
    });



});