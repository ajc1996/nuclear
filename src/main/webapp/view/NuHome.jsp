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
    <link href="css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link rel="stylesheet" href="css/goods.css">
    <link rel="stylesheet" href="css/style1.css">
    <link rel="stylesheet" href="css/shouye.css">
    <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <script   src="js/modernizr-custom-v2.7.1.min.js"></script>
    <script src="js/bootstrap.min.js?v=3.3.6"></script>
    <style>
        body{
            background-image: url(images/77.jpg);
        }
    </style>
    <script>
        $(document).ready(function(){
            var $miaobian=$('.Xcontent08>div');
            var $huantu=$('.Xcontent06>img');
            var $miaobian1=$('.Xcontent26>div');
            $miaobian.mousemove(function(){miaobian(this);});
            $miaobian1.click(function(){miaobian1(this);});
            function miaobian(thisMb){
                for(var i=0; i<$miaobian.length; i++){
                    $miaobian[i].style.borderColor = '#dedede';
                }
                thisMb.style.borderColor = '#cd2426';

                $huantu[0].src = thisMb.children[0].src;
            }
            function miaobian1(thisMb1){
                for(var i=0; i<$miaobian1.length; i++){
                    $miaobian1[i].style.borderColor = '#dedede';
                }
//		thisMb.style.borderColor = '#cd2426';
                $miaobian.css('border-color','#dedede');
                thisMb1.style.borderColor = '#cd2426';
                $huantu[0].src = thisMb1.children[0].src;
            }
            $(".Xcontent33").click(function(){
                var value=parseInt($('.input').val())+1;
                $('.input').val(value);
            })

            $(".Xcontent32").click(function(){
                var num = $(".input").val()
                if(num>0){
                    $(".input").val(num-1);
                }
            })
        })
    </script>
</head>
<body>
    <div class="topbar">
        <div class=" shop_title">核动力商城</div>
        <div class="container">
            <div class="container">
                <div class="header-search">
                    <form action="" class="search-form">
                        <input type="text" class="search-text" id="gname" name="gname">
