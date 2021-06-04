<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
    <head>
<%--    	<base href="<%=basePath%>"/>--%>
        <!-- 指定字符集 -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>修改宠物信息</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="js/jquery-2.1.0.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        
    </head>
    <body>
        <div class="container" style="width: 400px;">
        <h3 style="text-align: center;">修改宠物信息</h3>
        <form action="${pageContext.request.contextPath}/updateAnimalServlet" method="post">

            <!-- 隐藏域 提交cid-->
            <input type="hidden" name="pid" value="${animal.pid}">

          <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name"  value="${animal.name}" readonly="readonly" placeholder="请输入姓名" />
          </div>

            <div class="form-group">
                <label for="kind">种类：</label>
                <input type="text" class="form-control" id="kind"  name="kind" value="${animal.kind}" placeholder="请输入种类" />
            </div>

          <div class="form-group">
            <label for="birth">年龄：</label>
            <input type="text" class="form-control" id="birth"  name="birth" value="${animal.birth}" placeholder="请输入年龄" />
          </div>

            <div class="form-group">
                <label for="owner">主人：</label>
                <input type="text" class="form-control" id="owner"  name="owner" value="${animal.owner}" placeholder="请输入主人" />
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