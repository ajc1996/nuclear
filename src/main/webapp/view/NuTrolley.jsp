<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        #circles {
            width: 80px;
            height: 80px;
            -moz-border-radius: 50px;
            -webkit-border-radius: 50px;
            border-radius: 50px;
        }
    </style>
    <script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<script>
    function show() {
        $("#tros").html("");
        $.post("trolley/totrolley", {},
            function (data, status) {
                $.each(data, function (index, Items) {
                    $("#tros").append("    <div class=\"ibox-content\" >\n" +
                        "            <div  style=\"width: 800px;height:120px; \">\n" +
                        "            <div class=\"form-group\" style=\"width: 100px;height:100px;margin-top:10px;margin-left: 20px;\">\n" +
                        "            <div  style=\"width: 100px;height:100px;\">\n" +
                        "            <img src=\""+Items.gpic+"\" style=\"width: 100px;height:100px;\">\n" +
                        "            </div>\n" +
                        "            </div>\n" +
                        "\n" +
                        "            <div class=\"form-group\" style=\" float:left;  margin-left: 180px;margin-top: -115px;width:160px;height:100px;line-height: 100px;\" >\n" +
                        "\n" +
                        "            <a href=\"#\">" + Items.gname + "</a>\n" +
                        "            </div>\n" +
                        "            <div class=\"form-group\" style=\" float:left;  margin-left: 300px;margin-top: -115px;width:160px;height:100px;line-height: 100px;\">\n" +
                        "\n" +
                        "            <span>单价：</span>" + Items.gprice + "元\n" +
                        "        </div>\n" +
                        "        <div class=\"form-group\" style=\" float:left;  margin-left: 470px;margin-top: -115px;width:160px;height:100px;line-height: 100px;\">\n" +
                        "            <span>数量：</span>" + Items.tcount + "\n" +
                        "        </div>\n" +
                        "        <div class=\"form-group\" style=\" float:left; margin-left: 640px;margin-top: -115px;width:100px;height:100px;line-height: 100px;\">\n" +
                        "\n" +
                        "            <span>金额：</span><span id='count"+index+"'>" + Items.gprice * Items.tcount + "元\n</span>" +
                        "        </div>\n" +
                        "        <div class=\"form-group\" style=\" float:left;border-radius: 50%;  margin-left: 830px;margin-top: -115px;width:50px;height:20px;line-height: 100px;\">\n" +
                        "            <input type=\"button\"  class=\"btn btn-primary\" value=\"删除\"  onclick=\"deltrolley("+index+");\">\n" +
                        "            </div>\n" +
                        "        <div class=\"form-group\" style=\" float:left;border-radius: 50%; margin-left: 950px;margin-top: -115px;width:50px;height:20px;line-height: 100px;\">\n" +
                        "            <input type=\"button\"  class=\"btn btn-primary\" value=\"购买\"  onclick=\"buytrolley("+index+");\">\n" +
                        "            </div>\n" +
                        "        <div class=\"form-group\" style=\" position:relative;right:960px;top: 5px;float:left;border-radius: 50%; margin-left: 950px;margin-top: -115px;width:50px;height:20px;line-height: 100px;\">\n" +
                        "            <input type=\"checkbox\" class =\"tid\" id =\""+index+"\" name=\"tid\" value=\"" + Items.tid + "\">\n" +
                        "            </div>\n" +
                        "            </div>\n" +
                        "            </div>\n" +
                        "        ");
                });
            });
    }
    function getids() {
        var ids = new Array();
        var i = 0;
        $(".tid").each(function () {
            if ($(this).prop("checked")) {
                ids[i] = $(this).val();
                i++;
            }
        });
       return ids;
    }

    $(document).ready(function () {
        show();
        $("#ids").change(function () {
            $(".tid").each(function () {
                if ($("#ids").prop("checked")) {
                    if (!$(this).prop("checked")) {
                        $(this).prop("checked", true);
                    }
                }else{
                    if ($(this).prop("checked")) {
                        $(this).prop("checked", false);
                    }
                }
            });
        });
        $("#deleteall").click(function () {
            if (confirm("真的要删除吗?")) {
                var TrolleyModel = {
                    ids: getids()
                }
                $.ajax({
                    type: "post",
                    url: "trolley/delAll",
                    contentType: 'application/json;charset=UTF-8',
                    data: JSON.stringify(TrolleyModel),
                    success: function () {
                        alert("删除成功");
                        show();
                    },

                });
            }
        });

        $("#buyall").click(function () {
            var TrolleyModel = {
                ids: getids()
            };
            $.ajax({
                type: "post",
                url: "trolley/getcount",
                contentType: 'application/json;charset=UTF-8',
                data: JSON.stringify(TrolleyModel),
                success: function (data) {
                    var t=data.total;
                    if (confirm("确认购买？" + String.fromCharCode(10) + "共" +t+"元")) {
                        var TrolleyModel = {
                            ids: getids()
                        }
                        $.ajax({
                            type: "post",
                            url: "trolley/delAll",
                            contentType: 'application/json;charset=UTF-8',
                            data: JSON.stringify(TrolleyModel),
                            success: function () {
                                alert("购买成功");
                                show();
                            },

                        });
                    }
                },

            });

        });

    });



    function deltrolley(index) {
        var tid = $("#"+index).val();
        if (confirm("真的要删除吗?")) {
            $.ajax({
                type: 'post',
                url: 'trolley/removeTrolleyNu',
                contentType: 'application/json;charset=UTF-8',
                data: '{"tid":"' + tid + '"}',
                success: function (data) {
                    alert("删除成功");
                    show();
                }
            });
        }
    }

