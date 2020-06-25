<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: solomon
  Date: 2020/6/23
  Time: 8:59
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

<!-- 最上方留白处-->
<div class="white" style="height:28px;">
    <p>Husky</p>
</div>

<div class="action_search_box wrapper_box">
    <div class="inputbox" style="margin-top:10px;">

    </div>
</div>

<!--分割线-->
<hr style="height: 1px; border: none; border-top: 1px solid #DDD; margin: 25px 0 0px;">
<div style="margin-top:16px;">
    <div class="title">
        <div class="dashed">我的账户</div>
    </div>
    <div class="item"><a href="">个人资料</a></div>
    <div class="item"><a href="">修改密码</a></div>
</div>
<div class="shopcar_right_box l">
    <form action="gameupdate.action" method="post">
    <table>

        <s:iterator value="%{games}" var="p">

            <tr>
                <td>游戏名：<input  type="text" name="game.name" /></td>
                <td>下载地址：<input  type="text" name="game.address"/></td>
            </tr>
        </s:iterator>
        <%--        <tr><td colspan="7" align="center"><a href="insert.jsp">添加成员</a></td> </tr>--%>
    </table>
    <input type="submit" value="提交">
    </form>
</div>


</body>
</html>
