<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>用户信息管理系统</title>
    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">兽医信息列表</h3>

    <div style="float: left">
        <form class="form-inline" action="${pageContext.request.contextPath}/findDoctorByPageServlet" method="post">
            <div class="form-group">
                <label for="exampleInputName1">姓名</label>

                <input type="text" name="name" value="${condition.name[0]}" class="form-control" id="exampleInputName1" placeholder="姓名">
            </div>
            <div class="form-group">
                <label for="exampleInputAddress">专业</label>
                <input type="text" name="subject" value="${condition.subject[0]}" class="form-control" id="exampleInputAddress" placeholder="专业">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>

    <div style="float: right;margin: 5px;">
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/index.jsp">返回</a>
    </div>

    <form id="selectedForm" action="${pageContext.request.contextPath}/delSelectedServlet" method="post">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th>姓名</th>
                <th>专业</th>
            </tr>
            <c:forEach items="${pb.list}" var="doctor" varStatus="s">
                <tr>
<%--           提交表单只提交了这个input型的，就是是否被勾选。同时需要加个name--%>
                    <td>${doctor.name}</td>
                    <td>${doctor.subject}</td>
            </c:forEach>
        </table>
    </form>

    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <c:if test="${pb.currentPage ==1}">
                    <li class="disabled">
                </c:if>

                <c:if test="${pb.currentPage !=1}">
                    <li>
                </c:if>
<%--                                                                                                                    解决在有查询条件时 点击下一页所有数据又显示出来，所以将查询条件时刻带着--%>
                    <a href="${pageContext.request.contextPath}/findDoctorByPageServlet?currentPage=${pb.currentPage-1}&rows=5&name=${condition.name[0]}&subject=${condition.subject[0]}" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <c:forEach begin="1" end="${pb.totalPage}" var="i">
                    <c:if test="${pb.currentPage == i}">
                        <li class="active">
                            <a href="${pageContext.request.contextPath}/findDoctorByPageServlet?currentPage=${i}&rows=5&name=${condition.name[0]}&subject=${condition.subject[0]}">${i}</a></li>
                    </c:if>

                    <c:if test="${pb.currentPage != i}">
                        <li><a href="${pageContext.request.contextPath}/findDoctorByPageServlet?currentPage=${i}&rows=5&name=${condition.name[0]}&subject=${condition.subject[0]}">${i}</a></li>
                    </c:if>

                </c:forEach>
                    <c:if test="${pb.currentPage ==pb.totalPage}">
                     <li class="disabled">
                    </c:if>

                    <c:if test="${pb.currentPage !=pb.totalPage}">
                     <li>
                     </c:if>
                    <a href="${pageContext.request.contextPath}/findDoctorByPageServlet?currentPage=${pb.currentPage+1}&rows=5&name=${condition.name[0]}&subject=${condition.subject[0]}" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                    </li>
                <span style="font-size: 25px;margin-left: 5px">共${pb.totalCount}条记录，共${pb.totalPage}页</span>
            </ul>
        </nav>
    </div>
</div>
</body>
</html>