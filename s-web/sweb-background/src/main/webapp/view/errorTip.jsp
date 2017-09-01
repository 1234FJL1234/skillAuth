<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/common-tags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
    <title>404页面</title>
    <link href="${basePath}/css/404/404CSS.css" rel="stylesheet" type="text/css" />
</head>
<body>
<!-- 代码 开始 -->
<div class="fullScreen" id="fullScreen">
    <%--<a href="#" class="logo"><img src="${basePath}/images/homepage-logo.png"></a>--%>
    <img class="rotating" src="${basePath}/images/404/spaceman.svg" />
    <div class="pagenotfound-text">
        <h1>当前访问页面不存在</h1>
        <h2><a href="#">点击回到主页</a></h2>
    </div>
    <canvas id="canvas2d"></canvas>
</div>
<script type="text/javascript" src="${basePath}/js/404/jq22.js"></script>
<!-- 代码 结束 -->


</body>
</html>
