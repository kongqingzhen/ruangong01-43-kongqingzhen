<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: solomon
  Date: 2020/6/23
  Time: 8:51
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
    <div class="title">
        <div class="dashed">查找游戏</div>
    </div>
</div>
<div style="margin-top:16px;">
    <div class="title">
        <div class="dashed">我的账户</div>
    </div>
    <div class="item"><a href="">修改密码</a></div>
</div>

<div class="shopcar_right_box l">
    <table>
        <tr>
            <td>游戏</td>
            <td>下载地址</td>
            <td colspan="2">数据操作</td>
        </tr>

        <s:iterator value="#session.bookSession" status="st">
            <tr>
                <td><s:property value="Name"/></td>
                <td><s:property value="Address"/></td>
                <td><a href="delectbook.action?bookname=<s:property value="bookname"/>&count=<s:property value="count"/>&model=用户">
                    <input type="button" class="btn btn-danger btn-xs" value="借阅"></a></td>
            </tr>
        </s:iterator>
        <tr><td colspan="7" align="center"><a href="addgame.jsp"><input type="button"  value="添加"></a></td> </tr>
    </table>

</div>
</body>
</html>
