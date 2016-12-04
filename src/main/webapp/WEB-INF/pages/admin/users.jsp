<%--
  Created by IntelliJ IDEA.
  User: xuxu
  Date: 12/3/16
  Time: 11:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>SpringMVC User Management</title>

    <!-- new Bootstrap core CSS file -->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>


</head>
<body>
<div class="container">
    <h1>SpringMVC Blog-UserManagement </h1>
    <hr/>

    <h3>Users List<a href="/admin/users/add" type="button" class="btn btn-primary btn-sm"> Add</a></h3>

    <!--<c>标签：在jsp中使用了jstl语法，可以方便地进行一些判断if与遍历操作forEach；-->
    <!--User table is empty-->
    <c:if test="${empty userList}">
        <div class="alert alert-warning" role="alert">
            <span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>User table is empty, please<a href="/admin/users/add" type="button" class="btn btn-primary btn-sm">Add</a>
        </div>
    </c:if>

    <!--User table is not empty-->
    <c:if test="${!empty userList}">
        <table class="table table-bordered table-striped">
            <tr>
                <th>ID</th>
                <th>Nickname</th>
                <th>Username</th>
                <th>Password</th>
                <th>Action</th>
            </tr>

            <c:forEach items="${userList}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.nickname}</td>
                    <td>${user.firstName} ${user.lastName}</td>
                    <td>${user.password}</td>
                    <td>
                        <a href="/admin/users/show/${user.id}" type="button" class="btn btn-sm btn-success">Show
                            detail</a>
                        <a href="/admin/users/update/${user.id}" type="button" class="btn btn-sm btn-warning">Edit</a>
                        <a href="/admin/users/delete/${user.id}" type="button" class="btn btn-sm btn-danger">Delete</a>
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
