<%--
  Created by IntelliJ IDEA.
  User: solomon
  Date: 2020/6/15
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" type="text/css" href="css/login.css">

</head>
<body>

<div>

    <hr style="height: 1px; border: none; border-top: 1px solid #DDD; margin: 25px 0 0px;">
</div>


<form action="login.action" method="post">
    <div class="login_box">
        <div class="login_box_left">
            <h1>一个账号，玩转商城所有服务！</h1>
            <h2>一个平台，购买游戏，管理游戏</h2>

            <!-- 提示信息，默认隐藏 -->
            <div class="login-tip" style="display: none;">*您的账号密码不匹配，请重新输入</div>

            <div class="login_name_box">
                <div class="login_name_icon"></div>
                <input type="text" id="username" name="user.username" class="loginname" maxlength="25" tabindex="1" placeholder="用户名/已验证的手机号码">
            </div>
            <div class="check_code_tip" id="usernameError" style="display: none;"></div>

            <!-- 密码框 -->
            <div class="login_code_box">
                <div class="login_code_icon"></div>
                <input type="password" id="password" name="user.password" class="logincode" maxlength="20" tabindex="2" autocomplete="off" placeholder="密码">
            </div>
            <!-- 提示信息 -->
            <div class="check_code_tip" id="passwordError" style="display: none;"></div>


            <div class="forg_code_box">

                <a href="register.jsp" class="register">免费注册</a>
            </div>
            <input type="submit" class="login_btn" style="width:341px;cursor:pointer;" value="登&nbsp;&nbsp;&nbsp;录">
        </div>

        <div class="login_box_right">
        </div>
    </div>
</form>

<!-- 版权信息 -->
<div class="copyright_bgcolor">
    <div class="copyright">Copyright © 2018 XXX有限公司 版权所有 保留一切权利 鲁ICP备XXXXXXXX号-X</div>
</div>

</body>
</html>
