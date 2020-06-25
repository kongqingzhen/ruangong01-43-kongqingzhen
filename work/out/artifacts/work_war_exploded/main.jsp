<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: solomon
  Date: 2020/6/21
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
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
<div class="white" style="height:28px;">
    <p>Husky</p>
</div>

<div class="action_search_box wrapper_box">
    <div class="inputbox" style="margin-top:10px;">
    </div>
</div>

<!--分割线-->
<hr style="height: 1px; border: none; border-top: 1px solid #DDD; margin: 25px 0 0px;">
<div>
</div>
<div style="margin-top:16px;">
    <div class="title">
        <div class="dashed">我的账户</div>
    </div>
    <div class="item"><a href="changePass.jsp">修改密码</a></div>
    <div class="title">
        <div class="dashed">游戏</div>
    </div>
    <div class="item"><a href="findgame.jsp">查找游戏</a></div>
</div>

<div class="shopcar_right_box l">
    <table>
        <tr>
            <td>游戏</td>
            <td>下载地址</td>
        </tr>

        <s:iterator value="#session.gameSession" status="st">
            <tr>
                <td><s:property value="Name"/></td>
                <td><s:property value="Address"/></td>
        </s:iterator>
    </table>
</div>
</body>
</html>
