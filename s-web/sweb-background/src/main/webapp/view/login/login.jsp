<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title></title>
  <link href="<%=basePath %>/css/home/bootstrap.min.css" rel="stylesheet">
  <link href="<%=basePath %>/css/home/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
  <link href="<%=basePath %>/css/home/animate.min.css" rel="stylesheet">
  <link href="<%=basePath %>/css/home/style.min.css" rel="stylesheet">
  <link href="<%=basePath %>/css/home/login.min.css" rel="stylesheet">
  <!-- Bootstrap -->

  <link href="<%=basePath %>/plugins/iconfont/iconfont.css" rel="stylesheet">
  <link href="<%=basePath %>/css/home/signin.css" rel="stylesheet">
  <script type="text/javascript" src="<%=basePath %>/js/jquery/jquery-3.2.1.min.js"></script>

  <link href="<%=basePath %>/js/login/application.css" media="all" rel="stylesheet">
  <script src="<%=basePath %>/js/login/application.js"></script>
</head>
<style>
  .signinpanel .uname
  {
    background:#fff url(${basePath}/back/images/user.png) no-repeat 95% center;color:#333
  }
  .signinpanel .pword{
    background:#fff url(${basePath}/back/images/locked.png) no-repeat 95% center;color:#333
  }
</style>

<body class="sessions-new" style="background: url(<%=basePath %>/js/login/star.png) #000 no-repeat center center;background-size:auto 650px;">
<!-- 是否开启验证码-->
<input type="hidden" id="patchcaFlag" value="1"/>
<div class="signinpanel">
  <div class="row">
    <div class="col-sm-7">
      <div class="signin-info">
        <div class="logopanel m-b">
        </div>
        <div class="m-b"></div>
      </div>
    </div>
    <div class="col-sm-5" style="margin-left: 25%;margin-bottom: 30%">
      <form method="post" id="lForm">
        <h2 class="form-signin-heading"><img alt="" src="" width="165" max-height="39" id="lgLogo">  </h2>
        <input type="text" class="form-control uname" placeholder="用户名" name="name" id="managername" />
        <input type="password" class="form-control pword m-b" placeholder="密码"  name="password" id="managerpassword"/>
        <div class="row" id="geetestDiv">
          <div class="col-sm-7" >
            <%--<input type="text" class="form-control pword m-b code_text" placeholder="验证码"  style="margin-top: 1px">--%>
            <input type="text" placeholder="验证码"  style="margin-top: 1px" class="form-control pword m-b code_text">
          </div>
          <div class="col-sm-5"  >
            <a href="javascript:;"><img height="40" class="code_image" src="patchca.htm" alt="验证码" id="Patchs" title="点击换一张图片" style="cursor:pointer; width:100%;height: 34px; margin-top:1px;" onclick="this.src=this.src+'?'+Math.random(); " ></a>
          </div>
        </div>
        <div class="form-group">
          <div class="alert alert-danger alert-dismissible fade in" role="alert" id="login_error"  style="display:none;width:233px;">
            <button type="button" class="close"  onclick="hidediv(this);"  aria-label="Close"><span aria-hidden="true">×</span></button>
            <div style="float: left;"><strong>用户名或密码</strong>填写有误! </div><b data-container="body" data-toggle="popover" data-placement="right" data-trigger="hover" data-content="请联系我们的客服为您重置密码，请将您的身份认证信息准备齐全。" style="color: #428bca; display: inline-flex;"></b>
          </div>
          <div class="alert alert-danger alert-dismissible fade in " style="display: none" role="alert" id="code_old" >
            <button type="button" class="close" onclick="hidediv(this);" aria-label="Close"><span aria-hidden="true">×</span></button>
            <strong>验证码错误！</strong>
          </div>
        </div>
        <button class="btn btn-success btn-block" type="button" onclick="login();">登录</button>
      </form>
    </div>
  </div>
  <%--<div class="signup-footer">--%>
    <%--<div class="pull-left">--%>
      <%--&copy; 2015 All Rights Reserved. H+--%>
    <%--</div>--%>
  <%--</div>--%>
</div>
<div class="bottom_links"  style="background:rgba(0,0,0,.5);padding-top:0px;">
  <ul style="color:#ffffff;margin-bottom:0;">
    <li><a href="javascript:;">版权所有©南京大本营科技有限公司 <span id="copyright"></span></a></li>
    <li><a href="javascript:;"><span id="beian"></span></a></li>
    <li><a href="javascript:changeBgimg();">切换背景</a></li>
  </ul>
</div>

