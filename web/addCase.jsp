<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- HTML5文档-->
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>添加宠物病例</title>
    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="layui/css/layui.css">
    <script src="layui/layui.js"></script>
    <script src="layui/layui.js"></script>
    <script>
        layui.use('laydate', function(){
            var laydate = layui.laydate;
            //执行一个laydate实例
            laydate.render({
                elem: '#test1' //指定元素
            });
        });
    </script>
</head>
<body>
<div class="container">
    <center><h3>添加宠物病例页面</h3></center>
    <form action="${pageContext.request.contextPath}/addHistoryServlet" method="post">

        <div class="form-group">
            <label for="pid">宠物ID：</label>
            <input type="text" class="form-control" id="pid" name="pid" value="${pid}" readonly="readonly">
        </div>

        <div class="form-group"> <!-- 注意：这一层元素并不是必须的 -->
            <label for="test1">诊断时间：</label>
            <input type="text" class="layui-input" id="test1" name="data" width="500px" placeholder="请选择诊断时间" required="required">
        </div>

        <div class="form-group">
            <label for="describe">诊断病情描述：</label>
            <input type="text" class="form-control" id="describe" name="describe" placeholder="请输入宠物病情相关诊断信息" required="required">
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