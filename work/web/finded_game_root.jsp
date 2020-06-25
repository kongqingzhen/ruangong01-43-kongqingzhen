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
</body>
</html>
