<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/common-tags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <title>技能鉴定后台处理系统</title>

    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <!--[if lt IE 9]>
  <meta http-equiv="refresh" content="0;ie.html"/>
    <![endif]-->

    <link rel="shortcut icon" href="">
    <link href="${basePath}/resources/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="${basePath}/resources/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="${basePath}/resources/css/animate.min.css" rel="stylesheet">
    <link href="${basePath}/resources/css/style.min862f.css?v=4.1.0" rel="stylesheet">
</head>

<body class="fixed-sidebar full-height-layout gray-bg skin-1" style="overflow:hidden">
<div id="wrapper">
    <!--左侧导航开始-->
    <nav class="navbar-default navbar-static-side" role="navigation" style="width: 180px;">
        <div class="nav-close"><i class="fa fa-times-circle"></i>
        </div>
        <div class="sidebar-collapse">
            <ul class="nav" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element">
                        <span>
                            <img alt="image" id="bossSiteLogo" style="max-height:75px; max-width: 85px;"  class="img-circle"
                                 src="http://dby-ishop.b0.upaiyun.com/1494575821297.jpg"/>
                        </span>
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <span class="text-muted text-xs block">欢迎您&nbsp;&nbsp;
                                    <strong class="font-bold">
                                      ${name}
                                    </strong>
                            </span>
                        </a>
                    </div>
                    <div class="logo-element">
                    </div>
                </li>
                  <li>
                      <a href="#">
                          <span class="nav-label"><i class="fa fa-cogs" aria-hidden="true"></i>系统</span>
                          <span class="fa arrow"></span>
                      </a>
                        <ul class="nav nav-second-level">
                          <li>
                              <a class="J_menuItem"
                                 href="${basePath}/initAuthority.htm">角色管理</a>
                          </li>
                            <li>
                                <a class="J_menuItem"
                                   href="#">权限管理</a>
                            </li>
                            <li>
                                <a class="J_menuItem"
                                   href="${basePath}/initSetting.htm">菜单管理</a>
                            </li>
                            <li>
                                <a class="J_menuItem"
                                   href="#">操作日志</a>
                            </li>
                        </ul>
                  </li>
                <li>
                    <a href="#">
                        <span class="nav-label">用户管理</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a class="J_menuItem"
                               href="#">系统管理</a>
                        </li>
                        <li>
                            <a class="J_menuItem"
                               href="#">权限管理</a>
                        </li>
                        <li>
                            <a class="J_menuItem"
                               href="#">菜单管理</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#">
                        <span class="nav-label">信息查询</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a class="J_menuItem"
                               href="#">系统管理</a>
                        </li>
                        <li>
                            <a class="J_menuItem"
                               href="#">权限管理</a>
                        </li>
                        <li>
                            <a class="J_menuItem"
                               href="#">菜单管理</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </nav>
    <!--左侧导航结束-->
    <!--右侧部分开始-->
    <div id="page-wrapper" class="gray-bg dashbard-1" style="margin: 0 0 0 180px;">

        <div class="row content-tabs">
            <button class="roll-nav roll-left J_tabLeft"><i class="fa fa-backward"></i>
            </button>
            <nav class="page-tabs J_menuTabs">
                <div class="page-tabs-content">
                    <a href="javascript:;" class="active J_menuTab" data-id="${basePath}/controlPanelInfo.html">首页</a>
                </div>
            </nav>
            <button class="roll-nav roll-right J_tabRight"><i class="fa fa-forward"></i>
            </button>
            <div class="btn-group roll-nav roll-right">
                <button class="dropdown J_tabClose" data-toggle="dropdown">关闭操作<span class="caret"></span>

                </button>
                <ul role="menu" class="dropdown-menu dropdown-menu-right">
                    <li class="J_tabShowActive"><a>定位当前选项卡</a>
                    </li>
                    <li class="divider"></li>
                    <li class="J_tabCloseAll"><a>关闭全部选项卡</a>
                    </li>
                    <li class="J_tabCloseOther"><a>关闭其他选项卡</a>
                    </li>
                </ul>
            </div>
            <a href="${basePath}/logout.html" class="roll-nav roll-right J_tabExit"><i
                    class="fa fa fa-sign-out"></i> 退出</a>
        </div>
        <div class="row J_mainContent" id="content-main" style="height: calc(100% - 42px);">
            <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="${basePath}/controlPanelInfo.html"
                    frameborder="0"
                    data-id="${basePath}/controlPanelInfo.html" seamless></iframe>

        </div>
    </div>
    <!--右侧部分结束-->


</div>
<div id="logoutModal" class="modal fade Noprint" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">退出系统</h4>
            </div>
            <form class="form-horizontal" method="post" action="${basePath}/logout.htm">
                <div class="modal-body">
                    <div class="form-group">
                        <p class="text-muted">您确定要退出系统吗？</p>
                    </div>

                </div>
                <div class="modal-footer">
                    <input type="submit" class="btn btn-primary" value="确定"/>
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
<script src="${basePath}/resources/js/jquery.min.js?v=2.1.4"></script>
<script src="${basePath}/resources/js/bootstrap.min.js?v=3.3.6"></script>
<script src="${basePath}/resources/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="${basePath}/resources/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="${basePath}/resources/js/plugins/layer/layer.min.js"></script>
<script src="${basePath}/resources/js/hplus.min.js?v=4.1.0"></script>
<script type="text/javascript" src="${basePath}/resources/js/contabs.min.js"></script>

</body>
</html>