</div> <!-- /container -->
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<%=basePath %>/bootstrap/js/bootstrap.min.js"></script>
<script>
    document.onkeydown=function(event){
        var e = event || window.event || arguments.callee.caller.arguments[0];
        if(e && e.keyCode==13){ // enter 键
            //要做的事情
            login();
        }
    };

    var emp = null;
    function getPatcha(){
    }

    var patchaFlag;
    $(function(){




    });
    function login(){
        $("#managername").parents(".form-group").removeClass("has-error");
        $("#managerpassword").parents(".form-group").removeClass("has-error");
        patchaFlag = "0";
        var enterValue = $(".code_text").val();

        if( patchaFlag!="" && patchaFlag==0){
            $.ajax({
                url: "iflogin.htm",
                context: document.body,
                type: 'POST',
                async:false,
                data:{name:$("#managername").val(),password:$("#managerpassword").val(),code:enterValue,patchcaFlag:$("#patchcaFlag").val()},
                success: function(data){
                    if(data == 0){
                        //用户名错误
                        $("#login_error").css({"display":"block"});
                        $("#managername").parents(".form-group").addClass("has-error");
                        $("#Patchs").click();
                    }else if(data==-1) {
                 $("#Patchs").click();
                        $("#code_old").show();

                    }else if(data == 2){
                        //密码错误
                        $("#login_error").css({"display":"block"});
                        $("#Patchs").click();
                    }else if(data == 3){
                        //用户名错误
                        $("#login_error").css({"display":"block"});
                        $("#Patchs").click();
                    }else{
//                        alert('登录成功!')
                        window.location.href="index.htm";

                    }
                }});
        }else{

            $.ajax({
                url: "iflogin.htm",
                context: document.body,
                async:false,
                type: 'POST',
                data:{name:$("#managername").val(),password:$("#managerpassword").val(),code:enterValue},
                success: function(data){
                    if(data == 0){
                        //用户名错误
                        $("#login_error").css({"display":"block"});
                        $("#managername").parents(".form-group").addClass("has-error");
                      /*如果失败修更新验证码**/
                        $(".code_image").click();
                        $(".code_text").val("");
                        getPatcha();
                    }else if(data == 2){
                        //密码错误
                        $("#login_error").css({"display":"block"});
                        $("#managerpassword").parents(".form-group").addClass("has-error");
                      /*如果失败修更新验证码*/
                        $(".code_image").click();
                        $(".code_text").val("");
                        getPatcha();
                    }else if(data == 3){
                        //用户名错误*/
                        $("#login_error").css({"display":"block"});
                        $("#managername").parents(".form-group").addClass("has-error");
                        $("#managerpassword").parents(".form-group").addClass("has-error");
                        $(".code_image").click();
                        $(".code_text").val("");
                        getPatcha();
                    }else if (data == -1){
                        getPatcha();
                        $(".code_text").parents(".form-group").addClass("has-error");
                        $("#code_old").css({"display":"block"});
                        $(".code_image").click();
                        $(".code_text").val("");
                        getPatcha();
                    }else
                    {

                        window.location.href="index.htm";
                    }
                }});

        }

    }
    //随机生成一张背景图片
    function changeBgimg(){
        var n = Math.floor(Math.random()*3)+1;
        $("body").css("backgroundImage",'url(<%=basePath%>images/bgimg/'+n+'.png)');
        $("body").css("background-repeat",'no-repeat');

        if (n == 10) {
            $("body").css("background-size", 'auto 900px');
        } else if (n == 11) {
            $("body").css("background-size", 'auto 100%');
        } else {
            $("body").css("background-size", '100% 100%');
        }
    }
    $(function(){changeBgimg();});
    $(function () {
        $("#geetestDiv .float").css("float","right");
        $('[data-toggle="popover"]').popover();


        <%--//获取验证码开关--%>
        <%--$.ajax({--%>
            <%--url: "newgetLoginPatcha.htm?CSRFToken=${token}",--%>
            <%--async:false,--%>
            <%--success: function(data){--%>
                <%--if(data!=null&&data !=''){--%>
                    <%--$("#geetestDiv").hide();--%>
                    <%--$("#patchcaFlag").val(0);--%>

                <%--}--%>
            <%--}});--%>

        <%--//获取登录logo--%>
        <%--$.ajax({--%>
            <%--url: "ajaxGetSysBasic.htm?CSRFToken=${token}",--%>
            <%--success: function(data){--%>
                <%--if(data.loginLogo!=""){--%>
                    <%--$("#lgLogo").attr("src",data.loginLogo);--%>
                <%--}--%>
                <%--if(data.temp1!=""){--%>
                    <%--$("#copyright").text(data.temp1);--%>
                <%--}--%>
                <%--if(data.temp2!=""){--%>
                    <%--$("#beian").text(data.temp2);--%>
                <%--}--%>
                <%--if(data.bsetName!=null&&data.bsetName!=""){--%>
                    <%--$("title").html("后台登录 - "+data.bsetName);--%>
                <%--}--%>
            <%--}--%>
        <%--});--%>


    });
    function hidediv(obj){
        $(obj).parent().hide();
    }

    //授权验证
    function checkAuthorization() {
        $("#authorize_box").css({"display":"none"});
        $("#login_box").css({"display":"block"});
    }
</script>
</body>
</html>