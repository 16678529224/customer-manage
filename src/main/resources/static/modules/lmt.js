const lmt = {};
lmt['layui'] = {};
const validFormErrorTip = function (msg, o) {
    layer.tips(msg, "#" + o.obj[0].id, {
        tips: [1, '#3595CC']
    });
}

/**
 * 时间戳转换日期
 * @param inputTime
 * @returns {string}
 */
lmt.toDate = function (inputTime) {
    let date = new Date(inputTime * 1000);//秒需*1000
    let y = date.getFullYear();
    let m = date.getMonth() + 1;
    m = m < 10 ? ('0' + m) : m;
    let d = date.getDate();
    d = d < 10 ? ('0' + d) : d;
    let h = date.getHours();
    h = h < 10 ? ('0' + h) : h;
    let minute = date.getMinutes();
    var second = date.getSeconds();
    minute = minute < 10 ? ('0' + minute) : minute;
    second = second < 10 ? ('0' + second) : second;
    return y + '-' + m + '-' + d + ' ' + h + ':' + minute + ':' + second;
};

/**
 * 点击菜单
 */
lmt.triggerMenu = function ($menu) {

    let url = $menu.data('url');
    if (null === url || '' === url) {
        lmt.msg('未配置访问地址');
        return;
    }
    //# 移除当前高亮菜单
    $("ul.nav.nav-list li.active").removeClass('active');
    $menu.parent().addClass('active');
    $menu.parent().parent().parent().addClass('active');
    //# 当前点击菜单高亮
    $menu.addClass("active");

    let text = $menu.text().trim();
    let len = $("div[role='tabpanel'][id='" + text + "']").length;
    if (len == 0) {//当前页签不存在
        $.get(url, function (data) {
            //当前被选中选项卡样式删除
            lmt.removeActiveTab();
            //构建标签页
            let a = $("<a></a>").attr("href", "#" + text).attr("aria-controls", text).attr("role", "tab").attr("data-toggle", "tab").text(text);
            let closeBtn = $('<i class="index-tabs-close-btn icon iconfont icon-delete2"></i>');
            let li = $("<li></li>").attr("role", "presentation").addClass("active");
            closeBtn.appendTo(a);
            a.appendTo(li);
            li.appendTo($("#index-nav-tabs"));
            let div = $("<div></div>").attr("role", "tabpanel").attr("id", text).addClass("tab-pane active").html(data);
            div.appendTo($("#index-tab-content"));
        });
    } else {
        //页签存在选中当前页签
        lmt.removeActiveTab();
        $("a[href='#" + text + "']").parent().addClass("active");//页签
        $("div[id='" + text + "']").addClass("active");	//内容
    }
};


lmt.removeActiveTab = function () {
    $(".tab-pane.active").removeClass("active");
    $("ul.nav.nav-tabs li.active").removeClass("active");
};


/**
 * 明细弹窗
 */
lmt.detailDialog = function (params) {
    if (undefined === params.area) {
        params.area = ['600px', 'auto'];
    }
    ;

    if (undefined === params.title) {
        params.title = "查看详情";
    }
    ;

    return layer.open({
        id: 'detailDialog',
        title: params.title,
        type: 1,
        scrollbar: false,
        skin: 'layui-layer-rim', // 加上边框
        area: params.area, // 宽高
        shadeClose: true,
        content: params.content
    });
};

/**
 * 预修改弹窗
 */
lmt.preUpdateDialog = function (params) {

    if (undefined === params.area) {
        params.area = ['60%', '60%'];
    }

    if (undefined === params.title) {
        params.title = '信息修改';
    }

    if (undefined === params.btn) {
        params.btn = ['保存', '取消'];
    }

    return layer.open({
        id: 'preUpdateDialog',
        type: 1,
        skin: 'layui-layer-demo', //样式类名
        closeBtn: 0, //不显示关闭按钮
        area: params.area,
        title: params.title,
        scrollbar: false,
        btn: params.btn,
        yes: params.yes,
        cancel: params.cancel,
        anim: 2,
        shadeClose: true, //开启遮罩关闭
        content: params.content
    });
};

/**
 * 新增弹窗
 */
lmt.addDialog = function (params) {

    if (undefined === params.area) {
        params.area = ['60%', '60%'];
    }

    if (undefined === params.title) {
        params.title = '新增';
    }

    if (undefined === params.btn) {
        params.btn = ['保存', '取消'];
    }

    return layer.open({
        id: "addDialog",
        type: 1,
        skin: 'layui-layer-demo', //样式类名
        closeBtn: 0, //不显示关闭按钮
        area: params.area,
        title: params.title,
        scrollbar: false,
        btn: params.btn,
        yes: params.yes,
        cancel: params.cancel,
        anim: 2,
        shadeClose: true, //开启遮罩关闭
        content: params.content
    });
};

/**
 * 常用的几个操作提示
 * msg > 普通提示
 * msgSuccess > 带对号图标的提示信息
 * msgDel > 操作成功，成功删除{0}条数据
 */

lmt.msg = function (msg) {
    return layer.msg(msg);
}

