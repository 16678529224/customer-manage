/**
 @Name： 用户管理 管理员管理 角色管理
 */


layui.define(['table', 'form'], function(exports){
  var $ = layui.$
  ,table = layui.table
  ,form = layui.form;

  //用户管理
  table.render({
    elem: '#LAY-user-manage'
    ,url: layui.setter.base + 'sysUser/list/selUserListPage' //模拟接口json/useradmin/webuser.js
    ,cols: [[
      {type: 'checkbox', fixed: 'left'}
      ,{field: 'usercode', width: 80, title: '编号', sort: true}
      ,{field: 'username', title: '用户名', minWidth: 100}
      ,{field: 'nickname', title: '昵称', minWidth: 100}
      ,{field: 'avatar', title: '头像', width: 100, templet: '#imgTpl'}
      ,{field: 'mobile', title: '手机'}
      ,{field: 'email', title: '邮箱'}
      ,{field: 'sex', width: 80, title: '性别'}
      ,{field: 'ip', title: 'IP'}
      ,{field: 'status', title: '状态', width: 65
              ,templet:function (d) {
                    var bookpath = d.status;
                    if(bookpath == 0){
                        return "正常";
                    }else{
                        return "锁定";
                    }
                }
        }
      ,{field: 'delFlag', title: '删除', width: 65
              ,templet:function (d) {
                  var bookpath = d.delFlag;
                  if(bookpath == 0){
                      return "否";
                  }else{
                      return "是";
                  }
              }
          }
      ,{field: 'createTime', title: '加入时间', sort: true}
      ,{title: '操作', width: 150, align:'center', fixed: 'right', toolbar: '#table-useradmin-webuser'}
    ]]
    ,page: true
    ,limit: 30
    ,height: 'full-220'
    ,text: '对不起，加载出现异常！'
  });
  
  //监听工具条
  table.on('tool(LAY-user-manage)', function(obj){
    var data = obj.data;
    if(obj.event === 'del'){
      layer.prompt({
        formType: 1
        ,title: '敏感操作，请验证口令'
      }, function(value, index){
        layer.close(index);
        
        layer.confirm('真的删除行么', function(index){
          obj.del();
          layer.close(index);
        });
      });
    } else if(obj.event === 'edit'){
      var tr = $(obj.tr);

      layer.open({
        type: 2
        ,title: '编辑用户'
        ,content: layui.setter.base + 'sysUser/userform/index'//'../../../views/user/user/userform.html'
        ,maxmin: true
        ,area: ['500px', '450px']
        ,btn: ['确定', '取消']
        ,yes: function(index, layero){

          var iframeWindow = window['layui-layer-iframe'+ index]
          ,submitID = 'LAY-user-front-submit'
          ,submit = layero.find('iframe').contents().find('#'+ submitID);

          //监听提交
          iframeWindow.layui.form.on('submit('+ submitID +')', function(data){
            var field = data.field; //获取提交的字段
            
            //提交 Ajax 成功后，静态更新表格中的数据
            //$.ajax({});
            table.reload('LAY-user-front-submit'); //数据刷新
            layer.close(index); //关闭弹层
          });  
          
          submit.trigger('click');
        }
        ,success: function(layero, index){
              alert(layero)
              alert(index)
        }
      });
    }
  });

  //管理员管理
  table.render({
    elem: '#LAY-user-back-manage'
    ,url: layui.setter.base + 'json/useradmin/mangadmin.js' //模拟接口
    ,cols: [[
      {type: 'checkbox', fixed: 'left'}
      ,{field: 'id', width: 80, title: 'ID', sort: true}
      ,{field: 'loginname', title: '登录名'}
      ,{field: 'telphone', title: '手机'}
      ,{field: 'email', title: '邮箱'}
      ,{field: 'role', title: '角色'}
      ,{field: 'jointime', title: '加入时间', sort: true}
      ,{field: 'check', title:'审核状态', templet: '#buttonTpl', minWidth: 80, align: 'center'}
      ,{title: '操作', width: 150, align: 'center', fixed: 'right', toolbar: '#table-useradmin-admin'}
    ]]
    ,text: '对不起，加载出现异常！'
  });
  
  //监听工具条
  table.on('tool(LAY-user-back-manage)', function(obj){
    var data = obj.data;
    if(obj.event === 'del'){
      layer.prompt({
        formType: 1
        ,title: '敏感操作，请验证口令'
      }, function(value, index){
        layer.close(index);
        layer.confirm('确定删除此管理员？', function(index){
          console.log(obj)
          obj.del();
          layer.close(index);
        });
      });
    }else if(obj.event === 'edit'){
      var tr = $(obj.tr);

      layer.open({
        type: 2
        ,title: '编辑管理员'
        ,content: '../../../views/user/administrators/adminform.html'
        ,area: ['420px', '420px']
        ,btn: ['确定', '取消']
        ,yes: function(index, layero){
          var iframeWindow = window['layui-layer-iframe'+ index]
          ,submitID = 'LAY-user-back-submit'
          ,submit = layero.find('iframe').contents().find('#'+ submitID);

          //监听提交
          iframeWindow.layui.form.on('submit('+ submitID +')', function(data){
            var field = data.field; //获取提交的字段
            
            //提交 Ajax 成功后，静态更新表格中的数据
            //$.ajax({});
            table.reload('LAY-user-front-submit'); //数据刷新
            layer.close(index); //关闭弹层
          });  
          
          submit.trigger('click');
        }
        ,success: function(layero, index){           
          
        }
      })
    }
  });

  //角色管理
  table.render({
    elem: '#LAY-user-back-role',
      id: 'roleTable'
    ,url: layui.setter.base + 'sysRole/selRoleListPage'          // layui.setter.base + 'json/useradmin/role.js' //模拟接口
    ,cols: [[
      {type: 'checkbox', fixed: 'left'}
      /*,{field: 'id', width: 80, title: 'ID', sort: true}*/
      ,{field: 'name', title: '角色名',width:'15%'}
     /* ,{field: 'limits', title: '拥有权限'}*/
      ,{field: 'description', title: '具体描述',width:'45%'}
      ,{
          field: 'status', title: '状态', templet: function (d) {
              if(d.status==0){
                  return "正常";
              }else{
                  return "锁定";
              }

              /*return util.toDateString(d.createTime);*/
          }, width: '10%'
      }
      ,{title: '操作', width: 150, align: 'center', fixed: 'right', toolbar: '#table-useradmin-admin',width:'30%'}
    ]]
      ,page: true
      ,limit: 30
      ,height: 'full-220'
    ,text: '对不起，加载出现异常！'
  });
  
  //监听工具条
  table.on('tool(LAY-user-back-role)', function(obj){
    var data = obj.data;
    if(obj.event === 'del'){
      layer.confirm('确定删除此角色？', function(index){
          lmt.del({
              url: layui.setter.base  + 'sysRole/remove/'+obj.data.id,
              data: {},
              success: function (data) {
                  if (data.code == 100) {
                      layer.msg('成功', {icon: 1});
                  } else {
                  }
              }
          })


        obj.del();
        layer.close(index);
      });
    }else if(obj.event === 'edit'){
      var tr = $(obj.tr);

      layer.open({
        type: 2
        ,title: '编辑角色'
        ,content: layui.setter.base + 'sysRole/roleform/index'
        ,area: ['500px', '480px']
        ,btn: ['确定', '取消']
        ,yes: function(index, layero){
          var iframeWindow = window['layui-layer-iframe'+ index]
          ,submit = layero.find('iframe').contents().find("#LAY-user-role-submit");

          //监听提交
          iframeWindow.layui.form.on('submit(LAY-user-role-submit)', function(data){
            var field = data.field; //获取提交的字段
            
            //提交 Ajax 成功后，静态更新表格中的数据
            //$.ajax({});
            table.reload('LAY-user-back-role'); //数据刷新
            layer.close(index); //关闭弹层
          });  
          
          submit.trigger('click');
        }
        ,success: function(layero, index){
        
        }
      })
    }

  });
    //角色管理 tabletree
  /*table.render({
      elem: '#LAY-user-back-permission'
      ,url: layui.setter.base + 'sysPermission/selPermissionListPage'//url: layui.setter.base + 'json/useradmin/role.js' //模拟接口
      ,cols: [[
          {type: 'checkbox', fixed: 'left'}
          ,{field: 'id', width: 80, title: 'ID', sort: true,hide:true}
          ,{field: 'perms', title: '权限标识'}
          ,{field: 'name', title: '权限名称'}
          ,{field: 'createTime', title: '添加时间',sort: true}
          ,{field: 'description', title: '具体描述'}
          ,{field: 'type', title: '状态', width: 65
              ,templet:function (d) {
                  var type = d.type;
                  if(type == 0){
                      return "页面";
                  }else{
                      return "按钮";
                  }
              }
          }
          ,{field: 'status', title: '状态', width: 65
              ,templet:function (d) {
                  var status = d.status;
                  if(status == 0){
                      return "正常";
                  }else{
                      return "锁定";
                  }
              }
          }
          ,{title: '操作', width: 150, align: 'center', fixed: 'right', toolbar: '#table-useradmin-admin'}
      ]]
      ,page: true
      ,limit: 30
      ,height: 'full-220'
      ,text: '对不起，加载出现异常！'
  });*/
  exports('useradmin', {})
});