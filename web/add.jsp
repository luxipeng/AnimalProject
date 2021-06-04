<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- HTML5文档-->
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>添加用户</title>
    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <center><h3>添加宠物主人页面</h3></center>
    <form action="${pageContext.request.contextPath}/addUserServlet" method="post">

        <div class="form-group">
            <label for="cid">ID账号：</label>
            <input type="text" class="form-control" id="cid" name="cid" placeholder="请输入ID账号" required="required">
        </div>

        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="请输入姓名" required="required">
        </div>

        <div class="form-group">
            <label>性别：</label>
            <input type="radio" name="gender" value="男" checked="checked"/>男
            <input type="radio" name="gender" value="女"/>女
        </div>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age" name="age" placeholder="请输入年龄" required="required">
        </div>

        <div class="form-group">
            <label for="address">籍贯：</label>
            <select name="address" class="form-control" id="address">
                <option value="广东">广东</option>
                <option value="上海">上海</option>
                <option value="湖南">湖南</option>
                <option value="内蒙古">内蒙古</option>
                <option value="河南">河南</option>
                <option value="北京">北京</option>
                <option value="武汉">武汉</option>
            </select>
        </div>

        <div class="form-group">
            <label for="city">城市：</label>
            <input type="text" class="form-control" id="city" name="city" placeholder="请输入城市" required="required">
        </div>

        <div class="form-group">
            <label for="phone">手机号：</label>
            <input type="text" class="form-control" name="phone" id="phone" placeholder="请输入手机号" required="required"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <button type="button" class="btn btn-warning" onclick="window.location.href = '${pageContext.request.contextPath}/findUserByPageServlet?currentPage=1&rows=5'">
                返回</button>
        </div>
    </form>
</div>
</body>
</html>