lmt.msgSuccess = function (msg) {
    return layer.msg(msg, {
        icon: 1
    });
};

lmt.msgAdd = function (count) {
    if (count == "-1808") {
        return layer.alert('少于100无法提现', {
            icon: 2
        });
    } else if (count == "-1908") {
        return layer.alert('没有可提现金', {
            icon: 3
        });
    } else {
        return layer.msg('操作成功,成功保存' + count + '条数据', {
            icon: 1
        });
    }

};

lmt.msgWarn = function (msg) {
    return layer.msg(msg, {icon: 5, offset: 't', anim: 6});
}

lmt.msgDel = function (count) {
    return layer.msg('操作成功,成功删除' + count + '条数据', {
        icon: 1
    });
};

lmt.msgPass = function (count) {
    return layer.msg('操作成功,成功通过审核' + count + '条数据', {
        icon: 1
    });
};

lmt.msgEdit = function (count) {
    return layer.msg('操作成功,成功修改' + count + '条数据', {
        icon: 1
    });
};

/**
 * 操作确认
 * @param params.msg : 显示信息
 * @param params.btns: 显示按钮 ['确定', '取消']
 * @param params.title: 确认层标题 ['操作确认']
 * @param params.success: 点击按钮1的回调
 * @param params.cancel: 点击按钮2的回调
 */
lmt.confirm = function (params) {
    if (undefined === params.btns) {
        params.btns = ['确定', '取消'];
    }
    ;

    if (undefined === params.title) {
        params.title = '操作确认';
    }
    ;

    layer.confirm(params.msg, {
            id: "confirm",
            btn: params.btns, //显示按钮
            title: params.title,
            shadeClose: true
            //弹层标题
        }, params.success, //点击按钮1的回调
        params.cancel //点击按钮2的回调
    );
};


/**
 * ajax GET 请求
 */
lmt.get = function (params) {
    let index = layer.load(1);
    $.ajax({
        url: params.url,
        type: 'GET',
        data: params.data,
        dataType: params.dataType,
        success: params.success,
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            lmt.errorTip(XMLHttpRequest.responseJSON);
        },
        complete: function (request) {
            layer.close(index);
        }
    });
};

/**
 * ajax POST 请求
 */
lmt.post = function (params) {
    let index = layer.load(1);
    $.ajax({
        url: params.url,
        type: 'POST',
        data: params.data,
        dataType: params.dataType,
        success: params.success,
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            lmt.errorTip(XMLHttpRequest.responseJSON);
        },
        complete: function (request) {
            layer.close(index);
        }
    });
};

/**
 * ajax PUT 请求
 */
lmt.put = function (params) {
    let index = layer.load(1);

    if (params.data === undefined) {
        params.data = {};
    }
    params.data['_method'] = "PUT";

    $.ajax({
        url: params.url,
        type: 'POST',
        data: params.data,
        dataType: params.dataType,
        success: params.success,
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            lmt.errorTip(XMLHttpRequest.responseJSON);
        },
        complete: function (request) {
            layer.close(index);
        }
    });
};

/**
 * ajax DELETE 请求
 * @param * url: 目标地址
 * @param data: 请求携带参数
 * @param dataType: 预期服务器返回的数据类型
 * @param * success: 请求成功后的函数回调
 */
lmt.del = function (params) {
    let index = layer.load(1);


    if (params.data === undefined) {
        params.data = {};
    }

    params.data['_method'] = "DELETE";

    $.ajax({
        url: params.url,
        type: 'POST',
        data: params.data,
        dataType: params.dataType,
        success: params.success,
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            lmt.errorTip(XMLHttpRequest.responseJSON);
        },
        complete: function (request) {
            layer.close(index);
        }
    });
};

/**
 * jquery.form 插件以Ajax形式提交表单
 * @param data: 需要提交的数据,默认为 formSerialize()
 * @param success: 成功后的回调 function(responseText,responseStatus){}
 */
lmt.ajaxSubmit = function (params) {
    let index = layer.load(1);

    let $form = params.form;

    if (undefined === params.data) {
        params.data = $form.formSerialize();
    }

    $form.ajaxSubmit({
        data: params.data,
        timeout: 3000,
        beforeSubmit: function (formData, jqForm, options) {
            //return false 阻止提交
        },
        success: function (responseText, responseStatus) {
            params.success(responseText, responseStatus);
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            lmt.errorTip(XMLHttpRequest.responseJSON);
        }
    });
    layer.close(index);
};

lmt.errorTip = function (params) {
    //或联系管理员 >>>> [<small>18888888888</small>]
    layer.msg('<h4>服务器出错了: 错误码 >>>> [<strong style="color:#ff353a">' + params.code + '</strong>] , 错误信息 >>>> [<strong style="color:#ff6666">' + params.msg + '</strong>],请稍候重试...</h4>', {
        icon: 5,
        time: 5000
    });
};

/**
 * 重新加载表格
 * @param table
 */
lmt.layui.reloadTable = function (table, tableId, options) {
    if (options === undefined) {
        options = {};
    }
    table.reload(tableId, options);
};

/**
 * layui数据表格通用添加
 * @param url
 * @param table
 */
