<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <script src="layui/layui.js"></script>
</head>
<body>
<%
    if(1==2){

%>
<script>
    function alertOne() {
        layer.alert("这就是嗨的代价",{icon: 6})
    }
    window.onload=function () {
        alertOne();
    }
</script>
<%--<button onclick="alert()">alert函数</button>--%>
<%
    }
%>
<body>
<%--<button onclick="alertOne()">alert函数ss</button>--%>
</body>

</body>
</html>
