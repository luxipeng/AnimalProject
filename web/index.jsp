<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>功能</title>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
          integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"
            integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"
            integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
<%--    <!-- 1. 导入CSS的全局样式 -->--%>
<%--    <link href="css/bootstrap.min.css" rel="stylesheet">--%>
<%--    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->--%>
<%--    <script src="js/jquery-2.1.0.min.js"></script>--%>
<%--    <!-- 3. 导入bootstrap的js文件 -->--%>
<%--    <script src="js/bootstrap.min.js"></script>--%>
</head>

<body>
<!--容器-->
<div class="container" style="position: relative; width:1510px;height:1120px;float:left;margin: 0; padding: 0; border: none;">
    <img src="image/630.jpg" alt="banner"width="1510"height="600">
    <h3 style="text-align: center;">欢迎来到爱心宠物诊所</h3>
    <h3 style="text-align: center;">这是一所你值得信赖的诊所</h3>
        <h3 style="text-align: center;">爱心宠物诊所，用心诊治，用爱守护</h3>

            <!--横排按钮-->
            <div class="row" style="position:absolute;left:150px;">
                <div class="col-sm-6 col-md-4">
                    <div class="thumbnail">
                        <img src="image/n5.jpg" alt="no" >
                        <div class="caption">
                            <h3>查看医生信息</h3>
                            <p>点击进入查看医生信息板块</p>
                            <p><a href="${pageContext.request.contextPath}/findDoctorByPageServlet?currentPage=1&rows=5" class="btn btn-primary" role="button">进入</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row" style="position:absolute;right:-100px">
                <div class="col-sm-6 col-md-4">
                    <div class="thumbnail">
                        <img src="image/n7.jpg" alt="no" >
                        <div class="caption">
                            <h3>查看宠物信息</h3>
                            <p>点击进入查看宠物信息板块</p>
                            <p><a href="${pageContext.request.contextPath}/findAnimalByPageServlet?currentPage=1&rows=5" class="btn btn-primary" role="button">进入</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row" style="position:absolute;right:-500px">
                <div class="col-sm-6 col-md-4" >
                    <div class="thumbnail" >
                        <img src="image/n3.jpg" alt="no" >
                        <div class="caption">
                            <h3>查看客户信息</h3>
                            <p>点击进入查看客户信息板块</p>
                            <p><a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=1&rows=5" class="btn btn-primary" role="button">进入</a>
                        </div>
                    </div>
                </div>
            </div>
</div>
<!--logo-->
<div id="footer" style="clear:both;text-align:center;">
    版权 @爱心宠物诊所
</div>
</body>
</html>