lmt.layui.doAdd = function (url, table, tableId) {
    lmt.get({
        url: url,
        success: function (data) {
            let dialogId = lmt.addDialog({
                content: data,
                yes: function () {
                    let $thisForm = $("#layui-layer" + dialogId).find('form');
                    $thisForm.Validform({
                        tiptype: function (msg, o, cssctl) {
                            if (!o.obj.is("form")) {//验证表单元素时o.obj为该表单元素，全部验证通过提交表单时o.obj为该表单对象;
                                layer.tips(msg, "#" + o.obj[0].id, {
                                    tips: [1, '#3595CC']
                                });
                            }
                        },//提示信息类型
                        ajaxPost: true,//使用ajax方式提交表单数据，将会把数据POST到config方法或表单action属性里设定的地址；
                        beforeCheck: function (curform) {
                            //在表单提交执行验证之前执行的函数，curform参数是当前表单对象。
                            //这里明确return false的话将不会继续执行验证操作;
                        },
                        beforeSubmit: function (curform) {
                            //formSubmitLoadIndex = layer.load(1);
                        },
                        callback: function (data) {
                            //layer.close(formSubmitLoadIndex);
                            lmt.msgAdd(data);
                            layer.close(dialogId);
                            lmt.layui.reloadTable(table, tableId);
                        }
                    });
                    $thisForm.submit();
                }
            });
        }
    });
};

/**
 * layui 数据表格通用批量删除
 * @param url
 * @param table
 */
lmt.layui.doBatchDel = function (url, table, checkStatus, tableId) {
    //批量删除处理

    let data = checkStatus.data;
    if (data.length < 1) {
        lmt.msgWarn("请至少选择一条数据!");
        return;
    }
    let ids = "";
    for (let i = 0; i < data.length; i++) {
        ids += data[i].id + ",";
    }
    ids = ids.substring(0, ids.length - 1);
    lmt.confirm({
        msg: "确认删除选中数据吗？",
        success: function (r) {
            lmt.del({
                data: {"ids": ids},
                url: url,
                success: function (count) {
                    lmt.msgDel(count);
                    lmt.layui.reloadTable(table, tableId);
                }
            });
        }
    });
};

/**
 * layui 数据表格 行内按钮 通用修改
 * @param url
 * @param table
 */
lmt.layui.doEdit = function (url, table, tableId) {
    lmt.get({
        url: url,
        success: function (updatePage) {
            let dialogId = lmt.preUpdateDialog({
                content: updatePage,
                yes: function (index, layero) {
                    //点击[保存] 按钮后提交当前表单
                    let $thisForm = $("#layui-layer" + dialogId).find('form');
                    $thisForm.Validform({
                        tiptype: function (msg, o, cssctl) {
                            if (!o.obj.is("form")) {//验证表单元素时o.obj为该表单元素，全部验证通过提交表单时o.obj为该表单对象;
                                layer.tips(msg, "#" + o.obj[0].id, {
                                    tips: [1, '#3595CC']
                                });
                            }
                        },//提示信息类型
                        ajaxPost: true,//使用ajax方式提交表单数据，将会把数据POST到config方法或表单action属性里设定的地址；
                        beforeCheck: function (curform) {
                            //在表单提交执行验证之前执行的函数，curform参数是当前表单对象。
                            //这里明确return false的话将不会继续执行验证操作;
                        },
                        beforeSubmit: function (curform) {
                            //formSubmitLoadIndex = layer.load(1);
                        },
                        callback: function (response) {
                            lmt.msgEdit(response); //成功提示
                            layer.close(dialogId);
                            lmt.layui.reloadTable(table, tableId);
                        }
                    });
                    $thisForm.submit();
                }
            });
        }
    });
};

/**
 * layui 数据表格 行内按钮 通用删除
 * @param url
 * @param table
 */
lmt.layui.doDel = function (url, table, tableId) {
    layer.confirm('确认删除吗?', function (index) {
        lmt.del({
            url: url,
            success: function (count) {
                lmt.msgDel(count);
                lmt.layui.reloadTable(table, tableId);
            }
        });
        layer.close(index);
    });
};

/**
 * layui 数据表格 行内按钮 通用详情
 * @param url
 */
lmt.layui.doDetail = function (url) {
    lmt.get({
        url: url,
        success: function (res) {
            lmt.detailDialog({
                content: res
            });
        }
    });
};

/**
 * layui 数据表格默认配置参数
 */
const baseTableOptions = {
    page: true
    , cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
    , request: {
        pageName: "pageNum"
        , limitName: "pageSize"
    }
    , parseData: function (res) { //res 即为原始返回的数据
        return {
            "code": res.code, //解析接口状态
            "msg": res.msg, //解析提示文本
            "count": res.result.total, //解析数据长度
            "data": res.result.list //解析数据列表
        };
    }
    , response: {
        statusCode: 100 //规定成功的状态码，默认：0
    }
};

/**
 * form 表单序列化为Json对象
 */
$.fn.serializeObject = function () {
    let o = {};
    let a = this.serializeArray();
    $.each(a, function () {
        if (o[this.name]) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
}