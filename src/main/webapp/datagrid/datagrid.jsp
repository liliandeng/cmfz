<%@page pageEncoding="UTF-8" isELIgnored="false" contentType="text/html; utf-8" %>


    <script type="text/javascript">
        var toolbar = [{
            iconCls: 'icon-edit',
            text: "添加",
            handler: function () {
                $('#dd').dialog({
                    title: '添加',
                    width: 400,
                    height: 300,
                    closed: false,
                    cache: false,
                    //  href: 'get_content.php',
                    modal: true

                });

            }
        }, '-', {
            iconCls: 'icon-help',
            text: "删除",
            handler: function () {
                /*获取选中行*/
                var row = $("#ta").edatagrid("getSelected")
                if (row == null) {
                    $.messager.show({
                        title: '警告',
                        msg: '请选中删除行。',
                        showType: 'show',
                        style: {
                            right: '',
                            top: document.body.scrollTop + document.documentElement.scrollTop,
                            bottom: ''
                        }
                    });
                } else {
                    /*将当前行删除*/
                    $("#ta").edatagrid("destroyRow");
                    $.messager.show({
                        msg: "删除成功",
                    })
                    //重新加载当前页面
                    $("#ta").edatagrid("reload", true);
                }


            }
        }, '-', {
            text: "修改",
            iconCls: 'icon-help',
            handler: function () {
                /*获取选中行*/
                var row = $("#ta").edatagrid("getSelected")
                if (row == null) {
                    $.messager.show({
                        title: '警告',
                        msg: '请选中修改行。',
                        showType: 'show',
                        style: {
                            right: '',
                            top: document.body.scrollTop + document.documentElement.scrollTop,
                            bottom: ''
                        }
                    });
                } else {
                    /*将当前行变成可编辑模式*/
                    var index = $("#ta").edatagrid("getRowIndex", row);
                    $("#ta").edatagrid("editRow", index);
                }

            }
        }, '-', {
            text: "保存",
            iconCls: 'icon-help',
            handler: function () {
                $("#ta").edatagrid("saveRow");
            }
        }];

        $(function () {
            $('#ta').edatagrid({
                //通过URL将'id'参数发送到服务器以销毁行。
                destroyUrl: "${pageContext.request.contextPath}/deleteBanner",

                //该方法在edatagtid中，通过URL更新数据到服务器并返回更新的行。
                updateUrl: "${pageContext.request.contextPath}/updateBanner",
                toolbar: toolbar,
                url: '${pageContext.request.contextPath}/selectBannerAll',
                // method: "post",//easyui默认为post请求
                columns: [[
                    {field: 'title', title: '名字', width: 100},
                    {
                        field: 'status', title: '状态', width: 100, editor: {
                            type: "text",
                            options: {
                                required: true
                            }
                        }
                    },
                    {field: 'desc', title: '描述', width: 100, align: 'right'}
                ]],
                fit: true,
                fitColumns: true,
                pagination: true,
                pageSize: 5,
                pageList: [5, 10, 15, 20, 25, 30, 35, 40, 45, 50],
                view: detailview,
                detailFormatter: function (rowIndex, rowData) {
                    return '<table><tr>' +
                        '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/img/' + rowData.img + '" style="height:50px;"></td>' +
                        '<td style="border:0">' +
                        '<p>时间: ' + rowData.dates + '</p>' +
                        '<p>:描述:' + rowData.desc + '</p>' +
                        '</td>' +
                        '</tr></table>';
                }
            });


        });

        //添加操作开始
        function doAdd() {
            $("#ff").form("submit", {
                url: "${pageContext.request.contextPath}/insertBanner",
                //回调函数
                success: function (data) {
                    //因为data是json字符串，所以判断时，要么用JSON.parse()方法解析，要么时其等于一个true字符串进行判断
                    if (data == "true") {
                        //关闭修改对话框
                        $("#dd").dialog("close", true);
                        //刷新展示数据页面
                        $("#ta").edatagrid("reload", true);
                    } else {
                        alert("添加失败");
                    }
                },
            });
        };
        //添加操作====结束===

    </script>

<table id="ta"></table>
<%--弹出对话框--%>
<div id="dd">
    <form id="ff" method="post" enctype="multipart/form-data">
        标题： <input type="text" name="title"/> </br>
        描述：<input type="text" name="desc"/> </br>
        图片：<input type="file" name="wenjian"></br>
        状态：<input type="text" name="status"/> </br>
        日期：<input type="text" name="dates"/><font>日期格式yyyy-MM-dd</font> </br>
        <a href="JavaScript:void(0)" class="easyui-linkbutton" onclick="doAdd()">添加</a>
    </form>
</div>

