<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="layui/css/layui.css">
    <script src="layui/layui.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>

    <script>
        function deleteUser(cid) {
            //用户安全提示
            if(confirm("您确定要删除吗？")){
                location.href="${pageContext.request.contextPath}/delUserServlet?id="+cid;
            }
        }

        window.onload=function () {
        //给删除选中按钮添加单击事件
            document.getElementById("delSelected").onclick=function () {
                //提交下面包含勾选的form表单，(想要提交表单，就要获取其id值)
                document.getElementById("selectedForm").submit();
            }
            //1.获取第一个cb
            document.getElementById("firstCb").onclick=function () {
                //2.获取下边列表中所有的cb
                let cbs = document.getElementsByName("cid");
                //3.遍历
                for (let i = 0; i < cbs.length; i++) {
                    //4.设置这些cbs[i]的checked状态=firstCb.checked
                    cbs[i].checked=this.checked;
                }
            }
            document.getElementById("delSelected").onclick=function () {
                let cbs = document.getElementsByName("cid");
                let flag=true;
                for (let i = 0; i < cbs.length; i++) {
                    //判断是否有选中条目
                    if (cbs[i].checked){ //表示有一个条目被选中了
                        if (confirm("您是否确定删除？")){
                            //表单提交
                            document.getElementById("selectedForm").submit();
                            flag=false;
                            break;
                        }
                    }
                }
                if(flag){
                    alert("没有勾选联系人！");
                }
            }
        }
    </script>
</head>
<body>
<%
    if(request.getAttribute("pb")==null){
%>
<script>
    function alertOne() {
        layer.alert("未查询到该联系人！请重新刷新查询！",{icon: 6})
    }
    window.onload=function () {
        alertOne();
    }
</script>
<%
    }
%>
<div class="container">
    <h3 style="text-align: center">宠物主人信息列表</h3>

    <div style="float: left">
        <form class="form-inline" action="${pageContext.request.contextPath}/findUserByPageServlet" method="post">
            <div class="form-group">
                <label for="exampleInputName1">姓名</label>

                <input type="text" name="name" value="${condition.name[0]}" class="form-control" id="exampleInputName1" placeholder="姓名">
            </div>
            <div class="form-group">
                <label for="exampleInputAddress">ID号</label>
                <input type="text" name="cid" value="${condition.cid[0]}" class="form-control" id="exampleInputAddress" placeholder="ID号">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail2">电话</label>
                <input type="text" name="phone" ${condition.phone[0]}class="form-control" id="exampleInputEmail2" placeholder="电话">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>

    <div style="float: right;margin: 5px;">
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp">添加宠物主人</a>
        <a class="btn btn-primary" href="javascript:void(0);" id="delSelected">删除选中</a>
    </div>

    <form id="selectedForm" action="${pageContext.request.contextPath}/delSelectedServlet" method="post">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th><input type="checkbox" id="firstCb"></th>
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>籍贯</th>
                <th>城市</th>
                <th>电话</th>
                <th>操作</th>
            </tr>
            <%--                  要用el表达式来表示user--%>
<%--  在设置分页后将其升级 <c:forEach items="${users}" var="user" varStatus="s">--%>
<%--                                      var表示一个对象--%>
            <c:forEach items="${pb.list}" var="customer" varStatus="s">
                <tr>
<%--           提交表单只提交了这个input型的，就是是否被勾选。同时需要加个name--%>
                    <td><input type="checkbox" name="cid" value="${customer.cid}"></td>
<%--                    <td>${s.count}</td>--%>
                    <td>${customer.cid}</td>
                    <td>${customer.name}</td>
                    <td>${customer.gender}</td>
                    <td>${customer.age}</td>
                    <td>${customer.address}</td>
                    <td>${customer.city}</td>
                    <td>${customer.phone}</td>
                     <td><button type="button" class="btn btn-primary" onclick="window.location.href = '${pageContext.request.contextPath}/findUserServlet?cid=${customer.cid}'">
                    修改信息</button>&nbsp;
                     <button type="button" class="btn btn-warning" onclick="window.location.href = 'javascript:deleteUser(${customer.cid});'">
                    删除</button></td>
                    </tr>
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
                    <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${pb.currentPage-1}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
<%--                <li><a href="#">1</a></li>--%>
                <c:forEach begin="1" end="${pb.totalPage}" var="i">
<%--                <li><a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${i}&rows=5">${i}</a></li>--%>
<%--                下面操作是为分页选择选中的特效--%>
                    <c:if test="${pb.currentPage == i}">
                        <li class="active">
                            <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${i}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}">${i}</a></li>
                    </c:if>

                    <c:if test="${pb.currentPage != i}">
                        <li><a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${i}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}">${i}</a></li>
                    </c:if>

                </c:forEach>


                    <c:if test="${pb.currentPage ==pb.totalPage}">
                     <li class="disabled">
                    </c:if>

                    <c:if test="${pb.currentPage !=pb.totalPage}">
                     <li>
                     </c:if>
                    <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${pb.currentPage+1}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}" aria-label="Next">
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