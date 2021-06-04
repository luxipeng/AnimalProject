<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
    <head>
        <!-- 指定字符集 -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>修改宠物主人</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="js/jquery-2.1.0.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        
    </head>
    <body>
        <div class="container" style="width: 400px;">
        <h3 style="text-align: center;">修改宠物主人</h3>
        <form action="${pageContext.request.contextPath}/updateUserServlet" method="post">

            <!-- 隐藏域 提交cid-->
            <input type="hidden" name="cid" value="${customer.cid}">

          <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name"  value="${customer.name}" readonly="readonly" placeholder="请输入姓名" />
          </div>

          <div class="form-group">
            <label>性别：</label>
              <c:if test="${customer.gender=='男'}">
                  <input type="radio" name="gender" value="男"  checked/>男
                  <input type="radio" name="gender" value="女"  />女
              </c:if>

              <c:if test="${customer.gender=='女'}">
                  <input type="radio" name="gender" value="男"  />男
                  <input type="radio" name="gender" value="女"  checked/>女
              </c:if>
          </div>

          <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age"  name="age" value="${customer.age}" placeholder="请输入年龄" />
          </div>

          <div class="form-group">
            <label for="address">籍贯：</label>
             <select name="address" class="form-control" id="address">
                 <c:if test="${customer.address=='广东'}">
                     <option value="广东" selected>广东</option>
                     <option value="上海">上海</option>
                     <option value="湖南">湖南</option>
                     <option value="内蒙古">内蒙古</option>
                     <option value="河南">河南</option>
                     <option value="北京">北京</option>
                     <option value="武汉">武汉</option>
                 </c:if>
                 <c:if test="${customer.address=='上海'}">
                     <option value="广东">广东</option>
                     <option value="上海"selected>上海</option>
                     <option value="湖南">湖南</option>
                     <option value="内蒙古">内蒙古</option>
                     <option value="河南">河南</option>
                     <option value="北京">北京</option>
                     <option value="武汉">武汉</option>
                 </c:if>
                 <c:if test="${customer.address=='湖南'}">
                     <option value="广东">广东</option>
                     <option value="上海">上海</option>
                     <option value="湖南"selected>湖南</option>
                     <option value="内蒙古">内蒙古</option>
                     <option value="河南">河南</option>
                     <option value="北京">北京</option>
                     <option value="武汉">武汉</option>
                 </c:if>
                 <c:if test="${customer.address=='内蒙古'}">
                 <option value="广东">广东</option>
                 <option value="上海">上海</option>
                 <option value="湖南">湖南</option>
                 <option value="内蒙古"selected>内蒙古</option>
                 <option value="河南">河南</option>
                     <option value="北京">北京</option>
                     <option value="武汉">武汉</option>
             </c:if>
                 <c:if test="${customer.address=='河南'}">
                     <option value="广东">广东</option>
                     <option value="上海">上海</option>
                     <option value="湖南">湖南</option>
                     <option value="内蒙古">内蒙古</option>
                     <option value="河南"selected>河南</option>
                     <option value="北京">北京</option>
                     <option value="武汉">武汉</option>
                 </c:if>
                 <c:if test="${customer.address=='北京'}">
                     <option value="广东">广东</option>
                     <option value="上海">上海</option>
                     <option value="湖南">湖南</option>
                     <option value="内蒙古">内蒙古</option>
                     <option value="河南">河南</option>
                     <option value="北京"selected>北京</option>
                     <option value="武汉">武汉</option>
                 </c:if>
                 <c:if test="${customer.address=='河南'}">
                     <option value="广东">广东</option>
                     <option value="上海">上海</option>
                     <option value="湖南">湖南</option>
                     <option value="内蒙古">内蒙古</option>
                     <option value="河南">河南</option>
                     <option value="北京">北京</option>
                     <option value="武汉"selected>武汉</option>
                 </c:if>
            </select>
          </div>

          <div class="form-group">
            <label for="city">城市：</label>
            <input type="text" class="form-control" name="city" id="city" value="${customer.city}" placeholder="请输入城市"/>
          </div>

          <div class="form-group">
            <label for="phone">手机号码：</label>
            <input type="text" class="form-control" name="phone" id="phone" value="${customer.phone}" placeholder="请输入手机号码"/>
          </div>

             <div class="form-group" style="text-align: center">
                <input class="btn btn-primary" type="submit" value="提交" />
                <input class="btn btn-default" type="reset" value="重置" />
                 <button type="button" class="btn btn-warning" onclick="window.location.href = '${pageContext.request.contextPath}/findUserByPageServlet?currentPage=1&rows=5'">
                     返回</button>
             </div>
        </form>
        </div>
    </body>
</html>