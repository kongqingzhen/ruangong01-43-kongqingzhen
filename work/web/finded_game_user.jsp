<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: solomon
  Date: 2020/6/24
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="navbar-header" style="margin-left: 40%;margin-right: 1%" >
    <h3>查询结果如下：</h3>
</div>
<%--<form action="findbook.action" method="post">
    <table>
        <tr>
            <td><input name="find"></td>
            <td><input type="submit" value="查找"></td>
        </tr>
    </table>
</form>--%>

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
</body>
</html>
