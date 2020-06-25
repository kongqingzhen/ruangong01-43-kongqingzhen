<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商城首页</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/common-index.css">
    <link rel="stylesheet" type="text/css" href="css/index.css">

</head>
<body>

<!-- 最上方留白处-->
<div class="white" style="height:28px;">
    <p>Husky</p>
</div>

<div class="action_search_box wrapper_box">
    <div class="inputbox" style="margin-top:10px;">
        <div>
            <a class="search_icon " ></a>
            <input type="text" id="keyword" name="keyword" placeholder="请输入您感兴趣的内容">
            <a id="searchBtn" class="searchbtn" href="javascript:search();">搜&nbsp;索</a>
        </div>
    </div>
</div>

<!--分割线-->
<hr style="height: 1px; border: none; border-top: 1px solid #DDD; margin: 25px 0 0px;">
<div style="margin-top:16px;">
    <div class="title">
        <div class="dashed">我的账户</div>
    </div>
    <div class="item"><a href="">修改密码</a></div>
    <div class="title">
        <div class="dashed">游戏</div>
    </div>
    <div class="item"><a href="findgame.jsp">查找游戏</a></div>
</div>
<form action="findgame.action" method="post">
<div class="shopcar_right_box l">
    <table class="table table-hover">

        <tr>
            <td align="center" ><input name="find" type="text" size="50" ></td>
        </tr>
        <tr>
            <td align="center"><input type="submit" class="btn btn-info btn-xs" value="查找"></td>
        </tr>

    </table></div>
</form>


</body>
</html>