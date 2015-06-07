<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Sign in</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="./css/bootstrap.min.css">

    <!-- 可选的Bootstrap主题文件（一般不用引入） -->
    <link rel="stylesheet" href="./css/bootstrap-theme.min.css">

    <link rel="stylesheet" href="./css/login.css">
</head>
<body>
<div id="top">
    <a style="font-size: 30px;color: #000;font-style: bold;">作业提交系统</a>
</div>
<div id="login">
    <div id="legend" >
        <span class="text">Sign in</span>
    </div>
<form id="form_login" class="form" action="Index" method="post" onsubmit="return saveReport();">
    <fieldset>
        <div class="control-group">

            <!-- Select Basic -->
            <div class="controls">
                <label class="col-sm-2 control-label">身份</label>
                <select class="form-control" name="user_type" style="width: 120px">
                    <option value="3">教师</option>
                    <option value="2">学生</option>
                    <option value="1">管理员</option></select>
            </div>

        </div><div class="control-group">

        <!-- Text input-->
        <div class="controls">
            <label class="col-sm-2 control-label">用户名</label>
            <!--<label for="exampleInputName2">用户名</label>-->
            <input type="text" name = "login_user" placeholder="请输入邮箱/学号" class="form-control"style="width: 220px">
            <p class="help-block"></p>
        </div>
    </div>



        <div class="control-group">

            <!-- Text input-->

            <div class="controls">
                <label class="col-sm-2 control-label">密码</label>
                <input type="password" name="password" placeholder="请输入密码" class="form-control" style="width: 220px">
                <p class="help-block"></p>
            </div>
        </div>

        <div class="control-group">
            <label class="control-label"></label>

            <!-- Button -->
            <div class="controls">
                <input type="submit" class="btn btn-success" value="Sign in">
            </div>
        </div>
    </fieldset>
</form>
</div>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="./javascript/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="./javascript/bootstrap.min.js"></script>
<script src="./javascript/login.js"></script>
</body>
</html>