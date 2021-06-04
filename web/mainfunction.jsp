<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <base href="<%=basePath%>">
    <title>主功能界面</title>
</head>

<frameset rows="59,*" frameborder="no" border="0" framespacing="0" >
    <frame src="top.jsp" name="topframe" scrolling="no"  id="topFrame"  />
    <frameset cols="*" frameborder="no" border="0" framespacing="0">
<%--           <frame src="main/宠物.jsp" name="mainframe" id="mainframe" width="1130" height="800" />--%>
    <frame src="index.jsp" name="mainframe" id="mainframe" width="1130" height="800" />
    </frameset>
    <body>
    <p>浏览器不支持框架</p>
    </body>
</frameset>
</html>