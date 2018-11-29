<%@page pageEncoding="UTF-8" isELIgnored="false" contentType="text/html; utf-8" %>

<script type="text/javascript">
    var toolbar = [{
        iconCls: 'icon-edit',
        text: "添加专辑",
        handler: function () {

        }
    }, '-', {
        iconCls: 'icon-help',
        text: "添加章节",
        handler: function () {
            var row = $("#chapter_tg").treegrid("getSelected");
            if (row == null) {
                alert("请先选中专辑")
            } else {
                if (row.score != null) {
                    $("#chapter_dd").dialog("open")
                    $("#p_id").val(row.id)
                } else {
                    alert("请先选中专辑")
                }
            }

        }
    }, '-', {
        text: "专辑详情",
        iconCls: 'icon-help',
        handler: function () {
            /*展示专辑相关的信息*/
            $('#album').dialog("open")
            /*把专辑信息填充到dialog*/
            var row = $("#al").treegrid("getSelected");
            if (row == null) {
                alert("请先选中专辑")
            } else {
                if (row.score != null) {
                    $("#album_ff").form("load", row);
                    $("#album_img").prop("src", "${pageContext.request.contextPath}/img/" + row.coverlmg)
                } else {
                    alert("请先选中专辑")
                }
            }
        }
    }, '-', {
        text: "下载音频",
        iconCls: 'icon-help',
        handler: function () {
            var row = $("#chapter_tg").treegrid("getSelected");
            if (row != null) {
                if (row.size != null) {
                    location.href = "${pageContext.request.contextPath}/chapter/download?url=" + row.url + "&title=" + row.title
                }
            }
        }
    }];

    $(function () {
        $("#al").treegrid({
            toolbar: toolbar,
            method: "post",
            url: '${pageContext.request.contextPath}/selectAlbumAll',
            idField: 'id',
            treeField: 'title',
            pagination: true,
            columns: [[
                {field: 'title', title: '名字', width: 60},
                {field: 'downpath', title: '路径', width: 60},
                {field: 'size', title: '大小', width: 80},
                {field: 'duration', title: '时长', width: 80}
            ]],
            fit: true,
            fitColumns: true
        })

        $('#album').dialog({
            title: '专辑详情',
            width: 400,
            height: 200,
            closed: true,
        });

    });

</script>


<table id="al"></table>
<div id="album">
    <form id="album_ff" method="post">
        <div>
            标题： <input id="name" class="easyui-validatebox" type="text" name="title" data-options="required:true"/>
        </div>
        <div>
            作者： <input class="easyui-validatebox" type="text" name="author" data-options="required:true"/>
        </div>
        <div>
            简介： <input class="easyui-validatebox" type="text" name="brief" data-options="required:true"/>
        </div>
        <div>
            封面： <img src="" id="album_img">
        </div>
    </form>
</div>


<%--<div id="chapter_dd">

    <form id="chapter_ff" method="post" ENCTYPE="multipart/form-data">
        <div>
            标题:<input class="easyui-validatebox" type="text" name="title" data-options="required:true"/>
        </div>
        <div>
            请选择:<input type="file" name="chapter" style="width:300px">
        </div>
        <div>
            <input type="hidden" name="id" id="p_id" value="" style="width:300px">
        </div>
    </form>
</div>--%>

<div id="audio">
    <audio id="audio_id" src="" autoplay="autoplay" controls="controls" loop="loop"></audio>
</div>




