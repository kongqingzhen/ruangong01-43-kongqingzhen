<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" type="text/css" href="css/register.css">

</head>
<body>
<div>
    <div class="action_search_box content_box">
        <a class="logo" href="index.html"></a>
    </div>
    <!--与之前不同，加分割线-->
    <hr style="height: 1px; border: none; border-top: 1px solid #DDD; margin: 25px 0 0px;">
</div>

<!-- 中间注册 -->
<div>
    <!-- 注册内容 -->
    <form id="registerForm" action="#" method="post" novalidate="novalidate">
        <div class="register_box">
            <h1 >注册账号，玩转商城所有服务！</h1>
            <div>
                <div>用户名：</div>
                <input type="text" id="username" name="username" maxlength="25" placeholder="3-16个英文字母">
                <div class="error_tip" id="usernameError">请输入用户名</div>
            </div>
            <div>
                <div>密码：</div>
                <input type="password" id="password" name="password" style="ime-mode:disabled;" maxlength="20" autocomplete="off">
                <div class="error_tip" id="userpasswordError">请输入密码</div>
            </div>
            <div>
                <div>确认密码：</div>
                <input type="password" id="rePassword" name="rePassword" style="ime-mode:disabled;" maxlength="20" autocomplete="off">
                <div class="error_tip" id="repasswordError">请再次输入密码</div>
            </div>
            <div>
                <div>手机：</div>
                <input type="text" id="phone" name="phone"  maxlength="11">
                <div class="error_tip" id="phoneError">请输入手机</div>
            </div>
            <div>
                <div>邮箱：</div>
                <input type="text" id="email" name="email">
                <div class="error_tip" id="emailError">请输入邮箱</div>

            </div>


            <input type="button" class="register_btn" value="立即注册">

        </div>
    </form>

</div>
<!-- 版权信息 -->
<div class="copyright_bgcolor">
    <div class="copyright">Copyright © 2018 XXX有限公司 版权所有 保留一切权利 鲁ICP备XXXXXXXX号-X</div>
</div>

</body>
</html>