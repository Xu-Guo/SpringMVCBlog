<%--
  Created by IntelliJ IDEA.
  User: xuxu
  Date: 12/3/16
  Time: 4:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>SpringMVC Blog Management</title>

    <!-- new Bootstrap core CSS file -->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">

</head>
<body>
<div class="container">
    <h1>SpringMVC Blog Management</h1>
    <hr/>

    <h3>All Blogs <a href="/admin/blogs/add" type="button" class="btn btn-primary btn-sm">Add</a></h3>

    <!-- 如果用户列表为空 -->
    <c:if test="${empty blogList}">
        <div class="alert alert-warning" role="alert">
            <span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>Blog list is empty, please<a
                href="/admin/blogs/add" type="button" class="btn btn-primary btn-sm">Add</a>
        </div>
    </c:if>

    <!-- 如果用户列表非空 -->
    <c:if test="${!empty blogList}">
        <table class="table table-bordered table-striped">
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Author</th>
                <th>Public Date</th>
                <th>Operation</th>
            </tr>

            <c:forEach items="${blogList}" var="blog">
                <tr>
                    <td>${blog.id}</td>
                    <td>${blog.title}</td>
                    <!--<%--通过blog的userByUserId对象，找到了博文的作者，并且输出了他的昵称以及姓名。--%>-->
                    <td>${blog.userByUserId.nickname}, ${blog.userByUserId.firstName} ${blog.userByUserId.lastName}</td>
                        <%--<td><fmt:formatDate value="${blog.pubDate }" pattern="yyyy-MM-dd"/></td>--%>
                    <td>
                        <a href="/admin/blogs/show/${blog.id}" type="button" class="btn btn-sm btn-success">Show
                            Detail</a>
                        <a href="/admin/blogs/update/${blog.id}" type="button" class="btn btn-sm btn-warning">Edit</a>
                        <a href="/admin/blogs/delete/${blog.id}" type="button" class="btn btn-sm btn-danger">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>

<!-- jQuery lib must be imported before bootstrap.min.js-->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- Bootstrap core -->
<script src="//cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
