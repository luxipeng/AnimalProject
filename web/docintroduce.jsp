<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>医生介绍</title>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
          integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"
            integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"
            integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
</head>
<style>
    .bg1{
        background-image: url("image/bg.png");
        background-size: cover;
    }
</style>
<body class="bg1">
<!--信息页-->
<div class="container" style=" position:relative;width:1510px;height:900px;float:left;margin: 0; padding: 0; border: none;">
    <div class="page-header">
        <h1>爱心宠物诊所<small> 诚心服务 诚信救治</small></h1>
    </div>

    <!--医生4-->
    <div class="row" style="position:absolute;left:50px;">
        <div class="col-sm-6 col-md-4">
            <div class="thumbnail">
                <img src="image/b4.png" alt="no" width="1024" height="800">
                <div class="caption">
                    <h3>张志红</h3>
                    <p>心肺科专家</p>
                    <p>中国农业大学临床兽医硕士</p>
                    <p>北京小动物诊疗行业协会副秘书长</p>
                    <p>北京农学院畜牧兽医系外聘讲师</p>
                    <p><a href="outlet.jsp" class="btn btn-default" role="button">获取联系</a></p>
                </div>
            </div>
        </div>
    </div>
    <!--医生5-->
    <div class="row" style="position:absolute;right:-100px;">
        <div class="col-sm-6 col-md-4">
            <div class="thumbnail">
                <img src="image/b5.png" alt="no" width="1024"height="800">
                <div class="caption">
                    <h3>袁占奎</h3>
                    <p>外科专家</p>
                    <p>中国农业大学兽医外科博士</p>
                    <p>中国农业大学动物医学院讲师</p>
                    <p>北京市杰出青年兽医奖获得者</p>
                    <p><a href="outlet.jsp" class="btn btn-default" role="button">获取联系</a></p>
                </div>
            </div>
        </div>
    </div>
    <!--医生6-->
    <div class="row" style="position:absolute;right:-600px;">
        <div class="col-sm-6 col-md-4">
            <div class="thumbnail">
                <img src="image/b6.png" alt="no" width="1024" height="800">
                <div class="caption">
                    <h3>李贞玉</h3>
                    <p>中兽医专家</p>
                    <p>中国农业大学临床兽医硕士</p>
                    <p>中国兽医协会宠物诊疗分会理事</p>
                    <p>北京小动物诊疗行业协会理事</p>
                    <p><a href="outlet.jsp" class="btn btn-default" role="button">获取联系</a></p>
                </div>
            </div>
        </div>
    </div>
</div>
<div id="footer" style="clear:both;text-align:center;">
    @爱心宠物诊所
</div>
</body>
</html>