<%--                        <input type="submit" class="search-btn iconfont" value="&#xe652;">--%>
                        <button type="button" class="search-btn iconfont" value="&#xe652;" id="btnquerybtn">&#xe652;</button>
                    </form>
                </div>
            </div>
            <div class="shortcon"><img class="imga" src=""><span class="username">${username}</span></div>
            <div class="topbar-cart">
                <a href="#"><i></i>购物车</a>
            </div>
            <div class="topbar-info">
                <a href="#" class="link">登录</a>
                <span class="ver">|</span>
                <a href="#" class="link">注册</a>
                <span class="ver">|</span>
            </div>
        </div>
    </div>

    <div style="margin-top: 200px">

    </div>
    <%-- 循环 --%>
    <div class="piclist" style="background:transparent;">
        <ul class="listul">

        </ul>
        <div class="fydiv">
            <ul class="fenye">

            </ul>
        </div>
    </div>

    <%--modal框开始--%>
    <div class="modal inmodal" id="myModal22" tabindex="-1" role="dialog" aria-hidden="true" style="overflow:scroll">
        <div class="modal-dialog modal-lg">
            <div class="modal-content animated flipInY">
                <form id="form1" action="/goodsadd" method="post">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h4 class="modal-title">添加商品</h4>
                        <small class="font-bold" />
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <div class="row">
                                <div class="col-md-3">
                                    <img src="imgs/1505738536052.jpg" id='imgreal' class='img-responsive center-block'/>
                                </div>
                                <div class="col-md-4">

                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-white" data-dismiss="modal" id="btnclose">关闭</button>
                        <button type="submit" class="btn btn-primary" id="btnadd">保存</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <%--modal框结束--%>


    <a><div class="return_top"></div></a>
    <a data-toggle="modal" data-target="#avatar-modal"><div class="return_index">回到首页</div></a>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        $.ajax({
            type : "post",
            url :"selectByHome",
            contentType:'application/json;charset=UTF-8',
            dataType: 'text',
            success:function (re) {
                var data1 = eval('('+re+')');
                data2 = data1;
                dataCount = data1.length;
                getPage(1);
            },
            error:function (re) {
                alert(re);
                alert(2);
            }
        });

        $(".modalbtn").click(function () {
            alert("1");
        });
    });

    $('#btnquerybtn').click(function() {
        alert($("#gname").val());
        $.ajax({
            type : "post",
            url : "selectByGname",
            data: { gname :$("#gname").val()},
//            contentType:'application/json;charset=UTF-8',
            dataType: 'text',
            success:function (re) {
                alert("出来");
                var data1 = eval('('+re+')');
                data2 = data1;
                dataCount = data1.length;
                getPage(1);
            }
        })
    });

    
    function getPage(pn){
        var pageSize=8;//每页显示条数
        var pageCount= Math.ceil(dataCount / pageSize);//总页数
        if(pn==0||pn>pageCount){
            return;
        }
        var ul=$(".listul");
        ul.empty();
        //console.log(pageCount+"..."+pn)
        paintPage(pageCount,pn);   //绘制页码
        var startPage = pageSize * (pn - 1);

        if (pageCount == 1) {     // 当只有一页时
            for (var j = 0; j < dataCount; j++) {
                var e="<li><a data-toggle=\"modal\" data-target=\"#myModal22\"><img class=\"modalbtn\" src=\""+data2[j].gpic+"\" class=\"text-align\:center\"></a><p><span>"+data2[j].gname+"</span></p><p><span>"+data2[j].gname+"</span></p></li>";
                ul.append(e);
            }
        }else {      // 当超过一页时
            var e="";
            var endPage = pn<pageCount?pageSize * pn:dataCount;
            for (var j = startPage; j < endPage; j++) {
                var e="<li><a data-toggle=\"modal\" data-target=\"#myModal22\"><img class=\"modalbtn\" src=\""+data2[j].gpic+"\" class=\"text-align\:center\"></a><p><span >"+data2[j].gname+"</span></p><p><span>"+data2[j].gname+"</span></p></li>";
                ul.append(e);
            }
        }
    }


    //绘制页码
    function paintPage(number,currNum)  //number 总页数,currNum 当前页
    {
        var pageUl=$(".fenye");
        pageUl.empty();
        var ulDetail="";
        if(number==1){
            ulDetail= "<li class=\"prev\"><a href=\"javascript:void(0)\">上一页</a></li>"+
                "<li class=\"numb choose\"><a href=\"javascript:getPage(1)\">1</a></li>"+
                "<li class=\"next\"><a href=\"javascript:void(0)\">下一页</a></li>";
        }else if(number==2){
            ulDetail= "<li class=\"prev\"><a href=\"javascript:getPage(1)\">上一页</a></li>"+
                "<li class=\"numb"+choosele(currNum,1)+"\"><a href=\"javascript:getPage(1)\">1</a></li>"+
                "<li class=\"numb"+choosele(currNum,2)+"\"><a href=\"javascript:getPage(2)\">2</a></li>"+
                "<li class=\"next\"><a href=\"javascript:getPage(2)\">下一页</a></li>";
        }else if(number==3){
            ulDetail= "<li class=\"prev\"><a href=\"javascript:getPage("+parseInt(currNum-1)+")\">上一页</a></li>"+
                "<li class=\"numb"+choosele(currNum,1)+"\"><a href=\"javascript:getPage(1)\">1</a></li>"+
                "<li class=\"numb"+choosele(currNum,2)+"\"><a href=\"javascript:getPage(2)\">2</a></li>"+
                "<li class=\"numb"+choosele(currNum,3)+"\"><a href=\"javascript:getPage(3)\">3</a></li>"+
                "<li class=\"next\"><a href=\"javascript:getPage("+parseInt(currNum+1)+")\">下一页</a></li>";
        }else if(number==currNum&&currNum>3){
            ulDetail= "<li class=\"prev\"><a href=\"javascript:getPage("+parseInt(currNum-1)+")\">上一页</a></li>"+
                "<li class=\"numb\"><a href=\"javascript:getPage("+parseInt(currNum-2)+")\">"+parseInt(currNum-2)+"</a></li>"+
                "<li class=\"numb\"><a href=\"javascript:getPage("+parseInt(currNum-1)+")\">"+parseInt(currNum-1)+"</a></li>"+
                "<li class=\"numb choose\"><a href=\"javascript:getPage("+currNum+")\">"+currNum+"</a></li>"+
                "<li class=\"next\"><a href=\"javascript:getPage("+currNum+")\">下一页</a></li>";
        }else if(currNum==1&&number>3){
            ulDetail= "<li class=\"prev\"><a href=\"javascript:void(0)\">上一页</a></li>"+
                "<li class=\"numb choose\"><a href=\"javascript:void(0)\">1</a></li>"+
                "<li class=\"numb\"><a href=\"javascript:getPage(2)\">2</a></li>"+
                "<li class=\"numb\"><a href=\"javascript:getPage(3)\">3</a></li>"+
                "<li class=\"next\"><a href=\"javascript:getPage(2)\">下一页</a></li>";
        }else{
            ulDetail= "<li class=\"prev\"><a href=\"javascript:getPage("+parseInt(currNum-1)+")\">上一页</a></li>"+
                "<li class=\"numb\"><a href=\"javascript:getPage("+parseInt(currNum-1)+")\">"+parseInt(currNum-1)+"</a></li>"+
                "<li class=\"numb choose\"><a href=\"javascript:getPage("+currNum+")\">"+currNum+"</a></li>"+
                "<li class=\"numb\"><a href=\"javascript:getPage("+parseInt(currNum+1)+")\">"+parseInt(currNum+1)+"</a></li>"+
                "<li class=\"next\"><a href=\"javascript:getPage("+parseInt(currNum+1)+")\">下一页</a></li>";
        }

        $(".fenye").append(ulDetail);

    }

    function choosele(num,cur){
        if(num==cur){
            return " choose";
        }else{
            return "";
        }
    }
</script>
</html>