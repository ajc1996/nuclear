<%@ page language="java" import="java.util.*" import="javax.servlet.http.HttpSession" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<!-- Mirrored from www.zi-han.net/theme/hplus/form_basic.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:19:15 GMT -->
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>核动力商城修改</title>
    <meta name="keywords" content="后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="favicon.ico">
    <link href="css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <link href="https://cdn.bootcss.com/bootstrap-validator/0.5.3/css/bootstrapValidator.min.css" rel="stylesheet">
    <link href="head/cropper.min.css" rel="stylesheet">
    <link href="head/sitelogo.css" rel="stylesheet">
    <style>
        #circles{
            width: 80px;
            height: 80px;
            -moz-border-radius: 50px;
            -webkit-border-radius: 50px;
            border-radius: 50px;
        }
    </style>

</head>

<body class="gray-bg">
    <input type="hidden" value="${id}" id="sessionid" />
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-6 col-sm-offset-3">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>个人信息 <small></small></h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                            <a class="dropdown-toggle" data-toggle="dropdown" href="form_basic.html#" title="修改">
                                <i class="fa fa-wrench"></i>
                            </a>
                            <a class="close-link">
                                <i class="fa fa-times"></i>
                            </a>
                        </div>
                    </div>
                    <div class="ibox-content">
                        <form method="post" action="/usermodify" class="form-horizontal" id="modifyform1" name="form1">
                            <div class="form-group">
                                <label class="col-sm-4 control-label">用户名</label>
                                <div class="col-sm-5">
                                    <input type="text" class="form-control" disabled="" value="${name}" id="uname" name="uname">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label" style="line-height: 80px">头像</label>
                                <div class="col-sm-5">
                                    <div class="avatar-wrapper preview-lg" id="circles">
                                        <a data-toggle="modal" data-target="#avatar-modal"><img class="img-responsive center-block img-circle" src="${pic}" /></a>
                                    </div>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label">性别</label>
                                <div class="col-sm-5">
                                    <div class="radio i-checks">
                                        <label>
                                            <input type="radio" value="M" disabled="" id="usex1" name="usex"> <i></i> 男</label>
                                        <label>
                                            <input type="radio" value="W" disabled="" id="usex2" name="usex"> <i></i> 女</label>
                                    </div>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label">生日</label>
                                <div class="col-sm-5">
                                    <input type="text" disabled="" class="form-control" value="" id="ubirthday" name="ubirthday">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label">联系电话</label>

                                <div class="col-sm-5">
                                    <input type="text" disabled="" class="form-control" value="" id="uphone" name="uphone">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <div class="col-sm-2 col-sm-offset-4">
                                    <button class="btn btn-primary" id="btnmodify" value="修改">修改</button>
                                </div>
                                <div class="col-sm-1">
                                    <button class="btn btn-white" type="submit">取消</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <%-- 裁剪图片modal开始 --%>
    <div class="modal fade" id="avatar-modal" aria-hidden="true" aria-labelledby="avatar-modal-label" role="dialog" tabindex="-1" style="overflow:scroll">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <!--<form class="avatar-form" action="upload-logo.php" enctype="multipart/form-data" method="post">-->
                <form class="avatar-form">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h4 class="modal-title" id="avatar-modal-label">上传图片</h4>
                    </div>
                    <div class="modal-body">
                        <div class="avatar-body">
                            <div class="avatar-upload">
                                <input class="avatar-src" name="avatar_src" type="hidden">
                                <input class="avatar-data" name="avatar_data" type="hidden">
                                <label for="avatarInput" style="line-height: 35px;">图片上传</label>
                                <button class="btn btn-danger"  type="button" style="height: 35px;" onclick="$('input[id=avatarInput]').click();">请选择图片</button>
                                <span id="avatar-name"></span>
                                <input class="avatar-input hide" id="avatarInput" name="avatar_file" type="file">
                            </div>
                            <div class="row">
                                <div class="col-md-9">
                                    <div class="avatar-wrapper"></div>
                                </div>
                                <div class="col-md-3">
                                    <div class="avatar-preview preview-lg" id="imageHead"></div>
                                </div>
                            </div>
                            <div class="row avatar-btns">
                                <div class="col-md-4">
                                    <div class="btn-group">
                                        <button class="btn btn-danger fa fa-undo" data-method="rotate" data-option="-90" type="button" title="Rotate -90 degrees"> 向左旋转</button>
                                    </div>
                                    <div class="btn-group">
                                        <button class="btn  btn-danger fa fa-repeat" data-method="rotate" data-option="90" type="button" title="Rotate 90 degrees"> 向右旋转</button>
                                    </div>
                                </div>
                                <div class="col-md-5" style="text-align: right;">
                                    <button class="btn btn-danger fa fa-arrows" data-method="setDragMode" data-option="move" type="button" title="移动">
                                            <span class="docs-tooltip" data-toggle="tooltip" title="" data-original-title="$().cropper(&quot;setDragMode&quot;, &quot;move&quot;)">
                                            </span>
                                    </button>
                                    <button type="button" class="btn btn-danger fa fa-search-plus" data-method="zoom" data-option="0.1" title="放大图片">
                                            <span class="docs-tooltip" data-toggle="tooltip" title="" data-original-title="$().cropper(&quot;zoom&quot;, 0.1)">
                                              <!--<span class="fa fa-search-plus"></span>-->
                                            </span>
                                    </button>
                                    <button type="button" class="btn btn-danger fa fa-search-minus" data-method="zoom" data-option="-0.1" title="缩小图片">
                                            <span class="docs-tooltip" data-toggle="tooltip" title="" data-original-title="$().cropper(&quot;zoom&quot;, -0.1)">
                                              <!--<span class="fa fa-search-minus"></span>-->
                                            </span>
                                    </button>
                                    <button type="button" class="btn btn-danger fa fa-refresh" data-method="reset" title="重置图片">
                                                <span class="docs-tooltip" data-toggle="tooltip" title="" data-original-title="$().cropper(&quot;reset&quot;)" aria-describedby="tooltip866214">
                                                </span>
                                    </button>
                                </div>
                                <div class="col-md-3">
                                    <button class="btn btn-danger btn-block avatar-save fa fa-save" type="button" data-dismiss="modal"> 保存修改</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <%-- 裁剪图片modal结束 --%>

    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.6"></script>
    <script src="js/content.min.js?v=1.0.0"></script>
    <script src="js/plugins/iCheck/icheck.min.js"></script>
    <script href="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="https://cdn.bootcss.com/bootstrap-validator/0.5.3/js/bootstrapValidator.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap-validator/0.5.3/js/language/zh_CN.js"></script>
    <script src="https://cdn.bootcss.com/jquery.form/4.2.1/jquery.form.js"></script>
    <script src="js/plugins/sweetalert/sweetalert.min.js"></script>
    <script src="head/cropper.js"></script>
    <script src="head/sitelogo.js"></script>
    <script src="head/html2canvas.min.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            $(".i-checks").iCheck({
                checkboxClass:"icheckbox_square-green",
                radioClass:"iradio_square-green"
            });

            var sessionId = $("#sessionid").val();
            alert(sessionId);
            $.ajax({
                url:'/userFind',
                data:{
                    uid:$('#sessionid').val()
                },
                type:'POST',
                dataType: 'text',
                success:function(data){
                    var obj = eval('(' + data + ')');
                    alert(obj.usex);
                    var uusex = obj.usex;
                    var utime = null;
                    if(obj.ubirthday == null){
                        utime = obj.ubirthday;
                    }else {
                        utime = getMyDate(obj.ubirthday);
                    }
                    $("#uphone").attr("value",obj.uphone);
                    $("#ubirthday").attr("value",utime);
                    if(-1 < uusex.indexOf("M")){
                        alert("1");
                        $("#usex2").removeAttr("checked");
                        $("#usex1").attr("checked","value");
                    }else if(-1 < uusex.indexOf("W")){
                        alert("2");
                        $("#usex1").removeAttr("checked");
                        $("#usex2").attr("checked","value");
                    }else{
                        alert("3");
                        $("#usex1").removeAttr("checked");
                        $("#usex2").removeAttr("checked");
                    }
                },
                error:function (err){
                    alert(err);
                    alert("1");
                }
            });

            //修改——转换日期格式(时间戳转换为datetime格式)
            function getMyDate(str){
                var oDate = new Date(str),
                    oYear = oDate.getFullYear(),
                    oMonth = oDate.getMonth()+1,
                    oDay = oDate.getDate(),
                    oTime = oYear +'-'+ getzf(oMonth) +'-'+ getzf(oDay);//最后拼接时间
                return oTime;
            }

            //补0操作
            function getzf(num){
                if(parseInt(num) < 10){
                    num = '0'+num;
                }
                return num;
            }

            $("#modifyform1").ajaxForm(function (data) {
                alert("1");
                $('form').bootstrapValidator({
                    message: 'This value is not valid',
                    feedbackIcons: {
                        valid: 'glyphicon glyphicon-ok',
                        invalid: 'glyphicon glyphicon-remove',
                        validating: 'glyphicon glyphicon-refresh'
                    },
                    fields: {
                        uname: {
                            message: '账户名验证失败',
                            validators: {
                                notEmpty: {
                                    message: '账户名不能为空'
                                },
                                stringLength: {
                                    min: 6,
                                    max: 18,
                                    message: '账户名长度必须在6到18位之间'
                                },
                                regexp: {
                                    regexp: /^[a-zA-Z0-9_]+$/,
                                    message: '账户名由字母、数字、下划线组成'
                                },
                                remote: {
                                    message: '该账户名以被注册',
                                    url: "checkModify",
                                    type: 'post',
                                    data: function (validator) {
                                        return {
                                            uname: $("#uname").val()
                                        };
                                    },
                                    delay: 1000
                                }
                            }
                        },
                        uphone: {
                            validators: {
                                regexp: {
                                    regexp: /^1[3|5|8]{1}[0-9]{9}$/,
                                    message: '请输入正确的手机号码'
                                }
                            }
                        }
                    }
                });

                if(-1 < data.indexOf("modify1")){
                    $("#uname").removeAttr("disabled");
                    $("#ubirthday").removeAttr("disabled");
                    $("#uphone").removeAttr("disabled");
                    $("#usex1").removeAttr("disabled");
                    $("#usex2").removeAttr("disabled");
                    $("#btnmodify").html('保存');
                    $("#modifyform1").attr("action","/usermodify2");
                }else if(-1 < data.indexOf("modify2")){
                    $("#uname").attr("disabled",true);
                    $("#ubirthday").attr("disabled",true);
                    $("#usex2").attr("disabled",true);
                    $("#usex1").attr("disabled",true);
                    $("#uphone").attr("disabled",true);
                    $("#btnmodify").html('修改');
                    $("#modifyform1").attr("action","/usermodify");
                }
            });
        });
    </script>
    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
</body>
</html>
