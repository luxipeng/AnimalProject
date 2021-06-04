<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>失败</title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <script src="layui/layui.js"></script>
</head>
<body>
<%
    if(request.getAttribute("addError")!=null){
%>
<script>
    function alertOne() {
        layer.alert("该主人仍然有正在医治的宠物！",{icon: 4})
    }
    window.onload=function () {
        alertOne();
    }
</script>
<%
    }
//    response.sendRedirect(request.getContextPath()+"/findUserByPageServlet?currentPage=1&rows=5");
response.setHeader("refresh","5;url=" + request.getContextPath()+ "/findUserByPageServlet?currentPage=1&rows=5");
%>
</body>
</html>