//    $(document).on("click",".btn-primary",function () {
//        alert("1");
//        var src = $(this).attr('value');
//        alert()
//
//    });

    function buytrolley(index) {
        var tid = $("#"+index).val();
        var count = $("#count"+index+"").text();
        var text = "确认购买？" + String.fromCharCode(10) + "共" + count;
        if (confirm(text)) {
            $.ajax({
                type: 'post',
                url: 'trolley/removeTrolleyNu',
                contentType: 'application/json;charset=UTF-8',
                data: '{"tid":"' + tid + '"}',
                success: function (data) {
                    alert("购买成功");
                    show();
                }
            });
        }
    }

</script>
<body class="gray-bg">
<input type="hidden" value="${id}" id="sessionid"/>

<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-10 col-sm-offset-1 ">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>购物车
                        <small></small>
                    </h5>
                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>
                        <a class="dropdown-toggle" data-toggle="dropdown" href="form_basic.html#" title="修改">
                            <i class="fa fa-wrench"></i>
                        </a>
                    </div>
                </div>
                <div id="tros">
                </div>

                <div style="float:left;;position: relative;left: 715px">
                    <input type="checkbox" id="ids" value=""
                           style="position: relative;right:740px;top:3px;margin:30px;text-align: center">
                    <span style="position: relative;right:740px;margin-top:30px">全选</span>
                    <input type="button" class="btn btn-primary" style="margin:30px" value="删除" id="deleteall" >
                    <input type="button" class="btn btn-primary" style="margin:30px" value="购买" id="buyall">
                </div>
            </div>
        </div>
    </div>
