<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
    <!-- 先引用jquery -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>管理二级管理员</title>
    <meta name="description" content="使用bootstrap-table实现对所有管理员的增加，删除，查询">

    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/style.min862f.css?v=4.1.0" rel="stylesheet">

</head>
<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="ibox float-e-margins">
            <div class="col-sm-12">
                <!-- Example Events -->
                <div class="example-wrap">
                    <h4 class="example-title">事件</h4>
                    <div class="example">
                        <div class="btn-group hidden-xs" id="exampleTableEventsToolbar" role="group">
                            <button type="button" class="btn btn-outline btn-default" id="NuManageadd">
                                <i class="glyphicon glyphicon-plus" aria-hidden="true">新增</i>
                            </button>
                            <button type="button" class="btn btn-outline btn-default">
                                <i class="glyphicon glyphicon-pencil" aria-hidden="true">修改</i>
                            </button>
                            <button type="button" class="btn btn-outline btn-default">
                                <i class="glyphicon glyphicon-trash" aria-hidden="true">删除</i>
                            </button>
                        </div>
                        <table id="exampleTableEvents" data-height="400" data-mobile-responsive="true">
                        </table>
                    </div>
                </div>
                <!-- End Example Events -->
            </div>
        </div>
    </div>

    <%--modal 添加开始--%>
    <div class="modal fade" id="upload" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <form action="http://localhost:8080/GD/UploadAction_execute.action" method="post" enctype="multipart/form-data" name="uploadfile">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title" id="myModalLabelfile">上传文件</h4>
                    </div>
                    <div class="modal-body">
                        <input type="file" name="my" id="file" value="浏览" style="display: none;"
                               onchange="document.uploadfile.filePath.value=this.value"/>
                        <input type="text" name="filePath" id="filePath"/>
                        <input type="button" value="浏览..." onclick="document.uploadfile.my.click()"/><br>
                        <input type="submit" value="上传" id="shangchuan">
                    </div>
                    <div class="modal-footer"> <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>

                    </div>
                </div>
                <!-- /.modal-content -->
            </div>
            <!-- /.modal -->
        </form>
    </div>
    <%--modal 添加结束--%>

    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.6"></script>
    <script src="js/content.min.js?v=1.0.0"></script>
    <script src="js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
    <%--<script src="https://cdn.bootcss.com/bootstrap-table/1.2.2/bootstrap-table.js"></script>--%>
    <script src="js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
    <script src="js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
    <%--<script src="js/demo/bootstrap-table-demo.min.js"></script>--%>
    <%--<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>--%>
</body>
<script type="text/javascript">
    $(function () {
        //1.初始化Table
        var oTable = new TableInit();
        oTable.Init();
        //2.初始化Button的点击事件
        var oButtonInit = new ButtonInit();
        oButtonInit.Init();
        $("#NuManageadd").click(function () {
            $("#upload").modal('show');
        })

    });

    var TableInit = function () {
        var oTableInit = new Object();
        //初始化Table
        oTableInit.Init = function () {
            $('#exampleTableEvents').bootstrapTable({
                url: '/userquery',         //请求后台的URL（*）
                method: 'post',                      //请求方式（*）
                toolbar: '#exampleTableEventsToolbar',                //工具按钮用哪个容器
                striped: true,                      //是否显示行间隔色
                cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
                pagination: true,                   //是否显示分页（*）
                sortable: false,                     //是否启用排序
                sortOrder: "asc",                   //排序方式
                queryParams: oTableInit.queryParams,//传递参数（*）
                sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
                pageNumber:1,                       //初始化加载第一页，默认第一页
                pageSize: 10,                       //每页的记录行数（*）
                pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
                search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
                strictSearch: true,
                showColumns: true,                  //是否显示所有的列
                showRefresh: true,                  //是否显示刷新按钮
                minimumCountColumns: 1,             //最少允许的列数
                clickToSelect: true,                //是否启用点击选中行
                height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
                uniqueId: "ID",                     //每一行的唯一标识，一般为主键列
                showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
                cardView: false,                    //是否显示详细视图
                detailView: false,                   //是否显示父子表
                columns: [{
                    checkbox: true
                }, {
                    field: 'uid',
                    title: '管理员ID'
                }, {
                    field: 'uname',
                    title: '管理员帐号'
                }, {
                    field: 'upassword',
                    title: '管理员密码'
                }, {
                    field: 'upic',
                    title: '管理员头像'
                }, {
                    field: 'usex',
                    title: '管理员头像'
                }, {
                    field: 'ubirthday',
                    title: '管理员头像'
                }, {
                    field: 'ulimits',
                    title: '管理员头像'
                }, {
                    field: 'uphone',
                    title: '管理员头像'
                }]
            });
        };
        //得到查询的参数
        oTableInit.queryParams = function (params) {
            var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                limit: params.limit,   //页面大小
                offset: params.offset,  //页码
                uid: $("#uid").val(),
                upassword: $("#upassword").val()
            };
            return temp;
        };
        return oTableInit;
    };


    var ButtonInit = function () {
        var oInit = new Object();
        var postdata = {};

        oInit.Init = function () {
            //初始化页面上面的按钮事件
        };

        return oInit;
    };
</script>
</html>