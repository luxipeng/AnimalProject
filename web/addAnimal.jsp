<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- HTML5文档-->
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>添加宠物</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="layui/css/layui.css">
    <script src="layui/layui.js"></script>
</head>
<body>
<%
    if(request.getAttribute("addError")!=null){
%>
<script>
    function alertOne() {
        layer.alert("系统中不存在该主人，请重新选择主人！",{icon: 6})
    }
    window.onload=function () {
        alertOne();
    }
</script>
<%
    }
%>
<div class="container">
    <center><h3>添加宠物页面</h3></center>
    <form action="${pageContext.request.contextPath}/addAnimalServlet" method="post">

        <div class="form-group">
            <label for="pid">宠物ID：</label>
            <input type="text" class="form-control" id="pid" name="pid" placeholder="请输入宠物ID账号" required="required">
        </div>

        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="请输入宠物姓名" required="required">
        </div>

        <div class="form-group">
            <label for="kind">种类：</label>
            <input type="text" class="form-control" id="kind" name="kind" placeholder="请输入种类" required="required">
        </div>

        <div class="form-group">
            <label for="birth">年龄：</label>
            <input type="text" class="form-control" id="birth" name="birth" placeholder="请输入年龄" required="required">
        </div>

        <div class="form-group">
            <label for="owner">所属主人：</label>
            <input type="text" class="form-control" id="owner" name="owner" placeholder="请输入所属主人" required="required">
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <button type="button" class="btn btn-warning" onclick="window.location.href = '${pageContext.request.contextPath}/findAnimalByPageServlet?currentPage=1&rows=5'">
                返回</button>
        </div>
    </form>
</div>
</body>
</html>