</div>


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
    //    $(document).ready(function(){
    //        $(".i-checks").iCheck({
    //            checkboxClass:"icheckbox_square-green",
    //            radioClass:"iradio_square-green"
    //        });
    //
    //        var sessionId = $("#sessionid").val();
    //        alert(sessionId);
    //        $.ajax({
    //            url:'/userFind',
    //            data:{
    //                uid:$('#sessionid').val()
    //            },
    //            type:'POST',
    //            dataType: 'text',
    //            success:function(data){
    //                var obj = eval('(' + data + ')');
    //                alert(obj.usex);
    //                var uusex = obj.usex;
    //                var utime = null;
    //                if(obj.ubirthday == null){
    //                    utime = obj.ubirthday;
    //                }else {
    //                    utime = getMyDate(obj.ubirthday);
    //                }
    //                $("#uphone").attr("value",obj.uphone);
    //                $("#ubirthday").attr("value",utime);
    //                if(-1 < uusex.indexOf("M")){
    //                    alert("1");
    //                    $("#usex2").removeAttr("checked");
    //                    $("#usex1").attr("checked","value");
    //                }else if(-1 < uusex.indexOf("W")){
    //                    alert("2");
    //                    $("#usex1").removeAttr("checked");
    //                    $("#usex2").attr("checked","value");
    //                }else{
    //                    alert("3");
    //                    $("#usex1").removeAttr("checked");
    //                    $("#usex2").removeAttr("checked");
    //                }
    //            },
    //            error:function (err){
    //                alert(err);
    //                alert("1");
    //            }
    //        });
    //
    //        //修改——转换日期格式(时间戳转换为datetime格式)
    //        function getMyDate(str){
    //            var oDate = new Date(str),
    //                oYear = oDate.getFullYear(),
    //                oMonth = oDate.getMonth()+1,
    //                oDay = oDate.getDate(),
    //                oTime = oYear +'-'+ getzf(oMonth) +'-'+ getzf(oDay);//最后拼接时间
    //            return oTime;
    //        }
    //
    //        //补0操作
    //        function getzf(num){
    //            if(parseInt(num) < 10){
    //                num = '0'+num;
    //            }
    //            return num;
    //        }
    //
    //        $("#modifyform1").ajaxForm(function (data) {
    //            alert("1");
    //            $('form').bootstrapValidator({
    //                message: 'This value is not valid',
    //                feedbackIcons: {
    //                    valid: 'glyphicon glyphicon-ok',
    //                    invalid: 'glyphicon glyphicon-remove',
    //                    validating: 'glyphicon glyphicon-refresh'
    //                },
    //                fields: {
    //                    uname: {
    //                        message: '账户名验证失败',
    //                        validators: {
    //                            notEmpty: {
    //                                message: '账户名不能为空'
    //                            },
    //                            stringLength: {
    //                                min: 6,
    //                                max: 18,
    //                                message: '账户名长度必须在6到18位之间'
    //                            },
    //                            regexp: {
    //                                regexp: /^[a-zA-Z0-9_]+$/,
    //                                message: '账户名由字母、数字、下划线组成'
    //                            },
    //                            remote: {
    //                                message: '该账户名以被注册',
    //                                url: "checkModify",
    //                                type: 'post',
    //                                data: function (validator) {
    //                                    return {
    //                                        uname: $("#uname").val()
    //                                    };
    //                                },
    //                                delay: 1000
    //                            }
    //                        }
    //                    },
    //                    uphone: {
    //                        validators: {
    //                            regexp: {
    //                                regexp: /^1[3|5|8]{1}[0-9]{9}$/,
    //                                message: '请输入正确的手机号码'
    //                            }
    //                        }
    //                    }
    //                }
    //            });
    //
    //            if(-1 < data.indexOf("modify1")){
    //                $("#uname").removeAttr("disabled");
    //                $("#ubirthday").removeAttr("disabled");
    //                $("#uphone").removeAttr("disabled");
    //                $("#usex1").removeAttr("disabled");
    //                $("#usex2").removeAttr("disabled");
    //                $("#btnmodify").html('保存');
    //                $("#modifyform1").attr("action","/usermodify2");
    //            }else if(-1 < data.indexOf("modify2")){
    //                $("#uname").attr("disabled",true);
    //                $("#ubirthday").attr("disabled",true);
    //                $("#usex2").attr("disabled",true);
    //                $("#usex1").attr("disabled",true);
    //                $("#uphone").attr("disabled",true);
    //                $("#btnmodify").html('修改');
    //                $("#modifyform1").attr("action","/usermodify");
    //            }
    //        });
    //    });
</script>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
</body>
</html>
